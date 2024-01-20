package Main;


import Controller.Controller;
import Model.Board;
import View.BoardView;
import View.GameView;

public class Main{

    
    public static void main(String [] args) {

        Board board = new Board();
        BoardView bv = new BoardView();
        bv.setBoard(board);
        GameView gameView = new GameView();
        Controller controller = new Controller(board, gameView);
        

    }
}
