/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidad.Egresado;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andyv
 */
public class DEgresado extends DUsuario{
    private final String[] datos=new String[]{"DNI1","DNI2","Nomb","Ape","Dir","Cor","Tel","Fec","Pro","Dis","Sex"};

    public DEgresado() {
    }
    
    
    
    @Override
    public DefaultTableModel Leer(){
        
       
        try{
           super.Leer("call mEgresado();");
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
        System.out.println("Egresado: Error de lectura: "+ e);}
    return dt;
    }
     
     public DefaultTableModel Buscar(Egresado e,String txt,int i){
          
         
        try{
           super.Buscar("call b"+datos[i]+"Egresado(?);");
            
            if(i==1){o=e.getDNI(); 
            }else{o=txt;}
            
            cSt.setObject(1, o);
            rs=cSt.executeQuery();
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
        System.out.println("Egresado: Error de Buscado: "+ ex);}
    return dt;
    }
    
    public boolean Insertar(Egresado e){
    try{
    super.Insertar("call iEgresado(?,?,?);");
        cSt.setString(1, e.getDNI());   
        cSt.setInt(2, e.getProfesion());
        cSt.setString(3, e.getFGraduacion());
        
     rs=cSt.executeQuery();
     
        Cerrar();
        return true;
     
    }catch(Exception ex){
        System.out.println("Egresado: Error de Insertado: "+ ex);
    }
    return false;
    }
    

    public boolean Actualizar(Egresado e){
    try{
    super.Actualizar("call uEgresado(?,?,?);");
        cSt.setInt(1, e.getProfesion());
        cSt.setString(2, e.getFGraduacion());
        cSt.setString(3, e.getDNI());
     rs=cSt.executeQuery();
        
        Cerrar();
       
        return true;
     
            
    }catch(Exception ex){
        System.out.println("Egresado: Error de Modificado: "+ ex);
    }
    return false;
    }
    
    
    public boolean Eliminar(Egresado e){
    try{
        return super.Eliminar("call dEgresado(?);", e.getDNI());
     
    }catch(Exception ex){
        System.out.println("Egresado: Error de Eliminado: "+ ex);
    }
    return false;
    }
}
