package Negocio;

import Datos.DUsuario;
import Entidad.Usuario;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class NUsuario {

    private DUsuario uu=new DUsuario();
    
    public int SEARCH_DNI=4;
    public int SEARCH_NAME=5;
    public int SEARCH_LASTNAME=6;
    public int SEARCH_DIR=7;
    public int SEARCH_CORREO=8;
    public int SEARCH_PHONE=9;
    public int SEARCH_USER=10;
    
    public int USER_DNI=1;
    public int USER_DIST=2;
    public int USER_SEXO=3;
    
    public NUsuario() {
    }
    
    public NUsuario(Object ...titles) {
        uu.setTitle(titles);
    }
    
     public DefaultTableModel Leer(){
        return uu.Leer();
    }
     
    
    public DefaultTableModel Buscar(Usuario u,int user){
            return uu.Buscar(u,"", user);
    }
    
    public DefaultTableModel Buscar(String txt,int search){
            return uu.Buscar(null,txt, search);
    }
    
    public boolean BuscarBool(Usuario u,int user){
            return uu.Buscar(u,"", user).getRowCount()>0;
    }
    
    public boolean BuscarBool(String txt,int search){
            return uu.Buscar(null,txt, search).getRowCount()>0;
    }
    
    public boolean Insertar(Usuario u){
        return uu.Insertar(u);
    }
    

    public boolean Actualizar(Usuario u){
        return uu.Actualizar(u);
    }
    
    
    public boolean Eliminar(Usuario u){
        return uu.Eliminar(u);
    }
    
    public ArrayList cboSexo(){
        return uu.cboSexo();
    }
    
    public boolean Login(Usuario u){
        return uu.Logger(u);
    }
    
    public ArrayList<Object[]> Lectura() {
        return uu.getBusqueda();
    }
    
    public int Cantidad(){
        uu.Leer();
        return uu.getCantidad();
    }
    
}
