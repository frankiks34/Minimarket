package Logica;



import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Esta clase representa una venta en el sistema.
 * Contiene una lista de `VentaProducto`, que representa todos los productos vendidos.
 */
@Entity
public class Venta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
   
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "venta_id")
    private List<VentaProducto> productos;  // Lista de productos vendidos en esta venta
    
    private double total;  // Total de la venta (suma de los totales de los productos)
    
    public Venta() {
  
    }
    
    // Constructor
    public Venta(List<VentaProducto> productos) {
        this.productos = productos;
        
        this.total = calcularTotal();
    }

    // Método para agregar productos a la venta
    public void agregarProducto(VentaProducto ventaProducto) {
        productos.add(ventaProducto);
        total += ventaProducto.getTotal();
    }

    // Método para calcular el total de la venta
    private double calcularTotal() {
        double total = 0;
        for (VentaProducto ventaProducto : productos) {
            total += ventaProducto.getTotal();
        }
        return total;
    }

    // Métodos getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  

    public List<VentaProducto> getProductos() {
        return productos;
    }
  
    public void setProductos(List<VentaProducto> productos) {
        this.productos = productos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Venta [id=" + id  + ", total=" + total + "]";
    }
}
