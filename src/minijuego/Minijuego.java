package minijuego;

import Capibatchi.Mundo;
import Conexion.Conexion;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Minijuego {

    // Un hilo que se encargará de ejecutar el juego
    private static Thread juegoThread;

    // Una instancia de la clase Juego, que representa la lógica del juego
    private static Juego jueguito;

    // Una instancia de JFrame que servirá como la ventana principal del juego
    private static JFrame ventana;

    public static void iniciarJuego() {

        Moneda.contadorMonedas = 0;

        ventana = new JFrame("Juego");
        jueguito = new Juego();
        ventana.add(jueguito);
        ventana.setSize(1300, 439);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // WindowListener a la ventana
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                //Actualización de monedas             
                Conexion objConexion = Conexion.obtenerConexion();
                objConexion.establecerConexion();
                Integer monedasActuales = objConexion.obtenerMonedasMascota();
                Integer monedasSumadas = monedasActuales + Moneda.contadorMonedas;
                objConexion.actualizarMonedasMascota(monedasSumadas);
                objConexion.close();

                jueguito.sonido.detener();
                ventana.dispose();
                Mundo.view.setVisible(true);
                Mundo.getTemporizador().start(); // Se reanuda el temporizador (2)
                Mundo.getSoundTrack().reanudar();
                Mundo.getJungleSound().reanudar();

                // Esto nuevo le agrege para establecer las posiciones iniciales al capibara y los objetos
                Capibara.xInicial = 50;
                Capibara.yInicial = 310;
                Capibara.saltando = false;
                ObstaculoTierra.xInicial = 1300;
                ObstaculoTierra.yInicial = 310;

            }
        });

        // Usar siempre el mismo hilo
        if (juegoThread == null) {
            juegoThread = new Thread(new JuegoRunnable());
            juegoThread.start();
        }
    }

    private static void reiniciarPosiciones() {
        Adorno.xInicial = 1400;
        ObstaculoTierra.xInicial = 1300;
        ObstaculoTierra.yInicial = 310;
        Moneda.cambiarPosicion();
    }

    // Clase interna que implementa la interfaz Runnable. 
    // Esta clase se utiliza para ejecutar el bucle principal del juego en un hilo separado.
    private static class JuegoRunnable implements Runnable {

        @Override
        public void run() {
            while (true) {
                if (Juego.juegoFinalizado) {
                    JOptionPane.showMessageDialog(null, "Haz perdido.");
                    jueguito.sonido.detener();
                    ventana.dispose();
                    Juego.juegoFinalizado = false;
                    ObstaculoTierra.xAuxiliar = -4;
                    Juego.puntos = 0;
                    Juego.nivel = 1;
                    Juego.vidas = 3;
                } else {
                    jueguito.repaint();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Minijuego.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    // Modificar variables si pierde vida el capibara
                    if (Juego.pierdeVida) {
                        JOptionPane.showMessageDialog(null, "¡Cuidado!");
                        Juego.puntos = 0;
                        Juego.vidas--;
                        Capibara.saltando = false;
                        reiniciarPosiciones();
                        Juego.pierdeVida = false;
                    }
                }
            }
        }
    }

}
