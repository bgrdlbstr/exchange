package uk.co.bigredlobster.exchange.equator;

import com.lmax.disruptor.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import uk.co.bigredlobster.exchange.south.theStreet.BrokerFxRateEvent;
import uk.co.bigredobster.domain.BrokerFxRate;
import uk.co.bigredobster.domain.FxRate;

@Controller
public class FxRateEventHandler implements EventHandler<BrokerFxRateEvent> {

    @Autowired
    private SimpMessagingTemplate brokerMessagingTemplate;

    @Override
    public void onEvent(BrokerFxRateEvent fxRateEvent, long sequence, boolean isEndOfBatch) throws Exception {
//        System.out.println("fxRateEvent = " + fxRateEvent + " seq = " + sequence + " isEndOfBatch = " + isEndOfBatch);
        sendRate(fxRateEvent.getBrokerFxRate());
    }

    @SubscribeMapping("/topic/fxrates")
    @SendTo("/topic/fxrates")
    private void sendRate(final BrokerFxRate fxRate) throws Exception {
        if (brokerMessagingTemplate.getDefaultDestination() == null)
            brokerMessagingTemplate.setDefaultDestination("/topic/fxrates");
        this.brokerMessagingTemplate.convertAndSend(fxRate);
    }
}
