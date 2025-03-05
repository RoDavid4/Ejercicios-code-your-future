package com.egg.biblioteca.controllers;

import com.egg.biblioteca.services.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.egg.biblioteca.services.AutorService;
import com.egg.biblioteca.exceptions.MyException;
import java.util.logging.Logger;
import java.util.logging.Level;


@Controller
@RequestMapping("/autor") // localhost:8080/autor
public class AutorController {
    @Autowired
    private AutorService autorService;
    @Autowired
    private EditorialService editorialService;

    @GetMapping("/registrar") // localhost:8080/autor/registrar
    public String registrar() {
        return "autor_form.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, ModelMap model){
        try {
            autorService.crearAutor(nombre);    // llamo a mi servicio para persistir
            model.put("exito", "El autor fue cargado correctamente");
        } catch (MyException ex) {
            model.put("error", ex.getMessage());
            return "autor_form.html";
        }
        return "index.html";
    }
}