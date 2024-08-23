package Project;

public class building {
    private int id;
    private String address;
    private String building_scale;
    private String city;
    private String state;
    private String description;

    public building() {
    }

    public building(String address, String building_scale, String city, String state, String description) {
        this.address = address;
        this.building_scale = building_scale;
        this.city = city;
        this.state = state;
        this.description = description;

    }

    public String getAddress() {
        return address;
    }

    public String getBuildingScale() {
        return building_scale;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBuildingScale(String building_scale) {
        this.building_scale = building_scale;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
