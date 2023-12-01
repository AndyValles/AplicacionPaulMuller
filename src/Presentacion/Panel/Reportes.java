/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Panel;

import Presentacion.Modal.pExport;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/**
 *
 * @author andyv
 */
public class Reportes extends javax.swing.JPanel {

   private JFrame frm;
    public Reportes() {
        initComponents();
    }
    
    public void IniFrm(JFrame frm){
    this.frm=frm;
    }
    
    public void iniciar(){
        opUsuario.Iniciar("icon-Estudiante.png", "Usuario");
        opLibro.Iniciar("icono-Libro.png", "Libro");
        opDistrito.Iniciar("","Distrito");
        opCargo.Iniciar("","Cargo");
        opCarrera.Iniciar("","Carrera");
        opProfesion.Iniciar("","Profesión");
        opCategoria.Iniciar("icono_Categoria.png","Categoria");
        opAutor.Iniciar("icono_Autor.png","Autor");
        opPais.Iniciar("","Pais");
        opEditorial.Iniciar("icono_Editorial.png","Editorial");
        opDevolucion.Iniciar("icono_Devolucion.png","Devolución");
        opPrestamo.Iniciar("icono_Prestamo.png","Prestamo");
    }
    
    public void IniciarSelect(){
          opUsuario.Select(new MouseAdapter() {
              @Override
              public void mousePressed(MouseEvent e) {
                  new pExport(frm,true).setVisible(true);
              }
          });
        opLibro.Select(new MouseAdapter() {
              @Override
              public void mousePressed(MouseEvent e) {
                  new pExport(frm,true).setVisible(true);
              }
          });
        opDistrito.Select(new MouseAdapter() {
              @Override
              public void mousePressed(MouseEvent e) {
                  new pExport(frm,true).setVisible(true);
              }
          });
        opCargo.Select(new MouseAdapter() {
              @Override
              public void mousePressed(MouseEvent e) {
                  new pExport(frm,true).setVisible(true);
              }
          });
        opCarrera.Select(new MouseAdapter() {
              @Override
              public void mousePressed(MouseEvent e) {
                  new pExport(frm,true).setVisible(true);
              }
          });
        opProfesion.Select(new MouseAdapter() {
              @Override
              public void mousePressed(MouseEvent e) {
                  new pExport(frm,true).setVisible(true);
              }
          });
        opCategoria.Select(new MouseAdapter() {
              @Override
              public void mousePressed(MouseEvent e) {
                  new pExport(frm,true).setVisible(true);
              }
          });
        opAutor.Select(new MouseAdapter() {
              @Override
              public void mousePressed(MouseEvent e) {
                  new pExport(frm,true).setVisible(true);
              }
          });
        opPais.Select(new MouseAdapter() {
              @Override
              public void mousePressed(MouseEvent e) {
                  new pExport(frm,true).setVisible(true);
              }
          });
        opEditorial.Select(new MouseAdapter() {
              @Override
              public void mousePressed(MouseEvent e) {
                  new pExport(frm,true).setVisible(true);
              }
          });
        opDevolucion.Select(new MouseAdapter() {
              @Override
              public void mousePressed(MouseEvent e) {
                  new pExport(frm,true).setVisible(true);
              }
          });
        opPrestamo.Select(new MouseAdapter() {
              @Override
              public void mousePressed(MouseEvent e) {
                  new pExport(frm,true).setVisible(true);
              }
          });
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScroll1 = new ScrollPaneSpecial.JScrollPane.JScroll();
        jPanel1 = new javax.swing.JPanel();
        opUsuario = new Presentacion.Components.Opcion1();
        opLibro = new Presentacion.Components.Opcion1();
        opDistrito = new Presentacion.Components.Opcion1();
        opCargo = new Presentacion.Components.Opcion1();
        opCarrera = new Presentacion.Components.Opcion1();
        opProfesion = new Presentacion.Components.Opcion1();
        opAutor = new Presentacion.Components.Opcion1();
        opCategoria = new Presentacion.Components.Opcion1();
        opPrestamo = new Presentacion.Components.Opcion1();
        opDevolucion = new Presentacion.Components.Opcion1();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        opPais = new Presentacion.Components.Opcion1();
        opEditorial = new Presentacion.Components.Opcion1();

        setBackground(new java.awt.Color(250, 250, 250));
        setMinimumSize(new java.awt.Dimension(834, 490));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("Reportes");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 255));
        jLabel2.setText("Opciones para la realizacion de reportes de los datos obtenidos en el programa, como lo son los datos de estudiantes, entre otros.\n");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        opUsuario.setPbBackGround(new java.awt.Color(51, 204, 255));
        opUsuario.setSelBackGround(new java.awt.Color(102, 204, 255));

        opLibro.setSelBackGround(new java.awt.Color(255, 204, 0));

        opDistrito.setSelBackGround(new java.awt.Color(255, 204, 0));

        opCargo.setPbBackGround(new java.awt.Color(153, 0, 255));
        opCargo.setSelBackGround(new java.awt.Color(204, 153, 255));

        opCarrera.setSelBackGround(new java.awt.Color(255, 204, 0));

        opProfesion.setPbBackGround(new java.awt.Color(255, 153, 51));
        opProfesion.setSelBackGround(new java.awt.Color(255, 153, 102));

        opAutor.setSelBackGround(new java.awt.Color(255, 204, 0));

        opCategoria.setBackground(new java.awt.Color(0, 204, 0));
        opCategoria.setPbBackGround(new java.awt.Color(0, 204, 0));
        opCategoria.setSelBackGround(new java.awt.Color(102, 255, 51));

        opPrestamo.setSelBackGround(new java.awt.Color(255, 204, 0));

        opDevolucion.setPbBackGround(new java.awt.Color(255, 204, 0));
        opDevolucion.setSelBackGround(new java.awt.Color(255, 204, 0));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Procesos:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Usuario:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Libro:");

        opPais.setSelBackGround(new java.awt.Color(255, 204, 0));

        opEditorial.setSelBackGround(new java.awt.Color(255, 204, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(opEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(opCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(opAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(opPais, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(opDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(opPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(opDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(opUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(opProfesion, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(opLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(opCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(opCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(opLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(opProfesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opAutor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opCategoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opPais, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(opEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        jScroll1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScroll1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jScroll1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private ScrollPaneSpecial.JScrollPane.JScroll jScroll1;
    private Presentacion.Components.Opcion1 opAutor;
    private Presentacion.Components.Opcion1 opCargo;
    private Presentacion.Components.Opcion1 opCarrera;
    private Presentacion.Components.Opcion1 opCategoria;
    private Presentacion.Components.Opcion1 opDevolucion;
    private Presentacion.Components.Opcion1 opDistrito;
    private Presentacion.Components.Opcion1 opEditorial;
    private Presentacion.Components.Opcion1 opLibro;
    private Presentacion.Components.Opcion1 opPais;
    private Presentacion.Components.Opcion1 opPrestamo;
    private Presentacion.Components.Opcion1 opProfesion;
    private Presentacion.Components.Opcion1 opUsuario;
    // End of variables declaration//GEN-END:variables
}
