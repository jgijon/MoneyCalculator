package persistence;

import java.util.Date;
import model.Currency;
import model.ExchangeRate;
import model.Fraction;

public class MockExchangeRateLoader implements ExchangeRateLoader {
    
    private static MockExchangeRateLoader instance;

    public static ExchangeRateLoader getInstance() {
        if (instance == null)
            instance = new MockExchangeRateLoader();
        return instance;
    }
        
    @Override
    public ExchangeRate load(Date date, Currency from, Currency to) {
        return new ExchangeRate(from, to, date, new Fraction(10));
    }

    @Override
    public ExchangeRate load(Currency from, Currency to) {
        return load(new Date(), from, to);
    }

}
