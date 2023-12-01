/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Components;

import Entidad.Personal;
import Entidad.Usuario;
import Negocio.NCargo;
import Negocio.NPersonal;
import Presentacion.Modal.PDistrito;
import javax.swing.JFrame;

/**
 *
 * @author andyv
 */
public class OPPersonal extends javax.swing.JPanel {
    
    private NCargo cc=new NCargo();
    private NPersonal pp=new NPersonal();
    
    private JFrame frm;
    
    public OPPersonal() {
        initComponents();
        Iniciar();
    }

      private void Iniciar(){
        initComponents();
        for(Object o:cc.cboCargo()){cboCargo.addItem(o);}
    }
    
    private Personal Items(Usuario u){
        Personal p=new Personal();
        p.setDNI(u.getDNI());
        p.setCargo(cboCargo.getSelectedIndex()+1);
    return p;
    }
    
    public void IniFrm(JFrame frm){this.frm=frm;}
    
    public boolean Agregar(boolean a,Usuario u){
       if(a){
        return pp.Insertar(Items(u));
       }else {return pp.Actualizar(Items(u));} 
    }
    
    public void Cargo(String txt){
        cboCargo.setSelectedItem(txt);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboCargo = new combobox.Combobox();
        btnCargo = new ButtonSpecial.JbtnRadius.JButtonRadius();

        setBackground(new java.awt.Color(255, 255, 255));

        cboCargo.setLabeText("Cargo");
        cboCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cboCargoMouseEntered(evt);
            }
        });

        btnCargo.setBackground(new java.awt.Color(51, 204, 255));
        btnCargo.setBorder(null);
        btnCargo.setForeground(new java.awt.Color(255, 255, 255));
        btnCargo.setText("Agregar cargo");
        btnCargo.setColorBackground(new java.awt.Color(51, 204, 255));
        btnCargo.setColorClick(new java.awt.Color(0, 153, 255));
        btnCargo.setColorOver(new java.awt.Color(102, 204, 255));
        btnCargo.setColorText(new java.awt.Color(255, 255, 255));
        btnCargo.setFocusPainted(false);
        btnCargo.setRadius(15);
        btnCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(cboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargoActionPerformed
        new PDistrito(frm, true, "Cargo",true).setVisible(true);
    }//GEN-LAST:event_btnCargoActionPerformed

    private void cboCargoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboCargoMouseEntered
        while(cboCargo.getItemCount()>=1){cboCargo.removeItemAt(0);}
        for(Object o:cc.cboCargo()){cboCargo.addItem(o);}
    }//GEN-LAST:event_cboCargoMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ButtonSpecial.JbtnRadius.JButtonRadius btnCargo;
    private combobox.Combobox cboCargo;
    // End of variables declaration//GEN-END:variables
}
