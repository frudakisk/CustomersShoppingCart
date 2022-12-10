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
public class UsersTest {
    
    public UsersTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of addCreditCard method, of class Users.
     */
    @Test
    public void testAddCreditCard() {
        System.out.println("addCreditCard");
        int ccn = 0;
        Users instance = null;
        instance.addCreditCard(ccn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreditCard method, of class Users.
     */
    @Test
    public void testGetCreditCard() {
        System.out.println("getCreditCard");
        Users instance = null;
        int expResult = 0;
        int result = instance.getCreditCard();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verifyId method, of class Users.
     */
    @Test
    public void testVerifyId() {
        System.out.println("verifyId");
        String username = "";
        String password = "";
        Users instance = null;
        boolean expResult = false;
        boolean result = instance.verifyId(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
