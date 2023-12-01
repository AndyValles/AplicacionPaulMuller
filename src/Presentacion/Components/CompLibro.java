package Presentacion.Components;

import Negocio.Desing;
import Negocio.NLibro;
import java.awt.Color;
import javax.swing.ImageIcon;
import swing.ImageAvatar;


public class CompLibro extends javax.swing.JPanel {
    
    private Color bgFColor=Color.WHITE;
    private Color bgSelect=Color.RED;
    private Color bgPress=Color.BLUE;
    
    private ImageIcon icon=null;
    private Desing ds=new Desing();
    
    private NLibro libro=new NLibro(" ","Portada","Titulo","Autor");
    
    private String codigo;
    
    
    public CompLibro() {
        initComponents();
        pnSelect.setBackground(getBackground());
        setBackground(new Color(0,0,0,0));
    }

    protected void Iniciar(String cod){
        this.codigo=cod;
        IniText();
        
    }
    
    private void IniText(){
       
        String titulo="",autor="";
        
        if(libro.BuscarBool(codigo,libro.SEARCH_COD)){
            icon=(ImageIcon) ((ImageAvatar)libro.Lectura().get(0)[1]).getImage();
            titulo=libro.Lectura().get(0)[2]+"";
            autor=libro.Lectura().get(0)[3]+"";
        }
        
        lblTitulo.setText(titulo);
        lblAutor.setText(autor);
    }
    
    protected void IniImage(){
        lblImage.setIcon(icon);
        if(lblImage.getHeight()!=0 && lblImage.getWidth()!=0)ds.AsignarImagen(lblImage);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnSelect = new javax.swing.JPanel();
        btnSelect = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblAutor = new javax.swing.JLabel();

        setBackground(new java.awt.Color(250, 250, 250));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnSelect.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSelect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSelectMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSelectMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSelectMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnSelectMouseReleased(evt);
            }
        });
        pnSelect.add(btnSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 131, 200));
        pnSelect.add(lblImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 7, 110, 110));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Titulo");
        pnSelect.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 144, 111, -1));

        lblAutor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAutor.setForeground(new java.awt.Color(102, 102, 102));
        lblAutor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAutor.setText("autor");
        pnSelect.add(lblAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 110, -1));

        add(pnSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 200));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelectMouseEntered
        pnSelect.setBackground(bgSelect);
    }//GEN-LAST:event_btnSelectMouseEntered

    private void btnSelectMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelectMouseExited
        pnSelect.setBackground(bgFColor);
    }//GEN-LAST:event_btnSelectMouseExited

    private void btnSelectMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelectMouseReleased
       pnSelect.setBackground(bgSelect);
    }//GEN-LAST:event_btnSelectMouseReleased

    private void btnSelectMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelectMousePressed
       pnSelect.setBackground(bgPress);
    }//GEN-LAST:event_btnSelectMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JLabel btnSelect;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnSelect;
    // End of variables declaration//GEN-END:variables

    public Color getBgFColor() {
        return bgFColor;
    }

    public void setBgFColor(Color bgFColor) {
        this.bgFColor = bgFColor;
    }

    public Color getBgSelect() {
        return bgSelect;
    }

    public void setBgSelect(Color bgSelect) {
        this.bgSelect = bgSelect;
    }

    public Color getBgPress() {
        return bgPress;
    }

    public void setBgPress(Color bgPress) {
        this.bgPress = bgPress;
    }
}
