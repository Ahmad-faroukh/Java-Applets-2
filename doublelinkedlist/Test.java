package Archive.doublelinkedlist;

public class Test {
    public static void main(String[] args) {
        CustomDoubleLinkedList<String> customDoubleLinkedList = new CustomDoubleLinkedList();

        CDLIterator<String> doubleLinkedListIterator = new CDLIterator(customDoubleLinkedList);

        System.out.println(doubleLinkedListIterator.fromFirst());
        System.out.println();

        customDoubleLinkedList.addAtTail("Element 1");
        System.out.println(doubleLinkedListIterator.fromFirst());
        System.out.println();

        customDoubleLinkedList.addAtTail("Element 2");
        customDoubleLinkedList.addAtTail("Element 3");
        customDoubleLinkedList.addAtTail("Element 4");
        customDoubleLinkedList.addAtTail("Element 5");

        if(doubleLinkedListIterator.fromFirst()) {
            while(doubleLinkedListIterator.hasNext()) {
                System.out.println(doubleLinkedListIterator.next());
            }
        }
        System.out.println();

        if(doubleLinkedListIterator.fromLast()) {
            while(doubleLinkedListIterator.hasPrevious()) {
                System.out.println(doubleLinkedListIterator.previous());
            }
        }
    }
}