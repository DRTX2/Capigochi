package minijuego;

import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class Fondo {

    // Variables del tama�o de fondo
    private int anchoFondo = 1300;
    private int altoFondo = 400;

    // Coordenadas iniciales para mover el fondo
    private int x1 = 1300;
    private int y1 = 0;

    // Coordenadas auxiliares que mueven otro fondo
    private int x2 = 0;
    private int y2 = 0;

    public Fondo() {
    }

    // Controla el desplazamiento del fondo al decrementar las coordenadas x1 y x2
    public void mover() {
        x1 -= 2;
        x2 -= 2;
        if (x1 == 0 && x2 == -1300) {
            x1 = 1300;
            x2 = 0;
        }
    }

    // Dibuja el fondo en la pantalla, para ello se cargan las imagenes    
    public void paint(Graphics2D g) {
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/multimedia/fondoSinCharco.jpg"));
        g.drawImage(imagenFondo.getImage(), x1, y1, anchoFondo, altoFondo, null);
        g.drawImage(imagenFondo.getImage(), x2, y2, anchoFondo, altoFondo, null);
    }

}
