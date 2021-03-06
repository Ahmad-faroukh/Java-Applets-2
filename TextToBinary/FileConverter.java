
package Archive.TextToBinary;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileConverter extends javax.swing.JFrame {

    File textFile = new File("E:\\Java\\WIP\\src\\Draft\\TextToBinary\\TextFile.txt");
    
    File binaryFile = new File("E:\\Java\\WIP\\src\\Draft\\TextToBinary\\BinaryFile.dat");

    public FileConverter() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toBinary = new javax.swing.JButton();
        toText = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        toBinary.setText("convert to Binary");
        toBinary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionToBinary(evt);
            }
        });

        toText.setText("convert to textFile");
        toText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionToText(evt);
            }
        });

        area.setEditable(false);
        area.setColumns(20);
        area.setLineWrap(true);
        area.setRows(5);
        area.setWrapStyleWord(true);
        jScrollPane1.setViewportView(area);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toText, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toBinary))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(toBinary)
                .addGap(18, 18, 18)
                .addComponent(toText)
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void actionToBinary(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionToBinary
        try {
            FileReader reader = new FileReader(textFile);
            BufferedReader br = new BufferedReader(reader);
            String out = "";
            for(String line = br.readLine();line != null;line = br.readLine()){
                out += line+"\n";
            }
            FileOutputStream fos = new FileOutputStream(binaryFile);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeChars(out);
            dos.close();
            fos.close();
            area.setText("Text Converted to Binary : \n"+out);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileConverter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileConverter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_actionToBinary

    private void actionToText(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionToText
        try {
            FileInputStream fi = new FileInputStream(binaryFile);
            DataInputStream di = new DataInputStream(fi);
            String x = "";
            String y = "";
            for (int i = di.read(); i != -1; i = di.read()) {
                y += i;
                x+= (char) i;
            }
            area.setText("Binary Converted To Text :\n"+y);
            FileOutputStream fos = new FileOutputStream(textFile);
            
            Formatter formatter = new Formatter(fos);
            formatter.format("%s\n", x);
            formatter.close();
            fos.close();

            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileConverter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileConverter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_actionToText

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FileConverter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FileConverter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FileConverter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FileConverter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FileConverter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton toBinary;
    private javax.swing.JButton toText;
    // End of variables declaration//GEN-END:variables
}