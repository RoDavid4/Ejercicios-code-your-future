package com.egg.casaelectricidad.controllers;

import com.egg.casaelectricidad.entities.Fabrica;
import com.egg.casaelectricidad.exceptions.MyException;
import com.egg.casaelectricidad.services.FabricaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/fabrica")
public class FabricaController {
    @Autowired
    private FabricaService fabricaService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/registrar") // localhost:8080/editorial/registrar
    public String registrar( ModelMap modelo) {
        return "fabrica_form.html";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, ModelMap model)  {
        try {
            fabricaService.crearFabrica(nombre); // llamo a mi servicio para persistir
            model.put("exito", "La fabrica fue cargada correctamente");
        } catch (MyException ex) {
            model.put("error", ex.getMessage());
            return "fabrica_form.html";
        }
        return "inicio.html";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/lista")
    public String listar(ModelMap modelo) {

        List<Fabrica> fabricas = fabricaService.listarFabricas();
        modelo.addAttribute("fabricas", fabricas);
        return "listafabrica.html";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") UUID idFabrica, ModelMap modelo) {
        try {
            fabricaService.eliminarFabrica(idFabrica);
            modelo.put("exito", "La fabrica fue eliminada correctamente");
        } catch (MyException ex) {
            modelo.put("error", ex.getMessage());
            return "listafabrica.html";
        }
        return "inicio.html";
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/modificar/{idFabrica}")
    public String modificar(@PathVariable UUID idFabrica, ModelMap modelo) {
        try {
            modelo.put("fabrica", fabricaService.getOne(idFabrica));
        } catch (MyException ex) {
            modelo.put("error", ex.getMessage());
            return "listafabrica.html";
        }
        return "fabrica_modificar.html";
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/modificar/{id}")
    public String modificar(@PathVariable("id") UUID idFabrica, @RequestParam String nombreFabrica, ModelMap modelo) {
        try {
            fabricaService.actualizar(nombreFabrica, idFabrica);
            modelo.put("exito", "La fabrica fue modificada correctamente");
        } catch (MyException ex) {
            modelo.put("error", ex.getMessage());
            return "listafabrica.html";
        }
        return "inicio.html";
    }


}
