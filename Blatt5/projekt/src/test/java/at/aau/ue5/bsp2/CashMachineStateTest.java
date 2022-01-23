//12008073_AndreasMariusBaisan
package at.aau.ue5.bsp2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static at.aau.ue5.bsp2.CashMachineState.*;
import static org.junit.jupiter.api.Assertions.*;

public class CashMachineStateTest {

    private CashMachine cashMachine;

    @BeforeEach
    private void setup(){
        cashMachine = new CashMachine();
    }

    @Test
    public void ifThePathGoesAsIntended_ThenWorkAsIntended(){
        cashMachine.insertCard("5521");
        assertTrue(cashMachine.getCurrentState()==CARD_INSERTED);
        cashMachine.inputPIN("0815");
        assertTrue(cashMachine.getCurrentState()==PIN_OK);
        cashMachine.selectAmount(50);
        assertTrue(cashMachine.getCurrentState()==AMOUNT_VALID);
        cashMachine.takeCash();
        assertTrue(cashMachine.getCurrentState()==CASH_GIVEN);
        cashMachine.removeCard();
        assertTrue(cashMachine.getCurrentState()==CARD_TAKEN);
    }

    @Test
    public void ifCardNumberIsWrong_ThenRetainCard(){
        cashMachine.insertCard("1200");
        assertTrue(cashMachine.getCurrentState()==CARD_RETAINED);
    }

    @Test
    public void ifPinIsWrongTooManyTimes_ThenRetainCard(){
        cashMachine.insertCard("1212");
        cashMachine.inputPIN("31234");
        assertTrue(cashMachine.getCurrentState() == PIN_NOT_OK);
        cashMachine.inputPIN("658");
        assertTrue(cashMachine.getCurrentState() == PIN_NOT_OK);
        cashMachine.inputPIN("1");
        assertTrue(cashMachine.getCurrentState() == PIN_NOT_OK);
        cashMachine.inputPIN("2345");
        assertTrue(cashMachine.getCurrentState() == PIN_NOT_OK);
        cashMachine.inputPIN("1");
        assertTrue(cashMachine.getCurrentState() == CARD_RETAINED);
    }

    @Test
    public void ifPinIsWrongButNotTooManyTimes_ThenWorkAsIntended() {
        cashMachine.insertCard("1212");
        cashMachine.inputPIN("31234");
        assertTrue(cashMachine.getCurrentState() == PIN_NOT_OK);
        cashMachine.inputPIN("658");
        assertTrue(cashMachine.getCurrentState() == PIN_NOT_OK);
        cashMachine.inputPIN("1");
        assertTrue(cashMachine.getCurrentState() == PIN_NOT_OK);
        cashMachine.inputPIN("0815");
        assertTrue(cashMachine.getCurrentState() == PIN_OK);
        cashMachine.selectAmount(50);
        assertTrue(cashMachine.getCurrentState() == AMOUNT_VALID);
        cashMachine.takeCash();
        assertTrue(cashMachine.getCurrentState() == CASH_GIVEN);
        cashMachine.removeCard();
        assertTrue(cashMachine.getCurrentState() == CARD_TAKEN);
    }

    @Test
    public void ifAmountIsWrongAndThenRight_WorkAsIntended(){
        cashMachine.insertCard("5521");
        assertTrue(cashMachine.getCurrentState()==CARD_INSERTED);
        cashMachine.inputPIN("0815");
        assertTrue(cashMachine.getCurrentState()==PIN_OK);
        cashMachine.selectAmount(177);
        assertTrue(cashMachine.getCurrentState()==AMOUNT_NOT_VALID);
        cashMachine.selectAmount(7895);
        assertTrue(cashMachine.getCurrentState()==AMOUNT_NOT_VALID);
        cashMachine.selectAmount(50);
        assertTrue(cashMachine.getCurrentState()==AMOUNT_VALID);
        cashMachine.takeCash();
        assertTrue(cashMachine.getCurrentState()==CASH_GIVEN);
        cashMachine.removeCard();
        assertTrue(cashMachine.getCurrentState()==CARD_TAKEN);
    }



}
