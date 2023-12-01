/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DEditorial;
import Entidad.Editorial;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andyv
 */
public class NEditorial {
    private DEditorial ee=new DEditorial();
    
    
    public NEditorial(String ...titles) {
        ee.setTitle(titles);
    }
    
    public NEditorial() {
    }
    
    public DefaultTableModel Leer(){
        return ee.Leer();
    }
     
    public DefaultTableModel Buscar(Editorial e){
        return ee.Buscar(e, "", 1);
    }
    
     public DefaultTableModel Buscar(String txt,int search){
        return ee.Buscar(null, txt, search);
    }
    
    public boolean Insertar(Editorial e){
        return ee.Insertar(e);
    }
    

    public boolean Actualizar(Editorial e){
        return ee.Actualizar(e);
    }
    
    
    public boolean Eliminar(Editorial e){
        return ee.Eliminar(e);
    }
    
    public ArrayList cboEditorial(){
        return ee.cboEditorial();
    }
    
    public ArrayList<Object[]> Lectura() {
        return ee.getBusqueda();
    }
    
    public int Cantidad(){
        ee.Leer();
    return ee.getCantidad();
    }
    
    public int SEARCH_NAME=3;
    public int SEARCH_DIR=4;
    public int SEARCH_PHONE=5;
    public int SEARCH_CORREO=6;
    
    public int EDI_COD=1;
    public int EDI_PAIS=2;
}
