package Archive.prog3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Temperature_Convector extends JFrame{

    public Temperature_Convector(){
        this.setSize(280,150);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Convector");
        this.setLayout(new FlowLayout(FlowLayout.CENTER));


        JLabel labelMsg = new JLabel("Enter Celsius Temperature");

        JTextField input = new JTextField(20);

        JRadioButton fahreinhiet = new JRadioButton("Fahreinhiet");
        JRadioButton kalvin = new JRadioButton("Kalvin");
        ButtonGroup group = new ButtonGroup();
        group.add(fahreinhiet);
        group.add(kalvin);

        JLabel outPut = new JLabel("New Temperature Is : ");


        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (input.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter a value","Error",JOptionPane.ERROR_MESSAGE);
                }
                double conversionResault = 0;
                if (fahreinhiet.isSelected()){
                    conversionResault = Integer.parseInt(input.getText()) * 9/5 +32;
                    outPut.setText("New Temperature Is : " + conversionResault);
                }else if (kalvin.isSelected()){
                    conversionResault = Integer.parseInt(input.getText()) +273.15;
                    outPut.setText("New Temperature Is : " + conversionResault);
                }
            }
        });


        fahreinhiet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (input.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter a value","Error",JOptionPane.ERROR_MESSAGE);
                }
                if (e.getSource()==fahreinhiet){
                    double conversionResault = 0;
                    conversionResault = Integer.parseInt(input.getText()) * 9/5 +32;
                    outPut.setText("New Temperature Is : " + conversionResault);
                }
            }
        });

        kalvin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (input.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter a value","Error",JOptionPane.ERROR_MESSAGE);
                }
                if (e.getSource()==kalvin){
                    double conversionResault = 0;
                    conversionResault = Integer.parseInt(input.getText()) +273.15;
                    outPut.setText("New Temperature Is : " + conversionResault);
                }
            }
        });



        this.add(labelMsg);
        this.add(input);
        this.add(fahreinhiet);
        this.add(kalvin);
        this.add(outPut);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Temperature_Convector();
    }
}