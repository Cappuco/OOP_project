package hk.edu.polyu.comp.comp2021.jungle.model;

public class Tiger extends Piece{
    private final int rank = 6;

    Tiger (Location location, Team team) {
        super(location, team);
    }

    @Override
    void getMovables() {
        ;
    }
    public String toString() {
        return "tiger    ";
    }
    public int getRank() {
        return rank;
    }
}
