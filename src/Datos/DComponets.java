/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import ButtonSpecial.JbtnRadius.JButtonRadius;
import Negocio.Desing;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;
import swing.ImageAvatar;

/**
 *
 * @author andyv
 */
public class DComponets extends Coneccion{
    
    protected ArrayList<Object[]> busqueda=new ArrayList<>();
    protected Blob blob=null;
    
    protected Object[] title=null;
    protected Object o="";
    
    protected int cantidad = 0;
    protected int dato;
    
    protected Desing ds=new Desing();
    protected JButtonRadius modi=new JButtonRadius();
    protected JButtonRadius Eli=new JButtonRadius();
    
    protected DefaultTableModel dt;
    
    protected CallableStatement cSt;
    protected ResultSet rs;
    
    public DComponets() {
        IniButton();
    }
    
    protected JCheckBox checkBox(boolean isSelect){
        JCheckBox jk=new JCheckBox();
        jk.setSize(10, 10);
        jk.setSelected(isSelect);
        return jk;
    }
    
    protected  ImageAvatar Data(ImageIcon icon){
        ImageAvatar image=new ImageAvatar();
        
        image.setBorderSize(0);
        image.setBorderSpace(0);
        
        image.setSize(100,100);
        image.setImage(icon);

        return image;
    }
    
    private void IniButton(){
               
        Eli.setName("eliminar");
        modi.setName("modificar");
            
        Eli.setSize(10, 10);
        modi.setSize(10, 10);
        
        Eli.setIcon(new ImageIcon(getClass().getResource("/Imagens/Eliminar.png")));
        modi.setIcon(new ImageIcon(getClass().getResource("/Imagens/modificar.png")));
        
        ds.AsignarImagen(Eli, 0, 0);
        ds.AsignarImagen(modi, 0, 0);
    }
    
    public DefaultTableModel Leer(String txt) throws SQLException{
        dt=new DefaultTableModel();
        dt.setColumnIdentifiers(title);
        
        cSt= conexion().prepareCall(txt);
        rs=cSt.executeQuery();
        
        return dt;
    }
    
    public DefaultTableModel Buscar(String txt) throws SQLException{
        dt=new DefaultTableModel();
        dt.setColumnIdentifiers(title);
        
        while(!busqueda.isEmpty()){busqueda.remove(busqueda.size()-1);}

        
        cSt= conexion().prepareCall(txt);
         
       
        
        return dt;
    }
    
    public boolean Insertar(String txt) throws SQLException{
        cSt= conexion().prepareCall(txt);
       
        return true;
    }
    
    public boolean Actualizar(String txt) throws SQLException{
        cSt= conexion().prepareCall(txt);
       
        return true;
    }
    
    public boolean Eliminar(String txt,Object e) throws SQLException{
        cSt= conexion().prepareCall(txt);
         cSt.setObject(1, e);
        rs=cSt.executeQuery();
        Cerrar();
        return true;
    }
    
    public ArrayList cbo(String txt){
    ArrayList items=new ArrayList();
    try{
     cSt=conexion().prepareCall(txt);
      rs=cSt.executeQuery();
        while(rs.next()){
            items.add(rs.getString(1));
        }
         Cerrar();
    }catch(Exception e){}
    return items;
    }
    
    protected void Cerrar() throws SQLException{
        cSt.close();
        conexion().close();
        rs.close();
    }
    
    
    
    public Object[] getTitles() {
        return title;
    }

    public void setTitle(Object[] titles) {
        this.title = titles;
    }

    public ArrayList<Object[]> getBusqueda() {
        return busqueda;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public int getDato() {
        return dato;
    }
    
    
}
