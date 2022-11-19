/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panels;

import customersshoppingcart.ShoppingCart;
import java.awt.*;
import java.awt.event.*;
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
    
    
    public PriceShoppingCartPanel(double price) {
        
        //add action listener for button
        shoppingCartButton.addActionListener(buttonAction());
        
        String priceString = Double.toString(price);
        this.priceValue.setText(priceString);
        
        setLayout(new GridLayout(1,2));
        
        //add content to panel
        add(priceValue);
        add(shoppingCartButton);
    }

    private ActionListener buttonAction() {
        ActionListener al;
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Cart Button has been clicked");
                ShoppingCart cart = new ShoppingCart();
                cart.setSize(500,500);
                cart.setVisible(true);
                //cart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        };
        return al;
    }

}
