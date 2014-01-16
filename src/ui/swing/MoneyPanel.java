package ui.swing;

import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Fraction;
import model.Money;
import ui.CurrencyDialog;
import ui.MoneyDialog;

public class MoneyPanel extends JPanel implements MoneyDialog{
    private String amount;
    private CurrencyDialog currencyDialog;

    public MoneyPanel() {
        this.add(createTextField());
        this.add(new CurrencyPanel());
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField(10);
        return textField;
    }

    @Override
    public Money getMoney() {
        if(amount == null) amount = "0";
        return new Money(new Fraction(Double.parseDouble(amount)),currencyDialog.getCurrency());
    }
    
}
