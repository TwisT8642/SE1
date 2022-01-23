//12008073_AndreasMariusBaisan
package at.aau.ue5.bsp2;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static at.aau.ue5.bsp2.CashMachineState.*;
import static org.junit.jupiter.api.Assertions.*;


public class CashMachineParameterTest {

    private CashMachine cashMachine;

    @BeforeEach
    private void setup (){
        cashMachine = new CashMachine();
    }

    @ParameterizedTest
    @ValueSource(strings = {"265489","516868","897521","241965","648423","894232"})
    public void ifRightCardIsInserted_ThenChangeCurrentStateToCardInserted(String number){
        cashMachine.insertCard(number);
        assertTrue(cashMachine.getCurrentState()== CARD_INSERTED);
    }

    @ParameterizedTest
    @ValueSource(strings = {"265400","516800","897500","241900","648400","894200"})
    public void ifWrongCardIsInserted_ThenChangeCurrentStateToCardRetained (String number){
        cashMachine.insertCard(number);
        assertTrue(cashMachine.getCurrentState()==CARD_RETAINED);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2600","51800","897500","2471900","64835400","892154200"})
    public void ifPinNumberIsWrong_ThenChangeCurrentStateToPinNotOk (String number){
        cashMachine.insertCard("123412");
        cashMachine.inputPIN(number);
        assertTrue(cashMachine.getCurrentState()==PIN_NOT_OK);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0815"})
    public void ifCurrentStateIsWrongForInsertCard_ThenThrowIllegalStateException (String number){
        cashMachine.insertCard("123412");
        cashMachine.inputPIN(number);
        assertThrows(IllegalStateException.class, ()-> cashMachine.insertCard(number));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0815"})
    public void ifPinNumberIsRight_ThenChangeCurrentStateToPinOk (String number) {
        cashMachine.insertCard("123412");
        cashMachine.inputPIN(number);
        assertTrue(cashMachine.getCurrentState() == PIN_OK);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0815"})
    public void ifPinNumberIsWrongLessThanFiveTimesAndThenTheRightPinIsInserted_ThenChangeCurrentStateToPinOk (String number){
        cashMachine.insertCard("123412");
        cashMachine.inputPIN("31234");
        assertTrue(cashMachine.getCurrentState()==PIN_NOT_OK);
        cashMachine.inputPIN("658");
        assertTrue(cashMachine.getCurrentState()==PIN_NOT_OK);
        cashMachine.inputPIN("1");
        assertTrue(cashMachine.getCurrentState()==PIN_NOT_OK);
        cashMachine.inputPIN(number);
        assertTrue(cashMachine.getCurrentState()==PIN_OK);
    }
    @ParameterizedTest
    @ValueSource(strings = {"0815"})
    public void ifPinIsWrongTooManyTimes_ThenChangeCurrentStateToCardRetained (String number){
            cashMachine.insertCard("123412");
            cashMachine.inputPIN("31234");
            assertTrue(cashMachine.getCurrentState() == PIN_NOT_OK);
            cashMachine.inputPIN("658");
            assertTrue(cashMachine.getCurrentState() == PIN_NOT_OK);
            cashMachine.inputPIN("1");
            assertTrue(cashMachine.getCurrentState() == PIN_NOT_OK);
            cashMachine.inputPIN("2345");
            assertTrue(cashMachine.getCurrentState() == PIN_NOT_OK);
            cashMachine.inputPIN(number);
            assertTrue(cashMachine.getCurrentState() == CARD_RETAINED);
        }

    @ParameterizedTest
    @ValueSource(strings = {"0815"})
    public void ifInputPinIsUsedInWrongState_ThenThrowIllegalStateException (String number) {
        assertThrows(IllegalStateException.class, ()-> cashMachine.inputPIN(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {160,50,100,10,60,150})
    public void ifRightAmountIsInserted_ThenChangeCurrentStateToAmountValid (int number) {
        cashMachine.insertCard("123412");
        cashMachine.inputPIN("0815");
        cashMachine.selectAmount(number);
        assertTrue(cashMachine.getCurrentState()==AMOUNT_VALID);
    }

    @ParameterizedTest
    @ValueSource(ints = {777,78,12,363,4545,2365})
    public void ifAmountIsWrong_ThenChangeCurrentStateToAmountNotValid (int number) {
        cashMachine.insertCard("123412");
        cashMachine.inputPIN("0815");
        cashMachine.selectAmount(number);
        assertTrue(cashMachine.getCurrentState()==AMOUNT_NOT_VALID);
    }

    @ParameterizedTest
    @ValueSource(ints = {777,78,12,363,4545,2365})
    public void ifSelectAmountIsUsedInWrongState_ThenThrowIllegalStateException (int number) {
        assertThrows(IllegalStateException.class, ()-> cashMachine.selectAmount(number));
    }

    @Test
    public void ifTakeCashIsUsedAndTheCurrentStateIsCorrect_ThenChangeCurrentStateToCashGiven () {
        cashMachine.insertCard("123412");
        cashMachine.inputPIN("0815");
        cashMachine.selectAmount(160);
        cashMachine.takeCash();
        assertTrue(cashMachine.getCurrentState() == CASH_GIVEN);
    }

    @Test
    public void ifTakeCashIsUsedInWrongState_ThenThrowIllegalStateException () {
        assertThrows(IllegalStateException.class, () -> cashMachine.takeCash());
    }

    @Test
    public void ifRemoveCardIsUsedAndTheStateIsCorrect_ThenChangeCurrentStateToCardTaken () {
        cashMachine.insertCard("123412");
        cashMachine.inputPIN("0815");
        cashMachine.selectAmount(160);
        cashMachine.takeCash();
        cashMachine.removeCard();
        assertTrue(cashMachine.getCurrentState() == CARD_TAKEN);
    }

    @Test
    public void ifRemoveCardIsUsedInWrongState_ThenThrowIllegalStateException () {
        assertThrows(IllegalStateException.class, () -> cashMachine.removeCard());
    }


}