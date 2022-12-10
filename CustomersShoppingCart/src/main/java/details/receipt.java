/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package details;

import Panels.receiptPanel;
import Panels.revenuePanel;
import customersshoppingcart.Item;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author KarlHezel
 */
public class receipt extends JFrame {
    private ArrayList<Item> itemsArray = new ArrayList<>();
    private JLabel titleLabel = new JLabel("Title");
    private JLabel quantityLabel = new JLabel("Quantity");
    
    private JLabel priceLabel = new JLabel("Price");
    private JLabel subtotalLabel = new JLabel("Subtotal");
    private JLabel totalLabel = new JLabel("Total");
    private JLabel totalout = new JLabel();
    private JPanel northPanel = new JPanel();
    private JPanel centerPanel = new JPanel();
    private JPanel southPanel = new JPanel();
    private double total = 0;
    
    
    public receipt(ArrayList<Item> temp, HashMap<String, Integer> cartQuantity){
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
        southPanel.setLayout(new GridLayout(1,2));
        southPanel.add(totalLabel);
        southPanel.add(totalout);
        
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add("North", northPanel);
        this.getContentPane().add(new JScrollPane(centerPanel));
        this.getContentPane().add("Center", centerPanel);
        this.getContentPane().add("South", southPanel);

    }
}
