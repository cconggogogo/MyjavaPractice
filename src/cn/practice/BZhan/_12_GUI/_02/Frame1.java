package cn.practice.BZhan._12_GUI._02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 接口回调：
 * 当一个对象需要给外部对象提供数据时，
 * 可以定义一个内部接口把数据通过接口传递出去，
 * 所有外部对象需要这个数据时，就实现这个接口，
 * 好处：传递数据的对象不直接依赖与接收数据的对象(降低耦合度)
 */
public class Frame1 extends Frame implements Frame2.MoneyListener{
    private Label label = new Label("金额");
    private Button button = new Button("购买");

    public Frame1(){
        this.setSize(400,200);
        this.setTitle("窗体1");
        this.setLayout(new FlowLayout());
        this.add(button);
        this.add(label);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame2().setMoneyListener(Frame1.this);
            }
        });
        this.setVisible(true);
    }

    @Override
    public void setMoney(String money) {
        label.setText(money);
    }

    public static void main(String[] args) {
        new Frame1();
    }
}
