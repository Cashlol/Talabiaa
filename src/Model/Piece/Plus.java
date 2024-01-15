package Model.Piece;

public class Plus extends Piece{

    private int color;
    
    //constuctor to pass color, column and row into super class
    public Plus(int color, int col, int row) {
        super(PieceType.PLUS,color, col, row);
        this.color=color;
        //check which color is the piece and return their respective imagepath
        image = getImage((color==0) ? "/res/b-plus" : "/res/y-plus");
        
    }

    @Override
public boolean moveValidate(int targetCol, int targetRow) {
    // Check if the new position is a valid horizontal or vertical move
    int colDiff = Math.abs(targetCol - getCol());
    int rowDiff = Math.abs(targetRow - getRow());

    if ((colDiff == 0 && rowDiff > 0) || (colDiff > 0 && rowDiff == 0)) {
        // Check if there are no pieces in the path
        int colIncrement = (targetCol > getCol()) ? 1 : (targetCol < getCol()) ? -1 : 0;
        int rowIncrement = (targetRow > getRow()) ? 1 : (targetRow < getRow()) ? -1 : 0;

        int currentCol = getCol() + colIncrement;
        int currentRow = getRow() + rowIncrement;

        while (currentCol != targetCol || currentRow != targetRow) {
            if (board.getPiece(currentRow,currentCol) != null) {
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
    //blue = 0, uppercase symbol
    //yellow = 1, lowercase symbol
    @Override
    public String toString(){
        return (color==0) ? "PL" : "pl";
    }
}