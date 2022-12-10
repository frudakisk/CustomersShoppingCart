/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package HomePages;

import customersshoppingcart.Item;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nicholasgiacobbe
 */
public class CustomerHomePageTest {
    
    public CustomerHomePageTest() {
    }

    /**
     * @throws Exception
     */
    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }
    



    /**
     * Test of getCart method, of class CustomerHomePage.
     */
    @org.junit.Test
    public void testGetCart() {
        System.out.println("getCart");
        CustomerHomePage instance = null;
        ArrayList<Item> expResult = null;
        ArrayList<Item> result = instance.getCart();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCart method, of class CustomerHomePage.
     */
    @org.junit.Test
    public void testSetCart() {
        System.out.println("setCart");
        ArrayList<Item> newCart = null;
        CustomerHomePage instance = null;
        instance.setCart(newCart);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPriceShoppingCartPanel method, of class CustomerHomePage.
     */
    @org.junit.Test
    public void testSetPriceShoppingCartPanel() {
        System.out.println("setPriceShoppingCartPanel");
        ArrayList<Item> cart = null;
        CustomerHomePage instance = null;
        instance.setPriceShoppingCartPanel(cart);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
