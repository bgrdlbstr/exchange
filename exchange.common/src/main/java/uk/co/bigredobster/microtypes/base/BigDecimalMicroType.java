package uk.co.bigredobster.microtypes.base;

import java.math.BigDecimal;

public abstract class BigDecimalMicroType<T extends BigDecimal> extends MicroType<T> {
    public static final BigDecimal EMPTY = new BigDecimal(Long.MIN_VALUE);

    public BigDecimalMicroType(T value) {
        super(value);
    }

    @Override
    public String toString() {
        return "BigDecimalMicroType{" +
                "value=" + value.toPlainString() +
                '}';
    }
}
