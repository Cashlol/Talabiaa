package Model.Piece;

public class Time extends Piece{

    private int color;
    
    //constuctor to pass color, column and row into super class
    public Time(int color, int col, int row) {
        super(color, col, row);
        this.color=color;
        //check which color is the piece and return their respective imagepath
        image = getImage((color==0) ? "/res/b-time" : "/res/y-time");
    }

    @Override
    public boolean canMove(int targetCol, int targetRow) {
        // Check if the new position is a valid diagonal move
        int colDiff = Math.abs(targetCol - getCol());
        int rowDiff = Math.abs(targetRow - getRow());
    
        if (colDiff == rowDiff) {
            // Check if there are no pieces in the diagonal path
            int colIncrement = (targetCol > getCol()) ? 1 : -1;
            int rowIncrement = (targetRow > getRow()) ? 1 : -1;
    
            int currentCol = getCol() + colIncrement;
            int currentRow = getRow() + rowIncrement;
    
            while (currentCol != targetCol && currentRow != targetRow) {
                if (board.getPieceArray()[currentRow][currentCol] != null) {
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
        return (color==0) ? "TM" : "tm";
    }
}
