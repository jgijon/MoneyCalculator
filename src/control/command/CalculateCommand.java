package control.command;

import control.command.Command;
import model.Currency;
import model.ExchangeRate;
import model.Money;
import model.MoneyExchanger;
import persistence.ExchangeRateLoader;
import ui.CurrencyDialog;
import ui.MoneyDialog;
import ui.MoneyViewer;

public class CalculateCommand extends Command {
    
    private MoneyDialog moneyDialog;
    private CurrencyDialog currencyDialog;
    private MoneyViewer moneyViewer;
    private ExchangeRateLoader exchangeRateLoader;

    public CalculateCommand (MoneyDialog moneyDialog,
                            CurrencyDialog currencyDialog,
                            MoneyViewer moneyViewer,
                            ExchangeRateLoader exchangeRateLoader) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.moneyViewer = moneyViewer;
        this.exchangeRateLoader = exchangeRateLoader;
    }
    
    @Override
    public void execute() {
        Money money = moneyDialog.getMoney();
        Currency currency = currencyDialog.getCurrency();
        ExchangeRate exchangeRate = exchangeRateLoader.load(money.getCurrency(), currency);
        money = MoneyExchanger.exchange(money, exchangeRate);
        moneyViewer.setMoney(money);
        moneyViewer.showMoney();
    }

}
