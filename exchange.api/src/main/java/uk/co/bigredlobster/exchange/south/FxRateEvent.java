package uk.co.bigredlobster.exchange.south;

import uk.co.bigredobster.domain.FxRate;

import static com.google.common.base.Preconditions.checkNotNull;

public class FxRateEvent {
    private FxRate fxRate;

    public void setFxRate(final FxRate fxRate) {
        this.fxRate = checkNotNull(fxRate);
    }

    public void clear() {
        fxRate = null;
    }
}
