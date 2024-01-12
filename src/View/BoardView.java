package View;

import javax.swing.*;
import java.awt.*;

public class BoardView {
    
    private static final int COLS=7,ROWS=6;

    //draw the grids 
    public void draw(Graphics2D g2) {

        for(int x=0;x<COLS;x++) {
            for(int y=0;y<ROWS;y++){
                g2.setColor(Color.WHITE);
                g2.fillRect(x*100, y*100, 100, 100);
                g2.setColor(new Color(57,92,138,255));
                g2.drawRect(x*100, y*100,100,100);
            }
        }
    }
}
