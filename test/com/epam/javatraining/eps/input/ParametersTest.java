/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.javatraining.eps.input;

import com.epam.javatraining.eps.utils.Size;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kamila
 */
public class ParametersTest {
    
    public ParametersTest() {
    }

    @Test
    public void testGetFieldSize() {
        System.out.println("getFieldSize");
        Parameters instance = new Parameters(new Size(5, 6), 0.56);
        Size expResult = new Size(5, 6);
        Size result = instance.getFieldSize();
        assertEquals(expResult.getHeight(), result.getHeight());
        assertEquals(expResult.getWidth(), result.getWidth());
    }

    @Test
    public void testSetFieldSize() {
        System.out.println("setFieldSize");
        Size fieldSize = new Size (10, 20);
        Parameters instance = new Parameters(new Size(5,6), 0.56);
        instance.setFieldSize(fieldSize);
        assertEquals(fieldSize, instance.getFieldSize());
    }

    @Test
    public void testGetFillFactor() {
        System.out.println("getFillFactor");
        Parameters instance = new Parameters(new Size(5,6), 0.56);
        double expResult = 0.56;
        double result = instance.getFillFactor();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testSetFillFactor() {
        System.out.println("setFillFactor");
        double fillFactor = 0.2;
        Parameters instance = new Parameters(new Size(5,6), 0.56);
        instance.setFillFactor(fillFactor);
        assertEquals(fillFactor, instance.getFillFactor(), 0.0);
    }
}
