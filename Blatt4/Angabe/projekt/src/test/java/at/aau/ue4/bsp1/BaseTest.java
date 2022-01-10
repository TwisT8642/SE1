package at.aau.ue4.bsp1;


import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class BaseTest {

    private RingBuffer<Integer> ringBuffer = new RingBuffer(5);
    private Iterator ringBufferIterator = ringBuffer.iterator();

    @Test
    public void ifIsEmpty_ReturnTrue(){
        assertTrue(ringBuffer.isEmpty());
    }
    @Test
    public void ifRingBufferCapacityIs0_thenReturn0(){
        assertEquals(0, ringBuffer.size());
    }
    @Test
    public void ifOneItemIsPushed_ThenReturnSize1(){
        ringBuffer.push(0);
        assertEquals(1, ringBuffer.size());

    }

}
