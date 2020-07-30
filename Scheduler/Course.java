package Archive.Scheduler;

public class Course implements MethodList{
    private String courseNumber ;
    private String courseName ;
    private String courseRoom ;
    private String courseTeacher ;
    String coursetime[] = new String [5];

    public void display(){
        System.out.printf("%8s\t%8s\t%8s\t%8s\t",courseNumber , courseName , courseRoom , courseTeacher );
        for (int i = 0; i <5; i++) {
            System.out.printf("%5s", coursetime[i] +"\t");
        }
        System.out.println("");
    }

    public Course(){

        for (int i = 0; i <5; i++) {
            coursetime[i] = "-" ;
        }
    }

    public Course(String courseNumber, String courseName, String courseRoom, String courseTeacher) {

        for (int i = 0; i <5; i++) {
            coursetime[i] = "-" ;
        }

        this.courseNumber = courseNumber;
        this.courseName = courseName;
        this.courseRoom = courseRoom;
        this.courseTeacher = courseTeacher;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseRoom() {
        return courseRoom;
    }

    public void setCourseRoom(String courseRoom) {
        this.courseRoom = courseRoom;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    public String[] getCoursetime() {
        return coursetime;
    }

    public void setCoursetime(String[] coursetime) {
        this.coursetime = coursetime;
    }

}