package uk.co.bigredlobster.exchange.equator;

import com.lmax.disruptor.EventHandler;
import uk.co.bigredlobster.exchange.south.theStreet.FxRateEvent;

public class ClearingEventHandler implements EventHandler<FxRateEvent> {
    @Override
    public void onEvent(FxRateEvent fxRateEvent, long l, boolean b) throws Exception {
        fxRateEvent.clear();
    }
}
