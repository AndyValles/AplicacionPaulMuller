/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Negocio.NAutor;
import Negocio.NCategoria;
import Negocio.NDevolucion;
import Negocio.NEditorial;
import Negocio.NLibro;
import Negocio.NPrestamo;
import Negocio.NUsuario;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andyv
 */
public class frmPrograma extends javax.swing.JFrame {
    private String txt="";
    private String Codigo;
    
    private NPrestamo prestamo=new NPrestamo();
    private NDevolucion devolucion=new NDevolucion();
    private NLibro libro=new NLibro();
    private NAutor autor=new NAutor();
    private NEditorial editorial=new NEditorial();
    private NCategoria categoria=new NCategoria();
    
    private NUsuario uu=new NUsuario();
    
    private DefaultTableModel[] cant=new DefaultTableModel[]{};
    
    public frmPrograma(String txt) {
        this.txt=txt;
        Iniciar();
        
    }
    
    
    public frmPrograma() {
        Iniciar();
    }
    
    private void IniText(){
        String nombre="Andy Jesus";
        
        if(uu.BuscarBool(txt,uu.SEARCH_DNI)){
            nombre=uu.Lectura().get(0)[2]+" "+uu.Lectura().get(0)[4];
        } 
        
        menuPri.Presentacion(nombre);
        menuPri.IniciarText(prestamo.CantidadTotal(),devolucion.CantidadTotal(),libro.cantidad(),
                autor.Cantidad(),uu.Cantidad(),0,editorial.Cantidad(),categoria.Cantidad());
    }

    private void Iniciar(){
       initComponents();
       this.setLocationRelativeTo(this);
       header.Inicio(this,true);
       
       IniciarPanels();
       IniciarSelected();
       
       menu.IniForm(this);
       proceso.IniFrm(this);
       pLibro.IniFrm(this);
       reportes.IniFrm(this);

       menu.IniciarImagenes();
       pAdmin.iniciarImage();
       menuPri.IniciarImages();
       proceso.iniImage();
       
       reportes.iniciar();
       IniText();
       
       if(!txt.isEmpty()){ObtenerDatos();}
       
   }
   

   private void IniciarPanels(){
       menu.IniPanel(0,menuPri,pLibro,proceso,reportes,pAdmin);
   }
   
   private void IniciarSelected(){
    
    menu.SelectAdmin(new MouseAdapter(){
           @Override
           public void mousePressed(MouseEvent e) {
               iniAdmin();
           }
       });
   }
   
   private void iniAdmin(){
       pAdmin.Iniform(this);
   }
   
   
   private void ObtenerDatos(){
       menu.IniciarItems(txt);
   } 
   

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        admin1 = new Presentacion.Panel.Admin();
        header = new Presentacion.Components.WindowHeader();
        menu = new Presentacion.Components.Menu();
        jPanel1 = new javax.swing.JPanel();
        menuPri = new Presentacion.Panel.MenuPrincipal();
        pAdmin = new Presentacion.Panel.PanelAdministrador();
        proceso = new Presentacion.Panel.Procesos();
        reportes = new Presentacion.Panel.Reportes();
        pLibro = new Presentacion.Panel.pLibros();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImages(null);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new javax.swing.OverlayLayout(jPanel1));
        jPanel1.add(menuPri);
        jPanel1.add(pAdmin);
        jPanel1.add(proceso);
        jPanel1.add(reportes);
        jPanel1.add(pLibro);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
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
            java.util.logging.Logger.getLogger(frmPrograma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrograma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrograma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrograma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrograma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Presentacion.Panel.Admin admin1;
    private Presentacion.Components.WindowHeader header;
    private javax.swing.JPanel jPanel1;
    private Presentacion.Components.Menu menu;
    private Presentacion.Panel.MenuPrincipal menuPri;
    private Presentacion.Panel.PanelAdministrador pAdmin;
    private Presentacion.Panel.pLibros pLibro;
    private Presentacion.Panel.Procesos proceso;
    private Presentacion.Panel.Reportes reportes;
    // End of variables declaration//GEN-END:variables
}
