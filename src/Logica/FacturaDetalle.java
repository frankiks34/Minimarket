/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author Frank
 */
public class FacturaDetalle {
    
    private int id;
    private int cantidad;
    private float total;
    private Cliente cliente;
    private Vendedor vendedor;

    public FacturaDetalle(int id, int cantidad, float total, Cliente cliente, Vendedor vendedor) {
        this.id = id;
        this.cantidad = cantidad;
        this.total = total;
        this.cliente = cliente;
        this.vendedor = vendedor;
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

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    
    
            
            
            
            
            
            
            
            
            
            
    
    
    
}
