package prototipoprojetocompurb.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import prototipoprojetocompurb.Model.Tip;
import prototipoprojetocompurb.Model.User;
import prototipoprojetocompurb.Model.Venue;

public final class ConnectPostgresSQL {

    private static Connection connectDB() {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/compurbdb", "postgres", "postgres");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        return c;
    }

    // SQLs Users
    public static void insertUser(User user) {
        Connection c = null;
        Statement stmt = null;
        try {
            c = connectDB();
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "INSERT INTO usernyc (id,firstname,lastname,profilepic,gender,city) "
                    + "VALUES ('" + user.getUserId() + "','"
                    + user.getFirstName() + "','"
                    + user.getLastname() + "','"
                    + user.getProfilePic() + "','"
                    + user.getGender() + "','"
                    + user.getCity()
                    + "');";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Insert user successfully");
    }

    public static void deleteUserId(String id) {
        Connection c = null;
        Statement stmt = null;
        try {
            c = connectDB();
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "DELETE FROM usernyc WHERE id ='" + id + "';";
            stmt.executeUpdate(sql);
            c.commit();

            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Delete user successfully");
    }

    public static ArrayList<User> selectAllUsers() {
        Connection c = null;
        Statement stmt = null;
        ArrayList<User> users = new ArrayList<>();
        try {
            c = connectDB();
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usernyc;");
            while (rs.next()) {
                String id = rs.getString("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String profilepic = rs.getString("profilepic");
                String gender = rs.getString("gender");
                String city = rs.getString("city");

                User user = new User(id, firstname, lastname, profilepic, gender, city);
                users.add(user);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Search all users successfully");
        return users;
    }

    public static User selectUserId(String id) {
        Connection c = null;
        Statement stmt = null;
        User user = null;
        try {
            c = connectDB();
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usernyc WHERE id = '" + id + "';");
            while (rs.next()) {
                String userId = rs.getString("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String profilepic = rs.getString("profilepic");
                String gender = rs.getString("gender");
                String city = rs.getString("city");

                user = new User(userId, firstname, lastname, profilepic, gender, city);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Search user id successfully");
        return user;
    }

    // SQLs Venues
    public static void insertVenue(Venue venue) {
        Connection c = null;
        Statement stmt = null;
        try {
            c = connectDB();
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "INSERT INTO venuenyc (id,name,lat,lon,address,city,state,checkin,checkeduser,currentuser,todo,categoryid) "
                    + "VALUES ('" + venue.getId() + "','"
                    + venue.getName() + "',"
                    + venue.getLatitude() + ","
                    + venue.getLongitude() + ",'"
                    + venue.getAddress() + "','"
                    + venue.getCity() + "','"
                    + venue.getState() + "',"
                    + venue.getCheckin() + ","
                    + venue.getCheckedUser() + ","
                    + venue.getCurrentUser() + ","
                    + venue.getTodo() + ",'"
                    + venue.getCategoryId()
                    + "');";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Insert venue successfully");
    }

    public static void deleteVenueId(String id) {
        Connection c = null;
        Statement stmt = null;
        try {
            c = connectDB();
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "DELETE FROM venuenyc WHERE id ='" + id + "';";
            stmt.executeUpdate(sql);
            c.commit();

            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Delete venue successfully");
    }

    public static ArrayList<Venue> selectAllVenues() {
        Connection c = null;
        Statement stmt = null;
        ArrayList<Venue> venues = new ArrayList<>();
        try {
            c = connectDB();
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM venuenyc;");
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                double lat = rs.getDouble("lat");
                double lon = rs.getDouble("lon");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String state = rs.getString("state");
                int checkin = rs.getInt("checkin");;
                int checkedUser = rs.getInt("checkeduser");;
                int currentUser = rs.getInt("currentuser");;
                int todo = rs.getInt("todo");;
                String categoryId = rs.getString("categoryid");;

                Venue venue = new Venue(id, name, lat, lon, address, city, state, checkin, checkedUser, currentUser, todo, categoryId);
                venues.add(venue);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Search all venues successfully");
        return venues;
    }

    public static Venue selectVenueId(String id) {
        Connection c = null;
        Statement stmt = null;
        Venue venue = null;
        try {
            c = connectDB();
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM venuenyc WHERE id='" + id + "';");
            while (rs.next()) {
                String venueId = rs.getString("id");
                String name = rs.getString("name");
                double lat = rs.getDouble("lat");
                double lon = rs.getDouble("lon");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String state = rs.getString("state");
                int checkin = rs.getInt("checkin");;
                int checkedUser = rs.getInt("checkeduser");;
                int currentUser = rs.getInt("currentuser");;
                int todo = rs.getInt("todo");;
                String categoryId = rs.getString("categoryid");;

                venue = new Venue(venueId, name, lat, lon, address, city, state, checkin, checkedUser, currentUser, todo, categoryId);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Search venue id successfully");
        return venue;
    }
    
        // SQLs Tips
    public static void insertTip(Tip tip) {
        Connection c = null;
        Statement stmt = null;
        try {
            c = connectDB();
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "INSERT INTO tipnyc (iduser,idvenue) "
                    + "VALUES ('" + tip.getUserId() + "','"
                    + tip.getVenueId()
                    + "');";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Insert tip successfully");
    }

    public static void deleteTipId(String idTip) {
        Connection c = null;
        Statement stmt = null;
        try {
            c = connectDB();
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "DELETE FROM tipnyc WHERE id ='" + idTip + "';";
            stmt.executeUpdate(sql);
            c.commit();

            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Delete tip successfully");
    }

    public static ArrayList<Tip> selectAllTips() {
        Connection c = null;
        Statement stmt = null;
        ArrayList<Tip> tips = new ArrayList<>();
        try {
            c = connectDB();
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tipnyc;");
            while (rs.next()) {
                int id = rs.getInt("id");
                String idUser = rs.getString("iduser");
                String idVenue = rs.getString("idvenue");

                Tip tip = new Tip(idUser, idVenue);
                tip.setId(id);
                tips.add(tip);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Search all tips successfully");
        return tips;
    }

    public static Tip selectTipId(String idTip) {
        Connection c = null;
        Statement stmt = null;
        Tip tip = null;
        try {
            c = connectDB();
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tipnyc WHERE id='" + idTip + "';");
            while (rs.next()) {
                int id = rs.getInt("id");
                String idUser = rs.getString("iduser");
                String idVenue = rs.getString("idvenue");
             
                tip = new Tip(idUser, idVenue);
                tip.setId(id);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Search tip id successfully");
        return tip;
    }

}
