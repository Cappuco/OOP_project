package hk.edu.polyu.comp.comp2021.jungle.model;

public class Lion extends Piece {
    private final int rank = 7;

    Lion (Location location, Team team) {
        super(location, team);
    }

    @Override
    void getMovables() {
        ;
    }
    public String toString() {
        return "lion     ";
    }
    public int getRank() {
        return rank;
    }

}
