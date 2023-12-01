/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Modal;

import DialogSpecial.JDialogSpecial.JDialogCustom;
import Entidad.Autor;
import Entidad.Cargo;
import Entidad.Carrera;
import Entidad.Categoria;
import Entidad.Distrito;
import Entidad.Editorial;
import Entidad.Egresado;
import Entidad.Estudiante;
import Entidad.Libro;
import Entidad.Pais;
import Entidad.Personal;
import Entidad.Profesion;
import Entidad.Usuario;
import Negocio.NAutor;
import Negocio.NCargo;
import Negocio.NCarrera;
import Negocio.NCategoria;
import Negocio.NDistrito;
import Negocio.NEditorial;
import Negocio.NEgresado;
import Negocio.NEstudiante;
import Negocio.NLibro;
import Negocio.NPais;
import Negocio.NPersonal;
import Negocio.NProfesion;
import Negocio.NUsuario;
import Negocio.Desing;
import java.awt.Color;
import java.awt.event.MouseAdapter;

/**
 *
 * @author andyv
 */
public class Eliminar extends JDialogCustom {
    
    private Desing ds=new Desing();
    
    private NAutor Nautor=new NAutor();
    private NCargo Ncargo=new NCargo();
    private NCarrera Ncarrera=new NCarrera();
    private NCategoria Ncategoria=new NCategoria();
    private NDistrito Ndistrito=new NDistrito();
    private NEditorial Neditorial=new NEditorial();
    private NLibro Nlibro= new NLibro();
    private NPais Npais=new NPais();
    private NProfesion Nprofesion=new NProfesion();
    private NEstudiante Nestudiante=new NEstudiante();
    private NEgresado Negresado=new NEgresado();
    private NPersonal Npersonal=new NPersonal();
    private NUsuario Nusuario=new NUsuario();
    
    
    private Autor autor=new Autor();
    private Cargo cargo=new Cargo();
    private Carrera carrera=new Carrera();
    private Categoria categoria=new Categoria();
    private Distrito distrito=new Distrito();
    private Editorial editorial=new Editorial();
    private Libro libro= new Libro();
    private Pais pais=new Pais();
    private Profesion profesion=new Profesion();
    private Estudiante estudiante=new Estudiante();
    private Egresado egresado=new Egresado();
    private Personal personal=new Personal();
    private Usuario usuario=new Usuario();

    public int Autor =1;
    public int Cargo =2;
    public int Carrera = 3;
    public int Categoria = 4;
    public int Distrito = 5;
    public int Editorial = 6;
    public int Libro =  7;
    public int Pais = 8;
    public int Profesion = 9; 
    public int Estudiante = 10;
    public int Egresado = 11;
    public int Personal = 12;
    public int Usuario = 13;
    
    
    private int datos;
    public Eliminar(java.awt.Frame parent, boolean modal,int datos,Object data) {
        super(parent, modal);
        initComponents();
        
        this.datos=datos;
        
        ds.AsignarImagen(image);
        Iniciar(data);
        
        setBackground(new Color(0,0,0,150));
        setSize(parent.getSize());
    }
    
    private void Iniciar(Object info){
        switch(datos){
            case 1:
                autor.setCodigo(Integer.parseInt((String) info));
                break;
            case 2:
                cargo.setCodigo(Integer.parseInt((String) info));
                break;
            case 3:
                carrera.setCodigo(Integer.parseInt((String) info));
                break;
            case 4:
                categoria.setCodigo(Integer.parseInt((String) info));
                break;
            case 5:
                distrito.setCodigo(Integer.parseInt((String) info));
                break;
            case 6:
                editorial.setCodigo(Integer.parseInt((String) info));
                break;
            case 7:
                libro.setCodigo((String) info);
                break;
            case 8:
                pais.setCodigo(Integer.parseInt((String) info));
                break;
            case 9:
                profesion.setCodigo(Integer.parseInt((String) info));
                break;
            case 10:
                estudiante.setDNI((String) info);
                break;
            case 11:
                egresado.setDNI((String) info);
                break;
            case 12:
                personal.setDNI((String) info);
                break;
            case 13:
                usuario.setDNI((String) info);
                break;
        }
    }
    
    public void Select(MouseAdapter l){
        btnEliminar.addMouseListener(l);
    }
    
    public void info(String c,String item){
        lblInfo.setText("¿Desea eliminar el " +c+":"+ item +"?");
    }

    private void Eliminar(){
        switch(datos){
            case 1:
                Nautor.Eliminar(autor);
                break;
            case 2:
                Ncargo.Eliminar(cargo);
                break;
            case 3:
                Ncarrera.Eliminar(carrera);
                break;
            case 4:
                Ncategoria.Eliminar(categoria);
                break;
            case 5:
                Ndistrito.Eliminar(distrito);
                break;
            case 6:
                Neditorial.Eliminar(editorial);
                break;
            case 7:
                Nlibro.Eliminar(libro);
                break;
            case 8:
                Npais.Eliminar(pais);
                break;
            case 9:
                Nprofesion.Eliminar(profesion);
                break;
            case 10:
                Nestudiante.Eliminar(estudiante);
                break;
            case 11:
                Negresado.Eliminar(egresado);
                break;
            case 12:
                Npersonal.Eliminar(personal);
                break;
            case 13:
                Nusuario.Eliminar(usuario);
                break;
        }
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblInfo = new javax.swing.JLabel();
        btnEliminar = new ButtonSpecial.JbtnRadius.JButtonRadius();
        btnCancelar = new ButtonSpecial.JbtnRadius.JButtonRadius();
        image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInfo.setText("¿Desea eliminar el usuario: ?");

        btnEliminar.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminar.setBorder(null);
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setColorBackground(new java.awt.Color(255, 0, 0));
        btnEliminar.setColorClick(new java.awt.Color(255, 102, 102));
        btnEliminar.setColorOver(new java.awt.Color(255, 51, 51));
        btnEliminar.setColorText(new java.awt.Color(255, 255, 255));
        btnEliminar.setFocusPainted(false);
        btnEliminar.setRadius(15);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(51, 204, 255));
        btnCancelar.setBorder(null);
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setColorBackground(new java.awt.Color(51, 204, 255));
        btnCancelar.setColorClick(new java.awt.Color(0, 153, 255));
        btnCancelar.setColorOver(new java.awt.Color(102, 204, 255));
        btnCancelar.setColorText(new java.awt.Color(255, 255, 255));
        btnCancelar.setFocusPainted(false);
        btnCancelar.setRadius(15);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Eliminar.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(40, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(215, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(243, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Eliminar();
        this.dispose();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Eliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Eliminar dialog = new Eliminar(new javax.swing.JFrame(),true,1,null);
                
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
    private ButtonSpecial.JbtnRadius.JButtonRadius btnCancelar;
    protected ButtonSpecial.JbtnRadius.JButtonRadius btnEliminar;
    private javax.swing.JLabel image;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblInfo;
    // End of variables declaration//GEN-END:variables
}
