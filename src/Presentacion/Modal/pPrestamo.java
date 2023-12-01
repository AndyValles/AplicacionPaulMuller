package Presentacion.Modal;

import DialogSpecial.JDialogSpecial.JDialogCustom;
import Entidad.DetallePrestamo;
import Entidad.Prestamo;
import Negocio.NDetallePrestamo;
import Negocio.NLibro;
import Negocio.NPrestamo;
import Negocio.ValidateText;
import Tablespecial.JTableCustom.TablaCell;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andyv
 */
public class pPrestamo extends JDialogCustom {
    private DefaultTableModel dt=new DefaultTableModel();
    
    private NDetallePrestamo dp=new NDetallePrestamo();
    private NPrestamo pp=new NPrestamo("");
    
    private NLibro ll=new NLibro("codigo","Portada","Titulo","Autor","Publicación","Categoria","Editorial","Edición","Estado");
    
    private LocalDate ld=LocalDate.now();
    private ValidateText vl=new ValidateText();
    
    private Notification nt =null;
    
    private JFrame frm=null;
    private JUsuario uu=null;
    
    private boolean isPress;
    
    public pPrestamo(java.awt.Frame parent, boolean modal,boolean isPress) {
        super(parent, modal);
        initComponents();
        
        this.frm=(JFrame) parent;      
        this.isPress=isPress;
        
        iniciar();
        IniTable();
    }
    
    private void iniciar(){
       txtDNI.setText("");
       txtLibro.setText("");
       txtCanLibro.setText("0");
       while(dt.getRowCount()!=0){dt.removeRow(0);}
       
       dt.setColumnIdentifiers(new String[]{"codigo","Portada","Titulo","Autor","Publicación","Categoria","Editorial","Edición","Estado","Cantidad"});
       tblResult1.setModel(dt);
       
       tblResult1.setDefaultRenderer(Object.class,new TablaCell());               
       
       fecha2.Titulo("Fecha de devolución");
       
      
            
       GenerarCodigo();
    }
    
    private void GenerarCodigo(){
     int a=pp.CantidadDato();
       String codigo=vl.CodigoVol('P',"", a, 5);
       
       while(pp.BuscarBool(codigo, pp.SEARCH_CODE)){
           a++;
           codigo=vl.CodigoVol('P',"", a, 5);
       }
       
       txtCodigo.setText(codigo);
    }
    
     private void IniTable(){
        ArrayList<Object[]> lista=new ArrayList<>();
        Object[] Libro=new Object[10];
        
        if(!txtLibro.getText().isEmpty()){
            if(ll.BuscarBool(txtLibro.getText(), ll.SEARCH_TITLE)){
                for(int i=0;i<9;i++){ 
                    Libro[i]=ll.Lectura().get(0)[i];
                }
            
                Libro[9]=txtCanLibro.getText();
                lista.add(Libro);
            }
        }
            
       
        for(int i=0;i<lista.size();i++){dt.addRow(lista.get(i));}
     } 

    private Prestamo ItemsP(){
        Prestamo pre=new Prestamo();
        pre.setCodigo(txtCodigo.getText());
        pre.setDNI(txtDNI.getText());
        pre.setFPrestamo(ld.getYear()+"-"+ld.getMonthValue()+"-"+ld.getDayOfMonth());
        pre.setFDevolucion(fecha2.date());
        return pre;
    }
    
    private DetallePrestamo ItemsDe(int i){
     DetallePrestamo dp=new DetallePrestamo();
     dp.setPrestamo(txtCodigo.getText());
     dp.setLibro(tblResult1.getValueAt(i, 0)+"");
     dp.setCanLibros(Integer.parseInt(tblResult1.getValueAt(i,tblResult1.getColumnCount()-1)+""));
     return dp;
    }
    
    private DetallePrestamo ItemsDe(){
     DetallePrestamo dp=new DetallePrestamo();
     dp.setPrestamo(txtCodigo.getText());
     dp.setLibro(txtLibro.getText());
     dp.setCanLibros(Integer.parseInt(txtCanLibro.getText()));
     return dp;
    }
    
    private void EliminarTable(){
    
        if(dp.BuscarLibroBool(ItemsDe())){
            if(dp.EliminarLibro(ItemsDe())){
              if(tblResult1.getSelectedColumn()>=0){
                int r=tblResult1.getSelectedRow();
                dt.removeRow(r);
            }
            }
        }else{
            if(tblResult1.getSelectedColumn()>=0){
                int r=tblResult1.getSelectedRow();
                dt.removeRow(r);
            }
        }
    }
    
