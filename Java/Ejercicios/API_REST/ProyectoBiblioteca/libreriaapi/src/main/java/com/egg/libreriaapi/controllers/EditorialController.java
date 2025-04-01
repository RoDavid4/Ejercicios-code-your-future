package com.egg.libreriaapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.egg.libreriaapi.entities.Editorial;
import com.egg.libreriaapi.services.EditorialService;


@RestController
@RequestMapping("/editorial")
public class EditorialController {
    //Instancio al servicio, para poder acceder a sus métodos.
    @Autowired
    private EditorialService editorialService;


   
    @PostMapping("crear")
    public ResponseEntity<Object> crearEditorial(String nombre) {
        try {
            editorialService.crearEditorial(nombre);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
