/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panels;

import customersshoppingcart.Item;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author fruda
 */
public class AdminHomePageItemPanel extends JPanel{
    private JLabel name = new JLabel("Name");
    private JLabel picture = new JLabel("photo");
    private JLabel price = new JLabel("$0.00");
    private JLabel quantity = new JLabel("Quantity: 0");
    private JButton upQuantityButton = new JButton("+");
    private JButton downQuantityButton = new JButton("-");
    private JButton editItem = new JButton("Edit");
    private JPanel leftPanel = new JPanel();
    private JPanel itemDetailsPanel = new JPanel();
    
    
    
    public AdminHomePageItemPanel(Item item) {
        //set components with actual data
        name.setText(item.getName());
        String priceString = Double.toString(item.getPrice());
        price.setText(priceString);
        String quantityString = Integer.toString(item.getQuantity());
        quantity.setText(quantityString);
        
        //Setting up the item details panel
        itemDetailsPanel.setLayout(new GridLayout(1,4));
        itemDetailsPanel.add(picture);
        itemDetailsPanel.add(name);
        itemDetailsPanel.add(price);
        itemDetailsPanel.add(quantity);
        
        //setting up the left panel
        leftPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        
        gbc.gridx = 0;
        gbc.gridy = 1;
        //gbc.gridwidth = 1;
        leftPanel.add(upQuantityButton,gbc);
        
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        //gbc.gridwidth = 1;
        leftPanel.add(downQuantityButton, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        leftPanel.add(itemDetailsPanel, gbc);
        
        
        //setting up this panel
        this.setLayout(new GridLayout(1,2));
        this.add(leftPanel);
        this.add(editItem);
        
    }
}
