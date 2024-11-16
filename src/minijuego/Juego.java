package minijuego;

import Capibatchi.Sonido;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import javax.swing.JPanel;

public class Juego extends JPanel {

    // Sonido del juego
    public URL direccionSonidoSalto, direccionSonidoChoque, direccionSonidoFondo;
    public AudioClip sonidoChoque, sonidoSalto, sonidoFondo;
    public Sonido sonido;

    // Objetoss de las distintas clases
    public Capibara capi = new Capibara(this);
    public ObstaculoTierra obstaculo = new ObstaculoTierra(this);
    public Fondo fondo = new Fondo();
    public Adorno adorno = new Adorno();
    public Moneda moneda = new Moneda(this);

    // Variables para el juego
    public static boolean juegoFinalizado = false;
    public static boolean pierdeVida = false;
    public static int vidas = 3;
    public static int puntos = 0;
    public static int nivel = 1;

    public Juego() {
        direccionSonidoChoque = getClass().getResource("/multimedia/choque.wav");
        sonidoChoque = Applet.newAudioClip(direccionSonidoChoque);

        direccionSonidoSalto = getClass().getResource("/multimedia/salto.wav");
        sonidoSalto = Applet.newAudioClip(direccionSonidoSalto);

        sonido = new Sonido("src/multimedia/sonidoFondo.wav");
        sonido.reproducirEnHiloNuevo(true);

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                switch (keyCode) {
                    case KeyEvent.VK_SPACE:
                        // Acci�n de salto
                        if (!Capibara.saltando) {
                            sonidoSalto.play();
                        }
                        capi.keyPressed(e);
                        break;
                    case KeyEvent.VK_LEFT:
                        // Acci�n cuando se presiona la tecla de flecha izquierda
                        capi.moverIzquierda();
                        break;
                    case KeyEvent.VK_RIGHT:
                        // Acci�n cuando se presiona la tecla de flecha derecha
                        capi.moverDerecha();
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        // Asegura que el panel tenga el enfoque para recibir eventos de teclado
        setFocusable(true);
    }

    // Este método llama al método mover de cada uno 
    // de los elementos del juego, permitiendo que se actualicen y cambien de posición
    public void mover() {
        obstaculo.mover();
        capi.mover();
        fondo.mover();
        moneda.mover();
        adorno.mover();
    }

    // Es llamado automáticamente cuando el componente debe ser repintado. 
    // Este método se encarga de dibujar o redibujar el contenido del panel.
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        dibujar(g2);
    }

    // Este método se encarga de dibujar cada elemento del juego en el panel
    public void dibujar(Graphics2D g) {
        fondo.paint(g);
        capi.paint(g);
        obstaculo.paint(g);
        adorno.paint(g);
        moneda.paint(g);
        dibujarPuntaje(g);
        mover();
    }

    // Dibuja el puntaje, el número de vidas, el nivel y la cantidad de monedas en la interfaz gráfica
    public void dibujarPuntaje(Graphics2D g) {
        // Graphics2D g1 = g;
        Font score = new Font("Arial", Font.BOLD, 30);
        g.setFont(score);
        g.setColor(Color.RED);
        g.drawString("Puntaje: " + puntos, 1100, 30);
        g.drawString("Vidas: " + vidas, 20, 30);
        g.drawString("Nivel: " + nivel, 570, 30);
        g.drawString("Monedas: " + Moneda.contadorMonedas, 250, 30);
    }

    // Marca el final del juego, reproduce el sonido de choque y resetea la posición inicial del capibara
    public void finJuego() {
        juegoFinalizado = true;
        sonidoChoque.play();
        capi.resetearPosicionInicial();
    }

    // Marca la pérdida de una vida, reproduce el sonido de choque y resetea la posición inicial del capibara
    public void pierdeVida() {
        sonidoChoque.play();
        pierdeVida = true;
        capi.resetearPosicionInicial();
    }

}
