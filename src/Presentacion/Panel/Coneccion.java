/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Panel;

import Negocio.NConeccion;
import Negocio.ValidateText;
import javax.swing.JPanel;

public class Coneccion extends javax.swing.JPanel {
    
    private JPanel ps1=new JPanel();
    private JPanel ps2=new JPanel();
    
    private NConeccion cc=new NConeccion();
    private ValidateText vl=new ValidateText();
    
    private int dato=7;
    private boolean isConected;
    
    public Coneccion() {
        initComponents();
        Iniciar();
    }

    private void Iniciar(){
        txtDir.setText(cc.DefaultConection()[0]);
        txtPuerto.setText(cc.DefaultConection()[1]);
    }
    
    public boolean Conectado(){
       String contra="";
        for(char c:txtContra.getPassword()){contra+=c;} 
        cc.Conectar(txtDir.getText(),txtPuerto.getText(),txtUsuario.getText(),contra);
       return cc.isConected();
    }
    
    public void IniciarPanels(JPanel ps1,JPanel ps2){
        this.ps1=ps1;
        this.ps2=ps2;
    }
    
    public void Coneccion(){
     String des="La conección es";
        if(Conectado()){
            des+=" exitosa";
       }else{
            des+=" fallida";
       }
        lblConeccion.setText(des);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow1 = new main.PanelShadow();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtDir = new textfield.TextField();
        testbutton = new ButtonSpecial.JbtnRadius.JButtonRadius();
        txtPuerto = new textfield.TextField();
        btnSiguiente = new ButtonSpecial.JbtnRadius.JButtonRadius();
        btnAnterior = new ButtonSpecial.JbtnRadius.JButtonRadius();
        txtUsuario = new textfield.TextField();
        txtContra = new textfield.PasswordField();
        lblEUser = new javax.swing.JLabel();
        lblEContra = new javax.swing.JLabel();
        lblConeccion = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(834, 490));
        setPreferredSize(new java.awt.Dimension(834, 490));

        panelShadow1.setBackground(new java.awt.Color(255, 255, 255));
        panelShadow1.setRadius(20);
        panelShadow1.setShadowOpacity(0.0F);
        panelShadow1.setShadowSize(10);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 255));
        jLabel2.setText("Conección de datos ");

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("<html>Realice la coneccion con el sistema principal, para el envio y recibo de datos implementadas en la base de datos</html>");

        txtDir.setText("localhost");
        txtDir.setLabelText("Hostname:");
        txtDir.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDirFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDirFocusLost(evt);
            }
        });

        testbutton.setBackground(new java.awt.Color(0, 102, 255));
        testbutton.setBorder(null);
        testbutton.setForeground(new java.awt.Color(255, 255, 255));
        testbutton.setText("Test Coneccion");
        testbutton.setColorBackground(new java.awt.Color(0, 102, 255));
        testbutton.setColorClick(new java.awt.Color(51, 204, 255));
        testbutton.setColorOver(new java.awt.Color(51, 153, 255));
        testbutton.setColorText(new java.awt.Color(255, 255, 255));
        testbutton.setFocusPainted(false);
        testbutton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        testbutton.setRadius(15);
        testbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testbuttonActionPerformed(evt);
            }
        });

        txtPuerto.setText("3306");
        txtPuerto.setLabelText("Puerto");
        txtPuerto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPuertoFocusLost(evt);
            }
        });
        txtPuerto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPuertoKeyTyped(evt);
            }
        });

        btnSiguiente.setBackground(new java.awt.Color(0, 102, 255));
        btnSiguiente.setBorder(null);
        btnSiguiente.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguiente.setText("Siguiente");
        btnSiguiente.setColorBackground(new java.awt.Color(0, 102, 255));
        btnSiguiente.setColorClick(new java.awt.Color(51, 204, 255));
        btnSiguiente.setColorOver(new java.awt.Color(51, 153, 255));
        btnSiguiente.setColorText(new java.awt.Color(255, 255, 255));
        btnSiguiente.setFocusPainted(false);
        btnSiguiente.setRadius(15);
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnAnterior.setBackground(new java.awt.Color(0, 102, 255));
        btnAnterior.setBorder(null);
        btnAnterior.setForeground(new java.awt.Color(255, 255, 255));
        btnAnterior.setText("Anterior");
        btnAnterior.setColorBackground(new java.awt.Color(0, 102, 255));
        btnAnterior.setColorClick(new java.awt.Color(51, 204, 255));
        btnAnterior.setColorOver(new java.awt.Color(51, 153, 255));
        btnAnterior.setColorText(new java.awt.Color(255, 255, 255));
        btnAnterior.setFocusPainted(false);
        btnAnterior.setRadius(15);
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        txtUsuario.setLabelText("Usuario:");
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });

        txtContra.setLabelText("Contraseña:");
        txtContra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContraKeyTyped(evt);
            }
        });

        lblEUser.setForeground(new java.awt.Color(255, 0, 0));

        lblEContra.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblEUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblConeccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelShadow1Layout.createSequentialGroup()
                                        .addGap(162, 162, 162)
                                        .addComponent(lblEContra, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                                    .addGroup(panelShadow1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(testbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelShadow1Layout.createSequentialGroup()
                                        .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(162, 162, 162)
                                        .addComponent(txtPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelShadow1Layout.createSequentialGroup()
                                        .addGap(402, 402, 402)
                                        .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(148, 148, 148))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEContra, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                    .addComponent(lblEUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(testbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(lblConeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void testbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testbuttonActionPerformed
      Coneccion();
    }//GEN-LAST:event_testbuttonActionPerformed

    private void txtDirFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDirFocusGained
        if(txtDir.getText().equals("localhost")){
            txtDir.setText(" ");
        }
    }//GEN-LAST:event_txtDirFocusGained

    private void txtDirFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDirFocusLost

        if(txtDir.getText().trim().isEmpty()){
            txtDir.setText("localhost");
        }
    }//GEN-LAST:event_txtDirFocusLost

    private void txtPuertoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPuertoFocusLost
      if(txtPuerto.getText().isEmpty()){
          txtPuerto.setText("3306");
      }
    }//GEN-LAST:event_txtPuertoFocusLost

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        this.setVisible(false);
        ps1.setVisible(true);
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
      if(!txtUsuario.getText().isEmpty()){
          if(txtContra.getPassword().length>0){
              if(Conectado()){
                this.setVisible(false);
                ps2.setVisible(true);
             }else{
                  lblConeccion.setText("La conección es fallida");
             }
          }else{
              lblEContra.setText("Esta casilla no puede estar vacia");
          }
      }else{
          vl.valText(txtDir,lblEUser, false);
      }
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        lblEUser.setText("");
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtContraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraKeyTyped
       lblEContra.setText("");
    }//GEN-LAST:event_txtContraKeyTyped

    private void txtPuertoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPuertoKeyTyped
        vl.valNumber(evt);
    }//GEN-LAST:event_txtPuertoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ButtonSpecial.JbtnRadius.JButtonRadius btnAnterior;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblConeccion;
    private javax.swing.JLabel lblEContra;
    private javax.swing.JLabel lblEUser;
    private main.PanelShadow panelShadow1;
    private ButtonSpecial.JbtnRadius.JButtonRadius testbutton;
    private textfield.PasswordField txtContra;
    private textfield.TextField txtDir;
    private textfield.TextField txtPuerto;
    private textfield.TextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
