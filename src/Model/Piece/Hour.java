package Model.Piece;

public class Hour extends Piece{

    private int color;
    //constuctor to pass color, column and row into super class
    public Hour(int color, int col, int row) {
        super(color, col, row);
        this.color=color;
        //check which color is the piece and return their respective imagepath
        image = getImage((color==0) ? "/res/b-hour" : "/res/y-hour");
    }

    //display the piece symbol
    //blue = 0, uppercase symbol
    //yellow = 1, lowercase symbol
    @Override
    public String toString(){
        return (color==0) ? "HR" : "hr";
    }
}
