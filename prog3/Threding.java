package Archive.prog3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Threding extends JFrame{
    private Thread thread = new Thread();

    public synchronized void method() {
        System.out.println("");
        System.out.print("Method 1 :");
        for (int i = 0; i < 6; i++) {
            System.out.print(" "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void method2() {
        System.out.println("");
        System.out.print("Method 2 :");
        for (int i = 0; i < 6; i++) {
            System.out.print(" "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Threding (){

        JButton button = new JButton("Action 1");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("");
                for (int i = 0; i < 6; i++) {
                    System.out.print(" "+i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        JButton button1 = new JButton("Action 2");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //makes a new thread every time the button is clicked
                //if you want to make it where it cant do more
                // than one thread at a time put the new thread line outside of the button listener
                 thread = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        System.out.println("");
                        for (int i = 0; i < 6; i++) {
                            System.out.print(" "+i);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                });
                thread.start();
            }
        });


        JButton button2 = new JButton("Sync");

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Thread thread1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        method();
                    }
                });
                Thread thread2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        method2();
                    }
                });

                thread1.start();
                thread2.start();
            }
        });


        JButton button3 = new JButton("Stop Action 2");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (thread.isAlive()){
                    thread.stop();
                }
            }
        });


        setLayout( new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
        setLocationRelativeTo(null);
        this.add(button);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Threding();
    }
}