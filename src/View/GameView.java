package View;

import java.awt.*;
import javax.swing.*;


public class GameView extends JFrame{

    private JPanel sidePanel;
    private JButton saveBtn,loadBtn,endBtn;
    private BoardView bv = new BoardView();;

    public GameView() {

        //the main frame to host the panels
        setTitle("Talabia");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());
        setSize(810,636);
        setLocationRelativeTo(null);
        setResizable(true);
        
        //the sidepanel display the buttons
        sidePanel = new JPanel();
        sidePanel.setLayout(new GridLayout(3, 1));
        sidePanel.setPreferredSize(new Dimension(100,100));
        saveBtn = new JButton("Save Game");
        loadBtn = new JButton("Load Game");
        endBtn  = new JButton("End Game");
        
        sidePanel.add(saveBtn);
        sidePanel.add(loadBtn);
        sidePanel.add(endBtn);
        
        //adding the board gui and side panel into the frame
        // add(sidePanel, BorderLayout.EAST);
        add(bv, BorderLayout.CENTER);
        add(sidePanel, BorderLayout.EAST);
    }



    

    
}
