package hk.edu.polyu.comp.comp2021.jungle.model;

public class Rat extends Piece{
    private final int rank = 1;

    Rat (Location location, Team team) {
        super(location, team);
    }

    @Override
    void getMovables() {
        ;
    }

    public String toString() {
        return "rat      ";
    }
    public int getRank() {
        return rank;
    }

}
