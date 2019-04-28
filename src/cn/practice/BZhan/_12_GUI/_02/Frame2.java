package cn.practice.BZhan._12_GUI._02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame2 extends Frame {
    TextField textField = new TextField(20);
    private Button button = new Button("付款");

    public Frame2(){
        this.setSize(400,200);
        this.setLayout(new FlowLayout());
        this.setTitle("窗体2");
        this.add(button);
        this.add(textField);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                moneyListener.setMoney(text);
            }
        });
        this.setVisible(true);
    }

    private MoneyListener moneyListener;

    public void setMoneyListener(MoneyListener moneyListener) {
        this.moneyListener = moneyListener;
    }

    public static interface MoneyListener{
        public void setMoney(String money);
    }
}
