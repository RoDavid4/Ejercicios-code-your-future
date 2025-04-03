package com.egg.libreriaapi.controllers;

import com.egg.libreriaapi.entities.Editorial;
import com.egg.libreriaapi.exceptions.MyException;
import com.egg.libreriaapi.modelos.EditorialCreateDTO;
import com.egg.libreriaapi.services.EditorialService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/editorial")
public class EditorialController {
  // Instancio al servicio, para poder acceder a sus métodos.
  @Autowired private EditorialService editorialService;

  /*
                            Sin usar DTO
  @PostMapping("crear")
  public ResponseEntity<Object> crearEditorial(String nombre) {
    try {
      editorialService.crearEditorial(nombre);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }*/

  @PostMapping("/crear") // con DTO
  public ResponseEntity<Object> crearLibro(@RequestBody EditorialCreateDTO editorialCreateDTO) {
    try {
      editorialService.crearEditorial(editorialCreateDTO);
      return ResponseEntity.status(HttpStatus.CREATED).body(editorialCreateDTO);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @GetMapping("listar")
  public ResponseEntity<List<Editorial>> listarAutores() {
    try {
      List<Editorial> editoriales =
          editorialService
              .listarEditoriales(); // Llama al servicio para obtener la lista de autores
      return new ResponseEntity<>(editoriales, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("listarEstado")
  public ResponseEntity<List<Editorial>> listarEditorialesEstado(@RequestParam Boolean estado) {
    try {
      List<Editorial> editoriales = editorialService.listarActivas(estado); //
      return new ResponseEntity<>(editoriales, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PatchMapping("/modificar")
  public ResponseEntity<Void> modificarEditorial(
      @RequestParam String nombre, @RequestParam UUID id) {
    try {
      editorialService.modificarEditorial(nombre, id);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @DeleteMapping("/eliminar")
  public ResponseEntity<String> eliminarEditorial(@RequestParam UUID id) {
    try {
      editorialService.eliminarEditorial(id); // Llamada al servicio
      return ResponseEntity.ok("La editorial se eliminó correctamente.");
    } catch (MyException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(e.getMessage()); // Notificación de error
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Ocurrió un error inesperado.");
    }
  }

  @PatchMapping("/reactivar")
  public ResponseEntity<String> reactivarEditorial(@RequestParam UUID id) {
    try {
      editorialService.reactivarEditorial(id); // Llamada al servicio
      return ResponseEntity.ok("La editorial se reactivó correctamente.");
    } catch (MyException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(e.getMessage()); // Notificación de error
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Ocurrió un error inesperado.");
    }
  }
}
