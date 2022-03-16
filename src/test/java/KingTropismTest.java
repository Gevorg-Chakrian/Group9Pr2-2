import AI.KingTropism;
import AI.PieceEatable;
import Chessboard.*;
import Pieces.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static Chessboard.Board.scale;
import static Utilities.Normalization.normalizeScore;

import Chessboard.Board;
import Chessboard.Square;



/*
X - enemy piece
 ----------------------------------------------------------
| 0      0       0       0       0       0       0       0 |
|                                                          |
| 0      0       0       X       X       X       0       0 |
|                                                          |
| 0      0       X       X       X       X       X       0 |
|                                                          |
| 0      0       X       X       X       X       X       0 |
|                                                          |
| 0      0       0       0       0       0       0       0 |
|                                                          |
| 0      0       0       0       king    0       0       0 |
|                                                          |
| 0      0       0       0       0       0       0       0 |
|                                                          |
| 0      0       0       0       0       0       0       0 |
 ----------------------------------------------------------
 */
public class KingTropismTest {
    Board board;
    Square[][] squares = new Square[8][8];

    @BeforeEach
    void setup() {
        board = Board.getInstance();


        LinkedList<Piece> whitePieces = new LinkedList<>();
        whitePieces.add(new King(1, 5, 4));
        board.setWhitePieces(whitePieces);

        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                squares[i][k] = new Square(false, i, k, scale, Board.getInstance());
            }
        }

        squares[5][4] = new Square(new King(1, 5, 4), Board.getInstance());


        board.setSquares(squares);
    }

    @Test
    void testTropismMin(){
        double score = 0;
        Assertions.assertEquals(new KingTropism(board, 1, false).getOutput(), score);
    }

    @Test
    void testTropismStartGame(){
        double score = 64.0/8;

        Game game;
        game = new Game();
        game.start_game();
        board.setSquares(game.getSquares());
        Assertions.assertEquals(new KingTropism(board, 1, false).getOutput(), 1-normalizeScore(0.35,score));
    }

    @Test
    void testTropismFirstRow(){
        double score = 16.0/5;

        LinkedList<Piece> blackPieces = new LinkedList<>();
        blackPieces.add(new Pawn(-1, 3, 2));
        blackPieces.add(new Pawn(-1, 3, 3));
        blackPieces.add(new Pawn(-1, 3, 4));
        blackPieces.add(new Pawn(-1, 3, 5));
        blackPieces.add(new Pawn(-1, 3, 6));
        board.setBlackPieces(blackPieces);

        squares[3][2] = new Square(new Pawn(-1, 3, 2), Board.getInstance());
        squares[3][3] = new Square(new Pawn(-1, 3, 3), Board.getInstance());
        squares[3][4] = new Square(new Pawn(-1, 3, 4), Board.getInstance());
        squares[3][5] = new Square(new Pawn(-1, 3, 5), Board.getInstance());
        squares[3][6] = new Square(new Pawn(-1, 3, 6), Board.getInstance());

        Assertions.assertEquals(new KingTropism(board, 1, false).getOutput(), 1-normalizeScore(0.35, score));
    }

    @Test
    void testTropismSecondRow() {
        double score = 21.0/5;

        LinkedList<Piece> blackPieces = new LinkedList<>();
        blackPieces.add(new Pawn(-1, 2, 2));
        blackPieces.add(new Pawn(-1, 2, 3));
        blackPieces.add(new Pawn(-1, 2, 4));
        blackPieces.add(new Pawn(-1, 2, 5));
        blackPieces.add(new Pawn(-1, 2, 6));
        board.setBlackPieces(blackPieces);

        squares[2][2] = new Square(new Pawn(-1, 2, 2), Board.getInstance());
        squares[2][3] = new Square(new Pawn(-1, 2, 3), Board.getInstance());
        squares[2][4] = new Square(new Pawn(-1, 2, 4), Board.getInstance());
        squares[2][5] = new Square(new Pawn(-1, 2, 5), Board.getInstance());
        squares[2][6] = new Square(new Pawn(-1, 2, 6), Board.getInstance());

        Assertions.assertEquals(new KingTropism(board, 1, false).getOutput(), 1-normalizeScore(0.35, score));
    }

    @Test
    void testTropismThirdRow() {
        double score = 14.0/3;

        LinkedList<Piece> blackPieces = new LinkedList<>();
        blackPieces.add(new Pawn(-1, 1, 3));
        blackPieces.add(new Pawn(-1, 1, 4));
        blackPieces.add(new Pawn(-1, 1, 5));
        board.setBlackPieces(blackPieces);

        squares[1][3] = new Square(new Pawn(-1, 1, 3), Board.getInstance());
        squares[1][4] = new Square(new Pawn(-1, 1, 4), Board.getInstance());
        squares[1][5] = new Square(new Pawn(-1, 1, 5), Board.getInstance());

        Assertions.assertEquals(new KingTropism(board, 1, false).getOutput(), 1-normalizeScore(0.35, score));
    }

    @Test
    void testTropismAll(){
        double score = 51.0/13;

        LinkedList<Piece> blackPieces = new LinkedList<>();
        blackPieces.add(new Pawn(-1, 3, 2));
        blackPieces.add(new Pawn(-1, 3, 3));
        blackPieces.add(new Pawn(-1, 3, 4));
        blackPieces.add(new Pawn(-1, 3, 5));
        blackPieces.add(new Pawn(-1, 3, 6));

        blackPieces.add(new Pawn(-1, 2, 2));
        blackPieces.add(new Pawn(-1, 2, 3));
        blackPieces.add(new Pawn(-1, 2, 4));
        blackPieces.add(new Pawn(-1, 2, 5));
        blackPieces.add(new Pawn(-1, 2, 6));

        blackPieces.add(new Pawn(-1, 1, 3));
        blackPieces.add(new Pawn(-1, 1, 4));
        blackPieces.add(new Pawn(-1, 1, 5));
        board.setBlackPieces(blackPieces);

        squares[3][2] = new Square(new Pawn(-1, 3, 2), Board.getInstance());
        squares[3][3] = new Square(new Pawn(-1, 3, 3), Board.getInstance());
        squares[3][4] = new Square(new Pawn(-1, 3, 4), Board.getInstance());
        squares[3][5] = new Square(new Pawn(-1, 3, 5), Board.getInstance());
        squares[3][6] = new Square(new Pawn(-1, 3, 6), Board.getInstance());

        squares[2][2] = new Square(new Pawn(-1, 2, 2), Board.getInstance());
        squares[2][3] = new Square(new Pawn(-1, 2, 3), Board.getInstance());
        squares[2][4] = new Square(new Pawn(-1, 2, 4), Board.getInstance());
        squares[2][5] = new Square(new Pawn(-1, 2, 5), Board.getInstance());
        squares[2][6] = new Square(new Pawn(-1, 2, 6), Board.getInstance());

        squares[1][3] = new Square(new Pawn(-1, 1, 3), Board.getInstance());
        squares[1][4] = new Square(new Pawn(-1, 1, 4), Board.getInstance());
        squares[1][5] = new Square(new Pawn(-1, 1, 5), Board.getInstance());

        Assertions.assertEquals(new KingTropism(board, 1, false).getOutput(), 1-normalizeScore(0.35, score));
    }

    @Test
    void testTropismMax(){

        double score = 4.0/1;

        LinkedList<Piece> blackPieces = new LinkedList<>();
        blackPieces.add(new Pawn(-1, 3, 6));
        board.setBlackPieces(blackPieces);

        squares[3][6] = new Square(new Pawn(-1, 3, 6), Board.getInstance());

        Assertions.assertEquals(new KingTropism(board, 1, false).getOutput(), 1-normalizeScore(0.35, score));
    }
}