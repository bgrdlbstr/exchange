package uk.co.bigredlobster.exchange.south;

import uk.co.bigredlobster.exchange.equator.Cache;
import uk.co.bigredobster.domain.Broker;
import uk.co.bigredobster.domain.BrokerFxRate;
import uk.co.bigredobster.domain.CurrencyPair;
import uk.co.bigredobster.domain.FxRate;
import uk.co.bigredobster.microtypes.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

class RateGenerator {
    private final Cache cache;
    private final PrimaryCurrency primaryCurrency;
    private final SecondaryCurrency secondaryCurrency;
    private final ScheduledExecutorService executor;
    private Rate lastRate;
    private Broker broker = new Broker(new BrokerName("Barclays"), new BrokerCode("BARC"));

    RateGenerator(final Cache cache, final PrimaryCurrency primaryCurrency, final SecondaryCurrency secondaryCurrency, final Rate seed) {
        this.cache = cache;
        this.primaryCurrency = primaryCurrency;
        this.secondaryCurrency = secondaryCurrency;
        this.lastRate = seed;
        executor = Executors.newScheduledThreadPool(1);
    }

    void start() {
        Executor e = Executors.newSingleThreadExecutor();
        e.execute(this::generateRate);
    }

    @SuppressWarnings("InfiniteLoopStatement")
    private void generateRate() {
        while (true) {
            long delay = getDelayMs();
            try {
                Thread.sleep(delay);
                executor.execute(
                        () -> {
                            final Rate nextRate = getNextRate();
                            cache.add(new BrokerFxRate(broker, new FxRate(new CurrencyPair(primaryCurrency, secondaryCurrency), nextRate)));
                            this.lastRate = nextRate;
                        }
                );
            } catch (InterruptedException e) {
                throw new RuntimeException("Failed to sleep");
            }
        }
    }

    private Rate getNextRate() {
        if (Math.random() >= 0.5)
            return new Rate(lastRate.value.add(new BigDecimal(Math.random() / 100)).setScale(6, RoundingMode.HALF_UP));
        else
            return new Rate(lastRate.value.subtract(new BigDecimal(Math.random() / 100)).setScale(6, RoundingMode.HALF_UP));
    }

    private long getDelayMs() {
        return (int) (Math.random() * 100);
    }
}
