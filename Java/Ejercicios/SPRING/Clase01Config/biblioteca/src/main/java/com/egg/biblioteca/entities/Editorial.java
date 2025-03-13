package com.egg.biblioteca.entities;

import java.util.UUID;
import jakarta.persistence.*;
import lombok.Data;

@Data // Genera automaticamente Getters, Setters y Constructor vacio.
@Entity
@Table(name = "editorial")
public class Editorial {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_editorial")
  private UUID id;

  @Column(name = "nombre", unique = true, nullable = false)
  private String nombre;

 }