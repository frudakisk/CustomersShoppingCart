/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package details;
import customersshoppingcart.Item;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
/**
 * This class representds the frame for the details information
 * @author nicholasgiacobbe
 */
public class DetailPage extends JFrame {
    private Item item;
    private ImageIcon ii;
    private JLabel priceTitle = new JLabel("Price: ");
    private JLabel quantityTitle = new JLabel("Quantity: ");
    private JLabel blank = new JLabel("       ");
    private JLabel imageLabel = new JLabel();
    private JLabel itemLabel = new JLabel();
    private JLabel quantityLabel = new JLabel();
    private JLabel priceLabel = new JLabel();
    private JLabel descriptionLabel = new JLabel();
    private JPanel northPanel = new JPanel();
    private JPanel centerPanel = new JPanel();
    private JPanel southPanel = new JPanel();
    private JPanel bottomPanel = new JPanel();
    /***
     * constructor
     * @param temp item to pull and populated data
     * @precondition item is ready to be passed in
     * @postcondtion detail page is generated
     */
    public DetailPage(Item temp){
        super("Details");
        northPanel.setLayout(new GridLayout(1,1));
        this.item = temp;
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
        northPanel.add(imageLabel);
        itemLabel.setText(item.getName());
        String priceString = Double.toString(item.getPrice());
        priceLabel.setText(priceString);
        String quantityString = Integer.toString(item.getQuantity());
        quantityLabel.setText(quantityString);
        centerPanel.setLayout(new GridLayout(2,3));
        
        centerPanel.add(itemLabel);
        centerPanel.add(priceTitle);
        centerPanel.add(priceLabel);
        centerPanel.add(blank);
        centerPanel.add(quantityTitle);
        centerPanel.add(quantityLabel);
        southPanel.setLayout(new GridLayout(1,1));
        descriptionLabel.setText(item.description());
        southPanel.add(descriptionLabel);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add("North", northPanel);
        this.getContentPane().add("Center",centerPanel);
        this.getContentPane().add("South",southPanel);
        
        
        this.setSize(500,500);
        this.setVisible(true);
        
    }
    /***
     * 
     * @param w desired width of the image int
     * @param h desired height of the image int
     * @param img image
     * @return returns a BufferedImage
     * @throws Exception image does not exist
     * @precondition image and desired size is passed in
     * @postcondtion image is scaled and returned
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
