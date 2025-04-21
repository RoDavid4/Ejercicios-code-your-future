package com.egg.libreriaapi.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "autor")
public class Autor {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_autor")
  private UUID id;

  @Column(name = "nombre", unique = true, nullable = false)
  private String nombre;

  @Column(name = "autor_activo", nullable = false)
  private Boolean autorActivo;

}
