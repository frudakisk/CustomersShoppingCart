/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panels;

import customersshoppingcart.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import static javax.swing.SwingUtilities.getWindowAncestor;

/**
 * This class acts as a cell for items in the CustomerHomePage
 * @author fruda
 */
public class CustomerHomePageItemPanel extends JPanel{
    
    //Add in the items that will go into the panel
    private JLabel productName = new JLabel();
    private JLabel productPrice = new JLabel();
    private JLabel quantityField = new JLabel();
    private JLabel fakeImage = new JLabel("fakeImage");
    //private JImage ImageIcon = new JImage();
    public JButton addProductButton = new JButton("+");
    //TODO: change "..." to an image of a magnifying glass
    private JButton detailsButton = new JButton("...");
    
    //window ancestor
    //JFrame ancestor = (JFrame) getWindowAncestor(this);
    /***
     * Constructor for CustomerHomePageItemPanel. Grabs details from Item class
     * @param pn product name
     * @param price price of the item
     * @param quantity the quantity of an item in stock
     */
    public CustomerHomePageItemPanel(Item item, ArrayList<Item> tempCart) {
        //cart = tempCart;
        //if we manipulate cart, we manipulate tempCart
        //name price quantity
        //testing constructor methods
        //will most likely do this for all components bc reading from database
        this.productName.setText(item.getName());
        String priceString = Double.toString(item.getPrice());
        this.productPrice.setText(priceString);
        String quantityString = Integer.toString(item.getQuantity());
        this.quantityField.setText(quantityString);
        
        //Add action listeners to buttons
        addProductButton.addActionListener(addToShoppingCart(item, tempCart));
        detailsButton.addActionListener(itemDetailsAction());
        
        //set the layout
        setLayout(new GridLayout(1,6));
        
        //insert the items into the panel layout now
        add(fakeImage);//in placement for the image
        add(productName);
        add(productPrice);
        add(quantityField);
        add(addProductButton);
        add(detailsButton);
        
        
    }
    
    private ActionListener addToShoppingCart(Item item, ArrayList<Item> tempCart) {
        ActionListener al;
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //insert code here. refresh CustomerHomePage at end of action
                //don't worry about quantity yet
                tempCart.add(item);
                System.out.println("Looking at tempCart:");
                for(int i = 0; i < tempCart.size(); i++){                    
                    System.out.println(tempCart.get(i));
                }

            }
            
        };
        return al;
    }
    
    private ActionListener itemDetailsAction() {
        ActionListener al;
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //insert code here
            }
        };
        return al;
    }
    
    private ActionListener removeFromShoppingCart() {
        ActionListener al;
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //insert code here
            }
        };
        return al;
    }
    
}
