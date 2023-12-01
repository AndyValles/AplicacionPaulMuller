/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.Datos;

import Negocio.NPersonal;
import Entidad.Personal;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andyv
 */
public class NPersonalTest {
    
    public NPersonalTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of Leer method, of class NPersonal.
     */
//    @Test
//    public void testLeer() {
//        System.out.println("Leer");
//        NPersonal instance = new NPersonal();
//        DefaultTableModel expResult = null;
//        DefaultTableModel result = instance.Leer();
//        assertEquals(expResult, result);
//       
//    }

    /**
     * Test of Buscar method, of class NPersonal.
     */
//    @Test
//    public void testBuscar_Personal_int() {
//        System.out.println("Buscar");
//        Personal p = null;
//        int personal = 0;
//        NPersonal instance = new NPersonal();
//        DefaultTableModel expResult = null;
//        DefaultTableModel result = instance.Buscar(p, personal);
//        assertEquals(expResult, result);
//        
//    }

    /**
     * Test of Buscar method, of class NPersonal.
     */
//    @Test
//    public void testBuscar_String_int() {
//        System.out.println("Buscar");
//        String txt = "";
//        int search = 0;
//        NPersonal instance = new NPersonal();
//        DefaultTableModel expResult = null;
//        DefaultTableModel result = instance.Buscar(txt, search);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//       
//    }

    /**
     * Test of BuscarBool method, of class NPersonal.
     */
//    @Test
//    public void testBuscarBool_Personal_int() {
//        System.out.println("BuscarBool");
//        Personal p = null;
//        int personal = 0;
//        NPersonal instance = new NPersonal();
//        boolean expResult = false;
//        boolean result = instance.BuscarBool(p, personal);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//    }

    /**
     * Test of BuscarBool method, of class NPersonal.
     */
    @Test
    public void testBuscarBool_String_int() {
        System.out.println("BuscarBool");
         NPersonal instance = new NPersonal();
        String txt = "74998768";
        int search = instance.SEARCH_DNI;
       
        boolean expResult = true;
        boolean result = instance.BuscarBool(txt, search);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of Insertar method, of class NPersonal.
     */
//    @Test
//    public void testInsertar() {
//        System.out.println("Insertar");
//        Personal p = null;
//        NPersonal instance = new NPersonal();
//        boolean expResult = false;
//        boolean result = instance.Insertar(p);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//    }

    /**
     * Test of Actualizar method, of class NPersonal.
     */
//    @Test
//    public void testActualizar() {
//        System.out.println("Actualizar");
//        Personal p = null;
//        NPersonal instance = new NPersonal();
//        boolean expResult = false;
//        boolean result = instance.Actualizar(p);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of Eliminar method, of class NPersonal.
//     */
//    @Test
//    public void testEliminar() {
//        System.out.println("Eliminar");
//        Personal p = null;
//        NPersonal instance = new NPersonal();
//        boolean expResult = false;
//        boolean result = instance.Eliminar(p);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//    }

    /**
     * Test of Lectura method, of class NPersonal.
     */
//    @Test
//    public void testLectura() {
//        System.out.println("Lectura");
//        NPersonal instance = new NPersonal();
//        ArrayList expResult = null;
//        ArrayList result = instance.Lectura();
//        assertEquals(expResult, result);
//         TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
