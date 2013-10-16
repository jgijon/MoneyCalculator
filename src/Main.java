
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.execute();
    }
    
    public void execute() throws IOException {
        CurrencySetLoader.getInstance().load();
        MoneyDialog dialog = new MoneyDialog();
        dialog.execute();
        Money money = dialog.getMoney();
    }
}
