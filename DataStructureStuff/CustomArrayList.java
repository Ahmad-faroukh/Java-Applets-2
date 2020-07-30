package Archive.DataStructureStuff;

import java.util.Arrays;

public class CustomArrayList<E> {
    private int size = 0;
    private Object elements[];
    private static final int DEFAULT_CAPACITY = 1;
    
    public CustomArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    
    public void add(E object) {
        if (size == 0) {
            elements[0] = object;
            size = 1;
        } else {
            size = size + 1;
            elements = Arrays.copyOf(elements, size);
            elements[size - 1] = object;
        }
    }
    
    public E get(int index) {
        return (E) elements[index];
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
    
    public int size() {
        return size;
    }
}
