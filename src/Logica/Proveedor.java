/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Frank
 */

@Entity
@Table(name = "proveedor")
public class Proveedor {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String contacto;
    
    
    private TipoProveedor tipo;

    public Proveedor(int id, String nombre, String contacto, TipoProveedor tipo) {
        this.id = id;
        this.nombre = nombre;
        this.contacto = contacto;
        this.tipo = tipo;
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

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public TipoProveedor getTipo() {
        return tipo;
    }

    public void setTipo(TipoProveedor tipo) {
        this.tipo = tipo;
    }
    
    
    
    
    
}
