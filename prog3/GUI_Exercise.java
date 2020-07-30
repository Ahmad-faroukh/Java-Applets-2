package Archive.prog3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Exercise extends JFrame{

    public GUI_Exercise(){
        this.setSize(280,150);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Choose Icon");
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        getContentPane().setBackground(Color.GRAY);


        JComboBox<String> comboBox = new JComboBox<>();


        comboBox.addItem("Icon 1");
        comboBox.addItem("Icon 2");
        comboBox.addItem("Icon 3");

        comboBox.setMaximumRowCount(5);

        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(GUI_Testing.class.getResource("ToastIcon.png")));

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = comboBox.getSelectedIndex();
                if (index==0){
                    label.setIcon(new ImageIcon(GUI_Testing.class.getResource("ToastIcon.png")));
                }else if (index==1){
                    label.setIcon(new ImageIcon(GUI_Testing.class.getResource("HelloFaceToastIcon.png")));
                }else if (index==2){
                    label.setIcon(new ImageIcon(GUI_Testing.class.getResource("UpdateToastIcon.png")));
                }
            }
        });

        this.add(comboBox);
        this.add(label);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI_Exercise();
    }
}