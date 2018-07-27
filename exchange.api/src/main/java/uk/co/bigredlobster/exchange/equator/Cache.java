package uk.co.bigredlobster.exchange.equator;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import org.springframework.stereotype.Component;
import uk.co.bigredlobster.exchange.south.theStreet.FxRateEvent;
import uk.co.bigredobster.domain.FxRate;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Component
public class Cache {

    private final Disruptor<FxRateEvent> disruptor;
    private RingBuffer<FxRateEvent> ringBuffer;

    public Cache(FxRateEventHandler fxRateEventHandler) {
        Executor executor = Executors.newCachedThreadPool();
        int bufferSize = 1024;

        disruptor = new Disruptor<>(FxRateEvent::new, bufferSize, executor);
        disruptor.handleEventsWith(fxRateEventHandler).then(new ClearingEventHandler());
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
