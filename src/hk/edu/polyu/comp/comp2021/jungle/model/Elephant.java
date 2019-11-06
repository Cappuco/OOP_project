package hk.edu.polyu.comp.comp2021.jungle.model;

public class Elephant extends Piece {
    private final int rank = 8;

    Elephant (Location location, Team team) {
        super(location, team);
    }

    @Override
    void getMovables() {
        ;
    }
    public String toString() {
        return "elephant ";
    }
    public int getRank() {
        return rank;
    }
}
