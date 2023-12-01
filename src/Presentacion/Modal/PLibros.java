/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Modal;

import Entidad.Libro;
import Negocio.NAutor;
import Negocio.NCategoria;
import Negocio.NEditorial;
import Negocio.NLibro;
import Negocio.Desing;
import Negocio.NBusqueda;
import Negocio.Time;
import Negocio.ValidateText;
import Tablespecial.JTableCustom.TablaCell;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import swing.ImageAvatar;

/**
 *
 * @author andyv
 */
public class PLibros extends javax.swing.JDialog {
    
    private ValidateText vl=new ValidateText();
    private Desing ds=new Desing();
    private Time tm=new Time();
    
    private NLibro ll=null;
    private NAutor aa=new NAutor();
    private NCategoria cc=new NCategoria();
    private NEditorial ee=new NEditorial();
    private NBusqueda buscar=null;
    
    private JFrame frm=null;
    private Eliminar el=null;
    private Icon image;
    
    private ByteArrayOutputStream by;
    private JFileChooser ff=new JFileChooser();
    private LocalDate dt=LocalDate.now();
    
    private String ruta="";
    
    private byte[] portada;
    private int dia=0;
    private boolean isInsert=true;
   
    
     public PLibros(java.awt.Frame parent, boolean modal,boolean isPrestamo) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        
        IniTitulos(isPrestamo);
        this.frm=(JFrame) parent;
       
