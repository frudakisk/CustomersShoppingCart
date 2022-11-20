/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panels;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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
    private JButton addProductButton = new JButton("+");
    //TODO: change "..." to an image of a magnifying glass
    private JButton detailsButton = new JButton("...");
    
    /***
     * Constructor for CustomerHomePageItemPanel. Grabs details from Item class
     * @param pn product name
     * @param price price of the item
     * @param quantity the quantity of an item in stock
     */
    public CustomerHomePageItemPanel(String pn, double price, int quantity) {
        
        //testing constructor methods
        //will most likely do this for all components bc reading from database
        this.productName.setText(pn);
        String priceString = Double.toString(price);
        this.productPrice.setText(priceString);
        String quantityString = Integer.toString(quantity);
        this.quantityField.setText(quantityString);
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
    
}
