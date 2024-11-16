package Views;

import Capibatchi.Mundo;
import Capibatchi.Sonido;
import Conexion.Conexion;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.SwingConstants;

public class GameOver extends javax.swing.JFrame {

    public GameOver() {
        Conexion objConexion = Conexion.obtenerConexion();
  

        objConexion.borrarTabla("Capibara");
        objConexion.borrarTabla("Alimentos");
        objConexion.borrarTabla("Medicina");
        initComponents();
        iniciarSonido();
        this.configuracionGameOver();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNuevoJuego = new javax.swing.JLabel();
        btnClose = new javax.swing.JLabel();
        mensajeGameOver = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(900, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnNuevoJuego.setForeground(new java.awt.Color(0, 0, 0));
        btnNuevoJuego.setText("jugar de nuevo text");
        btnNuevoJuego.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoJuegoMouseClicked(evt);
            }
        });
        getContentPane().add(btnNuevoJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 330, 60));

        btnClose.setForeground(new java.awt.Color(0, 0, 0));
        btnClose.setText("jugar de nuevo text"); // NOI18N
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 330, 60));

        mensajeGameOver.setBackground(new java.awt.Color(255, 255, 255));
        mensajeGameOver.setForeground(new java.awt.Color(0, 0, 0));
        mensajeGameOver.setText("Mensaje game over"); // NOI18N
        mensajeGameOver.setOpaque(true);
        getContentPane().add(mensajeGameOver, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoJuegoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoJuegoMouseClicked
        this.peacefulSound.cerrar();
        Principal ventPrincipal = new Principal();
        Mundo.getView().dispose();
        ventPrincipal.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnNuevoJuegoMouseClicked

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnCloseMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameOver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameOver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameOver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameOver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameOver().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnClose;
    private javax.swing.JLabel btnNuevoJuego;
    private javax.swing.JLabel mensajeGameOver;
    // End of variables declaration//GEN-END:variables

    private Sonido peacefulSound;

    private void configuracionGameOver() {
        Font fuentePersoGrande = GameOver.cargarFuentePersonalizada("src/Fuentes/game_over.ttf", 200);

        this.mensajeGameOver.setFont(fuentePersoGrande);
        this.mensajeGameOver.setText("Game Over");
        this.mensajeGameOver.setHorizontalAlignment(SwingConstants.CENTER);

        Font fuentePersoChica = GameOver.cargarFuentePersonalizada("src/Fuentes/game_over.ttf", 70);

        this.btnNuevoJuego.setFont(fuentePersoChica);
        this.btnNuevoJuego.setText("Play Again");
        this.btnNuevoJuego.setHorizontalAlignment(SwingConstants.CENTER);

        this.btnClose.setFont(fuentePersoChica);
        this.btnClose.setText("Exit Game");
        this.btnClose.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public static Font cargarFuentePersonalizada(String rutaFuente, float tamaño) {
        Font fuentePersonalizada = null;
        try {
            File archivoFuente = new File(rutaFuente);
            if (archivoFuente.exists()) {
                InputStream is = new FileInputStream(archivoFuente);
                fuentePersonalizada = Font.createFont(Font.TRUETYPE_FONT, is);
                fuentePersonalizada = fuentePersonalizada.deriveFont(tamaño);
            } else {
                System.err.println("Error: Archivo de fuente no encontrado en la ruta especificada.");
            }
        } catch (Exception e) {
            System.err.println("Error al cargar la fuente personalizada: " + e.getMessage());
        }
        return fuentePersonalizada;
    }

    private void iniciarSonido() {
        this.peacefulSound = new Sonido("src/Sounds/peacefulSound.wav");
        this.peacefulSound.reproducirEnHiloNuevo(true);
    }
}
