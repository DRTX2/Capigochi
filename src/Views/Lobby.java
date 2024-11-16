package Views;

import Capibatchi.Alimento;
import Capibatchi.ArticuloInventario;
import Capibatchi.Mascota;
import Capibatchi.BarraEstado;
import Capibatchi.FuentePersonalizada;
import Capibatchi.GestorBarrasEstado;
import Capibatchi.GestorImagenesLabel;
import Capibatchi.Medicina;
import Capibatchi.Mundo;
import Capibatchi.Sonido;
import Conexion.Conexion;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

public class Lobby extends VentanaEscenario implements ObservadorMascota {
       Conexion objConexion = Conexion.obtenerConexion();
    public static ArrayList<ArticuloInventario> articulosDisponibles;
    private DefaultComboBoxModel modelo = new DefaultComboBoxModel();
    public static int totalMonedas = 0;
    public static boolean juegoEnCurso = false;
    
    public Lobby() {
        Lobby.articulosDisponibles = new ArrayList<>();
        this.objConexion.cargarArticulosDesdeBaseDeDatos();       
        this.initComponents();
        this.inicioBarras();
        this.iniciarMensajes();
        this.ocultarComponentes();
        this.colocarFuentes();
        this.colocarImagenes();
        this.setLocationRelativeTo(null);
        
        objConexion.close();   
    }
    
 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombreMascota = new javax.swing.JLabel();
        mensajeEnfermo = new javax.swing.JLabel();
        mensajeHambriento = new javax.swing.JLabel();
        mensajeCansado = new javax.swing.JLabel();
        mensajeAburrido = new javax.swing.JLabel();
        btnBaño = new javax.swing.JLabel();
        btnTienda = new javax.swing.JLabel();
        btnDormir = new javax.swing.JLabel();
        btnJugar = new javax.swing.JLabel();
        capibaraAnimation = new javax.swing.JLabel();
        imgComida = new javax.swing.JLabel();
        alimentar = new javax.swing.JButton();
        comida = new javax.swing.JComboBox<>(this.modelo);
        fondoLobby = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lobby");
        setBackground(new java.awt.Color(128, 137, 250));
        setResizable(false);
        setSize(new java.awt.Dimension(530, 530));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombreMascota.setBackground(new java.awt.Color(0, 0, 0));
        nombreMascota.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        nombreMascota.setForeground(new java.awt.Color(255, 255, 255));
        nombreMascota.setText("NOMBRE MASCOTA");
        getContentPane().add(nombreMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 460, -1));

        mensajeEnfermo.setFont(new java.awt.Font("Elephant", 0, 15)); // NOI18N
        mensajeEnfermo.setForeground(new java.awt.Color(255, 0, 0));
        mensajeEnfermo.setText("Mensaje Enfermo");
        getContentPane().add(mensajeEnfermo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 220, 30));

        mensajeHambriento.setFont(new java.awt.Font("Elephant", 0, 15)); // NOI18N
        mensajeHambriento.setForeground(new java.awt.Color(255, 0, 0));
        mensajeHambriento.setText("Mensaje Hambriento"); // NOI18N
        getContentPane().add(mensajeHambriento, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 220, 30));

        mensajeCansado.setFont(new java.awt.Font("Elephant", 0, 15)); // NOI18N
        mensajeCansado.setForeground(new java.awt.Color(255, 0, 0));
        mensajeCansado.setText("Mensaje Cansado");
        getContentPane().add(mensajeCansado, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 220, 30));

        mensajeAburrido.setFont(new java.awt.Font("Elephant", 0, 15)); // NOI18N
        mensajeAburrido.setForeground(new java.awt.Color(255, 0, 0));
        mensajeAburrido.setText("Mensaje Aburrido");
        getContentPane().add(mensajeAburrido, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 220, 30));

        btnBaño.setBackground(new java.awt.Color(204, 255, 204));
        btnBaño.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBaño.setText("boton baño"); // NOI18N
        btnBaño.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBañoMouseClicked(evt);
            }
        });
        getContentPane().add(btnBaño, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 150, 73));

        btnTienda.setText("bton tienda");
        btnTienda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTiendaMouseClicked(evt);
            }
        });
        getContentPane().add(btnTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, 180, 75));

        btnDormir.setText("bton habitacion");
        btnDormir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDormirMouseClicked(evt);
            }
        });
        getContentPane().add(btnDormir, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 380, 180, 75));

        btnJugar.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        btnJugar.setForeground(new java.awt.Color(0, 255, 204));
        btnJugar.setText("Jugar");
        btnJugar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnJugarMouseClicked(evt);
            }
        });
        getContentPane().add(btnJugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 170, 180, 75));
        btnJugar.getAccessibleContext().setAccessibleName("btnJugar");

        capibaraAnimation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/capMod.gif"))); // NOI18N
        getContentPane().add(capibaraAnimation, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 480, 170, 150));

        imgComida.setMinimumSize(new java.awt.Dimension(50, 50));
        imgComida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgComidaMouseClicked(evt);
            }
        });
        getContentPane().add(imgComida, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 100, 100));
        imgComida.setVisible(false);

        alimentar.setText("Inventario");
        alimentar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alimentarMouseClicked(evt);
            }
        });
        getContentPane().add(alimentar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 260, 110, 59));

        for (int i = 0; i < Lobby.articulosDisponibles.size(); i++) {
            modelo.addElement(Lobby.articulosDisponibles.get(i));
        }
        this.comida.setVisible(false);
        comida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comidaActionPerformed(evt);
            }
        });
        getContentPane().add(comida, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, -1, -1));

        fondoLobby.setMaximumSize(new java.awt.Dimension(600, 600));
        fondoLobby.setRequestFocusEnabled(false);
        getContentPane().add(fondoLobby, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBañoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBañoMouseClicked
        Mundo.getMouseClicked().reproducirEnHiloNuevo(false);
        Mundo.getJungleSound().detener();
        
        VentanaEscenario ventanaBaño = new Baño();
        Mundo.setView(ventanaBaño);
    
    }//GEN-LAST:event_btnBañoMouseClicked

    private void btnTiendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTiendaMouseClicked
        Tienda vt = new Tienda();
       
        Mundo.getTemporizador().stop();
        vt.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTiendaMouseClicked

    private void btnDormirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDormirMouseClicked
        Mundo.getMouseClicked().reproducirEnHiloNuevo(false);
        
        VentanaEscenario ventanaHabitacion = new Habitacion();
        Mundo.setView(ventanaHabitacion);
    
    }//GEN-LAST:event_btnDormirMouseClicked

    private void btnJugarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnJugarMouseClicked
        Mundo.getMouseClicked().reproducirEnHiloNuevo(false);
        this.eventosJugar();
        
    }//GEN-LAST:event_btnJugarMouseClicked

    private void alimentarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alimentarMouseClicked
         this.comida.setVisible(!this.comida.isVisible());
        if (this.comida.isVisible()) {//si el btnComida esta deshabilitado lo habilitamos y cambiamos el texto actual del btn Alimentar
            this.alimentar.setText("Cerrar");
        } else {//lo deshabilitamos y volvemos a cambiar el texto
            this.comida.setVisible(false);
            this.alimentar.setText("Inventario");
        }
        
    }//GEN-LAST:event_alimentarMouseClicked

    private void comidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comidaActionPerformed
        ArticuloInventario seleccionado = (ArticuloInventario) comida.getSelectedItem();
        if (seleccionado != null) {
            System.out.println("Elemento seleccionado: " + seleccionado + seleccionado.getPath());//ya esta
            //mostrar imagen de que se esta eligiendo
            this.mostrarArticuloSeleccionada(seleccionado);
        }
    }//GEN-LAST:event_comidaActionPerformed

    private void imgComidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgComidaMouseClicked
        Conexion objConexion = Conexion.obtenerConexion();
        objConexion.establecerConexion();
        ArticuloInventario seleccionado = (ArticuloInventario) comida.getSelectedItem();
        try {
            String nombre = seleccionado.getNombre();
            //nos basamos en el path como un id, las medicinas empezaran desde el 50
            int numPath=tratamientoNumero(seleccionado.getPath());
            int cantidadActual;
            String nombreTabla;

            if (numPath < 50) {//entonces es comida
                int hambreRecuperada = ((Alimento) seleccionado).gethambreRecuperada();
                Mundo.getControladorMascota().alimentar(hambreRecuperada);
                nombreTabla = "Alimentos";
            } else { //es medicina
                int saludRecuperada = ((Medicina) seleccionado).getSaludRecuperada();
                Mundo.getControladorMascota().curar(saludRecuperada);
                nombreTabla = "Medicina";
            }
            // Obtener y actualizar la cantidad de alimentos
            cantidadActual = objConexion.obtenerValorArticulo(nombre, nombreTabla);
            objConexion.actualizarValorArticulo(nombre, cantidadActual - 1, nombreTabla);
            objConexion.close();
            seleccionado.deacreaseCantidad();
            if (seleccionado.getCantidad() == 0) {
                Lobby.articulosDisponibles.remove(seleccionado);
                imgComida.setVisible(false);
                modelo.removeElement(seleccionado);
                //seleccionado=null;
            }
            //si ya no hay nada lo vamos a volver a poner como estaba antes? si ven esto dejo a su criterio si seria mejor eliminar los botones
            if (Lobby.articulosDisponibles.isEmpty()) {
                //this.alimentar.setText("Alimentar");
                this.alimentar.setVisible(false);
                this.comida.setVisible(false);
                this.comida = null;
            }else{
                //  this.actualizarComboBox();
                this.comida.repaint();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_imgComidaMouseClicked

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
            java.util.logging.Logger.getLogger(Lobby.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lobby.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lobby.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lobby.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lobby().setVisible(true);
            }
        });
    }

    public void mostrarVista(boolean mostrar) {
        this.setVisible(mostrar);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alimentar;
    private javax.swing.JLabel btnBaño;
    private javax.swing.JLabel btnDormir;
    private javax.swing.JLabel btnJugar;
    private javax.swing.JLabel btnTienda;
    private javax.swing.JLabel capibaraAnimation;
    private javax.swing.JComboBox<String> comida;
    private javax.swing.JLabel fondoLobby;
    private javax.swing.JLabel imgComida;
    private javax.swing.JLabel mensajeAburrido;
    private javax.swing.JLabel mensajeCansado;
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
        
        GestorImagenesLabel.setImageLabel(this.fondoLobby, "src/Imagenes/fondoLobby.jpg");
        
        GestorImagenesLabel.setImageLabel(this.btnBaño, "src/Imagenes/btnBanio.png");
        GestorImagenesLabel.setImageLabel(this.btnDormir, "src/Imagenes/btnDor.png");
        GestorImagenesLabel.setImageLabel(this.btnTienda, "src/Imagenes/btnTienda.png");
        GestorImagenesLabel.setImageLabel(this.btnJugar, "src/Imagenes/btnJugar.png");
        this.alimentar.setIcon(new ImageIcon("src/Imagenes/btnInventario.png"));
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

    private void ocultarComponentes() {
        this.mensajeEnfermo.setVisible(false);
        this.mensajeHambriento.setVisible(false);
        this.mensajeCansado.setVisible(false);
        this.mensajeAburrido.setVisible(false);
    }

    private void colocarFuentes() {
        Font fuentePerso = FuentePersonalizada.cargarFuentePersonalizada("src/Fuentes/game_over.ttf", 100);
        this.nombreMascota.setFont(fuentePerso);
        this.nombreMascota.setText(Mundo.getCapibara().getNombre());
    }
    

    private void eventosJugar() {
        if (Mundo.getCapibara().getEstadoEnergia().getValorEstado() >= 25) {
            this.setVisible(false);
            Mundo.getTemporizador().stop(); // Se para el temporizador (1)
            Mundo.getSoundTrack().detener();
            Mundo.getJungleSound().detener();
            Mundo.getControladorMascota().jugar();
        }else{
            JOptionPane.showMessageDialog(null, "No dispones de la energía necesaría para jugar. (mín 25)",
                    "Energía Insuficiente", 1);
        }
    }
    
    // No hay etiqeuta, no se esta utilizando este metodo
    public void actualizarEtiquetaMonedas(int cantidadMonedas) {
        totalMonedas += cantidadMonedas;
        // etiquetaMonedas.setText("Monedas: " + totalMonedas); Etiqueta para las monedas
    }
    
    
    private int tratamientoNumero(String target){
        String numPath = target.substring(10, 12);
        if(numPath.charAt(0)==0){
            numPath=target.substring(1);
        }
        return Integer.parseInt(numPath);
    }
    
    private void mostrarArticuloSeleccionada(ArticuloInventario a) {
        try {
            ImageIcon img = new ImageIcon(getClass().getResource(a.getPath()));
            System.out.println("path-" + a.getPath());
            imgComida.setIcon(new ImageIcon(img.getImage().getScaledInstance(imgComida.getWidth(), imgComida.getHeight(), Image.SCALE_SMOOTH)));
            imgComida.setVisible(true);
        } catch (Exception e) {
            System.err.println("e=" + e);
        }
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
