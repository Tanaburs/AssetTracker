package assettracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Created by Steve Williamson on 18/02/2016.
 */
public class LoginMain
{
    private String user;
    private String password;
    private int loginID;
    private boolean allowLogin = false;
    
    //------Method 1. Main Method.------
    public static void main(String[] args)
    {
        LoginMain form1 = new LoginMain();//Creates a new LoginMain object, form1
        form1.loginForm();//Runs the loginForm method of the form1 object
        DBConnect con = new DBConnect();
        con.DBConnect();
        con.close();
    }
     
    //------Method 2. Launches a Login Form.------
    public void loginForm() {
        //------Creates a Frame------
        JFrame myFrame = new JFrame("Asset Management System");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setBounds(500,500,600,250);
        myFrame.setLocationRelativeTo(null);
        myFrame.setLayout(null);//Overrides Java to allow manual setup of layout.
        myFrame.setResizable(false);
        myFrame.setAutoRequestFocus(true);
        myFrame.getContentPane().setBackground(Color.decode("#B0C4DE"));

        //------Creates Panels, mutiple panels used to format the layout within the frame.------
        JPanel loginPanel1 = new JPanel();
        loginPanel1.setBackground(Color.decode("#B0C4DE"));
        loginPanel1.setBounds(0, 0, 400, 50);

        JPanel loginPanel2=new JPanel();
        loginPanel2.setBackground(Color.decode("#B0C4DE"));
        loginPanel2.setBounds(0,50,400,50);

        JPanel loginPanel3=new JPanel();
        loginPanel3.setBackground(Color.decode("#B0C4DE"));
        loginPanel3.setBounds(30,100,400,50);

        JPanel loginPanel4=new JPanel();
        loginPanel4.setBackground(Color.decode("#B0C4DE"));
        loginPanel4.setBounds(400,0,100,100);

        //------Creates Graphic Icon Label.------
        JLabel iconL=new JLabel();
        ImageIcon myIcon=new ImageIcon("lib\\login2.png");
        Image scaleMyImage=myIcon.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        iconL.setIcon(new ImageIcon(scaleMyImage));
        
        //------Creates Labels.------
        JLabel userL = new JLabel("UserName");//--Creates a label
        JTextField userF = new JTextField(10);//--Creates a text field
        JLabel passwordL = new JLabel("Password");
        JTextField passwordF = new JTextField(10);
        
        //------Creates Buttons.------
        JButton submitBut = new JButton("Submit");
        JButton cancelBut = new JButton("Cancel");

        //------Adds Labels and Buttons to the Panels.------
        loginPanel1.add(userL);
        loginPanel1.add(userF);
        loginPanel2.add(passwordL);
        loginPanel2.add(passwordF);
        loginPanel3.add(submitBut);
        loginPanel3.add(cancelBut);
        loginPanel4.add(iconL);

        //------Adds the Panels to the Frame.------
        myFrame.add(loginPanel1);
        myFrame.add(loginPanel2);
        myFrame.add(loginPanel3);
        myFrame.add(loginPanel4);
        myFrame.setVisible(true);

        //------Assigning listeners to the buttons.------
        //------Assigns listener to submit button, checks the database for valid login credentials and creates an object of the InputForm Class if successful.------
        submitBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                user = userF.getText();//Sets the user variable to the value of the username field.
                password = passwordF.getText();//Sets the password variable to the value of the password field.
                DBConnect connect = new DBConnect(); //Creates a new DBConnect object
                try
                {
                    ResultSet rs = connect.query("select * from user");//Runs a query using the query method from the connect object.
                    //------Loop runs through the user table to find a match of username and password, if successful it sets the allowLogin variable to true.
                    while (rs.next())
                    {
                        {
                            if(rs.getString("userName").equals(user)&&rs.getString("password").equals(password))
                            {
                                allowLogin = true;
                                System.out.println("Login Succesful)");
                                break;
                            }
                        }
                    } 
                    //------Checks the allowLogin variable has been set to true, which will allow login, otherwise displays a login unsuccessful message.
                    if (allowLogin==true)
                    {
                        loginID = rs.getInt("idUser");
                        System.out.println(loginID);
                        InputForm newForm = new InputForm();
                        newForm.AssetTracker(loginID);
                        myFrame.dispose();
                    }
                    else
                    {
                    JOptionPane.showMessageDialog(myFrame, "Incorrect Username or Password");
                    }
                }
                catch(Exception exp)
                {
                    System.out.println ("Error: "+exp);
                }
                connect.close();
            }
            
        });

        //Listener for cancel button, clears text fields.
        cancelBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userF.setText("");
                passwordF.setText("");
            }
        });
        
       
    }
   
}
