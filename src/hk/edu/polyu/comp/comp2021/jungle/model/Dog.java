package hk.edu.polyu.comp.comp2021.jungle.model;

public class Dog extends Piece {
    private final int rank = 3;

    Dog (Location location, Team team) {
        super(location, team);
    }

    @Override
    void getMovables() {
        ;
    }

    public String toString() {
        return "dog      ";
    }
    public int getRank() {
        return rank;
    }
}
