package survey;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Survey");

        frame.setPreferredSize(new Dimension(200, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    public void createComponents(Container container) {
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        JLabel text = new JLabel("Are you?");
        container.add(text);
        JCheckBox yes = new JCheckBox("Yes!");
        JCheckBox no = new JCheckBox("No!");
        ButtonGroup group1 = new ButtonGroup();
        group1.add(yes);
        group1.add(no);
        container.add(yes);
        container.add(no);
        container.add(new JLabel("Why?"));
        JRadioButton reason = new JRadioButton("No reason.");
        JRadioButton fun = new JRadioButton("Because it is fun!");
        ButtonGroup group2 = new ButtonGroup();
        group2.add(reason);
        group2.add(fun);
        container.add(reason);
        container.add(fun);
        JButton button = new JButton("Done!");
        container.add(button);
    }

    public JFrame getFrame() {
        return frame;
    }
}
