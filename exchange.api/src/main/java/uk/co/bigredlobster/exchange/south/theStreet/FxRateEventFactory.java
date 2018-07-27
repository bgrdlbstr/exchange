package uk.co.bigredlobster.exchange.south.theStreet;

import com.lmax.disruptor.EventFactory;

public class FxRateEventFactory implements EventFactory<FxRateEvent> {

    @Override
    public FxRateEvent newInstance() {
        return new FxRateEvent();
    }
}
