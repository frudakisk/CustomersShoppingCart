/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ItemManipulation;

import customersshoppingcart.Item;
import customersshoppingcart.Users;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * This class represents the JFrame form for adding a new item into the store.
 * @author fruda
 */
public class AddItemFrame extends JFrame{
    //labels
    private JLabel title = new JLabel("Add Item Details");
    private JLabel nameLabel = new JLabel("Name: ");
    private JLabel priceLabel = new JLabel("Price: ");
    private JLabel quantityLabel = new JLabel("Quantity: ");
    private JLabel descriptionLabel = new JLabel("Description: ");
    //TODO: add picture too
    
    //buttons
    private JButton backButton = new JButton("Back");
    private JButton saveButton = new JButton("Save");
    private JButton addImageButton = new JButton("Select Image");
    
    //textFields
    private JTextField nameField = new JTextField();
    private JTextField priceField = new JTextField();
    private JTextField quantityField = new JTextField();
    private JTextArea descriptionField = new JTextArea();
    
    //panels
    private JPanel northPanel = new JPanel();
    private JPanel centerPanel = new JPanel();
    private JPanel southPanel = new JPanel();
    
    //stuff for file reading
    ArrayList<Item> itemArray = new ArrayList<>();
    File f = new File("items.txt");
    String imageLocation = null;
    
    public AddItemFrame() {
        super("Add Item");
        
        this.setLayout(new BorderLayout());
        
        //set up border panels
        //North panel
        northPanel.add(title);
        //Center Panel
        centerPanel.setLayout(new GridLayout(4,2));
        centerPanel.add(nameLabel);
        centerPanel.add(nameField);
        centerPanel.add(priceLabel);
        centerPanel.add(priceField);
        centerPanel.add(quantityLabel);
        centerPanel.add(quantityField);
        centerPanel.add(descriptionLabel);
        centerPanel.add(descriptionField);
        //south panel
        southPanel.setLayout(new GridLayout(1,3));
        southPanel.add(backButton);
        southPanel.add(addImageButton);
        southPanel.add(saveButton);
        
        //set up button actions
        saveButton.addActionListener(saveButtonAction());
        addImageButton.addActionListener(imageAction());
        //add panels to borderlayout
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add("North", northPanel);
        this.getContentPane().add("Center", centerPanel);
        this.getContentPane().add("South", southPanel);
        
        
        this.setSize(500,500);
        this.setVisible(true);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private ActionListener saveButtonAction() {
        ActionListener al;
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //create a new item and save it to our file
                System.out.println("Save Button Clicked");
                String name = nameField.getText();
                double price = Double.parseDouble(priceField.getText());
                int quantity = Integer.parseInt(quantityField.getText());
                String description = descriptionField.getText();
                //TODO: logic to find itemId based on last id used in file
                Item newItem = new Item(0, name, description, price, quantity, imageLocation);
                //TODO: add string representation of item to its file
                System.out.println(newItem);
                //read the file, save its content to array list, add new content
                //save back to file
                //check if file is empty
                if(f.length() == 0) {
                    itemArray.add(newItem);
                    addItemToFile(itemArray);
                } else {
                    itemArray = readFile();
                    itemArray.add(newItem);
                    addItemToFile(itemArray);
                };
                //Close this add window after success
                dispose();
            }
            
        };
        return al;
    }
    
    /***
     * Adds an Item to a the itemsFile.
     * @param newItem 
     */
    private void addItemToFile(ArrayList<Item> itemArray) {
         try
        {
            FileOutputStream fos = new FileOutputStream("items.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(itemArray);
            oos.close();
            fos.close();
        } 
        catch (IOException ioe) 
        {
            System.out.println("Error in addItemToFile");
            ioe.printStackTrace();
        }
    }
    
    /***
     * Reads the items.txt file and returns a list of all its content
     * @return Item list
     */
    private ArrayList<Item> readFile() {
        ArrayList<Item> itemTemp = new ArrayList<>();
        try
        {
            FileInputStream fis = new FileInputStream("items.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
 
            itemTemp = (ArrayList) ois.readObject();
            
            ois.close();
            fis.close();
            
        } 
        catch (IOException ioe) 
        {
            System.out.println("Error in readFile");
            ioe.printStackTrace();
          
        } 
        catch (ClassNotFoundException c) 
        {
            System.out.println("Class not found");
            c.printStackTrace();
     
        }
        return itemTemp;
    }
    
    //testing purposes
    public static void main(String args[]) {
        AddItemFrame frame = new AddItemFrame();
    }

    private ActionListener imageAction() {
       ActionListener al;
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //create a new item and save it to our file
                System.out.println("addImage Button Clicked");
               
                //Close this add window after success
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(null);
                final File f = chooser.getSelectedFile();
                String filename = f.getAbsolutePath();
                if (f == null) {
                    JOptionPane.showMessageDialog(null, "File Path is NULL!!");
                }
                imageLocation = filename;
            }
            
        };
        return al; 
    }
}
