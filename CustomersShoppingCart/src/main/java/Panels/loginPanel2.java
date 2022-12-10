/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panels;
import HomePages.CustomerHomePage;
import HomePages.SellerHomePage;
import customersshoppingcart.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author nicholasgiacobbe
 */
public class loginPanel2 extends JPanel {
    private JTextField username = new JTextField("username");
    private JPasswordField password = new JPasswordField("password");
    private JButton login = new JButton("Login");
    private JButton register = new JButton("Register");
    private boolean loginSuccess = false;
    private Users currentUser;
    private ArrayList<Users> userStorage= new ArrayList<>();
    private ArrayList<Item> itemArray = new ArrayList<>();
    File f = new File("logins.txt");
    
    /***
     * Lets us know if the users login was successful or not
     * @precondition loginSuccess must be initialized
     * @postcondition return true or false based value
     * @return loginSuccess - boolean
     */
    public boolean getLoginSuccess(){
        return loginSuccess; 
    }
    
    /***
     * Constructor for the loginPanel2 class
     * @param temp the inventory array list
     * @param home the home Frame for this panel
     * @precondition temp is not empty
     * @postcondition components are set in the panel
     */
    public loginPanel2(ArrayList<Item> temp, JFrame home){
        this.itemArray = temp;
        login.addActionListener(loginAction(home));
        username.setForeground(Color.LIGHT_GRAY);
        password.setForeground(Color.LIGHT_GRAY);
        username.addFocusListener(placeholderText("username", username));
        password.addFocusListener(placeholderText("password", password));
        register.addActionListener(registerAction());
        setLayout(new GridLayout(2,2));
        add(username);
        add(password);
        add(login);
        add(register);
    }
    
    /***
     * retrieves the current user
     * @precondition someone is logged in
     * @postcondition given the User
     * @return currentUser
     */
    public Users getCurrentUser(){
        return currentUser;
    }

    /***
     * The action that allows a user to login
     * @param home the parent frame of this panel component
     * @precondition username and password fields must be set
     * @postcondition user is potentially logged in
     * @return the home page of the customer or seller
     */
    private ActionListener loginAction(JFrame home) {
        ActionListener all;
        all = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = username.getText();
                char[] cpswrd = password.getPassword();
                String pswrd = new String(cpswrd);
                try {
                 
                    userStorage = readFile();
                    logic(user, pswrd, home);

                } catch (Exception ex) {

                    System.out.println(ex);

                }
            }

            
            
        };
        return all;
                
    }

    /***
     * Leads the user to registration frame
     * @precondition user has no account
     * @postcondition user now has an account
     * @return a new account
     */
    private ActionListener registerAction() {
        ActionListener alr;
                alr = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String user = username.getText();
                        char[] cpswrd = password.getPassword();
                        String pswrd = new String(cpswrd);
                        boolean userSts = false;
                        int id;
                        try  
                        {  
                           
                           
                              userStorage = readFile();
                              id = userStorage.size() - 1;
                              Users newUser = new Users(id, user, pswrd, userSts);
                              userStorage.add(newUser);  
                           
                           addData(userStorage);


                            JOptionPane.showMessageDialog(register, "Data Saved Successfully");   
                        }  
                        catch (Exception ex)   
                        {  
                            System.out.println(ex);  
                        }  
                    }

                };
                return alr;    
    }
    
    /***
     * Adds a user to the file associated with user information
     * @param userStorage the array that holds all users 
     * @precondition new user was created
     * @postcondition new user is saved into the logins.txt file
     */
    private void addData(ArrayList<Users> userStorage){
        try
        {
            FileOutputStream fos = new FileOutputStream("logins.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(userStorage);
            oos.close();
            fos.close();
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
        }
        
    }
    
    /***
     * read and load an array list with data from the logins.txt file
     * @precondition logins.txt file exist
     * @postcondition logins.txt data stored in an array list
     * @return userTemp - an array list of users
     */
    private ArrayList<Users> readFile(){
        ArrayList<Users> userTemp = new ArrayList<>();
        try
        {
            FileInputStream fis = new FileInputStream("logins.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
 
            userTemp = (ArrayList) ois.readObject();
            
            ois.close();
            fis.close();
            
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
          
        } 
        catch (ClassNotFoundException c) 
        {
            System.out.println("Class not found");
            c.printStackTrace();
     
        }
        return userTemp;
    }
   
    /***
     * checks if username and password are valid credentials
     * @param user username in question
     * @param pswrd password in question
     * @param home home frame
     * @precondition username and password fields have values
     * @postcondition user is logged in or not
     */
    private void logic(String user, String pswrd, JFrame home) {
        for (Users i : userStorage){
            System.out.println(i.name+i.password);
            System.out.println(user+pswrd);
            if(i.verifyId(user, pswrd)){
               JOptionPane.showMessageDialog(null, "Login Successfully!!");
                    CustomerHomePage customerHomePage = new CustomerHomePage(itemArray);
                    SellerHomePage sellerHomePage = new SellerHomePage(itemArray);
                    
                    loginSuccess = true;
                    currentUser = i;
                    //this window should be the current screen
                    JFrame window = home;
                    if (loginSuccess){
                        window.dispose();
                        System.out.println("Window should be disposed");
                        if(currentUser.userStatus){
                        window = sellerHomePage;
                        }
                        else if(!currentUser.userStatus){
                            window = customerHomePage;
                        }
                        window.setSize(500,500);
                        window.setVisible(true);
                        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    }
                    
                    
                    
                    
                    break; 
            }
        }
        if (!loginSuccess){
            JOptionPane.showMessageDialog(null, "incorrect username/password");
        }
        
    }
    
    /***
     * FocusListener to make watermark text on the username and password field
     * @param text placeholder text
     * @param field the text field to hold a watermark 
     * @return fl - the focus listener
     */
    public FocusListener placeholderText(String text, JTextField field) {
        FocusListener fl;
        fl = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(field.getForeground() == Color.LIGHT_GRAY){
                    System.out.println("color is light gray");
                    field.setForeground(Color.BLACK);
                    field.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                System.out.println("focusLost: " + field.getText());
                if(field.getText().equals(text) || field.getText().equals("")) {
                    field.setForeground(Color.LIGHT_GRAY);
                    field.setText(text);
                }
            }
            
        };
        return fl;
    }
}
