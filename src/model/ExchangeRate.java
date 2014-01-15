package model;

import java.util.Date;

public class ExchangeRate {

    private Currency source;
    private Currency target;
    private Date date;
    private Fraction rate;

    public ExchangeRate(Currency source, Currency target, Date date, Fraction rate) {
        this.source = source;
        this.target = target;
        this.date = date;
        this.rate = rate;
    }

    public Currency getSource() {
        return source;
    }

    public Currency getTarget() {
        return target;
    }

    public Date getDate() {
        return date;
    }

    public Fraction getRate() {
        return rate;
    }
}
