/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Reporte;

import Negocio.NBusqueda;
import Negocio.NPais;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author andyv
 */
public class REditorial extends javax.swing.JPanel {
    
    private NPais ee=new NPais();
    private NBusqueda bb=new NBusqueda();
    
    public REditorial() {
        initComponents();
        Iniciar();
        IniCbo();
    }

    private void Iniciar(){
        txtCodigo.setEnabled(false);
        txtNombre.setEnabled(false);
        cboEst.setEnabled(false);
        cboPais.setEnabled(false);
    }
    
    private void IniCbo(){
        for(Object o:ee.cboPais()){cboPais.addItem(o);}
        for(Object o:bb.getBuscarPor()){cboEst.addItem(o);}
    }
    
    protected HashMap items(){
            Map parametro=new HashMap();
            String codigo="%";
            String nombre="%";
            String pais="%";
            
            if(cbCodigo.isSelected()){codigo=txtCodigo.getText();}
            
            if(cbNombre.isSelected()){
                switch (cboEst.getSelectedIndex()) {
                    case 0:
                        nombre=txtNombre.getText()+"%";
                        break;
                    case 1:
                        nombre="%"+txtNombre.getText();
                        break;
                    case 2:
                       nombre="%"+txtNombre.getText()+"%";
                        break;
                    case 3:
                       nombre=txtNombre.getText();
                        break;
                }
            }
            
            if(cbPais.isSelected()){pais=cboPais.getSelectedItem()+"";}
            
            parametro.put("nombre",nombre);
            parametro.put("pais",pais);
            parametro.put("codigo",codigo);

            
            return (HashMap) parametro;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbCodigo = new checkbox.JCheckBoxCustom();
        txtCodigo = new textfield.TextField();
        cboEst = new combobox.Combobox();
        cbNombre = new checkbox.JCheckBoxCustom();
        cbPais = new checkbox.JCheckBoxCustom();
        txtNombre = new textfield.TextField();
        cboPais = new combobox.Combobox();

        setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 102, 255));
        lblTitulo.setText("Editorial");

        jLabel1.setText("Realizar  reporte por:");

        cbCodigo.setText("Codigo");
        cbCodigo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cbCodigoStateChanged(evt);
            }
        });

        txtCodigo.setLabelText("Codigo");

        cboEst.setLabeText("Buscar por");

        cbNombre.setText("Nombre");
        cbNombre.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cbNombreStateChanged(evt);
            }
        });

        cbPais.setText("Pais");
        cbPais.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cbPaisStateChanged(evt);
            }
        });

        txtNombre.setLabelText("Nombre");

        cboPais.setLabeText("Pais");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cboEst, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(cbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cboPais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(420, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboEst, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboPais, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbCodigoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbCodigoStateChanged
         txtCodigo.setEnabled(cbCodigo.isSelected());
    }//GEN-LAST:event_cbCodigoStateChanged

    private void cbNombreStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbNombreStateChanged
        txtNombre.setEnabled(cbNombre.isSelected());
        cboEst.setEnabled(cbNombre.isSelected());
    }//GEN-LAST:event_cbNombreStateChanged

    private void cbPaisStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbPaisStateChanged
         cboPais.setEnabled(cbPais.isSelected());
    }//GEN-LAST:event_cbPaisStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private checkbox.JCheckBoxCustom cbCodigo;
    private checkbox.JCheckBoxCustom cbNombre;
    private checkbox.JCheckBoxCustom cbPais;
    protected combobox.Combobox cboEst;
    protected combobox.Combobox cboPais;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblTitulo;
    protected textfield.TextField txtCodigo;
    protected textfield.TextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
