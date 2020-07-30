package Archive.DLL;

public class DoubleLinkedList<E> {
    private int size = 0;
    private Node<E> head;
    private Node<E> tail;

    public void addAtHead(E data) {
        if(size == 0) {
            head = new Node(data);
            tail = head;
        } else {
            Node<E> newNode = new Node(data);
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        size = size + 1;
    }

    public void addAtTail(E data) {
        if(size == 0) {
            tail = new Node(data);
            head = tail;
        } else {
            Node<E> newNode = new Node(data);
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size = size + 1;
    }


    public void addAtIndex(int index, E data) {
        if(index == 0) {
            addAtHead(data);
        } else if(index == size - 1) {
            addAtTail(data);
        } else {
            Node previous = null;
            Node current = null;
            Node ref = head;

            for(int i = 0 ; i < size ; i++) {
                if(i == index - 1) {
                    previous = ref;
                }
                if(i == index) {
                    current = ref;
                    Node<E> newNode = new Node(data);

                    previous.next = newNode;
                    newNode.previous = previous;

                    current.previous = newNode;
                    newNode.next = current;

                    size = size + 1;
                    break;
                }
                ref = ref.next;
            }
        }
    }
    public void deleteIndex(int index) {
            Node<E> current = null;
            Node<E> previous = null;
            Node<E> reference = head;
            for(int i = 0 ; i < size ; i++) {
                if(i == index - 1) {
                    previous = reference;
                }
                if(i == index) {
                    current = reference;

                    previous.next = current.next;
                    current.next.previous = previous;

                    current.next = null;
                    current.previous = null;

                    size = size - 1;
                    break;
                }
                reference = reference.next;
            }
        }
    }