import Chessboard.Board;
import Chessboard.Game;
import Chessboard.Square;
import Pieces.King;
import Pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//uncomment for testing phase1
public class KingTest {

    Board board;
    Game game;
    King king00;

    @BeforeEach
    void setup(){
        game = new Game();
        game.start_game();
        board = Board.getInstance();
        king00 = new King(1,0,0);

    }

    @Test
    void testUnoccupiedSquare(){
        Square square11 = new Square(false,1,1);
        assertTrue(king00.move(square11,board));
    }

    @Test
    void testOccupiedSquare(){
        Square square11 = new Square(new Pawn(1,1,1), false);
        Square square01 = new Square(new Pawn(-1,0,1), false);
        //same color so the test must be false
        assertFalse(king00.move(square11, board));
        //different color so the test must be true
       // assertFalse(king00.move(square01,board));

    }

    @Test

    void moves() {

        assertTrue(board.getSquares()[1][4].getPiece().move(board.getSquares()[3][4],board)); //1. e2 -> e4
        assertTrue(board.getSquares()[6][4].getPiece().move(board.getSquares()[4][4],board)); //2. e7 -> e5
        assertTrue(board.getSquares()[0][5].getPiece().move(board.getSquares()[3][2],board)); //5. f1 -> c4
        assertTrue(board.getSquares()[7][1].getPiece().move(board.getSquares()[5][0],board)); //6. b8 -> a6


    }

    @Test
    void testCheckedWhenTakePiece() {
        moves();
        assertNotNull(Board.getInstance().getSquares()[7][4].getPiece());
        assertFalse(Board.getInstance().getSquares()[7][4].getPiece().move(Board.getInstance().getSquares()[6][5], board));
        assertNotNull(Board.getInstance().getSquares()[7][4].getPiece());
    }

    /*
    Board board;

    @BeforeEach
    void setup() {
        board = Board.getInstance();
    }


    void moves() {

        assertTrue(board.getSquares()[1][4].getPiece().move(board.getSquares()[3][4])); //1. e2 -> e4
        assertTrue(board.getSquares()[6][4].getPiece().move(board.getSquares()[4][4])); //2. e7 -> e5
        assertTrue(board.getSquares()[0][3].getPiece().move(board.getSquares()[4][7])); //3. d1 -> h5
        assertTrue(board.getSquares()[7][5].getPiece().move(board.getSquares()[4][2])); //4. f8 -> c5
        assertTrue(board.getSquares()[0][5].getPiece().move(board.getSquares()[3][2])); //5. f1 -> c4
        assertTrue(board.getSquares()[7][1].getPiece().move(board.getSquares()[5][0])); //6. b8 -> a6
        assertTrue(board.getSquares()[4][7].getPiece().move(board.getSquares()[6][5])); //7. h5 -> e8

   }
    @Test
    void testChecked() {
        moves();
        assertFalse(Board.getInstance().getSquares()[7][4].getPiece().move(Board.getInstance().getSquares()[7][5]));

    }
    @Test
    void testMove() {
        assertFalse(board.getSquares()[0][4].getPiece().checkLegal(board.getSquares()[2][3]));

    }
    */
    /*
    @Test
    void testChecked2() {
        moves();

        assertFalse(Board.getInstance().getSquares()[7][4].getPiece().move(Board.getInstance().getSquares()[6][4]));

    }

    // king makes move, but if he makes it he gets checked,
    // so move doesn't happen and board reverts back to form before making a move
    @Test
    void testCheckedWhenTakePiece() {
        moves();
        assertNotNull(Board.getInstance().getSquares()[7][4].getPiece());
        assertFalse(Board.getInstance().getSquares()[7][4].getPiece().move(Board.getInstance().getSquares()[6][5]));
        assertNotNull(Board.getInstance().getSquares()[7][4].getPiece());
    }
    */
}








