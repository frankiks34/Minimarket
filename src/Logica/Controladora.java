/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Persistencia.ControladorPersistencia;
import java.util.ArrayList;
import java.util.List;
import Logica.Vendedor;
import Logica.Cliente;



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
 
   
        public void creartipodatos()
        {
          control.crearTipo();
        }

    public void agregarClienteALista(String nombre, String direccion, String telefono, String a) {
       
          TipoCliente tipoCliente = control.findTipoClienteByDescripcion(a);

    if (tipoCliente != null) {
       
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setNombre(nombre);
        nuevoCliente.setDireccion(direccion);
        nuevoCliente.setTelefono(telefono);
        nuevoCliente.setTipo(tipoCliente);

  
        control.crearCliente(nuevoCliente);
        

       
        tipoCliente.getClientes().add(nuevoCliente);

      
      control.actualizarTipoCliente(tipoCliente);
        
    } else {
        System.out.println("No se encontró el tipo de cliente: " + a);
    }
    
    }

    public List<Cliente> getclientes() {
       return control.getclientes();  
    }
        
    
     public void crearcategorias()
        {
        control.crearcategoria();
        }
    
       public void agregarProductoALista( String nombre, float precio, int stock,String descripcion, String categorias) {
       
          Categoria categoria = control.findCategoriaByNombre(categorias);

    if (categoria != null) {
       
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setStock(stock);
        producto.setDescripcion(descripcion);
        producto.setCategoria(categoria);
        control.crearProducto(producto);
  
      
       categoria.getProductos().add(producto);

      
      control.actualizarCategoria(categoria);
        
    } else {
        System.out.println("No se encontró el tipo de categoria: " + categorias);
    }
    
      
    
    }

     public List<Producto> getproductos(){
       return control.getproductos();
    }
    
      
}
