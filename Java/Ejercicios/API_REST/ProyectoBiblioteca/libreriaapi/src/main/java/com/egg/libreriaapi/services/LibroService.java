package com.egg.libreriaapi.services;

import com.egg.libreriaapi.entities.*;
import com.egg.libreriaapi.exceptions.MyException;
import com.egg.libreriaapi.modelos.LibroCreateDTO;
import com.egg.libreriaapi.modelos.LibroListarDTO;
import com.egg.libreriaapi.modelos.LibroMostrarDTO;
import com.egg.libreriaapi.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LibroService {
  @Autowired private LibroRepository libroRepository;
  @Autowired private AutorRepository autorRepository;
  @Autowired private EditorialRepository editorialRepository;
  @Autowired private AutorService autorService;
  @Autowired private EditorialService editorialService;

  @Transactional
  public void crearLibro(LibroCreateDTO libroCreateDTO) throws MyException {

    validarLibro(
        libroCreateDTO.getIsbn(),
        libroCreateDTO.getTitulo(),
        libroCreateDTO.getEjemplares(),
        libroCreateDTO.getIdAutor(),
        libroCreateDTO.getIdEditorial());
    Libro libroNvo = new Libro();

    libroNvo.setIsbn(libroCreateDTO.getIsbn());
    libroNvo.setTitulo(libroCreateDTO.getTitulo());
    libroNvo.setEjemplares(libroCreateDTO.getEjemplares());
    libroNvo.setLibroActivo(true);

    libroNvo.setAutor(autorService.getOne(libroCreateDTO.getIdAutor()));
    libroNvo.setEditorial(editorialService.getOne(libroCreateDTO.getIdEditorial()));

    libroRepository.save(libroNvo);
  }

  @Transactional(readOnly = true)
  public List<Libro> listarLibros() {

    List<Libro> libros = new ArrayList<>();

    libros = libroRepository.findAll();
    return libros;
  }

  @Transactional(readOnly = true)
  public Libro getOne(Long id) {
    return libroRepository.getReferenceById(id);
  }

  @Transactional(readOnly = true)
  public LibroMostrarDTO obtenerLibroDTO(Long isbn) {
    Optional<Libro> optionalLibro = libroRepository.findById(isbn);
    Libro libro = null;
    try {
      // Verificamos si el valor está presente en el Optional
      if (optionalLibro.isPresent()) {
        libro = optionalLibro.get();
      } else {
        throw new EntityNotFoundException("No se encontró el libro con ISBN: " + isbn);
      }
      // Manejo de la excepción en caso de que no se encuentre la entidad
    } catch (Exception e) {
      throw e;
    }
    // Mapear la entidad a DTO
    return new LibroMostrarDTO(
        isbn,
        libro.getTitulo(),
        libro.getEjemplares(),
        libro.getAutor().getNombre(),
        libro.getEditorial().getNombre());
  }

  @Transactional
  public void modificarLibro(
      LibroCreateDTO libroDTO) throws MyException {
    validarLibro(libroDTO.getIsbn(), libroDTO.getTitulo(), libroDTO.getEjemplares(), libroDTO.getIdAutor(), libroDTO.getIdEditorial());

    Optional<Libro> respuestaL = libroRepository.findById(libroDTO.getIsbn());
    Optional<Autor> respuestaA = autorRepository.findById(libroDTO.getIdAutor());
    Optional<Editorial> respuestaE = editorialRepository.findById(libroDTO.getIdEditorial());
    if (respuestaL.isPresent()) {

      Libro libro = respuestaL.get();
      if (libro.getLibroActivo()) {
        libro.setAutor(respuestaA.get());
        libro.setEditorial(respuestaE.get());
        libro.setEjemplares(libroDTO.getEjemplares());
        libro.setTitulo(libroDTO.getTitulo());
      } else {
        throw new MyException("El libro no está activo");
      }

    } else {
      throw new MyException("El ISBN del libro es incorrecto");
    }
  }

  @Transactional
  public void borrarLibro(Long isbn) throws MyException {
    Optional<Libro> libroOpt = libroRepository.findById(isbn);

    if (libroOpt.isPresent() && libroOpt.get().getLibroActivo()) {
      Libro libro = libroOpt.get();

      libro.setLibroActivo(false);
    } else {
      throw new MyException("El libro con ISBN " + isbn + " no existe o esta inactivo.");
    }
  }

  @Transactional
  public void reactivarLibro(Long isbn) throws MyException {
    Optional<Libro> libroOpt = libroRepository.findById(isbn);

    if (libroOpt.isPresent() && !libroOpt.get().getLibroActivo()) {
      Libro libro = libroOpt.get();
      libro.setLibroActivo(true);
    } else {
      throw new MyException("El libro con ISBN " + isbn + " no puede ser reactivado.");
    }
  }

  @Transactional(readOnly = true)
  public List<LibroListarDTO> listarActivos(boolean activo) {
    List<LibroListarDTO> libros = new ArrayList<>();
    libros = libroRepository.encontrarActivos(activo);
    return libros;
  }

  @Transactional(readOnly = true)
  public List<LibroListarDTO> listarPorAutor(Autor autor) {
    List<LibroListarDTO> libros = new ArrayList<>();
    libros = libroRepository.buscarPorAutor(autor);
    return libros;
  }

  @Transactional(readOnly = true)
  public List<LibroListarDTO> listarPorAutor(UUID autorId) throws MyException {

    validarIdAutor(autorId);
    Autor autor = autorRepository.getReferenceById(autorId);
    validarEstadoAutor(autor);

    List<LibroListarDTO> libros = new ArrayList<>();
    libros = libroRepository.buscarPorAutor(autor);
    return libros;
  }

  @Transactional(readOnly = true)
  public List<LibroListarDTO> listarPorEditorial(UUID editorialId) throws MyException {

    validarIdEditorial(editorialId);
    Editorial editorial = editorialRepository.getReferenceById(editorialId);
    validarEstadoEditorial(editorial);

    List<LibroListarDTO> libros = new ArrayList<>();
    libros = libroRepository.buscarPorEditorial(editorial);
    return libros;
  }

  @Transactional(readOnly = true)
  public List<LibroListarDTO> listarPorAutorEditorial(UUID autorId, UUID editorialId)
      throws MyException {

    validarIdAutor(autorId);
    validarIdEditorial(editorialId);
    Autor autor = autorRepository.getReferenceById(autorId);
    Editorial editorial = editorialRepository.getReferenceById(editorialId);
    validarEstadoAutor(autor);
    validarEstadoEditorial(editorial);

    List<LibroListarDTO> libros = new ArrayList<>();
    libros = libroRepository.buscarPorAutorYEditorial(autor, editorial);
    return libros;
  }

  private void validarLibro(
      Long isbn, String titulo, Integer ejemplares, UUID autor, UUID editorial) throws MyException {
    if (isbn == null
        || titulo == null
        || titulo.isEmpty()
        || ejemplares == null) {
      throw new MyException("Los datos proporcionados son inválidos o están incompletos.");
    } else {
      
      validarIdAutor(autor);
      validarIdEditorial(editorial);
    }
  }

  private void validarIdAutor(UUID autorId) throws MyException {
    if (autorId == null) {
      throw new MyException("El ID del autor no puede ser nulo.");
    }

    // Verificar existencia del autor
    boolean existe = autorRepository.existsById(autorId);
    if (!existe) {
      throw new MyException("El autor con el ID especificado no existe.");
    }
  }

  private void validarIdEditorial(UUID editorialId) throws MyException {
    if (editorialId == null) {
      throw new MyException("El ID de la editorial no puede ser nulo.");
    }

    // Verificar existencia de la editorial
    boolean existe = editorialRepository.existsById(editorialId);
    if (!existe) {
      throw new MyException("La editorial con el ID especificado no existe.");
    }
  }

  private void validarEstadoAutor(Autor autor) throws MyException {

    if (!autor.getAutorActivo()) {
      throw new MyException("El autor no está activo.");
    }
  }

  private void validarEstadoEditorial(Editorial editorial) throws MyException {
    if (!editorial.getEditorialActiva()) {
      throw new MyException("La editorial no esta activa");
    }
  }
}
