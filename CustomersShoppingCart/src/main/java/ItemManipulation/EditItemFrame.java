/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ItemManipulation;
import HomePages.SellerHomePage;
import customersshoppingcart.CustomersShoppingCart;
import customersshoppingcart.Item;
import customersshoppingcart.Users;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
/**
 *
 * @author fruda
 */
public class EditItemFrame extends JFrame {
    //labels
    private JLabel title = new JLabel("Add Item Details");
    private JLabel nameLabel = new JLabel("Name: ");
    private JLabel priceLabel = new JLabel("Price: ");
    private JLabel quantityLabel = new JLabel("Quantity: ");
    private JLabel descriptionLabel = new JLabel("Description: ");
    //TODO: add picture too
    
    //buttons
    private JButton deleteButton = new JButton("Delete Item");
    private JButton saveButton = new JButton("Save");
    private JButton addImageButton = new JButton("Select Image");
    
    //textFields
    private JTextField nameField;
    private JTextField priceField;
    private JTextField quantityField;
    private JTextArea descriptionField;
    
    //panels
    private JPanel northPanel = new JPanel();
    private JPanel centerPanel = new JPanel();
    private JPanel southPanel = new JPanel();
    private Item itemtochange;
    
    //stuff for file reading
    ArrayList<Item> itemArray = new ArrayList<>();
    File f = new File("items.txt");
    private String imageLocation = null;
    private int quantitySold = 0;
    
    /***
     * 
     * @param passeditem takes an Item class
     * @param frame takes the frame to update the information from the previous frame
     * @precondtion sellerhomepage has been generated
     * @postcondtion edit frame is generated with the item information
     */
    public EditItemFrame(Item passeditem, SellerHomePage frame ){
        super("Edit Item");
        this.itemtochange = passeditem;
        this.nameField = new JTextField(itemtochange.getName());
        this.priceField = new JTextField(String.valueOf(itemtochange.getPrice()));
        this.quantityField = new JTextField(String.valueOf(itemtochange.getQuantity()));
        this.descriptionField = new JTextArea(itemtochange.description());
        this.descriptionField.setLineWrap(true);
        this.imageLocation = itemtochange.getImageFileLocation();
        this.quantitySold = itemtochange.getQuantitySold();
        this.setLayout(new BorderLayout());
        //set up border panels
        //North panel
        this.northPanel.add(title);
        //Center Panel
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
        this.southPanel.add(deleteButton);
        this.southPanel.add(addImageButton);
        this.southPanel.add(saveButton);
        
        //set up button actions
        this.saveButton.addActionListener(saveButtonAction());
        this.addImageButton.addActionListener(imageAction());
        this.deleteButton.addActionListener(deleteAction());
        //add panels to borderlayout
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add("North", northPanel);
        this.getContentPane().add("Center", centerPanel);
        this.getContentPane().add("South", southPanel);
        this.setSize(500,500);
        this.setVisible(true);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        
        
        
        
    }
    /***
     * saves new items to array and file
     * @return actionlistener
     * @preconditon homepage for admin has been created
     * @postconditon new item has been added to inventory and saved to the file in this case the item has been edited returns to homepage
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
                Item newItem = new Item(itemtochange.getItemId(), name, description, price, quantity, quantitySold, imageLocation);
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
                    itemArray.set(itemtochange.getItemId(),newItem);
                    addItemToFile(itemArray);
                }
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
    
    /***
     * Adds an Item to a the itemsFile.
     * @param newItem takes inventory array
     * @precondtion class is constructed
     * @postcondtion item is added to the file
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
     * 
     * @return returns the inventory fetched from the file
     * @precondtion class is constructed
     * @postcondtion inventory from saved file
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
    /***
     * image picker
     * @return action listener
     * @precondtion class is constructed
     * @postconditon user is able to pick image
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
    /***
     * 
     * @return action listener
     * @precondition class is constructed
     * @postcondition item is deleted from the inventory and returned to the admin homepage
     */
    private ActionListener deleteAction() {
        ActionListener al;
        al = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                itemArray = readFile();
                
                for (int i = (itemtochange.getItemId() + 1 ); i < itemArray.size(); i++) {
                    itemArray.get(i).updateId(i-1);
                }
                itemArray.remove(itemtochange.getItemId());
                addItemToFile(itemArray);
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
    
    
    
}
