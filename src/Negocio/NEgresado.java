/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DEgresado;
import Entidad.Egresado;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andyv
 */
public class NEgresado {
    private DEgresado ee=new DEgresado();

    public NEgresado(Object ...titles) {
        ee.setTitle(titles);
    }

    public NEgresado() {
    }
        
    public DefaultTableModel Leer(){
        return ee.Leer();
    }
     
     public DefaultTableModel Buscar(Egresado e){
        return ee.Buscar(e,"", 1);
    }
      
    public DefaultTableModel Buscar(String txt,int search){
        return ee.Buscar(null, txt, search);
    }
    
       public boolean BuscarBool(Egresado e,int egresado){
        return ee.Buscar(e,"", egresado).getRowCount()>0;
    }
      
    public boolean BuscarBool(String txt,int search){
        return ee.Buscar(null, txt, search).getRowCount()>0;
    }
    
    public boolean Insertar(Egresado e){
     return ee.Insertar(e);
    }
    

    public boolean Actualizar(Egresado e){
        return ee.Actualizar(e);
    }
    
    
    public boolean Eliminar(Egresado e){
        return ee.Eliminar(e);
    }
    
     public ArrayList<Object[]> Lectura() {
        return ee.getBusqueda();
    }


        
    public int SEARCH_DNI=2;
    public int SEARCH_NAME=3;
    public int SEARCH_APE=4;
    public int SEARCH_DIR=5;
    public int SEARCH_CORREO=6;
    public int SEARCH_PHONE=7;
    public int SEARCH_DATE=8;
    
    public int EGRESADO_DNI=1;
    public int EGRESADO_PROFESION=9;
    
    public int USER_DIS=10;
    public int USER_SEXO=11;
    
}
