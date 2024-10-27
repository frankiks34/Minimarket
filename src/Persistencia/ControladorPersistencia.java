/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Logica.Cliente;
import static Logica.Cliente_.tipoCliente;
import Logica.TipoCliente;
import Logica.Vendedor;
import java.util.List;


/**
 *
 * @author Frank
 */
public class ControladorPersistencia {
    
    
    VendedorJpaController vendedor;
    TipoClienteJpaController tipo;
    ClienteJpaController clien;
    

    public ControladorPersistencia() {
    
        vendedor =new VendedorJpaController();
      tipo = new TipoClienteJpaController();
      clien = new ClienteJpaController();
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
   
}
