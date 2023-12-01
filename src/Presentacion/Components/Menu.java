/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Components;

import ButtonSpecial.JbtnItem.btnItem;
import Negocio.NEgresado;
import Negocio.NEstudiante;
import Negocio.NPersonal;
import Negocio.NUsuario;
import Negocio.Desing;
import Presentacion.Login;
import Presentacion.Modal.PConfiguracion;
import Presentacion.Modal.modalPrincipal;
import Presentacion.Modal.pPerfil;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import swing.ImageAvatar;

/**
 *
 * @author andyv
 */
public class Menu extends javax.swing.JPanel {
    private NUsuario uu=new NUsuario();
    private NPersonal pp=new NPersonal();
    private NEstudiante ee=new NEstudiante();
    private NEgresado egre=new NEgresado();

    
    private Desing ds=new Desing();
    
    private btnItem[] btn;
    private JPanel[] pnl;
    
    private JFrame frm;
    private String data;
    private boolean isSelect=false;
    
    public Menu() {
        Iniciar();
    }
    
    private void Iniciar(){
        initComponents();
        btn=new btnItem[]{btnMenuPrincipal,btnStock,btnProceso,btnReportes,btnPanelAdmin};
    }
    
    public void SelectAdmin(MouseAdapter m){
        btnPanelAdmin.addMouseListener(m);
    }
    
    private void Select(int a){
    int i=btn[a].getIndex();
    btn[a].setSelect(true);
       for(int b=0;b<btn.length;b++){
           if(btn[b].getIndex()!=i){
               btn[b].setSelect(false);
               btn[b].setBackground(new Color(255,255,255));
           }
       }
   }
    
   private void IniPanel(int a){
       for(JPanel p: pnl){p.setVisible(false);}
       pnl[a].setVisible(true);
   }
    
   public void IniciarImagenes(){
       ds.AsignarImagen(btnConf, 0, 0);
   }
   
   public void IniciarItems(String dato){
       String nombre="",cargo="";
       ImageAvatar img=null;
       try{
        if(!pp.BuscarBool(dato, pp.SEARCH_DNI)){
            if(!ee.BuscarBool(dato, ee.SEARCH_DNI)){
                if(egre.BuscarBool(dato, egre.SEARCH_DNI)){
                    nombre=(String) egre.Lectura().get(0)[2]+" "+(String) egre.Lectura().get(0)[4];
                    cargo=(String) egre.Lectura().get(0)[13];
                    img= (ImageAvatar) egre.Lectura().get(0)[1];
                }
            }else{
                 nombre=(String) ee.Lectura().get(0)[2]+" "+(String) ee.Lectura().get(0)[4];
                 cargo=(String) ee.Lectura().get(0)[13];
                 img= (ImageAvatar) ee.Lectura().get(0)[1];  
            }
       }else{
             nombre=(String) pp.Lectura().get(0)[2]+" "+(String) pp.Lectura().get(0)[4];
             cargo=(String) pp.Lectura().get(0)[13];
             img = (ImageAvatar) pp.Lectura().get(0)[1]; 
                 
       }
        
       
       lblNombre.setText(nombre);
       lblCategoria.setText(cargo);
       ImgPerfil.setImage(img.getImage());
       
       this.data=dato;
       }catch(Exception e){
         if(uu.BuscarBool(dato, uu.SEARCH_DNI)){
             
             new modalPrincipal(frm,true).setVisible(true);
             
             new Login().setVisible(true);
        }
       }
   }
   
   public void IniForm(JFrame frm){this.frm=frm;}
 
