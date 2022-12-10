/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ItemManipulation;

import customersshoppingcart.Item;
import customersshoppingcart.CustomersShoppingCart;
import customersshoppingcart.Users;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import HomePages.*;

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
    private JButton saveButton = new JButton("Save");
    private JButton addImageButton = new JButton("Select Image");
    private JButton backButton = new JButton("< Back");
    
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
    private int filelength = 0;
    /**
     * 
     * @param home homepage is passed so this class has access to the data from the previous frame
     * @precondition homepage has been generated
     * @postcondition additem page is generated
     *
     */
    public AddItemFrame(SellerHomePage home) {
        super("Add Item");
        
        this.setLayout(new BorderLayout());
        
        //set up border panels
        //North panel
        this.northPanel.add(title);
        //Center Panel
        this.descriptionField.setLineWrap(true);
        this.centerPanel.setLayout(new GridLayout(4,2));
        this.centerPanel.add(nameLabel);
        this.centerPanel.add(nameField);
        this.centerPanel.add(priceLabel);
        this.centerPanel.add(priceField);
        this.centerPanel.add(quantityLabel);
        this.centerPanel.add(quantityField);
        this.centerPanel.add(descriptionLabel);
        this.centerPanel.add(descriptionField);
        //south panel
        this.southPanel.setLayout(new GridLayout(1,3));
        this.southPanel.add(backButton);
        this.southPanel.add(addImageButton);
        this.southPanel.add(saveButton);
        
        //set up button actions
        this.saveButton.addActionListener(saveButtonAction());
        this.addImageButton.addActionListener(imageAction());
        this.backButton.addActionListener(backAction(home, this));
        //add panels to borderlayout
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add("North", northPanel);
        this.getContentPane().add("Center", centerPanel);
        this.getContentPane().add("South", southPanel);
        
        
        this.setSize(500,500);
        this.setVisible(true);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /**
     * saves new items to array and file
     * @return actionlistener
     * @precondition homepage for admin has been created
     * @postcondition new item has been added to inventory and saved to the file
     */
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
                
                //TODO: add string representation of item to its file
                //System.out.println(newItem);
                //read the file, save its content to array list, add new content
                //save back to file
                //check if file is empty
                int quantitySold = 0;
                if(f.length() == 0) {
                    
                    Item newItem = new Item(0, name, description, price, quantity, quantitySold, imageLocation);
                    itemArray.add(newItem);
                    addItemToFile(itemArray);
                } else {
                    itemArray = readFile();
                    Item newItem = new Item(filelength, name, description, price, quantity, quantitySold, imageLocation);
                    itemArray.add(newItem);
                    addItemToFile(itemArray);
                };
                //Close this add window after success
                dispose();
                CustomersShoppingCart customer = new CustomersShoppingCart();
                SellerHomePage sellerHomePage = new SellerHomePage(customer.itemArray);
                sellerHomePage.setSize(500,500);
                sellerHomePage.setVisible(true);
                sellerHomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
            
        };
        return al;
    }
    
    /**
     * Adds an Item to a the itemsFile.
     * @param itemArray array of the inventory that has been altered
     * @precondition itemarray is ready to be saved to a file
     * @postcondtion itemarray is saved to the file for storage
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
    
    /**
     * Reads the items.txt file and returns a list of all its content
     * @return Item inventory array
     * @precondition class is constructed
     * @postconditon file is read and the inventory file is returned
     */
    private ArrayList<Item> readFile() {
        ArrayList<Item> itemTemp = new ArrayList<>();
        try
        {
            FileInputStream fis = new FileInputStream("items.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
 
            itemTemp = (ArrayList) ois.readObject();
            filelength = itemTemp.size();
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
    /**
     * file picker
     * @return actionlistener
     * @precondition class is constructed
     * @postcondition user is able to pick a file for an image and the file path is stored to the inventory array
     */
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
    
    /**
     * This action listener helps transition from the add item frame to the
     * seller home page incase they do not want to add anything.
     * @param home SellerHomePage needs to pop back up
     * @param current we need to dispose of the current view
     * @return al - the action. returns the previous instance of sellerhomepage
     * @precondtion class is constructed
     * @postcondtion user is redirected back to the homepage
     */
    private ActionListener backAction(SellerHomePage home, JFrame current) {
        ActionListener al;
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //close this page and open the parent page
                current.dispose();
                SellerHomePage homePage = home;
                homePage.setSize(500,500);
                homePage.setVisible(true);
                homePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
            
        };
        return al;
    }
}
