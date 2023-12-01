/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Modal;

import DialogSpecial.JDialogSpecial.JDialogCustom;
import Entidad.Editorial;
import Negocio.NBusqueda;
import Negocio.NEditorial;
import Negocio.NPais;
import Negocio.ValidateText;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author andyv
 */
public class pEditorial extends JDialogCustom {
    
    private ValidateText vl=new ValidateText();
    
    private NEditorial ee=new NEditorial();
    private NPais pp=new NPais();
    
    private JFrame frm=null;
    
    private boolean isInsert=true;
    private String Codigo;
    
    public pEditorial(java.awt.Frame parent, boolean modal,boolean isInsert) {
        super(parent, modal);
        
        this.frm=(JFrame) parent;
        this.isInsert=isInsert;
        
        initComponents();
        
        setSize(parent.getSize());
        setBackground(new Color(0,0,0,150));
        
        Iniciar();
    }
    
     private void Iniciar(){
        if(cboPais.getItemCount()>0){cboPais.removeAllItems();}
        for(Object o:pp.cboPais()){cboPais.addItem(o);}
    }
    
    private Editorial Items(){
        Editorial e=new Editorial();
        if(Codigo!=null){e.setCodigo(Integer.parseInt(Codigo));}
        e.setNombre(txtNombre.getText());
        e.setDireccion(txtDir.getText());
        e.setTelefono(txtTelefono.getText());
        e.setCorreo(txtCorreo.getText());
        e.setPais(cboPais.getSelectedIndex()+1);
        return e;
    }
    
    private boolean Valida(){
        if(!txtNombre.getText().isEmpty()){
                if(!txtTelefono.getText().isEmpty()){
                     if(!txtCorreo.getText().isEmpty()){
                            return true;
                     }else{
                        vl.valText(txtCorreo, lblECorreo,false);
                     }
                }else{
                    vl.valText(txtTelefono, lblETelefono,false);
                }
        }else{
            vl.valText(txtNombre, lblENombre,false);
        }
        
        return false;
    }
    
    private boolean Insertar(){
       
      if(Valida()){
        if(ee.Insertar(Items())){return true;}
       }
        return false;
    }
    
    private boolean Modificar(){
       if(Valida()){
        if(ee.Actualizar(Items())){return true;}
       }
        return false;
    }
    
    private void Correo(){
    String correo=txtCorreo.getText().trim();
    if(!correo.isEmpty()){
           correo=correo.replaceAll("@gmail.com","");
            txtCorreo.setText(correo+"@gmail.com");
        }
    
    }
    
