
package Views;

import Capibatchi.Mascota;
import Capibatchi.Mundo;
import javax.swing.JOptionPane;

public abstract class VentanaEscenario extends javax.swing.JFrame implements ObservadorMascota {
    
    
    public void gameOver(){
        GameOver vtnGameOver = new GameOver();
        Mundo.getTemporizador().stop();
        Mundo.getSoundTrack().cerrar();
        Mundo.getJungleSound().cerrar();
        Mundo.getControladorMascota().vaciarListaObservadores();;
        this.dispose();
        vtnGameOver.setVisible(true);
    }
}
