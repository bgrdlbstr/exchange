package uk.co.bigredlobster.exchange.south;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Publishers {

    private final Cache cache;

    @Autowired
    public Publishers(Cache cache) {
        this.cache = cache;
    }

    @Bean
    public void startPublishing() {
        new FakePublisher(cache).startPublishing();
    }
}
