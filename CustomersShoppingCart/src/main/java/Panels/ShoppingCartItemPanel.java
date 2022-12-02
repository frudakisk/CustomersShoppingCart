/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panels;

import java.awt.*;
import java.util.ArrayList;
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
    
    
    
    public ShoppingCartItemPanel(ArrayList<String> item) {
        name.setText(item.get(0));
        totalPrice.setText(item.get(1));
        quantity.setText(item.get(2));
        
        setLayout(new GridLayout(1, 5));
        add(name);
        add(totalPrice);
        add(quantity);
        add(incrementButton);
        add(decrementButton);
        
        
    }
}
