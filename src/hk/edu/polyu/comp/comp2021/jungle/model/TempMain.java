package hk.edu.polyu.comp.comp2021.jungle.model;

// For testing only, will delete at the end.
public class TempMain {
    public static void main(String[] args) {
        Jungle j = new Jungle();
        //FileHandler.saveGame(j);

        //Jungle j2 = FileHandler.loadGame();
        //Prompt.printBoard(j2);
        new Display(j);
    }
}
