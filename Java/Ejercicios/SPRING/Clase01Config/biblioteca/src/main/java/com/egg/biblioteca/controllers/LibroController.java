package com.egg.biblioteca.controllers;

import com.egg.biblioteca.entities.Autor;
import com.egg.biblioteca.entities.Editorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.egg.biblioteca.services.*;
import com.egg.biblioteca.exceptions.MyException;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/libro")
public class LibroController {
    @Autowired
    private LibroService libroService;
    @Autowired
    private AutorService autorService;
    @Autowired
    private EditorialService editorialService;

    @GetMapping("/registrar") // localhost:8080/libro/registrar
    public String registrar(ModelMap model) {
        List<Autor> autores = autorService.listarAutores();
        List<Editorial> editoriales = editorialService.listarEditoriales();
        model.addAttribute("autores", autores);
        model.addAttribute("editoriales", editoriales);
        return "libro_form.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam(required = false) Long isbn, @RequestParam String titulo,
                           @RequestParam(required = false) Integer ejemplares, @RequestParam UUID id_Autor,
                           @RequestParam UUID id_Editorial, ModelMap modelo) {
        try {
            libroService.crearLibro(isbn, titulo, ejemplares, id_Autor, id_Editorial);
            modelo.put("exito", "El libro fue cargado correctamente");
        } catch (MyException ex) {
            modelo.put("error", ex.getMessage());
            return "libro_form.html"; // volvemos a cargar el formulario.
        }
        return "index.html";
    }



}
