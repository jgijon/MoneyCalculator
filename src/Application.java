
import control.command.CommandRegister;
import control.MoneyExchangeControl;
import control.command.Command;
import control.command.CommandCalculate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.console.ConsoleCurrencyDialog;
import ui.console.ConsoleMoneyDialog;
import java.io.IOException;
import persistence.ExchangeRateLoader;
import persistence.FileCurrencySetLoader;
import persistence.MockExchangeRateLoader;
import ui.console.ConsoleMoneyViewer;
import ui.swing.ActionListenerFactory;
import ui.swing.ApplicationFrame;

public class Application {

    private final static String PATH = "C:\\Users\\CrudPuppy\\Documents\\IS2\\currencies.txt";
    private final static String PATH_RATES = "C:\\Users\\CrudPuppy\\Documents\\IS2\\exchangerates.txt";

    public static void main(String[] args) throws IOException {
        Application application = new Application();
        //application.executeConsole();
        application.executeSwing();
    }

    private static void executeConsole() throws IOException {
        FileCurrencySetLoader file = new FileCurrencySetLoader(PATH);
        file.load();
        ConsoleMoneyDialog moneyDialog = new ConsoleMoneyDialog();
        ConsoleCurrencyDialog currencyDialog = new ConsoleCurrencyDialog();
        ConsoleMoneyViewer moneyViewer = new ConsoleMoneyViewer();
        ExchangeRateLoader exchangeRateLoader = MockExchangeRateLoader.getInstance();
        //FileExchangeRateLoader fileRates = new FileExchangeRateLoader(PATH_RATES);
        //fileRates.load(moneyDialog.getMoney().getCurrency(), currencyDialog.getCurrency());
        MoneyExchangeControl moneyExchangeControl = new MoneyExchangeControl(moneyDialog, currencyDialog, moneyViewer, exchangeRateLoader);
        moneyExchangeControl.execute();
        System.out.println("executeConsole finish");
    }

    private static void executeSwing() {
        FileCurrencySetLoader file = new FileCurrencySetLoader(PATH);
        file.load();
        
        final CommandRegister commandRegister = new CommandRegister();
        ActionListenerFactory factory = new ActionListenerFactory() {

            @Override
            public ActionListener getAction(final String action) {
                return new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        commandRegister.getActionMap(action).execute();
                    }
                };
            }
        };
        final ApplicationFrame frame = new ApplicationFrame(factory);
        commandRegister.setActionMap("calculate", new CommandCalculate(frame.getMoneyDialog(), 
                frame.getCurrencyDialog(),
                frame.getMoneyViewer()));
        commandRegister.setActionMap("exit", new Command() {

            @Override
            public void execute() {
                frame.dispose();
            }
        });
    }
}
