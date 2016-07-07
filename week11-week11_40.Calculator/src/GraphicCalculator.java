
import com.sun.java.swing.plaf.windows.resources.windows;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GraphicCalculator implements Runnable {
    private JFrame frame;
    private Calculator calc;

    public GraphicCalculator(Calculator calc) {
        this.calc = calc;
    }
    
    

    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(300, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        frame.setLayout( new GridLayout(3, 1));
        JTextField fieldOne = new JTextField("0");
        fieldOne.setEnabled(false);
        JTextField fieldTwo = new JTextField("0");
        
        container.add(fieldOne);
        container.add(fieldTwo);
        container.add(createPanel(fieldOne, fieldTwo), BorderLayout.SOUTH);
    }
    
    private JPanel createPanel(JTextField fieldOne, JTextField fieldTwo){
        JPanel panel = new JPanel(new GridLayout(1, 3));
        JButton buttonAdd = new JButton("+");
        JButton buttonSub = new JButton("-");
        JButton buttonZ = new JButton("Z");
        buttonAdd.addActionListener( new AddingInput(calc, fieldOne, fieldTwo, buttonZ));
        buttonSub.addActionListener( new SubtractingInput(calc, fieldOne, fieldTwo, buttonZ));
        buttonZ.addActionListener( new ResetOutputZero(fieldOne, fieldTwo, buttonZ));
        buttonZ.setEnabled(false);
        panel.add(buttonAdd);
        panel.add(buttonSub);
        panel.add(buttonZ);
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}