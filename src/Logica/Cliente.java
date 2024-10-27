/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;


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
public class Cliente{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    
    @ManyToOne
    @JoinColumn(name = "Tipo_Cliente_id")
    private TipoCliente tipoCliente;

    
   
    public Cliente() {
    
    }
    
    public Cliente(int id, String nombre, String direccion, String telefono, TipoCliente tipoCliente) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipoCliente = tipoCliente;
    }
    
    


  public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TipoCliente getTipo() {
        return tipoCliente;
    }

    public void setTipo(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    
    
    
    
}
