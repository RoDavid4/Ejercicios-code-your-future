package com.egg.libreriaapi.modelos;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AutorModificarEstadoDTO {

    private UUID id;
    private String nombre;
}
