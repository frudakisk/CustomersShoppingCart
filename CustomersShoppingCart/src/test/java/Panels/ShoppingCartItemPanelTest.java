/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Panels;

import customersshoppingcart.Item;
import customersshoppingcart.ShoppingCart;
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
public class ShoppingCartItemPanelTest {
    
    public ShoppingCartItemPanelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of incrementCartItem method, of class ShoppingCartItemPanel.
     */
    @Test
    public void testIncrementCartItem() {
        System.out.println("incrementCartItem");
        ArrayList<Item> shoppingCart = null;
        Item item = null;
        HashMap<String, Integer> cartQuantity = null;
        ShoppingCart home = null;
        ShoppingCartItemPanel instance = null;
        ActionListener expResult = null;
        ActionListener result = instance.incrementCartItem(shoppingCart, item, cartQuantity, home);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decrementCartItem method, of class ShoppingCartItemPanel.
     */
    @Test
    public void testDecrementCartItem() {
        System.out.println("decrementCartItem");
        ArrayList<Item> shoppingCart = null;
        Item item = null;
        HashMap<String, Integer> cartQuantity = null;
        ShoppingCart home = null;
        ShoppingCartItemPanel currentPanel = null;
        ShoppingCartItemPanel instance = null;
        ActionListener expResult = null;
        ActionListener result = instance.decrementCartItem(shoppingCart, item, cartQuantity, home, currentPanel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
