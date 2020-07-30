package Archive.prog3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame2 extends JFrame{
    private JPanel keysPanel;
    private JButton[] keysButtons;
    private JTextField textFieldLCD;
    String text = "";
    public Frame2() {
        GridLayout gridLayout = new GridLayout(4,4);
        keysPanel = new JPanel(gridLayout);
        gridLayout.setVgap(10);
        gridLayout.setHgap(10);
        keysButtons = new JButton[16];
        for(int i=0; i<=9; i++) {
            keysButtons[i] = new JButton(String.valueOf(i));
        }
        keysButtons[10] = new JButton("/");
        keysButtons[11] = new JButton("*");
        keysButtons[12] = new JButton("-");
        keysButtons[13] = new JButton("+");
        keysButtons[14] = new JButton("=");
        keysButtons[15] = new JButton(".");

        keysPanel.add(keysButtons[7]);
        keysPanel.add(keysButtons[8]);
        keysPanel.add(keysButtons[9]);
        keysPanel.add(keysButtons[10]);
        keysPanel.add(keysButtons[4]);
        keysPanel.add(keysButtons[5]);
        keysPanel.add(keysButtons[6]);
        keysPanel.add(keysButtons[11]);
        keysPanel.add(keysButtons[1]);
        keysPanel.add(keysButtons[2]);
        keysPanel.add(keysButtons[3]);
        keysPanel.add(keysButtons[12]);
        keysPanel.add(keysButtons[0]);
        keysPanel.add(keysButtons[15]);
        keysPanel.add(keysButtons[14]);
        keysPanel.add(keysButtons[13]);

        EventHandler eventHandler = new EventHandler();
        for(JButton button:keysButtons){
            button.addActionListener(eventHandler);
            button.setFont(new Font("Arial", Font.PLAIN, 18));
        }

        textFieldLCD = new JTextField("LCD");
        textFieldLCD.setFont(new Font("Arial", Font.PLAIN, 18));
        setLayout(new BorderLayout());
        add(textFieldLCD, BorderLayout.NORTH);
        add(keysPanel,BorderLayout.CENTER);

        this.setSize(270, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Calculator");
        this.setVisible(true);

    }

    private class EventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            text = text.concat(((AbstractButton) e.getSource()).getText());
            textFieldLCD.setText(
                    text
            );

        }

    }

    public static void main(String[] args) {
        new Frame2();
    }

}