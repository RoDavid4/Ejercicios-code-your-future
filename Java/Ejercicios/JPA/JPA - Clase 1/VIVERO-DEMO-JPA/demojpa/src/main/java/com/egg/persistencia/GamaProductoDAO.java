package com.egg.persistencia;

import com.egg.entidades.GamaProducto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GamaProductoDAO {
  private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
  private final EntityManager em = emf.createEntityManager();

  public void guardarGamaProduto(GamaProducto gamaProducto) throws Exception {

    em.getTransaction().begin();
    em.persist(gamaProducto);
    em.getTransaction().commit();
  }

  public void someDaoMethod() {
    try {
      em.getTransaction().begin();
      // operaciones con EntityManager
      em.getTransaction().commit();
    } catch (RuntimeException e) {
      if (em.getTransaction().isActive()) {
        em.getTransaction().rollback();
      }
      throw e; // Propagar la excepción
    } finally {
      if (em != null && em.isOpen()) {
        em.close(); // Cerrar el EntityManager al final
      }
    }
  }
}
