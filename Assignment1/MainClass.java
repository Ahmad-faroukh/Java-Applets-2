package Archive.Assignment1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainClass {

    public static void main(String[] args) {
        ArrayList<Student> stdArray = new ArrayList<>();

        Student s1 = new ArtStudent();
        Student s2 = new ItStudent();
        Student s3 = new ItStudent();
        Student s4 = new ArtStudent();

        s1.setGrade(85);
        s2.setGrade(73);
        s3.setGrade(96);
        s4.setGrade(63);

        stdArray.add(s1);
        stdArray.add(s2);
        stdArray.add(s3);
        stdArray.add(s4);

        Collections.sort(stdArray, Comparator.comparingDouble(Student::getGrade).reversed());

        for (Student std :
                stdArray) {
            System.out.println(std.getGrade());
        }


        File file = new File("E:\\students.dat");
        FileOutputStream stream = null;
        try {
            stream = new FileOutputStream(file);
            ObjectOutputStream osStream = new ObjectOutputStream(stream);
            osStream.writeObject(stdArray);
            osStream.flush();
            osStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}