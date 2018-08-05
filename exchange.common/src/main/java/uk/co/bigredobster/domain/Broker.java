package uk.co.bigredobster.domain;

import uk.co.bigredobster.microtypes.BrokerCode;
import uk.co.bigredobster.microtypes.BrokerName;

import java.util.Objects;

public class Broker {
    public final BrokerName brokerName;
    public final BrokerCode brokerCode;

    public Broker(final BrokerName brokerName, final BrokerCode brokerCode) {
        this.brokerName = brokerName;
        this.brokerCode = brokerCode;
    }

    public Broker(final Broker copy) {
        this.brokerCode = copy.brokerCode;
        this.brokerName = copy.brokerName;
    }

    @Override
    public String toString() {
        return "Broker{" +
                "brokerName=" + brokerName +
                ", brokerCode=" + brokerCode +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Broker broker = (Broker) o;
        return Objects.equals(brokerName, broker.brokerName) &&
                Objects.equals(brokerCode, broker.brokerCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brokerName, brokerCode);
    }
}
