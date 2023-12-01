/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Components;

import Entidad.Estudiante;
import Entidad.Usuario;
import Negocio.NCarrera;
import Negocio.NEstudiante;
import Negocio.Time;
import Presentacion.Modal.PDistrito;
import java.time.LocalDate;
import javax.swing.JFrame;

/**
 *
 * @author andyv
 */
public class OPEstudiante extends javax.swing.JPanel {
    private LocalDate lt=LocalDate.now();
    private Time tt=new Time();

    private NCarrera cc=new NCarrera();
    private NEstudiante ee=new NEstudiante();

    private JFrame frm;
    
    public OPEstudiante() {
        initComponents();
        Iniciar();
    }

     private void Iniciar(){
        initComponents();
        for(Object o:cc.cboCarrera()){cboCarrera.addItem(o);}
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
    
    private Estudiante Items(Usuario u){
        Estudiante e=new Estudiante();
        e.setDNI(u.getDNI());
        e.setCarrera(cboCarrera.getSelectedIndex()+1);
        e.setFPostulacion(cboAño.getSelectedItem()+"-"+(cboMes.getSelectedIndex()+1)+"-"+cboDia.getSelectedItem());
    return e;
    }
    
     public void IniFrm(JFrame frm){this.frm=frm;}
    
     public boolean Agregar(boolean a,Usuario u){
       if(a){
        return ee.Insertar(Items(u));
       }else {return ee.Actualizar(Items(u));} 
    }
    
      public void Carrera(String txt,String date){
        cboCarrera.setSelectedItem(txt);
        cboDia.setSelectedItem(date.substring(8, 10));
        cboMes.setSelectedIndex(Integer.parseInt(date.substring(5, 7)));
        cboAño.setSelectedItem(date.substring(0, 4));
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboCarrera = new combobox.Combobox();
        cboDia = new combobox.Combobox();
        cboMes = new combobox.Combobox();
        cboAño = new combobox.Combobox();
        jLabel1 = new javax.swing.JLabel();
        btnCarrera = new ButtonSpecial.JbtnRadius.JButtonRadius();

        setBackground(new java.awt.Color(255, 255, 255));

        cboCarrera.setLabeText("Carrera");
        cboCarrera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cboCarreraMouseEntered(evt);
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

        jLabel1.setText("Fecha de Postulación");

        btnCarrera.setBackground(new java.awt.Color(51, 204, 255));
        btnCarrera.setBorder(null);
        btnCarrera.setForeground(new java.awt.Color(255, 255, 255));
        btnCarrera.setText("Agregar carrera");
        btnCarrera.setColorBackground(new java.awt.Color(51, 204, 255));
        btnCarrera.setColorClick(new java.awt.Color(0, 153, 255));
        btnCarrera.setColorOver(new java.awt.Color(102, 204, 255));
        btnCarrera.setColorText(new java.awt.Color(255, 255, 255));
        btnCarrera.setFocusPainted(false);
        btnCarrera.setRadius(15);
        btnCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarreraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cboDia, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboMes, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboAño, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(cboCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboDia, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMes, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboAño, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboMesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMesItemStateChanged
      IniDia(cboMes.getSelectedIndex()+1);
    }//GEN-LAST:event_cboMesItemStateChanged

    private void btnCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarreraActionPerformed
         new PDistrito(frm, true, "Carrera",true).setVisible(true);
    }//GEN-LAST:event_btnCarreraActionPerformed

    private void cboCarreraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboCarreraMouseEntered
        while(cboCarrera.getItemCount()>=1){cboCarrera.removeItemAt(0);}
         for(Object o:cc.cboCarrera()){cboCarrera.addItem(o);}
    }//GEN-LAST:event_cboCarreraMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ButtonSpecial.JbtnRadius.JButtonRadius btnCarrera;
    private combobox.Combobox cboAño;
    private combobox.Combobox cboCarrera;
    private combobox.Combobox cboDia;
    private combobox.Combobox cboMes;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
