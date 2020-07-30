package Archive.prog3;

import javax.swing.*;

public class Employee_Jop {
    private String name;
    private String department;
    private double salary;
    public static int count = 0;

    public Employee_Jop() {
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
    public void setSalary(double salary, double bonus) {
        this.salary = salary * bonus;

    }

    public static void main(String[] args) {

        Employee[] Employees = new Employee[2];

        for (int i = 0; i < Employees.length; i++) {
            Employees[i] = new Employee();
        }

        //takes input using JoptionePane
        for (int i = 0; i < Employees.length; i++) {
            Employees[i].setName(JOptionPane.showInputDialog("Enter Name"));
            Employees[i].setDepartment(JOptionPane.showInputDialog("Enter Department"));
            Employees[i].setSalary(Double.parseDouble(JOptionPane.showInputDialog("Enter Salary")));
        }

        //sorts the Employees by name
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

        //a header for the Employees table
        String header;
        header = String.format("%-15s%-15s%-15s","Name","Department","Salary");

        //creates a string for the Employees data
        String data ="";
        for (int i = 0; i < Employees.length; i++) {
            data = data + String.format("\n"+
                    "%-15s%-15s%-15s",
                    Employees[i].getName(),
                    Employees[i].getDepartment(),
                    Employees[i].getSalary());
        }

        String table = header+data;

        JOptionPane.showMessageDialog(null,table);
    }
}