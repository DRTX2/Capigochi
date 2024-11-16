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
import javax.swing.JLabel;
import javax.swing.Timer;

public class Habitacion extends VentanaEscenario implements ObservadorMascota {

    public Habitacion() {
        super();
        
        this.initComponents();
        this.inicioBarras();
        this.iniciarMensajes();
        this.colocarImagenes();
        this.colocarFuentes();
        this.ocultarComponetesIniciales();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mensajeDormir = new javax.swing.JLabel();
        btnLobby = new javax.swing.JLabel();
        btnDespertar = new javax.swing.JLabel();
        btnDormir = new javax.swing.JLabel();
        mascotaImg = new javax.swing.JLabel();
        mensajeAburrido = new javax.swing.JLabel();
        mensajeHambriento = new javax.swing.JLabel();
        mensajeCansado = new javax.swing.JLabel();
        mensajeEnfermo = new javax.swing.JLabel();
        nombreMascota = new javax.swing.JLabel();
        fondoHabitacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mensajeDormir.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        mensajeDormir.setForeground(new java.awt.Color(255, 255, 255));
        mensajeDormir.setText("Mensaje cuando durme");
        getContentPane().add(mensajeDormir, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 310, 150));

        btnLobby.setText("btnLobby");
        btnLobby.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLobbyMouseClicked(evt);
            }
        });
        getContentPane().add(btnLobby, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 143, 83));

        btnDespertar.setText("btnDespertar");
        btnDespertar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDespertarMouseClicked(evt);
            }
        });
        getContentPane().add(btnDespertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 370, 140, 52));

        btnDormir.setText("btnDormir");
        btnDormir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDormirMouseClicked(evt);
            }
        });
        getContentPane().add(btnDormir, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 370, 115, 52));

        mascotaImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/capMod.gif"))); // NOI18N
        getContentPane().add(mascotaImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 460, 260, 230));

        mensajeAburrido.setBackground(new java.awt.Color(255, 255, 255));
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
        nombreMascota.setForeground(new java.awt.Color(255, 255, 255));
        nombreMascota.setText("NOMBRE MASCOTA");
        getContentPane().add(nombreMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 460, -1));

        fondoHabitacion.setBackground(new java.awt.Color(153, 255, 153));
        fondoHabitacion.setForeground(new java.awt.Color(204, 255, 204));
        getContentPane().add(fondoHabitacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLobbyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLobbyMouseClicked
        Mundo.getMouseClicked().reproducirEnHiloNuevo(false);

        Lobby ventanaLobby = new Lobby();
        Mundo.setView(ventanaLobby);
        
    
    }//GEN-LAST:event_btnLobbyMouseClicked

    private void btnDormirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDormirMouseClicked
        Mundo.getMouseClicked().reproducirEnHiloNuevo(false);
        this.eventosDormir();
    }//GEN-LAST:event_btnDormirMouseClicked

    private void btnDespertarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDespertarMouseClicked
        Mundo.getMouseClicked().reproducirEnHiloNuevo(false);
        this.eventosDespertar();
    }//GEN-LAST:event_btnDespertarMouseClicked

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
            java.util.logging.Logger.getLogger(Habitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Habitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Habitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Habitacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Habitacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnDespertar;
    private javax.swing.JLabel btnDormir;
    private javax.swing.JLabel btnLobby;
    private javax.swing.JLabel fondoHabitacion;
    private javax.swing.JLabel mascotaImg;
    private javax.swing.JLabel mensajeAburrido;
    private javax.swing.JLabel mensajeCansado;
    private javax.swing.JLabel mensajeDormir;
    private javax.swing.JLabel mensajeEnfermo;
    private javax.swing.JLabel mensajeHambriento;
    private javax.swing.JLabel nombreMascota;
    // End of variables declaration//GEN-END:variables

    private GestorBarrasEstado gestorBarras;
    private EstadoMascotaHandler mensajesEstados;

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

        GestorImagenesLabel.setImageLabel(this.btnLobby, "src/Imagenes/btnLobby.png");
        GestorImagenesLabel.setImageLabel(this.btnDormir, "src/Imagenes/btnDormir.png");
        GestorImagenesLabel.setImageLabel(this.btnDespertar, "src/Imagenes/btnDespertar.png");
        GestorImagenesLabel.setImageLabel(this.fondoHabitacion, "src/Imagenes/FondoHabitacion4.png");
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

    private void ocultarComponetesIniciales() {
        this.btnDespertar.setVisible(false);
        this.mensajeDormir.setVisible(false);

        this.mensajeEnfermo.setVisible(false);
        this.mensajeHambriento.setVisible(false);
        this.mensajeCansado.setVisible(false);
        this.mensajeAburrido.setVisible(false);
    }

    private void eventosDormir() {
        GestorImagenesLabel.setImageLabel(this.mascotaImg, "src/Imagenes/capibaraDuerme.gif");
        
        this.btnDormir.setVisible(false);
        this.btnLobby.setVisible(false);
        this.btnDespertar.setVisible(true);
        
        Mundo.getControladorMascota().dormir(this.mensajeDormir);
    }

    private void eventosDespertar() {
        this.btnDespertar.setVisible(false);
        this.btnDormir.setVisible(true);
        this.btnLobby.setVisible(true);
        
        this.mascotaImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/capibaraDescanso.gif")));
        
        Mundo.getControladorMascota().despertar(this.mensajeDormir);
    }

    private void colocarFuentes() {
        Font fuentePerso = FuentePersonalizada.cargarFuentePersonalizada("src/Fuentes/game_over.ttf", 100);

        this.nombreMascota.setFont(fuentePerso);
        this.nombreMascota.setText(Mundo.getCapibara().getNombre());
    }

    private void iniciarMensajes() {
        this.mensajesEstados = new EstadoMascotaHandler(Mundo.getCapibara());
        
        this.mensajesEstados.agregarMensaje(this.mensajeAburrido);
        this.mensajesEstados.agregarMensaje(this.mensajeHambriento);
        this.mensajesEstados.agregarMensaje(this.mensajeCansado);
        this.mensajesEstados.agregarMensaje(this.mensajeEnfermo);
        
        this.mensajesEstados.actualizarMensajes();
    }

}
