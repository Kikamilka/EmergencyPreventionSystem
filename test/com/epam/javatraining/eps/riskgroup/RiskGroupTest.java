/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.javatraining.eps.riskgroup;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kamila
 */
public class RiskGroupTest {
    
    public RiskGroupTest() {
    }

    @Test
    public void testGetNameGroup() {
        System.out.println("getNameGroup");
        RiskGroup group = new RiskGroup("NORMAL", new Range(1, 5));
        String expResult = "NORMAL";
        String result = group.getNameGroup();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetRange() {
        System.out.println("getRange");
        RiskGroup group = new RiskGroup("NORMAL", new Range(1, 5));
        Range expResult = new Range(1, 5);
        Range result = group.getRange();
        assertEquals(expResult.getMax(), result.getMax());
        assertEquals(expResult.getMin(), result.getMin());
    }
}
