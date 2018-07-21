package uk.co.bigredlobster.exchange.south;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import uk.co.bigredobster.domain.CurrencyPair;
import uk.co.bigredobster.domain.FxRate;
import uk.co.bigredobster.microtypes.PrimaryCurrency;
import uk.co.bigredobster.microtypes.Rate;
import uk.co.bigredobster.microtypes.SecondaryCurrency;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Cache {

    private final Disruptor<FxRateEvent> disruptor;
    private RingBuffer<FxRateEvent> ringBuffer;

    public Cache() {
        Executor executor = Executors.newCachedThreadPool();
        int bufferSize = 1024;

        disruptor = new Disruptor<>(FxRateEvent::new, bufferSize, executor);
        disruptor.handleEventsWith(new FxRateEventHandler()).then(new ClearingEventHandler());
    }

    public void add(FxRate fxRate) {
        ringBuffer.publishEvent(Cache::translate, fxRate);
    }

    public void start() {
        disruptor.start();
        ringBuffer = disruptor.getRingBuffer();
    }

    private static void translate(FxRateEvent event, long sequence, FxRate incomingRate) {
        event.setFxRate(incomingRate);
    }
}
