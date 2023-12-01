/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Modal;

import DialogSpecial.JDialogSpecial.JDialogCustom;
import Entidad.Usuario;
import Negocio.NDistrito;
import Negocio.NEgresado;
import Negocio.NEstudiante;
import Negocio.NPersonal;
import Negocio.NUsuario;
import Negocio.Desing;
import Negocio.NBusqueda;
import Negocio.ValidateText;
import Tablespecial.JTableCustom.TablaCell;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import swing.ImageAvatar;
import textfield.TextField;

/**
 *
 * @author andyv
 */
public class PUsuario extends JDialogCustom {
    
    private Icon image;
    
    private Desing ds=new Desing();
    private JFileChooser ff=new JFileChooser();
    private FileInputStream fotoPerfil;
    
    private ArrayList list=new ArrayList();
    private String[] Item=new String[]{"DNI","Foto Perfil","Primer Nombre","Segundo Nombre","Apellido Paterno","Apellido Materno","Direccion","Distrito","Correo","Telefono","Genero","Usuario","Contraseña"};
    
    
    private NEgresado ee=null;
    private NEstudiante es=null;
    private NPersonal pp=null;
    
    private NUsuario uu=new NUsuario();
    private NDistrito dd=new NDistrito();
    private NBusqueda buscar=new NBusqueda();
    
    private ValidateText vl=new ValidateText();
            
    private JFrame frm;
    private Eliminar el=null;
    private String txt="",ruta="";
    private boolean isInsert=true;
    
    public PUsuario(java.awt.Frame parent, boolean modal,String txt) {
        super(parent, modal);
        this.frm=(JFrame) parent;
        this.txt=txt;
        initComponents();
        IniFrm(frm);
        Inicio();
        
    }
    
    
    private void Inicio(){
        lblDial.setText(txt);
        lblTxt.setText("Nuevo registro de un "+txt.toLowerCase());
        pAgregar.setVisible(false);
        tblResult.setDefaultRenderer(Object.class, new TablaCell());
        IniOp();
        ImageDs();
        inicioCbo();
        Limpiar();
    }
    
    private void IniFrm(JFrame frm){
        opPer.IniFrm(frm);
        opEgre.IniFrm(frm);
        opEst.IniFrm(frm);
    }
    
    private void inicioCbo(){
        for(Object o:dd.cboDistrito()){cboDir.addItem(o);}
        for(Object o:uu.cboSexo()){cboSexo.addItem(o);}
        for(Object o:buscar.getBuscarPor()){cboBuscar.addItem(o);}
        for(Object o:buscar.getTitles()){cboBuscar1.addItem(o);}
    }
    
    private void IniciDatos(String txt){
        if(txt.equals("egresado")){
                ee=new NEgresado(list.toArray());
                tblResult.setModel(ee.Leer());
        }else if(txt.equals("estudiante")){
                es=new NEstudiante(list.toArray());
                tblResult.setModel(es.Leer());
        }else{
                pp=new NPersonal(list.toArray());
                tblResult.setModel(pp.Leer());
        }
    }
    
