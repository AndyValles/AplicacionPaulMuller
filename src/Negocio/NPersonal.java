/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DPersonal;
import Entidad.Personal;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andyv
 */
public class NPersonal {
     private DPersonal pp=new DPersonal();

    public NPersonal(Object ...titles) {
        pp.setTitle(titles);
    }

    public NPersonal() {
    }
        
    public DefaultTableModel Leer(){
        return pp.Leer();
    }
     
     public DefaultTableModel Buscar(Personal p,int personal){
        return pp.Buscar(p,"", personal);
    }
    
     public DefaultTableModel Buscar(String txt,int search){
        return pp.Buscar(null, txt, search);
    }
    
    public boolean BuscarBool(Personal p,int personal){
        return pp.Buscar(p,"", personal).getRowCount()!=0;
    }
     
     public boolean BuscarBool(String txt,int search){
        return pp.Buscar(null,txt, search).getRowCount()!=0;
    }
    
     
    public boolean Insertar(Personal p){
     return pp.Insertar(p);
    }
    

    public boolean Actualizar(Personal p){
        return pp.Actualizar(p);
    }
    
    
    public boolean Eliminar(Personal p){
        return pp.Eliminar(p);
    }
    
    public ArrayList<Object[]> Lectura() {
        return pp.getBusqueda();
    }
    
    public int SEARCH_DNI=2;
    public int SEARCH_NAME=3;
    public int SEARCH_APE=4;
    public int SEARCH_DIR=5;
    public int SEARCH_CORREO=6;
    public int SEARCH_PHONE=7;
    
    public int PERSONAL_DNI=1;
    public int PERSONAL_CARGO=8;
    
    public int USER_DIS=9;
    public int USER_SEXO=10;
}
