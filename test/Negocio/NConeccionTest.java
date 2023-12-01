/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

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
public class NConeccionTest {
    
    public NConeccionTest() {
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
     * Test of DefaultConection method, of class NConeccion.
     */
    

    /**
     * Test of Conectar method, of class NConeccion.
     */
    
    /**
     * Test of isConected method, of class NConeccion.
     */
    @Test
    public void testIsConected() {
        System.out.println("isConected");
        NConeccion instance = new NConeccion();
        boolean expResult = true;
        boolean result = instance.isConected();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
