package clicker.ui;

import clicker.applicationlogic.Calculator;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class UserInterface implements Runnable {
    private JFrame frame;
    private Calculator calc;

    public UserInterface(Calculator calc) {
        this.calc = calc;
    }
    
    


    @Override
    public void run() {
        frame = new JFrame("Click Effect");
        frame.setPreferredSize(new Dimension(200, 100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        BorderLayout layout = new BorderLayout();
        frame.setLayout(layout);
        JLabel label = new JLabel("0");
        JButton button = new JButton("Click!");
        ClickListener listen = new ClickListener(calc, label);
        button.addActionListener(listen);
        container.add(label, BorderLayout.CENTER);
        container.add(button, BorderLayout.SOUTH);
    }

    public JFrame getFrame() {
        return frame;
    }
}
