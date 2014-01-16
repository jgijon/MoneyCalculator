package control.command;


import model.Currency;
import model.ExchangeRate;
import model.Money;
import model.MoneyExchanger;
import persistence.MockExchangeRateLoader;
import ui.CurrencyDialog;
import ui.MoneyDialog;
import ui.MoneyViewer;

public class CommandCalculate extends Command{
    
    private final MoneyViewer moneyViewer;
    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;

    public CommandCalculate(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, MoneyViewer moneyViewer){
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.moneyViewer = moneyViewer;
    }


    @Override
    public void execute() {
        try {
            Money money = moneyDialog.getMoney();
            Currency currency = currencyDialog.getCurrency();
            ExchangeRate rate = MockExchangeRateLoader.getInstance().load(money.getCurrency(), currency);
            moneyViewer.setMoney(MoneyExchanger.exchange(money, rate));
            moneyViewer.showMoney();
        } catch (Exception ex) {
            
        }
        
    }
    
    

}
