package control;

import ui.CurrencyDialog;
import ui.MoneyDialog;
import ui.MoneyViewer;

public class CalculateCommand extends Command {
    
    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final MoneyViewer moneyViewer;

    public CalculateCommand (MoneyDialog moneyDialog,
                            CurrencyDialog currencyDialog,
                            MoneyViewer moneyViewer) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.moneyViewer = moneyViewer;
    }
    
    @Override
    public void execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
