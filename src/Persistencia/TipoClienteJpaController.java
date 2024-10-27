/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Logica.TipoCliente;
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
public class TipoClienteJpaController {
    
      private EntityManagerFactory emf = null;

    public TipoClienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public TipoClienteJpaController() {
        emf = Persistence.createEntityManagerFactory("MinimarketPU");
        
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    
     public void initializeTiposClientes() {
        EntityManager em = getEntityManager();
        try {
            long count = (long) em.createQuery("SELECT COUNT(t) FROM TipoCliente t").getSingleResult();
            if (count == 0) {
             
                create(new TipoCliente("Regular"));
                create(new TipoCliente("VIP"));
      
            }
        } finally {
            em.close();
        }
    }
    
    
    
    // Crear un nuevo tipo de cliente
    public void create(TipoCliente tipoCliente) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(tipoCliente);
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

    // Editar un tipo de cliente existente
    public void edit(TipoCliente tipoCliente) throws Exception {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            tipoCliente = em.merge(tipoCliente);
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

    // Eliminar un tipo de cliente
    public void destroy(Integer id) throws Exception {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            TipoCliente tipoCliente = em.getReference(TipoCliente.class, id);
            em.remove(tipoCliente);
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

    // Encontrar un tipo de cliente por ID
    public TipoCliente findTipoCliente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoCliente.class, id);
        } finally {
            em.close();
        }
    }

    // Obtener todos los tipos de cliente
    public List<TipoCliente> findTipoClienteEntities() {
        return findTipoClienteEntities(true, -1, -1);
    }

    // Obtener un rango de tipos de cliente
    public List<TipoCliente> findTipoClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT t FROM TipoCliente t");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
   
    public TipoCliente findTipoClienteByDescripcion(String descripcion) {
    EntityManager em = getEntityManager();
    try {
        Query query = em.createQuery("SELECT t FROM TipoCliente t WHERE t.descripcion = :descripcion");
        query.setParameter("descripcion", descripcion);
        return (TipoCliente) query.getSingleResult();
    } finally {
        em.close();
    }
}
    
    public void actualizarTipoCliente(TipoCliente tipoCliente) {
    EntityManager em = getEntityManager();
    EntityTransaction tx = em.getTransaction();
    try {
        tx.begin();
        em.merge(tipoCliente);
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
    

    // Contar el número total de tipos de cliente
    public int getTipoClienteCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT COUNT(t) FROM TipoCliente t");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    
    
}
