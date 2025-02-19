package com.egg.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "editorial")
public class Editorial {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_editorial")
  private int id;

  @Column(name = "nombre", unique = true, nullable = false)
  private String nombre;

  @Column(name = "alta")
  private boolean alta;

  public Editorial() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public boolean isAlta() {
    return alta;
  }

  public void setAlta(boolean alta) {
    this.alta = alta;
  }

  @Override
  public String toString() {
    return "Editorial [id=" + id + ", nombre=" + nombre + ", alta=" + alta + "]";
  }
}
