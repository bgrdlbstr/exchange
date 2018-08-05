package uk.co.bigredobster.microtypes;

import uk.co.bigredobster.microtypes.base.StringMicroType;

public class BrokerCode extends StringMicroType<String> {
    public static final BrokerCode EMPTY = new BrokerCode("EmptyBrokerCode");

    public BrokerCode(String value) {
        super(value);
    }
}
