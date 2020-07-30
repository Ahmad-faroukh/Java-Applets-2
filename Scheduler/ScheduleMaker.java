package Archive.Scheduler;

import java.util.Scanner;

public class ScheduleMaker {

    private static int CourseID = 0 ;
    private static String daysOfWeek[] = {"Sat","Sun","Mon","Tue","Wed"};

    public static void main(String[] args) {
        Student student = new Student();

        Course courses [] = new Course[30] ;
        for (int j = 0; j < 30; j++) {
            courses[j] = new Course();
        }
        Scanner scanner = new Scanner(System.in);

        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=");
        System.out.println(" Class Scheduling System ");
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=");
        System.out.println("");

        while(true){
            System.out.println("");
            System.out.println("1.Create A new Schedule Form");
            System.out.println("2.Display Schedule Form");
            System.out.println("3.Modify Schedule Form");
            System.out.println("4.Delete Schedule Form");
            System.out.println("0.Exit");
            System.out.println("");

            String mainMenu = scanner.next();

            switch(mainMenu){
                case "1" :

                    for (int j = 0; j < 30; j++) {
                        courses[j] = new Course();
                    }

                    System.out.print("Enter Student's Name : ");
                    String nameHolder = scanner.next();
                    student.setName(nameHolder);

                    System.out.print("Enter Student's ID : ");
                    String idHolder = scanner.next();
                    student.setId(idHolder);

                    System.out.print("Enter Student's Major : ");
                    String majorHolder = scanner.next();
                    student.setMajor(majorHolder);

                    System.out.print("Enter Student's Level : ");
                    String levelHolder = scanner.next();
                    student.setLevel(levelHolder);

                    System.out.println("");

                    boolean Back = false ;
                    boolean active = true ;

                    while (active){

                        System.out.print("Enter Course Number : ");
                        String courseNumberHolder = scanner.next();
                        courses[CourseID].setCourseNumber(courseNumberHolder);

                        System.out.print("Enter Course Name : ");
                        String courseNameHolder = scanner.next();
                        courses[CourseID].setCourseName(courseNameHolder);

                        System.out.print("Enter Course Room : ");
                        String courseRoomHolder = scanner.next();
                        courses[CourseID].setCourseRoom(courseRoomHolder);

                        System.out.print("Enter Course Teacher : ");
                        String courseTeacherHolder = scanner.next();
                        courses[CourseID].setCourseTeacher(courseTeacherHolder);

                        System.out.println("");

                        System.out.println("Create Schedule ?");
                        System.out.println("1.Yes");
                        System.out.println("2.No");
                        String subMenu1 = scanner.next();

                        switch (subMenu1)
                        {
                            case "1" :
                                System.out.println("Schedule Created !");
                                break;
                            case "2" :
                                Back = true ;
                                break;
                        }

                        if(Back){
                            break;
                        }

                        System.out.println("");

                        System.out.println("Choose Days (3)");
                        int daysChosen[] = new int [3];
                        int d = 0 ;
                        while (d < 3)
                        {
                            String days = scanner.next();
                            if(days.equalsIgnoreCase("Sat")||days.equalsIgnoreCase("Saturday")){
                                daysChosen[d] = 0 ;
                                d++;
                            }else if(days.equalsIgnoreCase("Sun")||days.equalsIgnoreCase("Sunday")){
                                daysChosen[d] = 1 ;
                                d++;
                            }else if (days.equalsIgnoreCase("Mon")||days.equalsIgnoreCase("Monday")){
                                daysChosen[d] = 2 ;
                                d++;
                            }else if(days.equalsIgnoreCase("Tue")||days.equalsIgnoreCase("Tuesday")){
                                daysChosen[d] = 3 ;
                                d++;
                            }else if(days.equalsIgnoreCase("Wed")||days.equalsIgnoreCase("Wednesday")){
                                daysChosen[d] = 4 ;
                                d++;
                            }else if(days.equalsIgnoreCase("Thu")||days.equalsIgnoreCase("Thursday") ||
                                    days.equalsIgnoreCase("Fri")||days.equalsIgnoreCase("Friday")){
                                System.out.println("Sorry our college does not open on thursday or friday");
                            }else{
                                System.out.println("Invalid Day");
                            }
                            if (d >1 && daysChosen[d-1] == daysChosen[d-2]) {
                                System.out.println("You cant choose the same day more than once");
                                d--;
                            }
                        }

                        System.out.println("");

                        int m = 0 ;
                        while (m < 3){
                            System.out.println("Choose the hours for :-");
                            System.out.print(daysOfWeek[daysChosen[m]]+" : ");
                            courses[CourseID].coursetime[daysChosen[m]]= scanner.next();
                            m++;
                        }
                        CourseID++;
                        System.out.println("");
                        System.out.println("Do you Wish to add another course ?");
                        System.out.println("1.Yes");
                        System.out.println("2.no");
                        String addmore = scanner.next();
                        switch(addmore){
                            case "1" :
                                active = true ;
                                break;

                            case "2" :
                                active = false ;
                                break;
                        }
                    }
                    System.out.println("");

                    break;

                case "2" :
                    System.out.print("=============================================");
                    System.out.println("=============================================");
                    System.out.println(student);
                    String x1 = "";
                    System.out.printf("%47s",x1);
                    for (int i = 0; i <5; i++) {
                        System.out.print(daysOfWeek[i]+"      ");
                    }
                    System.out.println("");
                    for (int i = 0; i < CourseID; i++) {
                        System.out.print(i+".");
                        courses[i].display();
                    }
                    System.out.print("=============================================");
                    System.out.println("=============================================");
                    break;

                case "3" :
                    boolean loop = true ;
                    while(loop){
                        System.out.println("");
                        System.out.println("1.Change The Days And Times Of a Course");
                        System.out.println("2.Edit The Course Information");
                        System.out.println("3.Add a Course");
                        System.out.println("4.Edit The Student Information");
                        System.out.println("5.Remove a Course");
                        System.out.println("0.Back");
                        String modifyMenu = scanner.next();
                        switch (modifyMenu){
                            case "1" :
                                System.out.println("Enter The Course ID You want to modify : ");
                                int idInput = scanner.nextInt();
                                for (int k = 0; k < 5; k++) {
                                    courses[idInput].coursetime[k]= "0" ;
                                }
                                System.out.println("");
                                System.out.println("Choose New Days (3) for " + courses[idInput].getCourseName());
                                int daysChosen[] = new int [3];
                                int d = 0 ;
                                while (d < 3)
                                {
                                    String days = scanner.next();
                                    if(days.equalsIgnoreCase("Sat")||days.equalsIgnoreCase("Saturday")){
                                        daysChosen[d] = 0 ;
                                        d++;
                                    }else if(days.equalsIgnoreCase("Sun")||days.equalsIgnoreCase("Sunday")){
                                        daysChosen[d] = 1 ;
                                        d++;
                                    }else if (days.equalsIgnoreCase("Mon")||days.equalsIgnoreCase("Monday")){
                                        daysChosen[d] = 2 ;
                                        d++;
                                    }else if(days.equalsIgnoreCase("Tue")||days.equalsIgnoreCase("Tuesday")){
                                        daysChosen[d] = 3 ;
                                        d++;
                                    }else if(days.equalsIgnoreCase("Wed")||days.equalsIgnoreCase("Wednesday")){
                                        daysChosen[d] = 4 ;
                                        d++;
                                    }else if(days.equalsIgnoreCase("Thu")||days.equalsIgnoreCase("Thursday") ||
                                            days.equalsIgnoreCase("Fri")||days.equalsIgnoreCase("Friday")){
                                        System.out.println("Sorry our college does not open on thursday or friday");
                                    }else{
                                        System.out.println("Invalid Day");
                                    }
                                    if (d >1 && daysChosen[d-1] == daysChosen[d-2]) {
                                        System.out.println("You cant choose the same day more than once");
                                        d--;
                                    }
                                }

                                System.out.println("");

                                int m = 0 ;
                                while (m < 3){
                                    System.out.println("Choose the hours for :-");
                                    System.out.print(daysOfWeek[daysChosen[m]]+" : ");
                                    courses[idInput].coursetime[daysChosen[m]]= scanner.next();
                                    m++;
                                }
                                break;
                            case "2" :
                                System.out.println("Enter The Course ID You want to modify : ");
                                int idInput2 = scanner.nextInt();

                                System.out.print("Enter The New Course Number : ");
                                String courseNumberHolder = scanner.next();
                                courses[idInput2].setCourseNumber(courseNumberHolder);

                                System.out.print("Enter The New Course Name : ");
                                String courseNameHolder = scanner.next();
                                courses[idInput2].setCourseName(courseNameHolder);

                                System.out.print("Enter The New Course Room : ");
                                String courseRoomHolder = scanner.next();
                                courses[idInput2].setCourseRoom(courseRoomHolder);

                                System.out.print("Enter The New Course Teacher : ");
                                String courseTeacherHolder = scanner.next();
                                courses[idInput2].setCourseTeacher(courseTeacherHolder);

                                System.out.println("");
                                break;
                            case "3" :
                                boolean active2 = true;
                                while (active2){

                                    System.out.print("Enter Course Number : ");
                                    String courseNumberHolder3 = scanner.next();
                                    courses[CourseID].setCourseNumber(courseNumberHolder3);

                                    System.out.print("Enter Course Name : ");
                                    String courseNameHolder3 = scanner.next();
                                    courses[CourseID].setCourseName(courseNameHolder3);

                                    System.out.print("Enter Course Room : ");
                                    String courseRoomHolder3 = scanner.next();
                                    courses[CourseID].setCourseRoom(courseRoomHolder3);

                                    System.out.print("Enter Course Teacher : ");
                                    String courseTeacherHolder3 = scanner.next();
                                    courses[CourseID].setCourseTeacher(courseTeacherHolder3);

                                    System.out.println("");

                                    System.out.println("Create Schedule ?");
                                    System.out.println("1.Yes");
                                    System.out.println("2.No");
                                    String subMenu1 = scanner.next();
                                    boolean back = false;
                                    switch (subMenu1)
                                    {
                                        case "1" :
                                            System.out.println("Schedule Created !");
                                            break;
                                        case "2" :
                                            back = true ;
                                            break;
                                    }
                                    if(back){
                                        break;
                                    }

                                    System.out.println("");

                                    System.out.println("Choose Days (3)");
                                    int daysChosen2[] = new int [3];
                                    int d2 = 0 ;
                                    while (d2 < 3)
                                    {
                                        String days = scanner.next();
                                        if(days.equalsIgnoreCase("Sat")||days.equalsIgnoreCase("Saturday")){
                                            daysChosen2[d2] = 0 ;
                                            d2++;
                                        }else if(days.equalsIgnoreCase("Sun")||days.equalsIgnoreCase("Sunday")){
                                            daysChosen2[d2] = 1 ;
                                            d2++;
                                        }else if (days.equalsIgnoreCase("Mon")||days.equalsIgnoreCase("Monday")){
                                            daysChosen2[d2] = 2 ;
                                            d2++;
                                        }else if(days.equalsIgnoreCase("Tue")||days.equalsIgnoreCase("Tuesday")){
                                            daysChosen2[d2] = 3 ;
                                            d2++;
                                        }else if(days.equalsIgnoreCase("Wed")||days.equalsIgnoreCase("Wednesday")){
                                            daysChosen2[d2] = 4 ;
                                            d2++;
                                        }else if(days.equalsIgnoreCase("Thu")||days.equalsIgnoreCase("Thursday") ||
                                                days.equalsIgnoreCase("Fri")||days.equalsIgnoreCase("Friday")){
                                            System.out.println("Sorry our college does not open on thursday or friday");
                                        }else{
                                            System.out.println("Invalid Day");
                                        }
                                        if (d2 >1 && daysChosen2[d2-1] == daysChosen2[d2-2]) {
                                            System.out.println("You cant choose the same day more than once");
                                            d2--;
                                        }
                                    }

                                    System.out.println("");

                                    int m2 = 0 ;
                                    while (m2 < 3){
                                        System.out.println("Choose the hours for :-");
                                        System.out.print(daysOfWeek[daysChosen2[m2]]+" : ");
                                        courses[CourseID].coursetime[daysChosen2[m2]]= scanner.next();
                                        m2++;
                                    }
                                    CourseID++;
                                    System.out.println("");
                                    System.out.println("Do you Wish to add another course ?");
                                    System.out.println("1.Yes");
                                    System.out.println("2.no");
                                    String addmore = scanner.next();
                                    switch(addmore){
                                        case "1" :
                                            active2 = true ;
                                            break;

                                        case "2" :
                                            active2 = false ;
                                            break;
                                    }
                                }

                                break;
                            case "4" :

                                System.out.print("Enter Student's Name : ");
                                String nameHolder3 = scanner.next();
                                student.setName(nameHolder3);

                                System.out.print("Enter Student's ID : ");
                                String idHolder3 = scanner.next();
                                student.setId(idHolder3);

                                System.out.print("Enter Student's Major : ");
                                String majorHolder3 = scanner.next();
                                student.setMajor(majorHolder3);

                                System.out.print("Enter Student's Level : ");
                                String levelHolder3 = scanner.next();
                                student.setLevel(levelHolder3);
                                break;

                            case "5" :
                                System.out.println("Enter The Course ID You want to Remove : ");
                                int idInput4 = scanner.nextInt();
                                System.out.println("Course " + courses[idInput4].getCourseName() + " Has been removed !");
                                courses[idInput4] = new Course();
                                CourseID--;
                                break;

                            case "0" :
                                loop = false ;
                                break;
                        }
                    }
                    break;
                case "4" :
                    System.out.println("Are you sure you want to delete the current schedule ");
                    System.out.println("1.Confirm Delete");
                    System.out.println("2.Cancel");
                    String confirmation = scanner.next();
                    switch(confirmation){
                        case "1" :
                            System.out.println("Schedule Deleted !");
                            for (int j = 0; j < 30; j++) {
                                courses[j] = new Course();
                            }
                            CourseID = 0 ;
                            break;
                        case "2" :

                            break;
                    }

                    break;
                case "0" :
                    System.out.println("Take Care :)");
                    System.exit(0);
                    break;
            }
        }

    }
}