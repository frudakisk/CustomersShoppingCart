/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panels;

import HomePages.CustomerHomePage;
import HomePages.SellerHomePage;
import customersshoppingcart.CustomersShoppingCart;
import customersshoppingcart.Item;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import customersshoppingcart.ShoppingCart;
import java.util.ArrayList;
import java.util.HashMap;
import details.receipt;

/**
 * This class represents the JFrame form for the checkout process and payment.
 * @author Karl Hezel
 */
public class Checkout extends JFrame{
    
    
    //labels
    private JLabel title = new JLabel("Pay Now");
    private JLabel paymetLabel = new JLabel("Payment Method: ");
    private JLabel reviewLabel = new JLabel("Address: ");
    private JLabel cardLabel = new JLabel("      Credit/Debit card Number:     ");
    private JLabel cardNameLabel = new JLabel("      Name on Card:                        ");
    private JLabel cardExpirationLabel = new JLabel("      Expiration on the card:            ");
    private JLabel CVVLabel = new JLabel("      CVV: ");
    private JLabel zipcodeLabel = new JLabel("      Zipcode:                                  ");
    private JLabel AddressLabel = new JLabel("      Address");
    private JLabel cityLabel = new JLabel("      City");
    private JLabel stateLabel = new JLabel("      State");
    private JLabel AddresszipLabel = new JLabel("      Zipcode");
    
    // adding separator 
    JSeparator s = new JSeparator();
    JSeparator t = new JSeparator();
    JSeparator a = new JSeparator();
       
    //buttons
    private JButton cancelButton = new JButton("Back");
    private JButton continueButton = new JButton("Place your order");
    
    //textFields
    private JTextField cardField = new JTextField();
    private JTextField cardnameField = new JTextField();
    private JTextField cardexpirationField = new JTextField();
    private JTextField CVVField = new JTextField();
    private JTextField zipcodeField = new JTextField();
    private JTextField AddressField = new JTextField();
    private JTextField cityField = new JTextField();
    private JTextField stateField = new JTextField();
    private JTextField AddresszipField = new JTextField();
    
    //panels
    private JPanel northPanel = new JPanel();
    private JPanel centerPanel = new JPanel();
    private JPanel southPanel = new JPanel();
    private JPanel westPanel = new JPanel();
    private JPanel eastPanel = new JPanel();

    
    /***
     * Constructor for Checkout
     * @param tempCart the customers shopping cart
     * @param home the parent screen of this file
     * @param cartQuantity key:value pair for quantity of item in cart
     * @precondition tempCart is not null, cartQuantity is not empty
     * @postcondition a form for the customer to fill out is spawned
     */
    public Checkout(ArrayList<Item> tempCart, CustomerHomePage home, HashMap<String, Integer> cartQuantity) {
        
        super("Checkout");
       
        this.setLayout(new BorderLayout());
        
        //set up border panels


        //West Panel
        westPanel.setLayout(new GridLayout(0,2));
        westPanel.add(a);
        westPanel.add(paymetLabel);
        westPanel.add(cardLabel);
        westPanel.add(cardField);
        westPanel.add(cardNameLabel);
        westPanel.add(cardnameField);
        westPanel.add(cardExpirationLabel);
        westPanel.add(cardexpirationField);
        westPanel.add(CVVLabel);
        westPanel.add(CVVField);
        westPanel.add(zipcodeLabel);
        westPanel.add(zipcodeField);
        westPanel.add(s);
        westPanel.add(reviewLabel);
        westPanel.add(AddressLabel);
        westPanel.add(AddressField);
        westPanel.add(cityLabel);
        westPanel.add(cityField);
        westPanel.add(stateLabel);
        westPanel.add(stateField);
        westPanel.add(AddresszipLabel);
        westPanel.add(AddresszipField);

        //south Panel
        southPanel.setLayout(new GridLayout(1,2));
        southPanel.add(cancelButton);
        southPanel.add(continueButton);
        
        //set up button actions
        continueButton.addActionListener(continueButtonAction(tempCart, cartQuantity, home));
        cancelButton.addActionListener(cancelButtonAction(tempCart, home));
        
        //add panels to borderlayout
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add("North", northPanel);
        this.getContentPane().add("Center", centerPanel);
        this.getContentPane().add("South", southPanel);
        this.getContentPane().add("West", westPanel);
        this.getContentPane().add("East", eastPanel);
        
        this.setSize(500,450);
        this.setVisible(true);
    }
    
    /***
     * This action places your order. Store inventory is updated, and cart information
     * is cleared for new shopping experience
     * @param temp customers shopping cart
     * @param cartQuantity hash map that shows quantity of item in cart
     * @param home the screen to be redirected to 
     * @precondition temp and cartQuantity must be not empty
     * @postcondition store information is updated
     * @return returns the receipt frame
     */
    private ActionListener continueButtonAction(ArrayList<Item> temp, HashMap<String, Integer> cartQuantity, CustomerHomePage home) {
        ActionListener al;
        al = new ActionListener() {
            public void actionPerformed(ActionEvent e){
            
            CustomersShoppingCart inventory = new CustomersShoppingCart();
            ArrayList<Item> inv = inventory.itemArray;
            
            System.out.println("itemArray: " + inv);
            System.out.println("temp: " + temp);
            System.out.println("cartQuantity: " + cartQuantity);
            
            //updating the quantity in store - should be less than current quantity
            //updating quantitysold - should be greater than current
            for(int i = 0; i < inv.size(); i++) {
                if(cartQuantity.containsKey(inv.get(i).getName())) {
                    System.out.println("For item: " + inv.get(i).getName());
                    System.out.println("quantity before: " + inv.get(i).getQuantity());
                    System.out.println("quantity sold before: " + inv.get(i).getQuantitySold());
                    int currentQuantity = inv.get(i).getQuantity();
                    //update quantity left in store
                    inv.get(i).updateQuantity(currentQuantity - cartQuantity.get(inv.get(i).getName()));
                    //update quantity sold
                    int currentQuantitySold = inv.get(i).getQuantitySold();
                    inv.get(i).updateQuantitySold(currentQuantitySold + cartQuantity.get(inv.get(i).getName()));
                    System.out.println("quantity after: " + inv.get(i).getQuantity());
                    System.out.println("quantity sold after: " + inv.get(i).getQuantitySold());
                }
            }
            inventory.addItemToFile();
                
            //dispose the current checkout screen
            dispose();
            //bring up the receipt screen
            receipt receipt = new receipt(temp, cartQuantity, inv); //show new frame
            receipt.setSize(500,500);
            receipt.setVisible(true);
            //clear the shopping cart and update price panel
            temp.clear();
            cartQuantity.clear();   
            }
        };
        return al;
    }

    /***
     * This action cancels the transaction and returns you to the home page, which
     * should be the the shopping cart
     * @param tempCart the customers shopping cart
     * @param home parent frame - shopping cart
     * @precondition tempCart is not empty
     * @postcondition returned to home page
     * @return returns us to the home page of this frame
     */
    private ActionListener cancelButtonAction(ArrayList<Item> tempCart, CustomerHomePage home) {
        ActionListener al;
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                dispose(); //remove current frame
                ShoppingCart cart = new ShoppingCart(tempCart, home); //show new frame
                cart.setSize(500,500);
                cart.setVisible(true);
                cart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            }
        };
        return al;
    }
}