package hk.edu.polyu.comp.comp2021.jungle.model;

import java.io.Serializable;

public abstract class Piece implements Serializable {
    public Location location;
    public Team team;
    protected Location[] Movables;



    abstract void getMovables();
    abstract int getRank();
    /*
    * Constructor, meant to be called as super()
    * */
    Piece(Location location, Team team) {
        this.location = location;
        this.team = team;
    }
}
