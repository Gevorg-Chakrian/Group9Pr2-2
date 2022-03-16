import AI.State;
import Chessboard.Board;
import Chessboard.Game;
import Utilities.DataFrame;
import Utilities.Logistic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestConvertVector {
    Board board;
    @BeforeEach
    void setup() {
        Game g = new Game();
        g.start_game();
        board = Board.getInstance();
    }


    @Test
    void testSimpleGame() {
       // Board.getInstance().getSquareByNotation("d2").getPiece().move(Board.getInstance().getSquareByNotation("a4"), Board.getInstance());
        double[] move1 =DataFrame.convert_to_vector(new State(board,-1),"4143");

        Logistic logistic = new Logistic(896);

        System.out.println("MOVE PREDICTED AS:");
        System.out.println(logistic.predict(move1,true,""));

    }
}
