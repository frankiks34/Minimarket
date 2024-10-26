/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Frank
 */
@Entity
public class Compras {
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 
 
    private Date fecha;
    
    private float total;
    
    @ManyToOne
    @JoinColumn(name = "proveedor", referencedColumnName = "id")
    private Proveedor proveedor;
    
    @ManyToOne
    @JoinColumn(name = "tipo_compra", referencedColumnName = "id")
    private TipoCompra tipoCompra;

    public Compras(int id, Date fecha, float total, Proveedor proveedor) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.proveedor = proveedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    
    
}
