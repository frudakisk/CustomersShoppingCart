/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panels;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
/**
 * This class extends JPanel and presents login information
 * @author nicholasgiacobbe
 */
public class loginPanel extends JPanel {
    private JTextField username = new JTextField("username");
    private JPasswordField password = new JPasswordField("password");
    private JButton login = new JButton("Login");
    private JButton register = new JButton("Register");
    private boolean loginSuccess = false;
    File f = new File("C:\\Files");
    private int line;
    
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
     * Constructor for the loginPanel class.
     * @precondition components have been initialized
     * @postcondition components are added to panel
     */
    public loginPanel(){
        login.addActionListener(loginAction());
        register.addActionListener(registerAction());
        setLayout(new GridLayout(2,2));
        add(username);
        add(password);
        add(login);
        add(register);
    }
    
    /***
     * This action determines if a user can login or not based off of their credentials
     * @precondition username and password fields have been filled out
     * @postcondition login success value is set
     * @return the home page if the user logs in successfully
     */
    private ActionListener loginAction(){
        ActionListener all;
        all = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = username.getText();
                char[] cpswrd = password.getPassword();
                String pswrd = new String(cpswrd);
                try {

                    createFolder();
                    readFile();
                    countLines();
                    logic(user, pswrd);

                } catch (Exception ex) {

                    System.out.println(ex);

                }
            }
            
        };
        return all;
    }
    
    /***
     * This action directs you to the registration frame for a user to register
     * @precondition user is on login page
     * @postcondition user is in registration page
     * @return the registration frame
     */
    private ActionListener registerAction(){
        ActionListener alr;
        alr = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = username.getText();
                char[] cpswrd = password.getPassword();
                String pswrd = new String(cpswrd);
                
                try  
                {  
                   createFolder();
                   readFile();
                   countLines();
                   addData(user,pswrd);
                       
                     
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
     * Creates the folder to hold users if it does not exist
     * @precondition folder does not exist
     * @postcondition folder is created
     */
    private void createFolder(){
        if(!f.exists()){
            f.mkdirs();
        }
    }
    
    /***
     * Reads the file with user information and checks if the file exists
     * @precondition none
     * @postcondition tells us if logins.txt exist or is created
     */
    void readFile(){
        try {
            FileReader fr = new FileReader(f+"\\logins.txt");
            System.out.println("file exists!");
        } catch (FileNotFoundException ex) {
            try {
                FileWriter fw = new FileWriter(f+"\\logins.txt");
                System.out.println("File created");
            } catch (IOException ex1) {
               // Logger.getLogger(notepad.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
    }
    
    /***
     * Adds a user to the file associated with user information
     * @param username the new users username
     * @param password the new users password
     * @precondition username and password values are set
     * @postcondition a new user is added to the logins.txt file
     */
    void addData(String username,String password){
        try {
            RandomAccessFile raf = new RandomAccessFile(f+"\\logins.txt", "rw");
            for(int i=0;i<line;i++){
                raf.readLine();
            }
            //if condition added after video to have no lines on first entry
            if(line>0){
            raf.writeBytes("\r\n");
            raf.writeBytes("\r\n");
            }
            
            raf.writeBytes("Username:"+username+ "\r\n");
            raf.writeBytes("Password:"+password+"\r\n");
            raf.writeBytes("admin:0");
    
            
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(notepad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(notepad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /***
     * counts the number of lines in the logins.txt file
     * @precondition logins.txt file ,ust exist
     * @postcondition tells us how many lines are in the file
     */
    void countLines(){
        try {
            line=0;
            RandomAccessFile raf = new RandomAccessFile(f+"\\logins.txt", "rw");
            for(int i=0;raf.readLine()!=null;i++){
                line++;
            }
            System.out.println("number of lines:"+line);
        } catch (FileNotFoundException ex) {
           // Logger.getLogger(notepad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
           // Logger.getLogger(notepad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /***
     * Checks if the username and password entered are associated with an actual account
     * @param usr username in question
     * @param pswd password in question
     * @precondition username and password field contain values
     * @postcondition loginSuccess = true if credentials are valid
     */
    void logic(String usr, String pswd) {
        try {
            RandomAccessFile raf = new RandomAccessFile(f + "\\logins.txt", "rw");
            for (int i = 0; i < line; i += 3) {
                System.out.println("count " + i);
                System.out.println(line);
                String forUser = raf.readLine().substring(9);
                String forPswd = raf.readLine().substring(9);
                String forAdmin = raf.readLine().substring(6);
                System.out.println(forUser + forPswd+forAdmin);
                if (usr.equals(forUser) & pswd.equals(forPswd)) {
                    JOptionPane.showMessageDialog(null, "Login Successfully!!");
                    loginSuccess = true;
                    break;
                } 
                else if (i == (line-4)) {
                    JOptionPane.showMessageDialog(null, "incorrect username/password");
                    break;
                }
                for (int k = 1; k <= 1; k++) {
                    raf.readLine();
                    System.out.println("problem");
                }
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

    }   
}
    
    

