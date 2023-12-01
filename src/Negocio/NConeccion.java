/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.Coneccion;


public class NConeccion {
    private Coneccion cc=new Coneccion();
    
    public String[] DefaultConection(){
        return new String[]{cc.getDireccion(),cc.getPuerto()};
    }
    
    public void Conectar(String direccion,String puerto,String usuario,String contra){
        cc.setDireccion(direccion);
        cc.setPuerto(puerto);
        cc.setUsuario(usuario);
        cc.setContra(contra);
    }
    
    public boolean isConected(){
        try{
            if(!cc.conexion().isClosed()){return true;}
        }catch(Exception e){}
        return false;
    }
    
}
