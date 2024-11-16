
package Capibatchi;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class BarraEstado {
    private JPanel barraFondo;
    private JPanel barraEstado;
    private Font fuentePerso;
    private int valorActual;

    public BarraEstado() {
        this.barraFondo = new JPanel();
        this.barraFondo.setBackground(new Color(235,230,234));
        fuentePerso = FuentePersonalizada.cargarFuentePersonalizada("src/Fuentes/futu.ttf", 12);
    }

    public void calcularPanelEstado(Mascota mascota, int estado) {
        if(estado > 100){
            this.valorActual = 100;
        }else{
            this.valorActual = estado;
        }
        
        if (this.barraEstado == null) {
            this.barraEstado = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    
                    if (mascota != null) {
                        int width = getWidth();
                        int height = getHeight();
                        if (valorActual >= 0 && valorActual <= 15) {
                            g.setColor(new Color(255,105,97));
                        } else if (valorActual > 15 && valorActual <= 50) {
                            g.setColor(new Color(255,215,0));
                        } else {
                            g.setColor(new Color(191,255,0));
                        }
                        
                        int barWidth = (valorActual * width) / 100;
                        g.fillRect(0, 0, barWidth, height);

                        g.setColor(Color.BLACK);
                        g.setFont(fuentePerso);
                        String texto = valorActual + "/100";
                        int textWidth = g.getFontMetrics().stringWidth(texto);
                        int textX = (width - textWidth) / 2;
                        int textY = (height / 2 + g.getFontMetrics().getHeight() / 2) - 6;
                        g.drawString(texto, textX, textY);
                    } else {
                        System.out.println("Barra estado error. Esto no debe salir");
                    }
                }
            };
            
            this.barraEstado.setBorder(new LineBorder(new Color(53,72,91),1));
            this.barraEstado.setLocation(0, 0);
            this.barraFondo.add(this.barraEstado);
            this.barraEstado.repaint();
        }

        if (this.barraEstado != null) {
            this.barraEstado.repaint();
        }
    }

    public JPanel getBarraFondo() {
        return barraFondo;
    }

    public JPanel getBarraEstado() {
        return barraEstado;
    }

    public void setBarraEstado(JPanel barraEstado) {
        this.barraEstado = barraEstado;
    }

    public void setBarraFondo(JPanel barraFondo) {
        this.barraFondo = barraFondo;
    }
}
