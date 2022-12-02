/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customersshoppingcart;

import Panels.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.swing.*;

/**
 * This class is for the shopping cart object of the project. This is where
 * the customer will store items that they wish to purchase. Customer can also
 * edit information in the shopping cart (add & remove items)
 * @author fruda
 */
public class ShoppingCart extends JFrame{
    
    //will hold items in shopping cart
    public ArrayList<Item> shoppingCart;
    //private JTable compressedCart;
    private HashMap<String, Integer> cartQuantity = new HashMap<>();
    
    //add in components for layout
    private JPanel northPanel = new JPanel();
    private JPanel centerPanel = new JPanel();
 
    /***
     * Constructor for ShoppingCart class
     */
    public ShoppingCart(ArrayList<Item> cart) {
        super("Shopping Cart");
        //add content to shopping cart
        shoppingCart = cart;
        
        //load the hashmap with shoppingCart content
        for(int i = 0; i < shoppingCart.size(); i++) {
            if(!cartQuantity.containsKey(shoppingCart.get(i).getName())) {
                cartQuantity.put(shoppingCart.get(i).getName(), 1);
            } else {
                String name = shoppingCart.get(i).getName();
                int newQuantity = cartQuantity.get(name) + 1;
                cartQuantity.put(name, newQuantity);
            }
        }
            
        //setup data for the center panel
        Set<ArrayList<String>> data = new HashSet<>();
        for(int i = 0; i < shoppingCart.size(); i++) {
            ArrayList<String> temp = new ArrayList<>();
            
            Item product = shoppingCart.get(i);
            double total = product.getPrice() * cartQuantity.get(product.getName());
            String totalString = Double.toString(total);
            int quantity = cartQuantity.get(product.getName());
            String quantityString = Integer.toString(quantity);
            temp.add(product.getName());
            temp.add(totalString);
            temp.add(quantityString);
            //create the cell with the information
            
            //add to set - no repeats
            data.add(temp);
        }
        
        //loading up the center panel
        centerPanel.setLayout(new GridLayout(cartQuantity.size(),1));
        Iterator value = data.iterator();
        while(value.hasNext()) {
            ShoppingCartItemPanel itemPanel = new ShoppingCartItemPanel((ArrayList<String>) value.next());
            centerPanel.add(itemPanel);
        }
        
        //testing purposes only - wil delete later
        System.out.println("Showing ShoppingCart Frame arraylist");
        for(int i = 0; i < shoppingCart.size(); i++) {
            System.out.println(shoppingCart.get(i));
        }
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add("Center", centerPanel);
    }
    
}
