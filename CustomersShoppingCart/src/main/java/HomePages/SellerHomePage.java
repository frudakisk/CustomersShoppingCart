/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HomePages;

import ItemManipulation.AddItemFrame;
import Panels.AdminHomePageItemPanel;
import customersshoppingcart.Item;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * This is the home page for the Seller. Here they can edit inventory
 * @author fruda
 */
public class SellerHomePage extends JFrame{
    //setting up components for seller home page
    //Set up items for north panel
    private JLabel welcome = new JLabel("Welcome, Admin!"); //TODO: make dynamic
    private JButton addItem = new JButton("Add Item");
    private JButton deleteItem = new JButton("Delete Item");
    private JPanel northPanel = new JPanel();
    private JPanel northPanelButtons = new JPanel();
    //Set up items for center panel
    private JPanel centerPanel = new JPanel();

    
    
    public SellerHomePage(ArrayList<Item> inventory) {
        super("Admin Home Page");
        
        //Setting up north panel
        northPanel.setLayout(new GridLayout(1,1));
        northPanelButtons.setLayout(new GridLayout(1,1));
        northPanel.add(welcome);
        northPanelButtons.add(addItem);
        //northPanelButtons.add(deleteItem);
        northPanel.add(northPanelButtons);
        
        //Setting up center panel
        //read from items file to determine how many cells to show
        //ArrayList iterator
        centerPanel.setLayout(new GridLayout(inventory.size(), 1));
        for(int i = 0; i < inventory.size(); i++) {
            JPanel cell = new AdminHomePageItemPanel(inventory.get(i));
            centerPanel.add(cell);
        }
        //JPanel cell = new AdminHomePageItemPanel();
        //centerPanel.setLayout(new GridLayout(1,1));
        //centerPanel.add(cell);
        
        //setting up button action listeners
        addItem.addActionListener(goToAddItemFrame());
        
        
        
        //Setting up JFrame layout
        this.getContentPane().setLayout(new BorderLayout());
        
        this.getContentPane().add("North", northPanel);
        this.getContentPane().add(new JScrollPane(centerPanel));
        this.getContentPane().add("Center", centerPanel);
        
    }
    
    private ActionListener goToAddItemFrame() {
        ActionListener al;
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //open the add item frame
                System.out.println("Add Item button clicked!");
                AddItemFrame frame = new AddItemFrame();
                
            }

        };
        return al;
    }
    
//    //testing purposes
//    public static void main (String args[]) {
//        SellerHomePage window = new SellerHomePage();
//        window.setSize(500,500);
//        window.setVisible(true);
//        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
}
