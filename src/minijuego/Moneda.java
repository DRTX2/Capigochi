package minijuego;

import Capibatchi.Sonido;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Moneda {

    // Temporizador para controlar la desaparicion de la moneda automaticamente
    private Timer temporizadorDesaparicion;

    public static int contadorMonedas = 0;

    // Variable del juego
    private Juego jueguito;

    // Variables de posicion
    private static int x;
    private static int y = 195;
    private static int xAuxiliar = -2;

    // Variables para cargar, generar la imagen
    private ImageIcon imagen;
    private Random rand = new Random();
    private Area cuerpo, moneda;

    // Variables para verificar la colision, el ancho y alto de la moneda
    public static boolean colisionada = false;
    private int anchoMoneda;
    private int altoMoneda;

    public Moneda(Juego jueguito) {
        this.jueguito = jueguito;

        x = obtenerPosicionX();
        imagen = new ImageIcon(getClass().getResource("/multimedia/moneda.gif"));
        iniciarTemporizador();
    }

    public void iniciarTemporizador() {
        // Configurar el temporizador de desaparicion con retraso inicial de 5 segundos
        temporizadorDesaparicion = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!colisionada) {
                    cambiarPosicion(); // Cambiar la posici�n si no ha sido recogida la moneda
                }
                colisionada = false; // Restablecer la marca de colisi�n
                temporizadorDesaparicion.restart(); // Reiniciar el temporizador
            }
        });

        temporizadorDesaparicion.start();
    }

    public int obtenerPosicionX() {
        int anchoJuego = jueguito.getWidth();
        if (anchoJuego <= 0) {
            return x = 700;
        }
        return rand.nextInt(500, 1200);
    }

    public static void cambiarPosicion() {
        // Cambiar la posici�n de la moneda
        Random rand = new Random();
        x = rand.nextInt(1000) + 50;
        y = 195;
    }

    public void mover() {

        x += xAuxiliar;

        // Gestiona colisiones, reproduce un sonido, incrementa el contador y reinicia el temporizador
        if (colision()) {
            colisionada = true;
            Sonido sonido = new Sonido("src/multimedia/sonidoMoneda.wav");
            sonido.reproducirEnHiloNuevo(false);
            sonido.detener();
            contadorMonedas++;
            // cambiarPosicion();
            temporizadorDesaparicion.restart(); // Reiniciar el temporizador de desaparici�n
        }
    }

    // Dibuja la moneda en la pantalla si no ha colisionado
    public void paint(Graphics2D g) {
        anchoMoneda = imagen.getIconWidth();
        altoMoneda = imagen.getIconHeight();

        // Solo dibujar la moneda si no ha colisionado
        if (!colisionada) {
            g.drawImage(imagen.getImage(), x, y, null);
        }
    }

    // Devuelve un área que representa el cuerpo de la moneda para la detección de colisiones
    public Area getBounds() {
        Rectangle forma1 = new Rectangle(x, y, anchoMoneda, altoMoneda);
        cuerpo = new Area(forma1);

        moneda = cuerpo;
        moneda.add(cuerpo);
        return moneda;
    }

    // Verifica la colisión entre la moneda y el capibara
    public boolean colision() {
        if (!colisionada) {
            // Intersecta el área del capibara con el área de la moneda
            Area areaA = new Area(jueguito.capi.getBounds());
            // Devuelve verdadero si la intersección no está vacía (hay colisión)
            areaA.intersect(getBounds());
            return !areaA.isEmpty();
        }
        // Si la moneda ya ha sido recogida, devuelve falso (no hay colisión)
        return false;
    }

}
