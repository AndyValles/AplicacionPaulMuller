/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DLibro;
import Entidad.Libro;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andyv
 */
public class NLibro {
    private DLibro ll=new DLibro();
    
    public NLibro(Object ...title) {
        ll.setTitle(title);
    }
    
    public NLibro() {
    }
    
    
    public DefaultTableModel Leer(){
        return ll.Leer(false);
    }
    
    public DefaultTableModel LeerReciente(){
        return ll.Leer(true);
    }
   
     public DefaultTableModel Buscar(Libro l,int libro){
        return ll.Buscar(l, "", libro);
    }
     
       public DefaultTableModel Buscar(String txt,int search){
        return ll.Buscar(null, txt,search);
    }
    
        public boolean BuscarBool(Libro l,int libro){
        return ll.Buscar(l, "", libro).getColumnCount()>0;
    }
     
       public boolean BuscarBool(String txt,int search){
        return ll.Buscar(null, txt, search).getColumnCount()>0;
    }
    
    public boolean Insertar(Libro l){
        return ll.Insertar(l);
    }
    

    public boolean Actualizar(Libro l){
        return ll.Actualizar(l);
    }
    
    
    public boolean Eliminar(Libro l){
        return ll.Eliminar(l);
    }
    
    public ArrayList cboLibro(){
        return ll.cboLibro();
    }
    
    public ArrayList<Object[]> Lectura() {
        return ll.getBusqueda();
    }
    
    public int cantidad(){
        ll.Leer(false);
        return ll.getCantidad();
    }
    
    public int Dato(){
        ll.Leer(false);
        return ll.getDato();
    }
    
    public int SEARCH_COD=2;
    public int SEARCH_TITLE=3;
    public int SEARCH_FPUB=4;
    public int SEARCH_FSUB=5;
    public int SEARCH_EDI=6;
    
    public int LIBRO_COD=1;
    public int LIBRO_EDITORIAL=7;
    public int LIBRO_AUTOR=8;
   
    public int LIBRO_ESTADO=9;
}
