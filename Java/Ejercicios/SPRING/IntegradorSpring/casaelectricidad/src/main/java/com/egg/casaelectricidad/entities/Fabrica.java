package com.egg.casaelectricidad.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Data
@Entity
public class Fabrica {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name ="uuid", strategy = "uuid2")
    @Column(name = "id_fabrica")
    private UUID idFabrica;
    @Column(name = "nombre_fabrica",  nullable = false)
    private String nombreFabrica;

}
