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
    
            
   public void actualizarProducto(int idProducto, String nuevoNombre, float nuevoPrecio, int nuevoStock, String nuevaDescripcion, String nuevaCategoria) {
    try {
        // Buscar el producto por ID
        Producto producto = control.getproductos().stream()
                .filter(p -> p.getId() == idProducto)
                .findFirst()
                .orElse(null);

        if (producto != null) {
            // Actualizar los campos del producto
            producto.setNombre(nuevoNombre);
            producto.setPrecio(nuevoPrecio);
            producto.setStock(nuevoStock);
            producto.setDescripcion(nuevaDescripcion);
            
            // Buscar y actualizar la categoría
            Categoria categoria = control.findCategoriaByNombre(nuevaCategoria);
            if (categoria != null) {
                producto.setCategoria(categoria);
            } else {
                System.out.println("La categoría proporcionada no existe.");
            }
            
            // Guardar el producto actualizado en la base de datos
            control.crearProducto(producto);  // Este método puede crear o actualizar el producto dependiendo de la implementación de persistencia
        } else {
            System.out.println("Producto con ID " + idProducto + " no encontrado.");
        }
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al actualizar el producto.");
    }
}
public void crearVenta( List<VentaProducto> productosVendidos) {
    try {
        // Crear una nueva venta
        Venta venta = new Venta(productosVendidos);

        // Guardar la venta en la base de datos
        control.crearVenta(venta);

        // Para cada producto vendido, guardamos la relación entre la venta y los productos
        for (VentaProducto ventaProducto : productosVendidos) {
            control.crearVentaProducto(ventaProducto);
        }

        System.out.println("Venta creada exitosamente con ID: " + venta.getId());
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al crear la venta.");
    }
}
public void actualizarStock(List<VentaProducto> productosVendidos) {
    try {
        for (VentaProducto ventaProducto : productosVendidos) {
            Producto producto = ventaProducto.getProducto();
            int cantidadVendida = ventaProducto.getCantidad();
            
            // Reducir el stock del producto
            if (producto.getStock() >= cantidadVendida) {
                producto.setStock(producto.getStock() - cantidadVendida);
                control.actualizarProducto(producto);  // Usar el método de actualización de producto
            } else {
                System.out.println("No hay suficiente stock para el producto: " + producto.getNombre());
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al actualizar el stock.");
    }
}
public List<Venta> obtenerVentas() {
    try {
        return control.getVentas();  // Retorna todas las ventas realizadas
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al obtener las ventas.");
        return new ArrayList<>();  // Devuelve una lista vacía en caso de error
    }
}
public List<VentaProducto> obtenerDetallesVenta(int idVenta) {
    try {
        // Buscar la venta por ID
        Venta venta = control.getVentas().stream()
                .filter(v -> v.getId() == idVenta)
                .findFirst()
                .orElse(null);

        if (venta != null) {
            return venta.getProductos();  // Devuelve los productos vendidos en esa venta
        } else {
            System.out.println("Venta con ID " + idVenta + " no encontrada.");
            return new ArrayList<>();
        }
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al obtener los detalles de la venta.");
        return new ArrayList<>();
    }
}

}
