import AI.Material;
import Chessboard.Board;
import Chessboard.Game;
import Chessboard.Square;
import Pieces.*;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static Utilities.Normalization.normalizeScore;
import static org.junit.Assert.assertEquals;
public class MaterialTest {

    Board board = new Board(7);
    //Game game = new Game();
    //game.start_game();

    @BeforeEach
    void setup1() {

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
    void testMaterialMax(){
        double score = 39;
        Assertions.assertEquals(Material.getMaterialScore(board, 1), normalizeScore(0.1,score));

    }

    @Test
    void testMaterialMin(){
        double score = 0;
        LinkedList<Piece> wPieces = new LinkedList<>();
        board.setWhitePieces(wPieces);
        Assertions.assertEquals(Material.getMaterialScore(board, 1), normalizeScore(0.1,score));

    }

    @Test
    void testMaterialPawn(){
        double score = 38;
        LinkedList<Piece> wPieces = board.getWhitePieces();
        wPieces.remove(0);
        board.setWhitePieces(wPieces);
        Assertions.assertEquals(Material.getMaterialScore(board, 1), normalizeScore(0.1,score));

    }

    @Test
    void testMaterialKing(){
        double score = 39;
        LinkedList<Piece> wPieces = board.getWhitePieces();
        wPieces.remove(14);
        board.setWhitePieces(wPieces);
        Assertions.assertEquals(Material.getMaterialScore(board, 1), normalizeScore(0.1,score));

    }

    @Test
    void testMaterialQueen(){
        double score = 30;
        LinkedList<Piece> wPieces = board.getWhitePieces();
        wPieces.remove(15);
        board.setWhitePieces(wPieces);
        Assertions.assertEquals(Material.getMaterialScore(board, 1), normalizeScore(0.1,score));

    }

    @Test
    void testMaterialBishop(){
        double score = 36;
        LinkedList<Piece> wPieces = board.getWhitePieces();
        wPieces.remove(13);
        board.setWhitePieces(wPieces);
        Assertions.assertEquals(Material.getMaterialScore(board, 1), normalizeScore(0.1,score));

    }

    @Test
    void testMaterialRook(){
        double score = 34;
        LinkedList<Piece> wPieces = board.getWhitePieces();
        wPieces.remove(8);
        board.setWhitePieces(wPieces);
        Assertions.assertEquals(Material.getMaterialScore(board, 1), normalizeScore(0.1,score));

    }

    @Test
    void testMaterialPawnKnight(){
        double score = 35;
        LinkedList<Piece> wPieces = board.getWhitePieces();
        wPieces.remove(0);
        wPieces.remove(11);
        board.setWhitePieces(wPieces);
        Assertions.assertEquals(Material.getMaterialScore(board, 1), normalizeScore(0.1,score));

    }
}
