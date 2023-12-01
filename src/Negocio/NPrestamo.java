/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DPrestamo;
import Entidad.Prestamo;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andyv
 */
public class NPrestamo {
    private DPrestamo pp=new DPrestamo();
    
      public NPrestamo() {
      }
      
      public NPrestamo(String ...titles) {
          pp.setTitle(titles);
      }
    
    public  DefaultTableModel Leer(){
        return pp.Leer();
    }
      
     public DefaultTableModel Buscar(Prestamo p){
        return pp.Buscar(p, "", 1);
    }
     
     public DefaultTableModel Buscar(String txt,int i){
        return pp.Buscar(null, txt, i);
    }
    
    public boolean Insertar(Prestamo p){
        return pp.Insertar(p);
    }
    
     public boolean BuscarBool(Prestamo p){
        return pp.Buscar(p, "", 1).getRowCount()>0;
    }
     
     public boolean BuscarBool(String txt,int i){
        return pp.Buscar(null, txt, i).getRowCount()>0;
    }

    public boolean Actualizar(Prestamo p){
        return pp.Actualizar(p);
    }
    
    
    public boolean Eliminar(Prestamo p){
        return pp.Eliminar(p);
    }
    
    public int CantidadTotal(){
        pp.Leer();
        return pp.getCantidad();
    }
    
    public int CantidadDato(){
        pp.Leer();
        return pp.getDato();
    }
    
    
    public int SEARCH_CODE=2;
    public int SEARCH_DNI=3;
}
