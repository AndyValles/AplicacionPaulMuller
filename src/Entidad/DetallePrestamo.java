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
public class DetallePrestamo {
    private String prestamo;
    private String Libro;
    private int CanLibros;

    public DetallePrestamo() {
    }
    
    
    
    
    public String getLibro() {
        return Libro;
    }

    public void setLibro(String Libro) {
        this.Libro = Libro;
    }

    public int getCanLibros() {
        return CanLibros;
    }

    public void setCanLibros(int CanLibros) {
        this.CanLibros = CanLibros;
    }

    public String getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(String prestamo) {
        this.prestamo = prestamo;
    }

}
