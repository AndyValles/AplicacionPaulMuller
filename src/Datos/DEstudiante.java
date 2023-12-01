/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidad.Estudiante;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andyv
 */
public class DEstudiante extends DUsuario{
    private final String[] datos=new String[]{"DNI1","DNI2","Nomb","Ape","Dir","Cor","Tel","Fec","Car","Dis","Sex"};
    
    public DEstudiante() {
       
    }
    
    
    
    @Override
    public DefaultTableModel Leer(){
       
      
        try{
         super.Leer("call mEstudiante();");
                while(rs.next()){
                   Object[] items=new Object[17];
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
                   items[13]=rs.getString(14);
                   items[14]=rs.getString(15);
                   items[15]=modi;
                   items[16]=Eli;
                   dt.addRow(items);
                }
          Cerrar();
        }catch(Exception e){
        System.out.println("Estudiante: Error de lectura: "+ e);}
    return dt;
    }
     
     public DefaultTableModel Buscar(Estudiante e,String txt,int i){
        
      
        try{
           super.Buscar("call b"+datos[i-1]+"Estudiante(?);");
            
            if(i==1){o=e.getDNI();    
            }else{o=txt;}
            
            cSt.setObject(1, o);
            
            ResultSet rs=cSt.executeQuery();
                while(rs.next()){
                  Object[] items=new Object[17];
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
                   items[13]=rs.getString(14);
                   items[14]=rs.getString(15);
                   items[15]=modi;
                   items[16]=Eli;
                   busqueda.add(items);
                   dt.addRow(items);
                }
            Cerrar();
        }catch(Exception ex){
        System.out.println("Estudiante: Error de Buscado: "+ ex);}
    return dt;
    }
    
    public boolean Insertar(Estudiante e){
    try{
     super.Insertar("call iEstudiante(?,?,?);");
        cSt.setString(1, e.getDNI());   
        cSt.setInt(2, e.getCarrera());
        cSt.setString(3, e.getFPostulacion());
        
      rs=cSt.executeQuery();
     
    
        Cerrar();
        return true;
     
    }catch(Exception ex){
        System.out.println("Estudiante: Error de Insertado: "+ ex);
    }
    return false;
    }
    

    public boolean Actualizar(Estudiante e){
    try{
    super.Actualizar("call uEstudiante(?,?,?);");
        cSt.setInt(1, e.getCarrera());
        cSt.setString(2, e.getFPostulacion());
        cSt.setString(3, e.getDNI());
     rs=cSt.executeQuery();
     
       Cerrar();
       
       return true;
     
            
    }catch(Exception ex){
        System.out.println("Estudiante: Error de Modificado: "+ ex);
    }
    return false;
    }
    
    
    public boolean Eliminar(Estudiante e){
    
    try{
        return super.Eliminar("call dEstudiante(?);",e.getDNI());
    }catch(Exception ex){
        System.out.println("Estudiante: Error de Eliminado: "+ ex);
    }
    return false;
    }
    
}
