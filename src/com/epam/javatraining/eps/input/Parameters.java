package com.epam.javatraining.eps.input;

import com.epam.javatraining.eps.utils.Size;

public class Parameters {
    
    private Size fieldSize;
    private double fillFactor;
    
    public Parameters() {

    }

    public Parameters(Size fieldSize, double fillFactor) {
        this.fieldSize = fieldSize;
        this.fillFactor = fillFactor;
    }

    public Size getFieldSize() {
        return fieldSize;
    }

    public void setFieldSize(Size fieldSize) {
        this.fieldSize = fieldSize;
    }

    public double getFillFactor() {
        return fillFactor;
    }

    public void setFillFactor(double fillFactor) {
        this.fillFactor = fillFactor;
    }
    
}
