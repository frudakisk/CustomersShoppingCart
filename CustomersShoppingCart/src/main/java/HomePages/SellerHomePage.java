/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HomePages;

import ItemManipulation.AddItemFrame;
import ItemManipulation.revenuePage;
import Panels.AdminHomePageItemPanel;
import customersshoppingcart.Item;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import loginPage.loginPage;

/**
 * This is the home page for the Seller. Here they can edit inventory
 * @author fruda
 */
public class SellerHomePage extends JFrame{
    //setting up components for seller home page
    //Set up items for north panel
    private JLabel welcome = new JLabel("Welcome"); //TODO: make dynamic
    private JButton addItem = new JButton("Add Item");
    private JButton logout = new JButton("logout");
    private JPanel northPanel = new JPanel();
    private JPanel northPanelButtons = new JPanel();
    private JButton salesButton = new JButton("Sales");
    //Set up items for center panel
    private JPanel centerPanel = new JPanel();
    public ArrayList<Item> itemsArray = new ArrayList<>();
    
    /**
     * 
     * @param inventory array of all the items
     * @precondtion inventory array exists and is passed into the constructor
     * @postconditon a jframe of the seller page is generated
     */
    public SellerHomePage(ArrayList<Item> inventory) {
        super("Admin Home Page");
        this.itemsArray = inventory;
        //Setting up north panel
        northPanel.setLayout(new GridLayout(1,1));
        northPanelButtons.setLayout(new GridLayout(1,3));
        northPanel.add(welcome);
        northPanelButtons.add(addItem);
        northPanelButtons.add(salesButton);
        northPanelButtons.add(logout);
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
        addItem.addActionListener(goToAddItemFrame(this));
        logout.addActionListener(logoutAction());
        salesButton.addActionListener(goToSalesFrame(inventory));
        
        
        
        //Setting up JFrame layout
        this.getContentPane().setLayout(new BorderLayout());
        
        this.getContentPane().add("North", northPanel);
        this.getContentPane().add(new JScrollPane(centerPanel));
        this.getContentPane().add("Center", centerPanel);
        
    }
    /***
     * 
     * @param home passes this class so additems has access to all the data in home
     * @return returns an action listener
     * @preconditon class is generated
     * @postcondition add item frame is generated and current frame is disposed
     */
    private ActionListener goToAddItemFrame(SellerHomePage home) {
        ActionListener al;
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //open the add item frame
                System.out.println("Add Item button clicked!");
                dispose();
                AddItemFrame frame = new AddItemFrame(home);
                frame.setSize(500,500);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
            }

        };
        return al;
    }
    /***
     * 
     * @param items takes the array of the inventory
     * @return returns action listened
     * @precondtion class is constructed
     * @postcondtion sales frame is generated showing information to the admin about the store
     */
    private ActionListener goToSalesFrame(ArrayList<Item> items) {
        ActionListener al;
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //pop up, not replace
                revenuePage rev = new revenuePage(items); 
                rev.setSize(500,500);
                rev.setVisible(true);
            }
            
        };
        return al;
    }
    /***
     * 
     * @return action listener for the button
     * @precondtion class is constructed
     * @postcondtion frame is destroyed and login page is shown
     */
    
    private ActionListener logoutAction() {
        ActionListener al;
        al = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                loginPage loginPage = new loginPage(itemsArray);
                JFrame window = loginPage;
                window.setSize(500,500);
                window.setVisible(true);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
            
        };
        return al;
    }
}
