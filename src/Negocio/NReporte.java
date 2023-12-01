/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DReportes;
import java.util.HashMap;

/**
 *
 * @author andyv
 */
public class NReporte {
    private DReportes rr=new DReportes();

    public NReporte() {
    }
    
    public boolean Reporte(String titulo,String ruta,HashMap dato){
      return rr.Reporte(titulo, ruta, dato);
    }
}
