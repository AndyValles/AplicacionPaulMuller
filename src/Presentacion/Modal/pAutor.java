/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Modal;

import DialogSpecial.JDialogSpecial.JDialogCustom;
import Entidad.Autor;
import Negocio.NAutor;
import Negocio.NPais;
import Negocio.ValidateText;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author andyv
 */
public class pAutor extends JDialogCustom {
    
    private NAutor aa=new NAutor();
    private NPais pp=new NPais();
    
    private ValidateText vl=new ValidateText();
    private JFrame frm=null;
    
    private boolean isInsert=true;
    private String Codigo;
    
    public pAutor(java.awt.Frame parent, boolean modal,boolean isInsert) {
        super(parent, modal);
        
        this.frm=(JFrame) parent;
        this.isInsert=isInsert;
        
        initComponents();
        
        setSize(parent.getSize());
        
        Iniciar();
        
        this.setBackground(new Color(0,0,0,100));
    }
    
    private void Iniciar(){
        if(cboPais.getItemCount()>0){cboPais.removeAllItems();}
        for(Object o:pp.cboPais()){cboPais.addItem(o);}
    }
    
    private Autor Items(){
        Autor a=new Autor();
        if(Codigo!=null){a.setCodigo(Integer.parseInt(Codigo));}
        a.setNombre(txtNombre.getText());
        a.setApePA(txtApePat.getText());
        a.setApeMA(txtApeMat.getText());
        a.setPais(cboPais.getSelectedIndex()+1);
        return a;
    }
    
     private boolean Valida(){
       if(!txtNombre.getText().isEmpty()){
                   return true;
        }else{
            vl.valText(txtNombre, lblENombre,false);
        }
        
        return false;
    }
    
    private boolean Insertar(){
        if(Valida()){if(aa.Insertar(Items())){return true;}}
        return false;
    }
    
    private boolean Modificar(){
       if(Valida()){
            if(aa.Actualizar(Items())){return true;}
       }
        return false;
    }
    
     public void IniItems(ArrayList item){
        if(item!=null){
            Codigo=item.get(0)+"";
            txtNombre.setText(item.get(1)+"");
            txtApePat.setText(item.get(2)+"");
            txtApeMat.setText(item.get(3)+"");
            cboPais.setSelectedItem(item.get(4));
        }
    }
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScroll1 = new ScrollPaneSpecial.JScrollPane.JScroll();
        jPanel1 = new javax.swing.JPanel();
        jButtonHeader11 = new ButtonSpecial.JbtnHeader.JButtonHeader();
        jLabel1 = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        Autor2 = new javax.swing.JLabel();
        txtNombre = new textfield.TextField();
        txtApePat = new textfield.TextField();
        txtApeMat = new textfield.TextField();
        cboPais = new combo_suggestion.ComboBoxSuggestion();
        btnAgregarPa = new ButtonSpecial.JbtnRadius.JButtonRadius();
        btnAgregar = new ButtonSpecial.JbtnRadius.JButtonRadius();
        lblEApePat = new javax.swing.JLabel();
        lblENombre = new javax.swing.JLabel();
        lblEApeMat = new javax.swing.JLabel();
        lblEPais = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(846, 525));
        setUndecorated(true);

        jScroll1.setScrollBackground(new java.awt.Color(51, 204, 255));
        jScroll1.setScrollClick(new java.awt.Color(153, 204, 255));
        jScroll1.setScrollOver(new java.awt.Color(51, 204, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(275, 525));

        jButtonHeader11.setBackground(new java.awt.Color(255, 255, 255));
        jButtonHeader11.setBorder(null);
        jButtonHeader11.setText("X");
        jButtonHeader11.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButtonHeader11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHeader11ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Autor");

        lblImage.setText("jLabel2");

        Autor2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Autor2.setForeground(new java.awt.Color(153, 153, 153));
        Autor2.setText("Pais");

        txtNombre.setLabelText("Nombre");
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtApePat.setLabelText("Apellido Paterno");
        txtApePat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApePatKeyTyped(evt);
            }
        });

        txtApeMat.setLabelText("Apellido Materno");
        txtApeMat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApeMatKeyTyped(evt);
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

        lblEApePat.setForeground(new java.awt.Color(255, 0, 0));

        lblENombre.setForeground(new java.awt.Color(255, 0, 0));

        lblEApeMat.setForeground(new java.awt.Color(255, 0, 0));

        lblEPais.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonHeader11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEApePat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblENombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEApeMat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Autor2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApeMat, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApePat, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cboPais, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAgregarPa, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEPais, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(jButtonHeader11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblENombre, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApePat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEApePat, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApeMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEApeMat, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Autor2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarPa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEPais, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScroll1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 539, Short.MAX_VALUE)
                .addComponent(jScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScroll1, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        vl.valText(txtNombre, lblENombre,true);
        vl.valText(txtNombre, 29, evt);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApePatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApePatKeyTyped
       vl.valText(txtApePat, lblEApePat,true);
       vl.valText(txtApePat, 29, evt);
    }//GEN-LAST:event_txtApePatKeyTyped

    private void txtApeMatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApeMatKeyTyped
        vl.valText(txtApeMat, lblEApeMat,true);
        vl.valText(txtApeMat, 29, evt);
    }//GEN-LAST:event_txtApeMatKeyTyped

    private void btnAgregarPaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPaActionPerformed
        new PDistrito(frm, true,"País",true).setVisible(true);
    }//GEN-LAST:event_btnAgregarPaActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
    if(cboPais.getItemCount()>0){
           if(isInsert){
                if(Insertar()){
                    this.dispose();
                }
           }else{
                if(Modificar()){
                    this.dispose();
                }
           }
    }else{lblEPais.setText("Debe agregar un país");}
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jButtonHeader11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHeader11ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonHeader11ActionPerformed

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
            java.util.logging.Logger.getLogger(pAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                pAutor dialog = new pAutor(new javax.swing.JFrame(), true,true);
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
    private ButtonSpecial.JbtnHeader.JButtonHeader jButtonHeader11;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private ScrollPaneSpecial.JScrollPane.JScroll jScroll1;
    private javax.swing.JLabel lblEApeMat;
    private javax.swing.JLabel lblEApePat;
    private javax.swing.JLabel lblENombre;
    private javax.swing.JLabel lblEPais;
    private javax.swing.JLabel lblImage;
    private textfield.TextField txtApeMat;
    private textfield.TextField txtApePat;
    private textfield.TextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
