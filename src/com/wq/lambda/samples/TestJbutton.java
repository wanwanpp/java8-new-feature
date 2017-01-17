package com.wq.lambda.samples;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 王萍 on 2017/1/16 0016.
 */
public class TestJbutton {

    /**
     * swing编程，写监听事件代码
     * @param args
     */
    public static void main(String[] args) {
        JButton show = new JButton("Show");

        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("without lambda");
            }
        });

        show.addActionListener(action-> System.out.println("using lambda"));
    }
}
