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
public class TurbinaTest {
    
    public TurbinaTest() {
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
     * Test of ligar method, of class Turbina.
     */
    @Test
    public void extendsMotor() {
        System.out.println("extendsMotor");
        assertEquals(Turbina.class.getSuperclass(), Motor.class);
        
    }
    
    /**
     * Test of ligar method, of class Turbina.
     */
    @Test
    public void testEstadoInicial() {
        System.out.println("estadoInicial");
        Turbina instance = new Turbina();
        assertEquals(false, instance.isLigado());
        assertEquals(0, instance.getNivelPotencia());        
    }

    /**
     * Test of ligar method, of class Turbina.
     */
    @Test
    public void testLigar() {
        System.out.println("ligar");
        Turbina instance = new Turbina();
        instance.ligar();
        boolean expResult = true;
        boolean result = instance.isLigado();
        assertEquals(expResult, result);
        assertEquals(5, instance.getNivelPotencia());
        
    }

    /**
     * Test of desligar method, of class Turbina.
     */
    @Test
    public void testDesligar() {
        System.out.println("desligar");
        Turbina instance = new Turbina();
        instance.ligar();
        instance.desligar();
        boolean expResult = false;
        boolean result = instance.isLigado();
        assertEquals(expResult, result);
        assertEquals(0, instance.getNivelPotencia());

    }

    /**
     * Test of aumentarPotencia method, of class Turbina.
     */
    @Test
    public void testAumentarPotencia() throws DesligadoException {
        System.out.println("aumentarPotencia");
        Turbina instance = new Turbina();
        instance.ligar();
        instance.aumentarPotencia(10);
        assertEquals(15, instance.getNivelPotencia());
        instance.aumentarPotencia(300);
        assertEquals(100, instance.getNivelPotencia());
    }
    
    @Test(expected = DesligadoException.class)
    public void testAumentarPotenciaDesligado() throws DesligadoException {
        System.out.println("aumentarPotencia");
        Turbina instance = new Turbina();
        instance.aumentarPotencia(10);
        
    }
    
    /**
     * Test of aumentarPotencia method, of class Turbina.
     */
    @Test
    public void testAumentarPotenciaNegativa() throws DesligadoException {
        System.out.println("AumentarPotenciaNegativa");
        //
        Turbina instance2 = new Turbina();
        instance2.ligar();
        instance2.aumentarPotencia(-15);
        assertEquals(5, instance2.getNivelPotencia());
    }

    /**
     * Test of diminuirPotencia method, of class Turbina.
     */
    @Test
    public void testDiminuirPotencia() throws DesligadoException {
        System.out.println("DiminuirPotencia");
        Turbina instance = new Turbina();
        
        instance.ligar();
        instance.diminuirPotencia(1);
        assertEquals(4, instance.getNivelPotencia());
        instance.diminuirPotencia(10);
        assertEquals(0, instance.getNivelPotencia());
    }
    
    /**
     * Test of diminuirPotencia method, of class Turbina.
     */
    @Test
    public void testDiminuirPotenciaNegativa() throws DesligadoException {
        System.out.println("diminuirPotencia");
        
        //
        Turbina instance2 = new Turbina();
        instance2.ligar();
        instance2.diminuirPotencia(-1);
        assertEquals(5, instance2.getNivelPotencia());
    }

    /**
     * Test of getNivelPotencia method, of class Turbina.
     */
    @Test
    public void testGetNivelPotencia() {
        System.out.println("getNivelPotencia");
        Turbina instance = new Turbina();
        int expResult1 = 0;
        int result1 = instance.getNivelPotencia();
        assertEquals(expResult1, result1);
        instance.ligar();
        int expResult2 = 5;
        int result2 = instance.getNivelPotencia();
        assertEquals(expResult2, result2);
    }
    
}
