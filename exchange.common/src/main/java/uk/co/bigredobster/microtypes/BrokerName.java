package uk.co.bigredobster.microtypes;

import uk.co.bigredobster.microtypes.base.StringMicroType;

public class BrokerName extends StringMicroType<String> {
    public static final BrokerName EMPTY = new BrokerName("EmptyBrokerName");

    public BrokerName(String value) {
        super(value);
    }
}
