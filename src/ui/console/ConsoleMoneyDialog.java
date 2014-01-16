package ui.console;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import model.Currency;
import model.CurrencySet;
import model.Fraction;
import model.Money;
import ui.MoneyDialog;


public class ConsoleMoneyDialog implements MoneyDialog{
   
    private Money money;
    
    public void execute() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduzca cantidad de dinero");
        String amount = reader.readLine();
        System.out.println("Introduzca divisa");
        String currency = reader.readLine();
        Currency[] currencies = CurrencySet.getInstance().search(currency);
        money = new Money(new Fraction(Double.valueOf(amount)), currencies[0]);        
        System.out.println("La cantidad es: "+ money.getAmount()+ " " + money.getCurrency().getSymbol());
    }

    @Override
    public Money getMoney() {
        return money;
    }

}