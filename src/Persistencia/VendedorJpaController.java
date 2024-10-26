/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;
import Logica.Vendedor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Frank
 */
    public class VendedorJpaController implements Serializable {
  private EntityManagerFactory emf = null;

    public VendedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public VendedorJpaController() {
        emf = Persistence.createEntityManagerFactory("MinimarketPU");
    }
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Crear un nuevo vendedor
    public void create(Vendedor vendedor) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(vendedor);
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

    // Editar un vendedor existente
    public void edit(Vendedor vendedor) throws Exception {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            vendedor = em.merge(vendedor);
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

    // Eliminar un vendedor
    public void destroy(Integer id) throws Exception {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Vendedor vendedor = em.getReference(Vendedor.class, id);
            em.remove(vendedor);
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

    // Encontrar un vendedor por ID
    public Vendedor findVendedor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vendedor.class, id);
        } finally {
            em.close();
        }
    }

    // Obtener todos los vendedores
    public List<Vendedor> findVendedorEntities() {
        return findVendedorEntities(true, -1, -1);
    }

    // Obtener un rango de vendedores
    public List<Vendedor> findVendedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT v FROM Vendedor v");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    // Contar el número total de vendedores
    public int getVendedorCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT COUNT(v) FROM Vendedor v");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    }
