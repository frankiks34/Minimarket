/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Persistencia.ControladorPersistencia;
import java.util.ArrayList;
import java.util.List;
import Logica.Vendedor;




/**
 *
 * @author Frank
 */
public class Controladora{
    
     ControladorPersistencia control =new ControladorPersistencia() ;

   
    public void crearvendedor(String nombre ,String contrasenia ,String telefono)
    {
        
        Vendedor a =new Vendedor();
        
        a.setNombre(nombre);
        a.setContrasenia(contrasenia);
        a.setTelefono(telefono);
        
        control.crearVe(a);
       
    }
     
    public boolean comprobar(String usuario, String contrasenia){
    
        boolean ingreso =false;
        List<Vendedor> lista = new ArrayList<Vendedor>();
        
        lista=control.getvendedores();
        
        
        System.out.println("Usuario logueado es : " + usuario + "contrasenia logueada es "+ contrasenia);
    
        for (Vendedor pro : lista) {
                System.out.println("Usuarios logueado son : " + pro.getNombre() + "contrasenias logueadas son "+ pro.getContrasenia());
       }
      
        
        
       for (Vendedor pro : lista) {
           if (pro.getNombre().equals(usuario)) {
               if (pro.getContrasenia().equals(contrasenia)) {
                   ingreso = true;
               }
               else{         
                  ingreso=false ;    
                  
              
               }      
           }
       }
    
       return ingreso;
    }

    public Vendedor obtenerVendedor(String usuario) {
    
        List<Vendedor> lista = new ArrayList<Vendedor>();
       
        lista=control.getvendedores();
        
   
        
        
       for (Vendedor pro : lista) {
           if (pro.getNombre().equals(usuario)) {
              
             return pro;
           }
            
       }
         return null;
    
    }

    public void cambiarcontra(Vendedor nuevacontrasenia) throws Exception {
           
        control.cambiarContr(nuevacontrasenia);
 
    }
     
    
        public List<Vendedor> obtenerVendedores() {
    
         return control.getvendedores();
    
    }
  
}
