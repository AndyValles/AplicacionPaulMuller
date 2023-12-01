/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Panel;

import Entidad.Autor;
import Entidad.Cargo;
import Entidad.Carrera;
import Entidad.Categoria;
import Entidad.Distrito;
import Entidad.Editorial;
import Entidad.Pais;
import Entidad.Profesion;
import Negocio.NAutor;
import Negocio.NCargo;
import Negocio.NCarrera;
import Negocio.NCategoria;
import Negocio.NDistrito;
import Negocio.NEditorial;
import Negocio.NPais;
import Negocio.NProfesion;
import Negocio.Desing;
import Negocio.NBusqueda;
import Negocio.ValidateText;
import Presentacion.Modal.Eliminar;
import Presentacion.Modal.PDistrito;
import Presentacion.Modal.pAutor;
import Presentacion.Modal.pEditorial;
import Tablespecial.JTableCustom.TablaCell;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andyv
 */
public class Mas extends javax.swing.JPanel {
   private Desing ds=new Desing();
   private ValidateText vl=new ValidateText();
   
   private PDistrito dat=null;
   private pEditorial edi=null;
   private pAutor aut=null;
   
   private NPais pais=new NPais("Codigo","Nombre","Estado","Modificar","Eliminar");
   private NCargo cargo=new NCargo("Codigo","Nombre","Estado","Modificar","Eliminar");
   private NCarrera carrera=new NCarrera("Codigo","Nombre","Estado","Modificar","Eliminar");
   private NProfesion profesion=new NProfesion("Codigo","Nombre","Estado","Modificar","Eliminar");
   private NDistrito distrito=new NDistrito("Codigo","Nombre","Estado","Modificar","Eliminar");
   private NAutor autor=new NAutor("Codigo","Nombre","Apellido Paterno","Apellido Materno","País","Modificar","Eliminar");
   private NEditorial editorial=new NEditorial("Codigo","Nombre","Dirección","Telefono","Correo","País","Modificar","Eliminar");
   private NCategoria categoria=new NCategoria("Codigo","Nombre","Estado","Modificar","Eliminar");
   
   private NBusqueda buscar=new NBusqueda("Codigo","Nombre","Estado");

   
   public int NPais = 1;
   public int NCargo = 2;
   public int NCarrera =3 ;
   public int NProfesion =4 ;
   public int NDistrito = 5;
   public int NAutor = 6;
   public int NEditorial =7 ;
   public int NCategoria = 8;

   
   private boolean isInsert=true;
   private int tbl;

   private Eliminar el=null;
   private JFrame frm;
   private JPanel pl; 
   
   public Mas() {
        initComponents();
        tblResult.setDefaultRenderer(Object.class, new TablaCell());
        Iniciar();
   }
   
   private void Iniciar(){
       for(Object o:buscar.getBuscarPor()){cboBuscar.addItem(o);}
       for(Object o:buscar.getTitles()){cboBuscar1.addItem(o);}
   }
   
   public void Reload(){
       ds.AsignarImagen(btnReload,20,10);
   }
   
   private ArrayList Items(){
   ArrayList lts=new ArrayList();
   int a=tblResult.getSelectedRow();
    for(int i=0;i<tblResult.getColumnCount();i++){
        lts.add(tblResult.getValueAt(a,i));
    }
   
   return lts;
   }
   
    public void IniAcceso(boolean isInsert,ArrayList data){
       switch(tbl){
           case 1:
               dat=new PDistrito(frm, true, "País", isInsert);
               dat.Item(data);
               dat.setVisible(true);
               break;
           case 2:
               dat=new PDistrito(frm, true, "Cargo", isInsert);
               dat.Item(data);
               dat.setVisible(true);
               break;
           case 3:
               dat=new PDistrito(frm, true, "Carrera", isInsert);
               dat.Item(data);
               dat.setVisible(true);
               break;
           case 4:
               dat=new PDistrito(frm, true, "Profesión", isInsert);
               dat.Item(data);
               dat.setVisible(true);
               break;
           case 5:
               dat=new PDistrito(frm, true, "Distrito", isInsert);
               dat.Item(data);
               dat.setVisible(true);
               break;
           case 6:
               aut=new pAutor(frm, true, isInsert);
               aut.IniItems(data);
               aut.setVisible(true);
               break;
           case 7:
               edi=new pEditorial(frm, true, isInsert);
               edi.IniItems(data);
               edi.setVisible(true);
               break;
           case 8:
               dat=new PDistrito(frm, true, "Categoria", isInsert);
               dat.Item(data);
               dat.setVisible(true);
               break;
       }
   }
   
    
   public void IniTable(int tbl){
       switch(tbl){
           case 1:
               tblResult.setModel(pais.Leer());
               break;
           case 2:
               tblResult.setModel(cargo.Leer());               
               break;
           case 3:
               tblResult.setModel(carrera.Leer());
               break;
           case 4:
               tblResult.setModel(profesion.Leer());
               break;
           case 5:
               tblResult.setModel(distrito.Leer());
               break;
           case 6:
               tblResult.setModel(autor.Leer());
               break;
           case 7:
               tblResult.setModel(editorial.Leer());
               break;
           case 8:
               tblResult.setModel(categoria.Leer());

               break;
       }
       this.tbl=tbl;
       setVisible(true);
   }
   
