/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panels;

import HomePages.CustomerHomePage;
import customersshoppingcart.Item;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import customersshoppingcart.ShoppingCart;
import java.util.ArrayList;

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

    
    
    public Checkout(ArrayList<Item> tempCart, CustomerHomePage home) {
        
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
        continueButton.addActionListener(continueButtonAction());
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
    
    private ActionListener continueButtonAction() {
        ActionListener al;
        al = new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Will display customer receipt");
            }
        };
        return al;
    }

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

    
    //testing purposes
    //public static void main(String args[]) {
    //    Checkout frame = new Checkout();
    //}
}







