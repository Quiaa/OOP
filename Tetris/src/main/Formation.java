package main;
import javax.swing.JFrame;

public class Formation extends JFrame{
    public Formation(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        GameArea gameArea = new GameArea();
        add(gameArea);
        pack();
        gameArea.launchGame();
    }
}
