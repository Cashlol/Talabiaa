package Model.Piece;

public class Point extends Piece{

    private int color;
    
    //constuctor to pass color, column and row into super class
    public Point(int color, int col, int row) {
        super(color, col, row);
        this.color=color;
        //check which color is the piece and return their respective imagepath
        image = getImage((color==0) ? "/res/b-point" : "/res/y-point");
    }

    @Override
    public boolean canMove(int targetCol, int targetRow) {
        // Check if the new position is a valid move forward or backward
        int colDiff = Math.abs(targetCol - getCol());
        int rowDiff = targetRow - getRow();

        // Check if the move is within the allowed range and in the correct direction
        if (colDiff == 0 && (
            (rowDiff == -1 && getRow() >= 0) ||
            (rowDiff == -2 && getRow() >= 0 && targetRow >= 0) 
        )) {
                // Check if there are no pieces in the path
                int rowIncrement = (targetRow > getRow()) ? 1 : -1;

                int currentRow = getRow() + rowIncrement;

                while (currentRow != targetRow) {
                if (board.getPieceArray()[currentRow][getCol()] != null) {
                    // There is a piece in the path, cannot move
                    return false;
                }

                currentRow += rowIncrement;
            }

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
        return (color==0) ? "PT" : "pt";
    }
}
