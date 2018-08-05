package uk.co.bigredlobster.exchange.equator;

import com.lmax.disruptor.EventHandler;
import uk.co.bigredlobster.exchange.south.theStreet.BrokerFxRateEvent;

public class ClearingEventHandler implements EventHandler<BrokerFxRateEvent> {
    @Override
    public void onEvent(BrokerFxRateEvent fxRateEvent, long l, boolean b) throws Exception {
        fxRateEvent.clear();
    }
}
