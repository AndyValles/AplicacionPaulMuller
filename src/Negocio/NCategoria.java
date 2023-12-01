/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DCategoria;
import Entidad.Categoria;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andyv
 */
public class NCategoria {
     private DCategoria cc=new DCategoria();

    public NCategoria(String ...titles) {
        cc.setTitle(titles);
    }

    public NCategoria() {
    }
    
    public DefaultTableModel Leer(){
        return cc.Leer();
    }
     
    public DefaultTableModel BuscarCod(Categoria c){
        return cc.Buscar(c, "", 1);
    }
     
     public DefaultTableModel BuscarEst(Categoria c){
        return cc.Buscar(c, "", 2);
    }
     
     public DefaultTableModel BuscarNom(String txt){
       return cc.Buscar(null, txt, 3);
    }
     
      public boolean BuscarCodBool(Categoria c){
        return cc.Buscar(c, "", 1).getRowCount()>0;
    }
     
     public boolean BuscarEstBool(Categoria c){
        return cc.Buscar(c, "", 2).getRowCount()>0;
    }
     
     public boolean BuscarNomBool(String txt){
       return cc.Buscar(null, txt, 3).getRowCount()>0;
    }
    
    public boolean Insertar(Categoria c){
        return cc.Insertar(c);
    }
    

    public boolean Actualizar(Categoria c){
        return cc.Actualizar(c);
    }
    
    public boolean Eliminar(Categoria c){
        return cc.Eliminar(c);
    }
    
    public ArrayList cboCategoria(){
        return cc.cboCategoria();
    }
    
    public ArrayList<Object[]> Lectura() {
        return cc.getBusqueda();
    }
    
     public int Cantidad(){
        cc.Leer();
    return cc.getCantidad();
    }
}
