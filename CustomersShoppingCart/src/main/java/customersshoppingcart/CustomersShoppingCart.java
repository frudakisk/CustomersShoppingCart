/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package customersshoppingcart;

import HomePages.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import loginPage.*;

/**
 * This is the main file for this application
 * @author fruda
 */
public class CustomersShoppingCart {

    //Will contain all items read from file
    public ArrayList<Item> itemArray = new ArrayList<>();
    
    /***
     * Constructor for CustomersShoppingCart page
     */
    public CustomersShoppingCart() {
        //Add in items from file
        itemArray = readFile();
    }
    
    /***
     * Reads items.txt file
     * @return An ArrayList(Item) that will contain all objects from the items.txt file
     */
    private ArrayList<Item> readFile() {
        ArrayList<Item> itemTemp = new ArrayList<>();
        try
        {
            FileInputStream fis = new FileInputStream("items.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
 
            itemTemp = (ArrayList) ois.readObject();
            
            ois.close();
            fis.close();
            
        } 
        catch (IOException ioe) 
        {
            System.out.println("Error in readFile");
            ioe.printStackTrace();
          
        } 
        catch (ClassNotFoundException c) 
        {
            System.out.println("Class not found");
            c.printStackTrace();
     
        }
        return itemTemp;
    }
    
    
    /***
     * main function for running application
     * @param args 
     */
    public static void main(String[] args) {
        CustomersShoppingCart customer = new CustomersShoppingCart();
        CustomerHomePage customerHomePage = new CustomerHomePage(customer.itemArray);
        SellerHomePage sellerHomePage = new SellerHomePage(customer.itemArray);
        boolean loginsuc=false;
        loginPage loginPage = new loginPage();
        JFrame window = loginPage;
        window.setSize(500,500);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while(!loginsuc){
            if (loginPage.getLoginPanel().getLoginSuccess()){
                window.dispose();
                if(loginPage.getLoginPanel().getCurrentUser().userStatus){
                    window = sellerHomePage;
                }
                else if(!loginPage.getLoginPanel().getCurrentUser().userStatus){
                    window = customerHomePage;
                }
                window.setSize(500,500);
                window.setVisible(true);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                loginsuc = true;
            }
        }
    }
}
