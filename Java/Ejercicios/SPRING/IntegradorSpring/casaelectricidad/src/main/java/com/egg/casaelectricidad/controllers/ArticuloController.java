package com.egg.casaelectricidad.controllers;

import com.egg.casaelectricidad.entities.Articulo;
import com.egg.casaelectricidad.entities.Fabrica;
import com.egg.casaelectricidad.exceptions.MyException;
import com.egg.casaelectricidad.services.ArticuloService;
import com.egg.casaelectricidad.services.FabricaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/articulo")
public class ArticuloController {
    @Autowired
    private ArticuloService articuloService;
    @Autowired
    private FabricaService fabricaService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/registrar") // localhost:8080/editorial/registrar
    public String registrar(ModelMap modelo) {
        List<Fabrica> fabricas = fabricaService.listarFabricas();
        modelo.addAttribute("fabricas", fabricas);
        return "articulo_form.html";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/registro")
    public String registro(@RequestParam MultipartFile archivo, @RequestParam String nombreArticulo,
                           @RequestParam String descripcionArticulo, @RequestParam Fabrica fabrica, ModelMap model)  {
        try {
            articuloService.crearArticulo(archivo, nombreArticulo, descripcionArticulo, fabrica); // llamo a mi servicio para persistir
            model.put("exito", "El artículo fue cargado correctamente");
        } catch (MyException ex) {
            model.put("error", ex.getMessage());
            List<Fabrica> fabricas = fabricaService.listarFabricas();
            model.addAttribute("fabricas", fabricas);
            return "articulo_form.html";
        }
        return "inicio.html";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/lista")
    public String listar(ModelMap modelo) {

        List<Articulo> articulos = articuloService.listarArticulos();
        modelo.addAttribute("articulos", articulos);
        return "listaarticulo.html";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") UUID idArticulo, ModelMap modelo) {
        try {
            articuloService.eliminarArticulo(idArticulo);
            modelo.put("exito", "El articulo fue eliminado correctamente");
        } catch (MyException ex) {
            modelo.put("error", ex.getMessage());
            return "listaarticulo.html";
        }
        return "inicio.html";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/modificar/{idArticulo}")
    public String modificar(@PathVariable UUID idArticulo, ModelMap modelo) {
        try {
            modelo.put("articulo", articuloService.getOne(idArticulo));
            List<Fabrica> fabricas = fabricaService.listarFabricas();
            modelo.addAttribute("fabricas", fabricas);
        } catch (MyException ex) {
            modelo.put("error", ex.getMessage());
            return "listaarticulo.html";
        }
        return "articulo_modificar.html";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/modificar/{id}")
    public String modificar(@PathVariable("id") UUID idArticulo, @RequestParam MultipartFile archivo,
                            @RequestParam String nombreArticulo, @RequestParam String descripcionArticulo,
                            @RequestParam Fabrica fabrica, ModelMap modelo) {
        try {
            articuloService.actualizar(idArticulo, archivo, nombreArticulo, descripcionArticulo, fabrica);
            modelo.put("exito", "El articulo fue modificado correctamente");
        } catch (MyException ex) {
            modelo.put("error", ex.getMessage());
            return "listaarticulo.html";
        }
        return "inicio.html";
    }
}
