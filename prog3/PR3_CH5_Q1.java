package Archive.prog3;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PR3_CH5_Q1 {
    private static List<Integer> linkedList = new LinkedList<>();
    public static void main(String[] args) {
        for (int i = 1; i <= 25 ; i++) {
            int random = (int)(Math.random()*100);
            linkedList.add(random);
        }

        System.out.println("Linked List Before Sorting");
        System.out.println(linkedList);
        System.out.println("Linked List After Sorting");
        Collections.sort(linkedList);
        System.out.println(linkedList);

        int sum = 0;
        double avg = 0;
        for (int i = 0; i < linkedList.size(); i++) {
            sum+=linkedList.get(i);
        }
        avg = sum/linkedList.size();
        System.out.println("Sum = : "+sum);
        System.out.println("Average = : "+avg);
    }
}