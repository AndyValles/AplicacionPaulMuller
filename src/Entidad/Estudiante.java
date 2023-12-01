/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author andyv
 */
public class Estudiante extends Usuario {

    private int Carrera;
    private String FPostulacion;

    public Estudiante() {
    }

    public int getCarrera() {
        return Carrera;
    }

    public void setCarrera(int Carrera) {
        this.Carrera = Carrera;
    }

    public String getFPostulacion() {
        return FPostulacion;
    }

    public void setFPostulacion(String FPostulacion) {
        this.FPostulacion = FPostulacion;
    }
    
    
}
