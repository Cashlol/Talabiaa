    package Main;
import javax.swing.*;

import Model.Board;
import Model.SidePanel;

import java.awt.*;

public class Main{
    
    public static void main(String [] args) {

        JFrame frame = new JFrame("Talabia");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        frame.setSize(810,635);
        frame.setLocationRelativeTo(null);

        Board board = new Board();
        SidePanel sp = new SidePanel();
        frame.add(board, BorderLayout.CENTER);
        frame.add(sp, BorderLayout.EAST);

        // Board board = new Board();
        // board.startGame();

        board.launchGame();
    }
}
