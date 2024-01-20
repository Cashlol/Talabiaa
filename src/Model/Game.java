package Model;

public class Game {

    private Color playerTurn;
    
    //initializes the corresponding variables to their default values
    public Game() {
        playerTurn=Color.YELLOW;
    }

    //starts the game by invoking the board class
    public void startGame() {

    }
    
    //check whether the Sun piece is eaten or not
    public void checkGameState() {
        
        endGame();
    }

    //sets the player's color according to their turn
    //yellow starts first, blue goes second
    public void changeTurn() {
        playerTurn = (playerTurn==Color.YELLOW) ? Color.BLUE : Color.YELLOW;
        System.out.println(playerTurn + " player turn to move");
    }

    public Color getTurn() {
        return playerTurn;
    }

    //ends the game when it is invoked inside the controller class
    public void endGame() {

    }

    //load an existing save file and display the previous piece locations
    public void loadGame() {

    }

    //save the current state of the game including the turn and piece locations
    public void saveGame() {

    }
}
