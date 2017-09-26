package assettracker;

import java.sql.*;   

/**
 *
 * @author Steve Williamson
 */
public class DBConnect {
    
    private Connection con = null;  // Helps to connect to SQL Database
    private Statement st; //Holds query
    private ResultSet rs;  //Holds results returned by query
    private static boolean hasData = false;

    public void close()
    {
        try
        {
            con.close();
        }
        catch(Exception exp1)
        {
            System.out.println("Error "+exp1);
        }
        
    }

//------Method 1. Connects to the database
    public void DBConnect()
    {
//        try
//        {
//            Class.forName("org.sqlite.JDBC"); //Loads the driver Class
//            con = DriverManager.getConnection("jdbc:sqlite:SQLiteDB.db");
//            initialise();
//        }
//        catch(Exception ex)
//        {
//            System.out.println("Error: "+ex);
//        }
        
        try {
          Class.forName("org.sqlite.JDBC");
          con = null;
          con = DriverManager.getConnection("jdbc:sqlite:SQLiteDB.db");
          initialise();
            }
        catch(Exception ex)
        {
            System.out.println("Error: "+ex);
        }
    System.out.println("Opened database successfully");
    }
    
    //------Method 2. Manipulates data in the database
    public void enterData(String input)
    {
        try
        {
            Class.forName("org.sqlite.JDBC"); //Loads the driver Class
            con = DriverManager.getConnection("jdbc:sqlite:SQLiteDB.db");
            st = con.createStatement();
            st.executeUpdate(input);
            
        }
        catch(Exception ex)
        {
            System.out.println("Error: "+ex);
        }
    }
    
    //------Method 3. Performs a query on the database and returns the resultset rs
    public ResultSet query(String doQuery)
    {
        try
        {
            Class.forName("org.sqlite.JDBC"); //Loads the driver Class
            con = DriverManager.getConnection("jdbc:sqlite:SQLiteDB.db");
            st = con.createStatement();
            rs = st.executeQuery(doQuery);
            return rs;
            
           
        }
        catch(Exception ex)
        {
            System.out.println("Error: "+ex);
            return rs;
        }
        

    }
    
    private void initialise()
    {
        try
        {
            if(!hasData)
            {
                hasData = true;
                Statement state = con.createStatement();
                ResultSet res = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='equipment'");//Checks if there is a sqlite_master table
                if(!res.next())//if an sqlite_master tabel is not found, then there is no database, so one is created;
                {
                    System.out.println("Building the User table with prepopulated values.");
                    Statement st1 = con.createStatement();
                    st1.execute("CREATE TABLE equipment (\n" +
                    "  idEquipment INTEGER PRIMARY KEY,\n" +
                    "  location int(11),\n" +
                    "  make varchar(45) ,\n" +
                    "  model varchar(45) ,\n" +
                    "  repairStatus int(11) ,\n" +
                    "  owner varchar(45) ,\n" +
                    "  mileage varchar(45) ,\n" +
                    "  colour varchar(45) ,\n" +
                    "  serviceHistory text ,\n" +
                    "  createdBy int(11) ,\n" +
                    "  equipmentType int(11) ,\n" +
                    "  AssetID varchar(45) ,"+
                    "foreign key(equipmentType) references equipmenttype(idEquipmentType)"+
                    "foreign key(repairStatus) references repairstatus(idRepairStatus)"+
                    "foreign key(createdBy) references user(idUser));");
                    Statement st2 = con.createStatement();
                    st2.execute("INSERT INTO `equipment` (`idEquipment`, `location`, `make`, `model`, `repairStatus`, `owner`, `mileage`, `colour`, `serviceHistory`, `createdBy`, `equipmentType`, `AssetID`) VALUES\n" +
                    "(2, 1, 'Land Rover', 'Wolf', 1, '', '', '', '', 1, 1, 'MD55AA'),\n" +
                    "(3, 1, 'Ford', 'Mondeo', 1, 'Steve', '12345', 'Blue', 'long', 1, 1, 'MD12ss'),\n" +
                    "(5, 1, 'Vauxhall', 'Vectra', 1, 'Ian', '3213172', 'Pink', 'long', 1, 1, 'FF33SS');");
                    
                    Statement st3 = con.createStatement();
                    st3.execute("CREATE TABLE `equipmenttype` (\n" +
                    "  `idEquipmentType` INTEGER PRIMARY KEY ,\n" +
                    "  `equipmentType` varchar(45) \n" +
                    ");");
                    
                    Statement st4 = con.createStatement();
                    st4.execute("INSERT INTO `equipmenttype` (`idEquipmentType`, `equipmentType`) VALUES\n" +
                    "(1, 'Vehicle'),\n" +
                    "(2, 'CIS Equipment');"); 
                    
                    Statement st5 = con.createStatement();
                    st5.execute("CREATE TABLE `location` (\n" +
                    "  `idLocation` INTEGER PRIMARY KEY ,\n" +
                    "  `locationName` varchar(45) \n" +
                    ");");
                    
                    Statement st6 = con.createStatement();
                    st6.execute("INSERT INTO `location` (`idLocation`, `locationName`) VALUES\n" +
                    "(1, 'FOB Alpha');");
                    
                    Statement st7 = con.createStatement();
                    st7.execute("CREATE TABLE `repairstatus` (\n" +
                    "  `idRepairStatus` INTEGER PRIMARY KEY ,\n" +
                    "  `repairStatus` varchar(45) \n" +
                    ");");
                    
                    Statement st8 = con.createStatement();
                    st8.execute("INSERT INTO `repairstatus` (`idRepairStatus`, `repairStatus`) VALUES\n" +
                    "(1, 'Awaiting Repair'),\n" +
                    "(2, 'Repaired'),\n" +
                    "(3, 'Under Repair');");
                    
                    Statement st9 = con.createStatement();
                    st9.execute("CREATE TABLE `user` (\n" +
                    "  `idUser` INTEGER PRIMARY KEY ,\n" +
                    "  `userName` varchar(45) ,\n" +
                    "  `password` varchar(45) ,\n" +
                    "  `userType` int(11) ," +
                    " foreign key(userType) references usertype(idUserType)" +
                    ");");
                    
                    Statement st10 = con.createStatement();
                    st10.execute("INSERT INTO `user` (`idUser`, `userName`, `password`, `userType`) VALUES\n" +
                    "(1, 'admin', 'password', 1);");
                    
                    Statement st11 = con.createStatement();
                    st11.execute("CREATE TABLE `usertype` (\n" +
                    "  `idUserType` INTEGER PRIMARY KEY ,\n" +
                    "  `userType` varchar(45) \n" +
                    ");");
                    
                    Statement st12 = con.createStatement();
                    st12.execute("INSERT INTO `usertype` (`idUserType`, `userType`) VALUES\n" +
                    "(1, 'Administrator'),\n" +
                    "(2, 'User');");
                    

                }
            }
        }
        catch(SQLException ex)
        {
            System.out.println("Error: "+ex);
        }
        close();
    }
     
}

