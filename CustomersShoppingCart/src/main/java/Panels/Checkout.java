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
    private JLabel TotalPriceLabel = new JLabel("Total Payment: ..Total amount will be here.. ");

    //TODO: add picture too
    
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
    
    //stuff for file reading

    
    
    public Checkout() {
        super("Checkout");
        
        this.setLayout(new BorderLayout());
        
        //set up border panels
        //North panel
        northPanel.add(title);


        //Center Panel
        centerPanel.setLayout(new GridLayout(4,2));
        centerPanel.add(paymetLabel);
        centerPanel.add(paymetField);
        centerPanel.add(reviewLabel);
        centerPanel.add(reviewField);
        centerPanel.add(TotalPriceLabel);

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
        
        this.setSize(300,250);
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
