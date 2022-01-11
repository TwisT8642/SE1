//12008073 Andreas Marius Baisan
package at.aau.ue4.bsp3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class McCabeTest {
    @Test
    public void ifZahl1Is50AndZahl2Is0_ThenReturn50() {
        assertEquals(50, McCabe.ggt(50,0));
    }
    @Test
    public void ifZahl1Is39AndZahl2Is3_ThenReturn1(){
        assertEquals(3, McCabe.ggt(39,3));
    }
    @Test
    public void ifZahl1Is15AndZahl2Is45_ThenReturn1(){
        assertEquals(15, McCabe.ggt(15,45));
    }
}
