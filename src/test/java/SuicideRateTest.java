import Chessboard.Board;
import Chessboard.Game;
import Pieces.Bishop;
import Pieces.Pawn;
import Pieces.Piece;
import Pieces.Queen;
import org.junit.jupiter.api.BeforeEach;

import java.util.LinkedList;

public class SuicideRateTest {

    Game game;
    Board board;

    @BeforeEach
    void setup() {

        game = new Game();
        board = Board.getInstance();
        game.start_game();

        LinkedList<Piece> whitePieces = new LinkedList<>();
        whitePieces.add(new Bishop(1, 6, 7));
        board.setWhitePieces(whitePieces);

        //*********

        LinkedList<Piece> blackPieces = new LinkedList<>();
        blackPieces.add(new Pawn(-1, 6, 5));
        blackPieces.add(new Pawn(-1, 5, 6));
        blackPieces.add(new Queen(-1, 6, 6));
        board.setBlackPieces(blackPieces);

    }
}
