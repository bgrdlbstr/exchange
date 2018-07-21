package uk.co.bigredobster.domain;

import uk.co.bigredobster.microtypes.PrimaryCurrency;
import uk.co.bigredobster.microtypes.SecondaryCurrency;

import static com.google.common.base.Preconditions.checkNotNull;

public class CurrencyPair {
    private PrimaryCurrency primaryCurrency;
    private SecondaryCurrency secondaryCurrency;

    public CurrencyPair(final PrimaryCurrency primaryCurrency, final SecondaryCurrency secondaryCurrency) {
        this.primaryCurrency = checkNotNull(primaryCurrency);
        this.secondaryCurrency = checkNotNull(secondaryCurrency);
    }

    public PrimaryCurrency getPrimaryCurrency() {
        return primaryCurrency;
    }

    public SecondaryCurrency getSecondaryCurrency() {
        return secondaryCurrency;
    }
}
