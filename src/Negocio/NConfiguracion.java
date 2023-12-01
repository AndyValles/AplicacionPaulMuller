/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DConfiguracion;
import Entidad.Configuracion;
import javax.swing.table.DefaultTableModel;


public class NConfiguracion {
        private DConfiguracion cc=new DConfiguracion();
    
        public NConfiguracion() {
        }
        
        public NConfiguracion(String ...titles) {
            cc.setTitle(titles);
        }
    
    public DefaultTableModel Leer(){
        return cc.Leer();
    }
     
     public DefaultTableModel Buscar(Configuracion c){
        return cc.Buscar(c);
     }
    
    public boolean Insertar(Configuracion c){
        return cc.Insertar(c);
    }
    

    public boolean Actualizar(Configuracion c){
        return cc.Actualizar(c);
    }
    
    
    public boolean Eliminar(Configuracion c){
        return cc.Eliminar(c);
    }
}
