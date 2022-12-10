/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package customersshoppingcart;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nicholasgiacobbe
 */
public class ItemTest {
    
    public ItemTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of updateId method, of class Item.
     */
    @Test
    public void testUpdateId() {
        System.out.println("updateId");
        int id = 0;
        Item instance = null;
        instance.updateId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePrice method, of class Item.
     */
    @Test
    public void testUpdatePrice() {
        System.out.println("updatePrice");
        double newPrice = 0.0;
        Item instance = null;
        instance.updatePrice(newPrice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateQuantity method, of class Item.
     */
    @Test
    public void testUpdateQuantity() {
        System.out.println("updateQuantity");
        int newQuantity = 0;
        Item instance = null;
        instance.updateQuantity(newQuantity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateQuantitySold method, of class Item.
     */
    @Test
    public void testUpdateQuantitySold() {
        System.out.println("updateQuantitySold");
        int newSold = 0;
        Item instance = null;
        instance.updateQuantitySold(newSold);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateName method, of class Item.
     */
    @Test
    public void testUpdateName() {
        System.out.println("updateName");
        String newName = "";
        Item instance = null;
        instance.updateName(newName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateDescription method, of class Item.
     */
    @Test
    public void testUpdateDescription() {
        System.out.println("updateDescription");
        String newDescription = "";
        Item instance = null;
        instance.updateDescription(newDescription);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateImage method, of class Item.
     */
    @Test
    public void testUpdateImage() {
        System.out.println("updateImage");
        String newImage = "";
        Item instance = null;
        instance.updateImage(newImage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemId method, of class Item.
     */
    @Test
    public void testGetItemId() {
        System.out.println("getItemId");
        Item instance = null;
        int expResult = 0;
        int result = instance.getItemId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Item.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Item instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of description method, of class Item.
     */
    @Test
    public void testDescription() {
        System.out.println("description");
        Item instance = null;
        String expResult = "";
        String result = instance.description();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class Item.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Item instance = null;
        double expResult = 0.0;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantity method, of class Item.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        Item instance = null;
        int expResult = 0;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantitySold method, of class Item.
     */
    @Test
    public void testGetQuantitySold() {
        System.out.println("getQuantitySold");
        Item instance = null;
        int expResult = 0;
        int result = instance.getQuantitySold();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImageFileLocation method, of class Item.
     */
    @Test
    public void testGetImageFileLocation() {
        System.out.println("getImageFileLocation");
        Item instance = null;
        String expResult = "";
        String result = instance.getImageFileLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Item.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Item instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toArrayList method, of class Item.
     */
    @Test
    public void testToArrayList() {
        System.out.println("toArrayList");
        Item instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.toArrayList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
