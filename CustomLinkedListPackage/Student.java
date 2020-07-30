package Archive.CustomLinkedListPackage;

public class Student implements Comparable <Student> {
    int id;
    String name;
    double avg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    @Override
    public int compareTo(Student o) {
        if(this.getId()<o.getId()){
            return -1 ;
        }else if(this.getId()>o.getId()){
            return 1;
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        Student std1 = new Student();
        std1.setId(5);
        Student std2 = new Student();
        std2.setId(5);
        System.out.println(std1.compareTo(std2));
    }
}