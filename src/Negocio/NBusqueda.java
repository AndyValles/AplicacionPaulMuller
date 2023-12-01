/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidad.Autor;
import Entidad.Cargo;
import Entidad.Carrera;
import Entidad.Categoria;
import Entidad.Distrito;
import Entidad.Editorial;
import Entidad.Libro;
import Entidad.Pais;
import Entidad.Profesion;
import javax.swing.table.DefaultTableModel;



public class NBusqueda {
    
    private NAutor Nautor=new NAutor("Codigo","Nombre","Apellido Paterno","Apellido Materno","País","Modificar","Eliminar");
    private NEditorial Neditorial=new NEditorial("Codigo","Nombre","Dirección","Telefono","Correo","País","Modificar","Eliminar");
    
    private NCargo Ncargo=new NCargo("Codigo","Nombre","Estado","Modificar","Eliminar");
    private NCarrera Ncarrera=new NCarrera("Codigo","Nombre","Estado","Modificar","Eliminar");
    private NCategoria Ncategoria=new NCategoria("Codigo","Nombre","Estado","Modificar","Eliminar");
    private NDistrito Ndistrito=new NDistrito("Codigo","Nombre","Estado","Modificar","Eliminar"); 
    private NPais Npais=new NPais("Codigo","Nombre","Estado","Modificar","Eliminar");
    private NProfesion Nprofesion=new NProfesion("Codigo","Nombre","Estado","Modificar","Eliminar");
    
    
    private NEstudiante Nestudiante=new NEstudiante("DNI","Foto Perfil","Primer Nombre","Segundo Nombre","Apellido Paterno","Apellido Materno","Direccion","Distrito","Correo","Telefono","Genero","Usuario","Contraseña","Carrera","Fecha Postulación","Modificar","Eliminar");
    private NEgresado Negresado=new NEgresado("DNI","Foto Perfil","Primer Nombre","Segundo Nombre","Apellido Paterno","Apellido Materno","Direccion","Distrito","Correo","Telefono","Genero","Usuario","Contraseña","Profesión","Fecha Graduación","Modificar","Eliminar");
    private NPersonal Npersonal=new NPersonal("DNI","Foto Perfil","Primer Nombre","Segundo Nombre","Apellido Paterno","Apellido Materno","Direccion","Distrito","Correo","Telefono","Genero","Usuario","Contraseña","Cargo","Modificar","Eliminar");
    
    private NUsuario Nusuario=null; 
    private NLibro Nlibro=null;
  
    private String[] buscarPor=new String[]{"Empieza con","Termina con","Igual a","Contiene"};
    private String[] titles;
    private Object[] titulo;
    
    public NBusqueda() {
    }

    public NBusqueda(String ...Titles) {
         this.titles=Titles;
    }
    
    public NBusqueda(Object[] titulo,String ...Titles) {
         this.titles=Titles;
         this.titulo=titulo;
    }
    
    public String SQL(int a,String txt){
    String sql="%";
        switch(a){
           case 0:
               sql=txt+"%";
               break;
           case 1:
                sql="%"+txt;
               break;
           case 2:
                sql=txt;
               break;
           case 3:
                 sql="%"+txt+"%";
               break;
        
        }
        return sql;
    }
    
     public DefaultTableModel tableAutor(int b1,Autor n){
             return Nautor.Buscar(n);
         
    }
    
    public DefaultTableModel tableAutor(int b,int b1,String txt){
        switch(b1){
         case 1:
             return Nautor.Buscar(SQL(b,txt), Nautor.USER_PAIS);
         case 2:
             return Nautor.Buscar(SQL(b,txt), Nautor.SEARCH_NAME);
         case 3:
             return Nautor.Buscar(SQL(b,txt), Nautor.SEARCH_LASTNAME);
        }
        return null;
    }
    
    
    public DefaultTableModel tableEditorial(int b1,Editorial n){
             return Neditorial.Buscar(n);
         
    }
    
