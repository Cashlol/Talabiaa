package Model;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SidePanel extends JPanel{

    JButton saveBtn,loadBtn,endBtn;
    JButton testFlip,testMove;

    Board board = new Board();
    
    //display the java panel with Save,Load and End button on the side
    public SidePanel() {

        setSize(100,100);
        setLayout(new GridLayout(2,1));
        saveBtn = new JButton("Save Game");
        loadBtn = new JButton("Load Game");
        endBtn = new JButton("End Game");

        //test the functions only
        testFlip = new JButton("Flip Test");
        testMove = new JButton("Move Test");

        testFlip.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // board.flipBoard();
            }
        });

        testMove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //board.doesSomething();
            }
        });

        add(testFlip);
        add(testMove);

        // add(saveBtn);
        // add(loadBtn);
        // add(endBtn);
    }
}
