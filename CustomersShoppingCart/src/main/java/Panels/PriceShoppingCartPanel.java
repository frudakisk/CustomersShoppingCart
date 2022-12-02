/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panels;

import HomePages.CustomerHomePage;
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
    private ArrayList<Item> cartCopy;
    
    /***
     * Constructor for the PriceShoppingCartPanel class
     * @param tempCart a transfer of items in an array list to this small panel
     */
    public PriceShoppingCartPanel(ArrayList<Item> tempCart, CustomerHomePage home) {
        
        cartCopy = tempCart;
        //add action listener for button
        shoppingCartButton.addActionListener(buttonAction(tempCart, home));
        
        //Get total price in shopping cart
        for(int i = 0; i < tempCart.size(); i++) {
            priceSum += tempCart.get(i).getPrice();
        }
        
        String priceString = Double.toString(priceSum);
        this.priceValue.setText("$" + priceString);
        
        setLayout(new GridLayout(1,2));
        
        //add content to panel
        add(priceValue);
        add(shoppingCartButton);
    }
    
    /***
     * A function to repaint the label value of the sum in shopping cart
     */
    public void repaintPriceValue(){
        String priceString = Double.toString(priceSum);
        priceValue.setText("$" + priceString);
        priceValue.repaint();
    }
    
    /***
     * updates the price in the shopping cart. should be called every time
     * an item is added to the shopping cart
     */
    public void updateCart() {
        priceSum = 0;
        for(int i = 0; i < cartCopy.size(); i++) {
            priceSum += cartCopy.get(i).getPrice();
        }
    }

    /***
     * Action listener to segue from customer home page to shopping cart
     * @return al the ActionListener object
     */
    private ActionListener buttonAction(ArrayList<Item> tempCart, CustomerHomePage home) {
        ActionListener al;
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Cart Button has been clicked");
                home.dispose(); //remove current frame
                ShoppingCart cart = new ShoppingCart(tempCart, home); //show new frame
                cart.setSize(500,500);
                cart.setVisible(true);
                cart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
            }
        };
        return al;
    }

    /***
     * A get method to return the sum in the shopping cart
     * @return priceSum - the total cost of items in the cart
     */
    public double getPriceSum() {
        return priceSum;
    }
}
