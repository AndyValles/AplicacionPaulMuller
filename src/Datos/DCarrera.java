
package Datos;

import Entidad.Carrera;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class DCarrera extends DComponets{
    private final String[] datos=new String[]{"Cod","Est","Nom"};

    public DCarrera() {
    }
    
    public DefaultTableModel Leer(){
     
        try{
           super.Leer("call mCarrera();");
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
        System.out.println("Carrera: Error de lectura: "+ e);}
    return dt;
    }
     
     public DefaultTableModel Buscar(Carrera c,String txt,int i){
       
        try{
            super.Buscar("call b"+datos[i-1]+"Carrera(?);");
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
                   items[2]=checkBox(rs.getBoolean(3));
                   items[3]=modi;
                   items[4]=Eli;
                   busqueda.add(items);
                   dt.addRow(items);
                }
              Cerrar();
        }catch(Exception e){
        System.out.println("Carrera: Error de Buscado: "+ e);}
    return dt;
    }
    
    public boolean Insertar(Carrera c){
    try{
     super.Insertar("call iCarrera(?,?);");
        cSt.setString(1, c.getNombre());
        cSt.setBoolean(2, c.isEstado());
     rs=cSt.executeQuery();
     
    
      Cerrar();
        return true;
     
    }catch(Exception e){
        System.out.println("Carrera: Error de Insertado: "+ e);
    }
    return false;
    }
    

    public boolean Actualizar(Carrera c){
    try{
    super.Actualizar("call uCarrera(?,?,?);");
        cSt.setString(1, c.getNombre());
        cSt.setBoolean(2, c.isEstado());
        cSt.setInt(3, c.getCodigo());
    rs=cSt.executeQuery();
        
        Cerrar();
        return true;
     
            
    }catch(Exception e){
        System.out.println("Carrera: Error de Modificado: "+ e);
    }
    return false;
    }
    
    
    public boolean Eliminar(Carrera c){
    try{
        return super.Eliminar("call dCarrera(?);", c.getCodigo());
     
    }catch(Exception e){
        System.out.println("Carrera: Error de Eliminado: "+ e);
    }
    return false;
    }
    
    public ArrayList cboCarrera(){
        return super.cbo("call cboCarrera();");
    }
}
