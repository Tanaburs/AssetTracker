package assettracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Created by Steve Williamson on 18/02/2016.
 */
public class InputForm 
{
    private JTextField vehMakeF;
    private JTextField vehModelF;
    private JComboBox vehLocationF;
    private JComboBox vehRStatusF;
    private JTextField vehOwnerF;
    private JTextField vehMileageF;
    private JTextField vehColourF;
    private JTextField vehHistoryF;
    private JTextField vehAssetF;
    private JTextField cAssetF;
    private JTextField cMakeF;
    private JTextField cModelF;
    private JComboBox cLocationF;
    private JComboBox cRStatusF;
    private JTextField cOwnerF;
    private int login;
    private JFrame mainFrame;

    //------Method 1. Creates the main form using the loginID from the LoginMain form.------
    public void AssetTracker(int loginID)
    {
        this.login = loginID;//loginID is assigned to a local variable to enable tracking of which users have made amendments.
        //------Creates a new Frame.------
        mainFrame = new JFrame("Asset Tracker");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(null);
        mainFrame.setAutoRequestFocus(true);
        mainFrame.setBounds(700, 0, 800, 400);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.getContentPane().setBackground(Color.decode("#B0C4DE"));
        mainFrame.setVisible(true);

        //------Creates the label.
        JLabel selectL= new JLabel("Select Equipment Type: ");

        //------Creates the Main panel buttons.
        JRadioButton radioBut1= new JRadioButton("Vehicles");
        JRadioButton radioBut2= new JRadioButton("CIS Equipment");
        JButton logoutBut= new JButton("Logout");

        //------Creates Main Panel.
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.decode("#B0C4DE"));
        mainPanel.add(selectL);
        mainPanel.add(radioBut1);
        mainPanel.add(radioBut2);
        mainPanel.add(logoutBut);
        mainFrame.add(mainPanel);
        mainPanel.setBounds(0, 0, 800, 120);

        //------Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(radioBut1);
        group.add(radioBut2);

        //------Creates Vehicle Panel1.
        JPanel vehPanel1 = new JPanel();
        vehPanel1.setVisible(false);
        vehPanel1.setBounds(0, 120, 800, 50);
        vehPanel1.setBackground(Color.decode("#B0C4DE"));
        mainFrame.add(vehPanel1);

        //------Creates Vehicle Panel2.
        JPanel vehPanel2 = new JPanel();
        vehPanel2.setVisible(false);
        vehPanel2.setBounds(0, 170, 800, 50);
        vehPanel2.setBackground(Color.decode("#B0C4DE"));
        mainFrame.add(vehPanel2);

        //------Creates Vehicle Panel3.
        JPanel vehPanel3 = new JPanel();
        vehPanel3.setVisible(false);
        vehPanel3.setBounds(0, 220, 800, 50);
        vehPanel3.setBackground(Color.decode("#B0C4DE"));
        mainFrame.add(vehPanel3);

        //------Creates Vehicle Panel4.
        JPanel vehPanel4 = new JPanel();
        vehPanel4.setVisible(false);
        vehPanel4.setBounds(0, 270, 800, 50);
        vehPanel4.setBackground(Color.decode("#B0C4DE"));
        mainFrame.add(vehPanel4);

        //-----Creates CIS Panel1.
        JPanel cisPanel1 = new JPanel();
        cisPanel1.setVisible(false);
        cisPanel1.setBounds(0, 120, 800, 50);
        cisPanel1.setBackground(Color.decode("#B0C4DE"));
        mainFrame.add(cisPanel1);

        //------Creates CIS Panel2.
        JPanel cisPanel2 = new JPanel();
        cisPanel2.setVisible(false);
        cisPanel2.setBounds(0, 170, 800, 50);
        cisPanel2.setBackground(Color.decode("#B0C4DE"));
        mainFrame.add(cisPanel2);

        //------Creates CIS Panel3.
        JPanel cisPanel3 = new JPanel();
        cisPanel3.setVisible(false);
        cisPanel3.setBounds(0, 220, 800, 50);
        cisPanel3.setBackground(Color.decode("#B0C4DE"));
        mainFrame.add(cisPanel3);

