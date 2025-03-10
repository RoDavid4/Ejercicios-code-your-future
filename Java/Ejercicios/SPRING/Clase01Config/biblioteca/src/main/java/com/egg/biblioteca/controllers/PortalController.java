package com.egg.biblioteca.controllers;

import com.egg.biblioteca.exceptions.MyException;
import com.egg.biblioteca.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class PortalController {
    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/")  // Acá es donde realizamos el mapeo
    public String index() {
        return "index.html";   // Acá es que retornamos con el método.
    }

    @GetMapping("/registrar")
    public String registrar() {
        return "registro.html";
    }

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, @RequestParam String email, @RequestParam String password,
                           @RequestParam String password2, RedirectAttributes redirectAttributes) {

        try {
            usuarioService.registrar(nombre, email, password, password2);
            redirectAttributes.addFlashAttribute("exito", "El usuario fue registrado correctamente");
        } catch (MyException ex) {
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
            return "redirect:/registrar"; // volvemos a cargar el formulario.
        }
        return "redirect:/";

    }

}