   public void IniPanel(int a,JPanel ...pnl){
       this.pnl=pnl;
     
       for(JPanel p: pnl){
           p.setVisible(false);
       }
       pnl[a].setVisible(true);
   }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnMenuPrincipal = new ButtonSpecial.JbtnItem.btnItem();
        btnStock = new ButtonSpecial.JbtnItem.btnItem();
        btnProceso = new ButtonSpecial.JbtnItem.btnItem();
        btnReportes = new ButtonSpecial.JbtnItem.btnItem();
        btnConf = new ButtonSpecial.JbtnRadius.JButtonRadius();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnPanelAdmin = new ButtonSpecial.JbtnItem.btnItem();
        jPanel3 = new javax.swing.JPanel();
        btnPerfil = new javax.swing.JLabel();
        ImgPerfil = new swing.ImageAvatar();
        lblNombre = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnMenuPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        btnMenuPrincipal.setBorder(null);
        btnMenuPrincipal.setText("Menu principal");
        btnMenuPrincipal.setBackgroundA(new java.awt.Color(255, 255, 255));
        btnMenuPrincipal.setColorBacgroundSelect(new java.awt.Color(204, 204, 204));
        btnMenuPrincipal.setColorBorder(new java.awt.Color(0, 102, 255));
        btnMenuPrincipal.setColorClick(new java.awt.Color(102, 204, 255));
        btnMenuPrincipal.setColorOver(new java.awt.Color(255, 255, 255));
        btnMenuPrincipal.setcolorTextClick(new java.awt.Color(255, 255, 255));
        btnMenuPrincipal.setColorTextOver(new java.awt.Color(0, 102, 255));
        btnMenuPrincipal.setFocusPainted(false);
        btnMenuPrincipal.setIndex(1);
        btnMenuPrincipal.setTamActual(2);
        btnMenuPrincipal.setTextA("Menu Principal");
        btnMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPrincipalActionPerformed(evt);
            }
        });

        btnStock.setBackground(new java.awt.Color(255, 255, 255));
        btnStock.setBorder(null);
        btnStock.setText("Stock Libros");
        btnStock.setBackgroundA(new java.awt.Color(255, 255, 255));
        btnStock.setColorBacgroundSelect(new java.awt.Color(204, 204, 204));
        btnStock.setColorBorder(new java.awt.Color(0, 102, 255));
        btnStock.setColorClick(new java.awt.Color(102, 204, 255));
        btnStock.setColorOver(new java.awt.Color(255, 255, 255));
        btnStock.setcolorTextClick(new java.awt.Color(255, 255, 255));
        btnStock.setColorTextOver(new java.awt.Color(0, 102, 255));
        btnStock.setFocusPainted(false);
        btnStock.setIndex(2);
        btnStock.setSelect(false);
        btnStock.setTamActual(2);
        btnStock.setTextA("Libros");
        btnStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStockActionPerformed(evt);
            }
        });

        btnProceso.setBackground(new java.awt.Color(255, 255, 255));
        btnProceso.setBorder(null);
        btnProceso.setText("Procesos");
        btnProceso.setBackgroundA(new java.awt.Color(255, 255, 255));
        btnProceso.setColorBacgroundSelect(new java.awt.Color(204, 204, 204));
        btnProceso.setColorBorder(new java.awt.Color(0, 102, 255));
        btnProceso.setColorClick(new java.awt.Color(102, 204, 255));
        btnProceso.setColorOver(new java.awt.Color(255, 255, 255));
        btnProceso.setcolorTextClick(new java.awt.Color(255, 255, 255));
        btnProceso.setColorTextOver(new java.awt.Color(0, 102, 255));
        btnProceso.setFocusPainted(false);
        btnProceso.setIndex(3);
        btnProceso.setSelect(false);
        btnProceso.setTamActual(2);
        btnProceso.setTextA("Procesos");
        btnProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesoActionPerformed(evt);
            }
        });

        btnReportes.setBackground(new java.awt.Color(255, 255, 255));
        btnReportes.setBorder(null);
        btnReportes.setText("Reportes");
        btnReportes.setBackgroundA(new java.awt.Color(255, 255, 255));
        btnReportes.setColorBacgroundSelect(new java.awt.Color(204, 204, 204));
        btnReportes.setColorBorder(new java.awt.Color(0, 102, 255));
        btnReportes.setColorClick(new java.awt.Color(102, 204, 255));
        btnReportes.setColorOver(new java.awt.Color(255, 255, 255));
        btnReportes.setcolorTextClick(new java.awt.Color(255, 255, 255));
        btnReportes.setColorTextOver(new java.awt.Color(0, 102, 255));
        btnReportes.setFocusPainted(false);
        btnReportes.setIndex(4);
        btnReportes.setSelect(false);
        btnReportes.setTamActual(2);
        btnReportes.setTextA("Reportes");
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnReportes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProceso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnStock, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMenuPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStock, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        btnConf.setBackground(new java.awt.Color(255, 255, 255));
        btnConf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Configuracion.png"))); // NOI18N
        btnConf.setColorClick(new java.awt.Color(51, 204, 255));
        btnConf.setColorOver(new java.awt.Color(102, 204, 255));
        btnConf.setFocusPainted(false);
        btnConf.setRadius(15);
        btnConf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnConfMousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 255));
        jLabel3.setText("Menu");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 255));
        jLabel4.setText("Opciones de Administrador");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnPanelAdmin.setBackground(new java.awt.Color(255, 255, 255));
        btnPanelAdmin.setBorder(null);
        btnPanelAdmin.setBackgroundA(new java.awt.Color(255, 255, 255));
        btnPanelAdmin.setColorBacgroundSelect(new java.awt.Color(204, 204, 204));
        btnPanelAdmin.setColorBorder(new java.awt.Color(0, 102, 255));
        btnPanelAdmin.setColorClick(new java.awt.Color(102, 204, 255));
        btnPanelAdmin.setColorOver(new java.awt.Color(255, 255, 255));
        btnPanelAdmin.setcolorTextClick(new java.awt.Color(255, 255, 255));
        btnPanelAdmin.setColorTextOver(new java.awt.Color(0, 102, 255));
        btnPanelAdmin.setFocusPainted(false);
        btnPanelAdmin.setIndex(5);
        btnPanelAdmin.setLabel("Panel Administrador");
        btnPanelAdmin.setSelect(false);
        btnPanelAdmin.setTamActual(2);
        btnPanelAdmin.setTextA("Panel Administrador");
        btnPanelAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPanelAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPanelAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnPanelAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 116, Short.MAX_VALUE))
        );

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPerfilMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnPerfilMousePressed(evt);
            }
        });
        jPanel3.add(btnPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 80));

        ImgPerfil.setBackground(new java.awt.Color(255, 255, 255));
        ImgPerfil.setGradientColor1(new java.awt.Color(255, 255, 255));
        ImgPerfil.setGradientColor2(new java.awt.Color(255, 255, 255));
        ImgPerfil.setImage(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icono-Adminhombre.png"))); // NOI18N
        jPanel3.add(ImgPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 13, 77, 69));

        lblNombre.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setText("Andy Valles");
        jPanel3.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 13, 108, 23));

        lblCategoria.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblCategoria.setForeground(new java.awt.Color(102, 102, 102));
        lblCategoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCategoria.setText("Administrador");
        jPanel3.add(lblCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 42, 108, 23));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConf, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(btnConf, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPrincipalActionPerformed
       Select(0);
       IniPanel(0);
    }//GEN-LAST:event_btnMenuPrincipalActionPerformed

    private void btnStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStockActionPerformed
        Select(1);
        IniPanel(1);
    }//GEN-LAST:event_btnStockActionPerformed

    private void btnProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesoActionPerformed
      Select(2);
      IniPanel(2);
    }//GEN-LAST:event_btnProcesoActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
      Select(3);
      IniPanel(3);
    }//GEN-LAST:event_btnReportesActionPerformed

    private void btnPanelAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPanelAdminActionPerformed
       Select(4);
       IniPanel(4);
    }//GEN-LAST:event_btnPanelAdminActionPerformed

    private void btnPerfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerfilMouseEntered
      
    }//GEN-LAST:event_btnPerfilMouseEntered

    private void btnConfMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfMousePressed
        new PConfiguracion(frm,true).setVisible(true);
    }//GEN-LAST:event_btnConfMousePressed

    private void btnPerfilMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerfilMousePressed
        new pPerfil(frm,true,data).setVisible(true);
    }//GEN-LAST:event_btnPerfilMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ImageAvatar ImgPerfil;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnConf;
    private ButtonSpecial.JbtnItem.btnItem btnMenuPrincipal;
    private ButtonSpecial.JbtnItem.btnItem btnPanelAdmin;
    private javax.swing.JLabel btnPerfil;
    private ButtonSpecial.JbtnItem.btnItem btnProceso;
    private ButtonSpecial.JbtnItem.btnItem btnReportes;
    private ButtonSpecial.JbtnItem.btnItem btnStock;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblNombre;
    // End of variables declaration//GEN-END:variables
}
