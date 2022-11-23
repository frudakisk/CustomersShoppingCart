/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customersshoppingcart;
import java.io.*;
/**
 * This class contains information about each user (customer or seller)
 * @author fruda
 */
public class Users implements Serializable {
    
    /***
     * Constructor for the user class
     * @param id unique id for user
     * @param name name of user
     * @param password password for user login
     * @param userStatus customer or seller
     */
    public Users(int id, String name, String password, boolean userStatus) {
        this.idNumber = id;
        this.name = name;
        this.password = password;
        this.userStatus = userStatus;
    }
    
    /***
     * set the credit card number for a user
     * @param ccn integer value
     */
    public void addCreditCard(int ccn) {
        this.creditCardNumber = ccn;
    }
    
    /***
     * get the credit card number
     * @return this.creditCardNumber
     */
    public int getCreditCard() {
        return creditCardNumber;
    }
    
    /***
     * verify the login information. This is case sensitive 
     * @param username username of attempting user
     * @param password password of attempting user
     * @return boolean - true if info found, false otherwise
     */
    public boolean verifyId(String username, String password) {
        return (this.name.equals(username) && this.password.equals(password));
    }
    
    
    //Attributes
    public int idNumber;
    public String name;
    public String password;
    private int creditCardNumber;
    public boolean userStatus;
}
