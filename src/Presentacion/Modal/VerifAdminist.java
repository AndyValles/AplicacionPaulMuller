/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Modal;

import DialogSpecial.JDialogSpecial.JDialogCustom;
import Negocio.Correo;
import Negocio.NCargo;
import Negocio.NPersonal;
import Negocio.DatosRandom;
import Negocio.ExtratorDatos;
import Negocio.Time;
import Presentacion.frmPrograma;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author andyv
 */
public class VerifAdminist extends JDialogCustom {
     private DatosRandom rd=new DatosRandom();
     private ExtratorDatos dt=null;
     private Correo car=new Correo();
     
     private  String[] Datos=new String[]{"Usuario","Muy Buenas Tardes","FFFF","example@gmail.com"}; 
     private  int mostInt=0,codInt=0;
     private  String codigo="";
     
     private NPersonal pp=new NPersonal();
     private NCargo cc=new NCargo();
     
     private Time t=new Time();
     private JFrame frm=new JFrame();
     
    public VerifAdminist(JFrame parent, boolean modal) {
        super(parent, modal); 
        this.frm=parent;
         
        initComponents();
        
        try{
           dt=new ExtratorDatos(getClass().getResource("/Data/Mensaje.txt").openStream());
        }catch(Exception e){}
        
       
       
        Inicial();
    }
    
    private void Inicial(){
        VisibleComp(false,true);
        setSize(frm.getWidth(),frm.getHeight());
        setBackground(new Color(200,200,0));
    }
    
    
    private void VisibleComp(boolean v1,boolean v2){
        txtCodigo.setVisible(v1);
        btnComp.setVisible(v1);
        
        txtCorreo.setVisible(v2);
        btnEnvCod.setVisible(v2);
    }
    
    
    
    private void iniciarCorreo(){//Envio de codigo
       String Cor=txtCorreo.getText().trim();
      
        if(pp.BuscarBool(Cor, pp.SEARCH_CORREO)){//lectura del sistema
            
            if(pp.Lectura().get(0)[13].toString().toLowerCase().equals("administrador")){//verifica si es administrador
                codigo=rd.Randon(4);//Agregar codigo
                if(car.Message(Cor, EnviarCorreo(pp.Lectura().get(0)[2]+" "+pp.Lectura().get(0)[3],"Muy "+t.horaSaludo(),codigo,Cor))){//verificar el envio de codigo al email
                    VisibleComp(true,false);//Se visualiza la casilla para el codigo
                    if(mostInt<1)mostInt=1;
                }else{
                     lblECo.setText("<html>El correo no es valio en la red verifique su email</html>");
                }
            }else{
                lblECo.setText("<html>No eres Administrador</html>");
            }
     
        }else{
            lblECo.setText("<html>El correo no se encuentra registrado por favor"
                    + " digitar un correo valido 'Ojo: Esta seccion solo es para personal'</html>");
        }
    }
    
