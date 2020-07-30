package Archive.Scheduler;

public interface MethodList {
     void display();

     String getCourseNumber();
    void setCourseNumber(String courseNumber);
    String getCourseName();
    void setCourseName(String courseName);
    String getCourseRoom();
    void setCourseRoom(String courseRoom);
    String getCourseTeacher();
    void setCourseTeacher(String courseTeacher);
    String[] getCoursetime();
    void setCoursetime(String[] coursetime);
}