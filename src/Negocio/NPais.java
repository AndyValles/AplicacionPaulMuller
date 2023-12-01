
package Negocio;

import Datos.DPais;
import Entidad.Pais;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andyv
 */
public class NPais {
    private DPais pp=new DPais();

    public NPais(String ...titles) {
        pp.setTitle(titles);
    }

    public NPais() {
    }
    
    public DefaultTableModel Leer(){
        return pp.Leer();
    }
     
    public DefaultTableModel BuscarCod(Pais p){
        return pp.Buscar(p, "", 1);
    }
     
     public DefaultTableModel BuscarEst(Pais p){
        return pp.Buscar(p, "", 2);
    }
     
     public DefaultTableModel BuscarNom(String txt){
       return pp.Buscar(null, txt, 3);
    }
     
     public boolean BuscarCodBool(Pais p){
        return pp.Buscar(p, "", 1).getRowCount()>0;
    }
     
     public boolean BuscarEstBool(Pais p){
        return pp.Buscar(p, "", 2).getRowCount()>0;
    }
     
     public boolean BuscarNomBool(String txt){
       return pp.Buscar(null, txt, 3).getRowCount()>0;
    }
    
    public boolean Insertar(Pais p){
        return pp.Insertar(p);
    }
    

    public boolean Actualizar(Pais p){
        return pp.Actualizar(p);
    }
    
    public boolean Eliminar(Pais p){
        return pp.Eliminar(p);
    }
    
    public ArrayList<Object[]> Lectura() {
        return pp.getBusqueda();
    }
    
    public ArrayList cboPais(){
        return pp.cboPais();
    }
}
