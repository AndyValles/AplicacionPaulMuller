/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidad.DetalleDevolucion;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andyv
 */
public class DDetalleDevolucion extends DComponets{
    
    private final String[] datos=new String[]{"Cod1","Cod2","DNI"};
     
    public DDetalleDevolucion() {
    }
    
    public DefaultTableModel Leer(){
       
     
        try{
          super.Leer("call mDetalleDevolucion();");
                while(rs.next()){                  
                   String[] items=new String[14];
                   items[0]=rs.getString(1);
                   items[1]=rs.getString(2);
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
        }catch(Exception e){
        System.out.println("Devolucion: Error de lectura: "+ e);}
    return dt;
    }
     
     public DefaultTableModel Buscar(DetalleDevolucion d,String txt,int i){
        
        try{
            super.Buscar("call bCod"+datos[i-1]+"DetalleDevolucion(?);");
            if(i==1){o=d.getDevolucion();}
            else{o=txt;}
            
            cSt.setObject(1, o);
            
            ResultSet rs=cSt.executeQuery();
                while(rs.next()){
                   String[] items=new String[14];
                   items[0]=rs.getString(1);
                   items[1]=rs.getString(2);
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
        }catch(Exception ex){
        System.out.println("Devolucion: Error de Buscado: "+ ex);}
    return dt;
    }
    
    public boolean Insertar(DetalleDevolucion d){
    try{
     super.Insertar("call iDetalleDevolucion(?,?,?);");
        cSt.setString(1, d.getDevolucion());
        cSt.setString(2, d.getLibro());
        cSt.setInt(3, d.getCantLibro());
      
        
     rs=cSt.executeQuery();
     
    
       Cerrar();
        return true;
     
    }catch(Exception e){
        System.out.println("Devolucion: Error de Insertado: "+ e);
    }
    return false;
    }
    

    public boolean Actualizar(DetalleDevolucion d){
    try{
     super.Actualizar("call uDetalleDevolucion(?,?,?,?);");
         cSt.setString(1, d.getDevolucion());
        cSt.setString(2, d.getLibro());
        cSt.setInt(3, d.getCantLibro());
    
       rs=cSt.executeQuery();
       Cerrar();
        return true;
     
            
    }catch(Exception e){
        System.out.println("Devolucion: Error de Modificado: "+ e);
    }
    return false;
    }
    
    public boolean Eliminar(DetalleDevolucion d){
    try{
     return super.Eliminar("call dDetalleDevolucion(?);", d.getDevolucion());
     
    }catch(Exception e){
        System.out.println("Devolucion: Error de Eliminado: "+ e);
    }
    return false;
    }
}
