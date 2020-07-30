package Archive.Assignment1;

public class ItStudent extends Student {


    @Override
    public void calculateGrade(double mid, double project, double finalGrade) {
        this.setGrade(mid*0.30 + project*0.30 + finalGrade*0.40);
    }
}