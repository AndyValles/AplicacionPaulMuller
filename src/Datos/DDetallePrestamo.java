/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidad.DetallePrestamo;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andyv
 */
public class DDetallePrestamo extends DComponets {
    private final String[] datos=new String[]{"DNI","Cod","FecP","FecD"};
    private PreparedStatement ps=null;
    public DDetallePrestamo() {
    }
    
    public DefaultTableModel Leer(){
     
        try{
           super.Leer("call mDetallePrestamo();");
                while(rs.next()){
                   String[] items=new String[13];
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
                   
                   cantidad++;
                   dato++;
                   dt.addRow(items);
                }
               Cerrar();
                
        }catch(Exception e){
        System.out.println("DetallePrestamo: Error de lectura: "+ e);}
    return dt;
    }
     
    public DefaultTableModel Buscar(DetallePrestamo d,String txt,int i){
        try{
          super.Buscar("call b"+datos[i-1]+"DetallePrestamo(?);");
            
            if(i==1){o=d.getPrestamo();}
            else{o=txt;}
            
            cSt.setObject(1, o);
            rs=cSt.executeQuery();
                while(rs.next()){
                   Object[] items=new Object[13];
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
                   dt.addRow(items);
                   busqueda.add(items);
                }
                
                Cerrar();
        }catch(Exception ex){
        System.out.println("DetallePrestamo: Error de Buscado: "+ ex);}
    return dt;
    }
    
    public DefaultTableModel BuscarLibro(DetallePrestamo d){
     try{
        super.Buscar("call bLibroDetallePrestamo(?,?,?);");
            cSt.setString(1, d.getPrestamo());
            cSt.setString(2, d.getLibro());
            cSt.setInt(3, d.getCanLibros());
            rs=cSt.executeQuery();
                while(rs.next()){
                   Object[] items=new Object[13];
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
                   dt.addRow(items);
                   busqueda.add(items);
                }
                Cerrar();
     }catch(Exception e){}
    return dt;
    }
    
    public boolean Insertar(DetallePrestamo d){
    try{
    super.Insertar("call iDetallePrestamo(?,?,?);");
        cSt.setString(1, d.getPrestamo());
        cSt.setString(2, d.getLibro());
        cSt.setInt(3, d.getCanLibros());
        
        
      rs=cSt.executeQuery();
     
    
       Cerrar();
        return true;
     
    }catch(Exception e){
        System.out.println("DetallePrestamo: Error de Insertado: "+ e);
    }
    return false;
    }
    

    public boolean Actualizar(DetallePrestamo d){
    try{
    super.Actualizar("call uDetallePrestamo(?,?,?);");
       cSt.setString(1, d.getLibro());
        cSt.setInt(2, d.getCanLibros());
        cSt.setString(3, d.getPrestamo());
    rs=cSt.executeQuery();
        Cerrar();
        return true;
     
            
    }catch(Exception e){
        System.out.println("DetallePrestamo: Error de Modificado: "+ e);
    }
    return false;
    }
    
    public boolean Eliminar(DetallePrestamo d){
    try{
    return super.Eliminar("call dDetallePrestamo(?);", d.getPrestamo());
     
    }catch(Exception e){
        System.out.println("DetallePrestamo: Error de Eliminado: "+ e);
    }
    return false;
    }
    
    public boolean EliminarLibro(DetallePrestamo d){
    try{
       PreparedStatement ps1=conexion().prepareStatement("Set SQL_SAFE_UPDATES=0;");
       PreparedStatement ps2=conexion().prepareStatement("Set SQL_SAFE_UPDATES=1;");

           cSt=conexion().prepareCall("call dLibDetallePrestamo(?,?,?)");
           cSt.setString(1, d.getPrestamo());
           cSt.setString(2, d.getLibro());
           cSt.setInt(3, d.getCanLibros());
       
       ps1.execute();
       rs=cSt.executeQuery();
       ps2.execute();
        
          Cerrar();
        return true;
    }catch(Exception e){
        System.out.println("DetallePrestamo: Error de Eliminado por Libro: "+ e);
    }
    return false;
    }
}
