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
public class Usuario {
    private String DNI;
    private String PriNombre;
    private String SegNombre;
    private String ApePat;
    private String ApeMat;
    private String Direccion;
    private int Distrito;
    private String Correo;
    private String Telefono;
    private int Sexo;
    private String Usuario;
    private String Contraseña;
    private byte[] fotoPerfil;

    public Usuario() {
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getPriNombre() {
        return PriNombre;
    }

    public void setPriNombre(String PriNombre) {
        this.PriNombre = PriNombre;
    }

    public String getSegNombre() {
        return SegNombre;
    }

    public void setSegNombre(String SegNombre) {
        this.SegNombre = SegNombre;
    }

    public String getApePat() {
        return ApePat;
    }

    public void setApePat(String ApePat) {
        this.ApePat = ApePat;
    }

    public String getApeMat() {
        return ApeMat;
    }

    public void setApeMat(String ApeMat) {
        this.ApeMat = ApeMat;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public int getDistrito() {
        return Distrito;
    }

    public void setDistrito(int Distrito) {
        this.Distrito = Distrito;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public int getSexo() {
        return Sexo;
    }

    public void setSexo(int Sexo) {
        this.Sexo = Sexo;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public byte[] getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(byte[] fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }
    
}