        //------Creates CIS Panel4.
        JPanel cisPanel4 = new JPanel();
        cisPanel4.setVisible(false);
        cisPanel4.setBounds(50, 270, 800, 30);
        cisPanel4.setBackground(Color.decode("#B0C4DE"));
        mainFrame.add(cisPanel4);

        //------Creates vehPanel Elements.
        JLabel vehAssetL= new JLabel("Registration: ");
        vehAssetF = new JTextField(10);

        JLabel vehMakeL=new JLabel ("Make: ");
        vehMakeF= new JTextField(10);

        JLabel vehModelL=new JLabel("Model: ");
        vehModelF= new JTextField(10);

        JLabel vehLocationL=new JLabel("Location: ");
        String[] vLocString = {"FOB Alpha","FOB Bravo","UK","Unknown"};
        vehLocationF= new JComboBox(vLocString);

        JLabel vehRStatusL=new JLabel("Repair Status: ");
        String[] vRStatusString = {"Repaired", "Under Repair", "Awaiting Repair"};
        vehRStatusF= new JComboBox(vRStatusString);

        JLabel vehOwnerL=new JLabel("Owner: ");
        vehOwnerF= new JTextField(10);

        JLabel vehMileageL=new JLabel("Mileage: ");
        vehMileageF= new JTextField(10);

        JLabel vehColourL=new JLabel("Colour: ");
        vehColourF= new JTextField(10);

        JLabel vehHistoryL=new JLabel("Service History: ");
        vehHistoryF= new JTextField(10);

        JLabel vehSearchL= new JLabel("Search for or update a Record: ");
        JLabel cSearchL= new JLabel("Search for or update a record: ");
        JButton vehSearchBut= new JButton("Search");
        JButton vehAddBut= new JButton("Update");
        JButton vehDeleteBut = new JButton("Delete");
        JButton cSearchBut= new JButton("Search");
        JButton cAddBut= new JButton("Update");
        JButton cisDeleteBut = new JButton("Delete");
        JButton vehClearBut= new JButton("Clear Form");
        JButton cisClearBut= new JButton("Clear Form");
        
        //------Creates cisPanel Elements
        JLabel cAssetL= new JLabel("Serial Number: ");
        cAssetF= new JTextField(10);

        JLabel cMakeL=new JLabel ("Make: ");
        cMakeF= new JTextField(10);

        JLabel cModelL=new JLabel("Model: ");
        cModelF= new JTextField(10);

        JLabel cLocationL=new JLabel("Location: ");
        String[] cLocationString = {"FOB Alpha", "FOB Bravo", "UK", "Unknown"};
        cLocationF= new JComboBox(cLocationString);

        JLabel cRStatusL=new JLabel("Repair Status: ");
        String[] cRStatusString = {"Repaired", "Under Repair", "Awaiting Repair"};
        cRStatusF= new JComboBox(cRStatusString);

        JLabel cOwnerL=new JLabel("Owner: ");
        cOwnerF= new JTextField(10);

        //------Adding vehPanel1 elements to the panel.
        vehPanel1.add(vehSearchL);
        vehPanel1.add(vehSearchBut);
        vehPanel1.add(vehAddBut);
        vehPanel1.add(vehClearBut);
        vehPanel1.add(vehDeleteBut);

        //------Adding vehPanel2 elements to the panel.
        vehPanel2.add(vehAssetL);
        vehPanel2.add(vehAssetF);
        vehPanel2.add(vehMakeL);
        vehPanel2.add(vehMakeF);
        vehPanel2.add(vehModelL);
        vehPanel2.add(vehModelF);

        //------Adding vehPanel3 elements to the panel.
        vehPanel3.add(vehRStatusL);
        vehPanel3.add(vehRStatusF);
        vehPanel3.add(vehLocationL);
        vehPanel3.add(vehLocationF);
        vehPanel3.add(vehOwnerL);
        vehPanel3.add(vehOwnerF);

        //------Adding vehPanel4 elements to the panel.
        vehPanel4.add(vehMileageL);
        vehPanel4.add(vehMileageF);
        vehPanel4.add(vehColourL);
        vehPanel4.add(vehColourF);
        vehPanel4.add(vehHistoryL);
        vehPanel4.add(vehHistoryF);

