package hk.edu.polyu.comp.comp2021.jungle.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Jungle implements Serializable {
    private Piece[][] jungle = new Piece[7][9];
    private final static Location[] WATERLOCATION = {
            new Location(1, 3),
            new Location(1, 4),
            new Location(1, 5),
            new Location(2, 3),
            new Location(2, 4),
            new Location(2, 5),
            new Location(4, 3),
            new Location(4, 4),
            new Location(4, 5),
            new Location(5, 3),
            new Location(5, 4),
            new Location(5, 5),
    };
    private String homePlayer, awayPlayer;

    public Jungle() {
        // not completed
        getNames();
        initJungle();
        Prompt.printBoard(this);
    }

    private void getNames() {
        Prompt.setHomePlayer();
        this.homePlayer = Prompt.getInput();
        Prompt.setAwayPlayer();
        this.awayPlayer = Prompt.getInput();

    }

    private void initJungle() {
        // dens and traps
        addPiece(new Den(Location.fromString("D1"), Team.Home));
        addPiece(new Trap(Location.fromString("C1"), Team.Home));
        addPiece(new Trap(Location.fromString("E1"), Team.Home));
        addPiece(new Trap(Location.fromString("D2"), Team.Home));
        addPiece(new Den(Location.fromString("D9"), Team.Away));
        addPiece(new Trap(Location.fromString("C9"), Team.Away));
        addPiece(new Trap(Location.fromString("E9"), Team.Away));
        addPiece(new Trap(Location.fromString("D8"), Team.Away));
        // animals
        addPiece(new Lion(Location.fromString("A1"), Team.Home));
        addPiece(new Tiger(Location.fromString("G1"), Team.Home));
        addPiece(new Cat(Location.fromString("B2"), Team.Home));
        addPiece(new Dog(Location.fromString("F2"), Team.Home));
        addPiece(new Elephant(Location.fromString("A3"), Team.Home));
        addPiece(new Wolf(Location.fromString("C3"), Team.Home));
        addPiece(new Leopard(Location.fromString("E3"), Team.Home));
        addPiece(new Rat(Location.fromString("G3"), Team.Home));

        addPiece(new Lion(Location.fromString("G9"), Team.Away));
        addPiece(new Tiger(Location.fromString("A9"), Team.Away));
        addPiece(new Cat(Location.fromString("F8"), Team.Away));
        addPiece(new Dog(Location.fromString("B8"), Team.Away));
        addPiece(new Elephant(Location.fromString("G7"), Team.Away));
        addPiece(new Wolf(Location.fromString("E7"), Team.Away));
        addPiece(new Leopard(Location.fromString("C7"), Team.Away));
        addPiece(new Rat(Location.fromString("A7"), Team.Away));
    }

    public String getHomePlayerName() {
        return this.homePlayer;
    }

    public String getAwayPlayerName() {
        return this.awayPlayer;
    }


    public void addPiece(Piece p) {
        this.jungle[p.location.getX()][p.location.getY()] = p;
    }

    public static boolean isWater(Location target) {
        for (Location water: WATERLOCATION) {
            if (target.equals(water)) return true;
        }
        return false;
    }

    public static String waterToString() {
        return ("water    ");
    }
    public static String grassToString() {
        return ("grass    ");
    }
    public Piece[][] getBoard() {
        return this.jungle;
    }
    public Piece getPiece(Location l) {return this.jungle[l.getX()][l.getY()];}

}
