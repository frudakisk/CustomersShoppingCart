/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panels;

import customersshoppingcart.Item;
import java.awt.*;
import javax.swing.*;

/**
 * This class represents the panel that will be in the revenuePage
 * @author fruda
 */
public class revenuePanel extends JPanel {
    //add attributes
    private JLabel name = new JLabel();
    private JLabel quantity = new JLabel();
    private JLabel quantitySold = new JLabel();
    private JLabel price = new JLabel();
    private JLabel revenue = new JLabel();
    
    /***
     * This panel will show statistics about a specific item
     * @param item the item to be analyzed
     * @precondition item is valid
     * @postcondition revenue information about item is displayed
     */
    public revenuePanel(Item item) {
        //setup the layout
        setLayout(new GridLayout(1,5));
        
        //set the values for each component
        name.setText(item.getName());
        String quantityString = Integer.toString(item.getQuantity());
        quantity.setText(quantityString);
        String quantitySoldString = Integer.toString(item.getQuantitySold());
        quantitySold.setText(quantitySoldString);
        String priceString = Double.toString(item.getPrice());
        price.setText( "$" + priceString);
        String revenueString = Double.toString(item.getQuantitySold() * item.getPrice());
        revenue.setText( "$" + revenueString);
           
        //add components to panel
        add(name);
        add(quantity);
        add(quantitySold);
        add(price);
        add(revenue);
    }
    
}
