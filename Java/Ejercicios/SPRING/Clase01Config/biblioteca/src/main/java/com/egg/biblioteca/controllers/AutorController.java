package com.egg.biblioteca.controllers;

import com.egg.biblioteca.entities.Autor;
import com.egg.biblioteca.services.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.egg.biblioteca.services.AutorService;
import com.egg.biblioteca.exceptions.MyException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.UUID;
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

    @GetMapping("/lista")
    public String listar(ModelMap modelo) {

        List<Autor> autores = autorService.listarAutores();
        modelo.addAttribute("autores", autores);
        return "autor_list.html";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable UUID id, ModelMap modelo) throws MyException {

        try {
            modelo.put("autor", autorService.getOne(id));
        } catch (MyException ex) {
            modelo.put("error", ex.getMessage());
        }

        return "autor_modificar.html";
    }


    @PostMapping("/modificar/{id}")
    public String modificar(@PathVariable UUID id, String nombre, RedirectAttributes redirectAttributes) {
        try {
            autorService.modificarAutor(nombre, id);

            redirectAttributes.addFlashAttribute("exito", "El autor fue modificado correctamente");
            return "redirect:../lista"; // Mensaje disponible tras redirección
        } catch (MyException ex) {
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
            return "redirect:../modificar/" + id; // Redirige al formulario con mensaje de error
        }
    }

}