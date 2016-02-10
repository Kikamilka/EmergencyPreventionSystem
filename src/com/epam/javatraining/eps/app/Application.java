package com.epam.javatraining.eps.app;

import com.epam.javatraining.eps.parser.Parser;
import com.epam.javatraining.eps.reporter.Reporter;
import com.epam.javatraining.eps.riskgroup.Range;
import com.epam.javatraining.eps.riskgroup.RiskGroup;
import com.epam.javatraining.eps.sector.Locator;
import com.epam.javatraining.eps.sector.Sector;
import com.epam.javatraining.eps.sector.SectorSource;
import com.epam.javatraining.eps.input.Parameters;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws CloneNotSupportedException {

        Parser parcer = new Parser();
        Parameters input = parcer.parse(args);

        SectorSource sectorSorse = new SectorSource(input.getFieldSize().getWidth(), input.getFieldSize().getHeight(), input.getFillFactor());
        Sector monitoringSector = sectorSorse.getSector();

        Locator locator = new Locator(getPosibleRiskGroups());
        Map<RiskGroup, Integer> situation = locator.fintCurSituation(monitoringSector);

        Reporter reporter = new Reporter();
        System.out.println(reporter.createReport(input.getFillFactor(), getPosibleRiskGroups(), monitoringSector, situation));
    }

    public static List<RiskGroup> getPosibleRiskGroups() {
        return Arrays.asList(new RiskGroup("NONE", new Range(1, 2)), new RiskGroup("MINOR", new Range(3, 4)),
                new RiskGroup("NORMAL", new Range(5, 7)), new RiskGroup("MAJOR", new Range(8, 13)),
                new RiskGroup("CRITICAL", new Range(14, Integer.MAX_VALUE)));
    }

}
