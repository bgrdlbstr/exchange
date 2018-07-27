package uk.co.bigredlobster.exchange.south.theStreet;

import uk.co.bigredobster.domain.FxRate;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

public class FxRateEvent {
    private FxRate fxRate;

    public FxRate getFxRate() {
        return new FxRate(fxRate);
    }

    public void setFxRate(final FxRate fxRate) {
        this.fxRate = new FxRate(checkNotNull(fxRate));
    }

    public void clear() {
        fxRate = null;
    }

    @Override
    public String toString() {
        return "FxRateEvent{" +
                "fxRate=" + fxRate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FxRateEvent that = (FxRateEvent) o;
        return Objects.equals(fxRate, that.fxRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fxRate);
    }
}
