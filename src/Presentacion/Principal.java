/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Negocio.Desing;
import java.awt.Color;

/**
 *
 * @author andyv
 */
public final class Principal extends javax.swing.JFrame {
    private final Desing ds=new Desing();
    private final String ruta="src/Imagens/";
    
    public Principal() {
        initComponents();
        Inicial();
    }
    
    public void Inicial(){  
        setBackground(new Color(255,255,255));
        setLocationRelativeTo(this);
        
        header.Inicio(this,false);
        admin.ImageDs();
        admin.Form(this);
        finalizar.pImage();
        ds.AsignarImagen(lLogo);
        
        IniciarPanels();
        AsignarPanels();
    }
  
    
    public void IniciarPanels(){
        admin.setVisible(false);
        finalizar.setVisible(false);
        coneccion.setVisible(false);
    }
    
    public void AsignarPanels(){
     bienvenido.Panel(coneccion);
     coneccion.IniciarPanels(bienvenido, admin);
     admin.Panel(coneccion, finalizar);
     finalizar.Panel(admin,this);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        admin1 = new Presentacion.Panel.Admin();
        pSPrincipal = new PanelSpecial.JPanelSlider.PanelSlider();
        lLogo = new javax.swing.JLabel();
        bienvenido = new Presentacion.Panel.Bienvenido();
        coneccion = new Presentacion.Panel.Coneccion();
        admin = new Presentacion.Panel.Admin();
        finalizar = new Presentacion.Panel.Finalizar();
        header = new Presentacion.Components.WindowHeader();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(0, 0));
        setUndecorated(true);

        pSPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pSPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logo.png"))); // NOI18N
        pSPrincipal.add(lLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 160, 64));
        pSPrincipal.add(bienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        pSPrincipal.add(coneccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, 500));
        pSPrincipal.add(admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        pSPrincipal.add(finalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, -1, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pSPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pSPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Presentacion.Panel.Admin admin;
    private Presentacion.Panel.Admin admin1;
    private Presentacion.Panel.Bienvenido bienvenido;
    private Presentacion.Panel.Coneccion coneccion;
    private Presentacion.Panel.Finalizar finalizar;
    private Presentacion.Components.WindowHeader header;
    private javax.swing.JLabel lLogo;
    private PanelSpecial.JPanelSlider.PanelSlider pSPrincipal;
    // End of variables declaration//GEN-END:variables


}
