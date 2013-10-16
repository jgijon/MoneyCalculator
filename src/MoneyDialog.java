
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MoneyDialog {
    
    private Money money;

    public Money getMoney() {
        return money;
    }
    
    public void execute() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduzca dinero");
        String amount = reader.readLine();
        System.out.println("Introduzca divisa");
        String currency = reader.readLine();
        money = new Money (Integer.valueOf(amount), CurrencySet.getInstance().search(currency));
        System.out.println("La cantidad es: "+ (int) money.getAmount()+ " " + money.getCurrency().getSymbol());
    }
}
