public class CurrencySetLoader {
    
    private static CurrencySetLoader instance;

    public CurrencySetLoader() {
    }

    public static CurrencySetLoader getInstance() {
        if (instance == null)
            instance = new CurrencySetLoader();
        return instance;
    }
    
    public void load(){
        CurrencySet set = CurrencySet.getInstance();
        set.add(new Currency ("USD", "American Dolar", "$"));
        set.add(new Currency ("EUR", "Euro", "€"));
    }
    
    
}
