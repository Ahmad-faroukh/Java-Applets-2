package Archive.DataStructureStuff;

import java.util.ArrayList;

public class CustomStack<E> {
    int size = 0 ;
    ArrayList<E> ar = new ArrayList<>();

    public void push(E data){
        ar.add(data);
        size+=1;
    }

    public void pop(){
        ar.remove(size-1);
        size-=1;
    }
}