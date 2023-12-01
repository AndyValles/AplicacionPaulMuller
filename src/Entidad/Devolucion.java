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
public class Devolucion {
    private String Codigo;
    private String prestamo;
    private String FAcordada;
    private String FRecibida;


    public Devolucion() {
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getFAcordada() {
        return FAcordada;
    }

    public void setFAcordada(String FAcordada) {
        this.FAcordada = FAcordada;
    }

    public String getFRecibida() {
        return FRecibida;
    }

    public void setFRecibida(String FRecibida) {
        this.FRecibida = FRecibida;
    }

    public String getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(String prestamo) {
        this.prestamo = prestamo;
    }

}