    public void IniItems(ArrayList item){
        if(item!=null){
            Codigo=item.get(0)+"";
            txtNombre.setText(item.get(1)+"");
            txtDir.setText(item.get(2)+"");
            txtTelefono.setText(item.get(3)+"");
            txtCorreo.setText(item.get(4)+"");
            cboPais.setSelectedItem(item.get(5));
        }
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScroll1 = new ScrollPaneSpecial.JScrollPane.JScroll();
        jPanel1 = new javax.swing.JPanel();
        txtNombre = new textfield.TextField();
        jButtonHeader1 = new ButtonSpecial.JbtnHeader.JButtonHeader();
        lblImage = new javax.swing.JLabel();
        btnAgregar = new ButtonSpecial.JbtnRadius.JButtonRadius();
        lblCat = new javax.swing.JLabel();
        lblENombre = new javax.swing.JLabel();
        txtDir = new textfield.TextField();
        txtTelefono = new textfield.TextField();
        txtCorreo = new textfield.TextField();
        cboPais = new combo_suggestion.ComboBoxSuggestion();
        btnAgregarPa = new ButtonSpecial.JbtnRadius.JButtonRadius();
        Autor2 = new javax.swing.JLabel();
        lblETelefono = new javax.swing.JLabel();
        lblECorreo = new javax.swing.JLabel();
        lblEPais = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(846, 525));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtNombre.setLabelText("Nombre");
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jButtonHeader1.setBackground(new java.awt.Color(255, 255, 255));
        jButtonHeader1.setBorder(null);
        jButtonHeader1.setText("X");
        jButtonHeader1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButtonHeader1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHeader1ActionPerformed(evt);
            }
        });

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Distrito.png"))); // NOI18N
        lblImage.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnAgregar.setBackground(new java.awt.Color(51, 153, 255));
        btnAgregar.setBorder(null);
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.setColorBackground(new java.awt.Color(51, 153, 255));
        btnAgregar.setColorClick(new java.awt.Color(102, 204, 255));
        btnAgregar.setColorOver(new java.awt.Color(51, 153, 255));
        btnAgregar.setColorText(new java.awt.Color(255, 255, 255));
        btnAgregar.setFocusPainted(false);
        btnAgregar.setRadius(15);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        lblCat.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblCat.setText("Editorial");

        lblENombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblENombre.setForeground(new java.awt.Color(255, 0, 0));

        txtDir.setLabelText("Dirección");
        txtDir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDirKeyTyped(evt);
            }
        });

        txtTelefono.setLabelText("Telefono");
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        txtCorreo.setLabelText("Correo");
        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCorreoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoFocusLost(evt);
            }
        });
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoKeyTyped(evt);
            }
        });

        cboPais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cboPaisMouseEntered(evt);
            }
        });

        btnAgregarPa.setBackground(new java.awt.Color(51, 204, 255));
        btnAgregarPa.setBorder(null);
        btnAgregarPa.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarPa.setText("Agregar Pais");
        btnAgregarPa.setColorBackground(new java.awt.Color(51, 204, 255));
        btnAgregarPa.setColorClick(new java.awt.Color(0, 153, 255));
        btnAgregarPa.setColorOver(new java.awt.Color(102, 204, 255));
        btnAgregarPa.setColorText(new java.awt.Color(255, 255, 255));
        btnAgregarPa.setFocusPainted(false);
        btnAgregarPa.setRadius(15);
        btnAgregarPa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPaActionPerformed(evt);
            }
        });

        Autor2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Autor2.setForeground(new java.awt.Color(153, 153, 153));
        Autor2.setText("Pais");

        lblETelefono.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblETelefono.setForeground(new java.awt.Color(255, 0, 0));

        lblECorreo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblECorreo.setForeground(new java.awt.Color(255, 0, 0));

        lblEPais.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(lblCat)
                        .addGap(93, 93, 93)
                        .addComponent(jButtonHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblENombre, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblETelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblECorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblEPais, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Autor2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cboPais, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAgregarPa, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 242, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblENombre, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblETelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblECorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Autor2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarPa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEPais, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jScroll1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 498, Short.MAX_VALUE)
                .addComponent(jScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScroll1, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        vl.valText(txtNombre, lblENombre, true);
        vl.valText(txtNombre, 49, evt);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void jButtonHeader1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHeader1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonHeader1ActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(isInsert){
            if(Insertar()){
                this.dispose();
            }
        }else{
            if(Modificar()){
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtDirKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDirKeyTyped
        vl.valText(txtDir, lblENombre, true);
        vl.valText(txtDir, 49, evt);
    }//GEN-LAST:event_txtDirKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        vl.valNumber(evt);
        vl.valText(txtTelefono, lblENombre, true);
        vl.valText(txtTelefono, 49, evt);
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyTyped
        vl.valText(txtCorreo, lblENombre, true);
        vl.valText(txtCorreo, 49, evt);
    }//GEN-LAST:event_txtCorreoKeyTyped

    private void btnAgregarPaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPaActionPerformed
        new PDistrito(frm, true,"País",true).setVisible(true);
    }//GEN-LAST:event_btnAgregarPaActionPerformed

    private void txtCorreoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusGained
        String correo=txtCorreo.getText().trim();
        if(!txtCorreo.getText().isEmpty()){
            txtCorreo.setText(correo.replaceAll("@gmail.com",""));
        }
    }//GEN-LAST:event_txtCorreoFocusGained

    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost
       Correo();
    }//GEN-LAST:event_txtCorreoFocusLost

    private void cboPaisMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboPaisMouseEntered
        Iniciar();
    }//GEN-LAST:event_cboPaisMouseEntered

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
            java.util.logging.Logger.getLogger(pEditorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pEditorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pEditorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pEditorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                pEditorial dialog = new pEditorial(new javax.swing.JFrame(), true,true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Autor2;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnAgregar;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnAgregarPa;
    private combo_suggestion.ComboBoxSuggestion cboPais;
    private ButtonSpecial.JbtnHeader.JButtonHeader jButtonHeader1;
    private javax.swing.JPanel jPanel1;
    private ScrollPaneSpecial.JScrollPane.JScroll jScroll1;
    private javax.swing.JLabel lblCat;
    private javax.swing.JLabel lblECorreo;
    private javax.swing.JLabel lblENombre;
    private javax.swing.JLabel lblEPais;
    private javax.swing.JLabel lblETelefono;
    private javax.swing.JLabel lblImage;
    private textfield.TextField txtCorreo;
    private textfield.TextField txtDir;
    private textfield.TextField txtNombre;
    private textfield.TextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
