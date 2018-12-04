package prototipoprojetocompurb.Model;

public class Venue {

    private String id;
    private String name;
    private double latitude;
    private double longitude;
    private String address;
    private String city;
    private String state;
    private int checkin;
    private int checkedUser;
    private int currentUser;
    private int todo;
    private String categoryId;

    public Venue(String id, String name, double latitude, double longitude, String address, String city, String state, int checkin, int checkedUser, int currentUser, int todo, String categoryId) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.city = city;
        this.state = state;
        this.checkin = checkin;
        this.checkedUser = checkedUser;
        this.currentUser = currentUser;
        this.todo = todo;
        this.categoryId = categoryId;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    public int getCheckin() {
        return checkin;
    }
    public void setCheckin(int checkin) {
        this.checkin = checkin;
    }

    public int getCheckedUser() {
        return checkedUser;
    }
    public void setCheckedUser(int checkedUser) {
        this.checkedUser = checkedUser;
    }

    public int getCurrentUser() {
        return currentUser;
    }
    public void setCurrentUser(int currentUser) {
        this.currentUser = currentUser;
    }

    public int getTodo() {
        return todo;
    }
    public void setTodo(int todo) {
        this.todo = todo;
    }

    public String getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Venues{" + "id=" + id + ", name=" + name + ", latitude=" + latitude + ", longitude=" + longitude + ", address=" + address + ", city=" + city + ", state=" + state + ", checkin=" + checkin + ", checkedUser=" + checkedUser + ", currentUser=" + currentUser + ", todo=" + todo + ", categoryId=" + categoryId + '}';
    }

    
}
