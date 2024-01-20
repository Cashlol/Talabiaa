package Model;

import Model.Piece.*;
import View.BoardView;
import View.GameView;


public class Board{
    
    public static final int COLS=7,ROWS=6;
    private Piece [][] piece;
    private Piece activePiece;
    private BoardView bv = new BoardView();
    private GameView gameView;
    private Game game;
    private int posX, posY;
    private Boolean pressed;
    // private Mouse mouse;


    //initialize the Piece array @Acash @JingYing
    public Board() {
        piece = new Piece[ROWS][COLS];
        game = new Game();
        activePiece= null;// No active piece initially
        initializePieces();
        // addMouseMotionListener(mouse);
        // addMouseListener(mouse);
    }

    //initialize board pieces into their respective coordinates @Acash
    public void initializePieces() {

        //add point piece for yellow and blue
        for(int x=0;x<COLS;x++) {
            setPiece(new Point(Color.YELLOW,x,4));
            setPiece(new Point(Color.BLUE,x,1));
        }

        //add blue and yellow pieces 
        setPiece(new Plus(Color.YELLOW,0,5));
        setPiece(new Hour(Color.YELLOW,1,5));
        setPiece(new Time(Color.YELLOW,2,5));
        setPiece(new Sun(Color.YELLOW,3,5));
        setPiece(new Time(Color.YELLOW,4,5));
        setPiece(new Hour(Color.YELLOW,5,5));
        setPiece(new Plus(Color.YELLOW,6,5));
        setPiece(new Plus(Color.BLUE,0,0));
        setPiece(new Hour(Color.BLUE,1,0));
        setPiece(new Time(Color.BLUE,2,0));
        setPiece(new Sun(Color.BLUE,3,0));
        setPiece(new Time(Color.BLUE,4,0));
        setPiece(new Hour(Color.BLUE,5,0));
        setPiece(new Plus(Color.BLUE,6,0));

        //print out the 2D piece location
        for(int x=0;x<ROWS;x++) {
            for(int y=0;y<COLS;y++) {
                if(piece[x][y] != null) {
                    System.out.print(piece[x][y] + " ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println(" ");
        }
    }

    //set piece based on the given col and row value @Acash
    public void setPiece(Piece piece){
        this.piece[piece.getRow()][piece.getCol()] = piece;
        piece.setBoard(this);
    }

    public Piece getPiece(int col,int row) {
        return piece[col][row];
    }

    public Piece [][] getPieces() {
        return piece;
    }

    //detect active piece @JingYing
    public void updatePiece(int posX, int posY, boolean pressed) {

        this.posX = posX;
        this.posY = posY;
        this.pressed = pressed;
        
        int col = posX / 100; //tile width is 100
        int row = posY / 100;  //tile height is 100 //to convert pixel to tile coordinate

        //check if the pressed is true
        if (pressed && activePiece == null) {
            if (isValidCoordinate(row, col) && piece[row][col] != null) {
                activePiece = piece[row][col];
            }
        } else if (!pressed && activePiece != null) {
            movePiece(row, col);
            activePiece = null;
        }
    }
    
    //check within bound of board @JingYing
    private boolean isValidCoordinate(int row, int col) {
        return row >= 0 && row < ROWS && col >= 0 && col < COLS;
    }
    
    
    //update piece location after move @Jing Ying
    private void movePiece(int newRow, int newCol) {

        if(game.getTurn() != activePiece.getColor()) {
            System.out.println("You cannot move this piece");
        } else {

                    // Check if the new position is within the bounds of the board
        if (isValidCoordinate(newRow, newCol)) {
            // Check if the target cell is empty or contains an opponent's piece
            if ((piece[newRow][newCol] == null || activePiece.canCapture(newCol, newRow))
                    && activePiece.canMove(newCol, newRow)) {
    
                // If there is an opponent's piece, remove it
                if (piece[newRow][newCol] != null && activePiece.canCapture(newCol, newRow)) {
                    // Remove the captured piece
                    piece[newRow][newCol].setIsEaten(); 
                
                    //check whether the piece eaten is a Sun piece, if true then end the game.(to be refactored)
                    if(piece[newRow][newCol].getType()=="Sun" && piece[newRow][newCol].checkIfEaten()) {
                        System.out.println("Game over " + game.getTurn() + " wins ");
                    }

                    piece[newRow][newCol] = null;   

                }
    
                // Clear the old position //without this it cannot go back to its old position.
                int oldRow = activePiece.getRow();
                int oldCol = activePiece.getCol();
                this.piece[oldRow][oldCol] = null;
    
                // Update the active piece's position
                activePiece.setPost(newCol, newRow);
    
                // Add the piece to the new position
                this.piece[newRow][newCol] = activePiece;
    
                System.out.println("\n"+ activePiece.getType() + " moved to Row: " + newRow + ", Col: " + newCol);
                bv.setBoard(this);
                bv.updateView();
                game.changeTurn();
            } else {
                System.out.println("Invalid move.");
            }
        } else {
            System.out.println("Invalid coordinates.");
        }
            
        }
    



    }
}
    
