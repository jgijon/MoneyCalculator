package ui.console;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import model.Currency;
import model.CurrencySet;
import ui.CurrencyDialog;


public class ConsoleCurrencyDialog implements CurrencyDialog{
    
    private Currency currency;
    
    public void execute(){
        while (true){
            try {
                System.out.println("Introduce la divisa");
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    String line = reader.readLine();
                    Currency[] currencies = CurrencySet.getInstance().search(line);
                    if (currencies.length == 1){
                        currency = currencies[0];
                        break;
                    }
                    if (currencies.length == 0){
                        System.out.println("No se ha encontrado divisas");
                    }
                    if (currencies.length > 1){
                        
                    }
                    
            } catch (IOException ex) {
                System.out.println("Por favor introduzca un valor correcto");
            }
        }

}

    @Override
    public Currency getCurrency() {
        return currency;
    }
    
}
