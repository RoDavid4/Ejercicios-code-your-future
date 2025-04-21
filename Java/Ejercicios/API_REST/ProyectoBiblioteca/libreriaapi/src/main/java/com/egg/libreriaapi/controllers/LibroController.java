package com.egg.libreriaapi.controllers;

import com.egg.libreriaapi.exceptions.MyException;
import com.egg.libreriaapi.modelos.LibroCreateDTO;
import com.egg.libreriaapi.modelos.LibroListarDTO;
import com.egg.libreriaapi.modelos.LibroMostrarDTO;
import com.egg.libreriaapi.services.LibroService;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @GetMapping("/listarLibro/{id}")
  public ResponseEntity<LibroMostrarDTO> obtenerLibro(@PathVariable Long id) {
    try {
      LibroMostrarDTO libroDTO = libroService.obtenerLibroDTO(id);
      return ResponseEntity.ok(libroDTO);
      } catch (EntityNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // 404
      } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();  //500
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

  @PatchMapping("/modificar")
  public ResponseEntity<Object> modificarLibro(@RequestBody LibroCreateDTO libro) {
    try {
      libroService.modificarLibro(libro);
      return ResponseEntity.status(HttpStatus.OK).body(libro);
    } catch (MyException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(e.getMessage()); // Notificación de error
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Ocurrió un error inesperado.");
    }
  }

  @DeleteMapping("/eliminar")
  public ResponseEntity<String> eliminarLibro(@RequestParam Long id) {
    try {
      libroService.borrarLibro(id); // Llamada al servicio
      return ResponseEntity.ok("El libro se eliminó correctamente.");
    } catch (MyException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(e.getMessage()); // Notificación de error
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Ocurrió un error inesperado.");
    }
  }

  @PatchMapping("/reactivar")
  public ResponseEntity<String> reactivarLibro(@RequestParam Long id) {
    try {
      libroService.reactivarLibro(id); // Llamada al servicio
      return ResponseEntity.ok("El libro se reactivó correctamente.");
    } catch (MyException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(e.getMessage()); // Notificación de error
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Ocurrió un error inesperado.");
    }
  }
}
