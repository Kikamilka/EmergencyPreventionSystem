package com.epam.javatraining.eps.sector;

public enum StateCell {

    BUSY("|X|"),
    EASY(" - ");
    public final String indication;

    private StateCell(String indication) {
        this.indication = indication;
    }

    private StateCell() {
        this.indication = null;
    }

    @Override
    public String toString() {
        return "StateCell{" + "indication=" + indication + '}';
    }

}
