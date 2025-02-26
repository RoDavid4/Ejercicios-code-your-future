package com.egg.biblioteca.entities;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "autor")
public class Autor {

  @Column(name = "id_autor")
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(name = "nombre", unique = true, nullable = false)
  private String nombre;

    public Autor() {}

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public String toString() {
    return "Autor{" + "id=" + id + ", nombre='" + nombre + '\'' + '}';
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }
}
