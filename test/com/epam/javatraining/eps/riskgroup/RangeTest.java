package com.epam.javatraining.eps.riskgroup;

import org.junit.Test;
import static org.junit.Assert.*;

public class RangeTest {
    
    public RangeTest() {
    }

    @Test
    public void testGetMinEmptyConstructor() {
        System.out.println("getMin");
        Range instance = new Range();
        int expResult = 0;
        int result = instance.getMin();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetMaxEmptyConstructor() {
        System.out.println("getMax");
        Range instance = new Range();
        int expResult = 0;
        int result = instance.getMax();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetMin() {
        System.out.println("getMin");
        Range instance = new Range(10, 2);
        int expResult = 2;
        int result = instance.getMin();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetMax() {
        System.out.println("getMax");
        Range instance = new Range(10, 200);
        int expResult = 200;
        int result = instance.getMax();
        assertEquals(expResult, result);
    }

    @Test
    public void testInRange() {
        System.out.println("inRange");
        Range range = new Range();        
        assertEquals(true, range.inRange(0));
        
        range = new Range(2, 10);
        assertEquals(true, range.inRange(2));
        
        range = new Range(5, 10);
        assertEquals(false, range.inRange(2));
    }
    
}
