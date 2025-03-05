package com.egg.biblioteca.services;

import com.egg.biblioteca.entities.*;
import com.egg.biblioteca.exceptions.MyException;
import com.egg.biblioteca.repositories.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private EditorialRepository editorialRepository;

    @Transactional
    public void crearLibro(
            Long isbn, String titulo, Integer ejemplares, UUID id_autor, UUID id_editorial) throws MyException {

        validarLibro(isbn, titulo, ejemplares, id_autor, id_editorial);
        Optional<Autor> rtaAutor = autorRepository.findById(id_autor);
        Optional<Editorial> rtaEditorial = editorialRepository.findById(id_editorial);

        if (!rtaAutor.isPresent() || !rtaEditorial.isPresent()) {
            throw new MyException("El autor o la editorial no existen");
        } else {
            Autor autor = rtaAutor.get();
            Editorial editorial = rtaEditorial.get();

            Libro libro = new Libro();
            libro.setIsbn(isbn);
            libro.setTitulo(titulo);
            libro.setEjemplares(ejemplares);
            libro.setAlta(new Date());
            libro.setAutor(autor);
            libro.setEditorial(editorial);

            libroRepository.save(libro);
        }
    }

    @Transactional(readOnly = true)
    public List<Libro> listarLibros() {

        List<Libro> libros = new ArrayList<>();

        libros = libroRepository.findAll();
        return libros;
    }

    @Transactional
    public void modificarLibro(
            Long isbn, String titulo, Integer ejemplares, UUID autor, UUID editorial, Long id) throws MyException {
        validarLibro(isbn, titulo, ejemplares, autor, editorial, id);

        Optional<Libro> respuestaL = libroRepository.findById(id);
        Optional<Autor> respuestaA = autorRepository.findById(autor);
        Optional<Editorial> respuestaE = editorialRepository.findById(editorial);

        if (respuestaL.isPresent() && respuestaA.isPresent() && respuestaE.isPresent()) {
            Libro libro = respuestaL.get();

            libro.setIsbn(isbn);
            libro.setTitulo(titulo);
            libro.setEjemplares(ejemplares);
            libro.setAutor(respuestaA.get());
            libro.setEditorial(respuestaE.get());
            libroRepository.save(libro);
        } else {
            throw new MyException("Hay datos faltantes o incorrectos");
        }
    }

    private void validarLibro (
            Long isbn, String titulo, Integer ejemplares, UUID autor, UUID editorial, Long id) throws MyException{
        if (isbn == null
                || titulo == null
                || titulo.isEmpty()
                || ejemplares == null
                || autor == null
                || editorial == null
                || id == null) {
            throw new MyException("Los datos proporcionados son inválidos o están incompletos.");
        }
    }

    private void validarLibro(
            Long isbn, String titulo, Integer ejemplares, UUID autor, UUID editorial) throws MyException{
        if (isbn == null
                || titulo == null
                || titulo.isEmpty()
                || ejemplares == null
                || autor == null
                || editorial == null) {
            throw new MyException(
                    "Los datos proporcionados son inválidos o están incompletos.");
        }
    }
}
