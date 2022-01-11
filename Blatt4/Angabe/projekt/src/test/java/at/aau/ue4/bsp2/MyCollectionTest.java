package at.aau.ue4.bsp2;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


public class MyCollectionTest
{
    private MyCollection c;

    @BeforeEach
    public void setup() {
        c = new MyCollection(5);
        c.add("1");
        c.add("2");
        c.add("3");
    }
    @Test
    public void testSizeSimple() {
        assertEquals(3,c.size());
    }

    @Test
    public void ifOneElementIsRemoved_ThenTheListShouldContainLessElements(){
        assertEquals(3,c.size());
        c.remove("3");
        assertEquals(2,c.size());
    }
    @Test
    public void ifAElementIsRemovedWhichIsNotContained_ThenThrowIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, ()->c.remove("4"));
    }

    @Test
    public void ifListIsEmptyAndAObjectIsRemoved_ThenThrowIllegalArgumentException(){
        assertEquals(3,c.size());
        c.remove("1");
        c.remove("2");
        c.remove("3");
        assertThrows(IllegalArgumentException.class, ()->c.remove("1"));
    }

    @Test
    public void ifListgetsEmptied_ThenListShouldBeEmpty(){
        assertEquals(3,c.size());
        c.empty();
        assertEquals(0,c.size());
    }




}
