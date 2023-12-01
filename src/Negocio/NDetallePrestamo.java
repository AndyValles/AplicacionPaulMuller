/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DDetallePrestamo;
import Entidad.DetallePrestamo;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andyv
 */
public class NDetallePrestamo {
    private DDetallePrestamo dp=new DDetallePrestamo();

    public NDetallePrestamo(String ...titles) {
        dp.setTitle(titles);
    }
    
     public NDetallePrestamo() {
    }
    
    public DefaultTableModel Leer(){
    return dp.Leer();
    }
     
    public DefaultTableModel Buscar(DetallePrestamo d,int i){
    return dp.Buscar(d, "", i);
    }
     
    public DefaultTableModel Buscar (String txt,int i){
     return dp.Buscar(null, txt, i);
    }
    
    public DefaultTableModel BuscarLibro(DetallePrestamo d){
         return dp.BuscarLibro(d);
    }
    
    public boolean BuscarBool(DetallePrestamo d,int i){
    return dp.Buscar(d, "", i).getRowCount()>0;
    }
     
    public boolean BuscarBool (String txt,int i){
     return dp.Buscar(null, txt, i).getRowCount()>0;
    }
    
     public boolean BuscarLibroBool(DetallePrestamo d){
         return dp.BuscarLibro(d).getRowCount()>0;
    }
    
    public boolean Insertar(DetallePrestamo d){
    return dp.Insertar(d);
    }
    

    public boolean Actualizar(DetallePrestamo d){
    return dp.Actualizar(d);
    }
    
    
    public boolean Eliminar(DetallePrestamo d){
       return dp.Eliminar(d);
    }
    
    public boolean EliminarLibro(DetallePrestamo d){
        return dp.EliminarLibro(d);
    }
    
    public ArrayList<Object[]> Lectura(){
        return dp.getBusqueda();
    }
    
    public int SEARCH_DNI=1;
    public int SEARCH_CODE=2;
    public int SEARCH_DATE_PRES=3;
    public int SEARCH_DATE_DEVO=3;

}
