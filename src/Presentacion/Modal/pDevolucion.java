/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Modal;

import DialogSpecial.JDialogSpecial.JDialogCustom;
import Entidad.DetalleDevolucion;
import Entidad.Devolucion;
import Negocio.NDetalleDevolucion;
import Negocio.NDetallePrestamo;
import Negocio.NDevolucion;
import Negocio.NLibro;
import Negocio.ValidateText;

import Tablespecial.JTableCustom.TablaCell;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andyv
 */
public class pDevolucion extends JDialogCustom{
    
    private DefaultTableModel dt=new DefaultTableModel();
    
    private NLibro ll=new NLibro("codigo","Portada","Titulo","Autor","Publicación","Categoria","Editorial","Edición","Estado");
    private NDetallePrestamo dp=new NDetallePrestamo(" "," "," "," "," "," "," "," "," ","","");
    private NDetalleDevolucion de=new NDetalleDevolucion();
    private NDevolucion dd=new NDevolucion();
    
    private ValidateText vl=new ValidateText();
    private LocalDate ld=LocalDate.now();
    private JFrame frm=null;
    
    public pDevolucion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.frm=(JFrame) parent;
        initComponents();
        if(parent!=null)setSize(parent.getSize());
        iniciar();
    }
    
    private  void iniciar(){
       dt.setColumnIdentifiers(new String[]{"codigo","Portada","Titulo","Autor","Publicación","Categoria","Editorial","Edición","Estado","Cantidad"});
       tblResult1.setModel(dt);
       
        fecha1.Titulo("Fecha acordada");
        
        tblResult1.setDefaultRenderer(Object.class,new TablaCell());               
        txtCodigo.setText(vl.CodigoVol('D',"", dd.Dato(), 5));
    }
    
    private Devolucion ItemsD(){
        Devolucion pre=new Devolucion();
        pre.setCodigo(txtCodigo.getText());
        pre.setPrestamo(txtPres.getText());
        pre.setFAcordada(fecha1.date());
        pre.setFRecibida(ld.getYear()+"-"+ld.getMonthValue()+"-"+ld.getDayOfMonth());
        return pre;
    }
    
     private DetalleDevolucion ItemsDt(){
        DetalleDevolucion dev=new DetalleDevolucion();
        dev.setDevolucion(txtCodigo.getText());
        dev.setLibro(txtLibro.getText());
        dev.setCantLibro(Integer.parseInt(txtCantidad.getText()));
        return dev;
    }
    
     private void agregarTodos(){
      DetalleDevolucion  detalle=new DetalleDevolucion();
       detalle.setDevolucion(txtCodigo.getText());
       for(int i=0;i<tblResult1.getRowCount();i++){
           detalle.setLibro(tblResult1.getValueAt(i, 0)+"");
           detalle.setCantLibro(Integer.parseInt(tblResult1.getValueAt(i, tblResult1.getColumnCount()-1)+""));
           if(de.Insertar(detalle)){
           
           }
       }
     }
     
     private void Agregar(){
         if(dd.Insertar(ItemsD())){
             if(de.Insertar(ItemsDt())){
             
             }
         }
     }
     
     private void Modificar(){
        
             if(de.Actualizar(ItemsDt())){
             
             }
         
     }
     
     private void Eliminar(){
        
             if(dd.Eliminar(ItemsD())){
             
             }
         
     }
   
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        fecha1 = new Presentacion.Components.Fecha();
        txtPres = new textfield.TextField();
        btnMPres = new ButtonSpecial.JbtnRadius.JButtonRadius();
        txtCodigo = new textfield.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResult1 = new dynamic_subjtable.TableCustom();
        txtCantidad = new textfield.TextField();
        btnSalir = new ButtonSpecial.JbtnRadius.JButtonRadius();
        btnDTodo = new ButtonSpecial.JbtnRadius.JButtonRadius();
        btnDevolver = new ButtonSpecial.JbtnRadius.JButtonRadius();
        txtDNI = new textfield.TextField();
        txtLibro = new textfield.TextField();
        btnAnula = new ButtonSpecial.JbtnRadius.JButtonRadius();
        btnModificar = new ButtonSpecial.JbtnRadius.JButtonRadius();
        btnBuscar = new ButtonSpecial.JbtnRadius.JButtonRadius();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtPres.setLabelText("Codigo Prestamo");

        btnMPres.setBackground(new java.awt.Color(51, 153, 255));
        btnMPres.setBorder(null);
        btnMPres.setForeground(new java.awt.Color(255, 255, 255));
        btnMPres.setText("...");
        btnMPres.setColorBackground(new java.awt.Color(51, 153, 255));
        btnMPres.setColorClick(new java.awt.Color(102, 204, 255));
        btnMPres.setColorOver(new java.awt.Color(102, 204, 255));
        btnMPres.setColorText(new java.awt.Color(255, 255, 255));
        btnMPres.setFocusPainted(false);
        btnMPres.setRadius(15);
        btnMPres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMPresActionPerformed(evt);
            }
        });

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(255, 255, 255));
        txtCodigo.setText("P-00001");
        txtCodigo.setLabelText("Codigo de Devolución");

        tblResult1.setModel(new javax.swing.table.DefaultTableModel(
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
        tblResult1.setFillsViewportHeight(true);
        tblResult1.setGridColor(new java.awt.Color(255, 255, 255));
        tblResult1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblResult1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblResult1);

        txtCantidad.setLabelText("Cantidad");
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(51, 153, 255));
        btnSalir.setBorder(null);
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.setActionCommand("Modificar");
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

        btnDTodo.setBackground(new java.awt.Color(51, 153, 255));
        btnDTodo.setBorder(null);
        btnDTodo.setForeground(new java.awt.Color(255, 255, 255));
        btnDTodo.setText("Devolver todo");
        btnDTodo.setActionCommand("Modificar");
        btnDTodo.setColorBackground(new java.awt.Color(51, 153, 255));
        btnDTodo.setColorClick(new java.awt.Color(102, 204, 255));
        btnDTodo.setColorOver(new java.awt.Color(102, 204, 255));
        btnDTodo.setColorText(new java.awt.Color(255, 255, 255));
        btnDTodo.setFocusPainted(false);
        btnDTodo.setRadius(15);
        btnDTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDTodoActionPerformed(evt);
            }
        });

        btnDevolver.setBackground(new java.awt.Color(51, 153, 255));
        btnDevolver.setBorder(null);
        btnDevolver.setForeground(new java.awt.Color(255, 255, 255));
        btnDevolver.setText("Devolver libro");
        btnDevolver.setActionCommand("Modificar");
        btnDevolver.setColorBackground(new java.awt.Color(51, 153, 255));
        btnDevolver.setColorClick(new java.awt.Color(102, 204, 255));
        btnDevolver.setColorOver(new java.awt.Color(102, 204, 255));
        btnDevolver.setColorText(new java.awt.Color(255, 255, 255));
        btnDevolver.setFocusPainted(false);
        btnDevolver.setRadius(15);
        btnDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverActionPerformed(evt);
            }
        });

        txtDNI.setEditable(false);
        txtDNI.setBackground(new java.awt.Color(255, 255, 255));
        txtDNI.setLabelText("DNI");

        txtLibro.setEditable(false);
        txtLibro.setBackground(new java.awt.Color(255, 255, 255));
        txtLibro.setLabelText("Codigo Libro");

        btnAnula.setBackground(new java.awt.Color(51, 153, 255));
        btnAnula.setBorder(null);
        btnAnula.setForeground(new java.awt.Color(255, 255, 255));
        btnAnula.setText("Anular");
        btnAnula.setActionCommand("Modificar");
        btnAnula.setColorBackground(new java.awt.Color(51, 153, 255));
        btnAnula.setColorClick(new java.awt.Color(102, 204, 255));
        btnAnula.setColorOver(new java.awt.Color(102, 204, 255));
        btnAnula.setColorText(new java.awt.Color(255, 255, 255));
        btnAnula.setFocusPainted(false);
        btnAnula.setRadius(15);
        btnAnula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnulaActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(51, 153, 255));
        btnModificar.setBorder(null);
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("Modificar");
        btnModificar.setColorBackground(new java.awt.Color(51, 153, 255));
        btnModificar.setColorClick(new java.awt.Color(102, 204, 255));
        btnModificar.setColorOver(new java.awt.Color(102, 204, 255));
        btnModificar.setColorText(new java.awt.Color(255, 255, 255));
        btnModificar.setFocusPainted(false);
        btnModificar.setRadius(15);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(51, 153, 255));
        btnBuscar.setBorder(null);
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.setColorBackground(new java.awt.Color(51, 153, 255));
        btnBuscar.setColorClick(new java.awt.Color(102, 204, 255));
        btnBuscar.setColorOver(new java.awt.Color(102, 204, 255));
        btnBuscar.setColorText(new java.awt.Color(255, 255, 255));
        btnBuscar.setFocusPainted(false);
        btnBuscar.setRadius(15);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPres, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMPres, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnula, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(txtLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnMPres, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnDTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnAnula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMPresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMPresActionPerformed
        new JDialPres(frm, true,true).setVisible(true);
    }//GEN-LAST:event_btnMPresActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        vl.valNumber(evt);
        vl.valText(txtCantidad, 8, evt);
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnDTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDTodoActionPerformed
      agregarTodos();
    }//GEN-LAST:event_btnDTodoActionPerformed

    private void btnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverActionPerformed
      Agregar();
    }//GEN-LAST:event_btnDevolverActionPerformed

    private void tblResult1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResult1MousePressed
       int r=tblResult1.getSelectedRow();
       txtLibro.setText(tblResult1.getValueAt(r, 0)+"");
       txtCantidad.setText(tblResult1.getValueAt(r, tblResult1.getColumnCount()-1)+"");
    }//GEN-LAST:event_tblResult1MousePressed

    private void btnAnulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAnulaActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        new JDialDevo(frm,true,false).setVisible(true);
    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(pDevolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pDevolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pDevolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pDevolucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                pDevolucion dialog = new pDevolucion(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ButtonSpecial.JbtnRadius.JButtonRadius btnAnula;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnBuscar;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnDTodo;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnDevolver;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnMPres;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnModificar;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnSalir;
    private Presentacion.Components.Fecha fecha1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private dynamic_subjtable.TableCustom tblResult1;
    private textfield.TextField txtCantidad;
    private textfield.TextField txtCodigo;
    private textfield.TextField txtDNI;
    private textfield.TextField txtLibro;
    private textfield.TextField txtPres;
    // End of variables declaration//GEN-END:variables

 class JDialPres extends JPrestamo{
    
        public JDialPres(Frame parent, boolean modal,boolean isPress) {
            super(parent, modal,isPress);
            tblResult.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                   tblResultMousePressed(e,txtPres);
                }
            });
        }
        
      public void tblResultMousePressed(MouseEvent evt,JTextField txt){
        int r=tblResult.getSelectedRow();
        ArrayList<Object[]> lista=new ArrayList<>();

            if(tblResult.getSelectedRow()>=0){
                String codigo=tblResult.getValueAt(r, 0)+"";
                String DNI=tblResult.getValueAt(r, 1)+"";
                
                if(dp.BuscarBool(codigo, dp.SEARCH_CODE)){
                    for(int b=0;b<dp.Lectura().size();b++){
                        String libro=dp.Lectura().get(b)[8]+"";
                        String cantidad=dp.Lectura().get(b)[9]+"";
                        Object[] libroT=new Object[10];

                        if(ll.BuscarBool(libro, ll.SEARCH_TITLE)){
                              
                                for(int a=0;a<9;a++){
                                libroT[a]=ll.Lectura().get(0)[a];
                            }
                            
                        }
                         libroT[9]=cantidad;
                         lista.add(libroT);
                    }
                }
                
                for(int i=0;i<lista.size();i++){dt.addRow(lista.get(i));}
                
                txt.setText(codigo);
                txtDNI.setText(DNI);
               
              
                this.dispose();
            }
        }
    }
 
 class JDialDevo extends JDialPres{
    
        public JDialDevo(Frame parent, boolean modal,boolean isPress) {
            super(parent, modal,isPress);
            tblResult.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                   tblResultMousePressed(e);
                }
            });
        }
        
      public void tblResultMousePressed(MouseEvent evt){
             super.tblResultMousePressed(evt, txtCodigo);
        }
    }
}

