import Chessboard.Board;
import Chessboard.DiceFace;
import Chessboard.Game;
import Chessboard.Square;
import Pieces.Pawn;
import Pieces.Queen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
//uncomment for testing phase1
class QueenTest {
    Queen queen33;
    Queen queen00;
    Board board;
    Board tmp = Board.getInstance();
    Game game;

    @BeforeEach
    void setup() {
        game = new Game();
        game.start_game();
        //DiceFace.testThrow=true;
        board = tmp;
        queen33 = new Queen(1, 3, 3);
        queen00 = new Queen(1,0,0);
    }

    @Test
    void testMoveForward(){
        Square square10 = new Square(false,1,0);
        assertTrue(queen00.move(square10,board));

    }





    @Test
    void testGreaterGreaterObstacle() {
        assertFalse(queen33.move(Board.getInstance().getSquares()[7][7],board));
    }


    @Test
    void testUnreachableSquareVertical() {
        assertFalse(queen33.move(Board.getInstance().getSquares()[5][2],board));
    }

    @Test
    void testUnreachableSquareHorizontal() {
        assertFalse(queen33.move(Board.getInstance().getSquares()[2][1],board));
    }


    @Test
    void testLegalButSameColor() {
        assertFalse(queen33.move(Board.getInstance().getSquares()[1][5],board));
    }

    @Test
    void isSameRow() {
        Square square = new Square(false, 3, 5);
        assertTrue(queen33.move(square,board));
    }

    @Test
    void isSameColumn() {
        Square square = new Square(false, 5, 3);
        assertTrue(queen33.move(square,board));
    }

    @Test
    void isSameColumnOccupied() {
        Board.getInstance().getSquares()[7][3] = new Square(new Pawn(1, 7, 3));
        assertFalse(queen33.move(Board.getInstance().getSquares()[7][3],board));
    }

    @Test
    void isSameRowOccupied() {
        Board.getInstance().getSquares()[3][5] = new Square(new Pawn(1, 3, 5));
        assertFalse(queen33.move(Board.getInstance().getSquares()[3][5],board));
    }
}
