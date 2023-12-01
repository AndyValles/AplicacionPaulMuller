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
public class Configuracion {
    private int Codigo;
    private int MaxLibros;
    private int MaxDias;

    public Configuracion() {
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public int getMaxLibros() {
        return MaxLibros;
    }

    public void setMaxLibros(int MaxLibros) {
        this.MaxLibros = MaxLibros;
    }

    public int getMaxDias() {
        return MaxDias;
    }

    public void setMaxDias(int MaxDias) {
        this.MaxDias = MaxDias;
    }
    
    
}
