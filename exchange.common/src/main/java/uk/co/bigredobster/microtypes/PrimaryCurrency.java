package uk.co.bigredobster.microtypes;

import uk.co.bigredobster.microtypes.base.StringMicroType;

public class PrimaryCurrency extends StringMicroType<String> {
    public static final PrimaryCurrency EMPTY = new PrimaryCurrency(StringMicroType.EMPTY);

    public PrimaryCurrency(String value) {
        super(value);
    }
}
