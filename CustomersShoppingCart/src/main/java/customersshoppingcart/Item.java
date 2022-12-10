/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customersshoppingcart;

import java.io.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * This class is for products in inventory. This is where all the items will be stored for the project.
 * any additional products added or subtracted will be reflected in here. 
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
     * @param quantitySold the quantity sold of the item
     * @param image location of image file
     */
    public Item(int itemId, String name, String description, double price, int quantity, int quantitySold, String image) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.imageFileLocation = image;
        this.quantitySold = quantitySold;
    }
    public void updateId(int id){
        this.itemId = id;
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
    
    /***
     * 
     * @return the item ID for each item
     */
    public int getItemId(){
        return itemId;
    }
    
   /***
    * 
    * @return name the name of the item. 
    */
    public String getName(){
        return name;
    }
    
    /***
     * 
     * @return the description of each item. 
     */
    public String description(){
        return description;
    }
    
    /***
     * 
     * @return price returns the price amount the item being sold.
     */
    public double getPrice(){
        return price;
    }
    
    /***
     * 
     * @return the quantity available. 
     */
    public int getQuantity(){
        return quantity;
    }
    
    /***
     * 
     * 
     * @return returns the amount sold. 
     */
    public int getQuantitySold(){
        return quantitySold;
    }
    
    /***
     * 
     * 
     * @return imageFileLocation the file location of the image displayed. 
     */
    public String getImageFileLocation(){
        return imageFileLocation;
    }
    
    /***
     * Adds the format for each item being sold.
     * @return itemId the item ID for each item
     * @return name The name of the item.
     * @return price the price of the item.
     * @return quantity the amount available of the item. 
     */
    @Override
    public String toString() {
        return itemId + " | " + name + " | " + price + " | " + quantity;
    }
    
    
    /***
     * sets the array for items
     * @return returns all the items within the array. 
     */
    public ArrayList<String> toArrayList(){
        ArrayList<String> itemArray = new ArrayList<>();
        //convert all attributes to string
        String itemIdString = Integer.toString(itemId);
        String priceString = Double.toString(price);
        String quantityString = Integer.toString(quantity);
        String quantitySoldString = Integer.toString(quantitySold);
        //add to arraylist
        itemArray.add(itemIdString);
        itemArray.add(name);
        itemArray.add(description);
        itemArray.add(priceString);
        itemArray.add(quantityString);
        itemArray.add(quantitySoldString);
        
        return itemArray;
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
