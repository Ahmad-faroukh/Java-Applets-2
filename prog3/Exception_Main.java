package Archive.prog3;

import java.io.IOException;

public class Exception_Main {

    public static void main(String[] args) {
        ExceptionA a = new ExceptionA();
        ExceptionB b = new ExceptionB();
        ExceptionC c = new ExceptionC();

        try {
            a.ExceptionA_Thrower();
            b.ExceptionB_Thrower();
            c.ExceptionC_Thrower();
        } catch (ExceptionA exceptionA) {
            System.out.println(exceptionA.getMessage());
        }

        try{
            a.ExceptionA_Thrower();
            b.ExceptionB_Thrower();
            IOE_Thrower();
            throw new NullPointerException();
        } catch (ExceptionB exceptionB) {
            System.out.println("ErrorB : " +exceptionB.getMessage());
        } catch (ExceptionA exceptionA) {
            System.out.println("ErrorA : " + exceptionA.getMessage());
        } catch (IOException iOE){
            System.out.println("Error iOE : " + iOE.getMessage());
        } catch (NullPointerException nPE) {
            System.out.println(nPE.getMessage());
        }

        try {
            someMethod();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void IOE_Thrower() throws IOException{
        throw new IOException("IOException has been thrown");
    }

    private static void someMethod() throws Exception{
        try {
            someMethod2();
        } catch (Exception e) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private static void someMethod2()throws Exception{
        throw new ArrayIndexOutOfBoundsException();
    }
}