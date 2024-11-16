package minijuego;

import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;

public class Adorno {

    // Lista de nombres de archivos de imagen de los personajes
    private List<String> nombresImagenes = new ArrayList<>();
    private Random rand = new Random();
    private String nombreImagenActual;
    private ImageIcon animal;

    // Variables que delimitan el area del obstaculo
    public Area cuerpo, obstaculo;

    // Coordenadas iniciales donde se ubica el obstaculo
    public static int xInicial = 1300;
    public static int yInicial = 305;

    // Coordenadas para manipular el obstaculo horizontalmente
    public static int xAuxiliar = -4;

    public Adorno() {

        nombresImagenes.add("/adornos/adorno1.png");
        nombresImagenes.add("/adornos/adorno2.png");
        nombresImagenes.add("/adornos/adorno3.png");
        nombresImagenes.add("/adornos/adorno4.png");
        nombresImagenes.add("/adornos/adorno5.png");
        nombresImagenes.add("/adornos/adorno6.png");
        nombresImagenes.add("/adornos/adorno7.png");

        nombreImagenActual = obtenerImagenAleatoria();
        animal = new ImageIcon(getClass().getResource(nombreImagenActual));
    }

    private String obtenerImagenAleatoria() {
        int indiceAleatorio = rand.nextInt(nombresImagenes.size());
        return nombresImagenes.get(indiceAleatorio);
    }

    public void mover() {
        if (xInicial <= -100) {
            xInicial = 1300;
            // Actualizar la imagen actual
            nombreImagenActual = obtenerImagenAleatoria();
            animal = new ImageIcon(getClass().getResource(nombreImagenActual));
        } else {
            // Incrementar la velocidad
            xInicial += xAuxiliar;
            // Cambiar de coordenadsa a aquellas imagenes que no tengan dimensiones correctas
            cambiarCoordenadasYAdornos();
        }
    }

    public void cambiarCoordenadasYAdornos() {
        if (nombreImagenActual.equals("/adornos/adorno4.png")
                || nombreImagenActual.equals("/adornos/adorno5.png")
                || nombreImagenActual.equals("/adornos/adorno6.png")
                || nombreImagenActual.equals("/adornos/adorno7.png")) {
            Adorno.yInicial = 307; // Mas bajo el nuemro, mas sube
        } else {
            Adorno.yInicial = 316; // Mas alto el numero, mas baja
        }
    }

    public void paint(Graphics2D g) {
        g.drawImage(animal.getImage(), xInicial, yInicial, null);
    }

}
