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
    
    private loginPanel loginPanel = new loginPanel();
    private JPanel northPanel = new JPanel();
    private boolean x = false;
    public loginPage(){
        super("login");
        northPanel.add(loginPanel);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add("North", northPanel);
       
    }
    public loginPanel getLoginPanel(){
        return loginPanel;
    }
    

}
