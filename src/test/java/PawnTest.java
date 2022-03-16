import Chessboard.Board;
import Chessboard.Game;
import Chessboard.Square;
import Pieces.Pawn;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    Pawn white_pawn11;
    Pawn white_pawn12;
    Pawn black_pawn60;
    Pawn black_pawn12;


    Square unoccupied_square20;
    Square unoccupied_square21;
    Square unoccupied_square50;
    Square occupied_square22;
    Square occupied_square22_diff;
    Square occupied_square22_diag;


    Square square00;

    Square real;
    Pawn realone;

    Board tablero;



    @BeforeEach
    void setUp() {

        tablero = Board.getInstance();

        Game juego = new Game();
        juego.start_game();

        white_pawn11 = new Pawn(1, 1, 1);
        white_pawn12 = new Pawn(1, 1, 2);


        black_pawn60 = new Pawn(-1, 6, 0);
        black_pawn12 = new Pawn(-1, 1, 2);


        square00= new Square(false,0,0);
        unoccupied_square20 = new Square(false, 2, 0);
        unoccupied_square21 = new Square(false, 2, 1);
        unoccupied_square50 = new Square(false, 5, 0);
        occupied_square22 = new Square(new Pawn(1,2,2),true);
        occupied_square22_diff = new Square(new Pawn(-1,2,2),true);
        occupied_square22_diag = new Square(new Pawn(-1,2,3),true);

        //Square o_square12 = new Square(new Pawn(1, 3, 7),true);

        real = new Square(false,2,8);
        realone = new Pawn(-1,1,8 );


    }



    @Test
    void testWhiteForwardMoveUnoccupied() {

        assertTrue(white_pawn11.move(unoccupied_square21 ,tablero ));
        assertEquals(white_pawn11.getColumn(), unoccupied_square21.getColumn());
        assertEquals(white_pawn11.getRow(), unoccupied_square21.getRow());
    }

    @Test
    void testWhiteForwardMoveOccupied() {

        assertFalse(white_pawn12.move(occupied_square22 ,tablero ));
        //pawn cannot eat in vertical, they need to move in diagonal
        assertFalse(white_pawn12.move(occupied_square22_diff ,tablero ));

    }


    @Test
    void testChecklegal() {

        assertFalse(realone.move(real, tablero));

    }




}
