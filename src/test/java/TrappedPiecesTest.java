import AI.KingSafety;
import AI.TrappedPieces;
import Chessboard.Board;
import Chessboard.Game;
import Pieces.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static Utilities.Normalization.normalizeScore;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrappedPiecesTest {

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

    @Test
    void testTrappedPieces() {

        assertEquals(TrappedPieces.getTrappedPiecesScore(board , -1) ,normalizeScore(0.1,9) );

    }





}
