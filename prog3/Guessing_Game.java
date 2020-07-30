package Archive.prog3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Guessing_Game extends JFrame{

    private int number;

    public Guessing_Game(){
        this.setSize(280,150);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Guessing Game");
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        number = (int) (Math.random() * 100);

        JLabel l1 = new JLabel("i have a number between 1 and 100.");
        JLabel l2 = new JLabel("Can you guess my number ?");
        JLabel msg = new JLabel("Enter your guess in here : ");
        JTextField input = new JTextField(4);
        msg.setLabelFor(input);
        JButton reset = new JButton("New Game");


        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Integer.parseInt(input.getText())==number){
                    msg.setText("Correct !! You Guessed It");
                    getContentPane().setBackground(Color.GREEN);
                    input.setEditable(false);
                } else if (Integer.parseInt(input.getText())>number){
                    msg.setText("Too High.Try a lower number");
                    getContentPane().setBackground(Color.RED);
                } else if (Integer.parseInt(input.getText())<number){
                    msg.setText("Too Low.Try a higher number");
                    getContentPane().setBackground(Color.BLUE);
                }
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==reset){
                    number = (int) (Math.random() * 100);
                    msg.setText("Enter your guess in here : ");
                    input.setText("");
                    input.setEditable(true);
                    getContentPane().setBackground(Color.white);
                }
            }
        });

        this.add(l1);
        this.add(l2);
        this.add(msg);
        this.add(input);
        this.add(reset);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Guessing_Game();
    }
}