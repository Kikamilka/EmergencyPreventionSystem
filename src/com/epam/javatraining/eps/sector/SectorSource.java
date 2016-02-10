package com.epam.javatraining.eps.sector;

import java.util.Random;

public class SectorSource {
    
    private final int width;
    private final int height;
    private final double fillFactor;
    private final Random randomValue;

    public SectorSource(int width, int height, double fillFactor) {
        this.randomValue = new Random();
        this.width = width;
        this.height = height;
        this.fillFactor = fillFactor;
    }
    
    public Sector getSector (){
        Sector monitoringSector = new Sector(width, height);
        fillSector(monitoringSector);
        return monitoringSector;
    }

    private void fillSector(Sector monitoringSector) {
        for (int indexRow = 0; indexRow < height; indexRow++) {
            for (int indexColumn = 0; indexColumn < width; indexColumn++) {
                randomFillCell(monitoringSector, indexRow, indexColumn);
            }
        }
    }

    private void randomFillCell(Sector monitoringSector, int indexRow, int indexColumn) {
        if (randomValue.nextDouble() <= fillFactor) {
            monitoringSector.setCellState(indexRow, indexColumn, StateCell.BUSY);
        } else {
            monitoringSector.setCellState(indexRow, indexColumn, StateCell.EASY);
        }
    }
    
}