    public void IniEliminar(ArrayList data){
        switch(tbl){
           case 1:
               IniElimi(8,data,"País");
               break;
           case 2:
               IniElimi(2,data,"Cargo");
               break;
           case 3:
               IniElimi(3,data,"Carrera");
               break;
           case 4:
               IniElimi(9,data,"Profesión");
               break;
           case 5:
               IniElimi(5,data,"Distrito");
               break;
           case 6:
               IniElimi(1,data,"Autor");
               break;
           case 7:
               IniElimi(6,data,"Editorial");
               break;
           case 8:
               IniElimi(4,data,"Categoria");
               break;
       }
   }
   
     public DefaultTableModel IniBuscar(int x,int y,Boolean b,String txt){
        switch(tbl){
           case 1:
               if(y!=1){
                   Pais o=new Pais();
                   if(!txt.isEmpty())o.setCodigo(Integer.parseInt(txt));
                   if(b!=null)o.setEstado(b);
                   return buscar.tablePais(y,(o));}
               else{return buscar.tablePais(x,txt);}
              
           case 2:
               if(y!=1){
                   Cargo o=new Cargo();
                   if(!txt.isEmpty())o.setCodigo(Integer.parseInt(txt));
                   if(b!=null)o.setEstado(b);
                   return buscar.tableCargo(y,o);}
               else{return buscar.tableCargo(x,txt);}
              
           case 3:
                if(y!=1){
                   Carrera o=new Carrera();
                   if(!txt.isEmpty())o.setCodigo(Integer.parseInt(txt));
                   if(b!=null)o.setEstado(b);
                    return buscar.tableCarrera(y,( o));}
               else{return buscar.tableCarrera(x,txt);}
               
           case 4:
                 if(y!=1){
                     Profesion o=new Profesion();
                   if(!txt.isEmpty())o.setCodigo(Integer.parseInt(txt+0));
                   if(b!=null)o.setEstado(b);
                     return buscar.tableProfesion(y,( o));}
               else{return buscar.tableProfesion(x,txt);}
              
           case 5:
                 if(y!=1){
                     Distrito o=new Distrito();
                   if(!txt.isEmpty())o.setCodigo(Integer.parseInt(txt));
                   if(b!=null)o.setEstado(b);
                     return buscar.tableDistrito(y,( o));}
               else{return buscar.tableDistrito(x,txt);}
               
           case 6:
                 if(y!=0){
                      Autor o=new Autor();
                   if(!txt.isEmpty())o.setCodigo(Integer.parseInt(txt));
                  
                   return buscar.tableAutor(y,(o));}
               else{return buscar.tableAutor(x,y,txt);}
               
           case 7:
                 if(y!=1){
                      Editorial o=new Editorial();
                      if(!txt.isEmpty())o.setCodigo(Integer.parseInt(txt));
                   
                     return buscar.tableEditorial(y,(o));}
               else{return buscar.tableEditorial(x,y,txt);}
               
           case 8:
                if(y!=1){
                     Categoria o=new Categoria();
                    if(!txt.isEmpty())o.setCodigo(Integer.parseInt(txt));
                   if(b!=null)o.setEstado(b);
                    return buscar.tableCategoria(y,(o));}
               else{return buscar.tableCategoria(x,txt);}
               
       }
        return null;
   }
    
   private void IniElimi(int i,ArrayList data,String txt){
        el=new Eliminar(frm,true,i,data.get(0));
        el.info(txt, (String)data.get(1));
        el.setVisible(true);
   }
   
