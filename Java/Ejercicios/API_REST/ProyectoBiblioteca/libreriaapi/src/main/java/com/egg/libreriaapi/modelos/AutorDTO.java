package com.egg.libreriaapi.modelos;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AutorDTO {

    private UUID id;
    private String nombre;
}
