package Controller;

import Model.Board;
import Model.Piece.Piece;
import View.BoardView;
import View.GameView;
import java.awt.event.*;

public class Controller extends  MouseAdapter{
    
    private Board board;
    private GameView gameView;
    private Piece [][] piece;

    public int posX, posY;
    public boolean pressed;

    public Controller(Board board, GameView gameView) {
        this.board = board;
        this.gameView = gameView;
        piece=board.getPieces();
        gameView.addMouseListener(this);
        gameView.addMouseMotionListener(this);
    }

    public void initController() {
        // gameView.addMouseListener(mouse);
        // gameView.addMouseMotionListener(mouse);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        posX = e.getX();
        posY = e.getY();
        board.updatePiece(posX,posY,pressed);
        gameView.revalidate();
        gameView.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        posX = e.getX();
        posY = e.getY();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        pressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    pressed = false;
    posX = e.getX();
    posY = e.getY();
    board.updatePiece(posX, posY, pressed);
    gameView.revalidate();
    gameView.repaint();
}


    //unused
    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}    

    @Override
    public void mouseClicked(MouseEvent e) {}


}




