/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Panel;

import Entidad.Cargo;
import Entidad.Personal;
import Entidad.Usuario;
import Negocio.NCargo;
import Negocio.NDistrito;
import Negocio.NPersonal;
import Negocio.NUsuario;
import Negocio.Desing;
import Negocio.Mantenimiento;
import Negocio.ValidateText;
import Presentacion.Modal.PDistrito;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author andyv
 */
public class Admin extends javax.swing.JPanel {
    
    private Mantenimiento m=new Mantenimiento();
    private JFrame frm=null;
    
    private JPanel p1=null;
    private JPanel p2=null;
    
    private JFileChooser file=new JFileChooser();
    
    private final NDistrito dd=new NDistrito();
    private final NUsuario uu=new NUsuario();
    private final NCargo cc=new NCargo();
    private final NPersonal pp=new NPersonal();
    private final Desing ds=new Desing();
    private final ValidateText val=new ValidateText();
    
    private String ruta=file.getCurrentDirectory().getPath();
    private String archivo="";
    private String nameC="";
    
    private boolean isImageAgre=false;
    private boolean isAddAdmin=false;
    
    
    public Admin() {
        initComponents();
        IniciarFiltro();
        Inicial();
        IniciarUsuario();
    }

    
    public void Form(JFrame frm){
        this.frm=frm;
    }
    
     public void Panel(JPanel p1,JPanel p2){
       this.p1=p1;
       this.p2=p2;
     }
   
     //Verifica si existe el cargo de administrador
     //si existe no pasara nada en caso no exista se registrara
   private void IniciarFiltro(){
       Cargo c=new Cargo();
       c.setNombre("Administrador");
       c.setEstado(true);
       
       if(!cc.buscarNom(c.getNombre())){
           cc.Insertar(c);
       }
   } 
   
     //Verifica si existe un usuario 
   private void IniciarUsuario(){
       if(pp.BuscarBool(cboCargo.getSelectedItem()+"",pp.PERSONAL_CARGO)){
           //En caso de existir un usuario desabilita los componentes 
          val.TextFor(txtDNI,txtPriNombre,txtSegNombre,txtApeP,txtApeM,txtDireccion,txtCorreo,txtTelefono,txtUsuario,txtContra,txtRContra);
          val.ButtonFor(btnADistrito,btnAAdmin,btnFile,btnCancelar);
          val.ComboFor(cboDistrito,cboSexo,cboCargo);
          lblEE.setText("Ya existe un usuario registrado presione siguiente");
          isAddAdmin=true;
       }
   }
   
   private void IniciarMantenimiento(String user,String contra,String bd){
        m.setUsuario(user);
        m.setContra(contra);
        m.setData(bd);
   }

   //Inicializar el texto
   private void Inicial(){
      txtRuta.setText(ruta);
      btnAbajo.setVisible(false);
      for(Object sexo:uu.cboSexo()){cboSexo.addItem(sexo);} 
      for(Object distrito:dd.cboDistrito()){cboDistrito.addItem(distrito);}
      for(Object cargo:cc.cboCargo()){cboCargo.addItem(cargo);}
   }

   //procedimiento para abrir el explorador de archivos
   //Para la cargar de una imagen como foto de perfil
   private void fileAsig(){
       try{
            file.setFileFilter(new FileNameExtensionFilter("Imagenes","jpg","png"));
            file.showSaveDialog(this);
            ruta=file.getSelectedFile().getPath();            
            txtRuta.setText(ruta);
            
            ds.AsignarImagen(lblFotoPerfil, ruta);
            isImageAgre=true;
       }catch(Exception e){
           ImageDs();
       }
       
   }
   
   //Valida el correo y lo verifica
   private void Correo(){
    String correo=txtCorreo.getText().trim();
    if(!correo.isEmpty()){
           correo=correo.replaceAll("@gmail.com","");
            txtCorreo.setText(correo+"@gmail.com");
        }
    
    }
   
   private void DNI(KeyEvent evt){
    lblEDNI.setText("");
    txtDNI.setText(txtDNI.getText().trim());
    String txt=txtDNI.getText();
       if(evt.getKeyCode()!=8){ 
           if(evt.getKeyCode()!=32){
            if( txt.length()>7){
               evt.consume();
                lblEDNI.setText("No se puede agregar mas de 8 caracteres");
            }
          }else{
                  if(txt.length()>0){
                      evt.consume();}     
        }
       }
       
   }
   
