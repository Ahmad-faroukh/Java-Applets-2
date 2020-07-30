package Archive.DataStructureStuff;

import java.util.Arrays;

public class CustomizedArrayList {

    private int size = 0;
    private int elements[];
    private static final int DEFAULT_CAPACITY = 1;

    public CustomizedArrayList() {
        elements = new int[DEFAULT_CAPACITY];
    }

    public void add(int integer) {
        if (size == 0) {
            elements[0] = integer;
            size = 1;
        } else {
            size = size + 1;
            elements = Arrays.copyOf(elements, size);
            elements[size - 1] = integer;
        }
    }
    
    public int get(int index) {
        return elements[index];
    }
    
    public void remove(int index) {
        int j = index + 1;
        for(int i = index ; j < elements.length ; i++) {
            elements[i] = elements[j];
            j = j + 1;
        }
        size = size - 1;
        elements = Arrays.copyOf(elements, size);
    }
    
    public boolean contains(int integer) {
        for(int i = 0 ; i < elements.length ; i++) {
            if (elements[i] == integer) {
                return true;
            }
        }
        
        return false;
    }
    
    public int size() {
        return size;
    }
    
    public static void main(String[] args) {
        CustomizedArrayList c = new CustomizedArrayList ();
        c.add(5);
        c.add(6);
        c.add(7);
        
        System.out.println(c.get(2));
        System.out.println(c.size());
        
        c.remove(1);
        System.out.println(c.get(1));
        System.out.println(c.size());
    }
}
