package com.egg.biblioteca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.egg.biblioteca.services.EditorialService;
import com.egg.biblioteca.exceptions.MyException;
import java.util.logging.Logger;
import java.util.logging.Level;

@Controller
@RequestMapping("/editorial")
public class EditorialController {

    @Autowired
    private EditorialService editorialService;

    @GetMapping("/registrar") // localhost:8080/editorial/registrar
    public String registrar() {
        return "editorial_form.html";
    }
    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, ModelMap model)  {
        try {
            editorialService.crearEditorial(nombre); // llamo a mi servicio para persistir
            model.put("exito", "La editorial fue cargada correctamente");
        } catch (MyException ex) {
            model.put("error", ex.getMessage());
            return "editorial_form.html";
        }
        return "index.html";
    }
}
