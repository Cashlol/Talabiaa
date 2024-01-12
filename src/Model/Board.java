package Model;
import View.BoardView;

import javax.swing.*;

import Model.Piece.Hour;
import Model.Piece.Piece;
import Model.Piece.Plus;
import Model.Piece.Point;
import Model.Piece.Sun;
import Model.Piece.Time;

import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel{
    
    private static final int BLUE=0,YELLOW=1;
    private static final int COLS=7,ROWS=6;
    private Piece [][] piece;

    BoardView bv = new BoardView();

    // public static ArrayList<Piece> pieces = new ArrayList<>();

    //constructor to initialize the Piece array
    public Board() {
        setSize(700,700);
        piece = new Piece[ROWS][COLS];
    }

    //launch game calls function to initialize the board
    public void launchGame() {
        // setPieces();
        setBoardPiece();
    }

    //set piece based on the given col and row value
    public void setPiece(Piece piece){
        this.piece[piece.getRow()][piece.getCol()] = piece;
        piece.setBoard(this);
    }

    //add piece based on the given col and row value
    public void addPiece(Piece piece){
        this.piece[piece.getRow()][piece.getCol()] = piece;
        piece.setBoard(this);
    }

    //initialize board pieces into their respective coordinates
    public void setBoardPiece() {

        //add point pieces for both yellow and blue
        for(int x=0;x<COLS;x++) {
            addPiece(new Point(YELLOW,x,4));
            addPiece(new Point(BLUE,x,1));
        }

        //add yellow pieces 
        addPiece(new Plus(YELLOW,0,3));
        addPiece(new Hour(YELLOW,1,5));
        addPiece(new Time(YELLOW,2,5));
        addPiece(new Sun(YELLOW,3,5));
        addPiece(new Time(YELLOW,4,5));
        addPiece(new Hour(YELLOW,5,5));
        addPiece(new Plus(YELLOW,6,5));
        
        //add blue pieces
        addPiece(new Plus(BLUE,0,0));
        addPiece(new Hour(BLUE,1,0));
        addPiece(new Time(BLUE,2,0));
        addPiece(new Sun(BLUE,3,0));
        addPiece(new Time(BLUE,4,0));
        addPiece(new Hour(BLUE,5,0));
        addPiece(new Plus(BLUE,6,0));

        //testing the array output for the pieces
        for(int x=0;x<ROWS;x++) {
            for(int y=0;y<COLS;y++) {
                if(piece[x][y] != null) {
                    System.out.print(piece[x][y] + " ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println(" ");
        }

        repaint();

    }

    // public void flipBoard() {

    //     for (int x = 0; x < ROWS / 2; x++) {
    //         for (int y = 0; y < COLS; y++) {
    //             // Swap the pieces in the top and bottom rows
    //             Piece temp = piece[x][y];
    //             piece[x][y] = piece[ROWS - 1 - x][y];
    //             piece[ROWS - 1 - x][y] = temp;
    //         }
    //     }

    //     // Redraw the board
    //     repaint();
    // }

    public void doesSomething() {
        movePiece(new Plus(YELLOW,0,5),3,0);

        for(int x=0;x<ROWS;x++) {
            for(int y=0;y<COLS;y++) {
                if(piece[x][y] != null) {
                    System.out.print(piece[x][y] + " ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println(" ");
        }

        System.out.println("clicking");
    }

    public void movePiece(Piece piece, int newRow, int newCol) {
        this.piece[piece.getRow()][piece.getCol()] = null;
        piece.setRow(newRow);
        piece.setCol(newCol);
        this.setPiece(piece);

        repaint();
    }

    //draws the images for each pieces that was passed from the arraylist Piece
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        bv.draw(g2);

        //draw image for each piece that is not null
        for(int x=0;x<ROWS;x++) {
            for(int y=0;y<COLS;y++) {
                if(piece[x][y] != null) {
                    piece[x][y].draw(g2);
                }
            }
        }

    }
}
