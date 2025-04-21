package com.egg.libreriaapi.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LibroMostrarDTO {

    private Long isbn;//Este dato sera utilizado como idLibro
    private String titulo;
    private Integer ejemplares;
    private String autor;
    private String editorial;
    
}