    private boolean Insertar(){
        if(!pp.BuscarBool(ItemsP())){
            if(pp.Insertar(ItemsP())){
                for(int i=0;i<tblResult1.getRowCount();i++){
                   if(dp.Insertar(ItemsDe(i))){
                       if(i==tblResult1.getRowCount()-1){
                           return true; 
                       }
                   }else{break;}
                }
            }
        }else{
        new Notification(frm, true, 0, "Insertado", "No se puede duplicar el codigo").setVisible(true);
        }
        
        return false;
    }
    
    private boolean Modificar(){
       if(isPress){
            if(pp.Actualizar(ItemsP())){
               for(int i=0;i<tblResult1.getRowCount();i++){
                   if(!dp.BuscarLibroBool(ItemsDe(i))){
                        if(dp.Insertar(ItemsDe(i))){
                            if(i==tblResult1.getRowCount()-1){
                                return true; 
                       }
                   }
                }
             }
          }
       }
        
        return false;
    }
    
    private boolean Eliminar(){
       if(isPress){
            if(pp.Eliminar(ItemsP())){return true; }
        }
        return false;
    }
       
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtCodigo = new textfield.TextField();
        txtDNI = new textfield.TextField();
        txtLibro = new textfield.TextField();
        txtCanLibro = new textfield.TextField();
        fecha2 = new Presentacion.Components.Fecha();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResult1 = new dynamic_subjtable.TableCustom();
        btnMDNI = new ButtonSpecial.JbtnRadius.JButtonRadius();
        btnMLibros = new ButtonSpecial.JbtnRadius.JButtonRadius();
        btnEliminar = new ButtonSpecial.JbtnRadius.JButtonRadius();
        btnAgregarLibro = new ButtonSpecial.JbtnRadius.JButtonRadius();
        btnSalir = new ButtonSpecial.JbtnRadius.JButtonRadius();
        btnAgregar = new ButtonSpecial.JbtnRadius.JButtonRadius();
        btnBuscar = new ButtonSpecial.JbtnRadius.JButtonRadius();
        btnModificar = new ButtonSpecial.JbtnRadius.JButtonRadius();
        btnAnular = new ButtonSpecial.JbtnRadius.JButtonRadius();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1228, 548));

        jPanel3.setLayout(new javax.swing.OverlayLayout(jPanel3));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(255, 255, 255));
        txtCodigo.setText("P-00001");
        txtCodigo.setLabelText("Codigo Prestamo");
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 11, 195, -1));

        txtDNI.setLabelText("DNI");
        txtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDNIKeyTyped(evt);
            }
        });
        jPanel1.add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 190, -1));

        txtLibro.setEditable(false);
        txtLibro.setBackground(new java.awt.Color(255, 255, 255));
        txtLibro.setLabelText("Libro");
        jPanel1.add(txtLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 195, -1));

        txtCanLibro.setText("0");
        txtCanLibro.setLabelText("Cantidad libros");
        txtCanLibro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCanLibroKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCanLibroKeyTyped(evt);
            }
        });
        jPanel1.add(txtCanLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 195, -1));
        jPanel1.add(fecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, -1, 80));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 247, 790, 280));

        btnMDNI.setBackground(new java.awt.Color(51, 153, 255));
        btnMDNI.setBorder(null);
        btnMDNI.setForeground(new java.awt.Color(255, 255, 255));
        btnMDNI.setText("...");
        btnMDNI.setColorBackground(new java.awt.Color(51, 153, 255));
        btnMDNI.setColorClick(new java.awt.Color(102, 204, 255));
        btnMDNI.setColorOver(new java.awt.Color(102, 204, 255));
        btnMDNI.setColorText(new java.awt.Color(255, 255, 255));
        btnMDNI.setFocusPainted(false);
        btnMDNI.setRadius(15);
        btnMDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMDNIActionPerformed(evt);
            }
        });
        jPanel1.add(btnMDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 28, 22));

        btnMLibros.setBackground(new java.awt.Color(51, 153, 255));
        btnMLibros.setBorder(null);
        btnMLibros.setForeground(new java.awt.Color(255, 255, 255));
        btnMLibros.setText("...");
        btnMLibros.setColorBackground(new java.awt.Color(51, 153, 255));
        btnMLibros.setColorClick(new java.awt.Color(102, 204, 255));
        btnMLibros.setColorOver(new java.awt.Color(102, 204, 255));
        btnMLibros.setColorText(new java.awt.Color(255, 255, 255));
        btnMLibros.setFocusPainted(false);
        btnMLibros.setRadius(15);
        btnMLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMLibrosActionPerformed(evt);
            }
        });
        jPanel1.add(btnMLibros, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 26, 22));

        btnEliminar.setBackground(new java.awt.Color(51, 153, 255));
        btnEliminar.setBorder(null);
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar Libro");
        btnEliminar.setActionCommand("Modificar");
        btnEliminar.setColorBackground(new java.awt.Color(51, 153, 255));
        btnEliminar.setColorClick(new java.awt.Color(102, 204, 255));
        btnEliminar.setColorOver(new java.awt.Color(102, 204, 255));
        btnEliminar.setColorText(new java.awt.Color(255, 255, 255));
        btnEliminar.setFocusPainted(false);
        btnEliminar.setRadius(15);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 180, 119, 28));

        btnAgregarLibro.setBackground(new java.awt.Color(51, 153, 255));
        btnAgregarLibro.setBorder(null);
        btnAgregarLibro.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarLibro.setText("Agregar libro");
        btnAgregarLibro.setActionCommand("Modificar");
        btnAgregarLibro.setColorBackground(new java.awt.Color(51, 153, 255));
        btnAgregarLibro.setColorClick(new java.awt.Color(102, 204, 255));
        btnAgregarLibro.setColorOver(new java.awt.Color(102, 204, 255));
        btnAgregarLibro.setColorText(new java.awt.Color(255, 255, 255));
        btnAgregarLibro.setFocusPainted(false);
        btnAgregarLibro.setRadius(15);
        btnAgregarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarLibroActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 130, 30));

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
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 480, 119, 28));

        btnAgregar.setBackground(new java.awt.Color(51, 153, 255));
        btnAgregar.setBorder(null);
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Registrar prestamo");
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
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 250, 119, 28));

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
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 119, 28));

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
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 290, 119, 28));

        btnAnular.setBackground(new java.awt.Color(51, 153, 255));
        btnAnular.setBorder(null);
        btnAnular.setForeground(new java.awt.Color(255, 255, 255));
        btnAnular.setText("Anular");
        btnAnular.setColorBackground(new java.awt.Color(51, 153, 255));
        btnAnular.setColorClick(new java.awt.Color(102, 204, 255));
        btnAnular.setColorOver(new java.awt.Color(102, 204, 255));
        btnAnular.setColorText(new java.awt.Color(255, 255, 255));
        btnAnular.setFocusPainted(false);
        btnAnular.setRadius(15);
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });
        jPanel1.add(btnAnular, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 330, 119, 28));

        jPanel3.add(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1002, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMDNIActionPerformed
        new JDialUsuario(frm, true).setVisible(true);
    }//GEN-LAST:event_btnMDNIActionPerformed

    private void btnMLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMLibrosActionPerformed
        new JDialLibro(frm, true).setVisible(true);
    }//GEN-LAST:event_btnMLibrosActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(tblResult1.getRowCount()!=0){
            if(Insertar()){
                 new Notification(frm, true,1,"Insertado", "Se inserto correctamente").setVisible(true);
                 iniciar();        
            }else{
                new Notification(frm, true,2,"Insertado", "No se inserto correctamente").setVisible(true);
            }
        }else{
            new Notification(frm, true,0,"Advertencia", "Debe agregar los libros para el prestamo").setVisible(true);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        new JDialPres(frm,true,true).setVisible(true);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
      EliminarTable();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(Modificar()){
            new Notification(frm, true,1,"Modificado", "Se modifico correctamente").setVisible(true);
        }else{
            new Notification(frm, true,2,"Modificado", "No se modifico correctamente").setVisible(true);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtCanLibroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCanLibroKeyTyped
        vl.valText(txtCanLibro,10, evt);
        vl.valNumber(evt);
    }//GEN-LAST:event_txtCanLibroKeyTyped

    private void txtDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNIKeyTyped
        vl.valNumber(evt);
        vl.valText(txtDNI, 8, evt);
    }//GEN-LAST:event_txtDNIKeyTyped

    private void btnAgregarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarLibroActionPerformed
        IniTable();
        txtLibro.setText("");
        txtCanLibro.setText("");
    }//GEN-LAST:event_btnAgregarLibroActionPerformed

    private void txtCanLibroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCanLibroKeyReleased
       if(txtCanLibro.getText().equals("0") && !txtLibro.getText().isEmpty()){
           txtCanLibro.setText("1");
       }
    }//GEN-LAST:event_txtCanLibroKeyReleased

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
       if(pp.BuscarBool(txtCodigo.getText(), pp.SEARCH_CODE)){
           if(Eliminar()){
               iniciar();
               new Notification(frm, true,1,"Anulado", "Se anulo correctamente").setVisible(true);
           }else{
               new Notification(frm, true,2,"Anulado", "No se anulo correctamente").setVisible(true);
           }
       }
    }//GEN-LAST:event_btnAnularActionPerformed

    private void tblResult1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResult1MousePressed
       if(tblResult1.getRowCount()>0){
       int r=tblResult1.getSelectedRow();
       txtLibro.setText(tblResult1.getValueAt(r, 0)+"");
       txtCanLibro.setText(tblResult1.getValueAt(r, tblResult1.getColumnCount()-1)+"");}
    }//GEN-LAST:event_tblResult1MousePressed

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
            java.util.logging.Logger.getLogger(pPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                pPrestamo dialog = new pPrestamo(new javax.swing.JFrame(), true,true);
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
    private ButtonSpecial.JbtnRadius.JButtonRadius btnAgregar;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnAgregarLibro;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnAnular;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnBuscar;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnEliminar;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnMDNI;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnMLibros;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnModificar;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnSalir;
    private Presentacion.Components.Fecha fecha2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private dynamic_subjtable.TableCustom tblResult1;
    private textfield.TextField txtCanLibro;
    private textfield.TextField txtCodigo;
    private textfield.TextField txtDNI;
    private textfield.TextField txtLibro;
    // End of variables declaration//GEN-END:variables

    class JDialUsuario extends JUsuario{
    
        public JDialUsuario(Frame parent, boolean modal) {
            super(parent, modal);
            tblResult.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    tblResultMousePressed(e);
                }
            });
        }
    
        private void tblResultMousePressed(MouseEvent l){
            int r=tblResult.getSelectedRow();
            if(tblResult.getSelectedRow()>=0){
                String codigo=tblResult.getValueAt(r, 0)+"";
                txtDNI.setText(codigo);
                this.dispose();
            }
        }
    }
    
    class JDialLibro extends PLibros{
    
        public JDialLibro(Frame parent, boolean modal) {
            super(parent, modal);
            tblResult.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                   tblResultMousePressed(e);
                }
            });
        }
        
        public void tblResultMousePressed(MouseEvent evt){
        int r=tblResult.getSelectedRow();
            if(tblResult.getSelectedRow()>=0){
                String codigo=tblResult.getValueAt(r, 2)+"";
                txtLibro.setText(codigo);
                this.dispose();
            }
            txtCanLibro.setText("1");
        }
   
    }

    class JDialPres extends JPrestamo{
    
        public JDialPres(Frame parent, boolean modal,boolean isPress) {
            super(parent, modal,isPress);
            tblResult.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                   tblResultMousePressed(e);
                }
            });
        }
        
      public void tblResultMousePressed(MouseEvent evt){
        int r=tblResult.getSelectedRow();
        ArrayList<Object[]> lista=new ArrayList<>();
        

            if(tblResult.getSelectedRow()>=0){
                String codigo=tblResult.getValueAt(r, 0)+"";
                String DNI=tblResult.getValueAt(r, 1)+"";
                
                if(dp.BuscarBool(codigo, dp.SEARCH_CODE)){
                    
                    for(int b=0;b<dp.Lectura().size();b++){
                        Object[] libroT=new Object[10];
                        String libro=dp.Lectura().get(b)[8]+"";
                        String cantidad=dp.Lectura().get(b)[9]+"";
                        

                        if(ll.BuscarBool(libro, ll.SEARCH_TITLE)){
                              
                                for(int a=0;a<9;a++){
                                libroT[a]=ll.Lectura().get(0)[a];
                            }
                            
                        }
                         libroT[9]=cantidad;
                         lista.add(libroT);
                         
                    }
                }
                
                while(dt.getRowCount()!=0){dt.removeRow(0);}
                for(int i=0;i<lista.size();i++){
                    dt.addRow(lista.get(i));

                }
                                
                txtCodigo.setText(codigo);
                txtDNI.setText(DNI);


                this.dispose();
            }
        }
      
       
    }
    
   
}
