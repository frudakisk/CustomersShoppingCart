/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package details;

import HomePages.CustomerHomePage;
import Panels.receiptPanel;
import customersshoppingcart.Item;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;

/**
 *
 * @author KarlHezel
 */
public class receipt extends JFrame {
    private ArrayList<Item> itemsArray = new ArrayList<>();
    private JLabel titleLabel = new JLabel("Title");
    private JLabel quantityLabel = new JLabel("Quantity");
    private JButton returnButton = new JButton("Return to Store");
    private JLabel priceLabel = new JLabel("Price");
    private JLabel subtotalLabel = new JLabel("Subtotal");
    private JLabel totalLabel = new JLabel("Total");
    private JLabel totalout = new JLabel();
    private JPanel northPanel = new JPanel();
    private JPanel centerPanel = new JPanel();
    private JPanel southPanel = new JPanel();
    private double total = 0;
    
    /***
     * constructor
     * @param temp array list of items in the cart
     * @param cartQuantity hashmap of the quanties
     * @param inventory inventory array of items
     * @precondition cart hashmap and inventories exist and program is ready to generate a reciept
     * @postcondition receipt is generated. 
     */
    public receipt(ArrayList<Item> temp, HashMap<String, Integer> cartQuantity, ArrayList<Item> inventory){
        super("Receipt");
        this.itemsArray = temp;
        System.out.println(temp);
        northPanel.setLayout(new GridLayout(1,4));
        northPanel.add(titleLabel);
        northPanel.add(quantityLabel);
        northPanel.add(priceLabel);
        northPanel.add(subtotalLabel);
        
        centerPanel.setLayout(new GridLayout(itemsArray.size(),1));
        ArrayList<Item> reciept = new ArrayList<Item>();
        for(int i = 0; i < itemsArray.size(); i++) {
            Item item = itemsArray.get(i);
            if(!reciept.contains(item)){
                reciept.add(item);
            }
        }
        for(int i = 0; i < reciept.size(); i++){
            Item item = reciept.get(i);
            JPanel itemPanel = new receiptPanel(item, cartQuantity);
            centerPanel.add(itemPanel);
            int quantity = cartQuantity.get(item.getName());
            total += (item.getPrice()*quantity);
        }
        
        
        
        this.totalout.setText(Double.toString(total));
        southPanel.setLayout(new GridLayout(1,3));
        southPanel.add(totalLabel);
        southPanel.add(totalout);
        southPanel.add(returnButton);
        
        //create action for button
        returnButton.addActionListener(returnToStore(inventory));
        
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add("North", northPanel);
        this.getContentPane().add(new JScrollPane(centerPanel));
        this.getContentPane().add("Center", centerPanel);
        this.getContentPane().add("South", southPanel);

    }
    /***
     * 
     * @param inventory inventory array
     * @return action listener
     * @precondition class is constructed
     * @postcondtion user is returned to the hompage. 
     */
    private ActionListener returnToStore(ArrayList<Item> inventory) {
        ActionListener al;
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //dispose of current screen
                dispose();
                //return to the customerhomepage with the inventory list passed
                CustomerHomePage customer = new CustomerHomePage(inventory);
                customer.setSize(500,500);
                customer.setVisible(true);
                customer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            } 
        };
        return al;
    }
}
