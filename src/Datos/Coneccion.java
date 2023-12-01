/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.DriverManager;


public class Coneccion {
     private String direccion="localhost";
     private String puerto="3306";
     private String usuario="root";
     private String contra="980101627";
        
        
     public Connection conexion(){
         Connection connection=null;
         try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://"+direccion+":"+puerto+"/BDBiblioteca",usuario, contra);
        
        }catch(Exception ex){
            System.out.println("Error al registrar el driver de MySQL: " + ex);
        }
            return connection;
    } 

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
     
     
     
     
     
     
     
     
     
}
