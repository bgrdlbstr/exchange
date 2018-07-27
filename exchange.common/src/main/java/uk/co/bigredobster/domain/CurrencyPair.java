package uk.co.bigredobster.domain;

import uk.co.bigredobster.microtypes.PrimaryCurrency;
import uk.co.bigredobster.microtypes.SecondaryCurrency;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "CurrencyPair{" +
                "primaryCurrency=" + primaryCurrency +
                ", secondaryCurrency=" + secondaryCurrency +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyPair that = (CurrencyPair) o;
        return Objects.equals(primaryCurrency, that.primaryCurrency) &&
                Objects.equals(secondaryCurrency, that.secondaryCurrency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primaryCurrency, secondaryCurrency);
    }
}
