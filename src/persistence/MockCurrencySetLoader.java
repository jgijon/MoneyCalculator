package persistence;

import model.Currency;
import model.CurrencySet;

public class MockCurrencySetLoader implements CurrencySetLoader {

    @Override
    public void load() {
        CurrencySet set = CurrencySet.getInstance();
        set.add(new Currency ("USD", "American Dolar", "$"));
        set.add(new Currency ("EUR", "Euro", "€"));
        set.add(new Currency ("GBP", "Libra Esterlina","£"));}

}
