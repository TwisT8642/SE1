import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EinstiegsbeispielTest {

    public int[] f = {3, 5, 7};
    public int[] g = {2, 4, 6};
    public int[] l = {1, 2, 3, 4};
    public int[] h = {2, -4, 6};
    public int[] k = {};


    //2 Normalfälle
    @Test
    public void whenScalarProductIsCalculatedCorrectly_ThenReturnsTheCorrectNumber() {
        Einstiegsbeispiel tester = new Einstiegsbeispiel(f, g);
        assertEquals(68, tester.getInnerProduct());
    }

    @Test
    public void whenScalarProductWithNegativeNumbersIsCorrect_ThenReturnsTheCorrectNumber() {
        Einstiegsbeispiel tester = new Einstiegsbeispiel(f, h);
        assertEquals(28, tester.getInnerProduct());
    }
    //2 Fehlerfälle
    @Test
    public void whenArrayLengthIsDifferent_ThenThrowsIllegalArgumentException() {
        assertThrows(Exception.class, () -> new Einstiegsbeispiel(f, l));
    }

    @Test
    public void whenBothArraysAreEmpty_ThenThrowIllegalArgumentException() {
        assertThrows(Exception.class, () -> new Einstiegsbeispiel(k,k));
    }
}



