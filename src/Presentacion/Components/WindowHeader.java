/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Components;


import Negocio.Desing;
import Negocio.ResponsiveDesing;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author andyv
 */
public class WindowHeader extends javax.swing.JPanel {
    private String ruta="src/Imagens/";
    
    private Desing ds=new Desing();
    private JFrame form=new JFrame();
    private JFrame[] frm;
    private Toolkit tk=Toolkit.getDefaultToolkit();
    private Dimension dm=tk.getScreenSize();
    private ResponsiveDesing  rd;
    
    private int locationX,locationY;
    private int W,H;
    private int X,Y;
    
    private boolean isSelect=false;
    private boolean isMaximizar=false;
    
    public WindowHeader() {
        initComponents();
        Inicial();
    }

    public JFrame Inicio(JFrame form,boolean max){
            this.form=form;
            isMaximizar=max;
            return form;
    }
    
    public void IniMaximizar(JFrame ...frm){
       this.frm=frm;
    }
  
    
     private final void Inicial(){
            btnSalir.setColorBackground(new Color(255,255,255));
            btnMaximizar.setColorBackground(Color.WHITE);
            btnMinimizar.setColorBackground(Color.WHITE);
    }
     
     
    
    private void Locate(){
        btnSalir.setLocation(0, 0);
        if(!isSelect){
            locationX=form.getLocation().x;
            locationY=form.getLocation().y;
            
            W=form.getWidth();
            H=form.getHeight();
            
            
        }
    }
    
    private void Maximizar(){
     Locate();
        int x=0,y=0;
        int w=0,h=0;

        if(!isSelect){
            w=dm.width;
            h=dm.height-20;

            isSelect=true;
        }else{
            x=locationX;
            y=locationY;

            w=W;
            h=H;
            isSelect=false;
        }
        
        form.setLocation(x,y);
        form.setSize(w, h);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbButtons = new javax.swing.JPanel();
        btnMinimizar = new ButtonSpecial.JbtnHeader.JButtonHeader();
        btnSalir = new ButtonSpecial.JbtnHeader.JButtonHeader();
        btnMaximizar = new ButtonSpecial.JbtnHeader.JButtonHeader();
        lIcono1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));

        cbButtons.setBackground(new java.awt.Color(255, 255, 255));
        cbButtons.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbButtons.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                cbButtonsMouseDragged(evt);
            }
        });
        cbButtons.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbButtonsMousePressed(evt);
            }
        });

        btnMinimizar.setBackground(new java.awt.Color(255, 255, 255));
        btnMinimizar.setBorder(null);
        btnMinimizar.setText("_");
        btnMinimizar.setColorOver(new java.awt.Color(0, 102, 255));
        btnMinimizar.setFocusPainted(false);
        btnMinimizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnMinimizar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setBorder(null);
        btnSalir.setText("X");
        btnSalir.setColorClick(new java.awt.Color(255, 51, 51));
        btnSalir.setFocusPainted(false);
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnMaximizar.setBackground(new java.awt.Color(255, 255, 255));
        btnMaximizar.setBorder(null);
        btnMaximizar.setText("[_]");
        btnMaximizar.setColorOver(new java.awt.Color(0, 102, 255));
        btnMaximizar.setFocusPainted(false);
        btnMaximizar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnMaximizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaximizarActionPerformed(evt);
            }
        });

        lIcono1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lIcono1.setForeground(new java.awt.Color(153, 153, 153));
        lIcono1.setText("Biblioteca");

        javax.swing.GroupLayout cbButtonsLayout = new javax.swing.GroupLayout(cbButtons);
        cbButtons.setLayout(cbButtonsLayout);
        cbButtonsLayout.setHorizontalGroup(
            cbButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cbButtonsLayout.createSequentialGroup()
                .addContainerGap(680, Short.MAX_VALUE)
                .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnMaximizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(cbButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(cbButtonsLayout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(lIcono1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(644, Short.MAX_VALUE)))
        );
        cbButtonsLayout.setVerticalGroup(
            cbButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cbButtonsLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(cbButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMaximizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMinimizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(cbButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(cbButtonsLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lIcono1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cbButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cbButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbButtonsMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbButtonsMouseDragged
        int x=evt.getXOnScreen(),y=evt.getYOnScreen();
        form.setLocation(x-X, y-Y);
        
        locationX=form.getLocation().x;
        locationY=form.getLocation().y;
    }//GEN-LAST:event_cbButtonsMouseDragged

    private void cbButtonsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbButtonsMousePressed
       X=evt.getX();
       Y=evt.getY();
    }//GEN-LAST:event_cbButtonsMousePressed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
       System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnMaximizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaximizarActionPerformed
       if(isMaximizar){
            Maximizar();
       }
    }//GEN-LAST:event_btnMaximizarActionPerformed

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        form.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ButtonSpecial.JbtnHeader.JButtonHeader btnMaximizar;
    private ButtonSpecial.JbtnHeader.JButtonHeader btnMinimizar;
    private ButtonSpecial.JbtnHeader.JButtonHeader btnSalir;
    private javax.swing.JPanel cbButtons;
    private javax.swing.JLabel lIcono1;
    // End of variables declaration//GEN-END:variables

    public boolean isIsMaximizar() {
        return isMaximizar;
    }

    public void setIsMaximizar(boolean isMaximizar) {
        this.isMaximizar = isMaximizar;
    }
}
