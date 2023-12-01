/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DDetalleDevolucion;
import Entidad.DetalleDevolucion;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andyv
 */
public class NDetalleDevolucion {

    private DDetalleDevolucion dd=new DDetalleDevolucion();
    
    public NDetalleDevolucion(String ...titles) {
        dd.setTitle(titles);
    }
    
    public NDetalleDevolucion() {
    }
    
    public DefaultTableModel Leer(){
    return dd.Leer();
    }
     
     public DefaultTableModel Buscar(DetalleDevolucion d){
        return dd.Buscar(d, "", DETALLE_CODE);
     }
     
     public DefaultTableModel Buscar(String txt,int i){
     return dd.Buscar(null, txt, i);
    }
     
     public boolean BuscarBool(DetalleDevolucion d){
        return dd.Buscar(d, "", DETALLE_CODE).getRowCount()>0;
     }
     
     public boolean BuscarBool(String txt,int i){
     return dd.Buscar(null, txt, i).getRowCount()>0;
    }
    
    public boolean Insertar(DetalleDevolucion d){
    return dd.Insertar(d);
    }
    

    public boolean Actualizar(DetalleDevolucion d){
    return dd.Actualizar(d);
    }
    
    
    public boolean Eliminar(DetalleDevolucion d){
    return dd.Eliminar(d);
    }
    
    public int DETALLE_CODE=1;
    public int SEARCH_CODE=2;
    public int SEARCH_DNI=3;

}
