/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Reporte;

import Negocio.NBusqueda;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author andyv
 */
public class RMas extends javax.swing.JPanel {
    
    private String[] datos=new  String[]{"Distrito","Carrera","Cargo","Profesión","País","Categoria"};
    private NBusqueda bb=new NBusqueda();
    
    public RMas() {
        initComponents();
        Iniciar();
    }
    
    private void Iniciar(){
        txtCodigo.setEnabled(false);
        cboEst.setEnabled(false);
        txtNombre.setEnabled(false);
        cbEstado.setEnabled(false);
    }
    
    private void IniCbo(){
        String[] l2=new String[]{"Todos","Activos","Desactivos"};
        for(String txt:bb.getBuscarPor()){cboEst.addItem(txt);}
        for(String txt:l2){cboEstado.addItem(txt);}
    }
    
    private void Ini(int i){
        lblTitulo.setText(datos[i]);
    }
    
    protected HashMap items(){
            Map parametro=new HashMap();
            parametro.put("user",txtCodigo.getText());
            if(cbCodigo.isSelected()){
                parametro.put("codigo",txtCodigo.getText());
            }else{ 
                parametro.put("codigo","%");}
            
            if(cbNombre.isSelected()){
                switch (cboEst.getSelectedIndex()) {
                    case 0:
                        parametro.put("nom",txtNombre.getText()+"%");
                        break;
                    case 1:
                        parametro.put("nom","%"+txtNombre.getText());
                        break;
                    default:
                        parametro.put("nom","%"+txtNombre.getText()+"%");
                        break;
                }
            }else{
                    parametro.put("nom","%");
            }
            
            if(cbEstado.isSelected()){
                switch (cboEstado.getSelectedIndex()) {
                    case 0:
                        parametro.put("estado1",true);
                        parametro.put("estado2",false);
                        break;
                    case 1:
                        parametro.put("estado1",true);
                        parametro.put("estado2",true);
                        break;
                    default:
                        parametro.put("estado1",false);
                        parametro.put("estado2",false);
                        break;
                }
            }else{
                parametro.put("estado1",true);       
                parametro.put("estado2",false);
            }
            
            return (HashMap) parametro;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        txtCodigo = new textfield.TextField();
        cboEstado = new combobox.Combobox();
        cboEst = new combobox.Combobox();
        txtNombre = new textfield.TextField();
        jLabel1 = new javax.swing.JLabel();
        cbNombre = new checkbox.JCheckBoxCustom();
        cbCodigo = new checkbox.JCheckBoxCustom();
        cbEstado = new checkbox.JCheckBoxCustom();

        setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 102, 255));
        lblTitulo.setText("Titulo");

        txtCodigo.setLabelText("Codigo");

        cboEstado.setLabeText("Estado");

        cboEst.setLabeText("Buscar por");

        txtNombre.setLabelText("Codigo");

        jLabel1.setText("Realizar  reporte por:");

        cbNombre.setText("Nombre");
        cbNombre.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cbNombreStateChanged(evt);
            }
        });

        cbCodigo.setText("Codigo");
        cbCodigo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cbCodigoStateChanged(evt);
            }
        });

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
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(cboEst, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(cboEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cbCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboEst, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbCodigoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbCodigoStateChanged
        txtCodigo.setEnabled(cbCodigo.isSelected());
    }//GEN-LAST:event_cbCodigoStateChanged

    private void cbNombreStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbNombreStateChanged
        cboEst.setEnabled(cbNombre.isSelected());
        txtNombre.setEnabled(cbNombre.isSelected());
    }//GEN-LAST:event_cbNombreStateChanged

    private void cbEstadoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbEstadoStateChanged
        cboEstado.setEnabled(cbEstado.isSelected());
    }//GEN-LAST:event_cbEstadoStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private checkbox.JCheckBoxCustom cbCodigo;
    private checkbox.JCheckBoxCustom cbEstado;
    private checkbox.JCheckBoxCustom cbNombre;
    protected combobox.Combobox cboEst;
    protected combobox.Combobox cboEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblTitulo;
    protected textfield.TextField txtCodigo;
    protected textfield.TextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
