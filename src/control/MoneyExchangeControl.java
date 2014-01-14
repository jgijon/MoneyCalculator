package control;


import ui.CurrencyDialog;


public class MoneyExchangeControl {
    
    public void execute(){
        //CurrencySetLoader.getInstance().load();
        CurrencyDialog dialog = new CurrencyDialog();
        dialog.execute();
        //CurrencyViewer viewer = new CurrencyViewer(dialog);
    }
}
