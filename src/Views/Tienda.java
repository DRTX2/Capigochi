package Views;

import Capibatchi.Alimento;
import Capibatchi.ArticuloInventario;
import Capibatchi.Mundo;
import Conexion.Conexion;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Tienda
        extends Ventana
         {
 Conexion objConexion = Conexion.obtenerConexion(); 
    Integer monedas;

    public Tienda() {

        monedas = objConexion.obtenerMonedasMascota(); // Obtener las monedas
        initComponents();
        iniciarImagenesMedicina();
        bloquearBotones();
        setLocationRelativeTo(null);
    }
    
    private void iniciarImagenesMedicina(){
        //this.med1
        //this.med2
        /*
        ImageIcon img = new ImageIcon(getClass().getResource("/Imagenes/50.jpg"));
        jLabel2.setIcon(new ImageIcon(img.getImage().getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH)));
    jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1580, -1, -1));

        */
        ImageIcon[] imagenes=new ImageIcon[4];
        for (int i = 50; i < 54; i++) {
            String resource="/Imagenes/"+i+".jpg";//como empiezan desde el 50
            imagenes[i-50] = new ImageIcon(getClass().getResource(resource));
        }
        this.med1.setIcon(new ImageIcon(imagenes[0].getImage().getScaledInstance(this.med1.getWidth(), this.med1.getHeight(), Image.SCALE_SMOOTH)));
        this.med2.setIcon(new ImageIcon(imagenes[1].getImage().getScaledInstance(this.med2.getWidth(), this.med2.getHeight(), Image.SCALE_SMOOTH)));
        this.med3.setIcon(new ImageIcon(imagenes[2].getImage().getScaledInstance(this.med3.getWidth(), this.med3.getHeight(), Image.SCALE_SMOOTH)));
        this.med4.setIcon(new ImageIcon(imagenes[3].getImage().getScaledInstance(this.med4.getWidth(), this.med4.getHeight(), Image.SCALE_SMOOTH)));
       
    }
  
    public Integer getMonedas() {
        return this.monedas;
    }

    public void setMonedas(Integer monedas) {
        this.monedas = monedas;
    }

    public void setComida(ArrayList<ArticuloInventario> articulos) {
        Lobby.articulosDisponibles = articulos;
    }

    private int buscarComida(Alimento a) {
        for (int i = 0; i < Lobby.articulosDisponibles.size(); i++) {
            if (Lobby.articulosDisponibles.get(i).equals(a)) {
                return i;
            }
        }
        return -1;
    }

    private void bloquearBotones() {//en este metodo se guarda la comida en el array estatico de la clase lobby         
        if (objConexion.obtenerMonedasMascota() < 7) {
            this.blockBtns();
        }
    }

    private boolean costoSuficienteComida(String nombre, String tabla){
        int costoArticulo=objConexion.obtenerCostoArticulo(nombre, tabla);
        int monedasActuales=objConexion.obtenerMonedasMascota();
        return costoArticulo>monedasActuales;//El costo del articulo es mayor a la cantidad de monedas actuales?
    }
    
    
    private void obtenerValorArticuloComida(String nombreComida) {
       
        if(costoSuficienteComida(nombreComida, "Alimentos"))//si lo es entonces termina el metodo
            return;
        //falta ver si su costo es suficiente
        Integer cantidadActual = objConexion.obtenerValorArticulo(nombreComida, "Alimentos");
        objConexion.actualizarValorArticulo(nombreComida, cantidadActual + 1, "Alimentos");
        objConexion.actualizarMonedasMascota(objConexion.obtenerMonedasMascota() - objConexion.obtenerCostoArticulo(nombreComida, "Alimentos"));
        this.etiquetaMonedas.setText("$ " + objConexion.obtenerMonedasMascota());
        bloquearBotones();
    }

    private void obtenerValorArticuloMedicina(String nombreMedicina) {
        if(costoSuficienteComida(nombreMedicina, "Medicina"))//si lo es entonces termina el metodo
            return;
        Integer cantidadActual = objConexion.obtenerValorArticulo(nombreMedicina, "Medicina");
        objConexion.actualizarValorArticulo(nombreMedicina, cantidadActual + 1, "Medicina");
        objConexion.actualizarMonedasMascota(objConexion.obtenerMonedasMascota() - objConexion.obtenerCostoArticulo(nombreMedicina, "Medicina"));
        this.etiquetaMonedas.setText("$ " + objConexion.obtenerMonedasMascota());
        bloquearBotones();
    }

    private void blockBtns() {
        this.btn1.setEnabled(false);
        this.btn2.setEnabled(false);
        this.btn3.setEnabled(false);
        this.btn4.setEnabled(false);
        this.btn5.setEnabled(false);
        this.btn6.setEnabled(false);
        this.btn7.setEnabled(false);
        this.btn8.setEnabled(false);
        this.btn9.setEnabled(false);
        this.btn10.setEnabled(false);
        this.btn11.setEnabled(false);
        this.btn12.setEnabled(false);
        this.btn13.setEnabled(false);
        this.btn14.setEnabled(false);
        this.btn15.setEnabled(false);
        this.btn16.setEnabled(false);
        this.btn17.setEnabled(false);
        this.btn18.setEnabled(false);
        this.btn19.setEnabled(false);
        this.btn20.setEnabled(false);
        this.btn21.setEnabled(false);
        this.btn22.setEnabled(false);
        this.btn23.setEnabled(false);
        this.btn24.setEnabled(false);
        this.btn25.setEnabled(false);
        this.btn26.setEnabled(false);
        this.btn27.setEnabled(false);
        this.btn28.setEnabled(false);
        this.btn29.setEnabled(false);
        this.btn30.setEnabled(false);
        this.btn31.setEnabled(false);
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn10 = new javax.swing.JButton();
        btn11 = new javax.swing.JButton();
        btn12 = new javax.swing.JButton();
        btn13 = new javax.swing.JButton();
        btn14 = new javax.swing.JButton();
        btn15 = new javax.swing.JButton();
        btn16 = new javax.swing.JButton();
        btn17 = new javax.swing.JButton();
        btn18 = new javax.swing.JButton();
        btn19 = new javax.swing.JButton();
        btn20 = new javax.swing.JButton();
        btn21 = new javax.swing.JButton();
        btn22 = new javax.swing.JButton();
        btn23 = new javax.swing.JButton();
        btn24 = new javax.swing.JButton();
        btn25 = new javax.swing.JButton();
        btn26 = new javax.swing.JButton();
        btn27 = new javax.swing.JButton();
        btn28 = new javax.swing.JButton();
        btn29 = new javax.swing.JButton();
        btn30 = new javax.swing.JButton();
        btn31 = new javax.swing.JButton();
        btnLobby = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        etiquetaMonedas = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        list1 = new javax.swing.JLabel();
        list2 = new javax.swing.JLabel();
        list3 = new javax.swing.JLabel();
        med1 = new javax.swing.JLabel();
        med2 = new javax.swing.JLabel();
        med3 = new javax.swing.JLabel();
        med4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(500, 100));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(518, 2800));
        jPanel1.setMinimumSize(new java.awt.Dimension(510, 504));
        jPanel1.setPreferredSize(new java.awt.Dimension(505, 1850));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn1.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        btn1.setText("$ 7");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        btn2.setText("$ 9");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        jPanel1.add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, -1, -1));

        btn3.setText("$ 9");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        jPanel1.add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, -1, -1));

        btn4.setText("$ 10");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        jPanel1.add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, -1, -1));

        btn5.setText("$ 10");
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        jPanel1.add(btn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, -1, -1));

        btn6.setText("$ 8");
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        jPanel1.add(btn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, -1, -1));

        btn7.setText("$ 13");
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        jPanel1.add(btn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 480, -1, -1));

        btn8.setText("$ 7");
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        jPanel1.add(btn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 480, -1, -1));

        btn9.setText("$ 9");
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });
        jPanel1.add(btn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 480, -1, -1));

        btn10.setText("$ 7");
        btn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn10ActionPerformed(evt);
            }
        });
        jPanel1.add(btn10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 660, -1, -1));

        btn11.setText("$ 7");
        btn11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn11ActionPerformed(evt);
            }
        });
        jPanel1.add(btn11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 660, -1, -1));

        btn12.setText("$ 13");
        btn12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn12ActionPerformed(evt);
            }
        });
        jPanel1.add(btn12, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 660, -1, -1));

        btn13.setText("$ 11");
        btn13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn13ActionPerformed(evt);
            }
        });
        jPanel1.add(btn13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 830, -1, -1));

        btn14.setText("$ 12");
        btn14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn14ActionPerformed(evt);
            }
        });
        jPanel1.add(btn14, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 830, -1, -1));

        btn15.setText("$ 12");
        btn15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn15ActionPerformed(evt);
            }
        });
        jPanel1.add(btn15, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 830, -1, -1));

        btn16.setText("$ 15");
        btn16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn16ActionPerformed(evt);
            }
        });
        jPanel1.add(btn16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 990, -1, -1));

        btn17.setText("$ 8");
        btn17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn17ActionPerformed(evt);
            }
        });
        jPanel1.add(btn17, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 990, -1, -1));

        btn18.setText("$ 7");
        btn18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn18ActionPerformed(evt);
            }
        });
        jPanel1.add(btn18, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 990, -1, -1));

        btn19.setText("$ 9");
        btn19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn19ActionPerformed(evt);
            }
        });
        jPanel1.add(btn19, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 1170, -1, -1));

        btn20.setText("$ 9");
        btn20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn20ActionPerformed(evt);
            }
        });
        jPanel1.add(btn20, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 1170, -1, -1));

        btn21.setText("$ 15");
        btn21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn21ActionPerformed(evt);
            }
        });
        jPanel1.add(btn21, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 1170, -1, -1));

        btn22.setText("$ 10");
        btn22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn22ActionPerformed(evt);
            }
        });
        jPanel1.add(btn22, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 1320, -1, -1));

        btn23.setText("$ 15");
        btn23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn23ActionPerformed(evt);
            }
        });
        jPanel1.add(btn23, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 1320, -1, -1));

        btn24.setText("$ 13");
        btn24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn24ActionPerformed(evt);
            }
        });
        jPanel1.add(btn24, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 1320, -1, -1));

        btn25.setText("$ 25");
        btn25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn25ActionPerformed(evt);
            }
        });
        jPanel1.add(btn25, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 1470, -1, -1));

        btn26.setText("$ 8");
        btn26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn26ActionPerformed(evt);
            }
        });
        jPanel1.add(btn26, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1470, -1, -1));

        btn27.setText("$ 7");
        btn27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn27ActionPerformed(evt);
            }
        });
        jPanel1.add(btn27, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 1470, -1, -1));

        btn28.setText("$ 10");
        btn28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn28ActionPerformed(evt);
            }
        });
        jPanel1.add(btn28, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1640, -1, 20));

        btn29.setText("$ 15");
        btn29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn29ActionPerformed(evt);
            }
        });
        jPanel1.add(btn29, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 1640, -1, -1));

        btn30.setText("$ 20");
        btn30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn30ActionPerformed(evt);
            }
        });
        jPanel1.add(btn30, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 1640, -1, -1));

        btn31.setText("$ 25");
        btn31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn31ActionPerformed(evt);
            }
        });
        jPanel1.add(btn31, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 1800, -1, -1));

        btnLobby.setText("Lobby");
        btnLobby.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLobbyActionPerformed(evt);
            }
        });
        jPanel1.add(btnLobby, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/monedas.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 40, 40));

        etiquetaMonedas.setText("$ "+this.monedas);
        jPanel1.add(etiquetaMonedas, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel1.setText("FOOD SHOP");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        list1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ComidaTanda1.jpg"))); // NOI18N
        jPanel1.add(list1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        list2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ComidaTanda2.jpg"))); // NOI18N
        jPanel1.add(list2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, -1, -1));

        list3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ComidaTanda3.jpg"))); // NOI18N
        jPanel1.add(list3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1010, -1, -1));
        jPanel1.add(med1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 1530, 90, 90));
        jPanel1.add(med2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 1530, 90, 90));
        jPanel1.add(med3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 1530, 90, 90));
        jPanel1.add(med4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 1690, 90, 90));

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        obtenerValorArticuloComida("Guayaba");
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        obtenerValorArticuloComida("Pollo");
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        obtenerValorArticuloComida("Pastel");
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        obtenerValorArticuloComida("Dona");
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        obtenerValorArticuloComida("Huevo");
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        obtenerValorArticuloComida("Zanahoria");
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        obtenerValorArticuloComida("Sandwitch");
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        obtenerValorArticuloComida("Pera");
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        obtenerValorArticuloComida("Queso");
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn10ActionPerformed
        obtenerValorArticuloComida("Helado");
    }//GEN-LAST:event_btn10ActionPerformed

    private void btn11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn11ActionPerformed
        obtenerValorArticuloComida("Banana");
    }//GEN-LAST:event_btn11ActionPerformed

    private void btn12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn12ActionPerformed
        obtenerValorArticuloComida("Cereza");
    }//GEN-LAST:event_btn12ActionPerformed

    private void btn13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn13ActionPerformed
        obtenerValorArticuloComida("Aguacate");
    }//GEN-LAST:event_btn13ActionPerformed

    private void btn14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn14ActionPerformed
        obtenerValorArticuloComida("Cafe");
    }//GEN-LAST:event_btn14ActionPerformed

    private void btn15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn15ActionPerformed
        obtenerValorArticuloComida("Quiwi");
    }//GEN-LAST:event_btn15ActionPerformed

    private void btn16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn16ActionPerformed
        obtenerValorArticuloComida("Fresa");
    }//GEN-LAST:event_btn16ActionPerformed

    private void btn17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn17ActionPerformed
        obtenerValorArticuloComida("Pan con mermelada");
    }//GEN-LAST:event_btn17ActionPerformed

    private void btn18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn18ActionPerformed
        obtenerValorArticuloComida("Agua");
    }//GEN-LAST:event_btn18ActionPerformed

    private void btn19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn19ActionPerformed
        obtenerValorArticuloComida("Sandia");
    }//GEN-LAST:event_btn19ActionPerformed

    private void btn20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn20ActionPerformed
        obtenerValorArticuloComida("Pancakes");
    }//GEN-LAST:event_btn20ActionPerformed

    private void btn21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn21ActionPerformed
        obtenerValorArticuloComida("Sushi");
    }//GEN-LAST:event_btn21ActionPerformed

    private void btn22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn22ActionPerformed
        obtenerValorArticuloComida("Hot dog");
    }//GEN-LAST:event_btn22ActionPerformed

    private void btn23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn23ActionPerformed
        obtenerValorArticuloComida("Coctel de fresa");
    }//GEN-LAST:event_btn23ActionPerformed

    private void btn24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn24ActionPerformed
        obtenerValorArticuloComida("Coctel de cereza");
    }//GEN-LAST:event_btn24ActionPerformed

    private void btn25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn25ActionPerformed
        obtenerValorArticuloComida("Jugo de naranja");
    }//GEN-LAST:event_btn25ActionPerformed

    private void btn26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn26ActionPerformed
        obtenerValorArticuloComida("Manzana roja");
    }//GEN-LAST:event_btn26ActionPerformed

    private void btn27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn27ActionPerformed
        obtenerValorArticuloComida("Manzana amarilla");
    }//GEN-LAST:event_btn27ActionPerformed

    private void btn28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn28ActionPerformed
        obtenerValorArticuloMedicina("Pastillas");
    }//GEN-LAST:event_btn28ActionPerformed

    private void btn29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn29ActionPerformed
        obtenerValorArticuloMedicina("Frasco de pastillas");
    }//GEN-LAST:event_btn29ActionPerformed

    private void btn30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn30ActionPerformed
        obtenerValorArticuloMedicina("Inyeccion");
    }//GEN-LAST:event_btn30ActionPerformed

    private void btn31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn31ActionPerformed
        obtenerValorArticuloMedicina("Botiquin");
    }//GEN-LAST:event_btn31ActionPerformed

    private void btnLobbyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLobbyActionPerformed
        objConexion.close();
        Mundo.getMouseClicked().reproducirEnHiloNuevo(false);
        Mundo.getTemporizador().start();
        
        this.dispose();

        Lobby ventanaLobby = new Lobby();
        Mundo.setView(ventanaLobby);
      
       
    }//GEN-LAST:event_btnLobbyActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tienda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn10;
    private javax.swing.JButton btn11;
    private javax.swing.JButton btn12;
    private javax.swing.JButton btn13;
    private javax.swing.JButton btn14;
    private javax.swing.JButton btn15;
    private javax.swing.JButton btn16;
    private javax.swing.JButton btn17;
    private javax.swing.JButton btn18;
    private javax.swing.JButton btn19;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn20;
    private javax.swing.JButton btn21;
    private javax.swing.JButton btn22;
    private javax.swing.JButton btn23;
    private javax.swing.JButton btn24;
    private javax.swing.JButton btn25;
    private javax.swing.JButton btn26;
    private javax.swing.JButton btn27;
    private javax.swing.JButton btn28;
    private javax.swing.JButton btn29;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn30;
    private javax.swing.JButton btn31;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnLobby;
    private javax.swing.JLabel etiquetaMonedas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel list1;
    private javax.swing.JLabel list2;
    private javax.swing.JLabel list3;
    private javax.swing.JLabel med1;
    private javax.swing.JLabel med2;
    private javax.swing.JLabel med3;
    private javax.swing.JLabel med4;
    // End of variables declaration//GEN-END:variables
}
