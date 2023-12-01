
package Negocio;

import Datos.DCargo;
import Entidad.Cargo;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class NCargo {
    private DCargo cc=new DCargo();
    
    public NCargo(String ...title){
        cc.setTitle(title);
    }
    
     public DefaultTableModel Leer(){
        return cc.Leer();
    }
     
     public DefaultTableModel BuscarCod(Cargo c){
        return cc.Buscar(c,"",1);
    }
     
     public DefaultTableModel BuscarEst(Cargo c){
        return cc.Buscar(c,"",2);
    }
    
     public DefaultTableModel BuscarNom(String txt){
        return cc.Buscar(null,txt,3);
    }
     
      public boolean buscarCod(Cargo c){
        return cc.Buscar(c,"",1).getRowCount()!=0;
    }
     
     public boolean buscarEst(Cargo c){
        return cc.Buscar(c,"",2).getRowCount()!=0;
    }
    
     public boolean buscarNom(String txt){
        return cc.Buscar(null,txt,3).getRowCount()!=0;
    }
    
    public boolean Insertar(Cargo c){
        return cc.Insertar(c);
    }
    

    public boolean Actualizar(Cargo c){
        return cc.Actualizar(c);
    }
    
    
    public boolean Eliminar(Cargo c){
    return cc.Eliminar(c);
    }
    
    public ArrayList<Object[]> Lectura() {
        return cc.getBusqueda();
    }
    
    public ArrayList cboCargo(){
    return cc.cboCargo();
    }
}
