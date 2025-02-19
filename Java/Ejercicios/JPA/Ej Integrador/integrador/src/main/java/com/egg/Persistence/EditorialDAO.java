package com.egg.Persistence;

import com.egg.Entity.Editorial;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class EditorialDAO {
    private final EntityManagerFactory emf;
    private final EntityManager em;

    public EditorialDAO() {
        this.emf = Persistence.createEntityManagerFactory("LOCAL_LIBRERIA");
        this.em  = emf.createEntityManager();
    }

    public void guardarEditorial(Editorial editorial) throws Exception {
        em.getTransaction().begin();
        em.persist(editorial);
        em.getTransaction().commit();
    }

    public void actualizarEditorial(Editorial editorial) throws Exception {
        em.getTransaction().begin();
        em.merge(editorial);
        em.getTransaction().commit();
    }

    public void eliminarEditorial(int id) throws Exception{
        Editorial editorial = em.find(Editorial.class, id);
        em.getTransaction().begin();
        em.remove(editorial);
        em.getTransaction().commit();
    }

    public Editorial buscarEditorial(int id) {
        return em.find(Editorial.class, id);
    }

    public List<Editorial> buscarEditorialPorNombre(String nombre) {
        return em.createQuery("SELECT e FROM Editorial e WHERE e.nombre = :nombre", Editorial.class)
        .setParameter("nombre", nombre)
        .getResultList();
    }

    public List<Editorial> obtenerListaEditoriales() {
        return em.createQuery("SELECT e FROM Editorial e").getResultList();
    }
}
