/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidad.Editorial;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andyv
 */
public class DEditorial extends DComponets{
    private String[] datos=new String[]{"Cod","Pais","Nom","Dir","Tel","Cor"};

    public DEditorial() {
    }
    
    
    
    public DefaultTableModel Leer(){
        try{
           super.Leer("call mEditorial();");
                while(rs.next()){
                   Object[] items=new Object[8];
                   items[0]=rs.getString(1);
                   items[1]=rs.getString(2);
                   items[2]=rs.getString(3);
                   items[3]=rs.getString(4);
                   items[4]=rs.getString(5);
                   items[5]=rs.getString(6);
                   items[6]=modi;
                   items[7]=Eli;
                   cantidad++;
                   dt.addRow(items);
                }
               Cerrar();
        }catch(Exception e){
        System.out.println("Editorial: Error de lectura: "+ e);}
    return dt;
    }
     
     public DefaultTableModel Buscar(Editorial e,String txt,int i){
        try{
         super.Buscar("call b"+datos[i-1]+"Editorial(?);");
            
            if(i==1){o=e.getCodigo();}
            else{o  = txt;}
             
            cSt.setObject(1, o);
            
             ResultSet rs=cSt.executeQuery();
                while(rs.next()){
                   Object[] items=new Object[8];
                   items[0]=rs.getString(1);
                   items[1]=rs.getString(2);
                   items[2]=rs.getString(3);
                   items[3]=rs.getString(4);
                   items[4]=rs.getString(5);
                   items[5]=rs.getString(6);
                   items[6]=modi;
                   items[7]=Eli;
                   busqueda.add(items);
                   dt.addRow(items);
                }
                Cerrar();
        }catch(Exception ex){
        System.out.println("Editorial: Error de Buscado: "+ ex);}
    return dt;
    }
    
    public boolean Insertar(Editorial e){
    try{
     super.Insertar("call iEditorial(?,?,?,?,?);");
        cSt.setString(1, e.getNombre());   
        cSt.setString(2, e.getDireccion());
        cSt.setString(3, e.getTelefono());
        cSt.setString(4, e.getCorreo());
        cSt.setInt(5, e.getPais());
     rs=cSt.executeQuery();
     
    
       Cerrar();
        return true;
     
    }catch(Exception ex){
        System.out.println("Editorial: Error de Insertado: "+ ex);
    }
    return false;
    }
    

    public boolean Actualizar(Editorial e){
    try{
     super.Actualizar("call uEditorial(?,?,?,?,?,?);");
       cSt.setString(1, e.getNombre());   
        cSt.setString(2, e.getDireccion());
        cSt.setString(3, e.getTelefono());
        cSt.setString(4, e.getCorreo());
        cSt.setInt(5, e.getPais());
        cSt.setInt(6, e.getCodigo());
      rs=cSt.executeQuery();
        
      Cerrar();
        return true;
     
            
    }catch(Exception ex){
        System.out.println("Editorial: Error de Modificado: "+ ex);
    }
    return false;
    }
    
    
    public boolean Eliminar(Editorial e){
    try{
     return super.Eliminar("call dEditorial(?);",e.getCodigo());
     
    }catch(Exception ex){
        System.out.println("Editorial: Error de Eliminado: "+ ex);
    }
    return false;
    }
    
    public ArrayList cboEditorial(){
        return super.cbo("call cboEditorial();");
    }

}
