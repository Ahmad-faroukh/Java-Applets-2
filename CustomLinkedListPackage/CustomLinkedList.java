package Archive.CustomLinkedListPackage;

public class CustomLinkedList<E> {
    private int size = 0;
    private Node head = null;
    private Node tail = null;
    
    public void addAtHead(E data) {
        if(size == 0) {
            head = new Node(data);
            tail = head;
        } else {
            Node temp = head;
            head = new Node(data);
            head.next = temp;
        }
        size = size + 1;
    }
    
    public void addAtTail(E data) {
        if(size == 0) {
            tail = new Node(data);
            head = tail;
        } else {
            Node newNode = new Node (data);
            tail.next = newNode;
            tail = newNode;
        }
        size = size + 1;
    }
    
    public void addAtIndex(int index, E data) {
        if(index == 0) {
            addAtHead(data);
            size = size + 1;
        } else if(index == size - 1) {
            addAtTail(data);
            size = size + 1;
        } else {
            Node current = head;
            Node previous = null;
            
            for(int i = 0 ; i < size ; i++) {
                if(i == index - 1) {
                    previous = current;
                }
                if(i == index) {
                    Node newNode = new Node(data);
                    previous.next = newNode;
                    newNode.next = current;
                    size = size + 1;
                    break;
                }
                current = current.next;
            }
        }
    }
    
    public void deleteHead() {
        if(size == 1) {
            head = tail = null;
        } else {
            head = head.next;
        }
        size = size - 1;
    }
    
    public void deleteTail() {
        if(size == 1) {
            tail = head = null;
            size = size - 1;
        } else {
            Node current = head;
            for(int i = 0 ; i < size ; i++) {
                if(i == size - 2){
                    tail = current;
                    tail.next = null;
                    size = size - 1;
                    break;
                }
                current = current.next;
            }
        }
    }
    
    public void deleteIndex(int index) {
        if(index == 0) {
            deleteHead();
//            size = size - 1; (size decrease in already in deleteHead)
        } else if(index == size - 1){
            deleteTail();
//            size = size - 1;  (size decrease in already in deleteTail)
        } else {
            Node current = head;
            Node previous = null;
            for(int i = 0 ; i < size ; i++) {
                if(i == index - 1) {
                    previous = current;
                } 
                else if(i == index) {
                    previous.next = current.next;
                    size = size - 1;
                    break;
                }
                current = current.next;
            }
        }
    }
    public boolean contains(E data) {
        Node current = head; // to start from the head
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if (data instanceof Comparable) { // check if the class implements comparable
                if (((Comparable) current.data).compareTo(data) == 0) { // if it does ... does it equal the compared data
                    flag = true;
                    break;
                } else if (current.equals(data)) {// if the class doesnt implement comparable use equals
                    flag = true;
                    break;
                }
                current = current.next; // to loop
            }
        }
        return flag;
    }
    public void remove(E data){
        Node current = head ; // start the loop with the first item
        int index = 0 ;
        for (int i = 0; i < size; i++) { // loop through the list and check if the list has the imputed data
            if (current.data.equals(data)/*current.data.equals(data)*/){
                deleteIndex(index);// using the existed delete using index method
            }
            current = current.next ;
            index++; // to determine the data index in the list
        }
    }
}