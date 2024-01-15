package Model.Piece;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Model.Board;

public class Piece {

    public BufferedImage image;
    public int x, y;

    private int col, row;
    private int color;
    private PieceType pieceType; // Use the enumeration type here

    protected Board board;


    public Piece(PieceType pieceType, int color, int col, int row) {
        this.pieceType = pieceType;
        this.color = color;
        this.col = col;
        this.row = row;
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
    // Getter method for pieceType
    public PieceType getPieceType() {
        return pieceType;
    }

    // Enum to represent different piece types
    public enum PieceType {
        POINT, HOURGLASS, TIME, PLUS, SUN
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

    //getter function to return color value
    public int getColor()
    {
        return color;
    }

    public void setCol(int newCol) {
        col = newCol;
    }
    
    public void setRow(int newRow) {
        // Update the correct variable, which is row
        row = newRow;
    }

    //setter function to set board object
    public void setBoard(Board board) {
        this.board = board;
    }

    //draw the game pieces based on the given parameter of :
    //x-coordinate
    //y-coordinate
    //image size
    public void draw(Graphics2D g2) {
        g2.drawImage(image,x,y,100,100,null);
    }

    public void drawAtCurrentPosition(Graphics2D g2) {
        g2.drawImage(image, x, y, 100, 100, null);
    }
    

    // New method to check if the mouse is over the piece
    public boolean isMouseOver(int mouseX, int mouseY) {
        int pieceX = getX(this.col);
        int pieceY = getY(this.row);
        int pieceWidth = 100; // Replace with your actual piece width
        int pieceHeight = 100; // Replace with your actual piece height

        return (mouseX >= pieceX && mouseX <= pieceX + pieceWidth &&
                mouseY >= pieceY && mouseY <= pieceY + pieceHeight);
    }

    public boolean moveValidate(int goCol, int goRow)
    {
        //override by subclass

        return true;
    }

    public boolean canCapture(int goRow, int goCol) {
        // Get the piece at the target position
        Piece targetPiece = board.getPiece(goRow,goCol);
    
        // Check if there is a piece at the target position and it belongs to the opposite team
        return (targetPiece != null && targetPiece.color != this.color);
    }
    //removes the object location returned when subclasses symbol is printed
    @Override
    public String toString() {
        return "";
    }
}
