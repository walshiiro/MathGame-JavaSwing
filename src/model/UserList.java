package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.parseInt;

public class UserList {
    List<User> users = new ArrayList<>();

    public void addUser(User user) {

        users.add(user);

    }
    public boolean checkUser(String name) {
        for(User u:users)
        {
            if(u.getName().equalsIgnoreCase(name))
                return true;

        }
        return false;
    }
    public List<User> getUsers() {
        return users;
    }
    public void readFromFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("userdata.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 2) {
                    try {
                        User variety = new User(fields[0].trim(), parseInt(fields[1].trim()));
                        users.add(variety);
                    } catch (Exception e) {

                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    public List<User> readFromFileRefresh() {
        List<User> users1 = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("userdata.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 2) {
                    try {
                        User variety = new User(fields[0].trim(), parseInt(fields[1].trim()));
                        users1.add(variety);
                    } catch (Exception e) {

                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return users1;
    }
    public void writeToFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("userdata.txt")); // 'true' to append data
            for (User user : users) {
                bw.write(user.getName() + "," + user.getPoints());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    public List<User> scoreTable()
    {
        List<User> usersList = readFromFileRefresh();

         Collections.sort(usersList);

         return usersList;
    }


}
