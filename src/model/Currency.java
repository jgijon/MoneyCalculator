package model;

public class Currency {
    
    private String code;
    private String name;
    private String symbol;
    

    public Currency(String code, String name, String symbol) {
        this.code = code;
        this.symbol = symbol;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }
    
}
