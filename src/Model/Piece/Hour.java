package Model.Piece;

import Model.Color;

public class Hour extends Piece{

    private Color color;
    //constuctor to pass color, column and row into super class
    public Hour(Color color, int col, int row) {
        super(color, col, row);
        this.color=color;
        //check which color is the piece and return their respective imagepath
        image = getImage((color==Color.BLUE) ? "/res/b-hour" : "/res/y-hour");
    }

    //@JingYing
    @Override
    public boolean canMove(int targetCol, int targetRow) {
        // Check if the new position is a valid L-shaped move
        //using absolute value, which turn the negative to positive, useful when calculate distance
        int colDiff = Math.abs(targetCol - getCol());
        int rowDiff = Math.abs(targetRow - getRow());

        if((colDiff == 1 && rowDiff == 2) || (colDiff == 2 && rowDiff == 1)){
            return true;
        }
        return false;
    }

    //display the piece symbol
    @Override
    public String toString(){
        return (color==Color.BLUE) ? "HR" : "hr";
    }

    @Override
    public String getType() {
        return "Hour";
    }
}
