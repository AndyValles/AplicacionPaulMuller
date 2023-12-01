/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidad.Prestamo;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andyv
 */
public class DPrestamo extends DComponets{
    private final String[] datos=new String[]{"Cod1","Cod2","DNI"};

    public DPrestamo() {
    }
    
    public DefaultTableModel Leer(){
        dato=1;
        try{
           super.Leer("call mPrestamo();");
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
                   
                   cantidad++;
                   dato++;
                   dt.addRow(items);
                }
               Cerrar();
                
        }catch(Exception e){
        System.out.println("Prestamo: Error de lectura: "+ e);}
    return dt;
    }
     
     public DefaultTableModel Buscar(Prestamo p,String txt,int i){
        
        try{
          super.Buscar("call b"+datos[i-1]+"Prestamo(?);");
          
          if(i==1){o=p.getCodigo();}
          else{o=txt;}
            
            cSt.setObject(1, o);
            rs=cSt.executeQuery();
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
                  
                   dt.addRow(items);
                   
                }
                
               Cerrar();
        }catch(Exception ex){
        System.out.println("Prestamo: Error de Buscado: "+ ex);}
    return dt;
    }
    
    public boolean Insertar(Prestamo p){
    try{
     super.Insertar("call iPrestamo(?,?,?,?);");
        cSt.setString(1, p.getCodigo());
        cSt.setString(2, p.getDNI());
        cSt.setString(3, p.getFPrestamo());
        cSt.setString(4, p.getFDevolucion());
        
        
     rs=cSt.executeQuery();
     
    
       Cerrar();
        return true;
     
    }catch(Exception e){
        System.out.println("Prestamo: Error de Insertado: "+ e);
    }
    return false;
    }
    

    public boolean Actualizar(Prestamo p){
    try{
     super.Actualizar("call uPrestamo(?,?,?,?);");
         cSt.setString(1, p.getDNI());
        cSt.setString(2, p.getFPrestamo());
        cSt.setString(3, p.getFDevolucion());
        cSt.setString(4, p.getCodigo());
    rs=cSt.executeQuery();
       
    Cerrar();
    return true;
     
            
    }catch(Exception e){
        System.out.println("Prestamo: Error de Modificado: "+ e);
    }
    return false;
    }
    
    
    public boolean Eliminar(Prestamo p){
    try{
     return super.Eliminar("call dPrestamo(?);",p.getCodigo());  
    }catch(Exception e){
        System.out.println("Prestamo: Error de Eliminado: "+ e);
    }
    return false;
    }
}
