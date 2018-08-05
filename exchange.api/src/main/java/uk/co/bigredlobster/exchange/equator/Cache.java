package uk.co.bigredlobster.exchange.equator;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import org.springframework.stereotype.Component;
import uk.co.bigredlobster.exchange.south.theStreet.BrokerFxRateEvent;
import uk.co.bigredobster.domain.BrokerFxRate;
import uk.co.bigredobster.domain.FxRate;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Component
public class Cache {

    private final Disruptor<BrokerFxRateEvent> disruptor;
    private RingBuffer<BrokerFxRateEvent> ringBuffer;

    public Cache(FxRateEventHandler fxRateEventHandler) {
        Executor executor = Executors.newCachedThreadPool();
        int bufferSize = 1024;

        disruptor = new Disruptor<>(BrokerFxRateEvent::new, bufferSize, executor);
        disruptor.handleEventsWith(fxRateEventHandler).then(new ClearingEventHandler());
    }

    private static void translate(BrokerFxRateEvent event, long sequence, BrokerFxRate incomingRate) {
        event.setBrokerFxRate(incomingRate);
    }

    public void add(BrokerFxRate fxRate) {
        ringBuffer.publishEvent(Cache::translate, fxRate);
    }

    public void start() {
        disruptor.start();
        ringBuffer = disruptor.getRingBuffer();
    }
}
