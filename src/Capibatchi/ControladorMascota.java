package Capibatchi;

import Conexion.Conexion;
import Views.Baño;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import minijuego.Minijuego;
import Views.ObservadorMascota;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class ControladorMascota {

    private Mascota mascota;
    private ArrayList<ObservadorMascota> observadores = new ArrayList<>();
    
    private Timer dormirTimer;
    private boolean durmiendo;
    private int segundosDormidos;
    private Sonido sleppingSounds;
    
    private Timer timerBano;
    
    public ControladorMascota() {
        this.mascota = Mundo.getCapibara();
    }

    public void actualizarEstadosCotidianos() {
        Conexion objConexion = Conexion.obtenerConexion();

        this.mascota.decrementarHambre(1);
        this.mascota.decrementarDiversion(1);
        this.mascota.decrementarHigiene(1);

        if (mascota.getEstadoHigiene().getValorEstado() < 10) {
            this.enfermo();
        }

        if (mascota.getEstadoHambre().getValorEstado() < 5) {
            this.hambirento();
        }
        // Obtener los valores actualizados de los estados

      
        objConexion.actualizarValoresMascotaEnBD(mascota.getEstadoEnergia().getValorEstado(), mascota.getEstadoHambre().getValorEstado(), mascota.getEstadoDiversion().getValorEstado(), mascota.getEstadoHigiene().getValorEstado(), mascota.getEstadoSalud().getValorEstado());
        this.notificarObservadores();
    }

    public void dormir(JLabel mensajeDormir) {
        Mundo.getTemporizador().stop();
        this.durmiendo = true;
        this.segundosDormidos = 0;
        
        this.sleppingSounds = new Sonido("src/Sounds/deepSnore.wav");
        this.sleppingSounds.reproducirEnHiloNuevo(true);
        
        this.dormirTimer = new Timer(1000, e -> {
            if (durmiendo) {
                mensajeDormir.setText("<html>Shhh!<br>"
                            + "Tu mascota " + Mundo.getCapibara().getNombre() + "<br>"
                            + "está durmiendo " + segundosDormidos + " seg. </html>");
                
                mensajeDormir.setVisible(true);
                segundosDormidos++;
            }
        });
        this.dormirTimer.start();

        notificarObservadores();
    }

    public void despertar(JLabel mensajeDespertar) {
        this.durmiendo = false;
        this.dormirTimer.stop();
        
        this.sleppingSounds.cerrar();
        
        int recuperacionEnergia = (this.segundosDormidos * 35) / 10;
        int perdidaHambre = (this.segundosDormidos * 3) / 5;
        int perdidaHigiene = (this.segundosDormidos * 1) / 5;
        
        this.mascota.aumentarEnergia(recuperacionEnergia);
        this.mascota.decrementarHigiene(perdidaHigiene);
        this.mascota.decrementarHambre(perdidaHambre);
        
        notificarObservadores();
        
        mensajeDespertar.setText("<html>Tu mascota " + Mundo.getCapibara().getNombre() + " ha dormido<br>"
                + this.segundosDormidos + " segundos.<br>"
                + "Ha recuperado " + recuperacionEnergia + " de energía</html>");
        
        Mundo.getTemporizador().start();
    }
    
    

    public void banar(Baño baño,int duracionBano) {
        Mundo.getTemporizador().stop();
        
        timerBano = new Timer(1000, new ActionListener() {
            int contador = duracionBano;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (contador > 0) {
                    baño.actualizarTiempoRestante(contador);
                    contador--;
                } else {
                    timerBano.stop();
                    
                    mascota.aumentarHigiene(55);
                    mascota.aumentarSalud(15);
                    Mundo.getTemporizador().start();
                    
                    notificarObservadores();
                    
                    baño.bañoTerminado();
                }
            }
        });
        timerBano.start();
    }
    

    public void jugar() {

        int respuesta = JOptionPane.showConfirmDialog(null, "¿Quieres jugar?", "Minijuego", JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {

            JTextArea textArea = new JTextArea("Para moverte utiliza las felchas (←↑→)\nPara saltar utiliza el espacio");
            textArea.setEditable(false); // Hacer el JTextArea no editable
            JOptionPane.showMessageDialog(null, textArea, "Instrucciones", JOptionPane.INFORMATION_MESSAGE);

            Minijuego.iniciarJuego();
            this.mascota.decrementarHigiene(25);
            this.mascota.decrementarHambre(15);
            this.mascota.decrementarEnergia(25);
            this.mascota.aumentarDiversion(50);
        } else {
            Mundo.view.setVisible(true);
            Mundo.getTemporizador().start(); // Se reanuda el temporizador (2)
            Mundo.getSoundTrack().reanudar();
            Mundo.getJungleSound().reanudar();
        }
    }

    public void enfermo() {
        this.mascota.decrementarSalud(5);
    }

    public void hambirento() {
        this.mascota.decrementarSalud(3);
    }

    public void alimentar(int cantidad) {
        this.mascota.aumentarHambre(cantidad);
        this.notificarObservadores();
    }

    public void curar(int cantidad) {
        this.mascota.aumentarSalud(cantidad);
        this.notificarObservadores();
    }

    public void agregarObservador(ObservadorMascota observador) {
        this.observadores.add(observador);
    }

    public void quitarObservador(ObservadorMascota observador) {
        this.observadores.remove(observador);
    }

    public void vaciarListaObservadores() {
        this.observadores.clear();
    }

    private void notificarObservadores() {
        if (!this.observadores.isEmpty()) {
            List<ObservadorMascota> copiaObservadores = new ArrayList<>(this.observadores);

            for (ObservadorMascota observador : copiaObservadores) {
                observador.actualizarMascota();
            }
        }
    }

    public ArrayList<Integer> getListaEstadosActuales() {
        ArrayList<Integer> listaEstados = new ArrayList<>();

        listaEstados.add(this.mascota.getEstadoSalud().getValorEstado());
        listaEstados.add(this.mascota.getEstadoDiversion().getValorEstado());
        listaEstados.add(this.mascota.getEstadoHambre().getValorEstado());
        listaEstados.add(this.mascota.getEstadoEnergia().getValorEstado());
        listaEstados.add(this.mascota.getEstadoHigiene().getValorEstado());

        return listaEstados;
    }

}
