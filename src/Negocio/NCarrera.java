package Negocio;

import Datos.DCarrera;
import Entidad.Carrera;
import Entidad.Categoria;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class NCarrera {
    private DCarrera cc=new DCarrera();

    public NCarrera(String ...titles) {
        cc.setTitle(titles);
    }

    public NCarrera() {
    }
    
    public DefaultTableModel Leer(){
        return cc.Leer();
    }
     
     public DefaultTableModel BuscarCod(Carrera c){
        return cc.Buscar(c, "", 1);
     }
     
     public DefaultTableModel BuscarEst(Carrera c){
        return cc.Buscar(c, "", 2);
     }
     
     public DefaultTableModel BuscarNom(String txt){
        return cc.Buscar(null, txt, 3);
     }
    
    public boolean Insertar(Carrera c){
        return cc.Insertar(c);
    }
    

    public boolean Actualizar(Carrera c){
        return cc.Actualizar(c);
    }
    
    
    public boolean Eliminar(Carrera c){
        return cc.Eliminar(c);
    }
    
    public ArrayList<Object[]> Lectura() {
        return cc.getBusqueda();
    }
    
    public ArrayList cboCarrera(){
        return cc.cboCarrera();
    }
}