    public DefaultTableModel tableEditorial(int b,int b1,String txt){
        switch(b1){
         case 1:
             return Neditorial.Buscar(SQL(b,txt), Neditorial.EDI_PAIS);
         case 2:
             return Neditorial.Buscar(SQL(b,txt), Neditorial.SEARCH_NAME);
         case 3:
             return Neditorial.Buscar(SQL(b,txt), Neditorial.SEARCH_DIR);
         case 4:
             return Neditorial.Buscar(SQL(b,txt), Neditorial.SEARCH_PHONE);
         case 5:
             return Neditorial.Buscar(SQL(b,txt), Neditorial.SEARCH_CORREO);
              }
        return null;
    }
    
    
     public DefaultTableModel tableCargo(int b1,Cargo n){
        switch(b1){
         case 0:
             return Ncargo.BuscarCod(n);
         case 2:
             return Ncargo.BuscarEst(n);
        
              }
        return null;
    }
    
    public DefaultTableModel tableCargo(int b,String txt){
             return Ncargo.BuscarNom(SQL(b,txt));
    }
    
    public DefaultTableModel tableCarrera(int b1,Carrera n){
        switch(b1){
         case 0:
             return Ncarrera.BuscarCod(n);
         case 2:
             return Ncarrera.BuscarEst(n);
        
              }
        return null;
    }
    
    public DefaultTableModel tableCarrera(int b,String txt){
             return Ncarrera.BuscarNom(SQL(b,txt));
    }
    
    public DefaultTableModel tableCategoria(int b1,Categoria n){
        switch(b1){
         case 0:
             return Ncategoria.BuscarCod(n);
         case 2:
             return Ncategoria.BuscarEst(n);
        
              }
        return null;
    }
    
    public DefaultTableModel tableCategoria(int b,String txt){
             return Ncategoria.BuscarNom(SQL(b,txt));
    }
    
    public DefaultTableModel tableProfesion(int b1,Profesion n){
        switch(b1){
         case 0:
             return Nprofesion.BuscarCod(n);
         case 2:
             return Nprofesion.BuscarEst(n);
        
              }
        return null;
    }
    
    public DefaultTableModel tableProfesion(int b,String txt){
             return Nprofesion.BuscarNom(SQL(b,txt));
    }
    
    public DefaultTableModel tableDistrito(int b1,Distrito n){
        switch(b1){
         case 0:
             return Ndistrito.BuscarCod(n);
         case 2:
             return Ndistrito.BuscarEst(n);
        
              }
        return null;
    }
    
    public DefaultTableModel tableDistrito(int b,String txt){
             return Ndistrito.BuscarNomb(SQL(b,txt));
    }
    
    
    public DefaultTableModel tablePais(int b1,Pais p){
        switch(b1){
         case 0:
             return Npais.BuscarCod(p);
         case 2:
             return Npais.BuscarEst(p);
        
              }
        return null;
    }
    
    public DefaultTableModel tablePais(int b,String txt){
             return Npais.BuscarNom(SQL(b,txt));
    }
    
    
     public DefaultTableModel tableU(int b,int b1,String txt){
         Nusuario=new NUsuario(titulo);
        switch(b1){
         case 0:
             return Nusuario.Buscar(SQL(b,txt), Nusuario.SEARCH_DNI);
         case 1:
             return Nusuario.Buscar(SQL(b,txt), Nusuario.SEARCH_NAME);
         case 2:
             return Nusuario.Buscar(SQL(b,txt), Nusuario.SEARCH_LASTNAME);
         case 3:
             return Nusuario.Buscar(SQL(b,txt), Nusuario.SEARCH_DIR);
         case 4:
             return Nusuario.Buscar(SQL(b,txt), Nusuario.USER_DIST);
         case 5:
             return Nusuario.Buscar(SQL(b,txt), Nusuario.SEARCH_CORREO);
         case 6:
             return Nusuario.Buscar(SQL(b,txt), Nusuario.USER_SEXO);
              }
        return null;
    }
     
     public DefaultTableModel tablePersonal(int b,int b1,String txt){
        switch(b1){
         case 0:
             return Npersonal.Buscar(SQL(b,txt), Npersonal.SEARCH_DNI);
         case 1:
             return Npersonal.Buscar(SQL(b,txt), Npersonal.SEARCH_NAME);
         case 2:
             return Npersonal.Buscar(SQL(b,txt), Npersonal.SEARCH_APE);
         case 3:
             return Npersonal.Buscar(SQL(b,txt), Npersonal.SEARCH_DIR);
         case 4:
             return Npersonal.Buscar(SQL(b,txt), Npersonal.SEARCH_CORREO);
         case 5:
             return Npersonal.Buscar(SQL(b,txt), Npersonal.SEARCH_PHONE);
         case 6:
             return Npersonal.Buscar(SQL(b,txt), Npersonal.PERSONAL_CARGO);
         case 7:
             return Npersonal.Buscar(SQL(b,txt), Npersonal.USER_DIS);
         case 8:
             return Npersonal.Buscar(SQL(b,txt), Npersonal.USER_SEXO);
              }
        return null;
    }
     
