package Views;

import Capibatchi.Mascota;
import Capibatchi.Mundo;
import javax.swing.JLabel;
import java.util.ArrayList;
import java.util.List;

public class EstadoMascotaHandler {

    private List<JLabel> mensajes;
    private Mascota capibara;
    
    public EstadoMascotaHandler(Mascota capibara) {
        this.capibara = capibara;
        this.mensajes = new ArrayList<>();
    }

    public EstadoMascotaHandler(Mascota capibara, List<JLabel> mensajes) {
        this.capibara = capibara;
        this.mensajes = mensajes;
    }

    public void actualizarMensajes() {
        verificarEstado(capibara.getEstadoDiversion().getValorEstado(), mensajes.get(0), "Mascota Aburrida!");
        verificarEstado(capibara.getEstadoHambre().getValorEstado(), mensajes.get(1), "Mascota Hambrienta!");
        verificarEstado(capibara.getEstadoEnergia().getValorEstado(), mensajes.get(2), "Mascota Cansada!");
        verificarEstado(capibara.getEstadoHigiene().getValorEstado(), mensajes.get(3), "Mascota Enferma!");
        

        if (capibara.getEstadoSalud().getValorEstado() == 0) {
            Mundo.view.gameOver();
        }
    }

    private void verificarEstado(int valorEstado, JLabel mensaje, String texto) {
        if (valorEstado < 15) {
            mensaje.setText(texto);
            mensaje.setVisible(true);
        } else {
            mensaje.setVisible(false);
        }
    }
    
    public void agregarMensaje(JLabel mensaje){
        this.mensajes.add(mensaje);
    }
    
    public void quitarMensaje(JLabel mensaje){
        this.mensajes.remove(mensaje);
    }
}
