package Model.Piece;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import Model.Color;
import Model.Board;

public class Point extends Piece {

    private Color color;
    private boolean rotate = false;
    private int count=0;

    // Constructor to pass color, column, and row into the super class
    public Point(Color color, int col, int row) {
        super(color, col, row);
        this.color = color;
        // Check which color is the piece and return their respective image path
        image = getImage((color == Color.BLUE) ? "/res/b-point" : "/res/y-point");
    }

    //@0JingYing
    public void rotateImage() {
        // Get the current image width and height
        int width = image.getWidth();
        int height = image.getHeight();

        // Create an AffineTransform for rotating the image by 180 degrees
        AffineTransform transform = AffineTransform.getRotateInstance(Math.PI, width / 2, height / 2);

        // Create a new BufferedImage to store the rotated image
        BufferedImage rotatedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        // Get the graphics context of the new image
        Graphics2D g2d = rotatedImage.createGraphics();

        // Apply the rotation transformation
        g2d.setTransform(transform);

        // Draw the original image onto the rotated image
        g2d.drawImage(image, 0, 0, null);

        // Dispose of the graphics context
        g2d.dispose();

        // Set the rotated image as the new image
        image = rotatedImage;

        // Update the rotate flag
        rotate = !rotate;
    }

    //@0JingYing
    @Override
    public boolean canMove(int targetCol, int targetRow) {
        int colDiff = Math.abs(targetCol - getCol());
        int rowDiff = Math.abs(targetRow - getRow());

        if (colDiff == 0) {
            // Check if the row difference is within the allowed range
            if (rowDiff > 2) {
                return false; // Move is too long
            }
            int rowIncrement = (targetRow > getRow()) ? 1 : -1;

            // Adjust the move direction based on the rotate flag
            if ((color == Color.BLUE && count % 2 == 0 && rowIncrement == 1) ||
            (color == Color.BLUE && count % 2 == 1 && rowIncrement == -1) ||
            (color == Color.YELLOW && count % 2 == 0 && rowIncrement == -1) ||
            (color == Color.YELLOW && count % 2 == 1 && rowIncrement == 1)) {

                int currentRow = getRow() + rowIncrement;

                while (currentRow != targetRow) {
                    if (board.getPieces()[currentRow][getCol()] != null) {
                        // There is a piece in the path, cannot move
                        return false;
                    }

                    currentRow += rowIncrement;
                }

                // Check if the piece is at the end of the board
                if ((color == Color.BLUE && targetRow == Board.ROWS - 1) ||
                    (color == Color.BLUE && targetRow == 0 ) ||
                    (color == Color.YELLOW && targetRow == 0) ||
                    (color == Color.YELLOW && targetRow == Board.ROWS - 1)) {
                    // Rotate the image by 180 degrees
                    rotateImage();
                    count++;
                }

                return true;
            }
        }

        return false;
    }


    // Display the piece symbol @Acash
    @Override
    public String toString() {
        return (color == Color.BLUE) ? "PT" : "pt";
    }

    @Override
    public String getType() {
        return "Point";
    }
}
