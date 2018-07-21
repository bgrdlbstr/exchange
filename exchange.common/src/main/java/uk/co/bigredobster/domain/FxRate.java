package uk.co.bigredobster.domain;

import uk.co.bigredobster.microtypes.Rate;

import java.util.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

public class FxRate {
    public final CurrencyPair currencyPair;
    public final Rate rate;

    public FxRate(final CurrencyPair currencyPair, final Rate rate) {
        this.currencyPair = checkNotNull(currencyPair);
        this.rate = checkNotNull(rate);
    }

    public CurrencyPair getCurrencyPair() {
        return currencyPair;
    }

    public Rate getRate() {
        return rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FxRate fxRate = (FxRate) o;
        return Objects.equals(currencyPair, fxRate.currencyPair) &&
                Objects.equals(rate, fxRate.rate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(currencyPair, rate);
    }

    @Override
    public String toString() {
        return "FxRate{" +
                "currencyPair=" + currencyPair +
                ", rate=" + rate +
                '}';
    }
}
