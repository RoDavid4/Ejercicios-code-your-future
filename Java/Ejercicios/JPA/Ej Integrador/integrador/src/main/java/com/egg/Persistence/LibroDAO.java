package com.egg.Persistence;

import com.egg.Entity.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class LibroDAO {
    private final EntityManagerFactory emf;
    private final EntityManager em;
    
    public LibroDAO() {
        this.emf = Persistence.createEntityManagerFactory("LOCAL_LIBRERIA");
        this.em  = emf.createEntityManager();
    }

    public void guardarLibro(Libro libro) throws Exception{
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
    }

    public void actualizarLibro(Libro libro) throws Exception{
        em.getTransaction().begin();
        em.merge(libro);
        em.getTransaction().commit();
    }

    public void eliminarLibro(int id) throws Exception{
        Libro libro = em.find(Libro.class, id);
        em.getTransaction().begin();
        em.remove(libro);
        em.getTransaction().commit();
    }

    public void darBajaLibro(int id) throws Exception{
        Libro libro = em.find(Libro.class, id);
        libro.setAlta(false);
        actualizarLibro(libro);
    }

    public void darAltaLibro(int id) throws Exception{
        Libro libro = em.find(Libro.class, id);
        libro.setAlta(true);
        actualizarLibro(libro);
    }

    public Libro buscarLibro(int id) {
        return em.find(Libro.class, id);
    }

    public List<Libro> obtenerListaLibros() {
        return em.createQuery("SELECT l FROM Libro l").getResultList();
    }

    public List<Libro> obtenerLibrosPorAutor(String nombre) {
        return em.createQuery("SELECT l FROM Libro l WHERE l.autor.nombre = :nombre").setParameter("nombre", nombre).getResultList();
    }

    public List<Libro> obtenerLibrosPorEditorial(String nombre) {
        return em.createQuery("SELECT l FROM Libro l WHERE l.editorial.nombre = :nombre").setParameter("nombre", nombre).getResultList();
    }

    public List<Libro> obtenerLibrosPorTitulo(String titulo) {
        return em.createQuery("SELECT l FROM Libro l WHERE l.titulo = :titulo").setParameter("titulo", titulo).getResultList();
    }

    public List<Libro> obtenerLibrosPorIsbn(Long isbn) {
        return em.createQuery("SELECT l FROM Libro l WHERE l.isbn = :isbn").setParameter("isbn", isbn).getResultList();
    }
}