   //verifica que cada uno de las caja de textos mportantes deben estar rellenadas 
   private boolean ValidateText(){
      JTextField[] txt = new JTextField[]{txtDNI,txtPriNombre,txtApeP,txtCorreo,txtUsuario,txtContra,txtRContra};
      JLabel[] lbl1=new JLabel[]{lblEDNI,lblEPriNombre,lblEApeP,lblECorreo,lblEUser,lblEContra,lblERContra};
      String CName1="",CName2="";
      
      //codifica las contraseñas
      for(char u:txtContra.getPassword()){CName1+=u;}
      for(char u:txtRContra.getPassword()){CName2+=u;}
      
      //verifica los textbox vacios
     if(val.valTextField(txt,"Esta casilla no debes estar vacia",lbl1,Color.red,new Color(3,155,216))){
         
        //verifica la cantidad de digitos en un dni       
         if(txt[0].getText().length() == 8){
             //verifica si el cboDistrito tiene valores agregados
                    if(cboDistrito.getSelectedIndex() >= 0){
                        //verifica si las contraseñas son iguales
                        if(CName1.equals(CName2)){
                            //Implementa el insertado en Usuario
                            if(uu.Insertar(ItemsU())){
                                //Implementa de Insertado en personal
                                if(pp.Insertar(ItemsP())){
                                    
                                    isAddAdmin= true;
                                }
                            }
                        }else{
                            lblERContra.setText("La contraseña debe ser igual en cada casilla");
                        }
                    }else{
                        lblEDistrito.setText("El distrito debe tener un valor");
                    }
                }else{
                    lblEDNI.setText("Debe rellenar los 8 caracteres");
                } 
            }else{
                btnAbajo.setVisible(true);
        }
     return isAddAdmin;
   }
   
   private Usuario ItemsU(){
       Usuario u=new Usuario();
       String txt="";
       for(char c:txtRContra.getPassword()){txt+=c;}
       
       u.setDNI(txtDNI.getText());
       u.setPriNombre(txtPriNombre.getText());
       u.setSegNombre(txtSegNombre.getText());
       u.setApePat(txtApeP.getText());
       u.setApeMat(txtApeM.getText());
       u.setDireccion(txtDireccion.getText());
       u.setDistrito(cboDistrito.getSelectedIndex()+1);
       u.setCorreo(txtCorreo.getText());
       u.setTelefono(txtTelefono.getText());
       u.setSexo(cboSexo.getSelectedIndex()+1);
       u.setUsuario(txtUsuario.getText());
       u.setContraseña(txt);
       u.setFotoPerfil(ds.ConvByte(((ImageIcon) lblFotoPerfil.getIcon()).getImage(), lblFotoPerfil.getWidth(), lblFotoPerfil.getHeight()));
       return u;
   }
   
   private Personal ItemsP(){
   Personal p=new Personal();
        p.setDNI(txtDNI.getText());
        p.setCargo(cboCargo.getSelectedIndex()+1);
   return p;
   }
   
