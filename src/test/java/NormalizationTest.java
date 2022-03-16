import Utilities.Normalization;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NormalizationTest {
    Normalization nor;


    @BeforeEach
    void setUp(){
        nor = new Normalization();

    }

    @Test
    void testValues(){
        nor = new Normalization();
        for(int i = 0; i<100; i++){
            double coefficient = Math.random()*12;
            double score = Math.random()*12;
            double result = Normalization.normalizeScore(coefficient,score);
            assertTrue( result >= 0 && result <= 1 );
            assertFalse(result > 1);

        }
    }
}
