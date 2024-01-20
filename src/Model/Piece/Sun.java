package Model.Piece;

import Model.Color;

public class Sun extends Piece{

    private Color color;
    
    //constuctor to pass color, column and row into super class
    public Sun(Color color, int col, int row) {
        super(color, col, row);
        this.color=color;
        //check which color is the piece and return their respective imagepath
        image = getImage((color==Color.BLUE) ? "/res/b-sun" : "/res/y-sun");
        
    }

    //@0JingYing
    @Override
    public boolean canMove(int targetCol, int targetRow) {
        if (Math.abs(targetCol - getCol()) <= 1 && Math.abs(targetRow - getRow()) <= 1)
        {
            return true;
        }
        return false;
    }

    //display the piece symbol
    //blue = 0, uppercase symbol
    //yellow = 1, lowercase symbol
    @Override
    public String toString(){
        return (color==Color.BLUE) ? "SN" : "sn";
    }

    @Override
    public String getType() {
        return "Sun";
    }
}
