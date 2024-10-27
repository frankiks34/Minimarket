/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package minimarket;

import Logica.Controladora;
import vistas.Inicio;



/**
 *
 * @author Frank
 */
public class Minimarket {

    
    public static void main(String[] args) {
      
          Controladora controladora = new Controladora();
          controladora.creartipodatos();
        
        Inicio inicio = new Inicio();

       inicio.setVisible(true);
       inicio.setLocationRelativeTo(null);
    }
    

}
    

