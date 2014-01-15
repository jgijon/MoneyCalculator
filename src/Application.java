
import control.MoneyExchangeControl;
import ui.ConsoleCurrencyDialog;
import ui.ConsoleMoneyDialog;
import java.io.IOException;
import persistence.ExchangeRateLoader;
import persistence.FileCurrencySetLoader;
import persistence.MockExchangeRateLoader;
import ui.ConsoleMoneyViewer;

public class Application {

    private final static String PATH = "C:\\Users\\CrudPuppy\\Documents\\IS2\\currencies.txt";
    
    public static void main(String[] args) throws IOException {
        Application application = new Application();
        application.executeConsole();
    }
    
    public void executeConsole() throws IOException {
        FileCurrencySetLoader file = new FileCurrencySetLoader(PATH);
        file.load();
        ConsoleMoneyDialog moneyDialog = new ConsoleMoneyDialog();
        ConsoleCurrencyDialog currencyDialog = new ConsoleCurrencyDialog();
        ConsoleMoneyViewer moneyViewer = new ConsoleMoneyViewer();
        ExchangeRateLoader exchangeRateLoader = MockExchangeRateLoader.getInstance();
        MoneyExchangeControl moneyExchangeControl = new MoneyExchangeControl(moneyDialog, currencyDialog, moneyViewer, exchangeRateLoader);
        moneyExchangeControl.execute();
        System.out.println("executeConsole finish");
    }
}
