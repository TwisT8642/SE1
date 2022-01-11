//12008073 Andreas Marius Baisan
package at.aau.ue4.bsp1;


import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class BaseTest {

    private RingBuffer<Integer> ringBuffer = new RingBuffer(5);
    private Iterator ringBufferIterator = ringBuffer.iterator();

    @Test
    public void ifIsEmpty_ReturnTrue() {
        assertTrue(ringBuffer.isEmpty());
    }

    @Test
    public void ifNotEmpty_ReturnFalse() {
        ringBuffer.push(1);
        assertFalse(ringBuffer.isEmpty());
    }

    @Test
    public void ifRingBufferContainsNothing_thenReturn0() {
        assertEquals(0, ringBuffer.size());
    }

    @Test
    public void ifRingBufferContainsFiveElements_thenReturn5() {
        ringBuffer.push(0);
        ringBuffer.push(1);
        ringBuffer.push(2);
        ringBuffer.push(3);
        ringBuffer.push(4);
        assertEquals(5, ringBuffer.size());
    }

    @Test
    public void ifItemsArePushed_ThenReturnTheSizeCorrectly() {
        assertEquals(0, ringBuffer.size());
        ringBuffer.push(0);
        assertEquals(1, ringBuffer.size());
        ringBuffer.push(1);
        assertEquals(2, ringBuffer.size());
    }

    @Test
    public void ifCountEqualsBufferLength_ThenThrowRuntimeException() {
        ringBuffer.push(0);
        ringBuffer.push(1);
        ringBuffer.push(2);
        ringBuffer.push(3);
        ringBuffer.push(4);
        assertThrows(RuntimeException.class, () -> ringBuffer.push(5));
    }

    @Test
    public void ifItemsArePopped_ThenSizeIsSmaller() {
        ringBuffer.push(0);
        ringBuffer.push(1);
        ringBuffer.push(2);
        assertEquals(3, ringBuffer.size());
        ringBuffer.pop();
        assertEquals(2, ringBuffer.size());
        ringBuffer.pop();
        assertEquals(1, ringBuffer.size());
        ringBuffer.pop();
        assertEquals(0, ringBuffer.size());
    }

    @Test
    public void ifNoItemIsThereToBePopped_ThenThrowRuntimeException() {
        assertEquals(0, ringBuffer.size());
        assertThrows(RuntimeException.class, () -> ringBuffer.pop());
    }

    @Test
    public void ifItemIsPopped_ThenItShouldBeReturned() {
        ringBuffer.push(1);
        assertEquals(1, ringBuffer.size());
        Integer i = ringBuffer.pop();
        assertEquals(1, (int) i);
        assertEquals(0, ringBuffer.size());
    }

    //IteratorTest
    @Test
    public void ifiIsSmallerThencount_ThenReturnTrue() {
        ringBuffer.push(0);
        assertTrue(ringBufferIterator.hasNext());
    }

    @Test
    public void ifiIsTheSameAscount_ThenReturnFalse() {
        assertFalse(ringBufferIterator.hasNext());
    }

    @Test
    public void ifMethodremoveIsUsed_ThenThrowUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> ringBufferIterator.remove());
    }

    @Test
    public void ifMethodnextIsUsedAndiIsNotSmallerThencount_ThenThrowNoSuchElementException() {
        assertThrows(NoSuchElementException.class, () -> ringBufferIterator.next());
    }

    @Test
    public void ifMethodnextIsUsed_ThenReturnTheElementOntheRightPosition() {
        ringBuffer.push(0);
        ringBuffer.push(5);
        ringBuffer.push(10);
        assertEquals(0, ringBufferIterator.next());
        assertEquals(5, ringBufferIterator.next());
        assertEquals(10, ringBufferIterator.next());
    }
}
