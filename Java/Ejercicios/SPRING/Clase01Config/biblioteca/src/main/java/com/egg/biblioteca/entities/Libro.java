package com.egg.biblioteca.entities;

import java.util.Date;

import jakarta.persistence.*;

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
  @Temporal (TemporalType.DATE)
  private Date alta;

  // FK
  @ManyToOne
  @JoinColumn(name = "id_autor")
  private Autor autor;

  @ManyToOne
  @JoinColumn(name = "id_editorial")
  private Editorial editorial;

  public Libro() {}

  public Long getIsbn() {
    return isbn;
  }

  public void setIsbn(Long isbn) {
    this.isbn = isbn;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public int getEjemplares() {
    return ejemplares;
  }

  public void setEjemplares(int ejemplares) {
    this.ejemplares = ejemplares;
  }

  public Autor getAutor() {
    return autor;
  }

  public void setAutor(Autor autor) {
    this.autor = autor;
  }

  public Editorial getEditorial() {
    return editorial;
  }

  public void setEditorial(Editorial editorial) {
    this.editorial = editorial;
  }

  @Override
  public String toString() {
    return "Libro [isbn="
        + isbn
        + ", titulo="
        + titulo
        + ", ejemplares="
        + ejemplares
        + ", alta="
        + alta
        + ", autor="
        + autor
        + ", editorial="
        + editorial
        + "]";
  }

public Date getAlta() {
    return alta;
}

public void setEjemplares(Integer ejemplares) {
    this.ejemplares = ejemplares;
}

public void setAlta(Date alta) {
    this.alta = alta;
}
}