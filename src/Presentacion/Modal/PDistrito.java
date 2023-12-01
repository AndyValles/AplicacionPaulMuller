/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Modal;

import DialogSpecial.JDialogSpecial.JDialogCustom;
import Entidad.Cargo;
import Entidad.Carrera;
import Entidad.Categoria;
import Entidad.Distrito;
import Entidad.Pais;
import Entidad.Profesion;
import Negocio.NCargo;
import Negocio.NCarrera;
import Negocio.NCategoria;
import Negocio.NDistrito;
import Negocio.NPais;
import Negocio.NProfesion;
import Negocio.Desing;
import Negocio.ValidateText;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JCheckBox;

/**
 *
 * @author andyv
 */
public class PDistrito extends JDialogCustom {
    
    private Desing ds=new Desing();
    private ValidateText vl=new ValidateText();
    
    private NDistrito dd=new NDistrito();
    private NCarrera cc=new NCarrera();
    private NProfesion pro=new NProfesion();
    private NCargo car=new NCargo();
    private NCategoria cat=new NCategoria();
    private NPais pa=new NPais();
    
    private String txt="";
    private Object Codigo;
    
    private boolean isInsert=true;
    private boolean isEst=false;
    
    public PDistrito(java.awt.Frame parent, boolean modal,String txt,boolean isInsert) {
        super(parent, modal);
        
        this.isInsert=isInsert;
        this.txt=txt;
        
        initComponents();
        setSize(parent.getSize());
        
        IniImage();
        IniCBO();
        
        
        lblCat.setText(txt);
    }
    
    private void IniCBO(){
        cboEstado.addItem("Activo");
        cboEstado.addItem("Desactivo");
    }
    
   
    
    private void Limpiar(){
        txtNombre.setText("");
        cboEstado.setSelectedIndex(0);
    }
    
    private void IniImage(){
        setBackground(new Color(0,0,0,100));
        ds.AsignarImagen(lblImage);
    }
    
    private Carrera ItemCa(){
            Carrera  c=new Carrera();
                
                if(Codigo!=null){c.setCodigo(Integer.parseInt((String) Codigo));}
                if(cboEstado.getSelectedIndex()==0){isEst=true;}
                
                c.setNombre(txtNombre.getText());
                c.setEstado(isEst);
        return c;
    }

    private Distrito ItemD(){
            Distrito d=new Distrito();
            
                if(Codigo!=null){
                    d.setCodigo(Integer.parseInt((String) Codigo));
                }
                if(cboEstado.getSelectedIndex()==0){isEst=true;}
                
                d.setNombre(txtNombre.getText());
                d.setEstado(isEst);
        return d;
    }
    
    private Profesion ItemP(){
            Profesion p=new Profesion();
                if(Codigo!=null){
                    p.setCodigo(Integer.parseInt((String) Codigo));
                }
                if(cboEstado.getSelectedIndex()==0){isEst=true;}
                
                    p.setNombre(txtNombre.getText());
                    p.setEstado(isEst);
        return p;
    }
    
    private Cargo ItemC(){
            Cargo ca=new Cargo();
            
                if(Codigo!=null){ca.setCodigo(Integer.parseInt((String) Codigo));}
                if(cboEstado.getSelectedIndex()==0){isEst=true;}
                
                ca.setNombre(txtNombre.getText());
                ca.setEstado(isEst);
        return ca;
    }
    
     private Pais ItemPa(){
            Pais pa=new Pais();
            
                if(Codigo!=null){
                    pa.setCodigo(Integer.parseInt((String) Codigo));}
                if(cboEstado.getSelectedIndex()==0){isEst=true;}
                
                pa.setNombre(txtNombre.getText());
                pa.setEstado(isEst);
        return pa;
    }
     
