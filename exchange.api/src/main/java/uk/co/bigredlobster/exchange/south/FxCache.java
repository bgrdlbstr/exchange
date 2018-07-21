package uk.co.bigredlobster.exchange.south;

import uk.co.bigredobster.domain.FxRate;

public class FxCache {

    private BaseCache baseCache;

    public FxCache() {
        int bufferSize = 1024;
        baseCache = new BaseCache(bufferSize);
        baseCache.disruptor.handleEventsWith(new FxRateEventHandler()).then(new ClearingEventHandler());
    }

    private static void translate(FxRateEvent event, long sequence, FxRate incomingRate) {
        event.setFxRate(incomingRate);
    }

    public void add(FxRate fxRate) {
        baseCache.ringBuffer.publishEvent(FxCache::translate, fxRate);
    }

    public void start() {
        baseCache.start();
    }
}
