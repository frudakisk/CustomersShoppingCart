/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panels;

import customersshoppingcart.Item;
import java.awt.GridLayout;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class represents the component that will show on the receipt frame
 * @author KarlHezel
 */
public class receiptPanel extends JPanel  {
    private JLabel name = new JLabel();
    private JLabel quantity = new JLabel();
    private JLabel price = new JLabel();
    private JLabel subtotal = new JLabel();
    
    /***
     * This panel will show statistics about a specific item
     * @param item the item to be analyzed
     * @param cartQuantity key:value pair of quantity of an item in the cart
     * @precondition item is valid
     * @postcondition a panel showing details about the item purchased
     */
    public receiptPanel(Item item, HashMap<String, Integer> cartQuantity) {
        //setup the layout
        setLayout(new GridLayout(1,4));
        
        //set the values for each component
        int cartquantity = cartQuantity.get(item.getName());
        name.setText(item.getName());
        String quantityString = Integer.toString(cartquantity);
        quantity.setText(quantityString);
        String priceString = Double.toString(item.getPrice());
        price.setText( "$" + priceString);
        String subtotalString = Double.toString(cartquantity * item.getPrice());
        subtotal.setText( "$" + subtotalString);
           
        //add components to panel
        add(name);
        add(quantity);
        add(price);
        add(subtotal);
    }
    
}
