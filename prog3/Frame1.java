package Archive.prog3;

import javax.swing.*;
import java.awt.*;

public class Frame1 extends JFrame{

    public Frame1(){
        setSize(300,135);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        this.setLayout(flowLayout);
        flowLayout.setHgap(15);
        this.setResizable(false);


        JPanel jPanel_1 = new JPanel();
        jPanel_1.setLayout(new GridLayout(2,1));
        JCheckBox checkBox1 = new JCheckBox("Snap To Grid");
        JCheckBox checkBox2 = new JCheckBox("Show Grid");
        jPanel_1.add(checkBox1);
        jPanel_1.add(checkBox2);


        JPanel jPanel_2 = new JPanel();
        GridLayout grid2 = new GridLayout(2,2);
        grid2.setVgap(8);
        jPanel_2.setLayout(grid2);
        JLabel label_1 = new JLabel("X:");
        JTextField field1 = new JTextField();
        Dimension d2 = new Dimension(30,25);
        field1.setPreferredSize(d2);
        JLabel label_2 = new JLabel("Y:");
        JTextField field2 = new JTextField();
        field2.setPreferredSize(d2);
        jPanel_2.add(label_1);
        jPanel_2.add(field1);
        jPanel_2.add(label_2);
        jPanel_2.add(field2);


        JPanel jPanel_3 = new JPanel();
        GridLayout grid3 = new GridLayout(3,1);
        jPanel_3.setLayout(grid3);
        JButton b1 = new JButton("OK");
        JButton b2 = new JButton("Cancel");
        JButton b3 = new JButton("Help");
        jPanel_3.add(b1);
        jPanel_3.add(b2);
        jPanel_3.add(b3);
        grid3.setVgap(7);

        this.add(jPanel_1);
        this.add(jPanel_2);
        this.add(jPanel_3);


        this.setTitle("Align");
        setVisible(true);

    }


    public static void main(String[] args) {
        new Frame1();
    }
}