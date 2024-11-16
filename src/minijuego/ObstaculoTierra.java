package minijuego;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

public class ObstaculoTierra {

    // Lista de nombres de archivos de imagen de los personajes
    private List<String> nombresImagenes = new ArrayList<>();
    private Random rand = new Random();
    private String nombreImagenActual;
    private ImageIcon animal;

    // Objeto de la clase juego
    private Juego jueguito;

    // Variables que delimitan el area del obstaculo
    private Area cuerpo, obstaculo;

    // Coordenadas iniciales donde se ubica el obstaculo
    public static int xInicial = 1300;
    public static int yInicial = 310;

    // Coordenadas para manipular el obstaculo horizontalmente
    public static int xAuxiliar = -4;

    // Dimensiones de las imagenes
    private int anchoImagen;
    private int altoImagen;

    // Variable para la velocidad de los objetos
    private int velocidad;

    public ObstaculoTierra(Juego jueguito) {
        this.jueguito = jueguito;

        nombresImagenes.add("/obstaculos/obstaculo1.png");
        nombresImagenes.add("/obstaculos/obstaculo2.png");
        nombresImagenes.add("/obstaculos/obstaculo3.png");
        nombresImagenes.add("/obstaculos/obstaculo4.png");
        nombresImagenes.add("/obstaculos/obstaculo5.png");

        nombreImagenActual = obtenerImagenAleatoria();
        animal = new ImageIcon(getClass().getResource(nombreImagenActual));

        // Asignar una velocidad aleatoria entre un rango espec�fico
        velocidad = obtenerVelocidadAleatoria();
    }

    public String obtenerImagenAleatoria() {
        int indiceAleatorio = rand.nextInt(nombresImagenes.size());
        return nombresImagenes.get(indiceAleatorio);
    }

    public int obtenerVelocidadAleatoria() {
        int velocidadMinima = 2;
        int velocidadMaxima = 6;
        // Calcular una nueva velocidad aleatoria dentro del rango
        return velocidadMinima + rand.nextInt(velocidadMaxima - velocidadMinima + 1);
    }

    public void mover() {

        // Si el obstaculo se ha salido de la ventana
        if (xInicial <= -100) {
            Juego.puntos++;
            xInicial = 1300; // Se reseta la posicion
            if (Juego.puntos % 3 == 0) {
                Juego.nivel++;
            }

            // Y se actualiza la imagen
            nombreImagenActual = obtenerImagenAleatoria();
            animal = new ImageIcon(getClass().getResource(nombreImagenActual));

            // Asignar una nueva velocidad aleatoria
            velocidad = obtenerVelocidadAleatoria();

        } else {

            if (colision()) { // Se verifica si se ha chocado con el capibara
                if (Juego.vidas == 1) { // Si chocho y no tiene vidas, pierde
                    jueguito.finJuego();
                } else {
                    jueguito.pierdeVida(); // Si chocho y tiene vidas, pierde una vida
                }
            } else {
                // Si no ha colisionado, simplemente se aumenta la velocidad al obstaculo
                xInicial += xAuxiliar - velocidad;
            }

            // Cambiar de coordenadsa a aquellas imagenes que no tengan dimensiones correctas
            cambiarCoordenadasYObstaculos();

        }
    }

    public void cambiarCoordenadasYObstaculos() {
        if (nombreImagenActual.equals("/obstaculos/obstaculo3.png")
                || nombreImagenActual.equals("/obstaculos/obstaculo4.png")
                || nombreImagenActual.equals("/obstaculos/obstaculo5.png")) {
            ObstaculoTierra.yInicial = 350;
        } else {
            ObstaculoTierra.yInicial = 321;
        }
    }

    // Dibuja el obstaculo en la pantalla
    public void paint(Graphics2D g) {
        anchoImagen = animal.getIconWidth();
        altoImagen = animal.getIconHeight();

        g.drawImage(animal.getImage(), xInicial, yInicial, null);
    }

    // Devuelve un area que representa el cuerpo del obstaculo para la deteccion de colisiones
    public Area getBounds() {
        // Area del cuerpo del objeto para la colision
        Rectangle forma1 = new Rectangle(xInicial, yInicial, anchoImagen, altoImagen);
        cuerpo = new Area(forma1);

        obstaculo = cuerpo;
        obstaculo.add(cuerpo);
        return obstaculo;
    }

    // Verifica la colision entre el obstaculo y el capibara
    public boolean colision() {
        Area areaA = new Area(jueguito.capi.getBounds());
        areaA.intersect(getBounds());
        return !areaA.isEmpty();
    }

}
