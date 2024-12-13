/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Logica.Categoria;
import Logica.Cliente;
import static Logica.Cliente_.tipoCliente;
import Logica.Producto;
import Logica.TipoCliente;
import Logica.Vendedor;
import Logica.Venta;
import Logica.VentaProducto;
import java.util.List;


/**
 *
 * @author Frank
 */
public class ControladorPersistencia {
    
    ProductoJpaController producto;
    VendedorJpaController vendedor;
    TipoClienteJpaController tipo;
    ClienteJpaController clien;
    CategoriaJpaController catego;
    VentaJpaController venta;
    VentaProductoJpaController ventaProducto;

    public ControladorPersistencia() {
    
        vendedor =new VendedorJpaController();
      tipo = new TipoClienteJpaController();
      clien = new ClienteJpaController();
      producto= new  ProductoJpaController();
      catego = new CategoriaJpaController();
      venta = new VentaJpaController();
              ventaProducto= new VentaProductoJpaController();
    }
    
  public void crearVe(Vendedor a){
  
  vendedor.create(a);
      
  }
  
  public List<Vendedor> getvendedores()
  {
      
      return vendedor.findVendedorEntities();
  
  }
          
  public void cambiarContr(Vendedor a) throws Exception  
  {
  vendedor.edit(a);
  }
  
  public void crearTipo()
  {
  tipo.initializeTiposClientes();
  }
  
  
   public void crearCliente(Cliente a){
  
  clien.create(a);
     
  }
   
   public void crearcategoria()
   {
   catego.initializeCategorias();
   }
   
 
   public TipoCliente findTipoClienteByDescripcion(String descripcion)
   {
       
   return tipo.findTipoClienteByDescripcion(descripcion);
   }

   public void actualizarTipoCliente(TipoCliente tipoCliente)
   {
   tipo.actualizarTipoCliente(tipoCliente);
   }

    public List<Cliente> getclientes() {
    return clien.findClienteEntities();
    }
 
    public void crearProducto(Producto a){
  
  producto.create(a);
     
  }
    
  public Categoria findCategoriaByNombre(String nombre) {
  
  return catego.findCategoriaByNombre(nombre);
  }
   
   public void actualizarCategoria(Categoria categoria) {
   catego.actualizarCategoria(categoria);
   }
    public List<Producto> getproductos() {
    return producto.findProductoEntities();
        
    }
    
    
    public void crearVenta(Venta ventaEntity) {
        venta.create(ventaEntity);
    }

    public void crearVentaProducto(VentaProducto ventaProductoEntity) {
        ventaProducto.create(ventaProductoEntity);
    }

    public List<Venta> getVentas() {
        return venta.findVentaEntities();
    }

    public List<VentaProducto> getVentaProductos() {
        return ventaProducto.findVentaProductoEntities();
    }
    public void actualizarProducto(Producto productos) {
    try {
       
       producto.edit(productos);   // Editar el producto en la base de datos
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al actualizar el producto.");
    }
}
}
