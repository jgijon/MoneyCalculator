package persistence;

import java.util.Date;
import model.Currency;
import model.ExchangeRate;
import model.Fraction;

public class MockExchangeRateLoader implements ExchangeRateLoader {

    @Override
    public ExchangeRate load(Date date, Currency from, Currency to) {
        return new ExchangeRate(from, to, date, new Fraction(2,32));
    }

    @Override
    public ExchangeRate load(Currency from, Currency to) {
        return load(new Date(), from, to);
    }

}
