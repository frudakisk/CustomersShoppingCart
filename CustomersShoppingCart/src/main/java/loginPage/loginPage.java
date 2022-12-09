/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginPage;
import customersshoppingcart.*;
import HomePages.*;
import Panels.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
/**
 *
 * @author nicholasgiacobbe
 */
public class loginPage extends JFrame {
    private ArrayList<Item> itemArray = new ArrayList<>();
    private loginPanel2 loginPanel;
    private JPanel northPanel = new JPanel();
    private boolean x = false;
    public loginPage(ArrayList<Item> temp){
        super("login");
        this.itemArray = temp;
        this.loginPanel = new loginPanel2(itemArray);
        northPanel.add(loginPanel);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add("North", northPanel);
       
    }
    public loginPanel2 getLoginPanel(){
        return loginPanel;
    }
    

}
