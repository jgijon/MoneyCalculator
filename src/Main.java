
import ui.MoneyDialog;
import model.Fraction;
import model.Money;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.execute();
    }
    
    public void execute() throws IOException {
        
        Fraction test1 = new Fraction(1,3);
        Fraction test2 = new Fraction(2,4);
        Fraction result = new Fraction();
        test1.showFraction();
        test2.showFraction();
        test1.add(test2).showFraction();
        test1.subtract(test2).subtract(new Fraction(-1,6)).showFraction();
        test1.product(test2).showFraction();
        test1.product(new Fraction (2,-3)).showFraction();
        test1.divide(test2).showFraction();
        double pruebaDouble = 4.86778;
        Fraction prueba1 = new Fraction (24.8867785);
        prueba1.showFraction();
        System.out.println((double)prueba1.getNumerator()/prueba1.getDenominator());
        
        //FileCurrencySetLoader.load();
        MoneyDialog dialog = new MoneyDialog();
        dialog.execute();
        Money money = dialog.getMoney();
    }
}
