package Views;

import Capibatchi.Mascota;
import Capibatchi.BarraEstado;
import Capibatchi.FuentePersonalizada;
import Capibatchi.GestorBarrasEstado;
import Capibatchi.GestorImagenesLabel;
import Capibatchi.Mundo;
import Capibatchi.Sonido;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.Timer;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

public class Baño extends VentanaEscenario implements ObservadorMascota {

    public Baño() {
        super();
        
        this.initComponents();
        this.inicioBarras();
        this.iniciarMensajes();
        this.colocarImagenes();
        this.colocarFuentes();
        this.ocultarComponetesIniciales();
        this.setLocationRelativeTo(null);
        this.inicioMusica();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        mensajeBaño = new javax.swing.JLabel();
        animacion = new javax.swing.JLabel();
        btnBanio = new javax.swing.JLabel();
        btnLobby = new javax.swing.JLabel();
        mensajeAburrido = new javax.swing.JLabel();
        mensajeHambriento = new javax.swing.JLabel();
        mensajeCansado = new javax.swing.JLabel();
        mensajeEnfermo = new javax.swing.JLabel();
        nombreMascota = new javax.swing.JLabel();
        fondoBaño = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mensajeBaño.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        mensajeBaño.setForeground(new java.awt.Color(255, 255, 255));
        mensajeBaño.setText("Mensaje de Baño");
        getContentPane().add(mensajeBaño, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 370, 230));

        animacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/capibaraDescanso.gif"))); // NOI18N
        getContentPane().add(animacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 210, 190));

        btnBanio.setText("btnBaño");
        btnBanio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBanioMouseClicked(evt);
            }
        });
        getContentPane().add(btnBanio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 190, 54));

        btnLobby.setText("btnLobby");
        btnLobby.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLobbyMouseClicked(evt);
            }
        });
        getContentPane().add(btnLobby, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 400, 143, 83));

        mensajeAburrido.setFont(new java.awt.Font("Elephant", 0, 15)); // NOI18N
        mensajeAburrido.setForeground(new java.awt.Color(255, 0, 0));
        mensajeAburrido.setText("Mensaje Aburrido");
        getContentPane().add(mensajeAburrido, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 220, 30));

        mensajeHambriento.setFont(new java.awt.Font("Elephant", 0, 15)); // NOI18N
        mensajeHambriento.setForeground(new java.awt.Color(255, 0, 0));
        mensajeHambriento.setText("Mensaje Hambriento");
        getContentPane().add(mensajeHambriento, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 220, 30));

        mensajeCansado.setFont(new java.awt.Font("Elephant", 0, 15)); // NOI18N
        mensajeCansado.setForeground(new java.awt.Color(255, 0, 0));
        mensajeCansado.setText("Mensaje Cansado");
        getContentPane().add(mensajeCansado, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 220, 30));

        mensajeEnfermo.setFont(new java.awt.Font("Elephant", 0, 15)); // NOI18N
        mensajeEnfermo.setForeground(new java.awt.Color(255, 0, 0));
        mensajeEnfermo.setText("Mensaje Enfermo");
        getContentPane().add(mensajeEnfermo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 220, 30));

        nombreMascota.setBackground(new java.awt.Color(0, 0, 0));
        nombreMascota.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        nombreMascota.setForeground(new java.awt.Color(0, 0, 0));
        nombreMascota.setText("NOMBRE MASCOTA");
        getContentPane().add(nombreMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 460, -1));
        getContentPane().add(fondoBaño, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLobbyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLobbyMouseClicked
        this.rioSound.cerrar();
        
        Mundo.getMouseClicked().reproducirEnHiloNuevo(false);
        Mundo.getJungleSound().reanudar();
        
        Lobby ventanaLobby = new Lobby();
        Mundo.setView(ventanaLobby);
     
    }//GEN-LAST:event_btnLobbyMouseClicked

    private void btnBanioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBanioMouseClicked
        Mundo.getMouseClicked().reproducirEnHiloNuevo(false);
        this.eventosBanioMascota();

    }//GEN-LAST:event_btnBanioMouseClicked

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
            java.util.logging.Logger.getLogger(Baño.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Baño.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Baño.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Baño.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Baño().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel animacion;
    private javax.swing.JLabel btnBanio;
    private javax.swing.JLabel btnLobby;
    private javax.swing.JLabel fondoBaño;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mensajeAburrido;
    private javax.swing.JLabel mensajeBaño;
    private javax.swing.JLabel mensajeCansado;
    private javax.swing.JLabel mensajeEnfermo;
    private javax.swing.JLabel mensajeHambriento;
    private javax.swing.JLabel nombreMascota;
    // End of variables declaration//GEN-END:variables

    private GestorBarrasEstado gestorBarras;
    private EstadoMascotaHandler mensajesEstados;
    
    private Sonido rioSound;
    private Sonido waterSplash;

    private void inicioMusica() {
        this.rioSound = new Sonido("src/Sounds/rioSound.wav");
        rioSound.reproducirEnHiloNuevo(true);
    }

    private void inicioBarras() {
        this.gestorBarras = new GestorBarrasEstado();
        this.gestorBarras.iniciarBarrasEstado(Mundo.getControladorMascota().getListaEstadosActuales());
        this.gestorBarras.vizualizacionBarras(this, 50, 70);
    }

    @Override
    public void actualizarMascota() {
        this.gestorBarras.actualizarBarras(this, Mundo.getControladorMascota().getListaEstadosActuales());

        this.mensajesEstados.actualizarMensajes();
    }

    private void colocarImagenes() {
        this.imagenesIconos();
        
        GestorImagenesLabel.setImageLabel(this.fondoBaño, "src/Imagenes/FondoBaño3.png");
        GestorImagenesLabel.setImageLabel(this.btnLobby, "src/Imagenes/btnLobby.png");
        GestorImagenesLabel.setImageLabel(this.btnBanio, "src/Imagenes/btnTakeBath.png");
    }
    
    private void imagenesIconos(){
        ArrayList<JLabel> panelesImagenes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            panelesImagenes.add(new JLabel());
        }

        GestorImagenesLabel gestorImagesIconsLabels = new GestorImagenesLabel(this, panelesImagenes);

        ArrayList<String> pathImages = new ArrayList<>();
        pathImages.add("src/Imagenes/corazon.png");
        pathImages.add("src/Imagenes/smiley.png");
        pathImages.add("src/Imagenes/tenedor.png");
        pathImages.add("src/Imagenes/relampago.png");
        pathImages.add("src/Imagenes/proteccion.png");

        gestorImagesIconsLabels.setEqualsSizeLabels(20, 20);
        gestorImagesIconsLabels.setPathsImagesUsed(pathImages);
        gestorImagesIconsLabels.setImagesLabels(20, 70);
    }
    
    private void eventosBanioMascota() {
        GestorImagenesLabel.setImageLabel(this.animacion, "src/Imagenes/capibaraBaño.gif");
        this.waterSplash = new Sonido("src/Sounds/WaterSplash.wav");
        this.waterSplash.reproducirEnHiloNuevo(true);

        this.btnLobby.setVisible(false);
        Mundo.getTemporizador().stop();

        int duracionBano = 10;  // Asigna la duración del baño que desees
        Mundo.getControladorMascota().banar(this, duracionBano);
        this.btnBanio.setVisible(false);
    }
    
    public void actualizarTiempoRestante(int contador){
        this.mensajeBaño.setVisible(true);
        this.mensajeBaño.setText("<html>Tú hermosa mascota " + Mundo.getCapibara().getNombre()
                        + "<br>se esta bañando, " + contador + " seg</html>");
    }

    private void ocultarComponetesIniciales() {
        this.mensajeEnfermo.setVisible(false);
        this.mensajeHambriento.setVisible(false);
        this.mensajeCansado.setVisible(false);
        this.mensajeAburrido.setVisible(false);

        this.mensajeBaño.setVisible(false);
    }

    private void colocarFuentes() {
        Font fuentePerso = FuentePersonalizada.cargarFuentePersonalizada("src/Fuentes/game_over.ttf", 100);

        this.nombreMascota.setFont(fuentePerso);
        this.nombreMascota.setText(Mundo.getCapibara().getNombre());
    }
    
    @Override
    public void gameOver(){
        this.rioSound.cerrar();
        GameOver vtnGameOver = new GameOver();
        Mundo.getTemporizador().stop();
        Mundo.getSoundTrack().cerrar();
        Mundo.getJungleSound().cerrar();
        Mundo.getControladorMascota().vaciarListaObservadores();;
        this.dispose();
        vtnGameOver.setVisible(true);
    }
    
    private void iniciarMensajes() {
        this.mensajesEstados = new EstadoMascotaHandler(Mundo.getCapibara());
        
        this.mensajesEstados.agregarMensaje(this.mensajeAburrido);
        this.mensajesEstados.agregarMensaje(this.mensajeHambriento);
        this.mensajesEstados.agregarMensaje(this.mensajeCansado);
        this.mensajesEstados.agregarMensaje(this.mensajeEnfermo);
        
        this.mensajesEstados.actualizarMensajes();
    }

    public void bañoTerminado() {
        this.animacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/capibaraDescanso.gif"))); // NOI18N
        mensajeBaño.setText("<html>Tú hermosa mascota " + Mundo.getCapibara().getNombre()
                            + "<br>se ha bañado</html>");
                    btnBanio.setVisible(true);
                    btnLobby.setVisible(true);
                    btnLobby.setLocation(160, 150);
        this.btnBanio.setVisible(true);
    }

}
