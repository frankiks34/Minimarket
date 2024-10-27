/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Frank
 */
@Entity
@Table(name = "Tipo_Cliente")
public class TipoCliente {
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
      
    private String descripcion;

     @OneToMany(mappedBy = "tipoCliente")
    private List<Cliente> clientes;
    
       public TipoCliente() {
      
    }

      public TipoCliente(String descripcion) {
        this.descripcion = descripcion;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    
    
    
    
}
