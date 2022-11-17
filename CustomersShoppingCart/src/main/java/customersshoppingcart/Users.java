/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customersshoppingcart;

/**
 *
 * @author fruda
 */
public class Users {
    
    public Users(int id, String name, String password, boolean userStatus) {
        this.idNumber = id;
        this.name = name;
        this.password = password;
        this.userStatus = userStatus;
    }
    
    public void addCreditCard(int ccn) {
        this.creditCardNumber = ccn;
    }
    
    public int getCreditCard() {
        return creditCardNumber;
    }
    
    //case sensitive
    public boolean verifyId(String username, String password) {
        if (this.name == username && this.password == password) {
            return true;
        }
        return false;
    }
    
    
    //Attributes
    public int idNumber;
    public String name;
    public String password;
    private int creditCardNumber;
    public boolean userStatus;
}