      public DefaultTableModel tableEstudiante(int b,int b1,String txt){
        switch(b1){
         case 0:
             return Nestudiante.Buscar(SQL(b,txt), Nestudiante.SEARCH_DNI);
         case 1:
             return Nestudiante.Buscar(SQL(b,txt), Nestudiante.SEARCH_NAME);
         case 2:
             return Nestudiante.Buscar(SQL(b,txt), Nestudiante.SEARCH_APE);
         case 3:
             return Nestudiante.Buscar(SQL(b,txt), Nestudiante.SEARCH_DIR);
         case 4:
             return Nestudiante.Buscar(SQL(b,txt), Nestudiante.SEARCH_CORREO);
         case 5:
             return Nestudiante.Buscar(SQL(b,txt), Nestudiante.SEARCH_PHONE);
         case 6:
             return Negresado.Buscar(SQL(b,txt), Negresado.SEARCH_DATE);
         case 7:
             return Nestudiante.Buscar(SQL(b,txt), Nestudiante.ESTUDIANTE_CARRERA);
         case 8:
             return Nestudiante.Buscar(SQL(b,txt), Nestudiante.USER_DIS);
         case 9:
             return Nestudiante.Buscar(SQL(b,txt), Nestudiante.USER_SEXO);
              }
        return null;
    }
      
       public DefaultTableModel tableEgresado(int b,int b1,String txt){
        switch(b1){
         case 0:
             return Negresado.Buscar(SQL(b,txt), Negresado.SEARCH_DNI);
         case 1:
             return Negresado.Buscar(SQL(b,txt), Negresado.SEARCH_NAME);
         case 2:
             return Negresado.Buscar(SQL(b,txt), Negresado.SEARCH_APE);
         case 3:
             return Negresado.Buscar(SQL(b,txt), Negresado.SEARCH_DIR);
         case 4:
             return Negresado.Buscar(SQL(b,txt), Negresado.SEARCH_CORREO);
         case 5:
             return Negresado.Buscar(SQL(b,txt), Negresado.SEARCH_PHONE);
         case 6:
             return Negresado.Buscar(SQL(b,txt), Negresado.SEARCH_DATE);
         case 7:
             return Negresado.Buscar(SQL(b,txt), Negresado.EGRESADO_PROFESION);
         case 8:
             return Negresado.Buscar(SQL(b,txt), Negresado.USER_DIS);
         case 9:
             return Negresado.Buscar(SQL(b,txt), Negresado.USER_SEXO);
              }
        return null;
    }
       
     public DefaultTableModel tableLibro(int b,int b1,String txt){
        Nlibro=new NLibro(titulo);
         switch(b1){
         case 0:
             return Nlibro.Buscar(SQL(b,txt), Nlibro.SEARCH_COD);
         case 1:
             return Nlibro.Buscar(SQL(b,txt), Nlibro.SEARCH_TITLE);
         case 2:
             return Nlibro.Buscar(SQL(b,txt), Nlibro.SEARCH_FPUB);
         case 3:
             return Nlibro.Buscar(SQL(b,txt), Nlibro.SEARCH_FSUB);
         case 4:
             return Nlibro.Buscar(SQL(b,txt), Nlibro.SEARCH_EDI);
         case 5:
             return Nlibro.Buscar(SQL(b,txt), Nlibro.LIBRO_EDITORIAL);
         case 6:
             return Nlibro.Buscar(SQL(b,txt), Nlibro.LIBRO_AUTOR);
              }
        return null;
    }
    
     public DefaultTableModel tableLibro(Libro l){
         Nlibro=new NLibro(titulo);
        return Nlibro.Buscar(l, Nlibro.LIBRO_ESTADO);
    }

    public String[] getBuscarPor() {
        return buscarPor;
    }

    public String[] getTitles() {
        return titles;
    }
}
