package Model.Piece;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Model.Board;

public class Piece {
    
    public BufferedImage image;
    private int x,y;
    private int col,row;
    private int color;
    private Boolean hasPiece=false;

    private Board board;

    public Piece(int color, int col, int row) {
        this.color=color;
        this.col=col;
        this.row=row;
        hasPiece=true;
        x = getX(col);
        y = getY(row);
    }
  
    //read the imagepath passed and store into the bufferedimage
    //return the corresponding image from the res folder 
    public BufferedImage getImage(String imagePath) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(getClass().getResource(imagePath + ".png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    //return image x coordinate according to tile size
    public int getX(int col) {
        return col*100;
    }

    //return image y coordinate according to tile size
    public int getY(int row) {
        return row*100;
    }

    //getter function to return column value
    public int getCol() {
        return col;
    }

    //getter function to return row value
    public int getRow() {
        return row;
    }

    public void setCol(int newCol) {
        col = newCol;
    }

    public void setRow(int newRow) {
        col = newRow;
    }

    //setter function to set board object
    public void setBoard(Board board) {
        this.board = board;
    }

    public void movePiece() {}

    public Boolean hasPiece() {
        return hasPiece=true;
    }

    //draw the game pieces based on the given parameter of :
    //x-coordinate
    //y-coordinate
    //image size
    public void draw(Graphics2D g2) {
        g2.drawImage(image,x,y,100,100,null);
    }

    //removes the object location returned when subclasses symbol is printed
    @Override
    public String toString() {
        return "";
    }
}
