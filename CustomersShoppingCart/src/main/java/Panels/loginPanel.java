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
 *
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
    public boolean getLoginSuccess(){
        return loginSuccess; 
    }
    public loginPanel(){
        login.addActionListener(loginAction());
        register.addActionListener(registerAction());
        setLayout(new GridLayout(2,2));
        add(username);
        add(password);
        add(login);
        add(register);
    }
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
    private void createFolder(){
        if(!f.exists()){
            f.mkdirs();
        }
    }
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
    
    

