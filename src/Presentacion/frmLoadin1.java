/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Negocio.Desing;
import Negocio.LectProp;
import static java.lang.Thread.sleep;

/**
 *
 * @author andyv
 */
public class frmLoadin1 extends javax.swing.JFrame {

    private LectProp lp=new LectProp(getClass().getResource("/Data/Inicio.properties").getPath());
    private Desing ds=new Desing();
    private Principal principal=null;
    private Login login=null;
    private int bar=0;

    public frmLoadin1() {
        initComponents();
        Inicio();
        Hilos();
        isVoid();
    }
    
    private void Inicio(){
        this.setLocationRelativeTo(this);
        ds.AsignarImagen(lblLogo);
        ds.AsignarImagen(lblFondo);
        pBar.setValue(45);
    }
    
    private boolean isVoid(){
       if(lp.Lectura("Carga.Login").equals("true")){
        return true;
        }
        
        return false;
    }
    
    private void Hilos(){
         new Thread(){
           @Override
           public void run() {
               try{
                  if(!isVoid()){
                        principal=new Principal();
                  }else{
                        login=new Login();
                      
                  }
                   
               }catch(Exception e){
                  
               }
           }
          }.start();
         
        
       
        new Thread(){
           @Override
           public void run() {
               try{
                   
                  while(true){
                   
                    if(principal!=null  || login!=null){
                        pBar.setValue(100);
                        lblCarga.setText("Listo");
                        
                        if(!isVoid()){
                            principal.setVisible(true);
                        }else{
                            login.setVisible(true);
                        }
                        
                        dispose();  
                        break;
                    }
                    sleep(50);
                  }
                   
                    
               }catch(Exception e){
                   System.out.println(e);
               }
           }
       }.start();
       
        new Thread(){
           @Override
           public void run() {
               try{
                  int i=0;
                  String txt="";
                  while(principal==null || login!=null){
                   
                    if(i==0){
                        txt="Cargando.";
                        i++;
                    }else if(i==1){
                        txt="Cargando..";
                        i++;
                    }else{
                        txt="Cargando...";
                        i=0;
                    }
                   
                    lblCarga.setText(txt);
                   sleep(100);
                  }
                   
                    
               }catch(Exception e){
                   System.out.println(e);
               }
           }
       }.start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pBar = new ProgressBar.JProgressBarCustom.JProgressCustom();
        jLabel1 = new javax.swing.JLabel();
        lblCarga = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pBar.setBgColor(new java.awt.Color(250, 250, 250));
        pBar.setBgValue(new java.awt.Color(0, 102, 255));
        pBar.setBorderPainted(false);
        jPanel1.add(pBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 324, 530, 20));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("<html>\n\t<p Style=\"Color:rgb(255,255,255);font-size:20px;\">   Programa de Biblioteca</p>\n\t<p Style=\"Color:rgb(230,230,230);font-size:10px;\">   El conocimiento es la mejor defensa.<p>\n<html>");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 8, 0, 0, new java.awt.Color(0, 153, 255)));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 310, 110));

        lblCarga.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblCarga.setForeground(new java.awt.Color(255, 255, 255));
        lblCarga.setText("Cargando...");
        jPanel1.add(lblCarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, 110, 40));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logo.png"))); // NOI18N
        jPanel1.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 150, 70));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/open-book.jpg"))); // NOI18N
        jPanel1.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 348));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmLoadin1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLoadin1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLoadin1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLoadin1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLoadin1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCarga;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblLogo;
    private ProgressBar.JProgressBarCustom.JProgressCustom pBar;
    // End of variables declaration//GEN-END:variables
}
