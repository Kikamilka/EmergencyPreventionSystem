package com.epam.javatraining.eps.sector;

import com.epam.javatraining.eps.riskgroup.Range;
import com.epam.javatraining.eps.riskgroup.RiskGroup;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class LocatorTest {

    List<RiskGroup> possibleGroups;
    Map<RiskGroup, Integer> groups;

    public LocatorTest() {
    }

    @Before
    public void initialization() throws Exception {
        Sector monitoringSector = new Sector(3, 2);
        monitoringSector.setCellState(0, 0, StateCell.BUSY);
        monitoringSector.setCellState(0, 1, StateCell.BUSY);
        monitoringSector.setCellState(1, 0, StateCell.EASY);
        monitoringSector.setCellState(1, 1, StateCell.EASY);
        monitoringSector.setCellState(0, 2, StateCell.EASY);
        monitoringSector.setCellState(1, 2, StateCell.BUSY);
        possibleGroups = Arrays.asList(new RiskGroup("NONE", new Range(1, 2)), new RiskGroup("MINOR", new Range(3, 4)));
        Locator locator = new Locator(possibleGroups);
        groups = locator.fintCurSituation(monitoringSector);
    }

    @Test
    public void testFintCurSituationNoneGroup() throws Exception {
        assertEquals(Integer.valueOf(2), groups.get(possibleGroups.get(0)));
    }
    
    @Test
    public void testFintCurSituationMinorGroup() throws Exception {
        assertEquals(Integer.valueOf(0), groups.get(possibleGroups.get(1)));
    }

    @Test
    public void testDefineDegreeRisk() {
        System.out.println("defineDegreeRisk");
        Locator locator = new Locator(possibleGroups);
        RiskGroup result = locator.defineDegreeRisk(2);
        assertEquals("NONE", result.getNameGroup());
        assertEquals(2, result.getRange().getMax());
        assertEquals(1, result.getRange().getMin());
    }

}
