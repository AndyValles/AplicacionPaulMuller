/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Modal;

import java.awt.Color;
import javax.swing.JFrame;


/**
 *
 * @author andyv
 */
public class modalPrincipal extends javax.swing.JDialog {

    private JFrame frm;
     public modalPrincipal(java.awt.Frame parent, boolean modal) {
         super(parent, modal);
         initComponents();
         this.frm=(JFrame) parent;
         setBackground(new Color(0,0,0,0));
         this.setLocationRelativeTo(this);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageAvatar1 = new swing.ImageAvatar();
        panelRound1 = new test.PanelRound();
        lblDes = new javax.swing.JLabel();
        panelRound2 = new test.PanelRound();
        imgModo = new swing.ImageAvatar();
        btnAgregar = new ButtonSpecial.JbtnRadius.JButtonRadius();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(250, 250, 250));
        panelRound1.setRoundBottomLeft(30);
        panelRound1.setRoundBottomRight(30);
        panelRound1.setRoundTopLeft(30);
        panelRound1.setRoundTopRight(30);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDes.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblDes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDes.setText("<html>El usuario registrado se encuentra en la lista de usuarios pero no pertenece a estudiante,egresado o personal, por favor comunicarse con la administración para su habilitación de entrada.<html>");
        panelRound1.add(lblDes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 380, 60));

        panelRound2.setBackground(new java.awt.Color(255, 0, 0));
        panelRound2.setRoundTopLeft(30);
        panelRound2.setRoundTopRight(30);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imgModo.setBackground(new java.awt.Color(255, 255, 255));
        imgModo.setForeground(new java.awt.Color(102, 102, 255));
        imgModo.setBorderSize(2);
        imgModo.setGradientColor1(new java.awt.Color(255, 255, 255));
        imgModo.setGradientColor2(new java.awt.Color(255, 255, 255));
        imgModo.setImage(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Mal_w.png"))); // NOI18N
        panelRound2.add(imgModo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 130, 120));

        panelRound1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 140));

        btnAgregar.setBackground(new java.awt.Color(255, 0, 0));
        btnAgregar.setBorder(null);
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Salir");
        btnAgregar.setColorBackground(new java.awt.Color(51, 153, 255));
        btnAgregar.setColorClick(new java.awt.Color(102, 204, 255));
        btnAgregar.setColorOver(new java.awt.Color(102, 204, 255));
        btnAgregar.setColorText(new java.awt.Color(255, 255, 255));
        btnAgregar.setFocusPainted(false);
        btnAgregar.setRadius(15);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        panelRound1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 160, 40));

        lblTitulo.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Mensaje");
        panelRound1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 340, 30));

        getContentPane().add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 290));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
      frm.dispose();
    }//GEN-LAST:event_btnAgregarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ButtonSpecial.JbtnRadius.JButtonRadius btnAgregar;
    private swing.ImageAvatar imageAvatar1;
    private swing.ImageAvatar imgModo;
    private javax.swing.JLabel lblDes;
    private javax.swing.JLabel lblTitulo;
    private test.PanelRound panelRound1;
    private test.PanelRound panelRound2;
    // End of variables declaration//GEN-END:variables
}
