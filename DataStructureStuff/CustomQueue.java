package Archive.DataStructureStuff;

import java.util.ArrayList;

public class CustomQueue<E> {
    int size = 0 ;
    ArrayList<E> arr = new ArrayList<>();

    public void enQueue(E data){
        arr.add(data);
        size++;
    }
    public void deQueue(){
        arr.remove(0);
        size--;
    }
}