     private Categoria ItemCat(){
            Categoria ca=new Categoria();
                if(Codigo!=null){ca.setCodigo(Integer.parseInt((String) Codigo));}
                if(cboEstado.getSelectedIndex()==0){isEst=true;}
                
                ca.setNombre(txtNombre.getText());
                ca.setEstado(isEst);
        return ca;
    }
    
    private boolean Insertar(){
        if(!txtNombre.getText().isEmpty()){
            
            if(txt.equals("Distrito") && dd.Insertar(ItemD())){return true;}
            else if (txt.equals("Carrera") && cc.Insertar(ItemCa())){return  true;}
            else if (txt.equals("Cargo") && car.Insertar(ItemC())){return true;}
            else if (txt.equals("Profesión") && pro.Insertar(ItemP())){return true;}
            else if (txt.equals("País") && pa.Insertar(ItemPa())){return true;}
            else if (txt.equals("Categoria") && cat.Insertar(ItemCat())){return true;}
        }else{
            txtNombre.setLineColor(new Color(255,0,0));
            txtNombre.requestFocus(true);
            lblENomb.setText("Esta casilla no debe estar vacia");
        }
        
        return false;
    }
    
     private boolean Modificar(){
        if(!txtNombre.getText().isEmpty()){
            
            if(txt.equals("Distrito") && dd.Actualizar(ItemD())){return true;}
            else if (txt.equals("Carrera") && cc.Actualizar(ItemCa())){return  true;}
            else if (txt.equals("Cargo") && car.Actualizar(ItemC())){return true;}
            else if (txt.equals("Profesión") && pro.Actualizar(ItemP())){return true;}
            else if (txt.equals("País") && pa.Actualizar(ItemPa())){return true;}
            else if (txt.equals("Categoria") && cat.Actualizar(ItemCat())){return true;}
        }else{
            txtNombre.setLineColor(new Color(255,0,0));
            txtNombre.requestFocus(true);
            lblENomb.setText("Esta casilla no debe estar vacia");
        }
        
        return false;
    }
     
    public void Item(ArrayList l){
        int est=0;
        
        if(l!=null){
            Codigo=l.get(0);
            txtNombre.setText(l.get(1)+"");
            if(((JCheckBox)l.get(2)).isSelected()){
                est=1;
            }
        }
        cboEstado.setSelectedIndex(est);
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNombre = new textfield.TextField();
        cboEstado = new combobox.Combobox();
        btnSalir = new ButtonSpecial.JbtnHeader.JButtonHeader();
        lblImage = new javax.swing.JLabel();
        btnAgregar = new ButtonSpecial.JbtnRadius.JButtonRadius();
        lblCat = new javax.swing.JLabel();
        lblENomb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtNombre.setLabelText("Nombre");
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        cboEstado.setLabeText("Estado");

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setBorder(null);
        btnSalir.setText("X");
        btnSalir.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
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

        lblCat.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblCat.setText("Distrito");

        lblENomb.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblENomb.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblCat)
                        .addGap(68, 68, 68)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblENomb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCat)))
                .addGap(18, 18, 18)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblENomb, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 571, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       
        if(isInsert){
            if(Insertar()){
                 this.dispose();}
        }else{
            if(Modificar()){
                 this.dispose();
                }
            }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        txtNombre.setLineColor(new Color(3,155,216));
        lblENomb.setText("");
        vl.valText(txtNombre, 49, evt);
    }//GEN-LAST:event_txtNombreKeyTyped

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
            java.util.logging.Logger.getLogger(PDistrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PDistrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PDistrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PDistrito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PDistrito dialog = new PDistrito(new javax.swing.JFrame(), true,"",true);
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
    private ButtonSpecial.JbtnRadius.JButtonRadius btnAgregar;
    private ButtonSpecial.JbtnHeader.JButtonHeader btnSalir;
    private combobox.Combobox cboEstado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCat;
    private javax.swing.JLabel lblENomb;
    private javax.swing.JLabel lblImage;
    private textfield.TextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
