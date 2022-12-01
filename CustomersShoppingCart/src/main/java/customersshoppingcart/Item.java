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
     * @param image location of image file
     */
    public Item(int itemId, String name, String description, double price, int quantity, String image) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.imageFileLocation = image;
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
    public void updateImage(String newImage) {
        this.imageFileLocation = newImage;
    }
    public int getItemId(){
        return itemId;
    }
    public String getName(){
        return name;
    }
    public String description(){
        return description;
    }
    public double getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }
    public int getQuantitySold(){
        return quantitySold;
    }
    public String getImageFileLocation(){
        return imageFileLocation;
    }
    @Override
    public String toString() {
        return itemId + " | " + name + " | " + price + " | " + quantity;
    }
    
    
    //Attributes
    private int itemId;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private int quantitySold;
    private String imageFileLocation;
}
