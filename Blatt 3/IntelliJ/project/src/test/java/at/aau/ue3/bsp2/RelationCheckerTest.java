package at.aau.ue3.bsp2;

import org.junit.Assert;
import org.junit.Test;

public class RelationCheckerTest {
    @Test
    public void ifXAndYIsZero_thenReturnZero(){
        Assert.assertEquals(0, RelationChecker.checkRelation(0,0));
    }

    @Test
    public void ifXIsEightAndYIsSeventeen_thenReturnThirtyfour() {
        Assert.assertEquals(34, RelationChecker.checkRelation(8, 17));

    }
        @Test
        public void ifXIsThreeAndYIsSeven_thenReturnEight(){
            Assert.assertEquals(8, RelationChecker.checkRelation(3,7));
        }

        @Test
        public void ifXIsFifteenAndYIsTen_thenReturnTwentyfive(){
            Assert.assertEquals(25, RelationChecker.checkRelation(15,10));
        }

}
