/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Panel;

import Negocio.Desing;
import Negocio.Time;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import javax.swing.JPanel;


/**
 *
 * @author andyv
 */
public class Bienvenido extends javax.swing.JPanel {
   private JPanel panel;
    
    private String ruta="src/Imagens/";
    private Desing ds=new Desing(); 
    private Time tm=new Time();
    
    public Bienvenido() {
        Iniciar();
    }
    
    private void Iniciar(){
     initComponents();
        IniciarText();
    }
    
    private void ColorTiempo(Color sol,Color paisaje,Color pasto){
        pSol.setBackground(sol);
        pPaisaje.setBackground(paisaje);        
        pPasto.setBackground(pasto);        
    }
    
    private void IniciarText(){
        int tiempo=tm.HoraActual();
        
        if(tiempo>=6 && tiempo<12){
            ColorTiempo(new Color(255,204,51),new Color(51,204,255),new Color(102,255,0));
        }else if(tiempo>=12 && tiempo<18){
            ColorTiempo(new Color(255,153,0),new Color(255,157,80),new Color(51,153,0));
        }else{
            ColorTiempo(new Color(204,204,204),new Color(18,34,88),new Color(102,153,0));
        }
        
        jTexto.setText("Bienvenido(a), Muy "+tm.horaSaludo());
    }
    
   public void Panel(JPanel panel){
       this.panel=panel;
   }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTexto = new javax.swing.JLabel();
        pPaisaje = new test.PanelRound();
        panelRound3 = new test.PanelRound();
        pSol = new test.PanelRound();
        panelRound5 = new test.PanelRound();
        panelRound6 = new test.PanelRound();
        panelRound7 = new test.PanelRound();
        panelRound8 = new test.PanelRound();
        panelRound9 = new test.PanelRound();
        panelRound10 = new test.PanelRound();
        panelRound11 = new test.PanelRound();
        pPasto = new test.PanelRound();
        btnSiguiente = new ButtonSpecial.JbtnRadius.JButtonRadius();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("<html>\nEste es el programa de biblioteca  segun el usuario usted podra ver libros por categorias y informaciones interesantes,\nAntes de continuar con el programa  debe realizar algunas configuraciones. Presione siguiente</html>\n");

        jTexto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTexto.setText("Bienvenido(a), Muy Buenas Tardes");

