/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Frank
 */

@Entity
public class Vendedor implements Serializable {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
       
    private String nombre;
    private String telefono;
    private String contrasenia;

      public Vendedor(int id, String nombre, String telefono, String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
    }
   
      public Vendedor()
      {
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

  
    
    
    
}
