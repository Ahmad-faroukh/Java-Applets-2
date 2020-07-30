package Archive.prog3;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListCopy extends JFrame{

    public ListCopy(){
        this.setSize(400,180);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        this.setLayout(flowLayout);
        this.setResizable(false);


        DefaultListModel<String> defaultListModel = new DefaultListModel<>();
        JList<String> jList = new JList<>(defaultListModel);
        defaultListModel.addElement("Black");
        defaultListModel.addElement("Blue");
        defaultListModel.addElement("Cyan");
        defaultListModel.addElement("Dark Gray");
        defaultListModel.addElement("Gray");
        defaultListModel.addElement("Yellow");
        defaultListModel.addElement("Red");
        defaultListModel.addElement("Green");
        jList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);//to able to chose more than one element using ctrl
        JScrollPane jScrollPane = new JScrollPane(jList);
        jScrollPane.setPreferredSize(new Dimension(100,100));
        this.add(jScrollPane);

        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = jList.getSelectedIndex();
            }
        });

        JButton Print = new JButton("Copy >>>");

        TextArea textField = new TextArea();
        Dimension dimension = new Dimension(140,120);
        textField.setPreferredSize(dimension);

        Print.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        List<String> li = jList.getSelectedValuesList();
                        String txt = "";
                        for (String s :li) {
                            txt = txt.concat(s+"\n");
                        }
                        textField.setText(txt);
                        if (li.isEmpty()){
                            JOptionPane.showMessageDialog(
                                    null,"No Items Selected","Warning",JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
        );


        this.add(Print);
        this.add(textField);


        this.setTitle("Multiple Selection Lists");
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ListCopy();
    }
}