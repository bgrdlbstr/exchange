package uk.co.bigredlobster.exchange.south;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Publishers {

    private final FxCache cache;

    @Autowired
    public Publishers(FxCache cache) {
        this.cache = cache;
    }

    @Bean
    public void startPublishing() {
        new FakePublisher(cache).startPublishing();
    }
}
