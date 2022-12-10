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
     * @param home the parent frame of this panel
     * @precondition tempCart cannot be null
     * @postcondition the total price of the shopping cart is displayed
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
     * @precondition priceSum must be a double
     * @postcondition refreshes the price on the screen
     */
    public void repaintPriceValue(){
        String priceString = Double.toString(priceSum);
        priceValue.setText("$" + priceString);
        priceValue.repaint();
    }
    
    /***
     * updates the price in the shopping cart. should be called every time
     * an item is added to the shopping cart
     * @precondition cartCopy cannot be null
     * @postcondition the sum of the cart is created
     */
    public void updateCart() {
        priceSum = 0;
        for(int i = 0; i < cartCopy.size(); i++) {
            priceSum += cartCopy.get(i).getPrice();
        }
    }

    /***
     * Action listener to segue from customer home page to shopping cart
     * @precondition tempCart must have been initialized
     * @postcondition the ShoppingCart will be displayed if !tempCart.isEmpty()
     * @return al the ActionListener object to transition to ShoppingCart frame
     */
    private ActionListener buttonAction(ArrayList<Item> tempCart, CustomerHomePage home) {
        ActionListener al;
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Cart Button has been clicked");
                if(tempCart.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Add something to your cart!");
                } else {
                    home.dispose(); //remove current frame
                    ShoppingCart cart = new ShoppingCart(tempCart, home); //show new frame
                    cart.setSize(500,500);
                    cart.setVisible(true);
                    cart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
                
                
            }
        };
        return al;
    }

    /***
     * A get method to return the sum in the shopping cart
     * @precondition priceSum must be a double
     * @postcondition priceSum is returned
     * @return priceSum - the total cost of items in the cart
     */
    public double getPriceSum() {
        return priceSum;
    }
}
