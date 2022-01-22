package at.aau.ue5.bsp2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static at.aau.ue5.bsp2.CashMachineState.*;
import static org.junit.jupiter.api.Assertions.*;

public class CashMachineRandomTest {

    private CashMachine cashMachine;

    @BeforeEach
    private void setup (){
        cashMachine = new CashMachine();
    }

    @Test
    public void testRandom1_InsertCard_SelectAmount_InputPin_TakeCash_RemoveCard(){
        cashMachine.insertCard("5521");
        assertTrue(cashMachine.getCurrentState()==CARD_INSERTED);
        assertThrows(IllegalStateException.class, ()->cashMachine.selectAmount(50));
        cashMachine.inputPIN("0815");
        assertTrue(cashMachine.getCurrentState()==PIN_OK);
        assertThrows(IllegalStateException.class, ()->cashMachine.takeCash());
        assertThrows(IllegalStateException.class, ()->cashMachine.removeCard());
    }

    @Test
    public void testRandom2_SelectAmount_RemoveCard_InputPin_InsertCard_TakeCash(){
        assertThrows(IllegalStateException.class, ()->cashMachine.selectAmount(50));
        assertThrows(IllegalStateException.class, ()->cashMachine.removeCard());
        assertThrows(IllegalStateException.class, ()->cashMachine.inputPIN("0815"));
        cashMachine.insertCard("5521");
        assertTrue(cashMachine.getCurrentState()==CARD_INSERTED);
        assertThrows(IllegalStateException.class, ()->cashMachine.takeCash());
    }

    @Test
    public void testRandom3_TakeCash_RemoveCard_InsertCard_InputPin_SelectAmount(){
        assertThrows(IllegalStateException.class, ()->cashMachine.takeCash());
        assertThrows(IllegalStateException.class, ()->cashMachine.removeCard());
        cashMachine.insertCard("5521");
        assertTrue(cashMachine.getCurrentState()==CARD_INSERTED);
        cashMachine.inputPIN("0815");
        assertTrue(cashMachine.getCurrentState()==PIN_OK);
        cashMachine.selectAmount(50);
        assertTrue(cashMachine.getCurrentState()==AMOUNT_VALID);
    }

    @Test
    public void testRandom4_TakeCash_InputPin_SelectAmount_RemoveCard_InsertCard(){
        assertThrows(IllegalStateException.class, ()->cashMachine.takeCash());
        assertThrows(IllegalStateException.class, ()->cashMachine.inputPIN("0815"));
        assertThrows(IllegalStateException.class, ()->cashMachine.selectAmount(50));
        assertThrows(IllegalStateException.class, ()->cashMachine.removeCard());
        cashMachine.insertCard("5521");
        assertTrue(cashMachine.getCurrentState()==CARD_INSERTED);
    }

    @Test
    public void testRandom5_TakeCash_InsertCard_InputPin_RemoveCard_SelectAmount(){
        assertThrows(IllegalStateException.class, ()->cashMachine.takeCash());
        cashMachine.insertCard("5521");
        assertTrue(cashMachine.getCurrentState()==CARD_INSERTED);
        cashMachine.inputPIN("0815");
        assertTrue(cashMachine.getCurrentState()==PIN_OK);
        assertThrows(IllegalStateException.class, ()->cashMachine.removeCard());
        cashMachine.selectAmount(50);
        assertTrue(cashMachine.getCurrentState()==AMOUNT_VALID);
    }
}
