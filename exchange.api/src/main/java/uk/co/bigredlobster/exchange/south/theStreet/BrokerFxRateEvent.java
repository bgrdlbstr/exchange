package uk.co.bigredlobster.exchange.south.theStreet;

import uk.co.bigredobster.domain.BrokerFxRate;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

public class BrokerFxRateEvent {
    private BrokerFxRate brokerFxRate;

    public BrokerFxRate getBrokerFxRate() {
        return new BrokerFxRate(brokerFxRate);
    }

    public void setBrokerFxRate(final BrokerFxRate brokerFxRate) {
        this.brokerFxRate = new BrokerFxRate(checkNotNull(brokerFxRate));
    }

    public void clear() {
        brokerFxRate = null;
    }

    @Override
    public String toString() {
        return "BrokerFxRateEvent{" +
                "brokerFxRate=" + brokerFxRate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrokerFxRateEvent that = (BrokerFxRateEvent) o;
        return Objects.equals(brokerFxRate, that.brokerFxRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brokerFxRate);
    }
}
