package com.egg.libreriaapi.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LibroListarDTO {

    private String titulo;
    private Integer ejemplares;
}
