package com.egg.casaelectricidad.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Data
@Entity
public class Articulo {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name ="uuid", strategy = "uuid2")
    @Column(name = "id_articulo")
    private UUID idArticulo;
    @Column(name = "nro_articulo", unique = true, nullable = false)
    private Integer nroArticulo;
    @Column(name = "nombre_articulo", nullable = false)
    private String nombreArticulo;
    @Column(name = "descripcion_articulo", nullable = false)
    private String descripcionArticulo;
    @ManyToOne
    private Imagen imagen;
    @ManyToOne
    private Fabrica fabrica;

}
