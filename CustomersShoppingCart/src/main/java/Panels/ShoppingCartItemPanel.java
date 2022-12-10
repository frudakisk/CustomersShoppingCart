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
 *This class is the specific panel that contains information about an item in the
 * shoppingCart frame
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
     * @param shoppingCart shopping cart from the customer
     * @param item item that the panel will be previewing in the shopping cart
     * @param cartQuantity key:value pair for quantity of an item in the cart
     * @param home - the parent JFrame 
     * @precondition shoppingCart cannot be empty
     * @postcondition A panel of an item is spawned on the shoppingCart frame
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
        decrementButton.addActionListener(decrementCartItem(shoppingCart, item, cartQuantity, home, this));
          
    }
    
    /***
     * ActionListener to add 1 item to the shopping cart. This updates the shopping cart
     * array, the cartQuantity HashMap, and the priceLabel on the home screen as well as
     * the current screen
     * @param shoppingCart the customer shopping cart 
     * @param item the item to be added to the shopping cart
     * @param cartQuantity key:value that holds # of items in shopping cart
     * @param home ShoppingCart is the parent frame and is  needed to refresh the page
     * @precondition item must be valid
     * @postcondition panel quantity is updated in UI and in back end
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
                //int index = shoppingCart.indexOf(item);
                //check the max quantity in store
                if(!quantityString.equals(itemArray.get(4))) {
                    
                    //incremet the item quantity by one each time we click this button
                    cartQuantity.replace(item.getName(), cartQuantity.get(item.getName()) + 1);
                    System.out.println("cartQuantity after incrementCartItem button click: " + cartQuantity);

                    //make string synchronous with cartQuantity value
                    quantityString = Integer.toString(cartQuantity.get(item.getName()));
                    quantity.setText(quantityString);
                    //update the total price of the item in the cart
                    double itemPrice = Double.parseDouble(itemArray.get(3));
                    double totalPriceDouble = cartQuantity.get(name.getText()) * itemPrice;
                    String totalPriceString = Double.toString(totalPriceDouble);
                    totalPrice.setText(totalPriceString);
                    //make sure these changes are reflected in the shopping cart
                    
                    shoppingCart.add(item);
                    
                    //printing out shoppingCart to see new results
                    for(int i = 0; i < shoppingCart.size(); i++) {
                        System.out.println(shoppingCart.get(i));
                    }
                    
                    //update the ShoppingCartSouthPanel priceLabel
                    home.updatePrice();
                    home.repaintPriceValue();
                    
                }
                                
            } 
        };
        return al;
    }
    
    /***
     * Action listener that removes item from the cart, updates the shopping cart,
     * updates the cartQuantity HashMap, and updates the current priceLabel on 
     * both the home and current screen
     * @param shoppingCart holds the items in customer shopping cart
     * @param item the item that we want to decrement in cartQuantity and remove from shoppingCart
     * @param cartQuantity holds the quantity of each item in the shoppingCart
     * @param home ShoppingCart - to refresh this page with new information
     * @param currentPanel this JPanel. Used to remove the panel once quantity = 0
     * @precondition item must be valid
     * @postcondition quantity of item is updated in UI and back end
     * @return al - Action of the button
     */
    public ActionListener decrementCartItem(ArrayList<Item> shoppingCart, Item item, 
            HashMap<String, Integer> cartQuantity, ShoppingCart home, ShoppingCartItemPanel currentPanel) {
        ActionListener al;
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //similar to incrementCartItem but just subtract 1
                //get store quantity, not quantity in shoppingCart
                String quantityString = quantity.getText();
                //make sure we do not go below 0
                if(!quantityString.equals("0")) {
                    //decrement the quantity by one each time we click this button
                    cartQuantity.replace(item.getName(), cartQuantity.get(item.getName()) - 1);
                    System.out.println("cartQuantity after incrementCartItem button click: " + cartQuantity);
                    
                    //make string synchronous with cartQuantity
                    quantityString = Integer.toString(cartQuantity.get(item.getName()));
                    quantity.setText(quantityString);
                    //update the total price of the item in the cart
                    double itemPrice = Double.parseDouble(itemArray.get(3));
                    double totalPriceDouble = cartQuantity.get(name.getText()) * itemPrice;
                    String totalPriceString = Double.toString(totalPriceDouble);
                    totalPrice.setText(totalPriceString);
                    //make sure these changes are reflected in the shoppingCart
                    shoppingCart.remove(item);
                    //make sure these changes are reflected in the cartQuantity
                    //no item should ever = 0, just take it out of the HashMap
                    //and refresh shopping cart to not show items with quantity = 0
                    
                    //Check if the quantity is 0, if so, refresh the frame with updated shoppingCart
                    if(quantity.getText().equals("0")) {
                        System.out.println("Quantity is 0!!!");
                        cartQuantity.remove(item.getName());
                        //dismiss this panel
                        //repaint the shopping cart view with new ArrayList shoppingCart
                        currentPanel.removeAll();
                        home.repaint();                        
                    }
                    //printing out shoppingCart to see new results
                    for(int i = 0; i < shoppingCart.size(); i++) {
                        System.out.println(shoppingCart.get(i));
                    }
                    //show the content of cartQuantity
                    System.out.println(cartQuantity);
                    //update the ShoppingCartSouthPanel priceLabel
                    home.updatePrice();
                    home.repaintPriceValue();;
                }
                
            }
            
        };
        return al;
    }
}
