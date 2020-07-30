package Archive.prog3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Numeric_Converter extends JFrame {
    private JPanel keysPanel;
    private JButton[] buttons;
    private JTextField display;
    private JRadioButton[] base;
    private JButton clear;
    private String input = "";
    private int currentBase = 10;

    public Numeric_Converter(){
        this.setSize(320,350);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        GridLayout gridLayout = new GridLayout(4,4);
        keysPanel = new JPanel(gridLayout);
        gridLayout.setVgap(10);
        gridLayout.setHgap(10);

        buttons = new JButton[16];
        for(int i=0; i<=9; i++) {
            buttons[i] = new JButton(String.valueOf(i));
        }


        buttons[10] = new JButton("A");
        buttons[11] = new JButton("B");
        buttons[12] = new JButton("C");
        buttons[13] = new JButton("D");
        buttons[14] = new JButton("E");
        buttons[15] = new JButton("F");

        keysPanel.add(buttons[7]);
        keysPanel.add(buttons[8]);
        keysPanel.add(buttons[9]);
        keysPanel.add(buttons[10]);
        keysPanel.add(buttons[4]);
        keysPanel.add(buttons[5]);
        keysPanel.add(buttons[6]);
        keysPanel.add(buttons[11]);
        keysPanel.add(buttons[1]);
        keysPanel.add(buttons[2]);
        keysPanel.add(buttons[3]);
        keysPanel.add(buttons[12]);
        keysPanel.add(buttons[0]);
        keysPanel.add(buttons[15]);
        keysPanel.add(buttons[14]);
        keysPanel.add(buttons[13]);

        EventHandler eventHandler = new EventHandler();
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].addActionListener(eventHandler);
        }

        display = new JTextField("");


        base= new JRadioButton[4];
        for (int i = 0; i < base.length; i++) {
            base[i]= new JRadioButton();
        }
        base[0] = new JRadioButton("Dec");
        base[1] = new JRadioButton("Bin");
        base[2] = new JRadioButton("Hex");
        base[3] = new JRadioButton("Oct");

        ButtonGroup group = new ButtonGroup();
        group.add(base[0]);
        group.add(base[1]);
        group.add(base[2]);
        group.add(base[3]);

        JPanel basePanel = new JPanel();
        basePanel.setLayout(new GridLayout(5,1));
        basePanel.add(base[0]);
        basePanel.add(base[1]);
        basePanel.add(base[2]);
        basePanel.add(base[3]);
        clear = new JButton("C");
        basePanel.add(clear);


        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("");
                input = "";
            }
        });

        display.setEditable(false);
        buttons[10].setEnabled(false);
        buttons[11].setEnabled(false);
        buttons[12].setEnabled(false);
        buttons[13].setEnabled(false);
        buttons[14].setEnabled(false);
        buttons[15].setEnabled(false);

        base[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttons[0].setEnabled(true);
                buttons[1].setEnabled(true);
                buttons[2].setEnabled(true);
                buttons[3].setEnabled(true);
                buttons[4].setEnabled(true);
                buttons[5].setEnabled(true);
                buttons[6].setEnabled(true);
                buttons[7].setEnabled(true);
                buttons[8].setEnabled(true);
                buttons[9].setEnabled(true);

                buttons[10].setEnabled(false);
                buttons[11].setEnabled(false);
                buttons[12].setEnabled(false);
                buttons[13].setEnabled(false);
                buttons[14].setEnabled(false);
                buttons[15].setEnabled(false);
            }
        });

        base[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttons[0].setEnabled(true);
                buttons[1].setEnabled(true);

                buttons[2].setEnabled(false);
                buttons[3].setEnabled(false);
                buttons[4].setEnabled(false);
                buttons[5].setEnabled(false);
                buttons[6].setEnabled(false);
                buttons[7].setEnabled(false);
                buttons[8].setEnabled(false);
                buttons[9].setEnabled(false);
                buttons[10].setEnabled(false);
                buttons[11].setEnabled(false);
                buttons[12].setEnabled(false);
                buttons[13].setEnabled(false);
                buttons[14].setEnabled(false);
                buttons[15].setEnabled(false);
            }
        });

        base[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttons[0].setEnabled(true);
                buttons[1].setEnabled(true);
                buttons[2].setEnabled(true);
                buttons[3].setEnabled(true);
                buttons[4].setEnabled(true);
                buttons[5].setEnabled(true);
                buttons[6].setEnabled(true);
                buttons[7].setEnabled(true);
                buttons[8].setEnabled(true);
                buttons[9].setEnabled(true);
                buttons[10].setEnabled(true);
                buttons[11].setEnabled(true);
                buttons[12].setEnabled(true);
                buttons[13].setEnabled(true);
                buttons[14].setEnabled(true);
                buttons[15].setEnabled(true);
            }
        });

        base[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttons[0].setEnabled(true);
                buttons[1].setEnabled(true);
                buttons[2].setEnabled(true);
                buttons[3].setEnabled(true);
                buttons[4].setEnabled(true);
                buttons[5].setEnabled(true);
                buttons[6].setEnabled(true);
                buttons[7].setEnabled(true);

                buttons[8].setEnabled(false);
                buttons[9].setEnabled(false);
                buttons[10].setEnabled(false);
                buttons[11].setEnabled(false);
                buttons[12].setEnabled(false);
                buttons[13].setEnabled(false);
                buttons[14].setEnabled(false);
                buttons[15].setEnabled(false);
            }
        });

        base[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("");
                int resault ;
                resault = convertToDecimal(input,currentBase);
                input = String.valueOf(resault);
                display.setText(input);
                currentBase = 10 ;
            }
        });

        base[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("");
                int resault ;
                resault = convertToDecimal(input,currentBase);
                input = Integer.toBinaryString(resault);
                display.setText(input);
                currentBase = 2 ;
            }
        });

        base[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("");
                int resault ;
                resault = convertToDecimal(input,currentBase);
                input = Integer.toHexString(resault);
                display.setText(input.toUpperCase());
                currentBase = 16;
            }
        });

        base[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("");
                int resault ;
                resault = convertToDecimal(input,currentBase);
                input = Integer.toOctalString(resault);
                display.setText(input.toUpperCase());
                currentBase = 8;
            }
        });


        base[0].setSelected(true);
        this.setLayout(new BorderLayout());
        this.add(display,BorderLayout.NORTH);
        this.add(keysPanel,BorderLayout.CENTER);
        this.add(basePanel,BorderLayout.EAST);
        this.add(keysPanel);
        this.setTitle("Convector");
        this.setVisible(true);
    }

    private class EventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            input = input.concat(((AbstractButton) e.getSource()).getText());
            display.setText(
                    input
            );

        }
    }

    private int convertToDecimal(String str, int base) {
        int v = 0;
        int total = 0;
        int pow = 0;
        str = str.toUpperCase();
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9')
                v = c - '0';
            else if (c >= 'A' && c <= 'Z')
                v = 10 + (c - 'A');
            total += v * Math.pow(base, pow);
            pow++;
        }
        return total;
    }

    public static void main(String[] args) {
        new Numeric_Converter();
    }
}