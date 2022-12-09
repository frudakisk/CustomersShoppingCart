/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panels;
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
    
    File f = new File("logins.txt");
    public boolean getLoginSuccess(){
        return loginSuccess; 
    }
    public loginPanel2(){
        username.setForeground(Color.LIGHT_GRAY);
        password.setForeground(Color.LIGHT_GRAY);
        username.addFocusListener(placeholderText("username", username));
        password.addFocusListener(placeholderText("password", password));
        login.addActionListener(loginAction());
        register.addActionListener(registerAction());
        setLayout(new GridLayout(2,2));
        add(username);
        add(password);
        add(login);
        add(register);
    }
    public Users getCurrentUser(){
        return currentUser;
    }

    private ActionListener loginAction() {
        ActionListener all;
        all = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = username.getText();
                char[] cpswrd = password.getPassword();
                String pswrd = new String(cpswrd);
                try {
                 
                    userStorage = readFile();
                    logic(user, pswrd);

                } catch (Exception ex) {

                    System.out.println(ex);

                }
            }

            
            
        };
        return all;
                
    }

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
   
    private void logic(String user, String pswrd) {
        for (Users i : userStorage){
            System.out.println(i.name+i.password);
            System.out.println(user+pswrd);
            if(i.verifyId(user, pswrd)){
               JOptionPane.showMessageDialog(null, "Login Successfully!!");
                    loginSuccess = true;
                    currentUser = i;
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
