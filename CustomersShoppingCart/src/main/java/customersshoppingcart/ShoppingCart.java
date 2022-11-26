/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customersshoppingcart;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * This class is for the shopping cart object of the project. This is where
 * the customer will store items that they wish to purchase. Customer can also
 * edit information in the shopping cart (add & remove items)
 * @author fruda
 */
public class ShoppingCart extends JFrame{
    
    //will hold items in shopping cart
    public ArrayList<Item> shoppingCart;
 
    /***
     * Constructor for ShoppingCart class
     */
    public ShoppingCart(ArrayList<Item> cart) {
        super("This is the Title for Shopping Cart View");
        //just some basic stuff in here to get started
        //add content to shopping cart
        shoppingCart = cart;
        System.out.println("Showing ShoppingCart Frame arraylist");
        for(int i = 0; i < shoppingCart.size(); i++) {
            System.out.println(shoppingCart.get(i));
        }
        this.getContentPane().setLayout(new BorderLayout());
    }
    
}
