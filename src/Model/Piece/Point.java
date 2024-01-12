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

    //display the piece symbol
    //blue = 0, uppercase symbol
    //yellow = 1, lowercase symbol
    @Override
    public String toString(){
        return (color==0) ? "PT" : "pt";
    }
}