   public void IniForm(JFrame frm){this.frm=frm;}
   public void IniPanel(JPanel pl){this.pl=pl;}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboBuscar = new combobox.Combobox();
        cboBuscar1 = new combobox.Combobox();
        txtBuscar = new textfield.TextField();
        jButtonRadius6 = new ButtonSpecial.JbtnRadius.JButtonRadius();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResult = new dynamic_subjtable.TableCustom();
        btnSalir = new ButtonSpecial.JbtnRadius.JButtonRadius();
        btnAgregar = new ButtonSpecial.JbtnRadius.JButtonRadius();
        btnReload = new ButtonSpecial.JbtnRadius.JButtonRadius();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(255, 255, 255));

        cboBuscar.setLabeText("Buscar por:");

        cboBuscar1.setLabeText("Buscar como:");
        cboBuscar1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboBuscar1ItemStateChanged(evt);
            }
        });

        txtBuscar.setLabelText("Buscar");
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        jButtonRadius6.setBackground(new java.awt.Color(51, 153, 255));
        jButtonRadius6.setBorder(null);
        jButtonRadius6.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRadius6.setText("Limpiar");
        jButtonRadius6.setColorBackground(new java.awt.Color(51, 153, 255));
        jButtonRadius6.setColorClick(new java.awt.Color(102, 204, 255));
        jButtonRadius6.setColorOver(new java.awt.Color(102, 204, 255));
        jButtonRadius6.setColorText(new java.awt.Color(255, 255, 255));
        jButtonRadius6.setFocusPainted(false);
        jButtonRadius6.setRadius(15);
        jButtonRadius6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRadius6ActionPerformed(evt);
            }
        });

        tblResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblResult.setFillsViewportHeight(true);
        tblResult.setGridColor(new java.awt.Color(255, 255, 255));
        tblResult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblResultMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblResult);

        btnSalir.setBackground(new java.awt.Color(51, 153, 255));
        btnSalir.setBorder(null);
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.setColorBackground(new java.awt.Color(51, 153, 255));
        btnSalir.setColorClick(new java.awt.Color(102, 204, 255));
        btnSalir.setColorOver(new java.awt.Color(102, 204, 255));
        btnSalir.setColorText(new java.awt.Color(255, 255, 255));
        btnSalir.setFocusPainted(false);
        btnSalir.setRadius(15);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(51, 153, 255));
        btnAgregar.setBorder(null);
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.setColorBackground(new java.awt.Color(51, 153, 255));
        btnAgregar.setColorClick(new java.awt.Color(102, 204, 255));
        btnAgregar.setColorOver(new java.awt.Color(102, 204, 255));
        btnAgregar.setColorText(new java.awt.Color(255, 255, 255));
        btnAgregar.setFocusPainted(false);
        btnAgregar.setRadius(15);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnReload.setBackground(new java.awt.Color(51, 153, 255));
        btnReload.setBorder(null);
        btnReload.setForeground(new java.awt.Color(255, 255, 255));
        btnReload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Reload.png"))); // NOI18N
        btnReload.setColorBackground(new java.awt.Color(51, 153, 255));
        btnReload.setColorClick(new java.awt.Color(102, 204, 255));
        btnReload.setColorOver(new java.awt.Color(102, 204, 255));
        btnReload.setColorText(new java.awt.Color(255, 255, 255));
        btnReload.setFocusPainted(false);
        btnReload.setRadius(15);
        btnReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadActionPerformed(evt);
            }
        });

        jLabel1.setText("Recargar tabla");

        jLabel2.setText("<html><h4>Nota:</h4>Al realizar un registro se debe recargar la tabla para visualizar los datos actuales\n</htm>");

        cbEstado.setBackground(new java.awt.Color(255, 255, 255));
        cbEstado.setText("Estado");
        cbEstado.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cbEstadoStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(709, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnReload, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(16, 16, 16))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 853, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 100, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(cboBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cboBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonRadius6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(cbEstado)
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReload, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonRadius6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(26, 26, 26)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                    .addGap(75, 75, 75)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblResultMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultMousePressed
        int column=tblResult.getColumnModel().getColumnIndexAtX(evt.getX());
        int row=evt.getY()/tblResult.getRowHeight();

        if(row<tblResult.getRowCount() && row>=0 &&column<tblResult.getColumnCount() && column>0){
            Object uu=tblResult.getValueAt(row, column);
            if(uu instanceof JButton){
                JButton btn=(JButton) uu;
                if(btn.getName().equals("modificar")){
                    IniAcceso(false,Items());
                }else{
                    IniEliminar(Items());
                }
            }
        }
    }//GEN-LAST:event_tblResultMousePressed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        IniAcceso(true,null);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        pl.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
        IniTable(tbl);
    }//GEN-LAST:event_btnReloadActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
      if(cboBuscar1.getSelectedIndex()==0){vl.valNumber(evt);}
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void cboBuscar1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboBuscar1ItemStateChanged
      txtBuscar.setEditable(cboBuscar1.getSelectedIndex()!=2);
      cbEstado.setVisible(cboBuscar1.getSelectedIndex()==2);
     
    }//GEN-LAST:event_cboBuscar1ItemStateChanged

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        int x=cboBuscar.getSelectedIndex(),y=cboBuscar1.getSelectedIndex();
       
       tblResult.setModel(IniBuscar(x,y,null,txtBuscar.getText()));
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void jButtonRadius6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRadius6ActionPerformed
        IniTable(tbl);
    }//GEN-LAST:event_jButtonRadius6ActionPerformed

    private void cbEstadoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbEstadoStateChanged
         if(cbEstado.isVisible()){
      int x=cboBuscar.getSelectedIndex(),y=cboBuscar1.getSelectedIndex();
      tblResult.setModel(IniBuscar(x,y,cbEstado.isSelected(),""));}
    }//GEN-LAST:event_cbEstadoStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ButtonSpecial.JbtnRadius.JButtonRadius btnAgregar;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnReload;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnSalir;
    private javax.swing.JCheckBox cbEstado;
    private combobox.Combobox cboBuscar;
    private combobox.Combobox cboBuscar1;
    private ButtonSpecial.JbtnRadius.JButtonRadius jButtonRadius6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private dynamic_subjtable.TableCustom tblResult;
    private textfield.TextField txtBuscar;
    // End of variables declaration//GEN-END:variables

   
}
