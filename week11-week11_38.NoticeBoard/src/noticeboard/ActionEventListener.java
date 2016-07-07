/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noticeboard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Michael
 */
public class ActionEventListener implements ActionListener{
    private JTextField replacement;
    private JLabel label;

    public ActionEventListener(JTextField replacement, JLabel label) {
        this.replacement = replacement;
        this.label = label;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        label.setText(replacement.getText());
        replacement.setText("");
    }
    
    
}
