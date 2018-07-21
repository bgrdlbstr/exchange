package uk.co.bigredlobster.exchange.south;

import com.lmax.disruptor.EventFactory;

public class FxRateEventFactory implements EventFactory<FxRateEvent> {

    @Override
    public FxRateEvent newInstance() {
        return new FxRateEvent();
    }
}