    //verifica que opcion esta el cbo
   // si esta en masculino mostrara el icono de hombre asi al reves
    public void ImageDs() {
       String arc="icono-Adminhombre.png";
       if(cboSexo.getSelectedIndex()==1){
           arc="icono-AdminMujer.png";
       }

       ds.AsignarImagen(lblFotoPerfil,"/Imagens", arc);
       ds.AsignarImagen(btnAbajo,30,30);
   }
  
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pScroll = new ScrollPaneSpecial.JScrollPane.JScroll();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDNI = new textfield.TextField();
        txtPriNombre = new textfield.TextField();
        txtSegNombre = new textfield.TextField();
        txtApeP = new textfield.TextField();
        txtApeM = new textfield.TextField();
        txtDireccion = new textfield.TextField();
        cboDistrito = new combobox.Combobox();
        txtCorreo = new textfield.TextField();
        txtTelefono = new textfield.TextField();
        cboSexo = new combobox.Combobox();
        txtUsuario = new textfield.TextField();
        cboCargo = new combobox.Combobox();
        jLabel3 = new javax.swing.JLabel();
        lblFotoPerfil = new javax.swing.JLabel();
        txtRuta = new textfield.TextField();
        btnCancelar = new ButtonSpecial.JbtnRadius.JButtonRadius();
        lblEDistrito = new javax.swing.JLabel();
        lblEDNI = new javax.swing.JLabel();
        lblEPriNombre = new javax.swing.JLabel();
        lblETelefono = new javax.swing.JLabel();
        lblESegNombre = new javax.swing.JLabel();
        lblEApeP = new javax.swing.JLabel();
        lblEApeMat = new javax.swing.JLabel();
        lblECargo = new javax.swing.JLabel();
        lblEDireccion = new javax.swing.JLabel();
        lblECorreo = new javax.swing.JLabel();
        lblESexo = new javax.swing.JLabel();
        lblERContra = new javax.swing.JLabel();
        txtRContra = new textfield.PasswordField();
        txtContra = new textfield.PasswordField();
        lblEUser = new javax.swing.JLabel();
        lblEContra = new javax.swing.JLabel();
        btnFile = new ButtonSpecial.JbtnRadius.JButtonRadius();
        btnAAdmin = new ButtonSpecial.JbtnRadius.JButtonRadius();
        btnADistrito = new ButtonSpecial.JbtnRadius.JButtonRadius();
        btnAbajo = new ButtonSpecial.JbtnRadius.JButtonRadius();
        btnSiguiente = new ButtonSpecial.JbtnRadius.JButtonRadius();
        btnAnterior = new ButtonSpecial.JbtnRadius.JButtonRadius();
        lblEE = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(830, 410));
        setPreferredSize(new java.awt.Dimension(834, 490));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pScroll.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        pScroll.setScrollBackground(new java.awt.Color(0, 102, 255));
        pScroll.setScrollClick(new java.awt.Color(51, 204, 255));
        pScroll.setScrollOver(new java.awt.Color(0, 204, 204));
        pScroll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pScrollMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(772, 900));
        jPanel1.setPreferredSize(new java.awt.Dimension(778, 900));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("Agregar Administrador");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 255));
        jLabel2.setText("<html>Antes de entrar al programa debe registrar a un usuario principal como administrador para la seguridad del programa y datos, al iniciarla aplicacion le aparecera un login donde ingresara su usuario y contraseña, debe agregar la informacion correspondiente:\n\n</html>");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 55, 700, -1));

        txtDNI.setLabelText("DNI");
        txtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDNIKeyTyped(evt);
            }
        });
        jPanel1.add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 215, -1));

        txtPriNombre.setLabelText("Primer Nombre");
        txtPriNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPriNombreKeyTyped(evt);
            }
        });
        jPanel1.add(txtPriNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 215, -1));

        txtSegNombre.setLabelText("Segundo Nombre");
        txtSegNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSegNombreKeyTyped(evt);
            }
        });
        jPanel1.add(txtSegNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, 215, -1));

        txtApeP.setLabelText("Apellido Paterno");
        txtApeP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApePKeyTyped(evt);
            }
        });
        jPanel1.add(txtApeP, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 215, -1));

        txtApeM.setLabelText("Apellido Materno");
        txtApeM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApeMKeyTyped(evt);
            }
        });
        jPanel1.add(txtApeM, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, 215, -1));

        txtDireccion.setLabelText("Direccion");
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDireccionKeyReleased(evt);
            }
        });
        jPanel1.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 520, 215, -1));

        cboDistrito.setLabeText("Distrito");
        cboDistrito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cboDistritoMouseEntered(evt);
            }
        });
        jPanel1.add(cboDistrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 520, 230, 44));

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
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 600, 215, -1));

        txtTelefono.setLabelText("Telefono");
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 600, 230, -1));

        cboSexo.setLabeText("Sexo");
        cboSexo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboSexoItemStateChanged(evt);
            }
        });
        jPanel1.add(cboSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 670, 220, 44));

        txtUsuario.setLabelText("Usuario");
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 750, 215, -1));

        cboCargo.setLabeText("Cargo");
        jPanel1.add(cboCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 670, 227, 44));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Foto de Perfil");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 120, -1));

        lblFotoPerfil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lblFotoPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 136, 140));

        txtRuta.setEditable(false);
        txtRuta.setBackground(new java.awt.Color(255, 255, 255));
        txtRuta.setForeground(new java.awt.Color(102, 102, 102));
        txtRuta.setFocusable(false);
        txtRuta.setLabelText("Ruta");
        txtRuta.setLineColor(new java.awt.Color(109, 109, 109));
        jPanel1.add(txtRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 250, -1));

        btnCancelar.setBackground(new java.awt.Color(51, 153, 255));
        btnCancelar.setBorder(null);
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Borrar");
        btnCancelar.setColorBackground(new java.awt.Color(51, 153, 255));
        btnCancelar.setColorClick(new java.awt.Color(51, 204, 255));
        btnCancelar.setColorOver(new java.awt.Color(51, 204, 255));
        btnCancelar.setColorText(new java.awt.Color(255, 255, 255));
        btnCancelar.setFocusPainted(false);
        btnCancelar.setRadius(15);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 95, 30));

        lblEDistrito.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblEDistrito.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lblEDistrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 570, 215, 20));

        lblEDNI.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblEDNI.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lblEDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 340, 210, 20));

        lblEPriNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblEPriNombre.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lblEPriNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 230, 20));

        lblETelefono.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblETelefono.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lblETelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 650, 230, 20));

        lblESegNombre.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblESegNombre.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lblESegNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 410, 276, 20));

        lblEApeP.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblEApeP.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lblEApeP, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, 215, 20));

        lblEApeMat.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblEApeMat.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lblEApeMat, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 490, 276, 20));

        lblECargo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblECargo.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lblECargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 720, 220, 20));

        lblEDireccion.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblEDireccion.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lblEDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 570, 215, 20));

        lblECorreo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblECorreo.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lblECorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 650, 220, 20));

        lblESexo.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblESexo.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lblESexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 720, 215, 20));

        lblERContra.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblERContra.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lblERContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 870, 215, 20));

        txtRContra.setLabelText("Repetir Contraseña");
        txtRContra.setShowAndHide(true);
        txtRContra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRContraKeyTyped(evt);
            }
        });
        jPanel1.add(txtRContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 820, 230, -1));

        txtContra.setLabelText("Contraseña");
        txtContra.setShowAndHide(true);
        txtContra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContraKeyTyped(evt);
            }
        });
        jPanel1.add(txtContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 750, 230, -1));

        lblEUser.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblEUser.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lblEUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 800, 215, 20));

        lblEContra.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        lblEContra.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lblEContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 800, 215, 20));

        btnFile.setBackground(new java.awt.Color(51, 153, 255));
        btnFile.setBorder(null);
        btnFile.setForeground(new java.awt.Color(255, 255, 255));
        btnFile.setText("Agregar");
        btnFile.setColorBackground(new java.awt.Color(51, 153, 255));
        btnFile.setColorClick(new java.awt.Color(51, 204, 255));
        btnFile.setColorOver(new java.awt.Color(102, 204, 255));
        btnFile.setColorText(new java.awt.Color(255, 255, 255));
        btnFile.setFocusPainted(false);
        btnFile.setRadius(15);
        btnFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFileActionPerformed(evt);
            }
        });
        jPanel1.add(btnFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 90, 30));

        btnAAdmin.setBackground(new java.awt.Color(51, 153, 255));
        btnAAdmin.setBorder(null);
        btnAAdmin.setForeground(new java.awt.Color(255, 255, 255));
        btnAAdmin.setText("Agregar administrador");
        btnAAdmin.setColorBackground(new java.awt.Color(51, 153, 255));
        btnAAdmin.setColorClick(new java.awt.Color(102, 204, 255));
        btnAAdmin.setColorOver(new java.awt.Color(0, 204, 255));
        btnAAdmin.setColorText(new java.awt.Color(255, 255, 255));
        btnAAdmin.setFocusPainted(false);
        btnAAdmin.setRadius(30);
        btnAAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAAdminActionPerformed(evt);
            }
        });
        jPanel1.add(btnAAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 830, 140, 40));

        btnADistrito.setBackground(new java.awt.Color(51, 153, 255));
        btnADistrito.setBorder(null);
        btnADistrito.setForeground(new java.awt.Color(255, 255, 255));
        btnADistrito.setText("Agregar Distrito");
        btnADistrito.setColorBackground(new java.awt.Color(51, 153, 255));
        btnADistrito.setColorClick(new java.awt.Color(51, 204, 255));
        btnADistrito.setColorOver(new java.awt.Color(51, 204, 255));
        btnADistrito.setColorText(new java.awt.Color(255, 255, 255));
        btnADistrito.setFocusPainted(false);
        btnADistrito.setRadius(15);
        btnADistrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnADistritoActionPerformed(evt);
            }
        });
        jPanel1.add(btnADistrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 530, 95, 30));

        btnAbajo.setBackground(new java.awt.Color(0, 102, 255));
        btnAbajo.setBorder(null);
        btnAbajo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Flecha_Abajo.png"))); // NOI18N
        btnAbajo.setColorBackground(new java.awt.Color(0, 102, 255));
        btnAbajo.setColorClick(new java.awt.Color(51, 204, 255));
        btnAbajo.setColorOver(new java.awt.Color(51, 204, 255));
        btnAbajo.setColorText(new java.awt.Color(255, 255, 255));
        btnAbajo.setFocusPainted(false);
        btnAbajo.setRadius(50);
        jPanel1.add(btnAbajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 350, 50, 50));

        pScroll.setViewportView(jPanel1);

        add(pScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 15, 790, 380));

        btnSiguiente.setBackground(new java.awt.Color(0, 102, 255));
        btnSiguiente.setBorder(null);
        btnSiguiente.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguiente.setText("Siguiente");
        btnSiguiente.setColorBackground(new java.awt.Color(0, 102, 255));
        btnSiguiente.setColorClick(new java.awt.Color(102, 204, 255));
        btnSiguiente.setColorOver(new java.awt.Color(0, 153, 255));
        btnSiguiente.setColorText(new java.awt.Color(255, 255, 255));
        btnSiguiente.setRadius(15);
        btnSiguiente.setRequestFocusEnabled(false);
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 410, 110, 30));

        btnAnterior.setBackground(new java.awt.Color(0, 102, 255));
        btnAnterior.setBorder(null);
        btnAnterior.setForeground(new java.awt.Color(255, 255, 255));
        btnAnterior.setText("Anterior");
        btnAnterior.setColorBackground(new java.awt.Color(0, 102, 255));
        btnAnterior.setColorClick(new java.awt.Color(102, 204, 255));
        btnAnterior.setColorOver(new java.awt.Color(0, 153, 255));
        btnAnterior.setColorText(new java.awt.Color(255, 255, 255));
        btnAnterior.setRadius(15);
        btnAnterior.setRequestFocusEnabled(false);
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        add(btnAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, 110, 30));

        lblEE.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        lblEE.setForeground(new java.awt.Color(0, 102, 255));
        add(lblEE, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, 480, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
       IniciarUsuario();
        if(isAddAdmin){
            this.setVisible(false);
            p2.setVisible(true);
       }else{
             ValidateText();
       }
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        this.setVisible(false);
        p1.setVisible(true);
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void cboSexoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboSexoItemStateChanged
        try{
            if(!isImageAgre){ImageDs();} 
        }catch(Exception e){}
    }//GEN-LAST:event_cboSexoItemStateChanged

    private void btnFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFileActionPerformed
       fileAsig();
    }//GEN-LAST:event_btnFileActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       isImageAgre=false;
       ImageDs();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAAdminActionPerformed
         ValidateText();
         IniciarUsuario();
    }//GEN-LAST:event_btnAAdminActionPerformed

    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost
        Correo();
    }//GEN-LAST:event_txtCorreoFocusLost

    private void txtCorreoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusGained
       String correo=txtCorreo.getText().trim();
        if(!txtCorreo.getText().isEmpty()){
            txtCorreo.setText(correo.replaceAll("@gmail.com",""));
        }
    }//GEN-LAST:event_txtCorreoFocusGained

    private void btnADistritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnADistritoActionPerformed
        new PDistrito(frm,true,"Distrito",true).setVisible(true);
    }//GEN-LAST:event_btnADistritoActionPerformed

    private void pScrollMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pScrollMouseClicked
        btnAbajo.setVisible(false);
    }//GEN-LAST:event_pScrollMouseClicked

    private void txtDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNIKeyTyped
       txtDNI.setLineColor(new Color(3,155,216));
       val.valNumber(evt);
       DNI(evt);
    }//GEN-LAST:event_txtDNIKeyTyped

    private void txtPriNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriNombreKeyTyped
         lblEPriNombre.setText("");
        txtPriNombre.setLineColor(new Color(3,155,216));
        val.valText(txtPriNombre,29,evt);
    }//GEN-LAST:event_txtPriNombreKeyTyped

    private void txtSegNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSegNombreKeyTyped
        txtSegNombre.setLineColor(new Color(3,155,216));
        val.valText(txtSegNombre,29,evt);
    }//GEN-LAST:event_txtSegNombreKeyTyped

    private void txtApePKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApePKeyTyped
    lblEApeP.setText("");
        txtApeP.setLineColor(new Color(3,155,216));
        val.valText(txtApeP,49,evt);
    }//GEN-LAST:event_txtApePKeyTyped

    private void txtApeMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApeMKeyTyped
         txtApeM.setLineColor(new Color(3,155,216));
        val.valText(txtApeM,49,evt);
    }//GEN-LAST:event_txtApeMKeyTyped

    private void txtDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyReleased
        txtDireccion.setLineColor(new Color(3,155,216));
        val.valText(txtDireccion,49,evt);
    }//GEN-LAST:event_txtDireccionKeyReleased

    private void txtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyTyped
         txtCorreo.setLineColor(new Color(3,155,216));
        val.valText(txtCorreo,39,evt);
    }//GEN-LAST:event_txtCorreoKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
       txtTelefono.setLineColor(new Color(3,155,216));
       lblETelefono.setText("");
       val.valNumber(evt);
       if(evt.getKeyCode() != 32){
            val.valText(txtTelefono,8,evt);
       }else{
            lblETelefono.setText("No se admite espaciado");
            if(txtTelefono.getText().isEmpty()){
                txtTelefono.setText("");
            }else{
                val.valText(txtTelefono,8,evt);
            }
       }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        lblEUser.setText("");
        txtUsuario.setLineColor(new Color(3,155,216));
        val.valText(txtUsuario,29,evt);
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtContraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraKeyTyped
        lblEContra.setText("");
        txtContra.setLineColor(new Color(3,155,216));
        val.valText(txtContra,49,evt);
    }//GEN-LAST:event_txtContraKeyTyped

    private void txtRContraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRContraKeyTyped
        lblERContra.setText("");
        txtRContra.setLineColor(new Color(3,155,216));
        val.valText(txtContra,49,evt);
    }//GEN-LAST:event_txtRContraKeyTyped

    private void cboDistritoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboDistritoMouseEntered
        if(cboDistrito.getItemCount()>0){cboDistrito.removeAllItems();}
        for(Object distrito:dd.cboDistrito()){cboDistrito.addItem(distrito);}
    }//GEN-LAST:event_cboDistritoMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ButtonSpecial.JbtnRadius.JButtonRadius btnAAdmin;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnADistrito;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnAbajo;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnAnterior;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnCancelar;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnFile;
    private ButtonSpecial.JbtnRadius.JButtonRadius btnSiguiente;
    private combobox.Combobox cboCargo;
    private combobox.Combobox cboDistrito;
    private combobox.Combobox cboSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblEApeMat;
    private javax.swing.JLabel lblEApeP;
    private javax.swing.JLabel lblECargo;
    private javax.swing.JLabel lblEContra;
    private javax.swing.JLabel lblECorreo;
    private javax.swing.JLabel lblEDNI;
    private javax.swing.JLabel lblEDireccion;
    private javax.swing.JLabel lblEDistrito;
    private javax.swing.JLabel lblEE;
    private javax.swing.JLabel lblEPriNombre;
    private javax.swing.JLabel lblERContra;
    private javax.swing.JLabel lblESegNombre;
    private javax.swing.JLabel lblESexo;
    private javax.swing.JLabel lblETelefono;
    private javax.swing.JLabel lblEUser;
    private javax.swing.JLabel lblFotoPerfil;
    private ScrollPaneSpecial.JScrollPane.JScroll pScroll;
    private textfield.TextField txtApeM;
    private textfield.TextField txtApeP;
    private textfield.PasswordField txtContra;
    private textfield.TextField txtCorreo;
    private textfield.TextField txtDNI;
    private textfield.TextField txtDireccion;
    private textfield.TextField txtPriNombre;
    private textfield.PasswordField txtRContra;
    private textfield.TextField txtRuta;
    private textfield.TextField txtSegNombre;
    private textfield.TextField txtTelefono;
    private textfield.TextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
