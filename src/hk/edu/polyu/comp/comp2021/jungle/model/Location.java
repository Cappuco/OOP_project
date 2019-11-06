package hk.edu.polyu.comp.comp2021.jungle.model;

import java.io.Serializable;

public class Location implements Serializable {
    public static final int XMAX = 7;
    public static final int YMAX = 9;

    private int x, y;

    /*
    * Constructor
    * */
    Location(int x, int y) {
        isValid(x,y);
        this.x = x;
        this.y = y;
    }

    /*
    * Input: integer: x ,y
    * Output: none, update the location by input.
    * */
    public void updateLocation(int x, int y) {
        isValid(x,y);
        this.x = x;
        this.y = y;
    }

    private void isValid(int x, int y){
        if (x >= XMAX || x<0 || y >= YMAX || y<0) {
            Utility.error("Error: invalid location.");
        }
    }

    /*
     * Input: none
     * Output: int, the x
     * */
    public int getX() {
        return this.x;
    }

    /*
     * Input: none
     * Output: int, the y
     * */
    public int getY() {
        return this.y;
    }

    /*
     * Input: Location other
     * Output: boolean, true if this and other Location has same x and y
     * */
    public boolean equals(Location other) {
        if(this.x == other.x && this.y == other.y) return true;
        return false;
    }

    /*
     * Input: None
     * Output: String, the location x and y in professor's format
     * */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(Character.toString('A'+this.x));
        s.append(Integer.toString(this.y+1));
        return s.toString();
    }

    /*
     * Input: String
     * Output: Location, new location decoded from String in professor's format
     * */
    public static Location fromString(String s) {
        return new Location(((int)(s.charAt(0))) - 65, Character.getNumericValue(s.charAt(1))-1);
    }

}
