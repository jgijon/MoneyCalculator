package persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import model.Currency;
import model.ExchangeRate;
import model.Fraction;

public class FileExchangeRateLoader implements ExchangeRateLoader {

    private final String file;
    
    public FileExchangeRateLoader (String file) {
        this.file = file;
    }
    
    @Override
    public ExchangeRate load(Date date, Currency from, Currency to) {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ExchangeRate load(Currency from, Currency to) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (true) {
                String line = reader.readLine().trim();
                if (line == null) {
                    break;
                }else{
                    String[] rateLine = line.split("/");
                    if (rateLine[1].equalsIgnoreCase(to.getCode()))
                        return new ExchangeRate(from, to, new Date(), new Fraction(Double.valueOf(rateLine[0])));
                }
            }
        } catch (IOException ex) {
            System.out.println("Input/Output Exception");
        }
        return null;
    }

}
