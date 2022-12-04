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
import java.util.HashMap;
import java.util.Set;
import javax.swing.*;

/**
 *
 * @author fruda
 */
public class ShoppingCartItemPanel extends JPanel{
    //create components
    private JLabel name = new JLabel();
    private JLabel totalPrice = new JLabel();
    private JLabel quantity = new JLabel();
    private JButton incrementButton = new JButton("+");
    private JButton decrementButton = new JButton("-");
    //others
    private ArrayList<String> itemArray;
    
    
    /***
     * Constructor for each item in the shopping cart
     * @param shoppingCart
     * @param item
     * @param cartQuantity
     */
    public ShoppingCartItemPanel(ArrayList<Item> shoppingCart, Item item,
            HashMap<String,Integer> cartQuantity, ShoppingCart home) {
        itemArray = item.toArrayList();
        name.setText(itemArray.get(1));
        double itemPrice = Double.parseDouble(itemArray.get(3));
        double totalPriceDouble = cartQuantity.get(name.getText()) * itemPrice;
        String totalPriceString = Double.toString(totalPriceDouble);
        totalPrice.setText(totalPriceString);
        //this is the wrong quantity - need quantity in cart - hasmap value
        int quantityInCart = cartQuantity.get(name.getText());
        String quantityInCartString = Integer.toString(quantityInCart);
        quantity.setText(quantityInCartString);
        
        setLayout(new GridLayout(1, 5));
        add(name);
        add(totalPrice);
        add(quantity);
        add(incrementButton);
        add(decrementButton);
        
        //add action listeners to buttons
        incrementButton.addActionListener(incrementCartItem(shoppingCart, item, home));
        decrementButton.addActionListener(decrementCartItem());
        
        
        
    }
    
    /***
     * ActionListener to increment the value of a certain item by 1
     * @return al - the action listener action
     */
    public ActionListener incrementCartItem(ArrayList<Item> shoppingCart, Item item, ShoppingCart home) {
        ActionListener al;
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //add same item
                //turn quantity to an integer & store in a var
                //add one to that integer
                //turn back to string
                //set the quantity label as the new sum
                //repaint the quantity label
                
                String quantityString = quantity.getText();
                //check the max quantity in store
                if(!quantityString.equals(itemArray.get(4))) {
                    int quantityInt = Integer.parseInt(quantityString);
                    quantityInt += 1;
                    quantityString = Integer.toString(quantityInt);
                    quantity.setText(quantityString);
                    //current information is not carried on to shopping cart
                    //make sure these changes are reflected in the shopping cart
                    shoppingCart.add(item);
                    System.out.println("Current Quantity: " + quantity.getText());
                    
                    for(int i = 0; i < shoppingCart.size(); i++) {
                        System.out.println(shoppingCart.get(i));
                    }
                    //System.out.println("Shopping cart after incrementing:" + shoppingCart);
                    //update the ShoppingCartSouthPanel priceLabel
                    home.updatePrice();
                    home.repaintPriceValue();;
                    
                }
                                
            } 
        };
        return al;
    }
    
    public ActionListener decrementCartItem() {
        ActionListener al;
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //similar to incrementCartItem but just subtract 1
                String quantityString = quantity.getText();
                if(!quantityString.equals("0")) {
                    int quantityInt = Integer.parseInt(quantityString);
                    quantityInt -= 1;
                    quantityString = Integer.toString(quantityInt);
                    quantity.setText(quantityString);
                    //current information is not carried on to shopping cart
                    //make sure these changes are reflected in the shopping cart
                    System.out.println("Current Quantity: " + quantity.getText());
                }
                
            }
            
        };
        return al;
    }
}
