/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.io.FileInputStream;

/**
 *
 * @author andyv
 */
public class Libro {
    private String Codigo;
    private byte[] Portada;
    private String Titulo;
    private int Autor;
    private String FPublicacion;
    private String FSubida;
    private int CantUsu;
    private int Categoria;
    private int Editorial;
    private String Edicion;
    private boolean Estado;

    public Libro() {
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public byte[] getPortada() {
        return Portada;
    }

    public void setPortada(byte[] Portada) {
        this.Portada = Portada;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public int getAutor() {
        return Autor;
    }

    public void setAutor(int Autor) {
        this.Autor = Autor;
    }

    public String getFPublicacion() {
        return FPublicacion;
    }

    public void setFPublicacion(String FPublicacion) {
        this.FPublicacion = FPublicacion;
    }

    public int getCategoria() {
        return Categoria;
    }

    public void setCategoria(int Categoria) {
        this.Categoria = Categoria;
    }

    public int getEditorial() {
        return Editorial;
    }

    public void setEditorial(int Editorial) {
        this.Editorial = Editorial;
    }

    public String getEdicion() {
        return Edicion;
    }

    public void setEdicion(String Edicion) {
        this.Edicion = Edicion;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public String getFSubida() {
        return FSubida;
    }

    public void setFSubida(String FSubida) {
        this.FSubida = FSubida;
    }

    public int getCantUsu() {
        return CantUsu;
    }

    public void setCantUsu(int CantUsu) {
        this.CantUsu = CantUsu;
    }
    
}
