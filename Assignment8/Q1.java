package Archive.Assignment8;

import java.util.function.IntConsumer;

public class Q1 {
    
    public static String toUpper(String s){
        return s.toUpperCase();
    }
    
    interface operation<T>{
        T operation (T x);
    }
    
    interface operation2{
         void operation2();
    }

    interface math<T>{
        T sqrt (T x);
    }
    
    public static void main(String[] args) {
        
        IntConsumer intConsumer = (int value) -> System.out.printf("%d",value);
        
        System.out.println("");
        intConsumer.accept(25);
        System.out.println("");
        System.out.println(toUpper("hello !!"));
        operation2 op = () -> System.out.println("Welcome to lambdas!");
        op.operation2();

        System.out.println("=====================");

        math<Double> m = (x) -> Math.sqrt(x);
        System.out.print("Square root of 25 = ");
        System.out.println(m.sqrt(25.0));

        System.out.println("=====================");

        System.out.print("The Cube for 4 = ");
        operation<Integer> cube = (x) -> x*x*x;
        System.out.println(cube.operation(4));
    }
}