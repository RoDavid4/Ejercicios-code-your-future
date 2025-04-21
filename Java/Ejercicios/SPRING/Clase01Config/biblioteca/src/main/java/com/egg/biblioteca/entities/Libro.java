package com.egg.biblioteca.entities;

import java.util.Date;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "libro")
public class Libro {
  @Id
  @Column(name = "isbn")
  private Long isbn;

  @Column(name = "titulo", unique = true, nullable = false)
  private String titulo;

  @Column(name = "ejemplares", nullable = false)
  private Integer ejemplares;

  @Column(name = "alta", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date alta;

  // FK
  @ManyToOne
  @JoinColumn(name = "id_autor")
  private Autor autor;

  @ManyToOne
  @JoinColumn(name = "id_editorial")
  private Editorial editorial;

}

