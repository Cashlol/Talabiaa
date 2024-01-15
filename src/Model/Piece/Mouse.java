package Model.Piece;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Model.Board;

public class Mouse extends MouseAdapter {
    public int x, y;
    public boolean pressed;
    private Board board;

    public Mouse(Board board) {  // Modify the constructor
        this.board = board;  // Add this line
    }

    @Override
    public void mousePressed(MouseEvent e){
        pressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e){
        pressed = false;
    }

    @Override
    public void mouseDragged(MouseEvent e){
        x = e.getX();
        y = e.getY();
        board.update();
    }

    @Override
    public void mouseMoved(MouseEvent e){
        x = e.getX();
        y = e.getY();
        board.update();
    }
}
