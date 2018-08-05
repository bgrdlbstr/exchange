package uk.co.bigredobster.domain;

import java.util.Objects;

public class BrokerFxRate {
    public final Broker broker;
    public final FxRate fxRate;

    public BrokerFxRate(final Broker broker, final FxRate fxRate) {
        this.broker = broker;
        this.fxRate = fxRate;
    }

    public BrokerFxRate(final BrokerFxRate copy) {
        this.broker = new Broker(copy.broker);
        this.fxRate = new FxRate(copy.fxRate);
    }

    @Override
    public String toString() {
        return "BrokerFxRate{" +
                "broker=" + broker +
                ", fxRate=" + fxRate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrokerFxRate that = (BrokerFxRate) o;
        return Objects.equals(broker, that.broker) &&
                Objects.equals(fxRate, that.fxRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(broker, fxRate);
    }
}
