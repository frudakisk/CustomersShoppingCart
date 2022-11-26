/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panels;

import customersshoppingcart.Item;
import customersshoppingcart.ShoppingCart;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;


/**
 * This panel will hold the total cost of items in shopping cart
 * and a button to redirect to the shopping cart view
 * @author fruda
 */
public class PriceShoppingCartPanel extends JPanel{
    
    //Create attributes
    private JLabel priceValue = new JLabel();
    private JButton shoppingCartButton = new JButton("Cart");
    private double priceSum = 0.00;
    
    /***
     * Constructor for the PriceShoppingCartPanel class
     * @param price total price in shopping cart
     */
    public PriceShoppingCartPanel(ArrayList<Item> tempCart) {
        
        //add action listener for button
        shoppingCartButton.addActionListener(buttonAction(tempCart));
        
        //Get total price in shopping cart
        for(int i = 0; i < tempCart.size(); i++) {
            priceSum += tempCart.get(i).price;
        }
        
        String priceString = Double.toString(priceSum);
        this.priceValue.setText(priceString);
        
        setLayout(new GridLayout(1,2));
        
        //add content to panel
        add(priceValue);
        add(shoppingCartButton);
    }

    /***
     * Action listener to segue from customer home page to shopping cart
     * @return al the ActionListener object
     */
    private ActionListener buttonAction(ArrayList<Item> tempCart) {
        ActionListener al;
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Cart Button has been clicked");
                ShoppingCart cart = new ShoppingCart(tempCart);
                cart.setSize(500,500);
                cart.setVisible(true);
                //cart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        };
        return al;
    }

}
