package com.egg.biblioteca.services;

import com.egg.biblioteca.entities.Imagen;
import com.egg.biblioteca.exceptions.MyException;
import com.egg.biblioteca.repositories.ImagenRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;
import java.util.UUID;

@Service
public class ImagenService {
    @Autowired
    ImagenRepository imagenRepository;

    @Transactional
    public Imagen guardar(MultipartFile archivo) throws MyException{
        if (archivo != null) {
            try {

                Imagen imagen = new Imagen();
                imagen.setMime(archivo.getContentType());
                imagen.setNombre(archivo.getName());
                imagen.setContenido(archivo.getBytes());

                return imagenRepository.save(imagen);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return null;
    }

    @Transactional
    public  Imagen actualizar(MultipartFile archivo, String idImagen) throws MyException {
        if (archivo != null) {
            try {

                Imagen imagen = new Imagen();

                if (idImagen != null) {
                    Optional<Imagen> respuesta = imagenRepository.findById(idImagen);

                    if (respuesta.isPresent()) {
                        imagen = respuesta.get();
                    }
                }

                imagen.setMime(archivo.getContentType());
                imagen.setNombre(archivo.getName());
                imagen.setContenido(archivo.getBytes());

                return imagenRepository.save(imagen);

            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
}
