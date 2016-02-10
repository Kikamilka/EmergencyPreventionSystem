package com.epam.javatraining.eps.reporter;

import com.epam.javatraining.eps.riskgroup.RiskGroup;
import com.epam.javatraining.eps.sector.StateCell;
import com.epam.javatraining.eps.sector.Sector;
import java.util.List;
import java.util.Map;

public class Reporter {

    public String createReport(double fillFactor, List<RiskGroup> riskGroup, Sector sector, Map<RiskGroup, Integer> situation) {
        StringBuilder resultReport = new StringBuilder();
        resultReport.append(getSeparatingLine());
        resultReport.append(getHeader());
        resultReport.append(getSeparatingLine());
        resultReport.append(getSizeSector(sector));
        resultReport.append(getFillFactor(fillFactor));
        resultReport.append(getPosibleRiskGroups(riskGroup));
        resultReport.append(getSeparatingLine());
        resultReport.append(getSectorView(sector));
        resultReport.append(getSituation(situation, riskGroup));
        return resultReport.toString();
    }

    private String getHeader() {
        return "EMERGENCY PREVENTION SYSTEM\n";
    }

    private String getSeparatingLine() {
        return "==================================================================\n";
    }

    private String getSizeSector(Sector sector) {
        return "Size: (" + sector.getWidth() + ", " + sector.getHeight() + ")\n";
    }

    private String getFillFactor(double fillFactor) {
        return "FILL_FACTOR = " + fillFactor + '\n';
    }

    private String getPosibleRiskGroups(List<RiskGroup> riskGroup) {
        StringBuilder result = new StringBuilder();
        result.append("Posible risk groups and its max count: \n");
        for (RiskGroup group : riskGroup) {
            result.append(group.getNameGroup()).append(" <= ").append(group.getRange().getMax());
            result.append("\n");
        }
        return result.toString();
    }

    private String getSectorView(Sector sector) {
        StringBuilder result = new StringBuilder();
        result.append(" ");
        for (int indexColumn = 0; indexColumn < sector.getWidth(); indexColumn++) {
            if (indexColumn < 10) {
                result.append("  ").append(indexColumn).append(" ");
            } else {
                result.append(" ").append(indexColumn).append(" ");
            }
        }
        result.append("\n");
        for (int indexRow = 0; indexRow < sector.getHeight(); indexRow++) {
            if (indexRow < 10) {
                result.append(indexRow).append(" ");
            } else {
                result.append(indexRow);
            }
            for (int indexColumn = 0; indexColumn < sector.getWidth(); indexColumn++) {
                StateCell valueCell = sector.getCellState(indexRow, indexColumn);
                result.append(getStateCell(valueCell)).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    private String getSituation(Map<RiskGroup, Integer> situation, List<RiskGroup> possibleRiskGroup) {
        StringBuilder result = new StringBuilder();
        result.append("\nRisk groups report: \n");
        result.append(getSeparatingLine());
        for (RiskGroup group : possibleRiskGroup) {
            for (Map.Entry<RiskGroup, Integer> entry : situation.entrySet()) {
                if (group.getNameGroup().equals(entry.getKey().getNameGroup())) {
                    result.append(entry.getKey().getNameGroup()).append(": ");
                    result.append(entry.getValue()).append(" groups;");
                    result.append("\n");
                }
            }
        }
        return result.toString();
    }

    private String getStateCell(StateCell valueCell) {
        return valueCell.indication;
    }

}
