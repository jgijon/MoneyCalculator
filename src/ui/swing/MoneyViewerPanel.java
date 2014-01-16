package ui.swing;


import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Money;
import ui.MoneyViewer;


public class MoneyViewerPanel extends JPanel implements MoneyViewer {

    private final JLabel result;
    private Money money;
    
    public MoneyViewerPanel() {
        this.setLayout(new FlowLayout());
        result=new JLabel("0");
    }

    @Override
    public void showMoney() {
        this.add(createLabel());
    }

    @Override
    public void setMoney(Money money) {
        this.money=money;
    }

    private JLabel createLabel() {
        if (money!=null)
            result.setText(money.toString());
        return result;
    }
}
