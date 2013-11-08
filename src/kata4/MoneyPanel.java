package kata4;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class MoneyPanel extends JPanel {

    public MoneyPanel() {
        this.add(createTextField());
        this.add(new CurrencyPanel());
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField(10);
        return textField;
    }
    
}
