package Views;

import Capibatchi.GestorImagenesLabel;
import Capibatchi.Mundo;
import Capibatchi.Sonido;
import Conexion.Conexion;
import javax.swing.JOptionPane;

public class Principal
        extends javax.swing.JFrame {

    public Principal() {
        initComponents();
        colocarFondo();
        iniciarMusica();
        this.setLocationRelativeTo(null);
    }

    public void iniciarPartida() {
        Conexion objConexion = Conexion.obtenerConexion();
        objConexion.establecerConexion();
        objConexion.consultarExistenciaTablaCapibara();
        objConexion.consultarExistenciaTablaAlimentos();
        objConexion.consultarExistenciaTablaMedicina();
        String nombreExistente = objConexion.obtenerNombreMascota();
        System.out.println(nombreExistente);
        String nombreFinal = "";
        if ("".equals(nombreExistente)) {
            String nuevoNombreMascota = this.pedirNombre();
//            nuevoNombreMascota.trim();
            if (nuevoNombreMascota != null) {

                objConexion.actualizarNombreMascota(nuevoNombreMascota);
                nombreFinal = nuevoNombreMascota;

            }

        } else {
            // Si hay un nombre en la base de datos, se utiliza ese nombre
            nombreFinal = nombreExistente;
        }
        objConexion.close();
        Mundo nuevoJuego = new Mundo(nombreFinal);
        nuevoJuego.ejecutar();
        this.startMusic.cerrar();
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        capibara = new javax.swing.JLabel();
        startButton = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Capibara Game");
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        capibara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/capibaraDescanso.gif"))); // NOI18N
        jPanel1.add(capibara, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, -1, 240));

        startButton.setToolTipText(""); // NOI18N
        startButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startButtonMouseClicked(evt);
            }
        });
        jPanel1.add(startButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 200, 60));

        fondo.setMaximumSize(new java.awt.Dimension(600, 600));
        fondo.setRequestFocusEnabled(false);
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 530));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startButtonMouseClicked
        this.startPop.cerrar();
        this.iniciarPartida();


    }//GEN-LAST:event_startButtonMouseClicked

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel capibara;
    private javax.swing.JLabel fondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel startButton;
    // End of variables declaration//GEN-END:variables

    private Sonido startMusic;
    private Sonido startPop;

    private void colocarFondo() {
        GestorImagenesLabel.setImageLabel(this.fondo, "src/Imagenes/LobbyAnimacion.gif");
    }

    private String pedirNombre() {
        String nombre;
        do {
            nombre = JOptionPane.showInputDialog("Ponle un nuevo nombre a tu mascota:");
            if (nombre == null) {
                JOptionPane.showMessageDialog(null, "Debes ingresar un nombre válido.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!nombre.trim().isEmpty()) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Debes ingresar un nombre válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (true);
        return nombre.trim();
    }

    private void iniciarMusica() {
        this.startMusic = new Sonido("src/Sounds/peacefulSound.wav");
        this.startMusic.reproducirEnHiloNuevo(true);

        this.startPop = new Sonido("src/Sounds/startPup.wav");
        this.startPop.reproducirEnHiloNuevo(false);
    }

}
