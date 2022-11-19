/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customersshoppingcart;

import javax.swing.ImageIcon;

/**
 *
 * @author fruda
 */
public class Item {
    
    public Item(int itemId, String name, String description, double price, int quantity) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        //this.image = image;
    }
    
    public void updatePrice(double newPrice) {
        this.price = newPrice;
    }
    
    public void updateQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }
    
    public void updateQuantitySold(int newSold) {
        this.quantitySold = newSold;
    }
    
    public void updateName(String newName) {
        this.name = newName;
    }
    
    public void updateDescription(String newDescription) {
        this.description = newDescription;
    }
    
    public void updateImage(ImageIcon newImage) {
        this.image = newImage;
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
