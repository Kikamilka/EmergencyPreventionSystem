package com.epam.javatraining.eps.parser;

import com.epam.javatraining.eps.input.Parameters;
import com.epam.javatraining.eps.utils.Size;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParserTest {
    
    public ParserTest() {
    }

    @Test
    public void testParse() {
        System.out.println("parse");
        String[] args = {"5", "10", "0.2"};
        Parser instance = new Parser();
        Parameters expResult = new Parameters(new Size(5, 10), 0.2);
        Parameters result = instance.parse(args);
        assertEquals(expResult.getFieldSize().getWidth(), result.getFieldSize().getWidth());
        assertEquals(expResult.getFieldSize().getHeight(), result.getFieldSize().getHeight());
        assertEquals(expResult.getFillFactor(), result.getFillFactor(), 0.0);
    }
    
}
