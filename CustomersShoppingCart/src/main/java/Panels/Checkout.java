/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panels;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class represents the JFrame form for the checkout process and payment.
 * @author Karl Hezel
 */
public class Checkout extends JFrame{
    //labels
    private JLabel title = new JLabel("Check Out");
    private JLabel paymetLabel = new JLabel("1. Payment Method: ");
    private JLabel reviewLabel = new JLabel("2. Review Items: ");
    private JLabel TotalPriceLabel = new JLabel("Total Payment: $0.00 ");
    private JLabel cardLabel = new JLabel("      Credit/Debit card Number:     123456789101112");
    private JLabel cardNameLabel = new JLabel("      Name on Card:                        The Florida Resident");
    private JLabel cardExpirationLabel = new JLabel("      Expiration on the card:            05/2025");
    private JLabel zipcodeLabel = new JLabel("      Zipcode:                                  98765");

    //TODO: add picture too



    // adding separator 
    JSeparator s = new JSeparator();
    JSeparator t = new JSeparator();
    JSeparator a = new JSeparator();
    
    
    //buttons
    private JButton cancelButton = new JButton("Back");
    private JButton continueButton = new JButton("Place your order");
    
    //textFields
    private JTextField paymetField = new JTextField("This is where the Payment info will be");
    private JTextField reviewField = new JTextField("This is where the Iten info will be");

    //panels
    private JPanel northPanel = new JPanel();
    private JPanel centerPanel = new JPanel();
    private JPanel southPanel = new JPanel();
    private JPanel westPanel = new JPanel();
    private JPanel eastPanel = new JPanel();

    
    //stuff for file reading

    
    
    public Checkout() {
        super("Checkout");
        
        this.setLayout(new BorderLayout());
        
        //set up border panels
        //North panel
        northPanel.add(title);


        //Center Panel
        centerPanel.setLayout(new GridLayout(3,2));


        //West Panel
        westPanel.setLayout(new GridLayout(0,1));
        westPanel.add(a);
        westPanel.add(paymetLabel);
        westPanel.add(cardLabel);
        westPanel.add(cardNameLabel);
        westPanel.add(cardExpirationLabel);
        westPanel.add(zipcodeLabel);
        westPanel.add(s);
        westPanel.add(reviewLabel);
        westPanel.add(t);
        westPanel.add(TotalPriceLabel);


        //East Panel ........ will have the buttons for adding products on the checkout panel.
        //centerPanel.add(TotalPriceLabel);




        //south Panel
        southPanel.setLayout(new GridLayout(1,2));
        southPanel.add(cancelButton);
        southPanel.add(continueButton);
        
        //set up button actions
        continueButton.addActionListener(continueButtonAction());
        cancelButton.addActionListener(cancelButtonAction());
        
        //add panels to borderlayout
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add("North", northPanel);
        this.getContentPane().add("Center", centerPanel);
        this.getContentPane().add("South", southPanel);
        this.getContentPane().add("West", westPanel);
        this.getContentPane().add("East", eastPanel);
        
        this.setSize(500,450);
        this.setVisible(true);
    }
    
    private ActionListener continueButtonAction() {
        ActionListener al;
        al = new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Will display customer receipt");
            }
        };
        return al;
    }

    private ActionListener cancelButtonAction() {
        ActionListener al;
        al = new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Going back to cutomer home page");
            }
        };
        return al;
    }

  
    //testing purposes
    public static void main(String args[]) {
        Checkout frame = new Checkout();
    }
}
