package Model.Piece;

public class Time extends Piece {

    private int color;

    //constuctor to pass color, column and row into super class
    public Time(int color, int col, int row) {
        super(color, col, row);
        this.color=color;
        //check which color is the piece and return their respective imagepath
        image = getImage((color==0) ? "/res/b-time" : "/res/y-time");
    }

 
    @Override
    public boolean MoveValidate(int goCol, int goRow) {
        int currentCol = getCol();
        int currentRow = getRow();
    
        int columnChange = Math.abs(goCol - currentCol);
        int rowChange = Math.abs(goRow - currentRow);
    
        // Check if the move is diagonal
        if (columnChange == rowChange) {
            // Check for any pieces blocking the way diagonally
            int colDirection = (goCol > currentCol) ? 1 : -1;
            int rowDirection = (goRow > currentRow) ? 1 : -1;
    
            for (int i = 1; i < columnChange; i++) {
                int checkCol = currentCol + i * colDirection;
                int checkRow = currentRow + i * rowDirection;
    
                // Check if there is any piece in the way
                if (board.getPiece(checkRow, checkCol) != null) {//got piece blocking
                    return false;
                }
            }
    
            return true;
        } else {
            // Not a diagonal move
            return false;
        }
    }
    
    //display the piece symbol
    //blue = 0, uppercase symbol
    //yellow = 1, lowercase symbol
    @Override
    public String toString(){
        return (color==0) ? "TM" : "tm";
    }
}
