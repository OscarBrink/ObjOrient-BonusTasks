package bonustask10;

import javax.imageio.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class ImageViewer extends JFrame {

    private boolean image1;

    public ImageViewer(String s) {
        super(s);
        image1 = true;
    }

    public static void main(String args[]) {
        try {
            JFrame frame = new ImageViewer("LOL");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            URL img1URL = new URL("http://www.sm.luth.se/csee/courses/d0010e/l/prob/10tj5Ei9o/LTU-Teatern.jpg");
            URL img2URL = new URL("http://www.sm.luth.se/csee/courses/d0010e/l/prob/10tj5Ei9o/LTU-Vetenskapens-hus.jpg");
            JPanel panel = new JPanel();
            Icon image1 = new ImageIcon(ImageIO.read(img1URL));
            Icon image2 = new ImageIcon(ImageIO.read(img2URL));
            JLabel imageLabel = new JLabel(image1);
            JButton button = new JButton("Change");

            class ButtonController implements ActionListener {
                private boolean on;

                public ButtonController() {
                    this.on = true;
                }

                public void actionPerformed(ActionEvent arg0) {
                    on = !on;
                    if (on) {
                        imageLabel.setIcon(image1);
                    } else {
                        imageLabel.setIcon(image2);
                    }
                }
            }

            button.addActionListener(new ButtonController());
            panel.add(imageLabel);
            panel.add(button);
            frame.setContentPane(panel);

            frame.pack();
            frame.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong.");
        }

    }

/*
    public static void main(String[] args) {
        int i = 0b010011101,
            i1 = 0235,
            i2 = 0x9d;

        System.out.println(
                i + "\n"
                + i1 + "\n"
                + i2
        );
    }
*/
}
