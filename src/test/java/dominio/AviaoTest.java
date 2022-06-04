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

import java.lang.reflect.Field;
import java.util.List;

/**
 *
 * @author inf323
 */
public class AviaoTest {
    
    public AviaoTest() {
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
     * Test of ligarTurbinas method, of class Aviao.
     */
    @Test
    public void testLigarTurbinas() {
        System.out.println("ligarTurbinas");
        Aviao instance = new Aviao();
        // Turbina n�o liga sem combust�vel!!
        boolean expResult = false;
        instance.ligarTurbinas();
        boolean result = instance.isTurbinasLigadas();
        assertEquals(expResult, result);
        assertEquals(0, instance.nivelPotenciaTurbinas());
       //
        instance.abastecer(1.0);
        instance.ligarTurbinas();
        assertEquals(true, instance.isTurbinasLigadas());
        assertEquals(5, instance.nivelPotenciaTurbinas());
    }

    /**
     * Test of desligarTurbinas method, of class Aviao.
     */
    @Test
    public void testDesligarTurbinas() {
        System.out.println("desligarTurbinas");
        Aviao instance = new Aviao();
        instance.ligarTurbinas();
        instance.desligarTurbinas();
        boolean expResult = false;
        boolean result = instance.isTurbinasLigadas();
        assertEquals(expResult, result);
        assertEquals(0, instance.nivelPotenciaTurbinas());
    }

    /**
     * Test of isTurbinasLigadas method, of class Aviao.
     */
    @Test
    public void testIsTurbinasLigadas() {
        System.out.println("isTurbinasLigadas");
        Aviao instance = new Aviao();
        boolean expResult = false;
        boolean result = instance.isTurbinasLigadas();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of nivelPotenciaTurbinas method, of class Aviao.
     */
    @Test
    public void testNivelPotenciaTurbinas() {
        System.out.println("nivelPotenciaTurbinas");
        Aviao instance = new Aviao();
        int expResult = 0;
        int result = instance.nivelPotenciaTurbinas();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of aumentarPotenciaTurbinas method, of class Aviao.
     */
    @Test
    public void testAumentarPotenciaTurbinas() {
        System.out.println("aumentarPotenciaTurbinas");
        Aviao instance = new Aviao();
        instance.aumentarPotenciaTurbinas();
        int expResult = 0;
        int result = instance.nivelPotenciaTurbinas();
        assertEquals(expResult, result);
        //
        instance.abastecer(1.0);
        instance.ligarTurbinas();
        instance.aumentarPotenciaTurbinas();
        assertEquals(10, instance.nivelPotenciaTurbinas());
    }
    
    /**
     * Test of aumentarPotenciaTurbinas method, of class Aviao.
     */
    @Test
    public void testLimiteMaximoPotenciaTurbinas() {
        System.out.println("LimiteMaximoPotenciaTurbinas");
        Aviao instance = new Aviao();
        instance.abastecer(1.0);
        instance.ligarTurbinas();

        for(int i=0; i < 30; i++)
        {
        	instance.aumentarPotenciaTurbinas();
        }
        
        assertEquals(100, instance.nivelPotenciaTurbinas());
    }

    /**
     * Test of diminuirPotenciaTurbinas method, of class Aviao.
     */
    @Test
    public void testDiminuirPotenciaTurbinas() {
        System.out.println("diminuirPotenciaTurbinas");
        Aviao instance = new Aviao();
        instance.diminuirPotenciaTurbinas();
        int expResult = 0;
        int result = instance.nivelPotenciaTurbinas();
        assertEquals(expResult, result);
        //
        instance.abastecer(1.0);
        instance.ligarTurbinas();
        instance.aumentarPotenciaTurbinas();
        instance.diminuirPotenciaTurbinas();
        assertEquals(5, instance.nivelPotenciaTurbinas());
    }
    
    /**
     * Test of diminuirPotenciaTurbinas method, of class Aviao.
     */
    @Test
    public void testLimiteMinimoPotenciaTurbinas() {
        System.out.println("LimiteMinimoPotenciaTurbinas");
        Aviao instance = new Aviao();
        instance.abastecer(1.0);
        instance.ligarTurbinas();
        instance.aumentarPotenciaTurbinas();
        for(int i=0; i < 4; i++)
        {
        	instance.diminuirPotenciaTurbinas();
        }
        assertEquals(0, instance.nivelPotenciaTurbinas());
    }
    
    /**
     * Test of turbinas, of class Aviao.
     */
    @SuppressWarnings("unchecked")
	@Test
    public void testQtdTurbinas() {
        System.out.println("diminuirPotenciaTurbinas");
        Aviao instance = new Aviao();
        int expResult = 2;
        
        try {
        	Field fdLsTurbina = instance.getClass().getDeclaredField("lsTurbinas");
        	fdLsTurbina.setAccessible(true);
        	List<Turbina> lsTurbinas = (List<Turbina>) fdLsTurbina.get(instance);
        	int result = lsTurbinas.size();
        	assertEquals(expResult, result);

		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
    }

    /**
     * Test of abastecer method, of class Aviao.
     */
    @Test
    public void testAbastecer() {
        System.out.println("abastecer");
        double value = 1.0;
        Aviao instance = new Aviao();
        instance.abastecer(value);
        assertEquals(value, instance.getQntdAtualCombustivel(), 0.0);
        
        double value2 = 10000.0;
        instance.abastecer(value2);
        assertEquals(instance.getCapacidadeTotalCombustivel(), instance.getQntdAtualCombustivel(), 0.0);
    }

    /**
     * Test of consumir method, of class Aviao.
     */
    @Test
    public void testConsumir() {
        System.out.println("consumir");
        double value = 50.0;
        Aviao instance = new Aviao();
        instance.consumir(value);
        assertEquals(0, instance.getQntdAtualCombustivel(), 0.0);
        //
        double value2 = 90.0;
        instance.abastecer(value2);
        instance.consumir(value);
        assertEquals(40, instance.getQntdAtualCombustivel(), 0.0);
        //
        instance.consumir(value);
        assertEquals(0, instance.getQntdAtualCombustivel(), 0.0); 
    }

    /**
     * Test of getCapacidadeTotalCombustivel method, of class Aviao.
     */
    @Test
    public void testGetCapacidadeTotalCombustivel() {
        System.out.println("getCapacidadeTotalCombustivel");
        Aviao instance = new Aviao();
        double expResult = 1000;
        double result = instance.getCapacidadeTotalCombustivel();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getQntdAtualCombustivel method, of class Aviao.
     */
    @Test
    public void testGetQntdAtualCombustivel() {
        System.out.println("getQntdAtualCombustivel");
        Aviao instance = new Aviao();
        double expResult = 0.0;
        double result = instance.getQntdAtualCombustivel();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of carregarCarga method, of class Aviao.
     */
    @Test
    public void testCarregarCarga() {
        System.out.println("carregarCarga");
        int value = 100;
        Aviao instance = new Aviao();
        instance.carregarCarga(value);
        assertEquals(value, instance.getQntdAtualCarga(), 0.1);
        //
        int value2 = 1000;
        instance.carregarCarga(value2);
        assertEquals(value, instance.getQntdAtualCarga(), 0.1);
    }
    
    /**
     * Test of descarregarCarga method, of class Aviao.
     */
    @Test
    public void testDescarregarCarga() {
        System.out.println("descarregarCarga");
        int value = 10;
        Aviao instance = new Aviao();
        instance.descarregarCarga(value);
        assertEquals(0, instance.getQntdAtualCarga(), 0.1);
        //
        instance.carregarCarga(200);
        int value2 = 100;
        instance.descarregarCarga(value2);
        assertEquals(100, instance.getQntdAtualCarga(), 0.1);
        //
        instance.descarregarCarga(value2);
        assertEquals(0, instance.getQntdAtualCarga(), 0.1);
    }

    /**
     * Test of getCapacidadeTotalCarga method, of class Aviao.
     */
    @Test
    public void testGetCapacidadeTotalCarga() {
        System.out.println("getCapacidadeTotalCarga");
        Aviao instance = new Aviao();
        int expResult = 1000;
        float result = instance.getCapacidadeTotalCarga();
        assertEquals(expResult, result, 0.1);
        
    }

    /**
     * Test of getQntdAtualCarga method, of class Aviao.
     */
    @Test
    public void testGetQntdAtualCarga() {
        System.out.println("getQntdAtualCarga");
        Aviao instance = new Aviao();
        int expResult = 0;
        float result = instance.getQntdAtualCarga();
        assertEquals(expResult, result, 0.1);
        
    }
    
}
