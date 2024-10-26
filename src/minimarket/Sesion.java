/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minimarket;

import Logica.Vendedor;

/**
 *
 * @author Frank
 */
public class Sesion {
    
      private static Vendedor usuarioActual;


    public static void iniciarSesion(Vendedor usuario) {
        usuarioActual = usuario;
    }


    public static Vendedor getUsuarioActual() {
        return usuarioActual;
    }


    public static void cerrarSesion() {
        usuarioActual = null;
    }
    
    
}
