package model;

import model.ExchangeRate;
import model.Money;

public class MoneyExchanger {
    
    public static Money exchange(Money money, ExchangeRate rate){
        return new Money(money.getAmount().product(rate.getRate()),rate.getTarget());
    }
}
