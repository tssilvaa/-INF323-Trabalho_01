/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author inf323
 */
public class CompartimentoCargaTest {
    
    public CompartimentoCargaTest() {
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
     * Test of getCapacidadeTotal method, of class CompartimentoCarga.
     */
    @Test
    public void testGetCapacidadeTotal() {
        System.out.println("getCapacidadeTotal");
        CompartimentoCarga instance = new CompartimentoCarga();
        int expResult = 1000;
        float result = instance.getCapacidadeTotal();
        assertEquals(expResult, result, 0.1);
    }

    /**
     * Test of getQntAtual method, of class CompartimentoCarga.
     */
    @Test
    public void testGetQntAtual() {
        System.out.println("getQntAtual");
        CompartimentoCarga instance = new CompartimentoCarga();
        int expResult = 0;
        float result = instance.getQntAtual();
        assertEquals(expResult, result, 0.1);
        
    }

    /**
     * Test of carregarCarga method, of class CompartimentoCarga.
     */
    @Test
    public void testCarregarCarga() {
        System.out.println("carregarCarga");
        CompartimentoCarga instance = new CompartimentoCarga();
        boolean expResult1 = false;
        boolean result1 = instance.carregarCarga(2000);
        assertEquals(expResult1, result1);
        assertEquals(0, instance.getQntAtual(), 0.1);
        //
        boolean expResult2 = true;
        boolean result2 = instance.carregarCarga(100);
        assertEquals(expResult2, result2);
        assertEquals(100, instance.getQntAtual(), 0.1);
        //
        boolean expResult3 = true;
        boolean result3 = instance.carregarCarga(50);
        assertEquals(expResult3, result3);
        assertEquals(150, instance.getQntAtual(), 0.1);
    }
    
    /**
     * Test of carregarCarga method, of class CompartimentoCarga.
     */
    @Test
    public void testCarregarCargaNegativa() {
        System.out.println("carregarCargaNegativa");
        CompartimentoCarga instance = new CompartimentoCarga();
        boolean expResult1 = false;
        boolean result1 = instance.carregarCarga(-100);
        assertEquals(expResult1, result1);
        assertEquals(0, instance.getQntAtual(), 0.1);
    }
    
    /**
     * Test of descarregarCarga method, of class CompartimentoCarga.
     */
    @Test
    public void testDescarregarCarga() {
        System.out.println("descarregarCarga");
        CompartimentoCarga instance = new CompartimentoCarga();        //
        boolean expResult1 = true;
        instance.carregarCarga(200);
        boolean result1 = instance.descarregarCarga(100);
        assertEquals(expResult1, result1);
        assertEquals(100, instance.getQntAtual(), 0.1);
        //
        boolean expResult2 = false;
        boolean result2 = instance.descarregarCarga(200);
        assertEquals(expResult2, result2);
        assertEquals(100, instance.getQntAtual(), 0.1);
        //
        boolean expResult3 = true;
        boolean result3 = instance.descarregarCarga(100);
        assertEquals(expResult3, result3);
        assertEquals(0, instance.getQntAtual(), 0.1);
    }
    
    /**
     * Test of descarregarCarga method, of class CompartimentoCarga.
     */
    @Test
    public void testDescarregarCargaNegativa() {
        System.out.println("descarregarCargaNegativa");
        CompartimentoCarga instance = new CompartimentoCarga();        //
        boolean expResult1 = false;
        boolean result1 = instance.descarregarCarga(-100);
        assertEquals(expResult1, result1);
        assertEquals(0, instance.getQntAtual(), 0.1);
    }
    
}
