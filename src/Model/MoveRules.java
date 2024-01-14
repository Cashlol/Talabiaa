package Model.Piece;

public interface MoveRules {
    boolean canMove(int targetCol, int targetRow);
}
