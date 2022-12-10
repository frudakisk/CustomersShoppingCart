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
import Panels.Checkout;

/**
 * This class is for the shopping cart object of the project. This is where
 * the customer will store items that they wish to purchase. Customer can also
 * edit information in the shopping cart (add and remove items)
 * @author fruda
 */
public class ShoppingCart extends JFrame{
    
    //will hold items in the customers shopping cart (subset of all items in store)
    public ArrayList<Item> shoppingCart;
    //private JTable compressedCart;
    private HashMap<String, Integer> cartQuantity = new HashMap<>();
    private double priceSum;
    
    //add in components for layout
    private JPanel northPanel = new JPanel();
    private JPanel centerPanel = new JPanel();
    private JPanel southPanel = new JPanel();
    
    //add in local components for north panel
    private JButton backButton = new JButton("< Back");
    private JButton checkOutButton = new JButton("Checkout >");
    private JLabel title = new JLabel("Shopping Cart");
    
    //add in local components for south panel
    private JLabel totalPriceLabel = new JLabel();
    
    
 
    /***
     * Constructor for ShoppingCart class
     * @param cart The items currently in the customers cart (subset of store inventory)
     * @param home The home screen that spawns the shoppingCart frame
     */
    public ShoppingCart(ArrayList<Item> cart, CustomerHomePage home) {
        super("Shopping Cart");
        //add content to shopping cart
        this.shoppingCart = cart;
        //update the pricelabel
        updatePrice();
        repaintPriceValue();
        
        
        //Settiing up the north panel
        northPanel.setLayout(new GridLayout(1,3));
        northPanel.add(backButton);
        northPanel.add(title);
        northPanel.add(checkOutButton);
        
        
        //load the hashmap with shoppingCart content everytime we load this page
        for(int i = 0; i < shoppingCart.size(); i++) {
            if(!cartQuantity.containsKey(shoppingCart.get(i).getName())) {
                cartQuantity.put(shoppingCart.get(i).getName(), 1);
            } else {
                String name = shoppingCart.get(i).getName();
                int newQuantity = cartQuantity.get(name) + 1;
                cartQuantity.put(name, newQuantity);
            }
        }
        
        
        //add button action listeners
        backButton.addActionListener(backAction(shoppingCart, home));
        checkOutButton.addActionListener(checkOutAction(cart, home, cartQuantity)); 
        
        
        //using a set to create unique list of shopping cart items of type Item
        //each item should show once in the shopping cart screen
        //and have an associated quantity with them
        Set<Item> itemData = new HashSet<>();
        for(int i = 0; i < shoppingCart.size(); i++) {
            itemData.add(shoppingCart.get(i));
        }

        //loading up the center panel 
        //provides the shallow copy of shoppingCart, current Item from set,
        //shallow copy of the HashMap, and this page so that we can update south
        //panel priceLabel
        centerPanel.setLayout(new GridLayout(cartQuantity.size(), 1));
        Iterator value = itemData.iterator();
        while(value.hasNext()) {
            ShoppingCartItemPanel itemPanel = new ShoppingCartItemPanel(shoppingCart, (Item) value.next(), 
                    cartQuantity, this);
            centerPanel.add(itemPanel);
        }

        //loading up the south panel
        southPanel.add(totalPriceLabel);
        
        //testing purposes only - wil delete later
        System.out.println("Showing ShoppingCart Frame arraylist");
        for(int i = 0; i < shoppingCart.size(); i++) {
            System.out.println(shoppingCart.get(i));
        }
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add("Center", centerPanel);
        this.getContentPane().add("North", northPanel);
        this.getContentPane().add("South", southPanel);
    }
    
    /***
     * action to return to the parent frame
     * @param shoppingCart the information about the shopping cart needs to be
     * returned to the parent JFrame
     * @param home the parent JFrame that needs to be updated with the new information
     * after this action is performed
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
     * @param tempCart Passes the item placed in the shopping cart to the checkout frame 
     * @param home the home screen that spawns the shoppingCart frame
     * @param cartQuantity Passes the amount placed in the shopping cart to the checkout frame 
     * @return al - the action
     */
        public ActionListener checkOutAction(ArrayList<Item> tempCart, CustomerHomePage home, HashMap<String, Integer> cartQuantity) {
        ActionListener al;
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //code here
                if(!tempCart.isEmpty()){
                    dispose();
                    Checkout Checkout = new Checkout(tempCart, home, cartQuantity);
                    Checkout.setSize(500,500);
                    Checkout.setVisible(true);
                    Checkout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } else {
                    JOptionPane.showMessageDialog(null, "Nothing in Cart!");
                }

            }
            
        };
        return al;
    }
        
    /***
     * Updates the totalPriceLabel with the most current total in the cart
     * each time the ShoppingCart frame is called
     */
    public void updatePrice() {
        priceSum = 0;
        for(int i = 0; i < shoppingCart.size(); i++){
            priceSum += shoppingCart.get(i).getPrice();
        }
        System.out.println("Total Price is: " + priceSum);
    }
    
    /***
     * repaints the totalPriceLabel value each time it is called
     */
    public void repaintPriceValue(){
        String priceSumString = Double.toString(priceSum);
        totalPriceLabel.setText("$" + priceSumString);
        totalPriceLabel.repaint();
    }
    
}
