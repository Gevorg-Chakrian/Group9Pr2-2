import AI.Material;
import AI.Mobility;
import Chessboard.Board;
import Chessboard.Game;
import Pieces.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.LinkedList;

import static Utilities.Normalization.normalizeScore;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MobilityTest {

    Board board = new Board(7);
    Game game = new Game();

    @BeforeEach
    void setup(){

        board = Board.getInstance();
        game.start_game();


        LinkedList<Piece> whitePieces = new LinkedList<>();
        for (int i = 0; i<8; i++){
            whitePieces.add(new Pawn(1, 1, i));
        }
        whitePieces.add(new Rook(1, 0, 0));
        whitePieces.add(new Rook(1, 0, 7));
        whitePieces.add(new Knight(1, 0, 1));
        whitePieces.add(new Knight(1, 0, 6));
        whitePieces.add(new Bishop(1, 0, 2));
        whitePieces.add(new Bishop(1, 0, 5));
        whitePieces.add(new King(1, 0, 3));
        whitePieces.add(new Queen(1, 0, 4));
        board.setWhitePieces(whitePieces);


    }

    @Test
    void testGetMobilityScore(){

        double score = 2;

        LinkedList<Piece> wPieces = board.getWhitePieces();

        board.setWhitePieces(wPieces);

        assertEquals(Mobility.getMobilityScore(board,1), normalizeScore(0.1,score));
    }


}
