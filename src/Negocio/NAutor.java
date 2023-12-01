/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DAutor;
import Entidad.Autor;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andyv
 */
public class NAutor {
    private DAutor aa=new DAutor();

    public NAutor(String ...titles) {
        aa.setTitle(titles);
    }

    public NAutor() {
    }
    
    
    
    public DefaultTableModel Leer(){
        return aa.Leer();
    }
     
     public DefaultTableModel Buscar(Autor a){
        return aa.Buscar(a, "", 1);
    }
     
      public DefaultTableModel Buscar(String txt,int search){
        return aa.Buscar(null, txt, search);
    }
    
    public boolean Insertar(Autor a){
        return aa.Insertar(a);
    }
    

    public boolean Actualizar(Autor a){
        return aa.Actualizar(a);
    }
    
    
    public boolean Eliminar(Autor a){
        return aa.Eliminar(a);
    }
    
    public ArrayList cboAutor(){
        return aa.cboAutor();
    }
    
    public ArrayList<Object[]> Lectura() {
        return aa.getBusqueda();
    }

    public int Cantidad(){
     aa.Leer();
     return aa.getCantidad();
    }
    public int USER_COD=1;
    public int USER_PAIS=2;
    
    public int SEARCH_NAME=3;
    public int SEARCH_LASTNAME=4;
}