    private void IniOp(){
        
        JPanel[] pnl=new JPanel[]{opEgre,opEst,opPer};
        
        for(JPanel p:pnl)p.setVisible(false);
        
        for(String tx:Item){
            list.add(tx);
        }
        
        switch(txt.toLowerCase()){
            case "egresado":
                list.add("Profesión");
                list.add("Fecha Graduación");
                list.add("Modificar");
                list.add("Eliminar");
                IniciDatos(txt.toLowerCase());
                 buscar=new NBusqueda("DNI","Nombre","Apellido","Direccion","Correo","Telefono","Fecha","Profesión","Distrito","Sexo");
                pnl[0].setVisible(true);
                break;
            case "estudiante":
                list.add("Carrera");list.add("Fecha Postulación");list.add("Modificar");list.add("Eliminar");
                IniciDatos(txt.toLowerCase());
                pnl[1].setVisible(true);
                buscar=new NBusqueda("DNI","Nombre","Apellido","Direccion","Correo","Telefono","Fecha","Carrera","Distrito","Sexo");
                break;
            case "personal":
                list.add("Cargo");list.add("Modificar");list.add("Eliminar");
                IniciDatos(txt.toLowerCase());
                pnl[2].setVisible(true);
                buscar=new NBusqueda("DNI","Nombre","Apellido","Direccion","Correo","Telefono","Cargo","Distrito","Sexo");
                break;
        
        }
        
    }
    
   
    
    
    private boolean ValidateText(){
      JTextField[] txt = new JTextField[]{txtDNI,txtPriNom,txtApePat,txtCorreo,txtUsu,txtContra,txtContra2};
      JLabel[] lbl1=new JLabel[]{lblEDNI,lblEPNom,lblEApeP,lblECorreo,lblEUsu,lblEContra,lblEContra2};
      String CName1="",CName2="";
      boolean isAdd=false;
      
      for(char u:txtContra.getPassword()){CName1+=u;}
      for(char u:txtContra2.getPassword()){CName2+=u;}
      
     try{
     if(vl.valTextField(txt,"Esta casilla no debes estar vacia",lbl1,Color.red,new Color(3,155,216))){  
            if(txt[0].getText().length() == 8){
                        if(CName1.equals(CName2)){
                           if(isInsert){ 
                            if(!uu.BuscarBool(Item(),uu.USER_DNI)){
                               if(uu.Insertar(Item())){
                                    isAdd=true;
                                }
                            }else{
                                isAdd=true;
                            }
                           }else{
                               if(uu.Actualizar(Item())){
                               isAdd=true;
                            }
                           }
                            
                            
                        }else{
                            lblEContra2.setText("La contraseña debe ser igual en cada casilla");
                        }
                }else{
                    lblEDNI.setText("Debe rellenar los 8 caracteres");
            }  
         }
     }catch(Exception e){}
     return isAdd;
   }
   
    
    
     private void ImageDs() {
       String arc="icono-Adminhombre.png";
       if(cboSexo.getSelectedIndex()==1){
           arc="icono-AdminMujer.png";
       }
       
       ruta= getClass().getResource("/Imagens/"+arc).getPath();
       
        image=new ImageIcon(ruta);
        Image.setImage(image);
       
        
     }
       
     private void IniBuscar(int x,int y,String txt){
        if(txt.equals("egresado")){
                tblResult.setModel(buscar.tableEgresado(x, y, txt));
        }else if(txt.equals("estudiante")){
                tblResult.setModel(buscar.tableEstudiante(x, y, txt));
        }else{
               tblResult.setModel(buscar.tablePersonal(x, y, txt));
        }
    }
   
    private void ChooserFile(){
        try{
            ff.setFileFilter(new FileNameExtensionFilter("Imagenes","jpg","png"));
            ff.showSaveDialog(this);
            
            ruta=ff.getSelectedFile().getPath();
            fotoPerfil=new FileInputStream(ff.getSelectedFile());
            image=new ImageIcon(ruta);
            
            Image.setImage(image);
            
            txtRuta.setText(ruta);
        }catch(Exception e){}
        
    }
    
    
    private Usuario Item(){
    Usuario u=new Usuario();
    String contra="";
    
    for(char c:txtContra2.getPassword()){contra+=c;}
    
      u.setDNI(txtDNI.getText());
      u.setPriNombre(txtPriNom.getText());
      u.setSegNombre(txtSegNomb.getText());
      u.setApePat(txtApePat.getText());
      u.setApeMat(txtApeMat.getText());
      u.setDireccion(txtDir.getText());
      u.setDistrito(cboDir.getSelectedIndex()+1);
      u.setCorreo(txtCorreo.getText());
      u.setTelefono(txtTelefono.getText());
      u.setSexo(cboSexo.getSelectedIndex()+1);
      u.setUsuario(txtUsu.getText());
      u.setContraseña(contra);
      u.setFotoPerfil(ds.ConvByte(((ImageIcon) Image.getImage()).getImage(), Image.getWidth(), Image.getHeight()));
    return u;
    }
    
    private void VisualText(JLabel lbl,TextField txt,KeyEvent evt,int c){
        
         lbl.setText("");
        txt.setLineColor(new Color(3,155,216));
        vl.valText(txt, c , evt);
    }
    
