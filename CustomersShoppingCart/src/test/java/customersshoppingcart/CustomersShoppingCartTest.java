/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package customersshoppingcart;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nicholasgiacobbe
 */
public class CustomersShoppingCartTest {
    
    public CustomersShoppingCartTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of addItemToFile method, of class CustomersShoppingCart.
     */
    @Test
    public void testAddItemToFile() {
        System.out.println("addItemToFile");
        CustomersShoppingCart instance = new CustomersShoppingCart();
        instance.addItemToFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class CustomersShoppingCart.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        CustomersShoppingCart.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
