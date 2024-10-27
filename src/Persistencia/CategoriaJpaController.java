/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Logica.Categoria;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Frank
 */
public class CategoriaJpaController{
     private EntityManagerFactory emf = null;

    public CategoriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public CategoriaJpaController() {
        emf = Persistence.createEntityManagerFactory("MinimarketPU");
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Crear una nueva categoría
    public void create(Categoria categoria) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(categoria);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

  
    public void edit(Categoria categoria) throws Exception {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            categoria = em.merge(categoria);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }


    public void destroy(Integer id) throws Exception {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Categoria categoria = em.getReference(Categoria.class, id);
            em.remove(categoria);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public Categoria findCategoria(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Categoria.class, id);
        } finally {
            em.close();
        }
    }


    public List<Categoria> findCategoriaEntities() {
        return findCategoriaEntities(true, -1, -1);
    }

 
    public List<Categoria> findCategoriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT c FROM Categoria c");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

   
    public int getCategoriaCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT COUNT(c) FROM Categoria c");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public Categoria findCategoriaByNombre(String nombre) {
    EntityManager em = getEntityManager();
    try {
        Query query = em.createQuery("SELECT c FROM Categoria c WHERE c.nombre = :nombre");
        query.setParameter("nombre", nombre);
        return (Categoria) query.getSingleResult();
    } finally {
        em.close();
    }
}
    public void actualizarCategoria(Categoria categoria) {
    EntityManager em = getEntityManager();
    EntityTransaction tx = em.getTransaction();
    try {
        tx.begin();
        em.merge(categoria);
        tx.commit();
    } catch (Exception e) {
        if (tx.isActive()) {
            tx.rollback();
        }
        throw e;
    } finally {
        em.close();
    }
}

   
    public void initializeCategorias() {
        EntityManager em = getEntityManager();
        try {
            long count = (long) em.createQuery("SELECT COUNT(c) FROM Categoria c").getSingleResult();
            if (count == 0) {
                create(new Categoria("Electrónica"));
                create(new Categoria("Ropa"));
                create(new Categoria("Alimentos"));
        
            }
        } finally {
            em.close();
        }
    }
}
