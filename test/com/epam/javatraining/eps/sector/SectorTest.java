package com.epam.javatraining.eps.sector;

import org.junit.Test;
import static org.junit.Assert.*;

public class SectorTest {
    
    public SectorTest() {
    }

    @Test
    public void testGetWidth() {
        System.out.println("getWidth");
        Sector instance = new Sector(5, 10);
        int expResult = 5;
        int result = instance.getWidth();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        Sector instance = new Sector(5, 10);
        int expResult = 10;
        int result = instance.getHeight();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetCellState() {
        System.out.println("getCellState");
        Sector instance = new Sector(1, 2);
        instance.setCellState(0, 0, StateCell.BUSY);
        StateCell expResult = StateCell.BUSY;
        StateCell result = instance.getCellState(0, 0);
        assertEquals(expResult, result);
    }
    
}
