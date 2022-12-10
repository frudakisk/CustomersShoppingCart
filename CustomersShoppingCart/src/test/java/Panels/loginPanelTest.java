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
public class loginPanelTest {
    
    public loginPanelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getLoginSuccess method, of class loginPanel.
     */
    @Test
    public void testGetLoginSuccess() {
        System.out.println("getLoginSuccess");
        loginPanel instance = new loginPanel();
        boolean expResult = false;
        boolean result = instance.getLoginSuccess();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readFile method, of class loginPanel.
     */
    @Test
    public void testReadFile() {
        System.out.println("readFile");
        loginPanel instance = new loginPanel();
        instance.readFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addData method, of class loginPanel.
     */
    @Test
    public void testAddData() {
        System.out.println("addData");
        String username = "";
        String password = "";
        loginPanel instance = new loginPanel();
        instance.addData(username, password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of countLines method, of class loginPanel.
     */
    @Test
    public void testCountLines() {
        System.out.println("countLines");
        loginPanel instance = new loginPanel();
        instance.countLines();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logic method, of class loginPanel.
     */
    @Test
    public void testLogic() {
        System.out.println("logic");
        String usr = "";
        String pswd = "";
        loginPanel instance = new loginPanel();
        instance.logic(usr, pswd);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
