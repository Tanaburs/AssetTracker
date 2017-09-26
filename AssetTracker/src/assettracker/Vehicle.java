package assettracker;

/**
 * Created by Steve Williamson on 17/02/2016.
 */
public class Vehicle extends Equipment
{
    //------Class Fields------
    private String vehMileage;
    private String vehColour;
    private String vehServiceHistory;


    //------Constructor for a Vehicle object.------
    Vehicle(String location, String assetID, String make,
            String model, String vehMileage, String vehColour,
            String vehServiceHistory, String owner, String repairStatus)
    {
        this.location=location;
        this.assetID=assetID;
        this.make=make;
        this.model=model;
        this.vehMileage=vehMileage;
        this.vehColour=vehColour;
        this.vehServiceHistory=vehServiceHistory;
        this.owner=owner;
        this.repairStatus=repairStatus;
    }

    Vehicle(){};

    //------Method 1. Setter method for vehMileage.
    public void setVehMileage(String vehMileage)
    {
        this.vehMileage = vehMileage;
    }
    
    //------Method 2. Getter method for vehMileage. 
    public String getVehMileage()
    {
        return vehMileage;
    }

    //------Method 3. Getter method for vehColour.
    public String getVehColour()
    {
        return vehColour;
    }

    //------Method 4. Setter method for vehColour.
    public void setVehColour(String vehColour)
    {
        this.vehColour = vehColour;
    }

    //------Method 5. Getter method for vehServiceHistory.
    public String getVehServiceHistory()
    {
        return vehServiceHistory;
    }

    //------Method 6. Setter method for vehService History.
    public void setVehServiceHistory(String vehServiceHistory)
    {
        this.vehServiceHistory = vehServiceHistory;
    }

    //------Method 7. Displays the values of the vehicle variables.
    public void display()
    {
        System.out.println(location);
        System.out.println(assetID);
        System.out.println(make);
        System.out.println(model);
        System.out.println(vehMileage);
        System.out.println(vehColour);
        System.out.println(vehServiceHistory);
        System.out.println(owner);
        System.out.println(repairStatus);
        System.out.println(faultRecord);
    }
}

