/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Components;

import Negocio.Desing;
import java.awt.Color;
import java.awt.event.MouseListener;


public class Opcion1 extends javax.swing.JPanel {
     
    private Color pbBackGround=Color.RED;
    private Color SelBackGround=Color.RED;
    private Desing ds=new Desing();
    
    private String ruta="/Imagens/";
    
    public Opcion1() {
        initComponents();
        setBackground(new Color(0,0,0,0));
        
        prBack.setBackground(pbBackGround);
        
    }

   
    public void Select(MouseListener l){
    btnPress.addMouseListener(l);
    }
    
    public void Iniciar(String image,String titulo){
     ds.AsignarImagen(lblImage, ruta+image);
     lblTitle.setText(titulo);
     lblTexto.setText("<html>Reporte y exportacion de "+titulo+"</html>");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        prBack = new test.PanelRound();
        btnPress = new javax.swing.JLabel();
        lblTexto = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();

        setBackground(new java.awt.Color(250, 250, 250));

        prBack.setBackground(new java.awt.Color(255, 51, 51));

        btnPress.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPress.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPressMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPressMouseExited(evt);
            }
        });

        lblTexto.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        lblTexto.setForeground(new java.awt.Color(255, 255, 255));
        lblTexto.setText("Reporte de titulo");

        lblTitle.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Titulo");

        javax.swing.GroupLayout prBackLayout = new javax.swing.GroupLayout(prBack);
        prBack.setLayout(prBackLayout);
        prBackLayout.setHorizontalGroup(
            prBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prBackLayout.createSequentialGroup()
                .addGroup(prBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(prBackLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnPress, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(prBackLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(prBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(63, 63, 63))
        );
        prBackLayout.setVerticalGroup(
            prBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prBackLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(prBackLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(prBackLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(btnPress, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(prBackLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblTexto))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(prBack, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(prBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPressMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPressMouseEntered
        prBack.setBackground(SelBackGround);
    }//GEN-LAST:event_btnPressMouseEntered

    private void btnPressMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPressMouseExited
         prBack.setBackground(pbBackGround);
    }//GEN-LAST:event_btnPressMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnPress;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblTexto;
    private javax.swing.JLabel lblTitle;
    private test.PanelRound prBack;
    // End of variables declaration//GEN-END:variables

    public Color getPbBackGround() {
        return pbBackGround;
    }

    public void setPbBackGround(Color pbBackGround) {
        this.pbBackGround = pbBackGround;
    }

    public Color getSelBackGround() {
        return SelBackGround;
    }

    public void setSelBackGround(Color SelBackGround) {
        this.SelBackGround = SelBackGround;
    }
}
