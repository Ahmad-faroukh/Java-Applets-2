package Archive.DataStructureStuff;

public class Node<E> {
    public E data;
    public Node next;

    public Node(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }
}