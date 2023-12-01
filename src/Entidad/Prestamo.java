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
public class Prestamo {
    private String Codigo;
    private String DNI;
    private String FPrestamo;
    private String FDevolucion;
   

    public Prestamo() {
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
 
    public String getFPrestamo() {
        return FPrestamo;
    }

    public void setFPrestamo(String FPrestamo) {
        this.FPrestamo = FPrestamo;
    }

    public String getFDevolucion() {
        return FDevolucion;
    }

    public void setFDevolucion(String FDevolucion) {
        this.FDevolucion = FDevolucion;
    }


}
