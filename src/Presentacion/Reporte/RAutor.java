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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author andyv
 */
public class RAutor extends javax.swing.JPanel {

    private NBusqueda bb=new NBusqueda();
    private NPais pp=new NPais();
    
    public RAutor() {
        initComponents();
        Iniciar();
        IniCbo();
    }

    private void Iniciar(){
        txtCodigo.setEnabled(false);
        cboEst.setEnabled(false);
        txtNombre.setEnabled(false);
        cboEst1.setEnabled(false);
        txtApeP.setEnabled(false);
        cboEst2.setEnabled(false);
        txtApeM.setEnabled(false);
        cboPais.setEnabled(false);
    }
    
    private void IniCbo(){
        for(Object o:pp.cboPais()){cboPais.addItem(o);}
        for(Object o:bb.getBuscarPor()){cboEst.addItem(o);}
        for(Object o:bb.getBuscarPor()){cboEst1.addItem(o);}
        for(Object o:bb.getBuscarPor()){cboEst2.addItem(o);}
    }
    
    private String Datos(JComboBox cbo,JTextField txt){
        return bb.SQL(cbo.getSelectedIndex(), txt.getText());
    }
    
    protected HashMap items(){
            Map parametro=new HashMap();
            String codigo="%",pais="%",nombre="%",apeP="%",apeM="%";
            
            if(cbCodigo.isSelected()){codigo=txtCodigo.getText();}
            if(cbPais.isSelected()){pais=cboPais.getSelectedItem()+"";}
            if(cbNombre.isSelected()){nombre=Datos(cboEst,txtNombre);}
            if(cbApe.isSelected()){
                apeP=Datos(cboEst1,txtApeP);
                apeM=Datos(cboEst2,txtApeM);
            }
            
            parametro.put("nombre",nombre);
            parametro.put("apeP",apeP);
            parametro.put("apeM",apeM);
            parametro.put("pais",pais);
            parametro.put("codigo",codigo);

            
            return (HashMap) parametro;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbCodigo = new checkbox.JCheckBoxCustom();
        cboEst = new combobox.Combobox();
        txtCodigo = new textfield.TextField();
        cbNombre = new checkbox.JCheckBoxCustom();
        cbApe = new checkbox.JCheckBoxCustom();
        cbPais = new checkbox.JCheckBoxCustom();
        txtNombre = new textfield.TextField();
        cboEst1 = new combobox.Combobox();
        txtApeP = new textfield.TextField();
        txtApeM = new textfield.TextField();
        cboEst2 = new combobox.Combobox();
        cboPais = new combobox.Combobox();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 102, 255));
        lblTitulo.setText("Autor");

        jLabel1.setText("Realizar  reporte por:");

        cbCodigo.setText("Codigo");
        cbCodigo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cbCodigoStateChanged(evt);
            }
        });

        cboEst.setLabeText("Buscar por");

        txtCodigo.setLabelText("Codigo");

        cbNombre.setLabel("Nombre");
        cbNombre.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cbNombreStateChanged(evt);
            }
        });

        cbApe.setLabel("Apellido");
        cbApe.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cbApeStateChanged(evt);
            }
        });

        cbPais.setText("Pais");
        cbPais.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cbPaisStateChanged(evt);
            }
        });

        txtNombre.setLabelText("Nombre");

        cboEst1.setLabeText("Buscar por");

        txtApeP.setLabelText("Apellido paterno");

        txtApeM.setLabelText("Apellido Materno");

        cboEst2.setLabeText("Buscar por");

        cboPais.setLabeText("Pais");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(cbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbApe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cboPais, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(cboEst2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtApeM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(cboEst1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtApeP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(cboEst, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)))
                .addContainerGap(409, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbApe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboEst, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboEst1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApeP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboEst2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApeM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(cboPais, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbCodigoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbCodigoStateChanged
        txtCodigo.setEnabled(cbCodigo.isSelected());
    }//GEN-LAST:event_cbCodigoStateChanged

    private void cbNombreStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbNombreStateChanged
       cboEst.setEnabled(cbNombre.isSelected());
       txtNombre.setEnabled(cbNombre.isSelected());
    }//GEN-LAST:event_cbNombreStateChanged

    private void cbApeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbApeStateChanged
       cboEst1.setEnabled(cbApe.isSelected());
       txtApeP.setEnabled(cbApe.isSelected());
       cboEst2.setEnabled(cbApe.isSelected());
       txtApeM.setEnabled(cbApe.isSelected());
    }//GEN-LAST:event_cbApeStateChanged

    private void cbPaisStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbPaisStateChanged
        cboPais.setEnabled(cbPais.isSelected());
    }//GEN-LAST:event_cbPaisStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private checkbox.JCheckBoxCustom cbApe;
    private checkbox.JCheckBoxCustom cbCodigo;
    private checkbox.JCheckBoxCustom cbNombre;
    private checkbox.JCheckBoxCustom cbPais;
    protected combobox.Combobox cboEst;
    protected combobox.Combobox cboEst1;
    protected combobox.Combobox cboEst2;
    protected combobox.Combobox cboPais;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitulo;
    protected textfield.TextField txtApeM;
    protected textfield.TextField txtApeP;
    protected textfield.TextField txtCodigo;
    protected textfield.TextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
