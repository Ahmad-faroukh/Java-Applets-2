package Archive.Assignment1;

import java.io.Serializable;

public abstract class Student implements Serializable {
    private int id;
    private String name;
    private String major;
    private double grade;

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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }


    public void calculateGrade(double mid , double project , double finalGrade){ }
}