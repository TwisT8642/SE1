package at.aau.ue5.bsp2;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static at.aau.ue5.bsp2.CashMachineState.*;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(Parameterized.class)
public class CashMachineParameterTest {

    private CashMachine cashMachine;

    private int input;
    private CashMachineState expected;

    @Before
    public void setup() {
        cashMachine = new CashMachine();
    }
    public CashMachineParameterTest(int input, CashMachineState expected){
        this.input = input;
        this.expected =expected;
    }

    @Parameterized.Parameters
    public static Collection moneyAmount(){
        return Arrays.asList(new Object [][] {
                {50, AMOUNT_VALID},
                {77, AMOUNT_NOT_VALID},
                {160,AMOUNT_VALID}
        });
    }

    @Test
    public void test(){
        System.out.println("Parameterized Number is: " +input);
        cashMachine.selectAmount(input);
        assertEquals(expected,cashMachine.getCurrentState());
    }


}
