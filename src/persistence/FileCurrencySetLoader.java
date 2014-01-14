package persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import model.Currency;
import model.CurrencySet;

public class FileCurrencySetLoader implements CurrencySetLoader {

    private final String file;
    
    public FileCurrencySetLoader(String file) {
        this.file = file;
    }
    
    @Override
    public void load() {
        try {
            Currency currency;
            BufferedReader reader = new BufferedReader(new FileReader(new File(file)));
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }else{
                    String[] currencyLine = line.split("-");
                    String code = currencyLine[0];
                    String name = currencyLine[1];
                    String symbol = currencyLine[2];
                    currency = new Currency(code, name, symbol);
                    CurrencySet.getInstance().add(currency);
                }
            }
        } catch (IOException ex) {
            System.out.println("Input/Output Exception");
        } 
    }

}
