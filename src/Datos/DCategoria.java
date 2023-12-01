/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidad.Categoria;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class DCategoria extends DComponets{
    private  String[] datos=new String[]{"Cod","Est","Nom"};

    public DCategoria() {
    }
    
    public DefaultTableModel Leer(){
      
        try{
          super.Leer("call mCategoria();");
                while(rs.next()){
                   Object[] items=new Object[5];
                   items[0]=rs.getString(1);
                   items[1]=rs.getString(2);
                   items[2]=rs.getString(3);
                   items[3]=modi;
                   items[4]=Eli;
                   cantidad++;
                   dt.addRow(items);
                }
               Cerrar();
        }catch(Exception e){
        System.out.println("Categoria: Error de lectura: "+ e);}
    return dt;
    }
     
     public DefaultTableModel Buscar(Categoria c,String txt,int i){
        try{
           super.Buscar("call b"+datos[i-1]+"Categoria(?);");
             switch (i) {
                case 1:
                    cSt.setInt(1, c.getCodigo());
                    break;
                case 2:
                    cSt.setBoolean(1, c.isEstado());
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
                   items[2]=rs.getString(3);
                   items[3]=modi;
                   items[4]=Eli;
                   busqueda.add(items);
                   dt.addRow(items);
                }
               Cerrar();
                
        }catch(Exception e){
        System.out.println("Categoria: Error de Buscado: "+ e);}
    return dt;
    }
    
    public boolean Insertar(Categoria c){
    try{
    super.Insertar("call iCategoria(?,?);");
       cSt.setString(1, c.getNombre());
        cSt.setBoolean(2, c.isEstado());
     rs=cSt.executeQuery();
     
    
        Cerrar();
        return true;
     
    }catch(Exception e){
        System.out.println("Categoria: Error de Insertado: "+ e);
    }
    return false;
    }
    

    public boolean Actualizar(Categoria c){
    try{
     super.Actualizar("call uCategoria(?,?,?);");
        cSt.setString(1, c.getNombre());
        cSt.setBoolean(2, c.isEstado());
        cSt.setInt(3, c.getCodigo());
     rs=cSt.executeQuery();
      Cerrar();
        return true;
     
            
    }catch(Exception e){
        System.out.println("Categoria: Error de Modificado: "+ e);
    }
    return false;
    }
    
    
    public boolean Eliminar(Categoria c){
    try{
     return super.Eliminar("call dCategoria(?);", c.getCodigo());   
    }catch(Exception e){
        System.out.println("Categoria: Error de Eliminado: "+ e);
    }
    return false;
    }
    
    public ArrayList cboCategoria(){
    return super.cbo("call cboCategoria();");
    }
}
