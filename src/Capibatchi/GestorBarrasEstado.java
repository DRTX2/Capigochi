
package Capibatchi;

import java.util.ArrayList;
import javax.swing.JFrame;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

public class GestorBarrasEstado {
    private ArrayList<BarraEstado> barrasEstado;
    
    public GestorBarrasEstado(){
        this.barrasEstado = new ArrayList<>();
    }
    
    public void iniciarBarrasEstado(ArrayList<Integer> estados){
        for(Integer estado: estados){
            BarraEstado barraNueva = new BarraEstado();
            barraNueva.calcularPanelEstado(Mundo.getCapibara(), estado);
            this.barrasEstado.add(barraNueva);
        }
    }
    
    public void vizualizacionBarras(JFrame jframe, int posicionX, int posicionY){
        for(BarraEstado barraReferente: this.barrasEstado){
            jframe.getContentPane().add(barraReferente.getBarraFondo(), new AbsoluteConstraints(posicionX, posicionY, 150, 20));
            
            jframe.getContentPane().add(barraReferente.getBarraEstado(), new AbsoluteConstraints(posicionX, posicionY, 150, 20));
            
            jframe.getContentPane().setComponentZOrder(barraReferente.getBarraFondo(), 0); 
            jframe.getContentPane().setComponentZOrder(barraReferente.getBarraEstado(), 0);
            
            posicionY += 30;
        }
    }
    
    public void actualizarBarras(JFrame jframe, ArrayList<Integer> estados){
        int i = 0;
        for(Integer estado : estados){
            this.barrasEstado.get(i).calcularPanelEstado(Mundo.getCapibara(), estado);
            i++;
        }
    }
    
    public void addEstadoBarra(BarraEstado barraEstado){
        this.barrasEstado.add(barraEstado);
    }
    
    public void removeEstadoBarra(BarraEstado barraEstado){
        this.barrasEstado.remove(barraEstado);
    }
    
}
