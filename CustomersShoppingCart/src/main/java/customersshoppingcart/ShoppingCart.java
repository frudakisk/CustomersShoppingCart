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
 * edit information in the shopping cart (add & remove items)
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
        shoppingCart = cart;
        //update the pricelabel
        updatePrice();
        repaintPriceValue();
        
        
        //Settiing up the north panel
        northPanel.setLayout(new GridLayout(1,3));
        northPanel.add(backButton);
        northPanel.add(title);
        northPanel.add(checkOutButton);
        
        //add button action listeners
        backButton.addActionListener(backAction(shoppingCart, home));
        checkOutButton.addActionListener(checkOutAction());
        
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
        //this is just getting an item in the shopping cart
        //and turning it int a String arraylist w no repeating items
        //we also make one new attributes - total - which is price*quantity in cart
//        Set<ArrayList<String>> data = new HashSet<>();
//        for(int i = 0; i < shoppingCart.size(); i++) {
//            ArrayList<String> temp = new ArrayList<>();
//            
//            Item product = shoppingCart.get(i);
//            double total = product.getPrice() * cartQuantity.get(product.getName());
//            String totalString = Double.toString(total);
//            int quantity = cartQuantity.get(product.getName());
//            String quantityString = Integer.toString(quantity);
//            int storeMaxQuantity = product.getQuantity();
//            String storeMaxQuantityString = Integer.toString(storeMaxQuantity);
//            temp.add(product.getName());
//            temp.add(totalString);
//            temp.add(quantityString);
//            temp.add(storeMaxQuantityString);
//            
//            //add to set - no repeats
//            data.add(temp);
//        }
        
        
        //System.out.println("Hash Map before going to SCIP: " + cartQuantity);
        Set<Item> itemData = new HashSet<>();
        for(int i = 0; i < shoppingCart.size(); i++) {
            itemData.add(shoppingCart.get(i));
        }
        
        System.out.println("This is the item data: " + itemData);
        //iterate through the set!!!!!
        System.out.println("This is the item in itemData: " + itemData);
        
//        //loading up the center panel the right way
//        centerPanel.setLayout(new GridLayout(cartQuantity.size(),1));
//        for(int i = 0; i < itemData.size(); i++) {
//           ShoppingCartItemPanel itemPanel = new ShoppingCartItemPanel(shoppingCart, itemData[i], cartQuantity);
//            centerPanel.add(itemPanel);
//        }
        centerPanel.setLayout(new GridLayout(cartQuantity.size(), 1));
        Iterator value = itemData.iterator();
        while(value.hasNext()) {
            ShoppingCartItemPanel itemPanel = new ShoppingCartItemPanel(shoppingCart, (Item) value.next(), 
                    cartQuantity, this);
            centerPanel.add(itemPanel);
        }

        //loading up the south panel
        //totalPriceLabel.setText("Total: $0.00");
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
                Checkout Checkout = new Checkout();
                Checkout.setSize(500,500);
                Checkout.setVisible(true);
                Checkout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    
    public void repaintPriceValue(){
        String priceSumString = Double.toString(priceSum);
        totalPriceLabel.setText("$" + priceSumString);
        totalPriceLabel.repaint();
    }
    
}
