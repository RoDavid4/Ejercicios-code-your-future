package com.egg.biblioteca.controllers;

import com.egg.biblioteca.entities.Autor;
import com.egg.biblioteca.entities.Editorial;
import com.egg.biblioteca.entities.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.egg.biblioteca.services.EditorialService;
import com.egg.biblioteca.exceptions.MyException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/editorial")
public class EditorialController {

    @Autowired
    private EditorialService editorialService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/registrar") // localhost:8080/editorial/registrar
    public String registrar() {
        return "editorial_form.html";
    }

    @PreAuthorize("hasRole('ADMIN')")
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

    @GetMapping("/lista")
    public String listar(ModelMap modelo) {

        List<Editorial> editoriales = editorialService.listarEditoriales();
        modelo.addAttribute("editoriales", editoriales);
        return "editorial_list.html";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable UUID id, ModelMap modelo) throws MyException {

        try {
            modelo.put("editorial", editorialService.getOne(id));
        } catch (MyException ex) {
            modelo.put("error", ex.getMessage());
        }

        return "editorial_modificar.html";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/modificar/{id}")
    public String modificar(@PathVariable UUID id, String nombre, RedirectAttributes redirectAttributes) {
        try {
            editorialService.modificarEditorial(nombre, id);

            redirectAttributes.addFlashAttribute("exito", "La editorial fue modificada correctamente");
            return "redirect:../lista"; // Mensaje disponible tras redirección
        } catch (MyException ex) {
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
            return "redirect:../modificar/" + id; // Redirige al formulario con mensaje de error
        }
    }
}
