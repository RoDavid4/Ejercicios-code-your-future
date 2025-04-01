package com.egg.libreriaapi.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.egg.libreriaapi.entities.Libro;
import com.egg.libreriaapi.services.LibroService;


@RestController
@RequestMapping("/libro")
public class LibroController {
    //Instancio al servicio, para poder acceder a sus métodos.
    @Autowired
    private LibroService libroService;


   
    @PostMapping("crear")
    public ResponseEntity<Object> crearLibro(Long isbn, String titulo, Integer ejemplares, UUID id_autor, UUID id_editorial) {
        try {
            libroService.crearLibro(isbn, titulo, ejemplares, id_autor, id_editorial);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
