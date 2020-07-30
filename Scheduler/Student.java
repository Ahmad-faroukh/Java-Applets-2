package Archive.Scheduler;

public class Student extends Person{
    private String id ;
    private String major ;
    private String level ;

    public Student(){
        super();
    }

    public Student(String name, String id, String major, String level) {
        super(name);
        this.id = id;
        this.major = major;
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return"Name/ID: " + name + "/" + id + "\n" + "Major/Level: " + major + "/" + level ;
    }

}