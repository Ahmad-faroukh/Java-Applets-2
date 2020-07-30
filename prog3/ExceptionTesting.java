package Archive.prog3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTesting {
    public static void main(String[] args) {
        int num1,num2;
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter num1");
            num1 = scanner.nextInt();
            System.out.println("Enter num1");
            num2 = scanner.nextInt();

            int array[] = new int[4];
            System.out.println(array[6]);

            System.out.println("sum= " + num1 / num2);
        }catch (InputMismatchException mm){
            System.out.println(mm);
        }catch (ArithmeticException ae){
            System.err.println("ArithmeticException");
        }catch (ArrayIndexOutOfBoundsException obe){
            System.out.println("out of bounders ");
        }
        finally {
            //used to close any opened stuff
            //finally will always be excited no matter what
        }
        myException ex = new myException() ;

        try {
            ex.MaxVal(500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            ex.minVal(10);
        } catch (Exception e) {
            System.out.println("value less than 20");
        }

        try {
            ex.test();
        } catch (myException e) {
            System.out.println(e.getMessage());
        }
    }
}