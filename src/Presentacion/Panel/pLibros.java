/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Panel;

import Negocio.NLibro;
import Presentacion.Components.CompLibro;
import Presentacion.Modal.frmLibro;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author andyv
 */
public class pLibros extends javax.swing.JPanel {

    private JFrame frm;
    
    private NLibro libro=new NLibro("Codigo");
    private List<LibroCom> btnLibro=new ArrayList<>();
   
    private String txt;
    
    public pLibros() {
        initComponents();
        DinamicBtn();
    }

    private void DinamicBtn(){
        
       for(int i=0;i<libro.Leer().getRowCount();i++){
           String cod=libro.Leer().getValueAt(i, 0)+"";
           LibroCom lib=new LibroCom(cod);
           btnLibro.add(lib);
           btnLibro.get(i).ImgIni();
           pnLib.add(btnLibro.get(i), "btn"+i);
           
       }
    }
    
    public void IniFrm(JFrame frm){this.frm=frm;}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScroll1 = new ScrollPaneSpecial.JScrollPane.JScroll();
        pnLib = new javax.swing.JPanel();
        lblDial = new javax.swing.JLabel();
        lblTxt = new javax.swing.JLabel();

        setBackground(new java.awt.Color(250, 250, 250));
        setMinimumSize(new java.awt.Dimension(834, 490));

        pnLib.setBackground(new java.awt.Color(250, 250, 250));
        pnLib.setLayout(new java.awt.GridLayout(0, 5, 10, 10));
        jScroll1.setViewportView(pnLib);

        lblDial.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblDial.setForeground(new java.awt.Color(0, 102, 255));
        lblDial.setText("Libros");
        lblDial.setToolTipText("");

        lblTxt.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        lblTxt.setForeground(new java.awt.Color(0, 102, 255));
        lblTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTxt.setText("Vista de los libros registrados");
        lblTxt.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDial, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTxt)
                .addGap(12, 12, 12)
                .addComponent(jScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ScrollPaneSpecial.JScrollPane.JScroll jScroll1;
    private javax.swing.JLabel lblDial;
    private javax.swing.JLabel lblTxt;
    private javax.swing.JPanel pnLib;
    // End of variables declaration//GEN-END:variables
    private class LibroCom extends CompLibro{
        private String codigo;
        
        public LibroCom(String cod) {
           Iniciar(cod);
           this.codigo=cod;
            btnSelect.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                   Select(e);
                }
            
            });
        }
        
        public void ImgIni(){IniImage();}
       
        private void Select(MouseEvent e){
            new frmLibro(frm, true, codigo).setVisible(true);
        }
    }
}

