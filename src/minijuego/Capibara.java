package minijuego;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import javax.swing.ImageIcon;

public class Capibara {

    private ImageIcon imagenCapibaraSuelo;
    private ImageIcon imagenCapibaraSalto;

    // Objeto de la clase juego
    private Juego jueguito;

    // Variables que nos ayudan a saber si el capibara salta o no
    public static boolean saltando = false;
    public boolean sube = false;
    public boolean baja = false;

    // Variables que delimitan el area del objeto
    private Area dibujo, cuerpoCapibara;

    // Variables de tama�o del personaje
    private int anchoPersonaje = 64;
    private int altoPersonaje = 64;

    // Coordenadas iniciales de personaje
    public static int xInicial = 50;
    public static int yInicial = 310;

    // Coordenadas para manipular personaje
    private int xAuxiliar = 4;
    private int yAuxiliar = 0;

    // Variables para la posici�n inicial
    private static int xInicialDos = 50;
    private static int yInicialDos = 310;

    public Capibara(Juego jueguito) {
        this.jueguito = jueguito;

        // Cargar las im�genes del capibara
        imagenCapibaraSuelo = new ImageIcon(getClass().getResource("/multimedia/capiLado.gif"));
        imagenCapibaraSalto = new ImageIcon(getClass().getResource("/multimedia/capiSalto.gif"));

    }

    public void mover() {

        if (saltando) {
            if (yInicial == 310) { // Si el capibara esta en el suelo
                sube = true;
                yAuxiliar = -2; // Mientras el numero sea mas bajo, mas va subiendo
                baja = false;
            }
            if (yInicial == 170) { // Si el capibara llego al limite del salto 
                baja = true;
                yAuxiliar = 2;  // Mientras el numero sea mas alto mas va bajando
                sube = false;
            }
            if (sube) {
                yInicial += yAuxiliar;
            }
            if (baja) {
                yInicial += yAuxiliar;
                if (yInicial == 310) { // Si el capibara llego al suelo 
                    saltando = false;
                }
            }
        }
    }

    public void moverIzquierda() {
        if (xInicial - xAuxiliar >= 0) {
            xInicial -= xAuxiliar;
        }
    }

    public void moverDerecha() {
        if (xInicial + xAuxiliar + anchoPersonaje <= jueguito.getWidth()) {
            xInicial += xAuxiliar;
        }
    }

    // Pintar al capibara
    public void paint(Graphics2D g) {
        // Dibujar la imagen correspondiente segun si est� saltando o no
        if (saltando) {
            g.drawImage(imagenCapibaraSalto.getImage(), xInicial, yInicial, anchoPersonaje, altoPersonaje, null);
        } else {
            g.drawImage(imagenCapibaraSuelo.getImage(), xInicial, yInicial, anchoPersonaje, altoPersonaje, null);
        }
    }

    // Detectar cuando el capibara esta saltando
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            saltando = true;
        }

    }

    // Que el capibara aparezca en la posicion inicial por defecto
    public void resetearPosicionInicial() {
        xInicial = xInicialDos;
        yInicial = yInicialDos;
    }

    public Area getBounds() {
        // Area del cuerpo del capibara para la colision
        Rectangle formal = new Rectangle(xInicial, yInicial, 64, 64);
        cuerpoCapibara = new Area(formal);

        dibujo = cuerpoCapibara;
        dibujo.add(cuerpoCapibara);

        return dibujo;
    }

}
