package Logica;


import Logica.Cliente;
import Logica.Controladora;
import java.util.List;

public class PruebaClienteExistente {
    public static void main(String[] args) {
        // Instancia de la controladora para manejar la lógica
        Controladora controladora = new Controladora();

        // Datos de prueba
        String nombreCliente = "Carlos";
        String direccionCliente = "Av. Siempre Viva 742";
        String telefonoCliente = "987654321";
        String tipoCliente = "Regular"; // O podría ser "VIP"

        // Lógica para verificar si el cliente ya existe
        List<Cliente> clientes = controladora.getclientes(); // Obtener la lista de clientes
        boolean clienteExiste = false;

        // Verificar si el cliente ya existe
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equals(nombreCliente)) {
                clienteExiste = true;
                break;
            }
        }

        if (clienteExiste) {
            System.out.println("El cliente ya existe. Por favor, elija otro nombre.");
        } else {
            // Si el cliente no existe, proceder a agregarlo
            controladora.agregarClienteALista(nombreCliente, direccionCliente, telefonoCliente, tipoCliente);
            System.out.println("Cliente agregado exitosamente.");
        }
    }
}
