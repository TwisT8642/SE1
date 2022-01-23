package at.aau.ue5.bsp5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyMathTestRefactored {

    private double x;
    private double y;
    private MyMath mm;
    private Fraction f;


    @BeforeEach
    public void setup (){
        mm = new MyMath();
        x = 10d;
        y = 5d;
        f = new Fraction();
    }

    //x1
    @Test
    public void ifXIs10PlusY5_ThenReturn15(){
        assertEquals(15d,(double) mm.add(x,y));
    }

    @Test
    public void ifXIs10MinusY5_ThenReturn5(){
        assertEquals(5d,(double) mm.sub(x,y));
    }

    @Test
    public void ifXIs10MultipliedByY5_ThenReturn50(){
        assertEquals(50d,(double) mm.mul(x,y));
    }

    @Test
    public void ifXIs10DividedByY5_ThenReturn2(){
        assertEquals(2d,(double) mm.div(x,y));
    }

    //x2
    @Test
    public void ifNumeratorIs1AndDenumeratorIs1Reduce_ThenReturn1And1(){
        f = new Fraction(1,1);
        assertEquals(new Fraction(1,1),mm.reduce(f));
    }

    @Test
    public void ifNumeratorIs10AndDenumeratorIs6Reduce_ThenReturn5And3(){
        f = new Fraction(10,6);
        assertEquals(new Fraction(5,3),mm.reduce(f));
    }

    @Test
    public void ifNumeratorIs10AndDenumeratorIs5Reduce_ThenReturn2And1(){
        f = new Fraction(10,5);
        assertEquals(new Fraction(2,1),mm.reduce(f));
    }

    @Test
    public void ifNumeratorIs10AndDenumeratorIs5ToDouble_ThenReturn2(){
        f = new Fraction(10,5);
        assertEquals(2d,(double) mm.toDouble(f));
    }

    @Test
    public void ifNumeratorIs10AndDenumeratorIs4ToDouble_ThenReturn2_5(){
        f = new Fraction(10,4);
        assertEquals(2.5d,(double) mm.toDouble(f));
    }


}
