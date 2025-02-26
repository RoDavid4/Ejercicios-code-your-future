package com.egg.Persistence;

import com.egg.Entity.Autor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class AutorDAO {
    private final EntityManagerFactory emf;
    private final EntityManager em;

    public AutorDAO() {
        this.emf = Persistence.createEntityManagerFactory("LOCAL_LIBRERIA");
        this.em  = emf.createEntityManager();
    }

    public void guardarAutor(Autor autor) throws Exception{
        em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
    }

    public void actualizarAutor(Autor autor) throws Exception{
        em.getTransaction().begin();
        em.merge(autor);
        em.getTransaction().commit();
    }

    public void eliminarAutor(int id) throws Exception{
        Autor autor = em.find(Autor.class, id);
        em.getTransaction().begin();
        em.remove(autor);
        em.getTransaction().commit();
    }

    public Autor buscarAutor(int id) {
        return em.find(Autor.class, id);
    }

    public List<Autor> obtenerListaAutores() {
        return em.createQuery("SELECT a FROM Autor a").getResultList();
    }
}
