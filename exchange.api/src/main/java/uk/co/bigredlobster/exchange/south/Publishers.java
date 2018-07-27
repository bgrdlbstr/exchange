package uk.co.bigredlobster.exchange.south;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import uk.co.bigredlobster.exchange.equator.Cache;

@Component
public class Publishers {

    private final Cache cache;

    @Autowired
    public Publishers(Cache cache) {
        this.cache = cache;
        this.cache.start();
    }

    @Bean
    public boolean startPublishing() {
        FakePublisher fakePublisher = new FakePublisher(cache);
        fakePublisher.startPublishing();
        return true;

    }
}
