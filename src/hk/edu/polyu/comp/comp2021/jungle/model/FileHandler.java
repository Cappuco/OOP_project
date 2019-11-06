package hk.edu.polyu.comp.comp2021.jungle.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.FileAlreadyExistsException;

public class FileHandler {
    public static Jungle continueOrNew() {
        Prompt.newOrLoad();
        String input = Prompt.getInput();
        if (input.charAt(0) == 'Y') {
            return loadGame();
        }
        else if (input.charAt(0) == 'N') {
            return new Jungle();
        }
        else {
            Utility.error("Error: Invalid input.");
        }
        return null;
    }

    private static boolean overwriteOrNo() {
        Prompt.overWriteOrNo();
        String input = Prompt.getInput();
        if (input.charAt(0) == 'Y') {
            return true;
        }
        else if (input.charAt(0) == 'N') {
            return false;
        }
        else {
            Utility.error("Error: Invalid input.");
        }
        return false;
    }

    public static void saveGame(Jungle j) {
        try {
            FileOutputStream f = new FileOutputStream(new File(
                    "src/hk/edu/polyu/comp/comp2021/jungle/model/resource/file/myJungle.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(j);

            o.close();
            f.close();

            System.out.println("welldone");
        } catch (FileNotFoundException e) {
            Utility.error("Error: File not found");
        } catch (IOException e) {
            e.printStackTrace();
            Utility.error("Error initializing stream");
        }
    }

    public static Jungle loadGame() {
        Jungle output = null;
        try {
            FileInputStream fi = new FileInputStream(new File(
                    "src/hk/edu/polyu/comp/comp2021/jungle/model/resource/file/myJungle.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read file to object;
            output = (Jungle) oi.readObject();

            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            Utility.error("Error: File not found");
        } catch (IOException e) {
            Utility.error("Error initializing stream");
        } catch (ClassNotFoundException e) {
            Utility.error("Error: fail to read Jungle object");
        }
        return output;
    }


}
