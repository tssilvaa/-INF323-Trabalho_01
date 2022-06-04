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
public class TanqueCombustivelTest {
    
    public TanqueCombustivelTest() {
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
     * Test of getCapacidadeTotal method, of class TanqueCombustivel.
     */
    @Test
    public void testGetCapacidadeTotal() {
        System.out.println("getCapacidadeTotal");
        Tanque instance = new TanqueCombustivel();
        double expResult = 1000;
        double result = instance.getCapacidadeTotal().doubleValue();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of getQntAtual method, of class TanqueCombustivel.
     */
    @Test
    public void testGetQntAtual() {
        System.out.println("getQntAtual");
        Tanque instance = new TanqueCombustivel();
        double expResult1 = 0;
        double result1 = instance.getQntAtual().doubleValue();
        assertEquals(expResult1, result1, 0.0);
        //
        double expResult2 = 10;
        instance.abastecer(10);
        double result2 = instance.getQntAtual().doubleValue();
        assertEquals(expResult2, result2, 0.0);
        //
        double expResult3 = 20;
        instance.abastecer(10);
        double result3 = instance.getQntAtual().doubleValue();
        assertEquals(expResult3, result3, 0.0);
        //
        double expResult4 = 1000;
        instance.abastecer(2000);
        double result4 = instance.getQntAtual().doubleValue();
        assertEquals(expResult4, result4, 0.0);
    }

    /**
     * Test of abastecer method, of class TanqueCombustivel.
     */
    @Test
    public void testAbastecer() {
        System.out.println("abastecer");
        double value1 = 200;
        Tanque instance = new TanqueCombustivel();
        boolean expResult1 = true;
        boolean result1 = instance.abastecer(value1);
        assertEquals(expResult1, result1);
        assertEquals(value1, instance.getQntAtual().doubleValue(), 0.0);
        //
        double value2 = 900;
        boolean expResult2 = false;
        boolean result2 = instance.abastecer(value2);
        assertEquals(expResult2, result2);
        assertEquals(instance.getCapacidadeTotal().doubleValue(), instance.getQntAtual().doubleValue(), 0.0);
    }
    
    /**
     * Test of abastecer method, of class TanqueCombustivel.
     */
    @Test
    public void testAbastecerNegativo() {
        System.out.println("AbastecerNegativo");
        double value1 = -200.0;
        Tanque instance = new TanqueCombustivel();
        boolean expResult1 = false;
        boolean result1 = instance.abastecer(value1);
        assertEquals(expResult1, result1);
        assertEquals(0, instance.getQntAtual().doubleValue(), 0.0);
    }
    
    /**
     * Test of consumir method, of class TanqueCombustivel.
     */
    @Test
    public void testConsumir() {
        System.out.println("consumir");
        double value1 = 200;
        Tanque instance = new TanqueCombustivel();
        boolean expResult1 = false;
        assertEquals(expResult1, instance.consumir(value1));
        assertEquals(0, instance.getQntAtual().doubleValue(), 0.0);
        //
        instance.abastecer(value1);
        double value2 = 50;
        boolean expResult2 = true;
        boolean result2 = instance.consumir(value2);
        assertEquals(expResult2, result2);
        assertEquals(150, instance.getQntAtual().doubleValue(), 0.0);
    }
    
    /**
     * Test of consumir method, of class TanqueCombustivel.
     */
    @Test
    public void testConsumirNegativo() {
        System.out.println("ConsumirNegativo");
        double value1 = -200.0;
        Tanque instance = new TanqueCombustivel();
        boolean expResult1 = false;
        assertEquals(expResult1, instance.consumir(value1));
        assertEquals(0, instance.getQntAtual().doubleValue(), 0.0);
    }
}
