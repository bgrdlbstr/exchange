package uk.co.bigredlobster.exchange.south;

import com.lmax.disruptor.EventHandler;

public class ClearingEventHandler implements EventHandler<FxRateEvent> {
    @Override
    public void onEvent(FxRateEvent fxRateEvent, long l, boolean b) throws Exception {
        fxRateEvent.clear();
    }
}
