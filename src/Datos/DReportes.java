/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.util.HashMap;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author andyv
 */
public class DReportes extends Coneccion{
    
    private Object[] titles;

    public DReportes() {
    }
    
    public boolean Reporte(String titulo,String ruta,HashMap dato){
     try{       
        
        JasperReport reporte=JasperCompileManager.compileReport(ruta);
        JasperPrint mostrar= JasperFillManager.fillReport(reporte,dato,conexion());
       
        JasperViewer ventana=new JasperViewer(mostrar,false);
        ventana.setTitle(titulo);
        ventana.setVisible(true);
        
        return true;
        }catch(Exception e){
        System.out.print(e.getMessage());
        }
     return false;
    }
}
