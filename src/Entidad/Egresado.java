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
public class Egresado extends Usuario {
    
    private int Profesion;
    private String FGraduacion;

    public Egresado() {
    }

    public int getProfesion() {
        return Profesion;
    }

    public void setProfesion(int Profesion) {
        this.Profesion = Profesion;
    }

    public String getFGraduacion() {
        return FGraduacion;
    }

    public void setFGraduacion(String FGraduacion) {
        this.FGraduacion = FGraduacion;
    }
    
    
}
