package cn.practice.Others._01_BasicJavaMethod.BZhan._12_GUI._01;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame implements ActionListener {
    public MyFrame(){
        this.setSize(600,400);
        this.setTitle("我的第一个GUI窗体");
        Button button = new Button("点我一下");

        // 给按钮添加单击事件
        button.addActionListener(this);
        FlowLayout flowLayout = new FlowLayout();
        this.setLayout(flowLayout);

        // 添加关闭事件
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });

        this.add(button);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame();
    }

    // 事件处理的方法
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("事件");
    }
}
