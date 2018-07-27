package uk.co.bigredlobster.exchange.north;

import java.util.Objects;

public class ApiCurrencyPair {
    private String primaryCurrency;
    private String secondaryCurrency;

    public ApiCurrencyPair() {}

    public ApiCurrencyPair(final String primaryCurrency, final String secondaryCurrency) {
        this.primaryCurrency = primaryCurrency;
        this.secondaryCurrency = secondaryCurrency;
    }

    public String getPrimaryCurrency() {
        return primaryCurrency;
    }

    public void setPrimaryCurrency(String primaryCurrency) {
        this.primaryCurrency = primaryCurrency;
    }

    public String getSecondaryCurrency() {
        return secondaryCurrency;
    }

    public void setSecondaryCurrency(String secondaryCurrency) {
        this.secondaryCurrency = secondaryCurrency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiCurrencyPair that = (ApiCurrencyPair) o;
        return Objects.equals(primaryCurrency, that.primaryCurrency) &&
                Objects.equals(secondaryCurrency, that.secondaryCurrency);
    }

    @Override
    public int hashCode() {

        return Objects.hash(primaryCurrency, secondaryCurrency);
    }

    @Override
    public String toString() {
        return "ApiCurrencyPair{" +
                "currencyPair='" + primaryCurrency + '\'' +
                ", secondaryCurrency='" + secondaryCurrency + '\'' +
                '}';
    }
}
