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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final RiskGroup rickGroup = (RiskGroup) obj;

        if (this.nameGroup != null ? !this.nameGroup.equals(rickGroup.nameGroup) : rickGroup.nameGroup != null) {
            return false;
        }
        return !(range != null ? !range.equals(rickGroup.range) : rickGroup.range != null);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.nameGroup);
        hash = 71 * hash + Objects.hashCode(this.range);
        return hash;
    }

}
