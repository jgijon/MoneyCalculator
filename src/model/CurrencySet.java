package model;

import java.util.ArrayList;
import java.util.HashSet;

public class CurrencySet extends HashSet<Currency>{

    private static CurrencySet instance;

    public CurrencySet() {
        super();
    }
    
    public static CurrencySet getInstance(){
        if (instance == null)
            instance = new CurrencySet();
        return instance;              
    }
    
    public Currency[] search(String token){
        ArrayList<Currency> list = new ArrayList<>();
        
        for (Currency currency : this){
            if (currency.getCode().equalsIgnoreCase(token))
                list.add(currency);
            else
                if (currency.getSymbol().equalsIgnoreCase(token))
                    list.add(currency);
                else
                    if (currency.getName().equalsIgnoreCase(token))
                        list.add(currency);    
        }
        return list.toArray(new Currency[0]);
    }
}
