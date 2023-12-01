/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Components;

import Entidad.Egresado;
import Entidad.Usuario;
import Negocio.NEgresado;
import Negocio.NProfesion;
import Negocio.Time;
import Presentacion.Modal.PDistrito;
import java.time.LocalDate;
import javax.swing.JFrame;

/**
 *
 * @author andyv
 */
public class OPEgresado extends javax.swing.JPanel {
    private Time tt=new Time();
    private LocalDate lt=LocalDate.now();
    
    private NEgresado ee=new NEgresado();
    private NProfesion pp=new NProfesion();
    private JFrame frm;
 
    public OPEgresado() {
        Iniciar();
    }
    
    private void Iniciar(){
        initComponents();
        for(Object o:pp.cboProfesion()){cboProfesion.addItem(o);}
        for(Object o:tt.Month()){cboMes.addItem(o);}
        for(Object o:tt.Year()){cboAño.addItem(o);} 
        cboMes.setSelectedIndex(lt.getMonthValue()-1);
        cboAño.setSelectedItem(lt.getYear());
        
        IniDia(lt.getMonthValue());
    }
    
   
    private void IniDia(int mes){
     if(cboDia.getItemCount()>0){
         cboDia.removeAllItems();
     }
        
     for(Object o:tt.DaysMonth(mes)){cboDia.addItem(o);}
     cboDia.setSelectedIndex(lt.getDayOfMonth()-1);
    }
    
    private Egresado Items(Usuario u){
        Egresado e=new Egresado();
        e.setDNI(u.getDNI());
        e.setProfesion(cboProfesion.getSelectedIndex()+1);
        e.setFGraduacion(cboAño.getSelectedItem()+"-"+(cboMes.getSelectedIndex()+1)+"-"+cboDia.getSelectedItem());
    return e;
    }
    
    public void IniFrm(JFrame frm){this.frm=frm;}
       
    public boolean Agregar(boolean a,Usuario u){
       if(a){
        return ee.Insertar(Items(u));
       }else {
           return ee.Actualizar(Items(u));
       } 
    }
    
    public void Profesion(String txt,String date){
        cboProfesion.setSelectedItem(txt);
        cboDia.setSelectedItem(date.substring(8, 10));
        cboMes.setSelectedIndex(Integer.parseInt(date.substring(5, 7)));
        cboAño.setSelectedItem(date.substring(0, 4));
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboProfesion = new combobox.Combobox();
        cboDia = new combobox.Combobox();
        cboMes = new combobox.Combobox();
        cboAño = new combobox.Combobox();
        jLabel1 = new javax.swing.JLabel();
        btnProfesion = new ButtonSpecial.JbtnRadius.JButtonRadius();

        setBackground(new java.awt.Color(255, 255, 255));

        cboProfesion.setLabeText("Profesion");
        cboProfesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cboProfesionMouseEntered(evt);
            }
        });

        cboDia.setLabeText("Dia");

        cboMes.setLabeText("Mes");
        cboMes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboMesItemStateChanged(evt);
            }
        });

        cboAño.setLabeText("Año");

        jLabel1.setText("Fecha de Graduación");

        btnProfesion.setBackground(new java.awt.Color(51, 204, 255));
        btnProfesion.setBorder(null);
        btnProfesion.setForeground(new java.awt.Color(255, 255, 255));
        btnProfesion.setText("Agregar profesión");
        btnProfesion.setColorBackground(new java.awt.Color(51, 204, 255));
        btnProfesion.setColorClick(new java.awt.Color(0, 153, 255));
        btnProfesion.setColorOver(new java.awt.Color(102, 204, 255));
        btnProfesion.setColorText(new java.awt.Color(255, 255, 255));
        btnProfesion.setFocusPainted(false);
        btnProfesion.setRadius(15);
        btnProfesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cboDia, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboMes, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboAño, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(cboProfesion, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProfesion, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboDia, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMes, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboAño, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboProfesion, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProfesion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboMesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMesItemStateChanged
       IniDia(cboMes.getSelectedIndex()+1);
    }//GEN-LAST:event_cboMesItemStateChanged

    private void btnProfesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfesionActionPerformed
        new PDistrito(frm, true, "Profesión",true).setVisible(true);
    }//GEN-LAST:event_btnProfesionActionPerformed

    private void cboProfesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboProfesionMouseEntered
          while(cboProfesion.getItemCount()>=1){cboProfesion.removeItemAt(0);}
         for(Object o:pp.cboProfesion()){cboProfesion.addItem(o);}
    }//GEN-LAST:event_cboProfesionMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ButtonSpecial.JbtnRadius.JButtonRadius btnProfesion;
    private combobox.Combobox cboAño;
    private combobox.Combobox cboDia;
    private combobox.Combobox cboMes;
    private combobox.Combobox cboProfesion;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
