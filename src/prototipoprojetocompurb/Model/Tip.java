package prototipoprojetocompurb.Model;

public class Tip {
    private int id;
    private String userId;
    private String venueId;

    public Tip(String userId, String venueId) {
        this.userId = userId;
        this.venueId = venueId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVenueId() {
        return venueId;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }

    @Override
    public String toString() {
        return "Tip{" + "id=" + id + ", userId=" + userId + ", venueId=" + venueId + '}';
    }

}
