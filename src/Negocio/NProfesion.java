
package Negocio;

import Datos.DProfesion;
import Entidad.Profesion;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andyv
 */
public class NProfesion {
     private DProfesion pp=new DProfesion();

    public NProfesion(String ...titles) {
        pp.setTitle(titles);
    }

    public NProfesion() {
    }
    
    public DefaultTableModel Leer(){
        return pp.Leer();
    }
     
     public DefaultTableModel BuscarCod(Profesion p){
        return pp.Buscar(p, "", 1);
     }
     
     public DefaultTableModel BuscarEst(Profesion p){
        return pp.Buscar(p, "", 2);
     }
     
     public DefaultTableModel BuscarNom(String txt){
        return pp.Buscar(null, txt, 3);
     }
    
    public boolean Insertar(Profesion p){
        return pp.Insertar(p);
    }
    

    public boolean Actualizar(Profesion p){
        return pp.Actualizar(p);
    }
    
    
    public boolean Eliminar(Profesion p){
        return pp.Eliminar(p);
    }
    
    public ArrayList cboProfesion(){
        return pp.cboProfesion();
    }
    
    public ArrayList<Object[]> Lectura() {
        return pp.getBusqueda();
    }
}
