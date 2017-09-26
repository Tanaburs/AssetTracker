package assettracker;

/**
 * Created by Steve Williamson on 17/02/2016.
 */
public class Equipment
{
    protected String location; //Current location of equipment
    protected String repairStatus; //Current repair status of equipment
    protected String make; //Make of equipment
    protected String model; //Model of equipment
    protected String owner; //Owner or person responsible for equipment
    protected String assetID; //Registration or Serial Number
    protected String faultRecord; //Record of faults

    //------Method 1. Getter method for faultRecord
    public String getFaultRecord() {
        return faultRecord;
    }

    //------Method 2. Setter method for faultRecord
    public void setFaultRecord(String faultRecord) {
        this.faultRecord = faultRecord;
    }

    //------Method 3. Getter method for assetID
    public String getAssetID() {

        return assetID;
    }

    //------Method 4. Setter method for assetID
    public void setAssetID(String assetID) {
        this.assetID = assetID;
    }

    //------Method 5. Getter method for owner
    public String getOwner() {

        return owner;
    }

    //------Method 6. Setter method for owner
    public void setOwner(String owner) {
        this.owner = owner;
    }

    //------Method 7. Getter method for model
    public String getModel() {

        return model;
    }

    //------Method 8. Setter method for model
    public void setModel(String model) {
        this.model = model;
    }

    //------Method 9. Getter method for make
    public String getMake() {

        return make;
    }

    //------Method 10. Setter method for make
    public void setMake(String make) {
        this.make = make;
    }

    //------Method 11. Getter method for repairStatus
    public String getRepairStatus() {

        return repairStatus;
    }

    //------Method 12. Setter method for repairStatus
    public void setRepairStatus(String repairStatus) {
        this.repairStatus = repairStatus;
    }

    //------Method 13. Getter method for location
    public String getLocation() {

        return location;
    }

    //------Method 14. Setter method for location
    public void setLocation(String location) {
        this.location = location;
    }
}

