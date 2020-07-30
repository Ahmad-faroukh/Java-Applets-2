package Archive.Assignment8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;


public class invoiceController {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
         Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","");
        PreparedStatement ps = con.prepareStatement("SELECT * FROM invoice");
        ArrayList<Invoice> list = new ArrayList<>();
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            int num = rs.getInt("partNum");
            String desc = rs.getString("partDesc");
            int quantity = rs.getInt("quantity");
            double price = rs.getDouble("price");
            Invoice temp = new Invoice(num, desc, quantity, price);
            list.add(temp);
        }

        System.out.println("Sort By Dec");
        list.stream().sorted(Comparator.comparing(Invoice::getPartDescription))
                .forEach(System.out::println);
        System.out.println("====================================================");

        System.out.println("Sort By Price");
        list.stream().sorted(Comparator.comparing(Invoice::getPrice))
                .forEach(System.out::println);
        System.out.println("====================================================");

        System.out.println("Sort By Quantity");
        list.stream().sorted(Comparator.comparing(Invoice::getQuantity))
                .forEach(System.out::println);
        System.out.println("====================================================");

         list.stream().sorted(Comparator.comparing(Invoice::getValue))
                 .map(in -> in.getValue() + " : " + in.getPartDescription())
                .forEach(System.out::println);
        System.out.println("====================================================");

         System.out.println("Sorted By Value");
         list.stream().sorted(Comparator.comparing(Invoice::getValue))
                 .filter(in -> in.getValue() >= 200 && in.getValue()<=500)
                 .map(in -> String.format("%.02f : %s", in.getValue(),in.getPartDescription()))
                .forEach(System.out::println);
    }
}