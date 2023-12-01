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
public class Autor {
    private int Codigo;
    private String Nombre;
    private String ApePA;
    private String ApeMA;
    private int Pais;

    public Autor() {
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApePA() {
        return ApePA;
    }

    public void setApePA(String ApePA) {
        this.ApePA = ApePA;
    }

    public String getApeMA() {
        return ApeMA;
    }

    public void setApeMA(String ApeMA) {
        this.ApeMA = ApeMA;
    }

    public int getPais() {
        return Pais;
    }

    public void setPais(int Pais) {
        this.Pais = Pais;
    }
    
}
