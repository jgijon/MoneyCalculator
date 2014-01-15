package control;


import java.io.IOException;
import model.Currency;
import model.ExchangeRate;
import model.Money;
import persistence.ExchangeRateLoader;
import ui.ConsoleCurrencyDialog;
import ui.ConsoleMoneyDialog;
import ui.ConsoleMoneyViewer;

public class MoneyExchangeControl {
    
    private ConsoleMoneyDialog moneyDialog;
    private ConsoleCurrencyDialog currencyDialog;
    private ConsoleMoneyViewer moneyViewer;
    private ExchangeRateLoader exchangeRateLoader;
    
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
