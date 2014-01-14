public class Money {

    private Fraction amount;
    private Currency currency;

    public Money(Fraction amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Fraction getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }
    
}
