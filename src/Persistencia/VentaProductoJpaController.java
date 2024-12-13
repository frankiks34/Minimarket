package Persistencia;



import Logica.VentaProducto;
import Logica.Producto;
import javax.persistence.*;
import java.util.List;

public class VentaProductoJpaController {

    private EntityManagerFactory emf = null;

    public VentaProductoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public VentaProductoJpaController() {
        emf = Persistence.createEntityManagerFactory("MinimarketPU");
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Crear un nuevo VentaProducto
    public void create(VentaProducto ventaProducto) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(ventaProducto);
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

    // Editar un VentaProducto existente
    public void edit(VentaProducto ventaProducto) throws Exception {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            ventaProducto = em.merge(ventaProducto);
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

    // Eliminar un VentaProducto
    public void destroy(Integer id) throws Exception {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            VentaProducto ventaProducto = em.getReference(VentaProducto.class, id);
            em.remove(ventaProducto);
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

    // Encontrar un VentaProducto por ID
    public VentaProducto findVentaProducto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VentaProducto.class, id);
        } finally {
            em.close();
        }
    }

    // Obtener todos los VentaProducto
    public List<VentaProducto> findVentaProductoEntities() {
        return findVentaProductoEntities(true, -1, -1);
    }

    // Obtener un rango de VentaProducto
    public List<VentaProducto> findVentaProductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT v FROM VentaProducto v");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    // Contar el número total de VentaProducto
    public int getVentaProductoCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT COUNT(v) FROM VentaProducto v");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
