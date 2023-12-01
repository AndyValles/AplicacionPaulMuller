/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Panel;

import Presentacion.Modal.pDevolucion;
import Presentacion.Modal.pPrestamo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/**
 *
 * @author andyv
 */
public class Procesos extends javax.swing.JPanel {

    private pPrestamo prs=null;
    private pDevolucion drs=null;
    private JFrame frm=null;
    
    private String ruta="/Imagens";
    public Procesos() {
        initComponents();
        Itext();
        IniFrm();
    }
    public void iniImage(){
     opPrestamo.IniImage(ruta, "Prestamo.png");
     opDevolucion.IniImage(ruta, "Devolucion.png");
    }

    private void Itext(){
        opPrestamo.IniTexto("Prestamo");
        opDevolucion.IniTexto("Devolucion");
    }
    
    private void IniFrm(){
        opPrestamo.Select(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                prs=new pPrestamo(frm, true,true);
                opPrestamo.getDialog(prs, frm);
                opPrestamo.IniDialog();
            }
            
        });
        
        opDevolucion.Select(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drs=new pDevolucion(frm, true);
                opDevolucion.getDialog(drs, frm);
                opDevolucion.IniDialog();
            }
            
        });
    }
    
    public void IniFrm(JFrame frm){this.frm=frm;}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        opDevolucion = new Presentacion.Components.Opcion();
        opPrestamo = new Presentacion.Components.Opcion();

        setBackground(new java.awt.Color(250, 250, 250));
        setMinimumSize(new java.awt.Dimension(834, 490));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("Procesos");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 255));
        jLabel2.setText("Si quiere realizar un prestamo o devolucion presione las opciones correspondientes para logras ello");

        opDevolucion.setColorClick(new java.awt.Color(153, 102, 255));
        opDevolucion.setColorOver(new java.awt.Color(153, 51, 255));

        opPrestamo.setColorClick(new java.awt.Color(102, 204, 255));
        opPrestamo.setColorOver(new java.awt.Color(51, 153, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(opPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(opDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(191, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(169, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private Presentacion.Components.Opcion opDevolucion;
    private Presentacion.Components.Opcion opPrestamo;
    // End of variables declaration//GEN-END:variables
}
