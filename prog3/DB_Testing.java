package Archive.prog3;

import java.sql.*;

public class DB_Testing {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java_db","root","");
            Statement sql = con.createStatement();
            ResultSet rs = sql.executeQuery("select * from person");
            while (rs.next()){
                System.out.println("First Name : " + rs.getString("fname") +
                        "\nLast Name : " + rs.getString("lname") + "\nAge : " + rs.getInt("age")+"\n");
            }
            int i = sql.executeUpdate("update person set age = "+19+" where id = "+2);//returns 1 if the update was done right
            System.out.println("Status " + i);
//            int j = sql.executeUpdate("insert into person (fname,lname,age) values ('nour','anwar','8')");
//            int k = sql.executeUpdate("delete from person where id = 5");

            //used to add more than one person efficiently
            PreparedStatement ps = con.prepareStatement("insert into person" + "(fname,lname,age) values (?,?,?)");

            // can be done using forloop
            ps.setString(1,"khalil");
            ps.setString(2,"omar");
            ps.setInt(3,23);
//            int ii  = ps.executeUpdate();
//            System.out.println("PS Status " + ii);
            ps.addBatch();

            ps.setString(1,"cheeki");
            ps.setString(2,"breeki");
            ps.setInt(3,69);
            ps.addBatch();
//            ps.executeBatch();//returns an array of int
        } catch (ClassNotFoundException e) {
            e.getMessage();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}