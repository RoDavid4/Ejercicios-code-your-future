package com.egg.biblioteca.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "editorial")
public class Editorial {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_editorial")
  private String id;

  @Column(name = "nombre", unique = true, nullable = false)
  private String nombre;

  public Editorial() {}

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public String toString() {
    return "Editorial [id=" + id + ", nombre=" + nombre + "]";
  }

public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}
}