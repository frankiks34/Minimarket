

import Logica.Controladora;
import Logica.Vendedor;
import java.util.List;

public class PruebaUsuarioExistente {
    public static void main(String[] args) {
        // Instancia de la controladora para manejar la lógica
        Controladora controladora = new Controladora();

        // Datos de prueba
        String nombre = "frank";
        String contrasenia = "123";
        String telefono = "987654321";

        // Lógica para verificar si el usuario ya existe
        List<Vendedor> vendedores = controladora.obtenerVendedores();
        boolean usuarioExiste = false;

        for (Vendedor vendedor : vendedores) {
            if (vendedor.getNombre().equals(nombre)) {
                usuarioExiste = true;
                break;
            }
        }

        if (usuarioExiste) {
            System.out.println("El usuario ya existe. Por favor, elija otro nombre.");
        } else {
            controladora.crearvendedor(nombre, contrasenia, telefono);
            System.out.println("Usuario creado exitosamente.");
        }
    }
}
