package Persistencia;



import Logica.Venta;
import Logica.VentaProducto;
import javax.persistence.*;
import java.util.List;

public class VentaJpaController {

    private EntityManagerFactory emf = null;

    public VentaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public VentaJpaController() {
        emf = Persistence.createEntityManagerFactory("MinimarketPU");
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Crear una nueva Venta
    public void create(Venta venta) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(venta);
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

    // Editar una Venta existente
    public void edit(Venta venta) throws Exception {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            venta = em.merge(venta);
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

    // Eliminar una Venta
    public void destroy(Integer id) throws Exception {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Venta venta = em.getReference(Venta.class, id);
            em.remove(venta);
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

    // Encontrar una Venta por ID
    public Venta findVenta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Venta.class, id);
        } finally {
            em.close();
        }
    }

    // Obtener todas las Ventas
    public List<Venta> findVentaEntities() {
        return findVentaEntities(true, -1, -1);
    }

    // Obtener un rango de Ventas
    public List<Venta> findVentaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT v FROM Venta v");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    // Contar el número total de Ventas
    public int getVentaCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT COUNT(v) FROM Venta v");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
