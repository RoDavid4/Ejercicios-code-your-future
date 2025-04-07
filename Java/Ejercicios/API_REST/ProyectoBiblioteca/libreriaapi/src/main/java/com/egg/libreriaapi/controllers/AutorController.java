package com.egg.libreriaapi.controllers;

import com.egg.libreriaapi.entities.Autor;
import com.egg.libreriaapi.modelos.AutorDTO;
import com.egg.libreriaapi.modelos.AutorModificarEstadoDTO;
import com.egg.libreriaapi.services.AutorService;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autor")
public class AutorController {
  // Instancio al servicio, para poder acceder a sus métodos.
  @Autowired private AutorService autorService;

  @PostMapping("crear")
  public ResponseEntity<Object> crearAutor(@RequestParam String nombre) {
    try {
      autorService.crearAutor(nombre);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("listar")
  public ResponseEntity<List<Autor>> listarAutores() {
    try {
      List<Autor> autores =
          autorService.listarAutores(); // Llama al servicio para obtener la lista de autores
      return new ResponseEntity<>(autores, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/listarAutor/{id}")
  public ResponseEntity<AutorDTO> listarAutor(@PathVariable UUID id) {
    try {
      // Llamamos al servicio para obtener el DTO
      AutorDTO autorDTO = autorService.obtenerAutorDTO(id);
      return ResponseEntity.ok(autorDTO);
    } catch (EntityNotFoundException e) {
      // Si no se encuentra la entidad, devolvemos un 404
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body(
              null); // Se puede devolver null, pero también podrías enviar un mensaje de error en
                     // el cuerpo
    } catch (Exception e) {
      // En caso de error general, devolvemos un 500
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @PatchMapping("/modificar")
  public ResponseEntity<Object> modificarAutor(@RequestBody AutorModificarEstadoDTO autorDTO) {
    try {
      autorService.modificarAutor(autorDTO);
      return ResponseEntity.status(HttpStatus.OK).body(autorDTO);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }
}
