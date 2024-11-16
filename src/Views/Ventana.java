
package Views;

import Views.Principal;
import Views.Lobby;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Ventana extends javax.swing.JFrame{
    public void gameOver(){//dialog gameOver
        
    }
    
    public void ocultar(){// dispose o this.visible(false)
        this.setVisible(false);
    }
    
    public void save(){//guardar data
        
        int value= JOptionPane.showConfirmDialog(this,"Desea guardar la partida", "ADVERTENCIA", JOptionPane.YES_OPTION, JOptionPane.NO_OPTION);
        if(value==JOptionPane.YES_OPTION){
            //acciones para guardarlo en __________
            
        }
    }
    
    public void noSave(){//dialogo advertencia
        
    }
    
    public void goVentanaPrincipal(){//redirige al lobby
        this.save();
        Principal ventanaInicio=new Principal();
        ventanaInicio.setVisible(true);
        dispose();
    }
    
    public void goVentanaLobby(){//redirige al lobby
        this.save();
        Lobby ventanaLobby=new Lobby();
        ventanaLobby.setVisible(true);
        dispose();
    }
}
