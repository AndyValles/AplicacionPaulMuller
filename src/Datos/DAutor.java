package Datos;

import Entidad.Autor;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andyv
 */
public class DAutor extends DComponets{
      private final String[] datos=new String[]{"Cod","Pais","Nom","Ape"};

    public DAutor() {
    }
    
    
    
    public DefaultTableModel Leer(){
       
        try{
          super.Leer("call mAutor();");
                while(rs.next()){
                   Object[] items=new Object[7];
                   items[0]=rs.getString(1);
                   items[1]=rs.getString(2);
                   items[2]=rs.getString(3);
                   items[3]=rs.getString(4);
                   items[4]=rs.getString(5);
                   items[5]=modi;
                   items[6]=Eli;

                   dt.addRow(items);
                }
               Cerrar();
        }catch(Exception e){
        System.out.println("Actor: Error de lectura: "+ e);}
    return dt;
    }
     
     public DefaultTableModel Buscar(Autor a,String txt,int i){
       
        try{
            super.Buscar("call b"+datos[i-1]+"Autor(?);");
            
            if(i== 1){o=a.getCodigo();}
            else{o =txt;}
             
            cSt.setObject(1,o);
        
            rs=cSt.executeQuery();
                while(rs.next()){
                   Object[] items=new Object[7];
                   items[0]=rs.getString(1);
                   items[1]=rs.getString(2);
                   items[2]=rs.getString(3);
                   items[3]=rs.getString(4);
                   items[4]=rs.getString(5);
                   items[5]=modi;
                   items[6]=Eli;
                   busqueda.add(items);
                   dt.addRow(items);
                }
                
                Cerrar();
        }catch(Exception ex){
        System.out.println("Actor: Error de Buscado: "+ ex);}
    return dt;
    }
    
    public boolean Insertar(Autor a){
    try{
    super.Insertar("call iAutor(?,?,?,?);");
        cSt.setString(1, a.getNombre());   
        cSt.setString(2, a.getApePA());
        cSt.setString(3, a.getApeMA());
        cSt.setInt(4, a.getPais());
      rs=cSt.executeQuery();
     
    
        Cerrar();
        return true;
     
    }catch(Exception ex){
        System.out.println("Actor: Error de Insertado: "+ ex);
    }
    return false;
    }
    

    public boolean Actualizar(Autor a){
    try{
     super.Actualizar("call uAutor(?,?,?,?,?);");
        cSt.setString(1, a.getNombre());   
        cSt.setString(2, a.getApePA());
        cSt.setString(3, a.getApeMA());
        cSt.setInt(4, a.getPais());
        cSt.setInt(5, a.getCodigo());
     rs=cSt.executeQuery();
       Cerrar();
        return true;
     
            
    }catch(Exception ex){
        System.out.println("Actor: Error de Modificado: "+ ex);
    }
    return false;
    }
    
    
    public boolean Eliminar(Autor a){
    try{
       return super.Eliminar("call dAutor(?);", a.getCodigo());
    }catch(Exception ex){
        System.out.println("Actor: Error de Eliminado: "+ ex);
    }
    return false;
    }
    
    
    public ArrayList cboAutor(){
        return super.cbo("call cboAutor();");
    }

}
