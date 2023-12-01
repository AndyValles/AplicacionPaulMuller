/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidad.Configuracion;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andyv
 */
public class DConfiguracion {
    private final Coneccion cc=new Coneccion();
    private String[] title;

    public DConfiguracion() {
    }
    
    public DefaultTableModel Leer(){
        DefaultTableModel dt=new DefaultTableModel();
        dt.setColumnIdentifiers(title);
        try{
            String[] items=new String[100];
            CallableStatement cSt= cc.conexion().prepareCall("call mConfiguracion();");
            ResultSet rs=cSt.executeQuery();
                while(rs.next()){
                   items[0]=rs.getString(1);
                   items[1]=rs.getString(2);
                   items[2]=rs.getString(3);
                   dt.addRow(items);
                }
        }catch(Exception e){
        System.out.println("Error de lectura: "+ e);}
    return dt;
    }
     
     public DefaultTableModel Buscar(Configuracion c){
         DefaultTableModel dt=new DefaultTableModel();
         dt.setColumnIdentifiers(title);
        try{
            String[] items=new String[100];
            CallableStatement cSt= cc.conexion().prepareCall("call bConfiguracion(?);");
            cSt.setInt(1, c.getCodigo());
            ResultSet rs=cSt.executeQuery();
                while(rs.next()){
                   items[0]=rs.getString(1);
                   items[1]=rs.getString(2);
                   items[2]=rs.getString(3);
                   
                   dt.addRow(items);
                }
        }catch(Exception e){
        System.out.println("Error de Buscado: "+ e);}
    return dt;
    }
    
    public boolean Insertar(Configuracion c){
    try{
     CallableStatement cSt= cc.conexion().prepareCall("call iConfiguracion(?,?);");
        cSt.setInt(1, c.getMaxDias());
        cSt.setInt(2, c.getMaxLibros());
     ResultSet rs=cSt.executeQuery();
     
    
        cSt.close();
        cc.conexion().close();
        rs.close();
        return true;
     
    }catch(Exception e){
        System.out.println("Error de Insertado: "+ e);
    }
    return false;
    }
    

    public boolean Actualizar(Configuracion c){
    try{
     CallableStatement cSt= cc.conexion().prepareCall("call uConfiguracion(?,?,?);");
        cSt.setInt(1, c.getMaxDias());
        cSt.setInt(2, c.getMaxLibros());
        cSt.setInt(3, c.getCodigo());
    
        cSt.close();
        cc.conexion().close();
       
        return true;
     
            
    }catch(Exception e){
        System.out.println("Error de Modificado: "+ e);
    }
    return false;
    }
    
    
    public boolean Eliminar(Configuracion c){
    try{
     CallableStatement cSt= cc.conexion().prepareCall("call dConfiguracion(?);");
     cSt.setInt(1, c.getCodigo());
     ResultSet rs=cSt.executeQuery();
      
        cSt.close();
        cc.conexion().close();
        rs.close();
        return true;
     
    }catch(Exception e){
        System.out.println("Error de Eliminado: "+ e);
    }
    return false;
    }

    public String[] getTitle() {
        return title;
    }

    public void setTitle(String[] title) {
        this.title = title;
    }
}
