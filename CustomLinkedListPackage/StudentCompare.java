package Archive.CustomLinkedListPackage;

import java.util.Comparator;

public class StudentCompare implements Comparator<Student>{

    public static void main(String[] args) {
        Student std1 = new Student();
        std1.setAvg(5);
        Student std2 = new Student();
        std2.setAvg(4);
        StudentCompare x1 = new StudentCompare();
        System.out.println(x1.compare(std1,std2));
    }

    @Override
    public int compare(Student s1, Student s2) {
        if(s1.getAvg()>s2.getAvg()){
            return 1;
        }else if(s1.getAvg()<s2.getAvg()){
            return -1;
        }else{
            return 0;
        }
    }
}