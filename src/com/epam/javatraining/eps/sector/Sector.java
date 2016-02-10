package com.epam.javatraining.eps.sector;

public class Sector {

    private StateCell[][] data;

    public Sector(int width, int height) {
        if ((width <= 0) || (height <= 0)) {
            throw new IllegalArgumentException();
        }
        this.data = new StateCell[height][width];
    }

    public StateCell[][] getStateCells() {
        return data;
    }

    public int getWidth() {
        return data[0].length;
    }

    public int getHeight() {
        return data.length;
    }

    public StateCell getCellState(int indexRow, int indexCollumn) {
        checkPosition(indexRow, indexCollumn);
        return data[indexRow][indexCollumn];
    }

    public void setCellState(int indexRow, int indexCollumn, StateCell state) {
        data[indexRow][indexCollumn] = state;
    }

    private void checkPosition(int indexRow, int indexCollumn) {
        if (indexRow < 0 || indexRow >= getHeight() || indexCollumn < 0 || indexCollumn >= getWidth()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //Sector cloneSector = super.clone();
        Sector cloneSector = new Sector(this.getWidth(), this.getHeight());
        cloneSector.data = new StateCell[this.getHeight()][this.getWidth()];
        for (int row = 0; row < this.getHeight(); row++) {
            for (int collumn = 0; collumn < this.getWidth(); collumn++) {
                cloneSector.setCellState(row, collumn, this.getCellState(row, collumn));
            }
        }
        return cloneSector;
    }
    
    

}
