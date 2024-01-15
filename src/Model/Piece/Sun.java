package Model.Piece;

public class Sun extends Piece{

    private int color;
    
    //constuctor to pass color, column and row into super class
    public Sun(int color, int col, int row) {
        super(PieceType.SUN, color, col, row);
        this.color=color;
        //check which color is the piece and return their respective imagepath
        image = getImage((color==0) ? "/res/b-sun" : "/res/y-sun");
        
    }

    //display the piece symbol
    //blue = 0, uppercase symbol
    //yellow = 1, lowercase symbol
    @Override
    public String toString(){
        return (color==0) ? "SN" : "sn";
    }
}
