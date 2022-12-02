/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customersshoppingcart;

import HomePages.CustomerHomePage;
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
    
    //add in local components
    private JButton backButton = new JButton("< Back");
    private JButton checkOutButton = new JButton("Checkout >");
    private JLabel title = new JLabel("Shopping Cart");
    
 
    /***
     * Constructor for ShoppingCart class
     */
    public ShoppingCart(ArrayList<Item> cart, CustomerHomePage home) {
        super("Shopping Cart");
        //add content to shopping cart
        shoppingCart = cart;
        
        
        //Settiing up the north panel
        northPanel.setLayout(new GridLayout(1,3));
        northPanel.add(backButton);
        northPanel.add(title);
        northPanel.add(checkOutButton);
        
        //add button action listeners
        backButton.addActionListener(backAction(shoppingCart, home));
        
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
        this.getContentPane().add("North", northPanel);
    }
    
    /***
     * action to return to the parent frame
     * @return al - the action
     */
    public ActionListener backAction(ArrayList<Item> shoppingCart, CustomerHomePage home) {
        ActionListener al;
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //code here
                dispose();
                CustomerHomePage customerHomePage = new CustomerHomePage(home.itemsArray);
                customerHomePage.setCart(shoppingCart);
                System.out.println("Cart after setCart: " + customerHomePage.tempCart);
                //remember the cart information
                //customerHomePage.setPriceShoppingCartPanel(shoppingCart);
                //customerHomePage.repaint();
                customerHomePage.setSize(500,500);
                customerHomePage.setVisible(true);
                customerHomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
            
        };
        return al;
    }
    
    /***
     * action to flow to the checkout page
     * @return al - the action
     */
        public ActionListener checkOutAction() {
        ActionListener al;
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //code here
            }
            
        };
        return al;
    }
    
}
