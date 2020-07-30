package Archive.prog3;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class GUI_Testing extends JFrame {

    public GUI_Testing(){
        /*
        Note how we dont need to use an Object to reach Jframe methods like in main
         */
        setTitle("Testing");
        Dimension d = new Dimension(800,600);
//        d = Toolkit.getDefaultToolkit().getScreenSize();
//        setSize(d);                 sets the window to full screen
        setSize(800,600);
        setLocationRelativeTo(null);//to center the Frame
        getContentPane().setBackground(Color.GRAY);

        JLabel jL = new JLabel();
        jL.setText("Hello");
        Font myFont = new Font(Font.SANS_SERIF,Font.BOLD | Font.ITALIC,32);//the Or sign ( | ) is to add multiple options
        jL.setForeground(Color.yellow);
        getContentPane().add(jL);
        jL.setVerticalAlignment(SwingConstants.TOP);//controls the label position in relation to the window
        jL.setHorizontalAlignment(SwingConstants.CENTER);//controls the label position in relation to the window


        ImageIcon myImg = new ImageIcon(GUI_Testing.class.getResource("avatar.jpg"));
        jL.setIcon(myImg);
        jL.setHorizontalTextPosition(SwingConstants.CENTER);//controls the img location in relation to the Label
        jL.setVerticalTextPosition(SwingConstants.BOTTOM);//controls the img location in relation to the Label


        JButton jB = new JButton("Print Text");
        jB.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Some Text");//prints text in the console
                        JOptionPane.showMessageDialog(GUI_Testing.this,"Title");
                    }
                }
        );

        getContentPane().add(jB);//adds the button to the window
        setLayout(new FlowLayout());//sets all the elements next to each other and if the there is no room it puts it into a new line

        JButton button2 = new JButton("change Background Color");
        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        getContentPane().setBackground(Color.GREEN);
                    }
                }
        );

        getContentPane().add(button2);

        JButton end = new JButton("Close Program");
        end.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int temp = JOptionPane.showConfirmDialog(GUI_Testing.this,"End Program ?");
                        if(temp==0){
                            System.exit(0);
                        }else if (temp==1){

                        }
                    }
                }
        );
        getContentPane().add(end);


        JTextField txt = new JTextField();
        txt.setColumns(20);//the width of the text field
        txt.setToolTipText("Text Field");//This text will show when you hover over the text field
        this.add(txt);
        TextArea txtarea= new TextArea();
        this.add(txtarea);

        JComboBox<String> box = new JComboBox<>();
        box.addItem("Select Your Age");
        box.addItem("Age is 10");
        box.addItem("Age is 20");
        box.addItem("Age is 30");
        box.addItem("Age is 40");
        this.add(box);
        box.setSelectedIndex(0);


        DefaultListModel<String> defaultListModel = new DefaultListModel<>();//similar to an arrayList
        JList<String> jList = new JList<>(defaultListModel);
//        jList.setPreferredSize(new Dimension(100,100));
//        this.add(jList);//dont need to add it by it self (add the scroll pane)
        defaultListModel.addElement("Name1");
        defaultListModel.addElement("Name2");
        defaultListModel.addElement("Name3");
        defaultListModel.addElement("Name4");
        defaultListModel.addElement("Name5");
        defaultListModel.addElement("Name6");
        defaultListModel.addElement("Name7");
        defaultListModel.addElement("Name8");
        jList.setSelectionMode(1);//to able to chose more than one element using ctrl
        JScrollPane jScrollPane = new JScrollPane(jList);
        jScrollPane.setPreferredSize(new Dimension(100,100));
        this.add(jScrollPane);

        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = jList.getSelectedIndex();
            }
        });

        JButton Print = new JButton("Print List Element");
        Print.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int indices[]= jList.getSelectedIndices();
                        List<String> li = jList.getSelectedValuesList();
                        for (String s :li) {
                            System.out.println(s);
                        }
                    }
                }
        );
        getContentPane().add(Print);


        JPopupMenu jpm = new JPopupMenu();
        JMenuItem item = new JMenuItem("Save");
        JMenuItem item2 = new JMenuItem("Settings");
        item2.setIcon(new ImageIcon(GUI_Testing.class.getResource("ToastIcon.png")));
        item.setMnemonic('s');
        jpm.add(item);

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        jpm.add(separator);
        jpm.add(item2);


        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("SAVED");
            }
        });

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton()==3){//Right Click
                    jpm.show(GUI_Testing.this,e.getX(),e.getY());
                }else if (e.getButton()==1){//Left Click

                }// 2 would be Middle Mouse Click
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//closes the window on exit and doesn't leave it running in the background.


        setVisible(true);//make sure that this is the last line (this will fix the bug where the elements wont show up unless if you resize)


    }

    public static void main(String[] args) {
//        JFrame f = new JFrame();//makes an object to able to use in the Main Method
//        f.setTitle("Testing");
//        f.setSize(800,600);
//        Dimension d = new Dimension(800,600);//a java object for dimensions (you can use in setSize)
//        f.setLocationRelativeTo(null);//Makes the Window appear in the center of the screen
//        f.setVisible(true);//the window is invisible by default
//        f.getContentPane().setBackground(Color.GRAY);//sets the Background color of the Pane to gray

        new GUI_Testing();//calls the constructor
    }
}