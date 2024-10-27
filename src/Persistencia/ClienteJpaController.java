/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Logica.Cliente;
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
public class ClienteJpaController {
 
    
       private EntityManagerFactory emf = null;

    public ClienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public ClienteJpaController() {
        emf = Persistence.createEntityManagerFactory("MinimarketPU");
    }
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Crear un nuevo cliente
    public void create(Cliente cliente) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(cliente);
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

    // Editar un cliente existente
    public void edit(Cliente cliente) throws Exception {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            cliente = em.merge(cliente);
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

    // Eliminar un cliente
    public void destroy(Integer id) throws Exception {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Cliente cliente = em.getReference(Cliente.class, id);
            em.remove(cliente);
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

    // Encontrar un cliente por ID
    public Cliente findCliente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    // Obtener todos los clientes
    public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
    }

    // Obtener un rango de clientes
    public List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT c FROM Cliente c");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    // Contar el número total de clientes
    public int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT COUNT(c) FROM Cliente c");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

  
    
}
