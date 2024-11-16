
package Capibatchi;

import Conexion.Conexion;
import Views.Lobby;
import Views.ObservadorMascota;
import Views.VentanaEscenario;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class Mundo {
    private static Mascota capibara;
    private static ControladorMascota controladorMascota;
    private ArrayList<ObservadorMascota> observadores = new ArrayList<>();

    public static VentanaEscenario view;
    private static Timer temporizador;
    
    private static Sonido soundTrack;
    private static Sonido jungleSound;
    private static Sonido mouseClicked;
    
    public Mundo(String nombreMascota) {
        Mundo.capibara = new Mascota();
        Mundo.capibara.setNombre(nombreMascota);
        Mundo.controladorMascota = new ControladorMascota();
        
        Lobby lobby = new Lobby();
       

        Mundo.view = lobby;
        
        Mundo.soundTrack = new Sonido("src/Sounds/WhiteLady.wav");
        Mundo.jungleSound = new Sonido("src/Sounds/JungleSound.wav");
        Mundo.mouseClicked = new Sonido("src/Sounds/correctSelection.wav");
    }
    
    public void ejecutar() {
        Mundo.view.setVisible(true);
        this.eventosMundo();
        
        Mundo.temporizador.start();
        Mundo.soundTrack.reproducirEnHiloNuevo(true);
        Mundo.jungleSound.reproducirEnHiloNuevo(true);
    }
    
    private void eventosMundo(){
        int intervalo = 3000; // 1000 ms = 1 segundo
        Mundo.temporizador = new Timer(intervalo, (ActionEvent e) -> {
            controladorMascota.actualizarEstadosCotidianos();
        });
        Mundo.controladorMascota.agregarObservador(Mundo.view);
    }

    public static void setView(VentanaEscenario view) {
        Mundo.view.dispose();
        Mundo.getControladorMascota().quitarObservador(Mundo.view);
        Mundo.view = view;
        Mundo.getControladorMascota().agregarObservador(Mundo.view);
        Mundo.view.setVisible(true);
    }

    public static VentanaEscenario getView() {
        return view;
    }
    
    public static ControladorMascota getControladorMascota() {
        return controladorMascota;
    }

    public static Timer getTemporizador() {
        return temporizador;
    }

    public static Sonido getSoundTrack() {
        return soundTrack;
    }
    
    public static Mascota getCapibara() {
        return capibara;
    }

    public static Sonido getJungleSound() {
        return jungleSound;
    }

    public static Sonido getMouseClicked() {
        return mouseClicked;
    }
    
    public void alimentando(int cantidad) {
        this.capibara.aumentarHambre(cantidad);
        this.notificarObservadores();
    }

    public void curar(int cantidad) {
        this.capibara.aumentarSalud(cantidad);
        this.notificarObservadores();
    }
    
    private void notificarObservadores() {
        if (!this.observadores.isEmpty()) {
            List<ObservadorMascota> copiaObservadores = new ArrayList<>(this.observadores);

            for (ObservadorMascota observador : copiaObservadores) {
                observador.actualizarMascota();
            }
        }
    }
}

