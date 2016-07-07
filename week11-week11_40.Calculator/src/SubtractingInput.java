
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
public class SubtractingInput implements ActionListener{
    private JTextField fieldOne;
    private JTextField fieldTwo;
    private Calculator calc;
    private JButton reset;

    public SubtractingInput( Calculator calc, JTextField fieldOne, JTextField fieldTwo, JButton reset) {
        this.fieldOne = fieldOne;
        this.fieldTwo = fieldTwo;
        this.calc = calc;
        this.reset = reset;
    }
    
    public int returnFieldOne(){
        return Integer.parseInt(fieldOne.getText());
    }
    
    public int returnFieldTwo(){
        return Integer.parseInt(fieldTwo.getText());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            calc.setInput(returnFieldOne());
            fieldOne.setText("" + calc.subtract(returnFieldTwo()));
            fieldTwo.setText("");
            if ( returnFieldOne() != 0) {
                reset.setEnabled(true);
            } else {
                reset.setEnabled(false);
            }
        } catch (Exception except) {
            fieldTwo.setText("");
        }
    }
    
}
