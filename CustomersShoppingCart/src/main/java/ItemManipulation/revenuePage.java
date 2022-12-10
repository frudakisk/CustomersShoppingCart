/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ItemManipulation;

import Panels.CustomerHomePageItemPanel;
import Panels.PriceShoppingCartPanel;
import Panels.revenuePanel;
import customersshoppingcart.Item;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author nicholasgiacobbe
 */
public class revenuePage extends JFrame{
    private ArrayList<Item> itemsArray = new ArrayList<>();
    private JLabel titleLabel = new JLabel("Title");
    private JLabel quantityLabel = new JLabel("Quantity");
    private JLabel quantitySold = new JLabel("Sales");
    private JLabel priceLabel = new JLabel("Price");
    private JLabel revenueLabel = new JLabel("Revenue");
    private JLabel totalRevenueLabel = new JLabel("Total Revenue");
    private JLabel totalRevenueout = new JLabel();
    private JPanel northPanel = new JPanel();
    private JPanel centerPanel = new JPanel();
    private JPanel southPanel = new JPanel();
    private double totalRevenue = 0;
    
    /***
     * constructor
     * @param temp takes in inventory array
     * @precondition array eexists for inventory
     * 
     * @postcondition revenue page is displayed
     */
    public revenuePage(ArrayList<Item> temp){
        super("Sales");
        this.itemsArray = temp;
        northPanel.setLayout(new GridLayout(1,5));
        northPanel.add(titleLabel);
        northPanel.add(quantityLabel);
        northPanel.add(quantitySold);
        northPanel.add(priceLabel);
        northPanel.add(revenueLabel);
        
        centerPanel.setLayout(new GridLayout(itemsArray.size(),1));
        
        for(int i = 0; i < itemsArray.size(); i++) {
            Item item = itemsArray.get(i);
            JPanel itemPanel = new revenuePanel(item);
            centerPanel.add(itemPanel);
            totalRevenue += (item.getPrice()*item.getQuantitySold());
        }
        this.totalRevenueout.setText(Double.toString(totalRevenue));
        southPanel.setLayout(new GridLayout(1,2));
        southPanel.add(totalRevenueLabel);
        southPanel.add(totalRevenueout);
        
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add("North", northPanel);
        this.getContentPane().add(new JScrollPane(centerPanel));
        this.getContentPane().add("Center", centerPanel);
        this.getContentPane().add("South", southPanel);
        
        
        
        
        
    }
}
