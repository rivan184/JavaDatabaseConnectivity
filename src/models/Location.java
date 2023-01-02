package models;


public class Location {
    private int locationId;
    private String streetAddress;
    private int regionId;

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public int getLocationId() {
        return locationId;
    }
    public int getRegionId() {
        return regionId;
    }
    public String getStreetAddress() {
        return streetAddress;
    }

}
