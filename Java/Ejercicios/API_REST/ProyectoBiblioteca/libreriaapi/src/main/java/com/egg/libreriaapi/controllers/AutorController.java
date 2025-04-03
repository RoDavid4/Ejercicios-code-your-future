package com.egg.libreriaapi.controllers;

import com.egg.libreriaapi.entities.Autor;
import com.egg.libreriaapi.modelos.AutorModificarEstadoDTO;
import com.egg.libreriaapi.services.AutorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autor")
public class AutorController {
  // Instancio al servicio, para poder acceder a sus métodos.
  @Autowired private AutorService autorServicio;

  @PostMapping("crear")
  public ResponseEntity<Object> crearAutor(@RequestParam String nombre) {
    try {
      autorServicio.crearAutor(nombre);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("listar")
  public ResponseEntity<List<Autor>> listarAutores() {
    try {
      List<Autor> autores =
          autorServicio.listarAutores(); // Llama al servicio para obtener la lista de autores
      return new ResponseEntity<>(autores, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PatchMapping("/modificar")
  public ResponseEntity<Object> modificarAutor(@RequestBody AutorModificarEstadoDTO autorDTO) {
    try {
      autorServicio.modificarAutor(autorDTO);
      return ResponseEntity.status(HttpStatus.OK).body(autorDTO);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }
}
