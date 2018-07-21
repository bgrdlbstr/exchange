package uk.co.bigredobster.microtypes;

import uk.co.bigredobster.microtypes.base.StringMicroType;

public class SecondaryCurrency extends StringMicroType<String> {
    public static final SecondaryCurrency EMPTY = new SecondaryCurrency(StringMicroType.EMPTY);

    public SecondaryCurrency(String value) {
        super(value);
    }
}
