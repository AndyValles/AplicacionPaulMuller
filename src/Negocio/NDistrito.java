
package Negocio;

import Datos.DDistrito;
import Entidad.Distrito;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class NDistrito {
    
    private DDistrito dd=new DDistrito();

    public NDistrito() {
    }
    
    public NDistrito(String ...titles){
        dd.setTitle(titles);
    }
    
     public DefaultTableModel Leer(){
        return dd.Leer();
    }
     
    
    public DefaultTableModel BuscarCod(Distrito d){
         return dd.Buscar(d,"", 1);
    }
    
    public DefaultTableModel BuscarEst(Distrito d){
         return dd.Buscar(d,"", 2);
    }
    
    public DefaultTableModel BuscarNomb(String txt){
         return dd.Buscar(null, txt, 3);
    }
    
    public boolean Insertar(Distrito d){
        return dd.Insertar(d);
    }
    

    public boolean Actualizar(Distrito d){
     return dd.Actualizar(d);
    }
    
    
    public boolean Eliminar(Distrito d){
        return dd.Eliminar(d);
    }
    
    public ArrayList<Object[]> Lectura() {
        return dd.getBusqueda();
    }
    
    public ArrayList cboDistrito(){
        return dd.cboDistrito();
    }
    
}
