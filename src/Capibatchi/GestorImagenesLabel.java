
package Capibatchi;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

public class GestorImagenesLabel {
    private ArrayList<JLabel> listLabels;
    private ArrayList<String> pathsImagesUsed;
    private JFrame jframeUsed;
    
    public GestorImagenesLabel(JFrame jframeUsed ,ArrayList<JLabel> listLabels){
        this.jframeUsed = jframeUsed;
        this.listLabels = listLabels;
    }
    
    public void setPathsImagesUsed(ArrayList<String> pathsImagesUsed) {
        this.pathsImagesUsed = pathsImagesUsed;
    }
    
    public void setEqualsSizeLabels(int dimesionX, int dimensioY){
        for(JLabel label : this.listLabels){
            label.setSize(dimesionX, dimensioY);
        }
    }
    
    public void setImagesLabels(int positionX, int positionY){
        int i = 0;
        for(JLabel label : listLabels){
            this.jframeUsed.getContentPane().add(label, new AbsoluteConstraints(positionX, positionY));
            GestorImagenesLabel.setImageLabel(label, this.pathsImagesUsed.get(i));
            this.jframeUsed.getContentPane().setComponentZOrder(label, 0);
            
            i++;
            positionY += 30;
        }
        //this.jframeUsed.repaint();
    }
    
    public static void setImageLabel(JLabel labelName, String path) {
        try {
            ImageIcon image = new ImageIcon(path);
            Image scaledImage = image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(scaledImage);
            labelName.setIcon(icon);
        } catch (Exception e) {
            System.out.println("No se cargo la imagen de " + labelName);
        }
    }
}
