/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Entidad.Usuario;
import Negocio.NUsuario;
import Negocio.Desing;
import Presentacion.Modal.VerifAdminist;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author andyv
 */
public class Login extends javax.swing.JFrame {
    
    private Desing ds=new Desing();
    private NUsuario uu=new NUsuario();
    private int intento=0;
    public Login() {
        initComponents();
        Iniciar();
    }
    
    private void Iniciar(){
            
            header.Inicio(this,false);
            this.setBackground(new Color(255,255,255));
            this.setLocationRelativeTo(this);
            pSombra.setBackground(new Color(0,102,255,100));
            btnAdmin.setVisible(false);
            IniciarImage();
    }
    
    private void IniciarImage(){
        ds.AsignarImagen(lFondo);
        ds.AsignarImagen(lImage);
     }
    
    private Usuario Items(){
       Usuario u=new Usuario();
       String txt="";    
       for(char c:txtContra.getPassword()){txt=txt+c;}
       u.setUsuario(txtUsuario.getText());
       u.setContraseña(txt);
       return u;
    }
    
    private void Login(){
        String user=txtUsuario.getText().trim();
        String txt="";
         for(char c:txtContra.getPassword()){txt=txt+c;}//obtiene los valores de la contraseña
         if(!user.isEmpty() && !txt.trim().isEmpty()){//verifica que las casillas no se encuentren vacias
                
             if(uu.Login(Items())){//agrega la informacion 
                    if(uu.BuscarBool(user,uu.SEARCH_USER)){//busqueda del usuario en la base de datos
                        new frmPrograma((String) uu.Lectura().get(0)[0]).setVisible(true);//Envio de datos
                        this.dispose();
                    }
             }else{
                    lELogin.setText("<html>El usuario o contraseña son incorrectos por favor"
                            + " verificar y ingresa nuevamente</html>");
                    txtUsuario.requestFocus(); 
                    txtUsuario.setLineColor(Color.red); 
                    txtContra.setLineColor(Color.red);
                     
                      intento+=1;
                      if(intento==3){btnAdmin.setVisible(true);}
                }
       }else{
             if(user.isEmpty()){
                txtUsuario.requestFocus();
                txtUsuario.setLineColor(Color.red);
                lEUsuario.setText("Esta casilla no debe estar vacia");
             }
             if(txt.isEmpty()){
                 if(!user.isEmpty()){txtContra.requestFocus();}
                txtContra.setLineColor(Color.red);
                lEContra.setText("Esta casilla no debe estar vacia");
             }
       }
    
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pSombra = new javax.swing.JPanel();
        lImage = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtContra = new textfield.PasswordField();
        txtUsuario = new textfield.TextField();
        btnIngresar = new ButtonSpecial.JbtnRadius.JButtonRadius();
        lEContra = new javax.swing.JLabel();
        lELogin = new javax.swing.JLabel();
        lEUsuario = new javax.swing.JLabel();
        btnAdmin = new ButtonSpecial.JbtnRadius.JButtonRadius();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lFondo = new javax.swing.JLabel();
        header = new Presentacion.Components.WindowHeader();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pSombra.setBackground(new java.awt.Color(0, 102, 255));

        lImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logo.png"))); // NOI18N
        lImage.setText("jLabel1");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("Iniciar Sesión");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, -1, -1));

        txtContra.setLabelText("Contraseña:");
        txtContra.setShowAndHide(true);
        txtContra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContraKeyTyped(evt);
            }
        });
        jPanel2.add(txtContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 324, -1));

        txtUsuario.setLabelText("Usuarios");
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });
        jPanel2.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 324, -1));

        btnIngresar.setBackground(new java.awt.Color(0, 102, 255));
        btnIngresar.setBorder(null);
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("Ingresar");
        btnIngresar.setColorClick(new java.awt.Color(102, 204, 255));
        btnIngresar.setColorOver(new java.awt.Color(51, 204, 255));
        btnIngresar.setColorText(new java.awt.Color(255, 255, 255));
        btnIngresar.setColorbackground(new java.awt.Color(0, 102, 255));
        btnIngresar.setFocusPainted(false);
        btnIngresar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnIngresar.setRadius(15);
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel2.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 200, 40));

        lEContra.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lEContra.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(lEContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 340, 30));

        lELogin.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lELogin.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(lELogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 340, 50));

        lEUsuario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lEUsuario.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(lEUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 350, 20));

        btnAdmin.setBackground(new java.awt.Color(0, 102, 255));
        btnAdmin.setBorder(null);
        btnAdmin.setForeground(new java.awt.Color(255, 255, 255));
        btnAdmin.setText("Soy Admin");
        btnAdmin.setColorBackground(new java.awt.Color(0, 102, 255));
        btnAdmin.setColorClick(new java.awt.Color(0, 204, 255));
        btnAdmin.setColorOver(new java.awt.Color(51, 153, 255));
        btnAdmin.setColorText(new java.awt.Color(255, 255, 255));
        btnAdmin.setFocusPainted(false);
        btnAdmin.setRadius(15);
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });
        jPanel2.add(btnAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 140, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("<html>Visita el programa de biblioteca para la vista de los libros y tesis</html>");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("<html> Si usted no tiene una cuenta verificada o se a olvidado su contraseña/usuario\n debe comunicarse con el aministrador para su correspondiente registro</html>");

        javax.swing.GroupLayout pSombraLayout = new javax.swing.GroupLayout(pSombra);
        pSombra.setLayout(pSombraLayout);
        pSombraLayout.setHorizontalGroup(
            pSombraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSombraLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pSombraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pSombraLayout.createSequentialGroup()
                        .addGroup(pSombraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lImage, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 28, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        pSombraLayout.setVerticalGroup(
            pSombraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pSombraLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(lImage, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        jPanel1.add(pSombra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 450));

        lFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/open-book.jpg"))); // NOI18N
        lFondo.setText("jLabel1");
        jPanel1.add(lFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 450));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 780, 450));
        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
       Login();
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
       try{new VerifAdminist(this,true).setVisible(true);}catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
    }//GEN-LAST:event_btnAdminActionPerformed

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
       lEUsuario.setText("");
       txtUsuario.setLineColor(new Color(0,102,255));
       lEUsuario.setText("");
       
       if(txtUsuario.getText().length()>=30){
           evt.consume();
       }
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtContraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraKeyTyped
       txtContra.setLineColor(new Color(0,102,255));
       lEContra.setText("");
       String txt="";
       for(char c:txtContra.getPassword()){txt=txt+c;}
       
       if(txt.length()>=50){
           evt.consume();
       }
    }//GEN-LAST:event_txtContraKeyTyped

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ButtonSpecial.JbtnRadius.JButtonRadius btnAdmin;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnIngresar;
    private Presentacion.Components.WindowHeader header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lEContra;
    private javax.swing.JLabel lELogin;
    private javax.swing.JLabel lEUsuario;
    private javax.swing.JLabel lFondo;
    private javax.swing.JLabel lImage;
    private javax.swing.JPanel pSombra;
    private textfield.PasswordField txtContra;
    private textfield.TextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
