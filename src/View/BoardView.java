package View;

import javax.swing.*;
import java.awt.*;
import Model.Board;
import Model.Piece.Piece;

public class BoardView extends JPanel{

    private static final int COLS=7,ROWS=6;
    private static Piece [][] pieces = new Piece[ROWS][COLS];
    private Board board;
    
    //initiliaze the board and pieces based on the Board object parameter
    public void setBoard(Board board) {
        this.board = board;
        pieces=board.getPieces();

        // System.out.println("Board View updating");
        // for(int x=0;x<ROWS;x++) {
        //     for(int y=0;y<COLS;y++) {
        //         if(pieces[x][y] != null) {
        //             System.out.print(pieces[x][y] + " ");
        //         } else {
        //             System.out.print("   ");
        //         }
        //     }
        //     System.out.println(" ");
        // }

    }

    public void updateView() {
        repaint();
    }
  
    //draw the tiles and pieces on location that has a piece @Acash
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        //required to make tiles resizeable
        //int tileWidth = getWidth() / COLS;
        //int tileHeight = getHeight() / ROWS;

        //default value, not resizeable
        int tileWidth = 100;
        int tileHeight = 100;

        for (int x = 0; x < ROWS; x++) {
            for (int y = 0; y < COLS; y++) {
                
                g2.setColor(Color.WHITE);
                g2.fillRect(y*tileWidth, x*tileHeight, tileWidth, tileHeight);
                g2.setColor(new Color(57,92,138,255));
                g2.drawRect(y*tileWidth, x*tileHeight,tileWidth, tileHeight);

                if(pieces[x][y] != null) {
                    pieces[x][y].drawPieces(g2);
                }

            }
        }

    }


}
