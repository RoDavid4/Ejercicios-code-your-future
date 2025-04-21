package com.egg.casaelectricidad.controllers;

import com.egg.casaelectricidad.entities.WebUser;
import com.egg.casaelectricidad.exceptions.MyException;
import com.egg.casaelectricidad.services.WebUserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
@RequestMapping("/")
public class PortalController {
    @Autowired
    private WebUserService usuarioService;


    @GetMapping("/")  // Acá es donde realizamos el mapeo
    public String index() {
        return "index.html";   // Acá es que retornamos con el método.
    }

    @GetMapping("/registrar")
    public String registrar() {
        return "registrousuario.html";
    }


    @PostMapping("/registro")
    public String registro(@RequestParam String email, @RequestParam String nombre, @RequestParam String apellido, @RequestParam String password,
                           @RequestParam String password2, RedirectAttributes redirectAttributes) {

        try {
            System.out.println("entre al try de registro");
            usuarioService.registrar(email, nombre, apellido, password, password2);
            redirectAttributes.addFlashAttribute("exito", "El usuario fue registrado correctamente");
        } catch (MyException ex) {
            System.out.println("hubo un error en el registro");
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
            return "redirect:/registrar"; // volvemos a cargar el formulario.
        }
        return "redirect:/"; // Redirigimos al index con el mensaje "flash"

    }

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error, ModelMap modelo ) {
        if (error != null) {
            modelo.put("error", "Usuario o Contraseña inválidos!");        }
        return "login.html";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/inicio")
    public String inicio(HttpSession session) {
        /* WebUser logueado = (WebUser) session.getAttribute("usuariosession");
        if (logueado.getRol().toString().equals("ADMIN")) {
            return "redirect:/admin/dashboard";
        } */
        return "inicio.html";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/perfil")
    public String perfil(HttpSession session, ModelMap modelo) {
        WebUser usuario = (WebUser) session.getAttribute("usuariosession");
        modelo.put("usuario", usuario);
        return "usuario_modificar.html";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @PostMapping("/perfil/{id}")
    public String actualizar(@PathVariable UUID id, @RequestParam String email, @RequestParam String nombre,
                             @RequestParam String apellido, @RequestParam String password,
                             @RequestParam String password2, ModelMap modelo) {
        try {
            usuarioService.actualizar(id, email, nombre, apellido, password, password2);
            modelo.put("exito", "El usuario fue actualizado correctamente");
            return "inicio.html";
        } catch (MyException ex) {

            modelo.put("error", ex.getMessage());
            modelo.put("nombre", nombre);
            modelo.put("email", email);
            return "usuario_modificar.html";
        }
    }

}
