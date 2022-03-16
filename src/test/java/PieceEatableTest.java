import AI.Material;
import AI.PieceEatable;
import Chessboard.Board;
import Pieces.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import static Chessboard.Board.scale;
import static Utilities.Normalization.normalizeScore;
import Chessboard.Square;



/*
X - enemy piece
 ----------------------------------------------------------
| 0      0       0       0       0       X       0       0 |
|                                                          |
| X      0       X       0       0       0       0       0 |
|                                                          |
| 0      0       0       0       knight  0       queen   0 |
|                                                          |
| 0      0       bishop  0       0       0       0       0 |
|                                                          |
| 0      X       0       X       0       0       X       0 |
|                                                          |
| 0      0       0       0       king    0       0       0 |
|                                                          |
| 0      0       0       0       0       0       0       0 |
|                                                          |
| rook   0       0       0       0       X       0       0 |
 ----------------------------------------------------------
 */

public class PieceEatableTest {
    Board board;
    Square[][] squares = new Square[8][8];

    @BeforeEach
    void setup() {
        board = Board.getInstance();


        LinkedList<Piece> whitePieces = new LinkedList<>();
        whitePieces.add(new Rook(1, 7, 0));
        whitePieces.add(new Knight(1, 2, 4));
        whitePieces.add(new Bishop(1, 3, 2));
        whitePieces.add(new King(1, 5, 4));
        whitePieces.add(new Queen(1, 2, 6));
        board.setWhitePieces(whitePieces);

        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                squares[i][k] = new Square(false, i, k, scale, Board.getInstance());
            }
        }

        squares[7][0] = new Square( new Rook(1, 7, 0), Board.getInstance());
        squares[2][4] = new Square( new Knight(1, 2, 4), Board.getInstance());
        squares[3][2] = new Square( new Bishop(1, 3, 2), Board.getInstance());
        squares[5][4] = new Square( new King(1, 5, 4), Board.getInstance());
        squares[2][6] = new Square( new Queen(1, 2, 6), Board.getInstance());

        board.setSquares(squares);
    }

    @Test
    void testEatableMin(){
        double score = 0;
        Assertions.assertEquals(new PieceEatable(board, 1).getScore(), normalizeScore(0.1, score));
    }

    @Test
    void testEatablePawn(){
        double score = 2.0/5*10;

        LinkedList<Piece> blackPieces = new LinkedList<>();
        blackPieces.add(new Pawn(-1, 1, 0));
        board.setBlackPieces(blackPieces);

        squares[1][0] = new Square(new Pawn(-1, 1, 0), Board.getInstance());

        Assertions.assertEquals(new PieceEatable(board, 1).getScore(), normalizeScore(0.1, score));
    }

    @Test
    void testEatableKnight(){
        double score = 1.5/5*10;

        LinkedList<Piece> blackPieces = new LinkedList<>();
        blackPieces.add(new Pawn(-1, 4, 1));
        board.setBlackPieces(blackPieces);

        squares[4][1] = new Square(new Knight(-1, 4, 1), Board.getInstance());
        Assertions.assertEquals(new PieceEatable(board, 1).getScore(), normalizeScore(0.1, score));
    }

    @Test
    void testEatableRookBishop(){
        double score = 6.0/5*10;

        LinkedList<Piece> blackPieces = new LinkedList<>();
        blackPieces.add(new Rook(-1, 1, 2));
        blackPieces.add(new Bishop(-1, 4, 3));
        board.setBlackPieces(blackPieces);

        squares[1][2] = new Square(new Rook(-1, 1, 2), Board.getInstance());
        squares[4][3] = new Square(new Bishop(-1, 4, 3), Board.getInstance());

        Assertions.assertEquals(new PieceEatable(board, 1).getScore(), normalizeScore(0.1, score));
    }

    @Test
    void testEatableQueen(){
        double score = 4.0/5*10;

        LinkedList<Piece> blackPieces = new LinkedList<>();
        blackPieces.add(new Queen(-1, 0, 5));
        board.setBlackPieces(blackPieces);

        squares[0][5] = new Square(new Queen(-1, 0, 5), Board.getInstance());

        Assertions.assertEquals(new PieceEatable(board, 1).getScore(), normalizeScore(0.1, score));
    }


    @Test
    void testEatableKing(){
        double score = 5.0/5*10;

        LinkedList<Piece> blackPieces = new LinkedList<>();
        blackPieces.add(new King(-1, 4, 6));
        board.setBlackPieces(blackPieces);

        squares[4][6] = new Square(new King(-1, 4, 6), Board.getInstance());

        Assertions.assertEquals(new PieceEatable(board, 1).getScore(), normalizeScore(0.1, score));
    }

    @Test
    void testEatableMax(){
        double score = 18.5/5*10;

        LinkedList<Piece> blackPieces = new LinkedList<>();
        blackPieces.add(new Pawn(-1, 1, 0));
        blackPieces.add(new Knight(-1, 4, 1));
        blackPieces.add(new Rook(-1, 1, 2));
        blackPieces.add(new Bishop(-1, 4, 3));
        blackPieces.add(new Queen(-1, 0, 5));
        blackPieces.add(new King(-1, 4, 6));
        board.setBlackPieces(blackPieces);

        squares[1][0] = new Square(new Pawn(-1, 1, 0), Board.getInstance());
        squares[4][1] = new Square(new Knight(-1, 4, 1), Board.getInstance());
        squares[1][2] = new Square(new Rook(-1, 1, 2), Board.getInstance());
        squares[4][3] = new Square(new Bishop(-1, 4, 3), Board.getInstance());
        squares[0][5] = new Square(new Queen(-1, 0, 5), Board.getInstance());
        squares[4][6] = new Square(new King(-1, 4, 6), Board.getInstance());

        Assertions.assertEquals(new PieceEatable(board, 1).getScore(), normalizeScore(0.1, score));
    }
}