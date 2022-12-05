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
     * @param home
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
        incrementButton.addActionListener(incrementCartItem(shoppingCart, item, cartQuantity, home));
        decrementButton.addActionListener(decrementCartItem(shoppingCart, item, cartQuantity, home));
        
        
        
    }
    
    /***
     * ActionListener to add 1 item to the shopping cart. This updates the shopping cart
     * array, the cartQuantity HashMap, and the priceLabel on the home screen as well as
     * the current screen
     * @param shoppingCart
     * @param item
     * @param cartQuantity
     * @param home
     * @return al - the action listener action
     */
    public ActionListener incrementCartItem(ArrayList<Item> shoppingCart, Item item, 
            HashMap<String, Integer> cartQuantity, ShoppingCart home) {
        ActionListener al;
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //store quantity, not shopping cart quantity
                String quantityString = quantity.getText();
                //check the max quantity in store
                if(!quantityString.equals(itemArray.get(4))) {
                    
                    //incremet the item quantity by one each time we click this button
                    cartQuantity.replace(item.getName(), cartQuantity.get(item.getName()) + 1);
                    System.out.println("cartQuantity after incrementCartItem button click: " + cartQuantity);

                    //make string synchronous with cartQuantity value
                    quantityString = Integer.toString(cartQuantity.get(item.getName()));
                    quantity.setText(quantityString);
                    //make sure these changes are reflected in the shopping cart
                    shoppingCart.add(item);
                    
                    //printing out shoppingCart to see new results
                    for(int i = 0; i < shoppingCart.size(); i++) {
                        System.out.println(shoppingCart.get(i));
                    }
                    
                    //update the ShoppingCartSouthPanel priceLabel
                    home.updatePrice();
                    home.repaintPriceValue();;
                    
                }
                                
            } 
        };
        return al;
    }
    
    /***
     * Action listener that removes item from the cart, updates the shopping cart,
     * updates the cartQuantity HashMap, and updates the current priceLabel on 
     * both the home and current screen
     * @param shoppingCart
     * @param item
     * @param cartQuantity
     * @param home
     * @return al - Action of the button
     */
    public ActionListener decrementCartItem(ArrayList<Item> shoppingCart, Item item, 
            HashMap<String, Integer> cartQuantity, ShoppingCart home) {
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
