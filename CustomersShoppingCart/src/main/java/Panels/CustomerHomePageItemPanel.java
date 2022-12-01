/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panels;

import customersshoppingcart.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import static javax.swing.SwingUtilities.getWindowAncestor;

/**
 * This class acts as a cell for items in the CustomerHomePage
 * @author fruda
 */
public class CustomerHomePageItemPanel extends JPanel{
    
    //Add in the items that will go into the panel
    private JLabel productName = new JLabel();
    private JLabel productPrice = new JLabel();
    private JLabel quantityField = new JLabel();
    private JLabel imageLabel = new JLabel();
    //private JImage ImageIcon = new JImage();
    public JButton addProductButton = new JButton("+");
    //TODO: change "..." to an image of a magnifying glass
    private JButton detailsButton = new JButton("...");
    private ImageIcon ii;
    //window ancestor
    //JFrame ancestor = (JFrame) getWindowAncestor(this);
    /***
     * Constructor for CustomerHomePageItemPanel. Grabs details from Item class
     * @param pn product name
     * @param price price of the item
     * @param quantity the quantity of an item in stock
     */
    public CustomerHomePageItemPanel(Item item, ArrayList<Item> tempCart) {
        //cart = tempCart;
        //if we manipulate cart, we manipulate tempCart
        //name price quantity
        //testing constructor methods
        //will most likely do this for all components bc reading from database
        this.productName.setText(item.getName());
        String priceString = Double.toString(item.getPrice());
        this.productPrice.setText(priceString);
        String quantityString = Integer.toString(item.getQuantity());
        this.quantityField.setText(quantityString);
        
        
        //image
        SwingWorker sw = new SwingWorker() {
        @Override
        protected Object doInBackground() throws Exception {
            Thread.sleep(5000);//simulate large image takes long to load
            ii = new ImageIcon(scaleImage(120, 120, ImageIO.read(new File(item.getImageFileLocation()))));
            return null;
        }

        @Override
        protected void done() { 
            super.done();
            imageLabel.setIcon(ii);
        }
    };
    sw.execute();
        
        //Add action listeners to buttons
        addProductButton.addActionListener(addToShoppingCart(item, tempCart));
        detailsButton.addActionListener(itemDetailsAction());
        
        //set the layout
        setLayout(new GridLayout(1,6));
        
        //insert the items into the panel layout now
        add(imageLabel);//in placement for the image
        add(productName);
        add(productPrice);
        add(quantityField);
        add(addProductButton);
        add(detailsButton);
        
        
    }
    
    private ActionListener addToShoppingCart(Item item, ArrayList<Item> tempCart) {
        ActionListener al;
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //insert code here. refresh CustomerHomePage at end of action
                //don't worry about quantity yet
                tempCart.add(item);
                System.out.println("Looking at tempCart:");
                for(int i = 0; i < tempCart.size(); i++){                    
                    System.out.println(tempCart.get(i));
                }

            }
            
        };
        return al;
    }
    
    private ActionListener itemDetailsAction() {
        ActionListener al;
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //insert code here
            }
        };
        return al;
    }
    
    private ActionListener removeFromShoppingCart() {
        ActionListener al;
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //insert code here
            }
        };
        return al;
    }
    
    public static BufferedImage scaleImage(int w, int h, BufferedImage img) throws Exception {
        BufferedImage bi;
        bi = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(img, 0, 0, w, h, null);
        g2d.dispose();
        return bi;
    }
}
