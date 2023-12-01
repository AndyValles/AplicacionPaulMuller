/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidad.Libro;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andyv
 */
public class DLibro extends DComponets{
      private final  String[] datos=new String[]{"Cod1","Cod2","Tit","FecP","FecS","Ed","Edi","Aut","Est"};
      private String data="";
    
      public DLibro() {
        
     }
      
    public DefaultTableModel Leer(boolean Fec){
        dato=1;
        if(Fec){data="FecS";}
        
        try{
           super.Leer("call m"+data+"Libro();");
      
                while(rs.next()){
                    Object[] items=new Object[11];
                    if(!Fec){o=Data(new ImageIcon(ImageIO.read(rs.getBinaryStream(2))));
                    }else{o=rs.getString(2);}
                    
                   items[0]=rs.getString(1);
                   items[1]=o;
                   items[2]=rs.getString(3);
                   items[3]=rs.getString(4);
                   items[4]=rs.getString(5);
                   items[5]=rs.getString(6);
                   items[6]=rs.getString(7);
                   items[7]=rs.getString(8);
                   items[8]=rs.getString(9);
                   
                   if(!Fec){items[9]=modi;
                            items[10]=Eli;}
                   dato++;
                   cantidad++;
                   dt.addRow(items);
                }
                
                Cerrar();
                
        }catch(Exception e){
        System.out.println("Libro: Error de lectura: "+ e);}
    return dt;
    }
   
     public DefaultTableModel Buscar(Libro l,String txt,int i){
         
        try{
          super.Buscar("call b"+datos[i-1]+"Libro(?);");
                
           if(i==1){o=l.getCodigo();}
           else if(i==9){o=l.isEstado();}
           else{o=txt;}
            
            cSt.setObject(1, o);
            rs=cSt.executeQuery();
                while(rs.next()){
                   Object[] items=new Object[100];
                   items[0]=rs.getString(1);
                   items[1]=Data(new ImageIcon(ImageIO.read(rs.getBinaryStream(2))));
                   items[2]=rs.getString(3);
                   items[3]=rs.getString(4);
                   items[4]=rs.getString(5);
                   items[5]=rs.getString(6);
                   items[6]=rs.getString(7);
                   items[7]=rs.getString(8);
                   items[8]=rs.getString(9);
                   items[9]=modi;
                   items[10]=Eli;
                   busqueda.add(items);
                   dt.addRow(items);
                }
                
                Cerrar();
        
        }catch(Exception e){
        System.out.println("Libro: Error de Buscado: "+ e);}
    return dt;
    }
    
    public boolean Insertar(Libro l){
    try{
     super.Insertar("call iLibro(?,?,?,?,?,?,?,?,?,?);");
        cSt.setString(1, l.getCodigo());
        cSt.setBytes(2, l.getPortada());
        cSt.setString(3, l.getTitulo());
        cSt.setInt(4, l.getAutor());
        cSt.setString(5, l.getFPublicacion());
        cSt.setString(6, l.getFSubida());
        cSt.setInt(7, l.getCategoria());
        cSt.setInt(8, l.getEditorial());
        cSt.setString(9, l.getEdicion());
        cSt.setBoolean(10, l.isEstado());
       
      rs=cSt.executeQuery();
     
    
       Cerrar();
        return true;
     
    }catch(Exception e){
        System.out.println("Libro: Error de Insertado: "+ e);
    }
    return false;
    }
    

    public boolean Actualizar(Libro l){
    try{
     super.Actualizar("call uLibro(?,?,?,?,?,?,?,?,?,?);");
        cSt.setBytes(1, l.getPortada());
        cSt.setString(2, l.getTitulo());
        cSt.setInt(3, l.getAutor());
        cSt.setString(4, l.getFPublicacion());
         cSt.setString(5, l.getFSubida());
        cSt.setInt(6, l.getCategoria());
        cSt.setInt(7, l.getEditorial());
        cSt.setString(8, l.getEdicion());
        cSt.setBoolean(9, l.isEstado());
        cSt.setString(10, l.getCodigo());
      rs=cSt.executeQuery();
     
       Cerrar();
        return true;
     
            
    }catch(Exception e){
        System.out.println("Libro: Error de Modificado: "+ e);
    }
    return false;
    }
    
    
    public boolean Eliminar(Libro l){
    try{
     return super.Eliminar("call dLibro(?);",l.getCodigo());
    }catch(Exception e){
        System.out.println("Libro: Error de Eliminado: "+ e);
    }
    return false;
    }
    
    public ArrayList cboLibro(){ 
    return super.cbo("call cboLibro();");
    }

}
