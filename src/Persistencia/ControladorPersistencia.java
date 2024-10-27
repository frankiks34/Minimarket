/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Logica.Vendedor;
import java.util.List;


/**
 *
 * @author Frank
 */
public class ControladorPersistencia {
    
    
    VendedorJpaController vendedor;
    
    
  public ControladorPersistencia() {
    
        vendedor =new VendedorJpaController();
    
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
  
}
