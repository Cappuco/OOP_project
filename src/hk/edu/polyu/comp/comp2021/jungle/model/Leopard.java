package hk.edu.polyu.comp.comp2021.jungle.model;

public class Leopard extends Piece{
    private final int rank = 5;

    Leopard (Location location, Team team) {
        super(location, team);
    }

    @Override
    void getMovables() {
        ;
    }
    public String toString() {
        return "leopard  ";
    }
    public int getRank() {
        return rank;
    }
}
