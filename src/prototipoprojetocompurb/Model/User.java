package prototipoprojetocompurb.Model;

public class User {

    private String userId; 
    private String firstName;
    private String lastname; 
    private String profilePic; 
    private String gender;
    private String city;

    public User(String userId, String firstName, String lastname, String profilePic, String gender, String city) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastname = lastname;
        this.profilePic = profilePic;
        this.gender = gender;
        this.city = city;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", firstName=" + firstName + ", lastname=" + lastname + ", profilePic=" + profilePic + ", gender=" + gender + ", city=" + city + '}';
    }
    
}
