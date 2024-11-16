
package Capibatchi;

import java.util.HashMap;
import java.util.Map;

public class GestorAlimentos {
    private Map<String, Integer> inventarioAlimentos;

    public GestorAlimentos() {
        inventarioAlimentos = new HashMap<>();
    }

    public void agregarAlimento(Alimento alimento) {
        String nombreAlimento = alimento.getNombre();
        int cantidadActual = inventarioAlimentos.getOrDefault(nombreAlimento, 0);
        inventarioAlimentos.put(nombreAlimento, cantidadActual + 1);
    }

    public void mostrarInventario() {
        for (Map.Entry<String, Integer> entry : inventarioAlimentos.entrySet()) {
            String nombreAlimento = entry.getKey();
            int cantidad = entry.getValue();
            System.out.println(nombreAlimento + ": " + cantidad);
        }
    }

    public Alimento obtenerAlimento(String nombre) {
        // Implementa la lógica para obtener un alimento específico si es necesario.
        // Puedes buscar en una lista de alimentos disponibles o en una base de datos, por ejemplo.
        // Luego, reduce la cantidad en el inventario.
        return null; // Cambia esto según tu implementación real.
    }

    // Otros métodos relacionados con la gestión de alimentos.
}