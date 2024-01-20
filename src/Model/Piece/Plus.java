package Model.Piece;

import Model.Color;

public class Plus extends Piece{

    private Color color;
    
    //constuctor to pass color, column and row into super class
    public Plus(Color color, int col, int row) {
        super(color, col, row);
        this.color=color;
        //check which color is the piece and return their respective imagepath
        image = getImage((color==Color.BLUE) ? "/res/b-plus" : "/res/y-plus");
        
    }

    //@0JingYing
    @Override
    public boolean canMove(int targetCol, int targetRow) {
        // Check if the new position is a valid horizontal or vertical move
        int colDiff = Math.abs(targetCol - getCol());
        int rowDiff = Math.abs(targetRow - getRow());
        int colIncrement;
        int rowIncrement;


        if ((colDiff == 0 && rowDiff > 0) || (colDiff > 0 && rowDiff == 0)) {
        // Check if there are no pieces in the path
        /*if (targetCol > getCol()) {
            colIncrement = 1;
        } else if (targetCol < getCol()) {
            colIncrement = -1;
        } else {
            colIncrement = 0;
        }
        
        if (targetRow > getRow()) {
            rowIncrement = 1;
        } else if (targetRow < getRow()) {
            rowIncrement = -1;
        } else {
            rowIncrement = 0;
        }*/

        colIncrement = (targetCol > getCol()) ? 1 : (targetCol < getCol()) ? -1 : 0;
        rowIncrement = (targetRow > getRow()) ? 1 : (targetRow < getRow()) ? -1 : 0;


        int currentCol = getCol() + colIncrement;
        int currentRow = getRow() + rowIncrement;

        while (currentCol != targetCol || currentRow != targetRow) {
            if (board.getPieces()[currentRow][currentCol] != null) {
                // There is a piece in the path, cannot move
                return false;
            }

            currentCol += colIncrement;
            currentRow += rowIncrement;
        }

            // No pieces in the path, valid move
            return true;
        }

        return false;
    }

    //display the piece symbol
    @Override
    public String toString(){
        return (color==Color.BLUE) ? "PL" : "pl";
    }

    @Override
    public String getType() {
        return "Plus";
    }
}