        if(parent!=null){setSize(getWidth(), parent.getHeight());}
        if(parent!=null){setLocation(parent.getLocation());}
        this.setBackground(new Color(0,0,0,100));
        inicio();
    }
    
    
    public PLibros(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(this);
        IniTitulos(true);
        inicio();
    }
    
    private void  IniTitulos(boolean Press){
        ArrayList<String> str=new ArrayList();
        str.add("Codigo");
        str.add("Portada");
        str.add("Titulo");
        str.add("Autor");
        str.add("Publicación");
        str.add("Categoria");
        str.add("Editorial");
        str.add("Edición");
        str.add("Estado");
        
        if(Press==false){
            str.add("Modificar");
            str.add("Eliminar");
            btnRegistrar.setVisible(true);
        }else{
            btnRegistrar.setVisible(false);
        }
        ll =new NLibro(str.toArray());
        buscar=new NBusqueda(str.toArray(),"Codigo","Title","Fecha publicación","Fecha Subida","Edición","Editorial","Autor","Estado");
    }
    
    private void inicio(){
        ImageDs();
        tblResult.setDefaultRenderer(Object.class,new TablaCell());
        tblResult.setModel(ll.Leer());
        txtCodigo.setText(vl.CodigoVol('L', "", ll.Dato(), 5));
        for(Object o:aa.cboAutor()){cboAutor.addItem(o);}
        for(Object o:cc.cboCategoria()){cboCat.addItem(o);}
        for(Object o:ee.cboEditorial()){cboEditorial.addItem(o);}
        
        for(Object o:tm.DaysMonth(dt.getMonthValue())){cboDia.addItem(o);}
        for(Object o:tm.Month()){cboMes.addItem(o);}
        for(Object o:tm.Year()){cboAño.addItem(o);}
        
        for(Object o:buscar.getBuscarPor()){cboBuscar.addItem(o);}
        for(Object o:buscar.getTitles()){cboBuscar1.addItem(o);}
        dia=dt.getDayOfMonth();
        
        cboDia.setSelectedItem(dia);
        cboMes.setSelectedIndex(dt.getMonthValue()-1);
        cboAño.setSelectedItem(dt.getYear());
        
        cboEstado.addItem("Activo");
        cboEstado.addItem("Desactivo");

        txtRuta.setText(ff.getCurrentDirectory().getPath());
        pAgregar.setVisible(false);
    }
    
    private Libro Items(){
        Libro l=new Libro();
        boolean estado=false;
        l.setCodigo(txtCodigo.getText());
        l.setPortada(ds.ConvByte(((ImageIcon)lblPortada.getIcon()).getImage(), lblPortada.getWidth(), lblPortada.getHeight()));
        l.setTitulo(txtTitulo.getText());
        l.setAutor(CodAut(cboAutor.getSelectedItem()+""));
        l.setFPublicacion(cboAño.getSelectedItem()+"-"+(cboMes.getSelectedIndex()+1)+"-"+cboDia.getSelectedItem());
        l.setFSubida(dt.getYear()+"-"+dt.getMonthValue()+"-"+dt.getDayOfMonth());
        l.setCantUsu(0);
        l.setCategoria(CodCat(cboCat.getSelectedItem()+""));
        l.setEditorial(CodEdi(cboEditorial.getSelectedItem()+""));
        l.setEdicion(txtEdicion.getText());
        if(cboEstado.getSelectedIndex()==0){estado=true;}
        l.setEstado(estado);
        return l;
    }
    
     private void ImageDs() {
       String arc="Portada.png";
       try{
           ruta= getClass().getResource("/Imagens/"+arc).getPath();
           File f=new File(ruta);
           image=new ImageIcon(ImageIO.read(f));

       }catch(Exception e){}
       
        
        lblPortada.setIcon(image);
        ds.AsignarImagen(lblPortada);
     }
     
     private int CodAut(String txt){
         int salida=0;
         aa.Buscar(txt, aa.SEARCH_NAME);
         return Integer.parseInt(aa.Lectura().get(0)[0]+"");
     }
     
     private int CodEdi(String txt){
         int salida=0;
         ee.Buscar(txt, ee.SEARCH_NAME);
         return Integer.parseInt(ee.Lectura().get(0)[0]+"");
     }
     
     private int CodCat(String txt){
         int salida=0;
         cc.BuscarNom(txt);
         return Integer.parseInt(cc.Lectura().get(0)[0]+"");
     }
     
     private void Obtener(){
         int i=tblResult.getSelectedRow();
         txtCodigo.setText(tblResult.getValueAt(i, 0)+"");
         lblPortada.setIcon(((ImageAvatar) tblResult.getValueAt(i, 1)).getImage());
         txtTitulo.setText(tblResult.getValueAt(i, 2)+"");
         cboAutor.setSelectedItem(tblResult.getValueAt(i, 3));
         
         cboDia.setSelectedItem(tblResult.getValueAt(i, 4).toString().substring(0, 3));
         cboMes.setSelectedItem(tblResult.getValueAt(i, 4).toString().substring(5, 7));
         cboAño.setSelectedItem(tblResult.getValueAt(i, 4).toString().substring(8, 10));

         cboCat.setSelectedItem(tblResult.getValueAt(i, 5));
         cboEditorial.setSelectedItem(tblResult.getValueAt(i, 6));
         txtEdicion.setText(tblResult.getValueAt(i, 7)+"");
         
         if(tblResult.getValueAt(i, 7).equals("1")){}
     }
     
    
     
      private void ChooserFile(){
        try{
            ff.setFileFilter(new FileNameExtensionFilter("Imagenes","jpg","png"));
            ff.showSaveDialog(this);
            ruta=ff.getSelectedFile().getPath();            
            
            image=new ImageIcon(ImageIO.read(ff.getSelectedFile()));
            
            lblPortada.setIcon(image);
            
            ds.AsignarImagen(lblPortada);
            txtRuta.setText(ruta);
        }catch(Exception e){
            ImageDs();
        }
        
    }
      
      private boolean Insertar(){
         
          if(!txtCodigo.getText().isEmpty()){
              if(!txtTitulo.getText().isEmpty()){
                  if(ll.Insertar(Items())){
                      
                      return true;
                  }
              }else{
                  
                  vl.valText(txtTitulo, lblETitulo,false);
              }
          }else{
             
              vl.valText(txtCodigo, lblECodigo, false);
          }
          return false;
      }
      
    private boolean Modificar(){
          if(!txtCodigo.getText().isEmpty()){
              if(!txtTitulo.getText().isEmpty()){
                  if(ll.Actualizar(Items())){
                      return true;
                  }
              }else{
                  vl.valText(txtTitulo, lblETitulo,false);
              }
          }else{
              vl.valText(txtCodigo, lblECodigo, false);
          }
          return false;
      }
    
    public void Select(MouseAdapter l){
    tblResult.addMouseListener(l);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        pBuscar = new javax.swing.JPanel();
        cboBuscar = new combobox.Combobox();
        txtBuscar = new textfield.TextField();
        jButtonRadius6 = new ButtonSpecial.JbtnRadius.JButtonRadius();
        btnRegistrar = new ButtonSpecial.JbtnRadius.JButtonRadius();
        btnSalir = new ButtonSpecial.JbtnRadius.JButtonRadius();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResult = new dynamic_subjtable.TableCustom();
        cboBuscar1 = new combobox.Combobox();
        cbEstado = new javax.swing.JCheckBox();
        pAgregar = new javax.swing.JPanel();
        jScroll1 = new ScrollPaneSpecial.JScrollPane.JScroll();
        jPanel2 = new javax.swing.JPanel();
        lblPortada = new javax.swing.JLabel();
        txtRuta = new textfield.TextField();
        btnAgregar = new ButtonSpecial.JbtnRadius.JButtonRadius();
        btnICancel = new ButtonSpecial.JbtnRadius.JButtonRadius();
        txtTitulo = new textfield.TextField();
        txtCodigo = new textfield.TextField();
        cboEditorial = new combo_suggestion.ComboBoxSuggestion();
        Autor = new javax.swing.JLabel();
        cboDia = new combobox.Combobox();
        cboMes = new combobox.Combobox();
        cboAño = new combobox.Combobox();
        Autor1 = new javax.swing.JLabel();
        cboCat = new combobox.Combobox();
        cboAutor = new combo_suggestion.ComboBoxSuggestion();
        Autor2 = new javax.swing.JLabel();
        txtEdicion = new textfield.TextField();
        cboEstado = new combobox.Combobox();
        btnInsert = new ButtonSpecial.JbtnRadius.JButtonRadius();
        btnEditorial = new ButtonSpecial.JbtnRadius.JButtonRadius();
        btnAutor = new ButtonSpecial.JbtnRadius.JButtonRadius();
        btnCategoria = new ButtonSpecial.JbtnRadius.JButtonRadius();
        lblETitulo = new javax.swing.JLabel();
        lblEAutor = new javax.swing.JLabel();
        lblECategoria = new javax.swing.JLabel();
        lblEEditorial = new javax.swing.JLabel();
        lblECodigo = new javax.swing.JLabel();
        lblTxt = new javax.swing.JLabel();
        lblDial = new javax.swing.JLabel();
        btnCancelar = new ButtonSpecial.JbtnRadius.JButtonRadius();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setLayout(new javax.swing.OverlayLayout(jPanel3));

        pBuscar.setBackground(new java.awt.Color(255, 255, 255));

        cboBuscar.setLabeText("Buscar por:");

        txtBuscar.setLabelText("Buscar");
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        jButtonRadius6.setBackground(new java.awt.Color(51, 153, 255));
        jButtonRadius6.setBorder(null);
        jButtonRadius6.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRadius6.setText("Limpiar");
        jButtonRadius6.setColorBackground(new java.awt.Color(51, 153, 255));
        jButtonRadius6.setColorClick(new java.awt.Color(102, 204, 255));
        jButtonRadius6.setColorOver(new java.awt.Color(102, 204, 255));
        jButtonRadius6.setColorText(new java.awt.Color(255, 255, 255));
        jButtonRadius6.setFocusPainted(false);
        jButtonRadius6.setRadius(15);

        btnRegistrar.setBackground(new java.awt.Color(51, 153, 255));
        btnRegistrar.setBorder(null);
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setColorBackground(new java.awt.Color(51, 153, 255));
        btnRegistrar.setColorClick(new java.awt.Color(102, 204, 255));
        btnRegistrar.setColorOver(new java.awt.Color(102, 204, 255));
        btnRegistrar.setColorText(new java.awt.Color(255, 255, 255));
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.setRadius(15);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(51, 153, 255));
        btnSalir.setBorder(null);
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.setColorBackground(new java.awt.Color(51, 153, 255));
        btnSalir.setColorClick(new java.awt.Color(102, 204, 255));
        btnSalir.setColorOver(new java.awt.Color(102, 204, 255));
        btnSalir.setColorText(new java.awt.Color(255, 255, 255));
        btnSalir.setFocusPainted(false);
        btnSalir.setRadius(15);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        tblResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblResult.setFillsViewportHeight(true);
        tblResult.setGridColor(new java.awt.Color(255, 255, 255));
        tblResult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblResultMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblResult);

        cboBuscar1.setLabeText("Buscar como:");
        cboBuscar1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboBuscar1ItemStateChanged(evt);
            }
        });

        cbEstado.setBackground(new java.awt.Color(255, 255, 255));
        cbEstado.setText("Estado");
        cbEstado.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cbEstadoStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pBuscarLayout = new javax.swing.GroupLayout(pBuscar);
        pBuscar.setLayout(pBuscarLayout);
        pBuscarLayout.setHorizontalGroup(
            pBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pBuscarLayout.createSequentialGroup()
                        .addComponent(cboBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(cbEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonRadius6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 907, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pBuscarLayout.createSequentialGroup()
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(650, 650, 650)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(269, Short.MAX_VALUE))
        );
        pBuscarLayout.setVerticalGroup(
            pBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRadius6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEstado))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3.add(pBuscar);

        pAgregar.setBackground(new java.awt.Color(255, 255, 255));

        jScroll1.setScrollBackground(new java.awt.Color(51, 153, 255));
        jScroll1.setScrollClick(new java.awt.Color(102, 204, 255));
        jScroll1.setScrollOver(new java.awt.Color(102, 204, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblPortada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtRuta.setEditable(false);
        txtRuta.setBackground(new java.awt.Color(255, 255, 255));
        txtRuta.setLabelText("Ruta");

        btnAgregar.setBackground(new java.awt.Color(51, 153, 255));
        btnAgregar.setBorder(null);
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.setColorBackground(new java.awt.Color(51, 153, 255));
        btnAgregar.setColorClick(new java.awt.Color(102, 204, 255));
        btnAgregar.setColorOver(new java.awt.Color(102, 204, 255));
        btnAgregar.setColorText(new java.awt.Color(255, 255, 255));
        btnAgregar.setFocusPainted(false);
        btnAgregar.setRadius(15);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnICancel.setBackground(new java.awt.Color(51, 153, 255));
        btnICancel.setBorder(null);
        btnICancel.setForeground(new java.awt.Color(255, 255, 255));
        btnICancel.setColorBackground(new java.awt.Color(51, 153, 255));
        btnICancel.setColorClick(new java.awt.Color(102, 204, 255));
        btnICancel.setColorOver(new java.awt.Color(102, 204, 255));
        btnICancel.setColorText(new java.awt.Color(255, 255, 255));
        btnICancel.setFocusPainted(false);
        btnICancel.setLabel("Cancelar");
        btnICancel.setRadius(15);
        btnICancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnICancelActionPerformed(evt);
            }
        });

        txtTitulo.setLabelText("Titulo");
        txtTitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTituloKeyTyped(evt);
            }
        });

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(255, 255, 255));
        txtCodigo.setLabelText("Codigo");
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        cboEditorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cboEditorialMouseEntered(evt);
            }
        });

        Autor.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Autor.setForeground(new java.awt.Color(153, 153, 153));
        Autor.setText("Autor");

        cboDia.setLabeText("Dia");

        cboMes.setLabeText("Mes");
        cboMes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboMesItemStateChanged(evt);
            }
        });

        cboAño.setLabeText("Año");

        Autor1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Autor1.setForeground(new java.awt.Color(153, 153, 153));
        Autor1.setText("Fecha Publicación");

        cboCat.setLabeText("Categoria");
        cboCat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cboCatMouseEntered(evt);
            }
        });

        cboAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cboAutorMouseEntered(evt);
            }
        });

        Autor2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Autor2.setForeground(new java.awt.Color(153, 153, 153));
        Autor2.setText("Editorial");

        txtEdicion.setLabelText("Edición");
        txtEdicion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEdicionKeyTyped(evt);
            }
        });

        cboEstado.setLabeText("Estado");

        btnInsert.setBackground(new java.awt.Color(51, 153, 255));
        btnInsert.setBorder(null);
        btnInsert.setForeground(new java.awt.Color(255, 255, 255));
        btnInsert.setText("Agregar");
        btnInsert.setColorBackground(new java.awt.Color(51, 153, 255));
        btnInsert.setColorClick(new java.awt.Color(102, 204, 255));
        btnInsert.setColorOver(new java.awt.Color(102, 204, 255));
        btnInsert.setColorText(new java.awt.Color(255, 255, 255));
        btnInsert.setFocusPainted(false);
        btnInsert.setRadius(15);
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnEditorial.setBackground(new java.awt.Color(51, 153, 255));
        btnEditorial.setBorder(null);
        btnEditorial.setForeground(new java.awt.Color(255, 255, 255));
        btnEditorial.setText("Agregar Editorial");
        btnEditorial.setColorBackground(new java.awt.Color(51, 153, 255));
        btnEditorial.setColorClick(new java.awt.Color(102, 204, 255));
        btnEditorial.setColorOver(new java.awt.Color(102, 204, 255));
        btnEditorial.setColorText(new java.awt.Color(255, 255, 255));
        btnEditorial.setFocusPainted(false);
        btnEditorial.setRadius(15);
        btnEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditorialActionPerformed(evt);
            }
        });

        btnAutor.setBackground(new java.awt.Color(51, 153, 255));
        btnAutor.setBorder(null);
        btnAutor.setForeground(new java.awt.Color(255, 255, 255));
        btnAutor.setText("Agregar Autor");
        btnAutor.setColorBackground(new java.awt.Color(51, 153, 255));
        btnAutor.setColorClick(new java.awt.Color(102, 204, 255));
        btnAutor.setColorOver(new java.awt.Color(102, 204, 255));
        btnAutor.setColorText(new java.awt.Color(255, 255, 255));
        btnAutor.setFocusPainted(false);
        btnAutor.setRadius(15);
        btnAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutorActionPerformed(evt);
            }
        });

        btnCategoria.setBackground(new java.awt.Color(51, 153, 255));
        btnCategoria.setBorder(null);
        btnCategoria.setForeground(new java.awt.Color(255, 255, 255));
        btnCategoria.setText("Agregar Categoria");
        btnCategoria.setColorBackground(new java.awt.Color(51, 153, 255));
        btnCategoria.setColorClick(new java.awt.Color(102, 204, 255));
        btnCategoria.setColorOver(new java.awt.Color(102, 204, 255));
        btnCategoria.setColorText(new java.awt.Color(255, 255, 255));
        btnCategoria.setFocusPainted(false);
        btnCategoria.setRadius(15);
        btnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaActionPerformed(evt);
            }
        });

        lblETitulo.setForeground(new java.awt.Color(255, 0, 0));

        lblEAutor.setForeground(new java.awt.Color(255, 0, 0));

        lblECategoria.setForeground(new java.awt.Color(255, 0, 0));

        lblEEditorial.setForeground(new java.awt.Color(255, 0, 0));

        lblECodigo.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lblEAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Autor2)
                            .addComponent(Autor)
                            .addComponent(Autor1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblPortada, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnICancel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lblETitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(cboAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblECategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblEEditorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cboCat, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(btnInsert, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(cboEstado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txtEdicion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(cboEditorial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(cboDia, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(cboMes, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(cboAño, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(0, 0, Short.MAX_VALUE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                    .addComponent(lblECodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(467, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblECodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnICancel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblETitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblPortada, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Autor, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(lblEAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Autor1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboCat, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblECategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Autor2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(lblEEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(txtEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScroll1.setViewportView(jPanel2);

        lblTxt.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        lblTxt.setForeground(new java.awt.Color(0, 102, 255));
        lblTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTxt.setText("Nuevo registro de un Libro");
        lblTxt.setToolTipText("");

        lblDial.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblDial.setForeground(new java.awt.Color(0, 102, 255));
        lblDial.setText("Libros");
        lblDial.setToolTipText("");

        btnCancelar.setBackground(new java.awt.Color(51, 153, 255));
        btnCancelar.setBorder(null);
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setColorBackground(new java.awt.Color(51, 153, 255));
        btnCancelar.setColorClick(new java.awt.Color(102, 204, 255));
        btnCancelar.setColorOver(new java.awt.Color(102, 204, 255));
        btnCancelar.setColorText(new java.awt.Color(255, 255, 255));
        btnCancelar.setFocusPainted(false);
        btnCancelar.setLabel("Cancelar");
        btnCancelar.setRadius(15);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pAgregarLayout = new javax.swing.GroupLayout(pAgregar);
        pAgregar.setLayout(pAgregarLayout);
        pAgregarLayout.setHorizontalGroup(
            pAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAgregarLayout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addGroup(pAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pAgregarLayout.createSequentialGroup()
                        .addComponent(lblDial, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(372, 372, 372))
        );
        pAgregarLayout.setVerticalGroup(
            pAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAgregarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDial)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );

        jPanel3.add(pAgregar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditorialActionPerformed
        new pEditorial(frm, true,true).setVisible(true);
    }//GEN-LAST:event_btnEditorialActionPerformed

    private void btnAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutorActionPerformed
       new pAutor(frm, true,true).setVisible(true);
    }//GEN-LAST:event_btnAutorActionPerformed

    private void btnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaActionPerformed
        new PDistrito(frm, true, "Categoria",true).setVisible(true);
    }//GEN-LAST:event_btnCategoriaActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        ChooserFile();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        isInsert=true;
      pAgregar.setVisible(true);
      pBuscar.setVisible(false);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        if(cboAutor.getItemCount()>0){
            if(cboEditorial.getItemCount()>0){
                if(cboCat.getItemCount()>0){
                    if(isInsert){
                        if(Insertar()){
                        }
                    }else{
                        if(Modificar()){}
                    }
                }else{
                    lblECategoria.setText("Debe agregar una categoria");
                }
            }else{
                lblEEditorial.setText("Debe agregar una editorial");
            }
        }else{
           lblEAutor.setText("Debe agregar un Autor");
        }
        
    }//GEN-LAST:event_btnInsertActionPerformed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        vl.valText(txtCodigo, 19, evt);
        vl.valText(txtCodigo,lblECodigo, true);
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void txtEdicionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdicionKeyTyped
         vl.valText(txtEdicion, 19, evt);
         
    }//GEN-LAST:event_txtEdicionKeyTyped

    private void txtTituloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTituloKeyTyped
        vl.valText(txtTitulo, 19, evt);
        vl.valText(txtTitulo,lblETitulo, true);
    }//GEN-LAST:event_txtTituloKeyTyped

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnICancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnICancelActionPerformed
      ImageDs();
    }//GEN-LAST:event_btnICancelActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        
        pAgregar.setVisible(false);
        pBuscar.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cboMesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMesItemStateChanged
        if(cboDia.getItemCount()>0){dia=(Integer) cboDia.getSelectedItem();cboDia.removeAllItems();}
        for(Object o:tm.DaysMonth(cboMes.getSelectedIndex()+1)){cboDia.addItem(o);}
        cboDia.setSelectedItem(dia);
    }//GEN-LAST:event_cboMesItemStateChanged

    private void tblResultMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResultMousePressed
        int column=tblResult.getColumnModel().getColumnIndexAtX(evt.getX());
        int row=evt.getY()/tblResult.getRowHeight();

        if(row<tblResult.getRowCount() && row>=0 &&column<tblResult.getColumnCount() && column>0){
            Object uu=tblResult.getValueAt(row, column);
            if(uu instanceof JButton){
                JButton btn=(JButton) uu;
                if(btn.getName().equals("modificar")){
                    Obtener();
                    isInsert=false;
                    btnInsert.setText("Modificar registro");
                    pBuscar.setVisible(false);
                    pAgregar.setVisible(true);
                }else{

                    int i=tblResult.getSelectedRow();
                    el=new Eliminar(frm,true,7,(String) tblResult.getValueAt(i, 0));
                    el.info("Libro",(String) tblResult.getValueAt(i, 2));
                    el.setVisible(true);

                }
            }
        }

    }//GEN-LAST:event_tblResultMousePressed

    private void cboAutorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboAutorMouseEntered
        if(cboAutor.getItemCount()>0){cboAutor.removeAllItems();} 
        for(Object o:aa.cboAutor()){cboAutor.addItem(o);}
    }//GEN-LAST:event_cboAutorMouseEntered

    private void cboCatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboCatMouseEntered
         if(cboCat.getItemCount()>0){cboCat.removeAllItems();}
        for(Object o:cc.cboCategoria()){cboCat.addItem(o);}
    }//GEN-LAST:event_cboCatMouseEntered

    private void cboEditorialMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboEditorialMouseEntered
         if(cboEditorial.getItemCount()>0){cboEditorial.removeAllItems();} 
        for(Object o:ee.cboEditorial()){cboEditorial.addItem(o);}
    }//GEN-LAST:event_cboEditorialMouseEntered

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
       
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void cboBuscar1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboBuscar1ItemStateChanged
            txtBuscar.setEditable(cboBuscar1.getSelectedIndex()!=7);
            cbEstado.setVisible(cboBuscar1.getSelectedIndex()==7);
    }//GEN-LAST:event_cboBuscar1ItemStateChanged

    private void cbEstadoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbEstadoStateChanged
        Libro l=new Libro();
        l.setEstado(cbEstado.isSelected());
        buscar.tableLibro(l);
    }//GEN-LAST:event_cbEstadoStateChanged

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
         int x=cboBuscar.getSelectedIndex(),y=cboBuscar1.getSelectedIndex();
        buscar.tableLibro(x, y, txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

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
            java.util.logging.Logger.getLogger(PLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PLibros dialog = new PLibros(new javax.swing.JFrame(), true,false);
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
    private javax.swing.JLabel Autor;
    private javax.swing.JLabel Autor1;
    private javax.swing.JLabel Autor2;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnAgregar;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnAutor;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnCancelar;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnCategoria;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnEditorial;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnICancel;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnInsert;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnRegistrar;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnSalir;
    private javax.swing.JCheckBox cbEstado;
    private combo_suggestion.ComboBoxSuggestion cboAutor;
    private combobox.Combobox cboAño;
    private combobox.Combobox cboBuscar;
    private combobox.Combobox cboBuscar1;
    private combobox.Combobox cboCat;
    private combobox.Combobox cboDia;
    private combo_suggestion.ComboBoxSuggestion cboEditorial;
    private combobox.Combobox cboEstado;
    private combobox.Combobox cboMes;
    private ButtonSpecial.JbtnRadius.JButtonRadius jButtonRadius6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private ScrollPaneSpecial.JScrollPane.JScroll jScroll1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDial;
    private javax.swing.JLabel lblEAutor;
    private javax.swing.JLabel lblECategoria;
    private javax.swing.JLabel lblECodigo;
    private javax.swing.JLabel lblEEditorial;
    private javax.swing.JLabel lblETitulo;
    private javax.swing.JLabel lblPortada;
    private javax.swing.JLabel lblTxt;
    private javax.swing.JPanel pAgregar;
    private javax.swing.JPanel pBuscar;
    protected dynamic_subjtable.TableCustom tblResult;
    private textfield.TextField txtBuscar;
    private textfield.TextField txtCodigo;
    private textfield.TextField txtEdicion;
    private textfield.TextField txtRuta;
    private textfield.TextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
