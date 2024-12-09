package model;

public class User implements Comparable<User>{
    private String name;
    private int points;
    public User(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    public int compareTo(User o) {
        return Integer.compare( o.points,this.points);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + ' ' +
                ", points=" + points +
                '}';
    }
}
