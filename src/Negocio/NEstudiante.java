/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DEstudiante;
import Entidad.Estudiante;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andyv
 */
public class NEstudiante {
    private DEstudiante ee=new DEstudiante();

    public NEstudiante(Object ...titles) {
        ee.setTitle(titles);
    }

    public NEstudiante() {
    }
        
    public DefaultTableModel Leer(){
        return ee.Leer();
    }
     
     public DefaultTableModel Buscar(Estudiante e,int estudiante){
        return ee.Buscar(e,"", estudiante);
    }
     
     public DefaultTableModel Buscar(String txt,int search){
        return ee.Buscar(null, txt, search);
    }
     
    public boolean BuscarBool(Estudiante e,int estudiante){
        return ee.Buscar(e,"", estudiante).getRowCount()>0;
    }
     
    public boolean BuscarBool(String txt,int search){
        return ee.Buscar(null, txt, search).getRowCount()>0;
    }
     
    
    public boolean Insertar(Estudiante e){
     return ee.Insertar(e);
    }
    

    public boolean Actualizar(Estudiante e){
        return ee.Actualizar(e);
    }
    
    
    public boolean Eliminar(Estudiante e){
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
    
    public int ESTUDIANTE_DNI=1;
    public int ESTUDIANTE_CARRERA=9;
    
    public int USER_DIS=10;
    public int USER_SEXO=11;
    
}
