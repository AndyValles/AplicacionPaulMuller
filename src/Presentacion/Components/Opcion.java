/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Components;

import Negocio.Desing;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author andyv
 */
public class Opcion extends JComponent {
    
    private Desing ds=new Desing();
    
    private Color colorOver=Color.RED;
    private Color colorBg=Color.WHITE;
    
    private Color colorTextOver=Color.WHITE;
    private Color colorText=Color.BLACK;
    
    private Color colorClick=Color.ORANGE;
    private Color colorTextClick=Color.WHITE;
    
    private boolean isEntered=false;
    
    private JDialog dial; 
    private JFrame frm;
    
    public Opcion() {
        initComponents();
        Inicia();
    }
    
    public void Select(MouseAdapter l){
        btnSelect.addMouseListener(l);
    }
  
    private void Inicia(){
        pBack.setBackground(colorBg);
    }
    
    public void IniDialog(){
          if(dial!=null){
                       dial.setSize(frm.getSize());
                       dial.setLocation(frm.getLocation());
                       dial.setVisible(true);
        }
    }
    
    public void IniImage(String ruta,String archivo){
        ds.AsignarImagen(lblImage, ruta, archivo);
    }
    
    public void IniTexto(String txt){
        Texto.setText(txt);
    }
    
    public void getDialog(JDialog dial,JFrame frm){
        this.dial=dial;
        this.frm=frm;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pBack = new test.PanelRound();
        btnSelect = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        Texto = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setBackground(new java.awt.Color(255, 255, 255));

        pBack.setBackground(new java.awt.Color(255, 255, 255));
        pBack.setRoundBottomLeft(20);
        pBack.setRoundBottomRight(20);
        pBack.setRoundTopLeft(20);
        pBack.setRoundTopRight(20);

        btnSelect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSelectMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSelectMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSelectMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnSelectMouseReleased(evt);
            }
        });

        Texto.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        Texto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Texto.setText("Texto");

        javax.swing.GroupLayout pBackLayout = new javax.swing.GroupLayout(pBack);
        pBack.setLayout(pBackLayout);
        pBackLayout.setHorizontalGroup(
            pBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBackLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Texto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pBackLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btnSelect, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
        );
        pBackLayout.setVerticalGroup(
            pBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBackLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(Texto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btnSelect, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelectMouseEntered
        pBack.setBackground(colorOver);
        Texto.setForeground(colorTextOver);
    }//GEN-LAST:event_btnSelectMouseEntered

    private void btnSelectMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelectMouseExited
       pBack.setBackground(colorBg);
       Texto.setForeground(colorText);
    
    }//GEN-LAST:event_btnSelectMouseExited

    private void btnSelectMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelectMousePressed
        pBack.setBackground(colorClick);
        Texto.setForeground(colorTextClick);
    }//GEN-LAST:event_btnSelectMousePressed

    private void btnSelectMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelectMouseReleased
        pBack.setBackground(colorOver);
        Texto.setForeground(colorTextOver);
    }//GEN-LAST:event_btnSelectMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Texto;
    private javax.swing.JLabel btnSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblImage;
    private test.PanelRound pBack;
    // End of variables declaration//GEN-END:variables

    public Color getColorOver() {
        return colorOver;
    }

    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
    }

    public Color getColorBg() {
        return colorBg;
    }

    public void setColorBg(Color colorBg) {
        this.colorBg = colorBg;
    }

    public Color getColorTextOver() {
        return colorTextOver;
    }

    public void setColorTextOver(Color colorTextOver) {
        this.colorTextOver = colorTextOver;
    }

    public Color getColorText() {
        return colorText;
    }

    public void setColorText(Color colorText) {
        this.colorText = colorText;
    }

    public Color getColorClick() {
        return colorClick;
    }

    public void setColorClick(Color colorClick) {
        this.colorClick = colorClick;
    }

    public Color getColorTextClick() {
        return colorTextClick;
    }

    public void setColorTextClick(Color colorTextClick) {
        this.colorTextClick = colorTextClick;
    }
}
