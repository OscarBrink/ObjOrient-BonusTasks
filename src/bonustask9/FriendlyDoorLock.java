package bonustask9;

import java.awt.event.*;
import javax.swing.*;

/**
 * @author Oscar Brink
 * 2018-02-08
 */
public class FriendlyDoorLock {

    public static void main(String argv[]) {
        JFrame frame = new JFrame("Layout Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(); // the "background"
        JLabel label = new JLabel("Enter PIN (4 digits):");
        JTextField text = new JTextField("", 4);
        JLabel resultText = new JLabel("---------------------------");
        // "WRONG (too high)";
        //  ----------------

        panel.add(label);
        panel.add(text);
        panel.add(resultText);
        frame.setContentPane(panel); // connect panel to frame

        text.addActionListener(new InputHandler(text, 100, resultText));

        frame.pack();
        frame.setVisible(true);
    }
}

/**
 * This class implements a controller for the textfield.
 *
 * @author hj
 */
class InputHandler implements ActionListener {
    private JTextField text;
    private Integer pin;
    private JLabel resultText;

    public InputHandler(JTextField text, Integer pin, JLabel resultText) {
        this.text = text;
        this.pin = pin;
        this.resultText = resultText;
    }

    // called when the return key is depressed
    public void actionPerformed(ActionEvent arg0) {
        int input = Integer.parseInt(text.getText());
        System.out.println(input + " " + pin);

        if (input == pin) {
            resultText.setText("CORRECT");
        } else if (input > pin) {
            resultText.setText("WRONG (too high)");
        } else {
            resultText.setText("WRONG (too low)");
        }

        text.setText(""); // empty the text field
    }
}
