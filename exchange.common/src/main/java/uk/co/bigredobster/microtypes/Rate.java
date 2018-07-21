package uk.co.bigredobster.microtypes;

import uk.co.bigredobster.microtypes.base.BigDecimalMicroType;

import java.math.BigDecimal;

public class Rate extends BigDecimalMicroType<BigDecimal> {
    public Rate(BigDecimal value) {
        super(value);
    }

    public Rate(String value) {
        this(new BigDecimal(value));
    }
}
