package uk.co.bigredlobster.exchange.south;

import uk.co.bigredlobster.exchange.equator.Cache;
import uk.co.bigredobster.microtypes.PrimaryCurrency;
import uk.co.bigredobster.microtypes.Rate;
import uk.co.bigredobster.microtypes.SecondaryCurrency;

import static com.google.common.base.Preconditions.checkNotNull;

class FakePublisher {
    private final Cache cache;

    FakePublisher(Cache cache) {
        this.cache = checkNotNull(cache);
    }

    void startPublishing() {
        new RateGenerator(cache, new PrimaryCurrency("EUR"), new SecondaryCurrency("USD"), new Rate("1.1")).start();
        new RateGenerator(cache, new PrimaryCurrency("GBP"), new SecondaryCurrency("USD"), new Rate("1.3")).start();
        new RateGenerator(cache, new PrimaryCurrency("JPY"), new SecondaryCurrency("USD"), new Rate("99.1")).start();
    }
}
