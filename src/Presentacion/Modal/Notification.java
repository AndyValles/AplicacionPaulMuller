/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Modal;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author andyv
 */
public class Notification extends javax.swing.JDialog {
      
      private Color bgColor=null;
      private  Timer tt=null;
      private JFrame frm=null;
      
      
      private int seg=0;
      public int ADVERTENCIA=0;
      public int EXITOSA=1;
      public int PELIGRO=2;
    
    
    
    public Notification(java.awt.Frame parent, boolean modal,int i,String dato1,String Info) {
        super(parent, modal);
        this.frm=(JFrame) parent;
        initComponents();
        Location(frm);
        Mostrar(i,dato1,Info);
        Animate(frm);
       
    }

    private void Location(JFrame frm){
        int x=frm.getX()+500,y=frm.getY()+50;
        setLocation(x, y);
    }
    
    
    
    private void Animate(JFrame frm){
       tt=new Timer(1000, (ActionEvent e) -> {
           Location(frm);
           seg++;
        if(seg==3){
            tt.stop();
            dispose();
        }
         
       });
      tt.start();
    }
    
    private Color color(int tipo){
        
        if(tipo==ADVERTENCIA){
            bgColor= new Color(242, 242, 58);
        }else if(tipo==EXITOSA){
            bgColor= new Color(0, 159, 0);
        }else{
            bgColor= new Color(208, 0, 0);
        }
        
        return bgColor;
    }
    
    private Icon img(int tipo){
        
      String ruta="/Imagens/";
        if(tipo==ADVERTENCIA){
            ruta+="advertencia_w.png";
        }else if(tipo==EXITOSA){
           ruta+="bien_w.png";
        }else{
            ruta+="Mal_w.png";
        }
           Icon image= new ImageIcon(getClass().getResource(ruta));
        return image;
    }
    
    private String dato(int tipo){
        String data="";
        if(tipo==ADVERTENCIA){
            data =" advertencia";
        }else if(tipo==EXITOSA){
           data =" exitoso";
        }else{
            data=" fallido";
        }
        return data;
    }
    
    public void Mostrar(int tipo,String dato1,String Info){
        
        lblInfo.setText(Info);
        lblDato.setText(dato1+dato(tipo));
        
        ColorDato.setBackground(color(tipo));
        image.setImage(img(tipo));
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ColorDato = new javax.swing.JPanel();
        image = new swing.ImageAvatar();
        lblDato = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ColorDato.setBackground(new java.awt.Color(0, 204, 0));

        image.setBackground(new java.awt.Color(0, 204, 0));
        image.setImage(new javax.swing.ImageIcon(getClass().getResource("/Imagens/bien_w.png"))); // NOI18N

        javax.swing.GroupLayout ColorDatoLayout = new javax.swing.GroupLayout(ColorDato);
        ColorDato.setLayout(ColorDatoLayout);
        ColorDatoLayout.setHorizontalGroup(
            ColorDatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ColorDatoLayout.setVerticalGroup(
            ColorDatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ColorDatoLayout.createSequentialGroup()
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(ColorDato, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 60));

        lblDato.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblDato.setText("Insertado exitoso");
        jPanel1.add(lblDato, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 140, -1));

        lblInfo.setText("El registro se agrego\n");
        jPanel1.add(lblInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 190, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Notification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Notification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Notification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Notification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Notification dialog = new Notification(new javax.swing.JFrame(), true,1,"","");
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
    private javax.swing.JPanel ColorDato;
    private swing.ImageAvatar image;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDato;
    private javax.swing.JLabel lblInfo;
    // End of variables declaration//GEN-END:variables
}
