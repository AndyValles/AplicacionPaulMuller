/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;


public class DetalleDevolucion {
  private String devolucion;
  private String libro;
  private int cantLibro;

    public DetalleDevolucion() {
    }

    public String getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(String devolucion) {
        this.devolucion = devolucion;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public int getCantLibro() {
        return cantLibro;
    }

    public void setCantLibro(int cantLibro) {
        this.cantLibro = cantLibro;
    }
  
}
