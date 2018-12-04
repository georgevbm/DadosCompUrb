package prototipoprojetocompurb.Util;

import prototipoprojetocompurb.Model.Venue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import prototipoprojetocompurb.Model.Tip;
import prototipoprojetocompurb.Model.User;

public class Controller {

    public Controller() {
    }
    
    // Métodos de leitura dos arquivos e salvamento no BD
    public void readTips(){
    try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\georg\\Desktop\\foursquare_data\\Tips\\NYC\\NYC-Tips.txt"));
            while (br.ready()) {
                String linha = br.readLine();
                String[] aux = linha.split("\t");
                
                Tip tip = new Tip(aux[0], aux[1]);
                
                ConnectPostgresSQL.insertTip(tip);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
    
    public void readVenues() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\georg\\Desktop\\foursquare_data\\Venues\\NYC\\NYC-Venues.txt"));
            while (br.ready()) {
                String linha = br.readLine().replace("\'", "´");
                String[] aux = linha.split("\t");

                Venue venue = new Venue(aux[0],
                        aux[1],
                        Double.parseDouble(aux[2]),
                        Double.parseDouble(aux[3]),
                        aux[4],
                        aux[5],
                        aux[6],
                        Integer.parseInt(aux[7]),
                        Integer.parseInt(aux[8]),
                        Integer.parseInt(aux[9]),
                        Integer.parseInt(aux[10]),
                        aux[11]);
                
                ConnectPostgresSQL.insertVenue(venue);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void readUser() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\georg\\Desktop\\foursquare_data\\Users\\NYC\\NYC-Users.txt"));
            while (br.ready()) {
                String linha = br.readLine().replace("\'", "");
                String[] aux = linha.split("\t");

                User user = new User(aux[0],
                        aux[1],
                        aux[2],
                        aux[3],
                        aux[4],
                        aux[5]);
                
                ConnectPostgresSQL.insertUser(user);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
