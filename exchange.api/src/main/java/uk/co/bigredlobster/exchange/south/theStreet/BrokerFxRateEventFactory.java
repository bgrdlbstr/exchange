package uk.co.bigredlobster.exchange.south.theStreet;

import com.lmax.disruptor.EventFactory;

public class BrokerFxRateEventFactory implements EventFactory<BrokerFxRateEvent> {

    @Override
    public BrokerFxRateEvent newInstance() {
        return new BrokerFxRateEvent();
    }
}
