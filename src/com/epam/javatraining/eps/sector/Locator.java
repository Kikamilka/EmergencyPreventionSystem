package com.epam.javatraining.eps.sector;

import com.epam.javatraining.eps.riskgroup.RiskGroup;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Locator {

    private final List<RiskGroup> riskGroup;
    private int[][] indexesClusters;
    private Sector monitoringSector;

    public Locator(List<RiskGroup> riskGroup) {
        this.riskGroup = riskGroup;
    }

    public Map<RiskGroup, Integer> fintCurSituation(Sector monitoringSector) throws CloneNotSupportedException {
        this.monitoringSector = (Sector) monitoringSector.clone();
        this.indexesClusters = new int[monitoringSector.getHeight()][monitoringSector.getWidth()];
        int curCluster = 1;
        for (int indexRow = 0; indexRow < monitoringSector.getHeight(); indexRow++) {
            for (int indexColumn = 0; indexColumn < monitoringSector.getWidth(); indexColumn++) {
                if (StateCell.BUSY.equals(monitoringSector.getCellState(indexRow, indexColumn))
                        && indexesClusters[indexRow][indexColumn] == 0) {
                    findCluster(indexRow, indexColumn, curCluster);
                    curCluster++;
                }
            }
        }
        Map<RiskGroup, Integer> curSituation = countElementsGroup(curCluster);
        return curSituation;
    }

    private Map<RiskGroup, Integer> countElementsGroup(int countGroups) {
        Map<RiskGroup, Integer> curSituation = new HashMap<>();
        for (RiskGroup group : riskGroup) {
            curSituation.put(group, 0);
        }
        int sizeGroup = 0;

        for (int indexCluster = 1; indexCluster < countGroups; indexCluster++) {
            for (int indexRow = 0; indexRow < monitoringSector.getHeight(); indexRow++) {
                for (int indexColumn = 0; indexColumn < monitoringSector.getWidth(); indexColumn++) {
                    if (indexesClusters[indexRow][indexColumn] == indexCluster) {
                        sizeGroup++;
                    }
                }
            }
            RiskGroup curDegreeRisk = defineDegreeRisk(sizeGroup);
            curSituation.put(curDegreeRisk, curSituation.get(curDegreeRisk) + 1);
            sizeGroup = 0;
        }
        return curSituation;
    }

    public RiskGroup defineDegreeRisk(int countCluster) {
        RiskGroup degree = null;
        for (RiskGroup group : riskGroup) {
            if (group.getRange().inRange(countCluster)) {
                degree = group;
            }
        }
        return degree;
    }

    private void findCluster(int indexRow, int indexColumn, int curCluster) {
        indexesClusters[indexRow][indexColumn] = curCluster;
        if (indexColumn + 1 != monitoringSector.getWidth()) {
            checkNeighbourCell(indexRow, indexColumn + 1, curCluster);
        }
        if (indexColumn != 0) {
            checkNeighbourCell(indexRow, indexColumn - 1, curCluster);
        }
        if (indexRow + 1 != monitoringSector.getHeight()) {
            checkNeighbourCell(indexRow + 1, indexColumn, curCluster);
        }
        if (indexRow != 0) {
            checkNeighbourCell(indexRow - 1, indexColumn, curCluster);
        }
    }

    private void checkNeighbourCell(int newPositionRow, int newPositionColumn, int curCluster) {
        if ((StateCell.BUSY.equals(monitoringSector.getCellState(newPositionRow, newPositionColumn)))
                && (indexesClusters[newPositionRow][newPositionColumn] == 0)) {
            findCluster(newPositionRow, newPositionColumn, curCluster);
        }
    }

}
