package assettracker;

/**
 * Created by Steve Williamson on 17/02/2016.
 */
public class CISEquipment extends Equipment
{
    
    //------Constructor for a CISEquipment object.------
    CISEquipment(String location, String make, String repairStatus,
                 String owner, String model, String assetID)
    {
        this.location=location;
        this.make=make;
        this.repairStatus=repairStatus;
        this.owner=owner;
        this.model=model;
        this.assetID=assetID;
    }
    CISEquipment(){};

    //------Method 1. Display Method to display all fields.
    public void display()
    {
        System.out.println(location);
        System.out.println(make);
        System.out.println(repairStatus);
        System.out.println(owner);
        System.out.println(model);
        System.out.println(assetID);
        System.out.println(faultRecord);
    }
}

