package com.egg.libreriaapi.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.egg.libreriaapi.exceptions.MyException;
import com.egg.libreriaapi.modelos.AutorDTO;
import com.egg.libreriaapi.modelos.AutorModificarEstadoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egg.libreriaapi.entities.Autor;
import com.egg.libreriaapi.repositories.AutorRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.transaction.annotation.Transactional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    // Método público para crear un Autor
    @Transactional
    public void crearAutor(String nombre) throws MyException {

        validarNombre(nombre);

        Autor autor = new Autor();
        autor.setNombre(nombre);
        autor.setAutorActivo(true);

        autorRepository.save(autor);
    }


    // Método público para listar todos los autores
    @Transactional(readOnly = true)
    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Autor getOne(UUID id) throws MyException {
        validarId(id);
        return autorRepository.getReferenceById (id);
    }

    @Transactional(readOnly = true)
    public AutorDTO obtenerAutorDTO(UUID id) {
        Optional<Autor> optionalAutor = autorRepository.findById(id);
        Autor autor = null;
        try {
            // Verificamos si el valor está presente en el Optional
            if (optionalAutor.isPresent()) {
                autor = optionalAutor.get();
            } else {
                throw new EntityNotFoundException("No se encontró el autor con ID: " + id);
            }
        } catch (EntityNotFoundException e) {
            // Manejo de la excepción en caso de que no se encuentre la entidad
            throw e; // Lanzamos la excepción personalizada
        }
       
        // Mapear la entidad a DTO
        return new AutorDTO(autor.getId(), autor.getNombre());
    }

    /*                                          Sin DTO
    // Método público para modificar un Autor
    @Transactional
    public void modificarAutor(String nombre, UUID id) throws MyException {
        validarNombre(nombre); // Validación del nombre
        validarId(id); // Validación del ID

        Optional<Autor> respuesta = autorRepository.findById(id);
           
        if (respuesta.isPresent()) {
            Autor autor = respuesta.get();
            if (autor.getAutorActivo()){ // Solo se modifican autores ACTIVOS
                autor.setNombre(nombre);
            } else {
                throw new MyException("El autor no está activo");
            }
        } else {
            throw new MyException("El autor con el ID especificado no existe.");
        }
    } */

    @Transactional                                                          // Con DTO
    public void modificarAutor(AutorModificarEstadoDTO autorDTO) throws MyException {
        validarNombre(autorDTO.getNombre()); // Validación del nombre
        validarId(autorDTO.getId()); // Validación del ID

        Optional<Autor> respuesta = autorRepository.findById(autorDTO.getId());
           
        if (respuesta.isPresent()) {
            Autor autor = respuesta.get();
            if (autor.getAutorActivo()){ // Solo se modifican autores ACTIVOS
                autor.setNombre(autorDTO.getNombre());
            } else {
                throw new MyException("El autor no está activo");
            }
        } else {
            throw new MyException("El autor con el ID especificado no existe.");
        }
    }

    @Transactional
    public void eliminarAutor(UUID id) throws MyException {
        validarId(id);

        Optional<Autor> respuesta = autorRepository.findById(id);
        if (respuesta.isPresent()) {
            Autor autor = respuesta.get();
            autor.setAutorActivo(false); // seteamos el autor como INACTIVO
        } else {
            throw new MyException("El autor con el ID especificado no existe.");
        }
    }

    // Método privado para validar el nombre
    private void validarNombre(String nombre) throws MyException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new MyException("El nombre no puede ser nulo o vacío.");
        }
    }

    // Método privado para validar el ID
    private void validarId(UUID id) throws MyException {
        if (id == null) {
            throw new MyException("El ID no puede ser nulo.");
        }
    }
}

