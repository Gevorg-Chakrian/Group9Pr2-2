import Chessboard.Square;
import Pieces.Knight;
import Pieces.Pawn;
import Chessboard.Board;
import Chessboard.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class KnightTest {
    Knight knight01;
    Board board;
    Game game;



    @BeforeEach
    void setup() {
        knight01 = new Knight(1, 0, 1);
        game = new Game();
        game.start_game();
        board = Board.getInstance();

    }


    @Test
    void testLegalUnoccupied() {
        Square u_square20 = new Square(false, 2, 0);
        assertTrue(knight01.move(u_square20, board));
    }



    @Test
    void testOccupiedBySameColor() {
        Square o_square20 = new Square(new Pawn(1, 2, 0),true);
        assertFalse(knight01.move(o_square20, board));
    }


    @Test
    void testOccupiedByDiffColor() {
        Square o_square20 = new Square(new Pawn(-1, 2, 0),true);
        assertTrue(knight01.move(o_square20, board));
    }


    @Test
    void testUnreachableSquare() {
        Square o_square00 = new Square(true, 5, 0);
        assertFalse(knight01.move(o_square00, board));
    }

    @Test
    void testOccupiedHorizontal() {
        Square o_square21 = new Square(new Pawn(-1, 1, 7 ),true);
        assertFalse(knight01.move(o_square21, board));
    }


    @Test
    void testUnoccupiedHorizontal() {

        Square u_square45 = new Square(false, 1, 4);
    }


}
