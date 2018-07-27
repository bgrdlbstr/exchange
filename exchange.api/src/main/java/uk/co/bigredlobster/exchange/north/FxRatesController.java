package uk.co.bigredlobster.exchange.north;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import uk.co.bigredobster.domain.CurrencyPair;
import uk.co.bigredobster.domain.FxRate;
import uk.co.bigredobster.microtypes.PrimaryCurrency;
import uk.co.bigredobster.microtypes.Rate;
import uk.co.bigredobster.microtypes.SecondaryCurrency;

import java.math.BigDecimal;

@Controller
public class FxRatesController {
    @MessageMapping("/getRate")
    @SendTo("/topic/fxrates")
    public FxRate greeting(final ApiCurrencyPair currencyPair) throws Exception {
        final String primaryCcyStr = HtmlUtils.htmlEscape(currencyPair.getPrimaryCurrency());
        final String secondaryCcyStr = HtmlUtils.htmlEscape(currencyPair.getSecondaryCurrency());
        return new FxRate(
                new CurrencyPair(new PrimaryCurrency(primaryCcyStr), new SecondaryCurrency(secondaryCcyStr)),
                new Rate(new BigDecimal("1.12"))
        );
    }
}
