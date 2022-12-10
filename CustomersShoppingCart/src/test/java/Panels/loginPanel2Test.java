/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Panels;

import customersshoppingcart.Users;
import java.awt.event.FocusListener;
import javax.swing.JTextField;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nicholasgiacobbe
 */
public class loginPanel2Test {
    
    public loginPanel2Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getLoginSuccess method, of class loginPanel2.
     */
    @Test
    public void testGetLoginSuccess() {
        System.out.println("getLoginSuccess");
        loginPanel2 instance = null;
        boolean expResult = false;
        boolean result = instance.getLoginSuccess();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentUser method, of class loginPanel2.
     */
    @Test
    public void testGetCurrentUser() {
        System.out.println("getCurrentUser");
        loginPanel2 instance = null;
        Users expResult = null;
        Users result = instance.getCurrentUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of placeholderText method, of class loginPanel2.
     */
    @Test
    public void testPlaceholderText() {
        System.out.println("placeholderText");
        String text = "";
        JTextField field = null;
        loginPanel2 instance = null;
        FocusListener expResult = null;
        FocusListener result = instance.placeholderText(text, field);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
