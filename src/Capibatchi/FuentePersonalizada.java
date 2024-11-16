
package Capibatchi;

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class FuentePersonalizada {
        
    public static Font cargarFuentePersonalizada(String rutaFuente, float tamaño) {
        Font fuentePersonalizada = null;
        try {
            File archivoFuente = new File(rutaFuente);
            if (archivoFuente.exists()) {
                InputStream is = new FileInputStream(archivoFuente);
                fuentePersonalizada = Font.createFont(Font.TRUETYPE_FONT, is);
                fuentePersonalizada = fuentePersonalizada.deriveFont(tamaño);
            } else {
                System.err.println("Error: Archivo de fuente no encontrado en la ruta especificada.");
            }
        } catch (Exception e) {
            System.err.println("Error al cargar la fuente personalizada: " + e.getMessage());
        }
        return fuentePersonalizada;
    }
}
