/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panels;

import HomePages.SellerHomePage;
import ItemManipulation.EditItemFrame;
import customersshoppingcart.Item;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *This class produces the item panel that will be displayed on the 
 * admin home page.
 * @author fruda
 */
public class AdminHomePageItemPanel extends JPanel{
    private JLabel name = new JLabel("Name");
    private JLabel picture = new JLabel();
    private JLabel price = new JLabel("$0.00");
    private JLabel quantity = new JLabel("Quantity: 0");
    private JButton editItem = new JButton("Edit");
    private Item storeditem;
    private ImageIcon ii;
    private SellerHomePage storedframe;
    
    /***
     * Constructor for the Item Panel.
     * @param item of type Item that the panel will display information about
     * @precondition Have Item to work with
     * @postcondition Display information about the item
     */
    public AdminHomePageItemPanel(Item item) {
        this.storeditem = item;
        //this.storedframe = frame;
        //set components with actual data
        name.setText(item.getName());
        String priceString = Double.toString(item.getPrice());
        price.setText(priceString);
        String quantityString = Integer.toString(item.getQuantity());
        quantity.setText(quantityString);
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
                picture.setIcon(ii);
            }
        };
        sw.execute();
        
        
        
        //Setting up the item details panel
        setLayout(new GridLayout(1,5));
        add(picture);
        add(name);
        add(price);
        add(quantity);
        add(editItem);
        editItem.addActionListener(goToEditFrame());
    }

    /***
     * Action Listener to transition from current page to the edit frame
     * @precondition a button has this action listener attatched to it
     * @postcondition the current frame is close and EditItemFrame is opened
     * @return the action of opening up the edit page
     */
    private ActionListener goToEditFrame() {
         ActionListener al;
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //open the add item frame
                final Window parentWindow = SwingUtilities.getWindowAncestor(AdminHomePageItemPanel.this);
                parentWindow.dispose();
                System.out.println("Add Item button clicked!");
                EditItemFrame editframe = new EditItemFrame(storeditem, storedframe);
                editframe.setSize(500,500);
                editframe.setVisible(true);
                editframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
