package uk.co.bigredlobster.exchange.south;

import uk.co.bigredobster.domain.CurrencyPair;
import uk.co.bigredobster.domain.FxRate;
import uk.co.bigredobster.microtypes.PrimaryCurrency;
import uk.co.bigredobster.microtypes.Rate;
import uk.co.bigredobster.microtypes.SecondaryCurrency;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static com.google.common.base.Preconditions.checkNotNull;

public class FakePublisher {
    private final FxCache cache;
    private final AtomicInteger counter;

    public FakePublisher(FxCache cache) {
        this.cache = checkNotNull(cache);
        counter = new AtomicInteger(0);
    }

    public void startPublishing() {
        final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.scheduleAtFixedRate(
                () -> cache.add(new FxRate(new CurrencyPair(new PrimaryCurrency("EUR"), new SecondaryCurrency("USD")), new Rate("1.10" + counter.incrementAndGet()))),
                10,
                10,
                TimeUnit.MILLISECONDS
        );
    }
}