    private String EnviarCorreo(String ...dTxt){
     String dato=dt.LeerArchivos(3186).replaceAll(Datos[0], dTxt[0]);
     for(int i=1;i<Datos.length;i++){
            dato=dato.replaceAll(Datos[i], dTxt[i]);
     }
     return dato;
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelRound1 = new test.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new textfield.TextField();
        btnEnvCod = new ButtonSpecial.JbtnRadius.JButtonRadius();
        btnComp = new ButtonSpecial.JbtnRadius.JButtonRadius();
        txtCorreo = new textfield.TextField();
        btnAnterior = new ButtonSpecial.JbtnRadius.JButtonRadius();
        lblECo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 204, 255));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        panelRound1.setRoundBottomLeft(50);
        panelRound1.setRoundBottomRight(50);
        panelRound1.setRoundTopLeft(50);
        panelRound1.setRoundTopRight(50);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("<html>Si en caso eres administrador ingrese su correo registrado en el programa para el envio de codigo para su correspondiente verificacion\n</html>");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setText("Verificar Codigo");

        txtCodigo.setLabelText("Codigo");
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        btnEnvCod.setBackground(new java.awt.Color(0, 102, 255));
        btnEnvCod.setBorder(null);
        btnEnvCod.setForeground(new java.awt.Color(255, 255, 255));
        btnEnvCod.setColorBackground(new java.awt.Color(0, 102, 255));
        btnEnvCod.setColorClick(new java.awt.Color(102, 204, 255));
        btnEnvCod.setColorOver(new java.awt.Color(51, 204, 255));
        btnEnvCod.setColorText(new java.awt.Color(255, 255, 255));
        btnEnvCod.setFocusPainted(false);
        btnEnvCod.setLabel("Enviar codigo");
        btnEnvCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnvCodActionPerformed(evt);
            }
        });

        btnComp.setBackground(new java.awt.Color(0, 102, 255));
        btnComp.setBorder(null);
        btnComp.setForeground(new java.awt.Color(255, 255, 255));
        btnComp.setColorBackground(new java.awt.Color(0, 102, 255));
        btnComp.setColorOver(new java.awt.Color(51, 204, 255));
        btnComp.setColorText(new java.awt.Color(255, 255, 255));
        btnComp.setFocusPainted(false);
        btnComp.setLabel("Combrobar codigo");
        btnComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompActionPerformed(evt);
            }
        });

        txtCorreo.setLabelText("Correo");
        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCorreoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoFocusLost(evt);
            }
        });
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoKeyTyped(evt);
            }
        });

        btnAnterior.setBackground(new java.awt.Color(0, 102, 255));
        btnAnterior.setBorder(null);
        btnAnterior.setForeground(new java.awt.Color(255, 255, 255));
        btnAnterior.setText("Anterior");
        btnAnterior.setColorBackground(new java.awt.Color(0, 102, 255));
        btnAnterior.setColorOver(new java.awt.Color(0, 204, 255));
        btnAnterior.setColorText(new java.awt.Color(255, 255, 255));
        btnAnterior.setFocusPainted(false);
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        lblECo.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(jLabel2))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(lblECo, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnComp, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEnvCod, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblECo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnComp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnvCod, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnvCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnvCodActionPerformed
     
        if(!txtCorreo.getText().isEmpty()){iniciarCorreo();}
       else{
           lblECo.setText("<html>Debe ingresar un correo para el envio del"
                   + " codigo</html>");
       }
    }//GEN-LAST:event_btnEnvCodActionPerformed

    private void btnCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompActionPerformed
        String cod=txtCodigo.getText().trim();
            if(!cod.isEmpty()){
                if(cod.equals(codigo)){
                    frm.dispose();
                    new frmPrograma().setVisible(true);
                }else{
                    if(codInt<3){lblECo.setText("El codigo es incorrecto vuelva a intentarlo");}
                    else{this.dispose();}
                    codInt++;
                }
            }else{
                 lblECo.setText("Debe agregar un codigo");
            }
        
    }//GEN-LAST:event_btnCompActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        if(mostInt==0){
            this.dispose();
        }else{
             VisibleComp(false,true);
            if(mostInt!=0)mostInt-=1;
        }
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void txtCorreoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusGained
         String correo=txtCorreo.getText().trim();
         setBackground(new Color(200,0,0));
        if(!correo.isEmpty()){
            txtCorreo.setText(correo.replaceAll("@gmail.com", ""));
        }
    }//GEN-LAST:event_txtCorreoFocusGained

    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost
        String correo=txtCorreo.getText().trim();
        if(!correo.isEmpty()){
            correo=correo.replaceAll("@gmail.com", "");
            txtCorreo.setText(correo+"@gmail.com");
        }
    }//GEN-LAST:event_txtCorreoFocusLost

    private void txtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyTyped
         String correo=txtCorreo.getText().trim();
         lblECo.setText("");
         txtCorreo.setText(correo);
         
        if(correo.length()>30){
            evt.consume();
        }
    }//GEN-LAST:event_txtCorreoKeyTyped

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        String cod=txtCodigo.getText();
        lblECo.setText("");
        if(cod.length()>=4){
            evt.consume();
        }
    }//GEN-LAST:event_txtCodigoKeyTyped

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
            java.util.logging.Logger.getLogger(VerifAdminist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerifAdminist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerifAdminist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerifAdminist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VerifAdminist dialog = new VerifAdminist(new javax.swing.JFrame(), true);
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
    private ButtonSpecial.JbtnRadius.JButtonRadius btnAnterior;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnComp;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnEnvCod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblECo;
    private test.PanelRound panelRound1;
    private textfield.TextField txtCodigo;
    private textfield.TextField txtCorreo;
    // End of variables declaration//GEN-END:variables
}
