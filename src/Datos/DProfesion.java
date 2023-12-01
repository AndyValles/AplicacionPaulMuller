/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidad.Profesion;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andyv
 */
public class DProfesion extends DComponets{
  public  String[] datos=new String[]{"Cod","Est","Nom"};

    public DProfesion() {
    }
  
  
  public DefaultTableModel Leer(){
        try{
           super.Leer("call mProfesion();");
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
        System.out.println("Profesion: Error de lectura: "+ e);}
    return dt;
    }
     
     public DefaultTableModel Buscar(Profesion p,String txt,int i){
        
        try{
            super.Buscar("call b"+datos[i-1]+"Profesion(?);");
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
        System.out.println("Profesion: Error de Buscado: "+ e);}
    return dt;
    }
    
    public boolean Insertar(Profesion p){
    try{
     super.Insertar("call iProfesion(?,?);");
        cSt.setString(1, p.getNombre());
        cSt.setBoolean(2, p.isEstado());
     rs=cSt.executeQuery();
     
    
       Cerrar();
        return true;
     
    }catch(Exception e){
        System.out.println("Profesion: Error de Insertado: "+ e);
    }
    return false;
    }
    

    public boolean Actualizar(Profesion p){
    try{
     super.Actualizar("call uProfesion(?,?,?);");
        cSt.setString(1, p.getNombre());
        cSt.setBoolean(2, p.isEstado());
        cSt.setInt(3, p.getCodigo());
     rs=cSt.executeQuery();
        Cerrar();
       
        return true;
     
            
    }catch(Exception e){
        System.out.println("Profesion: Error de Modificado: "+ e);
    }
    return false;
    }
    
    
    public boolean Eliminar(Profesion p){
    try{
     return  super.Eliminar("call dProfesion(?);",p.getCodigo());
     
    }catch(Exception e){
        System.out.println("Profesion: Error de Eliminado: "+ e);
    }
    return false;
    }
    
    public ArrayList cboProfesion(){
    return super.cbo("call cboProfesion();");
    }   
}