    private void Correo(){
    String correo=txtCorreo.getText().trim();
    if(!correo.isEmpty()){
           correo=correo.replaceAll("@gmail.com","");
            txtCorreo.setText(correo+"@gmail.com");
        }
    
    }
    
     private void Insertar(){
        String op=txt.toLowerCase();
        String usu="";
        
        if(ValidateText()){
           if(op.equals("egresado")){
               if(opEgre.Agregar(isInsert,Item())){
                   usu="Egresado";
               }
           }else if(op.equals("estudiante")){
               if(opEst.Agregar(isInsert,Item())){
                   usu="Estudiante";
               }
           }else{
               if(opPer.Agregar(isInsert,Item())){
                   usu="Personal";
               }
           }
            
        }
    }
    
    private void Limpiar(){
        txtRuta.setText(ff.getCurrentDirectory()+"");
        txtDNI.setText("");
        txtPriNom.setText("");
        txtSegNomb.setText("");
        txtApePat.setText("");
        txtApeMat.setText("");
        txtDir.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
        txtUsu.setText("");
        txtContra.setText("");
        txtContra2.setText("");
    }
    
    private void Obtener(){
        int row=tblResult.getSelectedRow();
        txtDNI.setText(tblResult.getValueAt(row, 0)+"");
        Image.setImage(((ImageAvatar)tblResult.getValueAt(row, 1)).getImage());
        txtPriNom.setText(tblResult.getValueAt(row, 2)+"");
        txtSegNomb.setText(tblResult.getValueAt(row, 3)+"");
        txtApePat.setText(tblResult.getValueAt(row, 4)+"");
        txtApeMat.setText(tblResult.getValueAt(row, 5)+"");
        txtDir.setText(tblResult.getValueAt(row, 6)+"");
        cboDir.setSelectedItem(tblResult.getValueAt(row, 7)+"");
        txtCorreo.setText(tblResult.getValueAt(row, 8)+"");
        txtTelefono.setText(tblResult.getValueAt(row, 9)+"");
        cboSexo.setSelectedItem(tblResult.getValueAt(row, 10)+"");
        txtUsu.setText(tblResult.getValueAt(row, 11)+"");
        txtContra.setText(tblResult.getValueAt(row, 12)+"");
        txtContra2.setText(tblResult.getValueAt(row, 12)+"");
        String text=tblResult.getValueAt(row,13)+"",date=tblResult.getValueAt(row,14)+"";
        
        if(txt.equals("egresado")){
               opEgre.Profesion(text,date);
        }else if(txt.equals("estudiante")){
               opEst.Carrera(text,date);
        }else{
               opPer.Cargo(text);
        }
    }
    
