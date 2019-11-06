package hk.edu.polyu.comp.comp2021.jungle.model;

public class Trap extends Piece{
    private final int rank = 0;

    Trap (Location location, Team team) {
        super(location, team);
    }

    @Override
    void getMovables() { // traps can't move!
        ;
    }
    public String toString() {
        return "trap     ";
    }
    public int getRank() {
        return rank;
    }
}
