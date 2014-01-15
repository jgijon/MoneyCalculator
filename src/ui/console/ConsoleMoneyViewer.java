package ui;

import model.Money;

public class ConsoleMoneyViewer implements MoneyViewer {
    
    private Money money;

    @Override
    public void showMoney() {
        System.out.println(money);
    }

    @Override
    public void setMoney(Money money) {
        this.money = money;
    }

}
