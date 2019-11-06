package hk.edu.polyu.comp.comp2021.jungle.model;

public class Cat extends Piece {
    private final int rank = 2;

    Cat (Location location, Team team) {
        super(location, team);

    }

    void getMovables() {
        ;
    }

    public String toString() {
        return "cat      ";
    }
    public int getRank() {
        return rank;
    }


}

