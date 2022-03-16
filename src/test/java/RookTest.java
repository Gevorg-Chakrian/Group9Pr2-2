import Chessboard.Board;
import Chessboard.Game;
import Chessboard.Square;
import Pieces.Pawn;
import Pieces.Rook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RookTest {
    //uncomment for testing phase1
    Rook rook33;
    Board board;
    Board tmp = Board.getInstance();
    Game game;

    @BeforeEach
    void setup() {
        game = new Game();
        game.start_game();
        rook33 = new Rook(1, 3, 3);
        board = tmp;

    }


    @Test
    void isSameRowUnoccupied() {
        Square square = new Square(false, 3, 5);
        assertTrue(rook33.move(square, board));
    }

    @Test
    void isSameColumnUnoccupied() {
        Square square = new Square(false, 5, 3);
        assertTrue(rook33.move(square, board));
    }

    @Test
    void isUnreachable() {
        Square square = new Square(false, 4, 2);
        assertFalse(rook33.move(square, board));
    }


    @Test
    void isSameColumnOccupied() {
        Board.getInstance().getSquares()[7][3] = new Square(new Pawn(1, 7, 3));
        assertFalse(rook33.move(Board.getInstance().getSquares()[7][3],board));
    }

    @Test
    void isSameRowOccupied() {
        Board.getInstance().getSquares()[3][5] = new Square(new Pawn(1, 3, 5));
        assertFalse(rook33.move(Board.getInstance().getSquares()[3][5],board));
    }


}