     private void ItemsData(String dni){
     if(uu.BuscarBool(dni, uu.SEARCH_DNI)){
        Image.setImage(((ImageAvatar)uu.Lectura().get(0)[1]).getImage());
        txtPriNom.setText(uu.Lectura().get(0)[2]+"");
        txtSegNomb.setText(uu.Lectura().get(0)[3]+"");
        txtApePat.setText(uu.Lectura().get(0)[4]+"");
        txtApeMat.setText(uu.Lectura().get(0)[5]+"");
        txtDir.setText(uu.Lectura().get(0)[6]+"");
        cboDir.setSelectedItem(uu.Lectura().get(0)[7]+"");
        txtCorreo.setText(uu.Lectura().get(0)[8]+"");
        txtTelefono.setText(uu.Lectura().get(0)[9]+"");
        cboSexo.setSelectedItem(uu.Lectura().get(0)[10]+"");
        txtUsu.setText(uu.Lectura().get(0)[11]+"");
        txtContra.setText(uu.Lectura().get(0)[12]+"");
        txtContra2.setText(uu.Lectura().get(0)[12]+"");
       }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        pAgregar = new javax.swing.JPanel();
        lblDial = new javax.swing.JLabel();
        jScroll1 = new ScrollPaneSpecial.JScrollPane.JScroll();
        jPanel2 = new javax.swing.JPanel();
        Image = new swing.ImageAvatar();
        txtRuta = new textfield.TextField();
        btnFile = new ButtonSpecial.JbtnRadius.JButtonRadius();
        btnCancelar = new ButtonSpecial.JbtnRadius.JButtonRadius();
        txtDNI = new textfield.TextField();
        txtPriNom = new textfield.TextField();
        txtSegNomb = new textfield.TextField();
        txtApePat = new textfield.TextField();
        txtApeMat = new textfield.TextField();
        txtDir = new textfield.TextField();
        cboDir = new combobox.Combobox();
        txtCorreo = new textfield.TextField();
        txtTelefono = new textfield.TextField();
        cboSexo = new combobox.Combobox();
        txtUsu = new textfield.TextField();
        txtContra = new textfield.PasswordField();
        txtContra2 = new textfield.PasswordField();
        jPanel3 = new javax.swing.JPanel();
        opPer = new Presentacion.Components.OPPersonal();
        opEst = new Presentacion.Components.OPEstudiante();
        opEgre = new Presentacion.Components.OPEgresado();
        btnInsertar = new ButtonSpecial.JbtnRadius.JButtonRadius();
        btnAgregarDis = new ButtonSpecial.JbtnRadius.JButtonRadius();
        lblEDNI = new javax.swing.JLabel();
        lblESNom = new javax.swing.JLabel();
        lblEPNom = new javax.swing.JLabel();
        lblEApeM = new javax.swing.JLabel();
        lblEApeP = new javax.swing.JLabel();
        lblEDir = new javax.swing.JLabel();
        lblECorreo = new javax.swing.JLabel();
        lblETel = new javax.swing.JLabel();
        lblEUsu = new javax.swing.JLabel();
        lblEContra = new javax.swing.JLabel();
        lblEContra2 = new javax.swing.JLabel();
        btnLimpiar = new ButtonSpecial.JbtnRadius.JButtonRadius();
        lblTxt = new javax.swing.JLabel();
        btnAtras = new ButtonSpecial.JbtnRadius.JButtonRadius();
        pBuscar = new javax.swing.JPanel();
        txtBuscar = new textfield.TextField();
        cboBuscar = new combobox.Combobox();
        btnLimp = new ButtonSpecial.JbtnRadius.JButtonRadius();
        btnAgregar = new ButtonSpecial.JbtnRadius.JButtonRadius();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResult = new dynamic_subjtable.TableCustom();
        btnSalir = new ButtonSpecial.JbtnRadius.JButtonRadius();
        cboBuscar1 = new combobox.Combobox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 153, 255));
        setMinimumSize(new java.awt.Dimension(834, 490));
        setUndecorated(true);

        jPanel4.setLayout(new javax.swing.OverlayLayout(jPanel4));

        pAgregar.setBackground(new java.awt.Color(255, 255, 255));
        pAgregar.setMinimumSize(new java.awt.Dimension(834, 490));
        pAgregar.setPreferredSize(new java.awt.Dimension(834, 490));

        lblDial.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblDial.setForeground(new java.awt.Color(0, 102, 255));
        lblDial.setText("Egresado");
        lblDial.setToolTipText("");

        jScroll1.setScrollBackground(new java.awt.Color(0, 102, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        Image.setBorderSize(0);
        Image.setBorderSpace(0);
        Image.setImage(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icono-Adminhombre.png"))); // NOI18N

        txtRuta.setEditable(false);
        txtRuta.setBackground(new java.awt.Color(255, 255, 255));
        txtRuta.setLabelText("Ruta");

        btnFile.setBackground(new java.awt.Color(51, 204, 255));
        btnFile.setBorder(null);
        btnFile.setForeground(new java.awt.Color(255, 255, 255));
        btnFile.setText("Agregar");
        btnFile.setColorBackground(new java.awt.Color(51, 204, 255));
        btnFile.setColorClick(new java.awt.Color(0, 153, 255));
        btnFile.setColorOver(new java.awt.Color(102, 204, 255));
        btnFile.setColorText(new java.awt.Color(255, 255, 255));
        btnFile.setFocusPainted(false);
        btnFile.setRadius(15);
        btnFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFileActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(51, 204, 255));
        btnCancelar.setBorder(null);
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setColorClick(new java.awt.Color(0, 153, 255));
        btnCancelar.setColorOver(new java.awt.Color(102, 204, 255));
        btnCancelar.setColorText(new java.awt.Color(255, 255, 255));
        btnCancelar.setColorbackground(new java.awt.Color(51, 204, 255));
        btnCancelar.setFocusPainted(false);
        btnCancelar.setRadius(15);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtDNI.setLabelText("DNI");
        txtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDNIKeyTyped(evt);
            }
        });

        txtPriNom.setLabelText("Primer Nombre");
        txtPriNom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPriNomKeyTyped(evt);
            }
        });

        txtSegNomb.setLabelText("Segundo Nombre");
        txtSegNomb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSegNombKeyTyped(evt);
            }
        });

        txtApePat.setLabelText("Apellido Paterno");
        txtApePat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApePatKeyTyped(evt);
            }
        });

        txtApeMat.setLabelText("Apellido Materno");
        txtApeMat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApeMatKeyTyped(evt);
            }
        });

        txtDir.setLabelText("Direccion");
        txtDir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDirKeyTyped(evt);
            }
        });

        cboDir.setLabeText("Distrito");
        cboDir.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cboDirFocusGained(evt);
            }
        });
        cboDir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cboDirMouseEntered(evt);
            }
        });

        txtCorreo.setLabelText("Correo");
        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCorreoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoFocusLost(evt);
            }
        });
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoKeyTyped(evt);
            }
        });

        txtTelefono.setLabelText("Telefono");
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        cboSexo.setLabeText("Sexo");

        txtUsu.setLabelText("Usuario");
        txtUsu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuKeyTyped(evt);
            }
        });

        txtContra.setLabelText("Contraseña");
        txtContra.setShowAndHide(true);
        txtContra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContraKeyTyped(evt);
            }
        });

        txtContra2.setLabelText("Repetir Contraseña");
        txtContra2.setShowAndHide(true);
        txtContra2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContra2KeyTyped(evt);
            }
        });

        jPanel3.setLayout(new javax.swing.OverlayLayout(jPanel3));
        jPanel3.add(opPer);
        jPanel3.add(opEst);
        jPanel3.add(opEgre);

        btnInsertar.setBackground(new java.awt.Color(51, 204, 255));
        btnInsertar.setBorder(null);
        btnInsertar.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertar.setText("Agregar registro");
        btnInsertar.setColorBackground(new java.awt.Color(51, 204, 255));
        btnInsertar.setColorClick(new java.awt.Color(0, 153, 255));
        btnInsertar.setColorOver(new java.awt.Color(102, 204, 255));
        btnInsertar.setColorText(new java.awt.Color(255, 255, 255));
        btnInsertar.setFocusPainted(false);
        btnInsertar.setRadius(15);
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        btnAgregarDis.setBackground(new java.awt.Color(51, 204, 255));
        btnAgregarDis.setBorder(null);
        btnAgregarDis.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarDis.setText("Agregar Distrito");
        btnAgregarDis.setColorBackground(new java.awt.Color(51, 204, 255));
        btnAgregarDis.setColorClick(new java.awt.Color(0, 153, 255));
        btnAgregarDis.setColorOver(new java.awt.Color(102, 204, 255));
        btnAgregarDis.setColorText(new java.awt.Color(255, 255, 255));
        btnAgregarDis.setFocusPainted(false);
        btnAgregarDis.setRadius(15);
        btnAgregarDis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarDisActionPerformed(evt);
            }
        });

        lblEDNI.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblEDNI.setForeground(new java.awt.Color(255, 0, 0));

        lblESNom.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblESNom.setForeground(new java.awt.Color(255, 0, 0));

        lblEPNom.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblEPNom.setForeground(new java.awt.Color(255, 0, 0));

        lblEApeM.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblEApeM.setForeground(new java.awt.Color(255, 0, 0));

        lblEApeP.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblEApeP.setForeground(new java.awt.Color(255, 0, 0));

        lblEDir.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblEDir.setForeground(new java.awt.Color(255, 0, 0));

        lblECorreo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblECorreo.setForeground(new java.awt.Color(255, 0, 0));

        lblETel.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblETel.setForeground(new java.awt.Color(255, 0, 0));

        lblEUsu.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblEUsu.setForeground(new java.awt.Color(255, 0, 0));

        lblEContra.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblEContra.setForeground(new java.awt.Color(255, 0, 0));

        lblEContra2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblEContra2.setForeground(new java.awt.Color(255, 0, 0));

        btnLimpiar.setBackground(new java.awt.Color(51, 204, 255));
        btnLimpiar.setBorder(null);
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setColorClick(new java.awt.Color(0, 153, 255));
        btnLimpiar.setColorOver(new java.awt.Color(102, 204, 255));
        btnLimpiar.setColorText(new java.awt.Color(255, 255, 255));
        btnLimpiar.setColorbackground(new java.awt.Color(51, 204, 255));
        btnLimpiar.setFocusPainted(false);
        btnLimpiar.setRadius(15);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Image, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnFile, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(108, 108, 108)
                                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblEContra, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(132, 132, 132)
                                .addComponent(lblEContra2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtApePat, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDir, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEApeP, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEDir, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblECorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPriNom, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEPNom, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(132, 132, 132)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblESNom, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cboDir, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAgregarDis, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtApeMat, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtContra2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEApeM, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblETel, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSegNomb, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFile, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(Image, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(lblEDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPriNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSegNomb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblESNom, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEPNom, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApePat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApeMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEApeP, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEApeM, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cboDir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnAgregarDis, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEDir, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblECorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtUsu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblETel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblEUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContra2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEContra, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEContra2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        jScroll1.setViewportView(jPanel2);

        lblTxt.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        lblTxt.setForeground(new java.awt.Color(0, 102, 255));
        lblTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTxt.setText("Nuevo registro de un egresado");
        lblTxt.setToolTipText("");

        btnAtras.setBackground(new java.awt.Color(51, 204, 255));
        btnAtras.setBorder(null);
        btnAtras.setForeground(new java.awt.Color(255, 255, 255));
        btnAtras.setText("Atras");
        btnAtras.setColorBackground(new java.awt.Color(51, 204, 255));
        btnAtras.setColorClick(new java.awt.Color(0, 153, 255));
        btnAtras.setColorOver(new java.awt.Color(102, 204, 255));
        btnAtras.setColorText(new java.awt.Color(255, 255, 255));
        btnAtras.setFocusPainted(false);
        btnAtras.setRadius(15);
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pAgregarLayout = new javax.swing.GroupLayout(pAgregar);
        pAgregar.setLayout(pAgregarLayout);
        pAgregarLayout.setHorizontalGroup(
            pAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAgregarLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(pAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblDial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                        .addComponent(jScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        pAgregarLayout.setVerticalGroup(
            pAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAgregarLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblDial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScroll1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addGap(29, 29, 29)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        jPanel4.add(pAgregar);

        pBuscar.setBackground(new java.awt.Color(255, 255, 255));

        txtBuscar.setLabelText("Buscar");
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        cboBuscar.setLabeText("Buscar por:");

        btnLimp.setBackground(new java.awt.Color(51, 204, 255));
        btnLimp.setBorder(null);
        btnLimp.setForeground(new java.awt.Color(255, 255, 255));
        btnLimp.setText("Limpiar");
        btnLimp.setColorBackground(new java.awt.Color(51, 204, 255));
        btnLimp.setColorClick(new java.awt.Color(0, 153, 255));
        btnLimp.setColorOver(new java.awt.Color(102, 204, 255));
        btnLimp.setColorText(new java.awt.Color(255, 255, 255));
        btnLimp.setFocusPainted(false);
        btnLimp.setRadius(15);
        btnLimp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(51, 204, 255));
        btnAgregar.setBorder(null);
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.setColorBackground(new java.awt.Color(51, 204, 255));
        btnAgregar.setColorClick(new java.awt.Color(0, 153, 255));
        btnAgregar.setColorOver(new java.awt.Color(102, 204, 255));
        btnAgregar.setColorText(new java.awt.Color(255, 255, 255));
        btnAgregar.setFocusPainted(false);
        btnAgregar.setRadius(15);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
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

        btnSalir.setBackground(new java.awt.Color(51, 204, 255));
        btnSalir.setBorder(null);
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.setColorBackground(new java.awt.Color(51, 204, 255));
        btnSalir.setColorClick(new java.awt.Color(0, 153, 255));
        btnSalir.setColorOver(new java.awt.Color(102, 204, 255));
        btnSalir.setColorText(new java.awt.Color(255, 255, 255));
        btnSalir.setFocusPainted(false);
        btnSalir.setRadius(15);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        cboBuscar1.setLabeText("Buscar como:");

        javax.swing.GroupLayout pBuscarLayout = new javax.swing.GroupLayout(pBuscar);
        pBuscar.setLayout(pBuscarLayout);
        pBuscarLayout.setHorizontalGroup(
            pBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pBuscarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pBuscarLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pBuscarLayout.createSequentialGroup()
                        .addComponent(cboBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimp, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(pBuscarLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        pBuscarLayout.setVerticalGroup(
            pBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLimp, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        jPanel4.add(pBuscar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       ImageDs();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        Limpiar();
        IniciDatos(txt.toLowerCase());
        pAgregar.setVisible(false);
        pBuscar.setVisible(true);
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFileActionPerformed
        ChooserFile();
    }//GEN-LAST:event_btnFileActionPerformed

    private void txtPriNomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriNomKeyTyped
        VisualText(lblEPNom, txtPriNom, evt,29);
    }//GEN-LAST:event_txtPriNomKeyTyped

    private void txtSegNombKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSegNombKeyTyped
       VisualText(lblESNom, txtSegNomb, evt,29);
    }//GEN-LAST:event_txtSegNombKeyTyped

    private void txtApePatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApePatKeyTyped
       VisualText(lblEApeP, txtApePat, evt,49);
    }//GEN-LAST:event_txtApePatKeyTyped

    private void txtApeMatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApeMatKeyTyped
       VisualText(lblEApeM, txtApeMat, evt,49);
    }//GEN-LAST:event_txtApeMatKeyTyped

    private void txtDirKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDirKeyTyped
        VisualText(lblEDir, txtDir, evt,49);
    }//GEN-LAST:event_txtDirKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        vl.valNumber(evt);
        VisualText(lblETel, txtTelefono, evt,8);
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtUsuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuKeyTyped
       if(evt.getKeyCode()!=8 || evt.getKeyCode()!=32){
        VisualText(lblEUsu, txtUsu, evt,29);
       }else{
           evt.consume();
       }
    }//GEN-LAST:event_txtUsuKeyTyped

    private void txtContraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraKeyTyped
        lblEContra.setText("");
        txtContra.setLineColor(new Color(3,155,216));
        vl.valText(txtContra, 49, evt);
    }//GEN-LAST:event_txtContraKeyTyped

    private void txtContra2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContra2KeyTyped
        lblEContra2.setText("");
        txtContra2.setLineColor(new Color(3,155,216));
        vl.valText(txtContra2, 49, evt);
    }//GEN-LAST:event_txtContra2KeyTyped

    private void txtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyTyped
        VisualText(lblECorreo, txtCorreo, evt,49);
    }//GEN-LAST:event_txtCorreoKeyTyped

    private void txtCorreoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusGained
        String correo=txtCorreo.getText().trim();
        if(!txtCorreo.getText().isEmpty()){
            txtCorreo.setText(correo.replaceAll("@gmail.com",""));
        }
    }//GEN-LAST:event_txtCorreoFocusGained

    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost
        Correo();
    }//GEN-LAST:event_txtCorreoFocusLost

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
       Insertar();
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnAgregarDisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDisActionPerformed
        new PDistrito(frm, true,"Distrito",true).setVisible(true);
    }//GEN-LAST:event_btnAgregarDisActionPerformed

    private void cboDirFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cboDirFocusGained
      
    }//GEN-LAST:event_cboDirFocusGained

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        isInsert=true;
        btnInsertar.setText("Agregar registro");
        pBuscar.setVisible(false);
        pAgregar.setVisible(true);
        btnLimpiar.setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
       this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
       if(cboBuscar1.getSelectedIndex()==0||cboBuscar1.getSelectedIndex()==5){
           vl.valNumber(evt);
       }
    }//GEN-LAST:event_txtBuscarKeyTyped

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
                     btnLimpiar.setVisible(false);
                     btnInsertar.setText("Modificar registro");
                     pBuscar.setVisible(false);
                     pAgregar.setVisible(true);
               }else{
                   
                     int i=tblResult.getSelectedRow();
                     int data=0;
                      
                     switch(txt.toLowerCase()){
                                    case "egresado":
                                            data=11;
                                            break;
                                    case "estudiante":
                                            data=10;
                                            break;
                                    case "personal":
                                            data=12;
                                            break;
        
                                    }  
                     
                     el=new Eliminar(frm,true,data,(String) tblResult.getValueAt(i, 0));
                     el.info(txt.toLowerCase(),(String) tblResult.getValueAt(i, 2));
                     el.setVisible(true);
                  
               }
           }
       } 
       
    }//GEN-LAST:event_tblResultMousePressed
  
    private void txtDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNIKeyTyped
        lblEDNI.setText("");
        txtDNI.setLineColor(new Color(3,155,216));
        vl.valNumber(evt);
        if(evt.getKeyChar()!=8 || evt.getKeyCode()!=32){
            vl.valText(txtDNI, 7, evt);
        }else{
            evt.consume();
        }
        ItemsData(txtDNI.getText());
    }//GEN-LAST:event_txtDNIKeyTyped

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        Limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        int a=cboBuscar.getSelectedIndex(),b=cboBuscar1.getSelectedIndex();
        IniBuscar(a,b,txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnLimpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpActionPerformed
       IniciDatos(txt); 
    }//GEN-LAST:event_btnLimpActionPerformed

    private void cboDirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboDirMouseEntered
          while(cboDir.getItemCount()>=1){cboDir.removeItemAt(0);}
            for(Object o:dd.cboDistrito()){cboDir.addItem(o);}
    }//GEN-LAST:event_cboDirMouseEntered

 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ImageAvatar Image;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnAgregar;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnAgregarDis;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnAtras;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnCancelar;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnFile;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnInsertar;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnLimp;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnLimpiar;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnSalir;
    private combobox.Combobox cboBuscar;
    private combobox.Combobox cboBuscar1;
    private combobox.Combobox cboDir;
    private combobox.Combobox cboSexo;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private ScrollPaneSpecial.JScrollPane.JScroll jScroll1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDial;
    private javax.swing.JLabel lblEApeM;
    private javax.swing.JLabel lblEApeP;
    private javax.swing.JLabel lblEContra;
    private javax.swing.JLabel lblEContra2;
    private javax.swing.JLabel lblECorreo;
    private javax.swing.JLabel lblEDNI;
    private javax.swing.JLabel lblEDir;
    private javax.swing.JLabel lblEPNom;
    private javax.swing.JLabel lblESNom;
    private javax.swing.JLabel lblETel;
    private javax.swing.JLabel lblEUsu;
    private javax.swing.JLabel lblTxt;
    private Presentacion.Components.OPEgresado opEgre;
    private Presentacion.Components.OPEstudiante opEst;
    private Presentacion.Components.OPPersonal opPer;
    private javax.swing.JPanel pAgregar;
    private javax.swing.JPanel pBuscar;
    private dynamic_subjtable.TableCustom tblResult;
    private textfield.TextField txtApeMat;
    private textfield.TextField txtApePat;
    private textfield.TextField txtBuscar;
    private textfield.PasswordField txtContra;
    private textfield.PasswordField txtContra2;
    private textfield.TextField txtCorreo;
    private textfield.TextField txtDNI;
    private textfield.TextField txtDir;
    private textfield.TextField txtPriNom;
    private textfield.TextField txtRuta;
    private textfield.TextField txtSegNomb;
    private textfield.TextField txtTelefono;
    private textfield.TextField txtUsu;
    // End of variables declaration//GEN-END:variables

   
}
