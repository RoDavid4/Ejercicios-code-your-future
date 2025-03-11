package com.egg.biblioteca.controllers;

import com.egg.biblioteca.entities.Autor;
import com.egg.biblioteca.entities.Editorial;
import com.egg.biblioteca.entities.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.egg.biblioteca.services.*;
import com.egg.biblioteca.exceptions.MyException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PreAuthorize("hasRole('ADMIN')")
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

    @GetMapping("/lista")
    public String listar(ModelMap modelo) {

        List<Libro> libros = libroService.listarLibros();
        modelo.addAttribute("libros", libros);
        return "libro_list.html";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable long id, ModelMap modelo) {

            modelo.put("libro", libroService.getOne(id));
            modelo.put("autores", autorService.listarAutores());
            modelo.put("editoriales", editorialService.listarEditoriales());

        return "libro_modificar.html";
    }


    @PostMapping("/modificar/{id}")
    public String modificar(@PathVariable @RequestParam(required = false) Long isbn, @RequestParam String titulo,
                            @RequestParam(required = false) Integer ejemplares, @RequestParam UUID id_Autor,
                            @RequestParam UUID id_Editorial, @RequestParam(required = false) Long nuevoIsbn, RedirectAttributes redirectAttributes) {
        try {
            System.out.println(nuevoIsbn);
            libroService.modificarLibro(isbn, titulo, ejemplares, id_Autor, id_Editorial, nuevoIsbn);

            redirectAttributes.addFlashAttribute("exito", "El Libro fue modificado correctamente");
            return "redirect:../lista"; // Mensaje disponible tras redirección
        } catch (MyException ex) {
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
            return "redirect:../modificar/" + isbn; // Redirige al formulario con mensaje de error
        }
    }
}
