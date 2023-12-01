/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Panel;

import Presentacion.Modal.PConfAdmin;
import Presentacion.Modal.PLibros;
import Presentacion.Modal.PUsuario;
import Presentacion.Modal.pMas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/**
 *
 * @author andyv
 */
public class PanelAdministrador extends javax.swing.JPanel {
    
    private String ruta="/Imagens";
    private JFrame frm=null;
    
    private PUsuario usu=null;
    private PLibros lib=null;
    private PConfAdmin conf=null;
    private pMas mas=null;
    
    public PanelAdministrador() {
       Iniciar();
    }
    
    private void Iniciar(){
        initComponents();
        IniText();
        IniciarPress();
    }
    
    private void IniciarPress(){
         opEgresado.Select(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                usu=new PUsuario(frm,true,"Egresado");
                opEgresado.getDialog(usu, frm);
                opEgresado.IniDialog();
            }
        });
         
         opEstudiante.Select(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                usu=new PUsuario(frm,true,"Estudiante");
                opEstudiante.getDialog(usu, frm);
                opEstudiante.IniDialog();
            }
        });
        
          opPersonal.Select(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                usu=new PUsuario(frm,true,"Personal");
                opPersonal.getDialog(usu, frm);
                opPersonal.IniDialog();
            }
        });
         
            opLibro.Select(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lib=new PLibros(frm, true,false);
                opLibro.getDialog(lib, frm);
                opLibro.IniDialog();
            }
        });
           
             opConfi.Select(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                conf=new PConfAdmin(frm, true);
                opConfi.getDialog(conf, frm);
                opConfi.IniDialog();
            }
        });
            
              opTesis.Select(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mas=new pMas(frm, true);
                opTesis.getDialog(mas, frm);
                opTesis.IniDialog();
            }
        });
    
    }
    
    
    public void Iniform(JFrame frm){
            this.frm=frm;
    }

     public void iniciarImage(){
       opEgresado.IniImage(ruta, "icon-Egresado.png");
       opEstudiante.IniImage(ruta, "icon-Estudiante.png");
       opPersonal.IniImage(ruta, "icon-Otros.png");
       opConfi.IniImage(ruta,"Configuracion.png");
       opLibro.IniImage(ruta, "icono-Libro.png");
       opTesis.IniImage(ruta, "Mas.png");
   }
     
     private void IniText(){
         opEgresado.IniTexto("Egresado");
         opEstudiante.IniTexto("Estudiante");
         opPersonal.IniTexto("Personal");
         opConfi.IniTexto("Configuracion");
         opLibro.IniTexto("Libro");
         opTesis.IniTexto("Otros");
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        opPersonal = new Presentacion.Components.Opcion();
        opEgresado = new Presentacion.Components.Opcion();
        opEstudiante = new Presentacion.Components.Opcion();
        opLibro = new Presentacion.Components.Opcion();
        opTesis = new Presentacion.Components.Opcion();
        opConfi = new Presentacion.Components.Opcion();

        setBackground(new java.awt.Color(250, 250, 250));
        setMinimumSize(new java.awt.Dimension(834, 490));
        setPreferredSize(new java.awt.Dimension(834, 490));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("Panel administrador");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 255));
        jLabel2.setText("Opciones para el resgistro y administración de los datos en el programa, como lo son los registros de estudiantes, entre otros.\n");

        opPersonal.setColorClick(new java.awt.Color(102, 204, 255));
        opPersonal.setColorOver(new java.awt.Color(0, 102, 255));

        opEgresado.setColorClick(new java.awt.Color(102, 204, 255));
        opEgresado.setColorOver(new java.awt.Color(0, 102, 255));
        opEgresado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                opEgresadoMousePressed(evt);
            }
        });

        opEstudiante.setColorClick(new java.awt.Color(102, 204, 255));
        opEstudiante.setColorOver(new java.awt.Color(0, 102, 255));

        opLibro.setColorClick(new java.awt.Color(102, 204, 255));
        opLibro.setColorOver(new java.awt.Color(0, 102, 255));

        opTesis.setColorClick(new java.awt.Color(102, 204, 255));
        opTesis.setColorOver(new java.awt.Color(0, 102, 255));

        opConfi.setColorClick(new java.awt.Color(102, 204, 255));
        opConfi.setColorOver(new java.awt.Color(0, 102, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(opLibro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(40, 40, 40)
                        .addComponent(opTesis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(40, 40, 40)
                        .addComponent(opConfi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(opEgresado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(40, 40, 40)
                        .addComponent(opEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(40, 40, 40)
                        .addComponent(opPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(365, 365, 365))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(opEstudiante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(opEgresado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opConfi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(opTesis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(opLibro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(51, 51, 51))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void opEgresadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opEgresadoMousePressed
         System.out.println("año");
    }//GEN-LAST:event_opEgresadoMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private Presentacion.Components.Opcion opConfi;
    private Presentacion.Components.Opcion opEgresado;
    private Presentacion.Components.Opcion opEstudiante;
    private Presentacion.Components.Opcion opLibro;
    private Presentacion.Components.Opcion opPersonal;
    private Presentacion.Components.Opcion opTesis;
    // End of variables declaration//GEN-END:variables
}
