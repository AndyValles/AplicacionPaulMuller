/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidad.Pais;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andyv
 */
public class DPais extends DComponets{
     private  String[] datos=new String[]{"Cod","Est","Nom"};

    public DPais() {
    }
     
     public DefaultTableModel Leer(){
      
        try{
           super.Leer("call mPais();");
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
        System.out.println("Pais: Error de lectura: "+ e);}
    return dt;
    }
     
     public DefaultTableModel Buscar(Pais p,String txt,int i){
         
        try{
           super.Buscar("call b"+datos[i-1]+"Pais(?);");
            switch (i) {
                case 1:
                    cSt.setInt(1, p.getCodigo());
                    break;
                case 2:
                    cSt.setBoolean(1, p.isEstado());
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
        System.out.println("Pais: Error de Buscado: "+ e);}
    return dt;
    }
    
    public boolean Insertar(Pais p){
    try{
     super.Insertar("call iPais(?,?);");
        cSt.setString(1, p.getNombre());
        cSt.setBoolean(2, p.isEstado());
      rs=cSt.executeQuery();
     
    
       Cerrar();
        return true;
     
    }catch(Exception e){
        System.out.println("Pais: Error de Insertado: "+ e);
    }
    return false;
    }
    

    public boolean Actualizar(Pais p){
    try{
     super.Actualizar("call uPais(?,?,?);");
        cSt.setString(1, p.getNombre());
        cSt.setBoolean(2, p.isEstado());
        cSt.setInt(3, p.getCodigo());
      rs=cSt.executeQuery();
     
        Cerrar();
       
        return true;
     
            
    }catch(Exception e){
        System.out.println("Pais: Error de Modificado: "+ e);
    }
    return false;
    }
    
    
    public boolean Eliminar(Pais p){
    try{
        return super.Eliminar("call dPais(?);", p.getCodigo()); 
    }catch(Exception e){
        System.out.println("Pais: Error de Eliminado: "+ e);
    }
    return false;
    }
    
    public ArrayList cboPais(){
    return super.cbo("call cboPais();");
    }
}