        //------Adding cisPanel1 elements to the panel.
        cisPanel1.add(cSearchL);
        cisPanel1.add(cSearchBut);
        cisPanel1.add(cAddBut);
        cisPanel1.add(cisClearBut);
        cisPanel1.add(cisDeleteBut);

        //-----Adding cisPanel2 elements to the panel.
        cisPanel2.add(cAssetL);
        cisPanel2.add(cAssetF);
        cisPanel2.add(cMakeL);
        cisPanel2.add(cMakeF);
        cisPanel2.add(cModelL);
        cisPanel2.add(cModelF);

        //------Adding cisPanel3 elements to the panel.
        cisPanel3.add(cRStatusL);
        cisPanel3.add(cRStatusF);
        cisPanel3.add(cLocationL);
        cisPanel3.add(cLocationF);
        cisPanel3.add(cOwnerL);
        cisPanel3.add(cOwnerF);

        //------Assigns listeners to the radio buttons.
        radioBut1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(radioBut1.isSelected())
                {
                    //Makes the vehicle panels visible.
                    vehPanel1.setVisible(true);
                    vehPanel2.setVisible(true);
                    vehPanel3.setVisible(true);
                    vehPanel4.setVisible(true);
                    
                    //Hides the CIS panels.
                    cisPanel1.setVisible(false);
                    cisPanel2.setVisible(false);
                    cisPanel3.setVisible(false);
                    cisPanel4.setVisible(false);
                }
            }
        });

        radioBut2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(radioBut2.isSelected())
                {
                    //Hides the vehicle panels.
                    vehPanel1.setVisible(false);
                    vehPanel2.setVisible(false);
                    vehPanel3.setVisible(false);
                    vehPanel4.setVisible(false);
                    
                    //Makes the CIS panels visible.
                    cisPanel1.setVisible(true);
                    cisPanel2.setVisible(true);
                    cisPanel3.setVisible(true);
                    cisPanel4.setVisible(true);
                }
            }
        });

        //------Assigns listener to the logout button.
        logoutBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(mainFrame, "Logout Successful");
                mainFrame.dispose();
                onLogOut();
            }
        });

        //------Assigns listener to the vehClearBut.
        vehClearBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                vehAssetF.setText("");
                vehMakeF.setText("");
                vehModelF.setText("");
                vehRStatusF.setSelectedIndex(1);
                vehLocationF.setSelectedIndex(1);
                vehOwnerF.setText("");
                vehMileageF.setText("");
                vehColourF.setText("");
                vehHistoryF.setText("");
            }
        });

        //------Assigns listener to the cisClearBut.
        cisClearBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                cAssetF.setText("");
                cMakeF.setText("");
                cModelF.setText("");
                cRStatusF.setSelectedIndex(1);
                cLocationF.setSelectedIndex(1);
                cOwnerF.setText("");
            }
        });

        //------Assigns listener to the vehSearchBut
        vehSearchBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onVehSearchBut();
            }
        });

        //------Assigns listener to the vehAddBut
        vehAddBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onAddVeh();//Calls the onAddVeh Method.
            }
        });

        //------Assigns listener to the cSearchBut.
        cSearchBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCisSearchBut();//Calls the onCisSearchBut Method.
            }
        });
        
        //------Assigns listener to the cAddbut.
        cAddBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onAddCis();
            }
        });
        
        //------Assigns listener to the vehDeleteBut.
        vehDeleteBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                onVehDeleteBut();//Calls the onVehDeleteBut Method.
                vehAssetF.setText("");
                vehMakeF.setText("");
                vehModelF.setText("");
                vehRStatusF.setSelectedIndex(1);
                vehLocationF.setSelectedIndex(1);
                vehOwnerF.setText("");
                vehMileageF.setText("");
                vehColourF.setText("");
                vehHistoryF.setText("");    
            }
        });
        
        //------Assigns listener to the cisDeleteBut.
        cisDeleteBut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                onCisDeleteBut();//Calls the onCisDeleteBut Method.
                cAssetF.setText("");
                cMakeF.setText("");
                cModelF.setText("");
                cRStatusF.setSelectedIndex(1);
                cLocationF.setSelectedIndex(1);
                cOwnerF.setText("");
            }
        });
    }
    
    //------Method 2. Updates vehicles records within the database.
    private void onAddVeh()
    {
        //Creating a new vehicle object and assigning the variables.
        Vehicle veh1=new Vehicle();
        veh1.setAssetID(vehAssetF.getText());
        veh1.setMake(vehMakeF.getText());
        veh1.setModel(vehModelF.getText());
        veh1.setLocation((String) vehLocationF.getSelectedItem());
        veh1.setRepairStatus((String)vehRStatusF.getSelectedItem());
        veh1.setOwner(vehOwnerF.getText());
        veh1.setVehColour(vehColourF.getText());
        veh1.setVehMileage(vehMileageF.getText());
        veh1.setVehServiceHistory(vehHistoryF.getText());
        
        //------Ensures the assetID field is populated before updating a record.
        if(veh1.getAssetID().equals(""))
        {
            JOptionPane.showMessageDialog(mainFrame, "An Asset ID must be entered to create a record!");
        }
        else
        {
            String make = veh1.getMake();
            String model = veh1.getModel();
            int repairStatus = 1;
            int location = 2;
            String owner = veh1.getOwner();
            int mileage;
            if(veh1.getVehMileage().equals(""))// Checks to ensure the value given for mileage is not empty before converting to an int datatype
            {
                mileage = 0; //sets the mileage to 0 (Unknown) in database
            }
            else
            {
                mileage = Integer.parseInt(veh1.getVehMileage());//Converts the String value for mileage into an int datatype
            }
            String colour = veh1.getVehColour();
            String serviceHistory = veh1.getVehServiceHistory();
            int createdBy = this.login;//Gets the user login to associate with the creation of this record
            int equipmentType = 1;//Sets the equipment type to 1 in the database, this represents a vehicle
            String assetID = veh1.getAssetID();
            DBConnect connect = new DBConnect(); //Creates a new DBConnect object
                try
                {
                    String loc = (String)vehLocationF.getSelectedItem();
                    String status = (String)vehRStatusF.getSelectedItem();
                    ResultSet rs1 = connect.query("SELECT * FROM location "+"WHERE locationName = '"+loc+"'");
                    ResultSet rs2 = connect.query("SELECT * FROM repairstatus "+"WHERE repairStatus = '"+status+"'");
                    while (rs1.next())
                     {
                        location = rs1.getInt("idLocation");
                     }
                     while (rs2.next())
                     {
                        repairStatus = rs2.getInt("idRepairStatus");
                     }
                }

                catch(Exception exp1)
                {
                     System.out.println("Error: "+exp1);
                }
                try
                {
                     ResultSet rs = connect.query("SELECT * FROM equipment "+"WHERE assetID = '"+assetID+"'");
                     //This while loop checks the database to ensure there is no entry already exisiting with the assetID to ensure database integrity
                     int counter = 0;
                     while (rs.next())
                     {
                        counter = counter+1;
                     }
                     if(counter ==0)
                     {
                     //String to be used in the SQL statement
                     String input = "?, "+location+", '"+make+"', '"+model+"', "+repairStatus+", '"+owner+"', "+mileage+", '"+colour+"', '"
                     +serviceHistory+"', "+createdBy+", "+equipmentType+", '"+assetID+"'";
                     //Calls the enterData method to insert a new row into the equipment table
                     connect.enterData("INSERT INTO equipment "+"VALUES ("+input+")");
                     JOptionPane.showMessageDialog(mainFrame, "Record successfully entered");//Feedback window to inform the record has been entered to the database
                     //Code below clears down the fields to prepare them for a new entry
                     vehAssetF.setText("");
                     vehMakeF.setText("");
                     vehModelF.setText("");
                     vehRStatusF.setSelectedIndex(1);
                     vehLocationF.setSelectedIndex(1);
                     vehOwnerF.setText("");
                     vehMileageF.setText("");
                     vehColourF.setText("");
                     vehHistoryF.setText("");
                     }
                     else//else statement to inform the user if they attempt to enter a prexisiting record
                     {
                        connect.enterData("UPDATE equipment SET location='"+location+"',make='"+make+"',model='"+model+"',repairStatus='"+repairStatus+"',"
                        + "owner='"+owner+"',mileage='"+mileage+"',colour='"+colour+"',serviceHistory='"+serviceHistory+"',createdBy='"+createdBy+"',equipmentType='"
                        +equipmentType+"' WHERE assetID='"+assetID+"'");
                        JOptionPane.showMessageDialog(mainFrame, "Record already exists, existing record updated");
                     }
                }
                catch(Exception exp)
                {
                    System.out.println ("Error: "+exp);
                }
                connect.close();
        }
                
    }
    
    //------Method 3. Searches vehicle records within the database.
    private void onVehSearchBut()//Method to perform a search on the database for records matching the asset ID
    {
        DBConnect connect = new DBConnect(); //Creates a new DBConnect object
        try
        {
            String input = vehAssetF.getText();
            //Calls the enterData method to insert a new row into the equipment table
            ResultSet rs = connect.query("SELECT * FROM equipment "+"WHERE assetID = '"+input+"'");//Searches the database for records with the matching assetID
            while (rs.next())
                {
                    vehAssetF.setText(rs.getString("assetID"));
                    vehMakeF.setText(rs.getString("make"));
                    vehModelF.setText(rs.getString("model"));
                    ResultSet rs1 = connect.query("SELECT * FROM repairStatus "+"WHERE idRepairStatus = '"+rs.getInt("repairStatus")+"'");
                    while (rs1.next())
                        {
                            vehRStatusF.setSelectedItem(rs1.getString("repairStatus"));
                        }
                    ResultSet rs2 = connect.query("SELECT * FROM location "+"WHERE idLocation = '"+rs.getInt("location")+"'");
                    while (rs2.next())
                        {
                            vehLocationF.setSelectedItem(rs2.getString("locationName"));
                        }   
                    vehOwnerF.setText(rs.getString("owner"));
                    vehMileageF.setText(rs.getString("mileage"));
                    vehColourF.setText(rs.getString("colour"));
                    vehHistoryF.setText(rs.getString("serviceHistory"));
                }
        }
        catch(Exception exp)
        {
            System.out.println ("Error: "+exp);
        }
        connect.close();
    }
    
    //------Method 4.  Adds CIS Records to the database.
    private void onAddCis()
    {
        //Creating a new cis object and assigning the variables
        CISEquipment cis1=new CISEquipment();
        cis1.setAssetID(cAssetF.getText());
        cis1.setMake(cMakeF.getText());
        cis1.setModel(cModelF.getText());
        cis1.setLocation((String) cLocationF.getSelectedItem());
        cis1.setRepairStatus((String)cRStatusF.getSelectedItem());
        cis1.setOwner(cOwnerF.getText());
        
        if(cis1.getAssetID().equals(""))//ensures the asset ID field is populated before entering a new record
        {
            JOptionPane.showMessageDialog(mainFrame, "An Asset ID must be entered to create a record!");
        }
        else
        {
            String make = cis1.getMake();
            String model = cis1.getModel();
            int repairStatus = 1;
            int location = 2;
            String owner = cis1.getOwner();        
            int createdBy = this.login;//Gets the user login to associate with the creation of this record
            int equipmentType = 2;//Sets the equipment type to 2 in the database, this represents CIS Equipment
            String assetID = cis1.getAssetID();
            DBConnect connect = new DBConnect(); //Creates a new DBConnect object
            try
            {
                String loc = (String)cLocationF.getSelectedItem();
                String status = (String)cRStatusF.getSelectedItem(); 
                ResultSet rs1 = connect.query("SELECT * FROM location "+"WHERE locationName = '"+loc+"'");
                ResultSet rs2 = connect.query("SELECT * FROM repairstatus "+"WHERE repairStatus = '"+status+"'");
                while (rs1.next())
                {
                    location = rs1.getInt("idLocation");  
                }
                while (rs2.next())
                {
                    repairStatus = rs2.getInt("idRepairStatus");
                }
            }     
            catch(Exception exp1)
            {
                System.out.println("Error: "+exp1);     
            }
            try
            {
                ResultSet rs = connect.query("SELECT * FROM equipment "+"WHERE assetID = '"+assetID+"'");
                //This while loop checks the database to ensure there is no entry already exisiting with the assetID to ensure database integrity
                int counter = 0;
                while (rs.next())
                {
                    counter = counter+1;
                }
                if(counter ==0)
                {
                    //String to be used in the SQL statement
                    String input = "?, "+location+", '"+make+"', '"+model+"', "+repairStatus+", '"+owner+"', "+0+", '"+0+"', '"
                    +0+"', "+createdBy+", "+equipmentType+", '"+assetID+"'";
                    //Calls the enterData method to insert a new row into the equipment table
                    connect.enterData("INSERT INTO equipment "+"VALUES ("+input+")");
                    JOptionPane.showMessageDialog(mainFrame, "Record successfully entered");//Feedback window to inform the record has been entered to the database
                    //Code below clears down the fields to prepare them for a new entry
                    cAssetF.setText("");
                    cMakeF.setText("");
                    cModelF.setText("");
                    cRStatusF.setSelectedIndex(1);
                    cLocationF.setSelectedIndex(1);
                    //vehLocationF.setText("");
                    cOwnerF.setText(""); 
                }
                else//else statement to inform the user if they attempt to enter a prexisiting record
                {
                    connect.enterData("UPDATE equipment SET location='"+location+"',make='"+make+"',model='"+model+"',repairStatus='"+repairStatus+"',"
                    + "owner='"+owner+"',mileage='"+0+"',colour='"+0+"',serviceHistory='"+0+"',createdBy='"+createdBy+"',equipmentType='"+equipmentType+"' WHERE assetID='"+assetID+"'");
                    JOptionPane.showMessageDialog(mainFrame, "Record already exists, existing record updated");
                }
            }    
            catch(Exception exp)
            {
                System.out.println ("Error: "+exp);
            }
            connect.close();
        }  
    }
    
    //-----Method 5. Searches CIS Records in the database.
    private void onCisSearchBut()//Method to perform a search on the database for records matching the asset ID
    {
        DBConnect connect = new DBConnect(); //Creates a new DBConnect object
        try
        {
            String input = cAssetF.getText();
            //Calls the enterData method to insert a new row into the equipment table
            ResultSet rs = connect.query("SELECT * FROM equipment "+"WHERE assetID = '"+input+"'");//Searches the database for records with the matching assetID
            while (rs.next())
                {
                    cAssetF.setText(rs.getString("assetID"));
                    cMakeF.setText(rs.getString("make"));
                    cModelF.setText(rs.getString("model"));
                    ResultSet rs1 = connect.query("SELECT * FROM repairStatus "+"WHERE idRepairStatus = '"+rs.getInt("repairStatus")+"'");
                    while (rs1.next())
                        {
                            cRStatusF.setSelectedItem(rs1.getString("repairStatus"));
                        }
                    ResultSet rs2 = connect.query("SELECT * FROM location "+"WHERE idLocation = '"+rs.getInt("location")+"'");
                    while (rs2.next())
                        {
                            cLocationF.setSelectedItem(rs2.getString("locationName"));
                        }   
                    cOwnerF.setText(rs.getString("owner"));   
                }
        }
        catch(Exception exp)
        {
            System.out.println ("Error: "+exp);
        }
        connect.close();
    }
    
    //------Method 6. Deletes a vehicle record from the database.
    private void onVehDeleteBut()
    {
        DBConnect connect = new DBConnect(); // Creates a new DBConnect object
        try
        {
            System.out.println(vehAssetF.getText());
            connect.enterData("DELETE FROM equipment WHERE AssetID = '"+vehAssetF.getText()+"'");
            JOptionPane.showMessageDialog(mainFrame, "Record successfully deleted");
        }
        catch(Exception exp)
        {
            System.out.println("Error: "+exp);
        }
        connect.close();
    }
    
    //------Method 7. Deletes a CIS record from the database.
    private void onCisDeleteBut()
    {
        DBConnect connect = new DBConnect(); // Creates a new DBConnect object
        try
        {
            connect.enterData("DELETE FROM equipment WHERE assetID = '"+cAssetF.getText()+"'");
            JOptionPane.showMessageDialog(mainFrame, "Record successfully deleted");
        }
        catch(Exception exp)
        {
            System.out.println("Error: "+exp);
        }
        connect.close();
    }

    //------Method 8. Logs the user out of the main form and returns to the login form.
    private void onLogOut()
    {
        LoginMain form1 = new LoginMain();//Creates a new loginMain object - form1.
        form1.loginForm();//Creates a login form using the form1 object.
    }
}
