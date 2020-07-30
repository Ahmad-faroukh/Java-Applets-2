package Archive.prog3;

import javax.swing.*;
import java.awt.*;

public class Frame3 extends JFrame {

    public Frame3(){
        setSize(500,220);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        flowLayout.setVgap(0);
        this.setLayout(flowLayout);
        this.setResizable(false);


        JLabel printerLabel = new JLabel("Printer:MyPrinter");

        JTextField f1 = new JTextField();
        Dimension d = new Dimension(70,80);
        f1.setPreferredSize(d);

        JTextField f2 = new JTextField();
        Dimension d2 = new Dimension(50,80);
        f2.setPreferredSize(d2);

        JTextField f3 = new JTextField();
        f3.setPreferredSize(d);

        JLabel l2 = new JLabel("Print Quality:");

        JComboBox<String> box = new JComboBox<>();
        box.addItem("High");
        box.addItem("Medium");
        box.addItem("Low");
        JCheckBox checkBox1_C = new JCheckBox("Print to File");


        JPanel buttonPanel = new JPanel();
        GridLayout grid3 = new GridLayout(4,1);
        buttonPanel.setLayout(grid3);
        JButton b1b = new JButton("OK");
        JButton b2b = new JButton("Cancel");
        JButton b3b = new JButton("Setup...");
        JButton b4b = new JButton("Help");
        buttonPanel.add(b1b);
        buttonPanel.add(b2b);
        buttonPanel.add(b3b);
        buttonPanel.add(b4b);
        grid3.setVgap(10);



        JPanel midContainer = new JPanel();
        midContainer.setLayout(new GridLayout(1,1));


        JCheckBox checkBox1_A = new JCheckBox("Image");
        JCheckBox checkBox2_A = new JCheckBox("Text");
        JCheckBox checkBox3_A = new JCheckBox("Code");
        JPanel firstMenu = new JPanel();
        GridLayout gridLayout = new GridLayout(3,1);
        firstMenu.setLayout(gridLayout);
        firstMenu.add(checkBox1_A);
        firstMenu.add(checkBox2_A);
        firstMenu.add(checkBox3_A);


        JRadioButton b1 = new JRadioButton("Selection");
        JRadioButton b2 = new JRadioButton("All");
        JRadioButton b3 = new JRadioButton("Applet");
        ButtonGroup group = new ButtonGroup();
        group.add(b1);
        group.add(b2);
        group.add(b3);
        JPanel secondMenu = new JPanel();
        secondMenu.setLayout(gridLayout);
        secondMenu.add(b1);
        secondMenu.add(b2);
        secondMenu.add(b3);


        midContainer.add(f1);
        midContainer.add(firstMenu);
        midContainer.add(f2);
        midContainer.add(secondMenu);
        midContainer.add(f3);


        JPanel footer = new JPanel();
        GridLayout singleRow = new GridLayout(1,1);
        footer.setLayout(singleRow);
        footer.add(l2);
        footer.add(box);
        footer.add(checkBox1_C);


        this.add(printerLabel);
        this.add(midContainer);
        this.add(buttonPanel);
        this.add(footer);

        this.setTitle("Printer");
        setVisible(true);
    }

    public static void main(String[] args) {
        new Frame3();
    }
}