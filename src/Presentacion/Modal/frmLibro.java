/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Modal;

import DialogSpecial.JDialogSpecial.JDialogCustom;
import Negocio.Desing;
import Negocio.NLibro;
import java.awt.Color;
import javax.swing.ImageIcon;
import swing.ImageAvatar;

/**
 *
 * @author andyv
 */
public class frmLibro extends JDialogCustom {
    
    private NLibro libro=new NLibro("Codigo","Portada","Titulo","Autor","Publicación","Categoria","Editorial","Edición","Estado");
    private Desing ds=new Desing();
    private ImageIcon image=null;
    private String codigo;
    
    public frmLibro(java.awt.Frame parent, boolean modal,String codigo) {
        super(parent, modal);
        this.codigo=codigo;
        initComponents();
        setSize(parent.getSize());
        setBackground(new Color(0,0,0,150));
        Iniciar();
    }

    private void Iniciar(){
        
        
        if(libro.BuscarBool(codigo,libro.SEARCH_COD)){
            image=(ImageIcon) ((ImageAvatar)libro.Lectura().get(0)[1]).getImage();
            
            lblCodigo.setText("Codigo:  "+libro.Lectura().get(0)[0]);
            lblTitulo.setText(libro.Lectura().get(0)[2]+"");
            lblCategoria.setText(libro.Lectura().get(0)[5]+"");
            lblFPubli.setText("Fecha publicación:  "+libro.Lectura().get(0)[4]);
            lblAutor.setText("Autor:  "+libro.Lectura().get(0)[3]);
            lblEditorial.setText("Editorial:  "+libro.Lectura().get(0)[6]);
            lblEdicion.setText("Edición:  "+libro.Lectura().get(0)[7]);
            lblPortada.setIcon(image);
        }
        ds.AsignarImagen(lblPortada);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonHeader11 = new ButtonSpecial.JbtnHeader.JButtonHeader();
        lblPortada = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblAutor = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        lblEditorial = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        lblEdicion = new javax.swing.JLabel();
        lblFPubli = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButtonHeader11.setBackground(new java.awt.Color(255, 255, 255));
        jButtonHeader11.setBorder(null);
        jButtonHeader11.setText("X");
        jButtonHeader11.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButtonHeader11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHeader11ActionPerformed(evt);
            }
        });

        lblPortada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblTitulo.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblTitulo.setText("Titulo");

        lblAutor.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblAutor.setForeground(new java.awt.Color(102, 102, 102));
        lblAutor.setText("Autor:");

        lblCategoria.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblCategoria.setForeground(new java.awt.Color(102, 102, 102));
        lblCategoria.setText("Categoria");

        lblEditorial.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblEditorial.setForeground(new java.awt.Color(102, 102, 102));
        lblEditorial.setText("Editorial:");

        lblCodigo.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblCodigo.setForeground(new java.awt.Color(102, 102, 102));
        lblCodigo.setText("Codigo:");

        lblEdicion.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblEdicion.setForeground(new java.awt.Color(102, 102, 102));
        lblEdicion.setText("Edicion:");

        lblFPubli.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblFPubli.setForeground(new java.awt.Color(102, 102, 102));
        lblFPubli.setText("Fecha Publicación:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonHeader11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFPubli, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPortada, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(218, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButtonHeader11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPortada, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblCodigo)
                        .addGap(17, 17, 17)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCategoria)
                        .addGap(60, 60, 60)))
                .addGap(23, 23, 23)
                .addComponent(lblFPubli)
                .addGap(13, 13, 13)
                .addComponent(lblAutor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEditorial)
                .addGap(18, 18, 18)
                .addComponent(lblEdicion)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonHeader11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHeader11ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonHeader11ActionPerformed

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
            java.util.logging.Logger.getLogger(frmLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmLibro dialog = new frmLibro(new javax.swing.JFrame(), true,"");
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
    private ButtonSpecial.JbtnHeader.JButtonHeader jButtonHeader11;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblEdicion;
    private javax.swing.JLabel lblEditorial;
    private javax.swing.JLabel lblFPubli;
    private javax.swing.JLabel lblPortada;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
