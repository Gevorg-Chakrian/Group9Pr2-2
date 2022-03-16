import Chessboard.Board;
import Chessboard.DiceFace;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    /*

    Board board;


    @BeforeEach
    void setup() {
        DiceFace.testThrow = true;
        board = Board.getInstance();
    }


    @Test
    void testSimpleGame() {
        assertTrue(board.getSquares()[1][4].getPiece().move(board.getSquares()[3][4])); //1. e2 -> e4
        assertTrue(board.getSquares()[6][4].getPiece().move(board.getSquares()[4][4])); //2. e7 -> e5
        assertTrue(board.getSquares()[0][3].getPiece().move(board.getSquares()[4][7])); //3. d1 -> h5
        assertTrue(board.getSquares()[7][5].getPiece().move(board.getSquares()[4][2])); //4. f8 -> c5
        assertTrue(board.getSquares()[0][5].getPiece().move(board.getSquares()[3][2])); //5. f1 -> c4
        assertTrue(board.getSquares()[7][1].getPiece().move(board.getSquares()[5][0])); //6. b8 -> a6
        assertTrue(board.getSquares()[4][7].getPiece().move(board.getSquares()[6][5])); //7. h5 -> e8

        assertEquals(board.getSquares()[6][5].getPiece().getColor(), 1);

    }

    @Test
    void testSimpleGame2() {
        assertTrue(board.getSquares()[1][4].getPiece().move(board.getSquares()[3][4]));//1
        assertTrue(board.getSquares()[7][1].getPiece().move(board.getSquares()[5][2]));//2
        assertTrue(board.getSquares()[0][6].getPiece().move(board.getSquares()[2][7]));//3
        assertTrue(board.getSquares()[6][3].getPiece().move(board.getSquares()[4][3]));//4
        assertTrue(board.getSquares()[3][4].getPiece().move(board.getSquares()[4][3]));//5
        assertTrue(board.getSquares()[7][3].getPiece().move(board.getSquares()[4][3]));//6
        assertTrue(board.getSquares()[0][3].getPiece().move(board.getSquares()[2][5]));//7
        assertTrue(board.getSquares()[4][3].getPiece().move(board.getSquares()[6][3]));//8
        assertTrue(board.getSquares()[0][5].getPiece().move(board.getSquares()[4][1]));//9
        assertTrue(board.getSquares()[7][6].getPiece().move(board.getSquares()[5][5]));//10
        assertTrue(board.getSquares()[4][1].getPiece().move(board.getSquares()[5][2]));//11
        assertTrue(board.getSquares()[6][3].getPiece().move(board.getSquares()[5][2]));//12
        assertTrue(board.getSquares()[2][5].getPiece().move(board.getSquares()[5][2]));//13


    }

    @Test
    void testSimpleGame3() {
        assertTrue(board.getSquareByNotation("a2").getPiece().move(board.getSquareByNotation("a4")));//1
        assertTrue(board.getSquareByNotation("h7").getPiece().move(board.getSquareByNotation("h5")));//2
        assertTrue(board.getSquareByNotation("a1").getPiece().move(board.getSquareByNotation("a3")));//3
        assertTrue(board.getSquareByNotation("g7").getPiece().move(board.getSquareByNotation("g5")));//4
        assertTrue(board.getSquareByNotation("a3").getPiece().move(board.getSquareByNotation("g3")));//5
        assertTrue(board.getSquareByNotation("f8").getPiece().move(board.getSquareByNotation("g7")));//6
        assertTrue(board.getSquareByNotation("g3").getPiece().move(board.getSquareByNotation("g5")));//7
        assertTrue(board.getSquareByNotation("g7").getPiece().move(board.getSquareByNotation("b2")));//8
        assertTrue(board.getSquareByNotation("c1").getPiece().move(board.getSquareByNotation("b2")));//9
        assertTrue(board.getSquareByNotation("b8").getPiece().move(board.getSquareByNotation("c6")));//10
        assertTrue(board.getSquareByNotation("g5").getPiece().move(board.getSquareByNotation("g8")));//11
        assertTrue(board.getSquareByNotation("h8").getPiece().move(board.getSquareByNotation("g8")));//12
        assertTrue(board.getSquareByNotation("a4").getPiece().move(board.getSquareByNotation("a5")));//13
        assertTrue(board.getSquareByNotation("c6").getPiece().move(board.getSquareByNotation("a5")));//14
        assertTrue(board.getSquareByNotation("g2").getPiece().move(board.getSquareByNotation("g4")));//15
        assertTrue(board.getSquareByNotation("a5").getPiece().move(board.getSquareByNotation("b3")));//16
        assertTrue(board.getSquareByNotation("g4").getPiece().move(board.getSquareByNotation("h5")));//17
        assertTrue(board.getSquareByNotation("b3").getPiece().move(board.getSquareByNotation("d2")));//18
        assertTrue(board.getSquareByNotation("e1").getPiece().move(board.getSquareByNotation("d2")));//19
        assertTrue(board.getSquareByNotation("g8").getPiece().move(board.getSquareByNotation("g1")));//20
        assertTrue(board.getSquareByNotation("h1").getPiece().move(board.getSquareByNotation("g1")));//21
        assertTrue(board.getSquareByNotation("c7").getPiece().move(board.getSquareByNotation("c6")));//22
        assertTrue(board.getSquareByNotation("f1").getPiece().move(board.getSquareByNotation("h3")));//23
        assertTrue(board.getSquareByNotation("d8").getPiece().move(board.getSquareByNotation("a5")));//24
        assertTrue(board.getSquareByNotation("d2").getPiece().move(board.getSquareByNotation("d3")));//25
        assertTrue(board.getSquareByNotation("a5").getPiece().move(board.getSquareByNotation("h5")));//26
        assertTrue(board.getSquareByNotation("g1").getPiece().move(board.getSquareByNotation("g5")));//27
        assertTrue(board.getSquareByNotation("h5").getPiece().move(board.getSquareByNotation("g5")));//28
        // some assertFalse
        assertFalse(board.getSquareByNotation("h2").getPiece().move(board.getSquareByNotation("h3")));
        assertFalse(board.getSquareByNotation("d1").getPiece().move(board.getSquareByNotation("c2")));
        assertFalse(board.getSquareByNotation("d1").getPiece().move(board.getSquareByNotation("d4")));
        assertFalse(board.getSquareByNotation("c8").getPiece().move(board.getSquareByNotation("b7")));
        assertFalse(board.getSquareByNotation("c8").getPiece().move(board.getSquareByNotation("d7")));
        assertFalse(board.getSquareByNotation("g5").getPiece().move(board.getSquareByNotation("d8")));
        assertFalse(board.getSquareByNotation("b1").getPiece().move(board.getSquareByNotation("a1")));
        assertFalse(board.getSquareByNotation("e8").getPiece().move(board.getSquareByNotation("e7")));
        assertFalse(board.getSquareByNotation("f2").getPiece().move(board.getSquareByNotation("g1")));

        DiceFace.testThrow = true;
    }

     */


}
