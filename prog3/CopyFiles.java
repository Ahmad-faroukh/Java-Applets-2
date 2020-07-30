package Archive.prog3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class CopyFiles{

    public static void main(String[] args) throws Exception {
        File fileToCopy = new File("C:\\Users\\ACER E15\\Desktop\\Notes.txt");
        File file2 = new File("C:\\Users\\ACER E15\\Desktop\\file2.txt");
        File file3 = new File("C:\\Users\\ACER E15\\Desktop\\file3.txt");
        File fileToPasteTo = new File("C:\\Users\\ACER E15\\Desktop\\testingFile.txt");
        String textHolder="";
        String newLine = System.getProperty("line.separator");
        Scanner scanner = new Scanner(fileToCopy);
        Scanner scanner2 = new Scanner(file2);
        Scanner scanner3 = new Scanner(file3);
        while (scanner.hasNextLine()){
            textHolder = textHolder.concat(scanner.nextLine()+newLine);
        }
        while (scanner2.hasNextLine()){
            textHolder = textHolder.concat(scanner2.nextLine()+newLine);
        }
        while (scanner3.hasNextLine()){
            textHolder = textHolder.concat(scanner3.nextLine()+newLine);
        }
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fileToPasteTo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fos);
        pw.write(textHolder);
        pw.flush();
        pw.close();
    }
}