package Model.Piece;

import Model.Color;

public class Time extends Piece{

    private Color color;
    
    //constuctor to pass color, column and row into super class
    public Time(Color color, int col, int row) {
        super(color, col, row);
        this.color=color;
        //check which color is the piece and return their respective imagepath
        image = getImage((color==Color.BLUE) ? "/res/b-time" : "/res/y-time");
    }

    //@0JingYing
    @Override
    public boolean canMove(int targetCol, int targetRow) {
        // Check if the new position is a valid diagonal move
        int colDiff = Math.abs(targetCol - getCol());
        int rowDiff = Math.abs(targetRow - getRow());
    
        //diagonal move = same distance for column and row
        if (colDiff == rowDiff) {
            //increment 1 to ensure there is no piece can be skip.

            // Check if there are no pieces in the diagonal path
            //If targetCol is greater than the current column (getCol()), it means the target position is to the right of the current position horizontally.
            //If targetCol is not greater than the current column, it means the target position is to the left horizontally, and colIncrement is set to -1
            //If targetRow is greater than the current row (getRow()), it means the target position is below the current position vertically.
            //If targetRow is not greater than the current row, it means the target position is above vertically
            int colIncrement = (targetCol > getCol()) ? 1 : -1;
            int rowIncrement = (targetRow > getRow()) ? 1 : -1;
    
            int currentCol = getCol() + colIncrement;
            int currentRow = getRow() + rowIncrement;
    
            //iterates through each cell along the diagonal path until it reaches the target position
            while (currentCol != targetCol && currentRow != targetRow) {
                if (board.getPieces()[currentRow][currentCol] != null) {
                    // There is a piece in the path, cannot move
                    return false;
                }
            
                currentCol += colIncrement;
                currentRow += rowIncrement;
            }
    
            //If the loop completes without encountering any obstacles
            // No pieces in the path, valid move
            return true;
        }
    
        return false;
    }

    //display the piece symbol
    //blue = 0, uppercase symbol
    //yellow = 1, lowercase symbol
    @Override
    public String toString(){
        return (color==Color.BLUE) ? "TM" : "tm";
    }

    @Override
    public String getType() {
        return "Time";
    }
}
