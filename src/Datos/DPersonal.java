
package Datos;

import Entidad.Personal;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;


public class DPersonal extends DUsuario{
    private final String[] datos=new String[]{"DNI1","DNI2","Nomb","Ape","Dir","Cor","Tel","Car","Dis","Sex"};
    

    public DPersonal() {
       
    }
   
    
     public DefaultTableModel Leer(){
         
        
        try{
           super.Leer("call mPersonal();");
                while(rs.next()){
                   Object[] items=new Object[16];
                   items[0]=rs.getString(1);
                   items[1]=Data(new ImageIcon(ImageIO.read(rs.getBinaryStream(2))));
                   items[2]=rs.getString(3);
                   items[3]=rs.getString(4);
                   items[4]=rs.getString(5);
                   items[5]=rs.getString(6);
                   items[6]=rs.getString(7);
                   items[7]=rs.getString(8);
                   items[8]=rs.getString(9);
                   items[9]=rs.getString(10);
                   items[10]=rs.getString(11);
                   items[11]=rs.getString(12);
                   items[12]=rs.getString(13);
                   items[13]=rs.getString(14);
                   items[14]=modi;
                   items[15]=Eli;
                   dt.addRow(items);
                }
             Cerrar();
        }catch(Exception e){
        System.out.println("Personal: Error de lectura: "+ e);}
    return dt;
    }
     
     public DefaultTableModel Buscar(Personal p,String txt,int i){
         
      
         try{
          super.Buscar("call b"+datos[i-1]+"Personal(?);");
            
            if(i==1){o=p.getDNI();
            }else{o=txt;}
            
            cSt.setObject(1, o);
            BufferedImage bf=null;
            rs=cSt.executeQuery();
                while(rs.next()){
                   Object[] items=new Object[16];
                   items[0]=rs.getString(1);
                   items[1]=Data(new ImageIcon(ImageIO.read(rs.getBinaryStream(2))));
                   items[2]=rs.getString(3);
                   items[3]=rs.getString(4);
                   items[4]=rs.getString(5);
                   items[5]=rs.getString(6);
                   items[6]=rs.getString(7);
                   items[7]=rs.getString(8);
                   items[8]=rs.getString(9);
                   items[9]=rs.getString(10);
                   items[10]=rs.getString(11);
                   items[11]=rs.getString(12);
                   items[12]=rs.getString(13);
                   items[13]=rs.getString(14);
                   items[14]=modi;
                   items[15]=Eli;
                   busqueda.add(items);
                   dt.addRow(items);
                }
                
              Cerrar();
        }catch(Exception e){
        System.out.println("Personal: Error de Buscado: "+ e);}
    return dt;
    }
    
    public boolean Insertar(Personal p){
    try{
       super.Insertar("call iPersonal(?,?);");
        cSt.setString(1, p.getDNI());
        cSt.setInt(2, p.getCargo());
        rs=cSt.executeQuery();
     
    
       Cerrar();
        return true;
     
    }catch(Exception e){
        System.out.println("Personal: Error de Insertado: "+ e);
    }
    return false;
    }
    

    public boolean Actualizar(Personal p){
    try{
        super.Actualizar("call uPersonal(?,?);");
        cSt.setInt(1, p.getCargo());
        cSt.setString(2, p.getDNI());
        rs=cSt.executeQuery();
        
        Cerrar();
       
        return true;
     
            
    }catch(Exception e){
        System.out.println("Personal: Error de Modificado: "+ e);
    }
    return false;
    }
    
    
    public boolean Eliminar(Personal p){
    try{
        return super.Eliminar("call dPersonal(?);",p.getDNI());
    
    }catch(Exception e){
        System.out.println("Personal: Error de Eliminado: "+ e);
    }
    return false;
    }
}
