/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HomePages;

import Panels.*;
import customersshoppingcart.Item;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * The Home page for customer logins. This is where shopping happens
 * @author fruda
 */
public class CustomerHomePage extends JFrame{
    
    //Setting up data stream contains all items in store
    public ArrayList<Item> itemsArray = new ArrayList<>();
    //the array that will hold all items in customers shopping cart (subset of itemsArray)
    public ArrayList<Item> tempCart = new ArrayList<>();
    //setup components for North
    private JLabel welcomeLabel = new JLabel("Welcome");
    private JLabel titleLabel = new JLabel("Customer Shopping");
    private PriceShoppingCartPanel pricePanel = new PriceShoppingCartPanel(tempCart, this);
    private JPanel northPanel = new JPanel();
    
    //setup components for Center
    private JPanel centerPanel = new JPanel();

    
    /***
     * Constructor for CustomerHomePage
     * @param temp an ArrayList containing all items in inventory
     */
    public CustomerHomePage(ArrayList<Item> temp) {
        super("Home Page - Customer");
        
        System.out.println("Contents of cart when entering customerhomepage: " + tempCart);
        
        this.itemsArray = temp;
        
        //setup panel for North
        northPanel.setLayout(new GridLayout(1,3));
        northPanel.add(welcomeLabel);
        northPanel.add(titleLabel);
        northPanel.add(pricePanel);
        
        //setup panel for Center
        centerPanel.setLayout(new GridLayout(itemsArray.size(),1));
        
        //should go to num of items in inventory
        for(int i = 0; i < itemsArray.size(); i++) {
            //each itemPanel needs access to the tempCart so that we can add items
            //to the cart!
            JPanel item = new CustomerHomePageItemPanel(itemsArray.get(i), tempCart, pricePanel, this);
            //I think I can do a shallow copy of an arrayList and it still saves data
            centerPanel.add(item);    
        }
        
        
        
        this.getContentPane().setLayout(new BorderLayout());
        
        this.getContentPane().add("North", northPanel);
        this.getContentPane().add(new JScrollPane(centerPanel));
        this.getContentPane().add("Center", centerPanel);
    
        
        
        
    }
    
    public ArrayList<Item> getCart() {
        return tempCart;
    }
    
    public void setCart(ArrayList<Item> newCart){
        tempCart.clear();
        for(int i = 0; i < newCart.size(); i++) {
            tempCart.add(newCart.get(i));
        }
        System.out.println("After setCart(): " + tempCart);
        pricePanel.updateCart();
        pricePanel.repaintPriceValue();
        //this.repaint()
    }
    
    public void setPriceShoppingCartPanel(ArrayList<Item> cart) {
        pricePanel = new PriceShoppingCartPanel(cart, this);
    }
    
//    //testing purposes
//    public static void main(String args[]) {
//        CustomerHomePage window = new CustomerHomePage();
//        window.setSize(500,500);
//        window.setVisible(true);
//        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
}
