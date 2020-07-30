package Archive.prog3;

import java.util.Scanner;

public class Employee {
    private String name ;
    private String department;
    private double salary;
    public static int count =0;

    public Employee() {
        count++;
        /*increments the Employee count by 1 each
        time an instance is created
         */
    }

    public static int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    //takes a salary bonus argument as percentage
    public void setSalary(double salary ,double bonus) {
        this.salary = salary*bonus;
    }

    public static void main(String[] args) {
        Employee[] Employees = new Employee[10];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < Employees.length; i++) {
            Employees[i] = new Employee();
        }

        //a simple menu to access the methods
        while (true){
            System.out.println("");
            System.out.println("Select an operation");
            System.out.println("1.Enter Employee's Info Using a Scanner");
            System.out.println("2.Sort The Employees By Salary");
            System.out.println("3.Sort The Employees By Name");
            System.out.println("4.Print The Employees Data");
            System.out.println("5.Print The Employees Count");
            System.out.println("0.Exit");
            System.out.println("");

            System.out.print("Option ID : ");
            int input = scanner.nextInt();
            switch (input){
                //takes the Employees info using a scanner
                case 1 :
                    for (int i = 0; i < Employees.length; i++) {
                        System.out.print("Enter The Employee's ["+i+"] Name : ");
                        Employees[i].setName(scanner.next());
                        System.out.print("Enter The Employee's ["+i+"] Department : ");
                        Employees[i].setDepartment(scanner.next());
                        System.out.print("Enter The Employee's ["+i+"] Salary : ");
                        Employees[i].setSalary(scanner.nextDouble());
                    }
                    break;

                //sorts the Employees by Salary
                case 2 :
                    Employee temp;
                    for (int i = 0; i < Employees.length; i++) {
                        for (int j = 0; j < Employees.length; j++) {
                            if (Employees[i].getSalary() > Employees[j].getSalary()) {
                                temp = Employees[i];
                                Employees[i]=Employees[j];
                                Employees[j]=temp;
                            }
                        }
                    }
                    break;

                //sorts the Employees by name
                case 3 :
                    Employee temp2;

                    for (int i = 0; i < Employees.length; i++) {
                        for (int j = 0; j < Employees.length; j++) {
                            if (Employees[i].getName().toLowerCase().charAt(0) < Employees[j].getName().toLowerCase().charAt(0)) {
                                temp2 = Employees[i];
                                Employees[i]=Employees[j];
                                Employees[j]=temp2;
                            }
                        }
                    }
                    break;

                    //prints the Data in a Table Form
                case 4 :
                    System.out.println("===========================================");
                    System.out.printf("%-15s%-15s%-15s","Name","Department","Salary");
                    System.out.println("");
                    for (int i = 0; i < Employees.length; i++) {
                        System.out.println(String.format(
                                "%-15s%-15s%-15s",
                                Employees[i].getName(),
                                Employees[i].getDepartment(),
                                Employees[i].getSalary()));
                    }
                    System.out.println("===========================================");

                    break;

                case 5 :
                    System.out.println(count);
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }
}