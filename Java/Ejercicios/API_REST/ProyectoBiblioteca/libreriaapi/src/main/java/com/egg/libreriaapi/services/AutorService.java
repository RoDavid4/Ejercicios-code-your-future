package com.egg.libreriaapi.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.egg.libreriaapi.exceptions.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egg.libreriaapi.entities.Autor;
import com.egg.libreriaapi.repositories.AutorRepository;

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

    // Método público para modificar un Autor
    @Transactional
    public void modificarAutor(String nombre, UUID id) throws MyException {
        validarNombre(nombre); // Validación del nombre
        validarId(id); // Validación del ID

        Optional<Autor> respuesta = autorRepository.findById(id);
        if (respuesta.isPresent()) {
            Autor autor = respuesta.get();
            autor.setNombre(nombre);
            autorRepository.save(autor);
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

