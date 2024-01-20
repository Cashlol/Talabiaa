package Model.Piece;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.w3c.dom.events.MouseEvent;

import Model.Board;
import Model.Color;


public abstract class Piece implements MoveRules{
    
    public BufferedImage image;
    private int x,y;
    private int col,row;
    private Boolean isEaten;
    private Color color;
    
    protected Board board;

    public Piece(Color color, int col, int row) {
        this.color=color;
        this.col=col;
        this.row=row;
        isEaten=false;
        x = getX(col);
        y = getY(row);
    }
  
    //read the imagepath passed and store into the bufferedimage
    //return the corresponding image from the res folder  @Acash
    public BufferedImage getImage(String imagePath) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(getClass().getResource(imagePath + ".png"));
        } catch(IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    //return image x coordinate according to tile size @Acash
    public int getX(int col) {
        return col*100;
    }

    //return image y coordinate according to tile size @Acash
    public int getY(int row) {
        return row*100;
    }

    //return col value @Acash
    public int getCol() {
        return col;
    }

    //return row value @Acash
    public int getRow() {
        return row;
    }

    public Color getColor() {
        return color;
    }

    //set piece position to new column and row value @Acash
    public void setPost(int newCol, int newRow) {
        col = newCol;
        row = newRow;
    }

    //set board object
    public void setBoard(Board board) {
        this.board = board;
    }

    //draw the pieces
    public void drawPieces(Graphics2D g2) {
        int currentX = getCol() * 100;
        int currentY = getRow() * 100;
        g2.drawImage(image, currentX, currentY, 100, 100, null);
    }

    //@0JingYing
    @Override 
    public boolean canMove(int targetCol, int targetRow) {
        // default implementation (can be overridden by subclasses)
        return true;
    }

    //@0JingYing
    public boolean canCapture(int targetCol, int targetRow) {
        // Get the piece at the target position
        Piece targetPiece = board.getPieces()[targetRow][targetCol];
    
        // Check if there is a piece at the target position and it belongs to the opposite team
        return (targetPiece.color != this.color);
    }

    public void setIsEaten() {
        isEaten=true;
    }

    public Boolean checkIfEaten() {
        return isEaten;
    }
    
    //removes the object location returned when subclasses symbol is printed @Acash
    public abstract String toString();
    public abstract String getType();


}
