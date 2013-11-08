package kata4;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class CurrencyPanel extends JPanel{
    private static String[] currencies = {"EUR", "USD", "CAD", "GBP"};

    public CurrencyPanel() {
        this.add(createComboBox());
    }

    private JComboBox createComboBox() {
        JComboBox comboBox = new JComboBox(currencies);
        return comboBox;
    }
    
    
}
