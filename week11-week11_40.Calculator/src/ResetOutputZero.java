
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael
 */
public class ResetOutputZero implements ActionListener{
    private JTextField field;
    private JTextField fieldTwo;
    private JButton reset;

    public ResetOutputZero(JTextField field, JTextField fieldTwo, JButton reset) {
        this.field = field;
        this.fieldTwo = fieldTwo;
        this.reset = reset;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        field.setText("0");
        fieldTwo.setText("");
        reset.setEnabled(false);
    }
    
}
