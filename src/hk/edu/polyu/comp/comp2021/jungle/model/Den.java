package hk.edu.polyu.comp.comp2021.jungle.model;

public class Den extends Piece {
    private final int rank = 0;

    Den (Location location, Team team) {
        super(location, team);
    }

    @Override
    void getMovables() { // Den does not move
        ;
    }

    public String toString() {
        return "den      ";
    }
    public int getRank() {
        return rank;
    }
}
