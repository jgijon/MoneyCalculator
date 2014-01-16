package control;


import model.MoneyExchanger;
import java.io.IOException;
import model.Currency;
import model.ExchangeRate;
import model.Money;
import persistence.ExchangeRateLoader;
import ui.console.ConsoleCurrencyDialog;
import ui.console.ConsoleMoneyDialog;
import ui.console.ConsoleMoneyViewer;

public class MoneyExchangeControl {
    
    private final ConsoleMoneyDialog moneyDialog;
    private final ConsoleCurrencyDialog currencyDialog;
    private final ConsoleMoneyViewer moneyViewer;
    private final ExchangeRateLoader exchangeRateLoader;
    
    public MoneyExchangeControl (ConsoleMoneyDialog moneyDialog,
                                ConsoleCurrencyDialog currencyDialog,
                                ConsoleMoneyViewer moneyViewer,
                                ExchangeRateLoader exchangeRateLoader) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.moneyViewer = moneyViewer;
        this.exchangeRateLoader = exchangeRateLoader;
        
    }
    
    public void execute() throws IOException{
        moneyDialog.execute();
        Money money = moneyDialog.getMoney();
        currencyDialog.execute();
        Currency currency = currencyDialog.getCurrency();
        ExchangeRate exchangeRate = exchangeRateLoader.load(money.getCurrency(), currency);
        money = MoneyExchanger.exchange(money, exchangeRate);
        moneyViewer.setMoney(money);
        moneyViewer.showMoney();
        System.out.println("end execute moneyexchangecontrol");
        
    }
}
