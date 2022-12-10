/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package customersshoppingcart;

import HomePages.CustomerHomePage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nicholasgiacobbe
 */
public class ShoppingCartTest {
    
    public ShoppingCartTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of backAction method, of class ShoppingCart.
     */
    @Test
    public void testBackAction() {
        System.out.println("backAction");
        ArrayList<Item> shoppingCart = null;
        CustomerHomePage home = null;
        ShoppingCart instance = null;
        ActionListener expResult = null;
        ActionListener result = instance.backAction(shoppingCart, home);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkOutAction method, of class ShoppingCart.
     */
    @Test
    public void testCheckOutAction() {
        System.out.println("checkOutAction");
        ArrayList<Item> tempCart = null;
        CustomerHomePage home = null;
        HashMap<String, Integer> cartQuantity = null;
        ShoppingCart instance = null;
        ActionListener expResult = null;
        ActionListener result = instance.checkOutAction(tempCart, home, cartQuantity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePrice method, of class ShoppingCart.
     */
    @Test
    public void testUpdatePrice() {
        System.out.println("updatePrice");
        ShoppingCart instance = null;
        instance.updatePrice();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of repaintPriceValue method, of class ShoppingCart.
     */
    @Test
    public void testRepaintPriceValue() {
        System.out.println("repaintPriceValue");
        ShoppingCart instance = null;
        instance.repaintPriceValue();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
