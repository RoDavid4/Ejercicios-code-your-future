package com.egg.libreriaapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.egg.libreriaapi.exceptions.MyException;
import com.egg.libreriaapi.modelos.EditorialCreateDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.egg.libreriaapi.entities.Editorial;
import com.egg.libreriaapi.repositories.EditorialRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class EditorialService {
    @Autowired
    private EditorialRepository editorialRepository;

    /* @Transactional // Sin DTO
    public void crearEditorial(String nombre) throws MyException {
        validarEditorial(nombre);

        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);
        editorial.setEditorialActiva(true);

        editorialRepository.save(editorial);
    } */

    @Transactional //con DTO
    public void crearEditorial(EditorialCreateDTO editorialCreateDTO) throws MyException{

        validarEditorial(editorialCreateDTO.getNombre());

        Editorial editorialNueva = new Editorial();
        
        editorialNueva.setNombre(editorialCreateDTO.getNombre());
        editorialNueva.setEditorialActiva(true);
        
        editorialRepository.save(editorialNueva);
    }

    @Transactional(readOnly = true)
    public List<Editorial> listarEditoriales() {

        List<Editorial> editoriales = new ArrayList<>();

        editoriales = editorialRepository.findAll();
        return editoriales;
    }

    

    @Transactional(readOnly = true)
    public List<Editorial> listarActivas(boolean activa) {
        List<Editorial> editoriales = new ArrayList<>();
        editoriales = editorialRepository.editorialActiva(activa);
        return editoriales;
    }

    @Transactional(readOnly = true)
    public Editorial  getOne(UUID id) throws MyException {
        validarEditorial(id);
        return editorialRepository.getReferenceById (id);
    }

    @Transactional
    public void modificarEditorial(String nombre, UUID id) throws MyException {
        validarEditorial(nombre, id);

        Optional<Editorial> respuesta = editorialRepository.findById(id);

        if (respuesta.isPresent()) {
            Editorial editorial = respuesta.get();
            if (editorial.getEditorialActiva()) {
                editorial.setNombre(nombre);
            } else {
                throw new MyException("La editorial no está activa");
            }
        } else {
            throw new MyException("La editorial no existe");
        }
    }

    @Transactional
    public void eliminarEditorial(UUID id) throws MyException {
        validarEditorial(id);

        Optional<Editorial> respuesta = editorialRepository.findById(id);
        if (respuesta.isPresent() && respuesta.get().getEditorialActiva()) {
            Editorial editorial = respuesta.get();
            editorial.setEditorialActiva(false); // seteamos la editorial como INACTIVA
        } else {
            throw new MyException("La editorial no existe o ha sido eliminada");
        }
    }

    @Transactional
    public void reactivarEditorial(UUID id) throws MyException {
        validarEditorial(id);

        Optional<Editorial> respuesta = editorialRepository.findById(id);
        if (respuesta.isPresent() && !respuesta.get().getEditorialActiva()) {
            Editorial editorial = respuesta.get();
            editorial.setEditorialActiva(true); // seteamos la editorial como ACTIVA
        } else {
            throw new MyException("La editorial no se puede reactivar");
        }
    }

    private void validarEditorial(String nombre, UUID id) throws MyException {
        if (id == null || nombre == null || nombre.isEmpty()) {
            throw new MyException("Parametros nombre y/o id no pueden ser nulos o vacíos.");
        }
    }

    private void validarEditorial(String nombre) throws MyException {
        if (nombre == null || nombre.isEmpty()) {
            throw new MyException("El nombre no puede ser nulo o vacío.");
        }
    }

    private void validarEditorial(UUID id) throws MyException {
        if (id == null) {
            throw new MyException("El ID no puede ser nulo.");
        }
    }

}