        pPaisaje.setBackground(new java.awt.Color(18, 34, 88));
        pPaisaje.setRoundTopLeft(500);
        pPaisaje.setRoundTopRight(500);
        pPaisaje.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound3.setBackground(new java.awt.Color(255, 255, 255));
        panelRound3.setRoundBottomLeft(100);
        panelRound3.setRoundBottomRight(100);
        panelRound3.setRoundTopLeft(100);
        panelRound3.setRoundTopRight(100);

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        pPaisaje.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 90, 20));

        pSol.setBackground(new java.awt.Color(204, 204, 204));
        pSol.setRoundBottomLeft(100);
        pSol.setRoundBottomRight(100);
        pSol.setRoundTopLeft(100);
        pSol.setRoundTopRight(100);

        javax.swing.GroupLayout pSolLayout = new javax.swing.GroupLayout(pSol);
        pSol.setLayout(pSolLayout);
        pSolLayout.setHorizontalGroup(
            pSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        pSolLayout.setVerticalGroup(
            pSolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        pPaisaje.add(pSol, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 70, 70));

        panelRound5.setBackground(new java.awt.Color(255, 255, 255));
        panelRound5.setRoundBottomLeft(100);
        panelRound5.setRoundBottomRight(100);
        panelRound5.setRoundTopLeft(100);
        panelRound5.setRoundTopRight(100);

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        pPaisaje.add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 90, 20));

        panelRound6.setBackground(new java.awt.Color(255, 255, 255));
        panelRound6.setRoundBottomLeft(100);
        panelRound6.setRoundBottomRight(100);
        panelRound6.setRoundTopLeft(100);
        panelRound6.setRoundTopRight(100);

        javax.swing.GroupLayout panelRound6Layout = new javax.swing.GroupLayout(panelRound6);
        panelRound6.setLayout(panelRound6Layout);
        panelRound6Layout.setHorizontalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );
        panelRound6Layout.setVerticalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        pPaisaje.add(panelRound6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 90, 20));

        panelRound7.setBackground(new java.awt.Color(0, 204, 0));
        panelRound7.setRoundBottomLeft(100);
        panelRound7.setRoundBottomRight(100);
        panelRound7.setRoundTopLeft(100);
        panelRound7.setRoundTopRight(100);

        javax.swing.GroupLayout panelRound7Layout = new javax.swing.GroupLayout(panelRound7);
        panelRound7.setLayout(panelRound7Layout);
        panelRound7Layout.setHorizontalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panelRound7Layout.setVerticalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        pPaisaje.add(panelRound7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 40, 30));

        panelRound8.setBackground(new java.awt.Color(0, 204, 0));
        panelRound8.setRoundBottomLeft(100);
        panelRound8.setRoundBottomRight(100);
        panelRound8.setRoundTopLeft(100);
        panelRound8.setRoundTopRight(100);

        javax.swing.GroupLayout panelRound8Layout = new javax.swing.GroupLayout(panelRound8);
        panelRound8.setLayout(panelRound8Layout);
        panelRound8Layout.setHorizontalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panelRound8Layout.setVerticalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        pPaisaje.add(panelRound8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, -1, -1));

        panelRound9.setBackground(new java.awt.Color(0, 204, 0));
        panelRound9.setRoundBottomLeft(100);
        panelRound9.setRoundBottomRight(100);
        panelRound9.setRoundTopLeft(100);
        panelRound9.setRoundTopRight(100);

        javax.swing.GroupLayout panelRound9Layout = new javax.swing.GroupLayout(panelRound9);
        panelRound9.setLayout(panelRound9Layout);
        panelRound9Layout.setHorizontalGroup(
            panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panelRound9Layout.setVerticalGroup(
            panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        pPaisaje.add(panelRound9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, -1, -1));

        panelRound10.setBackground(new java.awt.Color(0, 204, 0));
        panelRound10.setRoundBottomLeft(100);
        panelRound10.setRoundBottomRight(100);
        panelRound10.setRoundTopLeft(100);
        panelRound10.setRoundTopRight(100);

        javax.swing.GroupLayout panelRound10Layout = new javax.swing.GroupLayout(panelRound10);
        panelRound10.setLayout(panelRound10Layout);
        panelRound10Layout.setHorizontalGroup(
            panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panelRound10Layout.setVerticalGroup(
            panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        pPaisaje.add(panelRound10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, -1, -1));

        panelRound11.setBackground(new java.awt.Color(204, 102, 0));

        javax.swing.GroupLayout panelRound11Layout = new javax.swing.GroupLayout(panelRound11);
        panelRound11.setLayout(panelRound11Layout);
        panelRound11Layout.setHorizontalGroup(
            panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        panelRound11Layout.setVerticalGroup(
            panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        pPaisaje.add(panelRound11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 20, 80));

        pPasto.setBackground(new java.awt.Color(102, 153, 0));
        pPasto.setRoundBottomLeft(100);
        pPasto.setRoundBottomRight(100);
        pPasto.setRoundTopLeft(100);
        pPasto.setRoundTopRight(100);

        javax.swing.GroupLayout pPastoLayout = new javax.swing.GroupLayout(pPasto);
        pPasto.setLayout(pPastoLayout);
        pPastoLayout.setHorizontalGroup(
            pPastoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        pPastoLayout.setVerticalGroup(
            pPastoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );

        pPaisaje.add(pPasto, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 250, 380, 110));

        btnSiguiente.setBackground(new java.awt.Color(0, 102, 255));
        btnSiguiente.setBorder(null);
        btnSiguiente.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguiente.setText("Siguiente");
        btnSiguiente.setColorBackground(new java.awt.Color(0, 102, 255));
        btnSiguiente.setColorClick(new java.awt.Color(102, 204, 255));
        btnSiguiente.setColorOver(new java.awt.Color(0, 153, 255));
        btnSiguiente.setColorText(new java.awt.Color(255, 255, 255));
        btnSiguiente.setFocusPainted(false);
        btnSiguiente.setRadius(15);
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pPaisaje, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(346, 346, 346)
                        .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(pPaisaje, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
       this.setVisible(false);
       panel.setVisible(true);
    }//GEN-LAST:event_btnSiguienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ButtonSpecial.JbtnRadius.JButtonRadius btnSiguiente;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jTexto;
    private test.PanelRound pPaisaje;
    private test.PanelRound pPasto;
    private test.PanelRound pSol;
    private test.PanelRound panelRound10;
    private test.PanelRound panelRound11;
    private test.PanelRound panelRound3;
    private test.PanelRound panelRound5;
    private test.PanelRound panelRound6;
    private test.PanelRound panelRound7;
    private test.PanelRound panelRound8;
    private test.PanelRound panelRound9;
    // End of variables declaration//GEN-END:variables
}
