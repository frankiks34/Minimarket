package Logica;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Esta clase representa un producto dentro de una venta.
 * Se utiliza para asociar un producto a una venta, con la cantidad que se vendió.
 */
@Entity
public class VentaProducto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
      

    
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
    
    private int cantidad;
    
    private double total;  // Total para esa línea de producto (precio * cantidad)

    // Constructor
    public VentaProducto() {
    }

    public VentaProducto(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.total = producto.getPrecio() * cantidad;
    }

    // Métodos getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    @Override
    public String toString() {
        return "VentaProducto [producto=" + producto.getNombre() + ", cantidad=" + cantidad + ", total=" + total + "]";
    }
}
