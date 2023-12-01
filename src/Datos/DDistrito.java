/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidad.Distrito;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andyv
 */
public class DDistrito extends DComponets{
     private final String[] datos=new String[]{"Cod","Est","Nom"};
    public DDistrito() {
    }
    
     
    public DefaultTableModel Leer(){
       
        try{
           super.Leer("call mDistrito();");
                while(rs.next()){
                   Object[] items=new Object[5];
                   items[0]=rs.getString(1);
                   items[1]=rs.getString(2);
                   items[2]=checkBox(rs.getBoolean(3));
                   items[3]=modi;
                   items[4]=Eli;
                   dt.addRow(items);
                }
              Cerrar();
        }catch(Exception e){
        System.out.println("Distrito: Error de lectura: "+ e);}
    return dt;
    }
     
    
    public DefaultTableModel Buscar(Distrito d,String txt,int i){
           try{
            super.Buscar("call b"+datos[i-1]+"Distrito(?);");
            switch (i) {
                case 1:
                    cSt.setInt(1, d.getCodigo());
                    break;
                case 2:
                    cSt.setBoolean(1, d.isEstado());
                    break;
                case 3:
                    cSt.setString(1, txt);
                    break;
            }
            
            rs=cSt.executeQuery();
                while(rs.next()){
                   Object[] items=new Object[5];
                   items[0]=rs.getString(1);
                   items[1]=rs.getString(2);
                   items[2]=checkBox(rs.getBoolean(3));
                   items[3]=modi;
                   items[4]=Eli;
                   busqueda.add(items);
                   dt.addRow(items);
                }
                
               Cerrar();
           }catch(Exception e){
                System.out.println("Distrito: Error de Buscado: "+ e);
           }
         return dt;
    }
      
    
    public boolean Insertar(Distrito d){
    try{
     super.Insertar("call iDistrito(?,?);");
        cSt.setString(1, d.getNombre());
        cSt.setBoolean(2, d.isEstado());
     rs=cSt.executeQuery();
     
    
        Cerrar();
        return true;
     
    }catch(Exception e){
        System.out.println("Distrito: Error de Insertado: "+ e);
    }
    return false;
    }
    

    public boolean Actualizar(Distrito d){
    try{
    super.Actualizar("call uDistrito(?,?,?);");
      cSt.setString(1, d.getNombre());
      cSt.setBoolean(2, d.isEstado());
      cSt.setInt(3, d.getCodigo());
    rs=cSt.executeQuery();
    
       Cerrar();
       
        return true;
     
            
    }catch(Exception e){
        System.out.println("Distrito: Error de Modificado: "+ e);
    }
    return false;
    }
    
    
    public boolean Eliminar(Distrito d){
    try{
    return super.Eliminar("call dDistrito(?);", d.getCodigo());
     
    }catch(Exception e){
        System.out.println("Distrito: Error de Eliminado: "+ e);
    }
    return false;
    }
    
    public ArrayList cboDistrito(){
        return super.cbo("call cboDistrito();");
    }
}
