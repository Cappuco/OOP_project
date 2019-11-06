package hk.edu.polyu.comp.comp2021.jungle.model;

import javax.swing.WindowConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Display{

    final int GRIDSIZE = 100, XMAX = 7, YMAX = 9;
    final JFrame frame = new JFrame("Animal Chess");
    ImageLoader images = new ImageLoader();
    final JButton[][] icons = new JButton[XMAX][YMAX];
    Jungle j;
    final int[] YMAPPER = {8,7,6,5,4,3,2,1,0};
    // Init **************************************
    private void init() {
        initIcon();
        initMenu();
    }

    private void initIcon() {
        Location l;
        for(int y = YMAX-1; y >= 0; y--) {
            for(int x = 0; x < 7; x++)  {
                l = new Location(x,y);
                icons[x][y] = new JButton(new ImageIcon(images.getImage(j.getPiece(l),l)));
                icons[x][y].setBounds(x*GRIDSIZE,YMAPPER[y]*GRIDSIZE,GRIDSIZE,GRIDSIZE);

                final int X = x, Y = y;
                icons[x][y].addActionListener(e -> highLight(icons[X][Y],new Location(X,Y)));
                frame.add(icons[x][y]);
            }
        }
    }

    private void initMenu() {
        JMenuBar b = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        b.add(menu);

        JMenuItem saveMenu = new JMenuItem("Save");
        saveMenu.setMnemonic(KeyEvent.VK_E);
        saveMenu.setToolTipText("Save the current file.");
        saveMenu.addActionListener((event) -> saveFile());

        JMenuItem LoadMenu = new JMenuItem("Load");
        LoadMenu.setMnemonic(KeyEvent.VK_E);
        LoadMenu.setToolTipText("Load the last saved file.");
        LoadMenu.addActionListener((event) -> loadFile());

        JMenuItem saveExitMenu = new JMenuItem("Save and Exit");
        saveExitMenu.setMnemonic(KeyEvent.VK_E);
        saveExitMenu.setToolTipText("Save and exit the game.");
        saveExitMenu.addActionListener((event) -> saveExitFile());

        menu.add(saveMenu);
        menu.add(LoadMenu);
        menu.add(saveExitMenu);

        frame.setJMenuBar(b);
    }

    private void highLight(JButton i, Location l) {
        i.setIcon(new ImageIcon(images.getImageHighlight(j.getPiece(l),l)));
        disable(i);
        //i.setEnabled(false);
    }

    private void disable(JButton i) {
        i.setDisabledIcon(i.getIcon());
        i.setEnabled(false);
    }

    // menu methods ****************************
    private void saveFile() {
        System.out.println("file saved");
        showMessage();
    }

    private void loadFile() {
        System.out.println("file loaded");
    }

    private void saveExitFile() {
        saveFile();
        System.out.println("bye!");
        System.exit(0);
    }

    // message handle **************
    private void showMessage() {
        int reply = JOptionPane.showConfirmDialog(null, "add message here", "the title", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "HELLO");
        }
        else {
            JOptionPane.showMessageDialog(null, "GOODBYE");
            System.exit(0);
        }
    }

    // canvas handle ************************************
    @SuppressWarnings("serial")
    public class Canvas extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(images.backgroundImage, 0, 0, this);
        }
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(images.backgroundImage.getWidth(this),
                    images.backgroundImage.getHeight(this));
        }
    }


    public Display(Jungle j) {
        this.j = j;
        init();
        Canvas bg = new Canvas();
        frame.add(bg);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}