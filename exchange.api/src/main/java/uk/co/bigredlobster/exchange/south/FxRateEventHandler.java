package uk.co.bigredlobster.exchange.south;

import com.lmax.disruptor.EventHandler;

public class FxRateEventHandler implements EventHandler<FxRateEvent> {
    @Override
    public void onEvent(FxRateEvent fxRateEvent, long sequence, boolean isEndOfBatch) throws Exception {
        System.out.println("fxRateEvent = " + fxRateEvent + " seq = " + sequence + " isEndOfBatch = " + isEndOfBatch);
    }
}
