package com.epam.javatraining.eps.utils;

import org.junit.Test;
import static org.junit.Assert.*;

public class SizeTest {
    
    public SizeTest() {
    }

    @Test
    public void testGetWidth() {
        System.out.println("getWidth");
        Size instance = new Size(10, 20);
        int result = instance.getWidth();
        assertEquals(10, result);
    }

    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        Size instance = new Size(10, 20);
        int result = instance.getHeight();
        assertEquals(20, result);
    }
    
}
