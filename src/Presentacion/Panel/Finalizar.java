/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Panel;

import Negocio.Desing;
import Negocio.LectProp;
import Presentacion.Login;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author andyv
 */
public class Finalizar extends javax.swing.JPanel {
    private JPanel p1=new JPanel();
    private JFrame frm=new JFrame();
    private Desing ds=new Desing();
    private LectProp lp=new LectProp(getClass().getResource("/Data/Inicio.properties").getPath());
    
    public Finalizar() {
        initComponents();
    }
    
    public void pImage(){
        ds.AsignarImagen(lblImage);
    }

    public void Panel(JPanel p1,JFrame frm){
        this.p1=p1;
        this.frm=frm;
    }
    
    public void Pripiedad(){
    lp.Escritura("Carga.Login", "true");
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnAnterior = new ButtonSpecial.JbtnRadius.JButtonRadius();
        btnSiguiente = new ButtonSpecial.JbtnRadius.JButtonRadius();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setToolTipText("");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 117, 34, 38));

        btnAnterior.setBackground(new java.awt.Color(0, 102, 255));
        btnAnterior.setBorder(null);
        btnAnterior.setForeground(new java.awt.Color(255, 255, 255));
        btnAnterior.setText("Anterior");
        btnAnterior.setColorBackground(new java.awt.Color(0, 102, 255));
        btnAnterior.setColorClick(new java.awt.Color(51, 204, 255));
        btnAnterior.setColorOver(new java.awt.Color(51, 153, 255));
        btnAnterior.setColorText(new java.awt.Color(255, 255, 255));
        btnAnterior.setRadius(15);
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        add(btnAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 381, 107, 29));

        btnSiguiente.setBackground(new java.awt.Color(0, 102, 255));
        btnSiguiente.setBorder(null);
        btnSiguiente.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguiente.setText("Siguiente");
        btnSiguiente.setColorBackground(new java.awt.Color(0, 102, 255));
        btnSiguiente.setColorClick(new java.awt.Color(51, 204, 255));
        btnSiguiente.setColorOver(new java.awt.Color(51, 153, 255));
        btnSiguiente.setColorText(new java.awt.Color(255, 255, 255));
        btnSiguiente.setRadius(15);
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 380, 113, 29));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("<html>Se realizara las configuraciones para su mejor uso de la aplicacion. Presione siguiente:</html>\n");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 400, 34));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("<html>Muchas gracias por elegir este programa</html>\n");
        jLabel3.setToolTipText("");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 480, 110));

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Libro2.png"))); // NOI18N
        add(lblImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 390, 410));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        this.setVisible(false);
        p1.setVisible(true);
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        this.setVisible(false);
        frm.dispose();
        Pripiedad();
        new Login().setVisible(true);
    }//GEN-LAST:event_btnSiguienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ButtonSpecial.JbtnRadius.JButtonRadius btnAnterior;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblImage;
    // End of variables declaration//GEN-END:variables
}
