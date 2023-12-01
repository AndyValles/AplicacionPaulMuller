/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DDevolucion;
import Entidad.Devolucion;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andyv
 */
public class NDevolucion {
    private DDevolucion dd =new DDevolucion();   
    
      public NDevolucion() {
      }
      
      public NDevolucion(String ...title) {
          dd.setTitle(title);
      }
    
     public DefaultTableModel Leer(){
            return dd.Leer();
    }  
     
    public DefaultTableModel Buscar_Estudiante(Devolucion d){
        return dd.Buscar(d, "", 1);
    }
    
    public DefaultTableModel Buscar_Egresado(String txt,int i){
        return dd.Buscar(null,txt, i);
    }
    
    public boolean Insertar(Devolucion d){
        return dd.Insertar(d);
    }
    

    public boolean Actualizar(Devolucion d){
        return dd.Actualizar(d);
    }
    
    
    public boolean Eliminar(Devolucion d){
        return dd.Eliminar(d);
    }
    
    public int CantidadTotal(){
        dd.Leer();
        return dd.getCantidad();
    }
    
    public int Dato(){
        dd.Leer();
        return dd.getDato();
    }
    
    public int SEARCH_CODE=2;
    public int SEARCH_DNI=3;
}
