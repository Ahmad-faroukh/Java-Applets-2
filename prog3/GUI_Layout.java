package Archive.prog3;

import javax.swing.*;
import java.awt.*;

public class GUI_Layout extends JFrame {

    public GUI_Layout(){
        setSize(800,600);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.GRAY);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
//        this.setLayout(flow);
//        flow.setHgap(20);//horizontal margin
//        flow.setVgap(20);//vertical margin

        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");

        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(b4);


        GridLayout gridLayout = new GridLayout(2,2);
//        this.setLayout(gridLayout);


        //===========Border layout=========
        this.add(b1,BorderLayout.NORTH);
        this.add(b2,BorderLayout.EAST);
        this.add(b3,BorderLayout.CENTER);
        this.add(b4,BorderLayout.WEST);

        setVisible(true);
    }

    public static void main(String[] args) {
        new GUI_Layout();
    }
}