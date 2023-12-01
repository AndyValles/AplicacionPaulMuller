package Datos;

import Entidad.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andyv
 */
public class  DUsuario extends DComponets{
    
    private final String[] datos=new String[]{"DNI1","Dis","Sex","DNI2","Nomb","Ape","Dir","Cor","Tel","User"};
    
    
    public DUsuario() { 
    }
    
    public DefaultTableModel Leer(){
        try{
               super.Leer("call mUsuarios();");
                
                while(rs.next()){
                   Object[] items=new Object[13];
                   items[0]=rs.getString(1);                   
                   items[1]=Data(new ImageIcon(ImageIO.read(rs.getBinaryStream(2))));
                   items[2]=rs.getString(3);
                   items[3]=rs.getString(4);
                   items[4]=rs.getString(5);
                   items[5]=rs.getString(6);
                   items[6]=rs.getString(7);
                   items[7]=rs.getString(8);
                   items[8]=rs.getString(9);
                   items[9]=rs.getString(10);
                   items[10]=rs.getString(11);
                   items[11]=rs.getString(12);
                   items[12]=rs.getString(13);
                   cantidad++;
                   dt.addRow(items);
                }
               
               Cerrar();
        }catch(IOException | SQLException e){
            System.out.println("Usuario: Error de lectura: "+ e);
        }
    return dt;
    }
     
    
     public DefaultTableModel Buscar(Usuario u,String txt,int i){
         
        
         
        try{
            super.Buscar("call b"+datos[i-1]+"Usuarios(?);");
            
            if(i==1){o=u.getDNI();
            }else {o=txt;}
            
            cSt.setObject(1, o);
            
            rs=cSt.executeQuery();
                
            while(rs.next()){
                   Object[] items=new Object[13];
                   items[0]=rs.getString(1);
                   items[1]=Data(new ImageIcon(ImageIO.read(rs.getBinaryStream(2))));
                   items[2]=rs.getString(3);
                   items[3]=rs.getString(4);
                   items[4]=rs.getString(5);
                   items[5]=rs.getString(6);
                   items[6]=rs.getString(7);
                   items[7]=rs.getString(8);
                   items[8]=rs.getString(9);
                   items[9]=rs.getString(10);
                   items[10]=rs.getString(11);
                   items[11]=rs.getString(12);
                   items[12]=rs.getString(13);
                   busqueda.add(items);
                   dt.addRow(items);
                }
                
                
                Cerrar();
        }catch(IOException | SQLException e){
        System.out.println("Usuario: Error de Buscado: "+ e);}
    return dt;
    }
    
    public boolean Insertar(Usuario u){
    
     try{
        super.Insertar("call iUsuarios(?,?,?,?,?,?,?,?,?,?,?,?,?);");
        
        cSt.setString(1, u.getDNI());
        cSt.setString(2, u.getPriNombre());
        cSt.setString(3, u.getSegNombre());
        cSt.setString(4, u.getApePat());
        cSt.setString(5, u.getApeMat());
        cSt.setString(6, u.getDireccion());
        cSt.setInt(7, u.getDistrito());
        cSt.setString(8, u.getCorreo());
        cSt.setString(9, u.getTelefono());
        cSt.setInt(10, u.getSexo());
        cSt.setString(11, u.getUsuario());
        cSt.setString(12, u.getContraseña());
        cSt.setBytes(13, u.getFotoPerfil());
        
        rs=cSt.executeQuery();
     
    
        Cerrar();
        
        return true;
     
    }catch(SQLException e){
        System.out.println("Usuario: Error de Insertado: "+ e);
    }
    return false;
    }
    

    public boolean Actualizar(Usuario u){
    try{
    super.Actualizar("call uUsuarios(?,?,?,?,?,?,?,?,?,?,?,?,?);");
    
      cSt.setString(1, u.getPriNombre());
      cSt.setString(2, u.getSegNombre());
      cSt.setString(3, u.getApePat());
      cSt.setString(4, u.getApeMat());
      cSt.setString(5, u.getDireccion());
      cSt.setInt(6, u.getDistrito());
      cSt.setString(7, u.getCorreo());
      cSt.setString(8, u.getTelefono());
      cSt.setInt(9, u.getSexo());
      cSt.setString(10, u.getUsuario());
      cSt.setString(11, u.getContraseña());
      cSt.setBytes(12, u.getFotoPerfil());
      cSt.setString(13, u.getDNI());
        
        rs=cSt.executeQuery();  
        Cerrar();
       
        return true;
     
            
    }catch(SQLException e){
        System.out.println("Usuario: Error de Modificado: "+ e);
    }
    return false;
    }
    
    
    public boolean Eliminar(Usuario u){
    try{
        return super.Eliminar("call dUsuarios(?);",u.getDNI());
    
    }catch(SQLException e){
        System.out.println("Usuario: Error de Eliminado: "+ e);
    }
    return false;
    }
    
    public ArrayList cboSexo(){ 
    return super.cbo("call cboSexo();");
    }
    
    public boolean Logger(Usuario u){
       try{
    cSt=conexion().prepareCall("call LoginUser(?,?);");
        cSt.setString(1,u.getUsuario());
        cSt.setString(2, u.getContraseña());
    
    rs=cSt.executeQuery();
        
    if(rs.next()){
          Cerrar();
          return true;
    }
    
       }catch(SQLException e){
    
    }
     
        return false;
    }

    
}
