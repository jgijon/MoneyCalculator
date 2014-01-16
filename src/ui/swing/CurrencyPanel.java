package ui.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import model.Currency;
import model.CurrencySet;
import ui.CurrencyDialog;

public class CurrencyPanel extends JPanel implements CurrencyDialog{

    private Currency currency;
    
    public CurrencyPanel() {
        this.add(createComboBox());
    }

    private JComboBox createComboBox() {
        final JComboBox comboBox = new JComboBox();
        for (Currency item : CurrencySet.getInstance())
            comboBox.addItem(item);
        currency = CurrencySet.getInstance().iterator().next();
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currency = (Currency) comboBox.getSelectedItem();
            }
        });
        return comboBox;
    }

    @Override
    public Currency getCurrency() {
        return currency;
    }
    
    
}
