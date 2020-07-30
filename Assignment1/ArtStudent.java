package Archive.Assignment1;

public class ArtStudent extends Student{

    @Override
    public void calculateGrade(double mid, double report, double finalGrade) {
        this.setGrade(mid*0.40 + report*0.10 + finalGrade*0.50);
    }
}