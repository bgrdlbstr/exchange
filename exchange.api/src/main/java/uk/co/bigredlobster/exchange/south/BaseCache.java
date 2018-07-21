package uk.co.bigredlobster.exchange.south;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class BaseCache {
    final Disruptor<FxRateEvent> disruptor;
    RingBuffer<FxRateEvent> ringBuffer;

    public BaseCache(final int bufferSize) {
        final Executor executor = Executors.newCachedThreadPool();
        disruptor = new Disruptor<>(FxRateEvent::new, bufferSize, executor);
    }

    public void start() {
        disruptor.start();
        ringBuffer = disruptor.getRingBuffer();
    }
}
