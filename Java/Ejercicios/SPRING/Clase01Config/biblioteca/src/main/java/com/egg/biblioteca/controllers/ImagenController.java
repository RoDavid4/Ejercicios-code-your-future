package com.egg.biblioteca.controllers;
import com.egg.biblioteca.entities.Usuario;
import com.egg.biblioteca.exceptions.MyException;
import com.egg.biblioteca.services.ImagenService;
import com.egg.biblioteca.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Controller
@RequestMapping("/imagen")
public class ImagenController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ImagenService imagenServicio;
    // Obtener imagen de perfil de usuario
    @GetMapping("/perfil/{id}")
    public ResponseEntity<byte[]> imagenUsuario(@PathVariable UUID id) throws MyException {//recibe el id del usuario
        Usuario usuario = usuarioService.getOne(id);
        byte[] imagen = usuario.getImagen().getContenido();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(imagen, headers, HttpStatus.OK);
    }
    // Subir imagen de perfil para un usuario
    @PostMapping("/perfil/{id}")
    public ResponseEntity<String> actualizarImagenPerfil(@PathVariable String id,
                                                         @RequestParam("archivo") MultipartFile archivo) {
        try {
    // Llamada al servicio para guardar la imagen
            imagenServicio.actualizar(archivo, id);
            return new ResponseEntity<>("Imagen actualizada exitosamente",
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la imagen",
                    HttpStatus.BAD_REQUEST);
        }
    }
}
