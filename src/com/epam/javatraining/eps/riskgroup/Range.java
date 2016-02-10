package com.epam.javatraining.eps.riskgroup;

public class Range {

    private final int min;
    private final int max;

    public Range() {
        this.min = 0;
        this.max = 0;
    }

    public Range(int min, int max) {
        if (min < 0 || max < 0) {
            throw new IllegalArgumentException();
        }
        if (min <= max) {
            this.min = min;
            this.max = max;
        } else {
            this.min = max;
            this.max = min;
        }
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public boolean inRange(int value) {
        return value >= min && value <= max;
    }
}
