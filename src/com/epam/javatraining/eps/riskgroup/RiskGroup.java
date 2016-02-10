package com.epam.javatraining.eps.riskgroup;

import java.util.Objects;

public class RiskGroup {

    private final String nameGroup;
    private final Range range;

    public RiskGroup(String nameGroup, Range range) {
        this.nameGroup = nameGroup;
        this.range = range;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public Range getRange() {
        return range;
    }
}
