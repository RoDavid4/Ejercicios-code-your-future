package com.egg.libreriaapi.controllers;

import com.egg.libreriaapi.modelos.LibroCreateDTO;
import com.egg.libreriaapi.modelos.LibroListarDTO;
import com.egg.libreriaapi.services.LibroService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/libro")
public class LibroController {
  // Instancio al servicio, para poder acceder a sus métodos.
  @Autowired private LibroService libroService;

  @PostMapping("/crear")
  public ResponseEntity<Object> crearLibro(@RequestBody LibroCreateDTO libroDTO) {
    try {
      libroService.crearLibro(libroDTO);
      return ResponseEntity.status(HttpStatus.CREATED).body(libroDTO);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
  }

  @GetMapping("/listarActivos")
  public ResponseEntity<List<LibroListarDTO>> listarLibrosActivos(@RequestParam Boolean activo) {

    try {
      List<LibroListarDTO> libros = libroService.listarActivos(activo);
      return ResponseEntity.ok(libros);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
  }

  @GetMapping("/listarAutor")
  public ResponseEntity<List<LibroListarDTO>> listarLibrosAutor(@RequestParam UUID autor) {
    try {
      List<LibroListarDTO> libros = libroService.listarPorAutor(autor);
      return ResponseEntity.ok(libros);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
  }

  @GetMapping("/listarEditorial")
  public ResponseEntity<List<LibroListarDTO>> listarLibrosEditorial(@RequestParam UUID editorial) {
    try {
      List<LibroListarDTO> libros = libroService.listarPorEditorial(editorial);
      return ResponseEntity.ok(libros);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
  }

  @GetMapping("/listarAutorEditorial")
  public ResponseEntity<List<LibroListarDTO>> listarLibrosAutorEditorial(@RequestParam UUID autor, 
    @RequestParam UUID editorial) {
    try {
      List<LibroListarDTO> libros = libroService.listarPorAutorEditorial(autor, editorial);
      return ResponseEntity.ok(libros);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
  }
}
