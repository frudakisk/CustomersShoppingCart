/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customersshoppingcart;

import java.io.*;
import javax.swing.ImageIcon;

/**
 * This class is for products in inventory
 * @author fruda
 */
public class Item implements Serializable{
    
    /***
     * Constructor for Item class
     * @param itemId the identification of the item
     * @param name the name of the item
     * @param description a short description of the item
     * @param price the price of the item
     * @param quantity the quantity of the item in stock
     */
    public Item(int itemId, String name, String description, double price, int quantity) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        //this.image = image;
    }
    
    /***
     * Sets a new price for an item
     * @param newPrice the new price of the item
     */
    public void updatePrice(double newPrice) {
        this.price = newPrice;
    }
    
    /***
     * Sets the new quantity of the item
     * @param newQuantity the new quantity of the item
     */
    public void updateQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }
    
    /***
     * sets the new quantity sold value
     * @param newSold new amount of item sold after each purchase
     */
    public void updateQuantitySold(int newSold) {
        this.quantitySold = newSold;
    }
    
    /***
     * sets a new name for an item
     * @param newName new name of the item
     */
    public void updateName(String newName) {
        this.name = newName;
    }
    
    /***
     * sets a new description of an item
     * @param newDescription new description for item
     */
    public void updateDescription(String newDescription) {
        this.description = newDescription;
    }
    
    /***
     * sets the image for an item
     * @param newImage the new image for the item
     */
    public void updateImage(ImageIcon newImage) {
        this.image = newImage;
    }
    
    @Override
    public String toString() {
        return itemId + " | " + name + " | " + price + " | " + quantity;
    }
    
    
    //Attributes
    public int itemId;
    public String name;
    public String description;
    public double price;
    public int quantity;
    public int quantitySold;
    public ImageIcon image;
}
