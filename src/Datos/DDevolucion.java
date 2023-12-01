package Datos;

import Entidad.Devolucion;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andyv
 */
public class DDevolucion extends DComponets{
    private final String[] datos=new String[]{"Cod1","Cod2","DNI"};

    public DDevolucion() {
    }
    
    public DefaultTableModel Leer(){
        dato=1;
        
        try{
            super.Leer("call mDevolucion();");
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
                  
                   dato++;
                   cantidad++;
                   dt.addRow(items);
                }
                Cerrar();
        }catch(Exception e){
        System.out.println("Devolucion: Error de lectura: "+ e);}
    return dt;
    }
     
     public DefaultTableModel Buscar(Devolucion d,String txt,int i){
       
        try{
          super.Buscar("call b"+datos[i-1]+"Devolucion(?);");
            if(i==1){o=d.getCodigo();}
            else{o=txt;}
            
            cSt.setObject(1, o);
            
            rs=cSt.executeQuery();
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
                  
                   dt.addRow(items);
                }
                Cerrar();
        }catch(Exception ex){
        System.out.println("Devolucion: Error de Buscado: "+ ex);}
    return dt;
    }
    
    public boolean Insertar(Devolucion d){
    try{
    super.Insertar("call iDevolucion(?,?,?,?);");
        cSt.setString(1, d.getCodigo());
        cSt.setString(2, d.getPrestamo());
        cSt.setString(3, d.getFAcordada());
        cSt.setString(4, d.getFRecibida());
      
        
      rs=cSt.executeQuery();
     
    
        Cerrar();
        return true;
     
    }catch(Exception e){
        System.out.println("Devolucion: Error de Insertado: "+ e);
    }
    return false;
    }
    

    public boolean Actualizar(Devolucion d){
    try{
     super.Actualizar("call uDevolucion(?,?,?,?);");
         cSt.setString(1, d.getPrestamo());
        cSt.setString(2, d.getFAcordada());
        cSt.setString(3, d.getFRecibida());
        cSt.setString(4, d.getCodigo());
    rs=cSt.executeQuery();
       Cerrar();
        return true;
     
            
    }catch(Exception e){
        System.out.println("Devolucion: Error de Modificado: "+ e);
    }
    return false;
    }
    
    
    public boolean Eliminar(Devolucion d){
    try{
    return super.Eliminar("call dDevolucion(?);", d.getCodigo());
     
    }catch(Exception e){
        System.out.println("Devolucion: Error de Eliminado: "+ e);
    }
    return false;
    }
}
