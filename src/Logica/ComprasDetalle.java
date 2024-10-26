/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author Frank
 */
public class ComprasDetalle {
 
    private int id;
    
    private int cantidad;
    
    private float preciounitario;
    
    private Producto producto;
    
    
   
    private Compras compras;

    public ComprasDetalle(int id, int cantidad, float preciounitario, Producto producto, Compras compras) {
        this.id = id;
        this.cantidad = cantidad;
        this.preciounitario = preciounitario;
        this.producto = producto;
        this.compras = compras;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(float preciounitario) {
        this.preciounitario = preciounitario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Compras getCompras() {
        return compras;
    }

    public void setCompras(Compras compras) {
        this.compras = compras;
    }
    
    
    
    
}
