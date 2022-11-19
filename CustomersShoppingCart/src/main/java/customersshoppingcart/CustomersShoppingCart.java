/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package customersshoppingcart;

import HomePages.CustomerHomePage;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author fruda
 */
public class CustomersShoppingCart {

    //Will contain all items read from file
    public ArrayList<Item> tempArray = new ArrayList<>();
    
    //TODO: replace with file output stream
    //each Item will read data from the file and create an new instance
    //then store it into an array
    
//    for(int i = 0; i < fileLineLength; i++) {
//        Item x = new Item(...);
//        tempArray.add(x);
//    }
    //dummy items - remove lated
    Item banana = new Item(1, "banana", "this is a banana", 1.25, 10);
    Item orange = new Item(1, "orange", "this is an orange", 2.25, 15);
    Item kiwi = new Item(1, "kiwi", "this is a kiwi", 0.75, 32);
    Item apple = new Item(1, "apple", "this is an apple", 1.99, 6);
    
    public CustomersShoppingCart() {
        //Add in items from file
        tempArray.add(banana);
        tempArray.add(orange);
        tempArray.add(kiwi);
        tempArray.add(apple);
    }
    
    
    public static void main(String[] args) {
        CustomersShoppingCart customer = new CustomersShoppingCart();
        CustomerHomePage window = new CustomerHomePage(customer.tempArray);
        window.setSize(500,500);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
