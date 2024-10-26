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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Frank
 */
@Entity
public class Kardex {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
     @Temporal(TemporalType.DATE)
    private Date fechamovimiento;
    private String tipomovimi;
    private int cantidad;
    
    @ManyToOne
    @JoinColumn(name = "ProductoID")
    private Producto producto;

    public Kardex(int id, Date fechamovimiento, String tipomovimi, int cantidad, Producto producto) {
        this.id = id;
        this.fechamovimiento = fechamovimiento;
        this.tipomovimi = tipomovimi;
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechamovimiento() {
        return fechamovimiento;
    }

    public void setFechamovimiento(Date fechamovimiento) {
        this.fechamovimiento = fechamovimiento;
    }

    public String getTipomovimi() {
        return tipomovimi;
    }

    public void setTipomovimi(String tipomovimi) {
        this.tipomovimi = tipomovimi;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    
    
    
}
