/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Panels;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nicholasgiacobbe
 */
public class PriceShoppingCartPanelTest {
    
    public PriceShoppingCartPanelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of repaintPriceValue method, of class PriceShoppingCartPanel.
     */
    @Test
    public void testRepaintPriceValue() {
        System.out.println("repaintPriceValue");
        PriceShoppingCartPanel instance = null;
        instance.repaintPriceValue();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCart method, of class PriceShoppingCartPanel.
     */
    @Test
    public void testUpdateCart() {
        System.out.println("updateCart");
        PriceShoppingCartPanel instance = null;
        instance.updateCart();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPriceSum method, of class PriceShoppingCartPanel.
     */
    @Test
    public void testGetPriceSum() {
        System.out.println("getPriceSum");
        PriceShoppingCartPanel instance = null;
        double expResult = 0.0;
        double result = instance.getPriceSum();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
