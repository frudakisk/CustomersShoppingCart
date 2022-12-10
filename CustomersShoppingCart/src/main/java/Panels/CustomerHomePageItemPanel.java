/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panels;

import HomePages.CustomerHomePage;
import ItemManipulation.AddItemFrame;
import customersshoppingcart.*;
import details.DetailPage;
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
    public JButton addProductButton = new JButton("+");
    //TODO: change "..." to an image of a magnifying glass
    private JButton detailsButton = new JButton("Details");
    private Item panelitem;
    private ImageIcon ii;
    
    /***
     * Constructor for CustomerHomePageItemPanel. Grabs details from Item class
     * @param item the current item for the cell
     * @param tempCart holds items added from the store
     * @param pricePanel the JPanel that holds current price and button to shopping cart view
     * @precondition item cannot be null, tempCart cannot be null
     * @postcondition Each panel is populated with specific information
     */
    public CustomerHomePageItemPanel(Item item, ArrayList<Item> tempCart, PriceShoppingCartPanel pricePanel,
            CustomerHomePage home) {
        this.panelitem = item;
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
        addProductButton.addActionListener(addToShoppingCart(item, tempCart, pricePanel, home));
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
    
    /***
     * Action Listener to add item to shopping cart array & update cost label in pricePanel
     * @param item the item of the current cell
     * @param tempCart temporary cart that holds items added by customer
     * @param pricePanel holds the current price of tempCart
     * @param home the CustomerHomePage that needs to be repainted
     * @precondition panel contains a valid Item
     * @postcondition price is updated when button is clicked
     * @return the action of adding to shopping cart and updating cart cost
     */
    private ActionListener addToShoppingCart(Item item, ArrayList<Item> tempCart, PriceShoppingCartPanel pricePanel,
            CustomerHomePage home) {
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
                //update the panel in the frame
                pricePanel.updateCart();
                pricePanel.repaintPriceValue();
                System.out.println("Current Price: " + pricePanel.getPriceSum());
                //repaint the parent JFrame?
                home.repaint();
            }           
        };
        return al;
    }
    
    /***
     * This action directs you to the details popup of the current Item
     * @precondition item cannot be null
     * @postcondition a pop up of the details screen appears
     * @return a pop u[ pf DetailPage
     */
    private ActionListener itemDetailsAction() {
        ActionListener al;
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DetailPage frame = new DetailPage(panelitem);
            }
        };
        return al;
    }
    
    /***
     * This function helps show the image by scaling it appropriatly 
     * @param w the width of the image
     * @param h the height of the image
     * @param img the actual image
     * @return a scaled version of a .jpeg image
     * @throws Exception 
     * @precondition have an image in jpeg form
     * @postcondition scales the image to its container
     */
    private static BufferedImage scaleImage(int w, int h, BufferedImage img) throws Exception {
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
