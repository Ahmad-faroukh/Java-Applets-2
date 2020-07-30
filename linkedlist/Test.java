package Archive.linkedlist;

public class Test {
    public static void main(String[] args) {
        CustomLinkedList<String> customList = new CustomLinkedList();

        ListIterator<String> listIterator = new ListIterator(customList);

        System.out.println(listIterator.fromFirst());
        System.out.println();

        customList.addAtTail("Element 1");
        System.out.println(listIterator.fromFirst());
        System.out.println();

        customList.addAtTail("Element 2");
        customList.addAtTail("Element 3");
        customList.addAtTail("Element 4");
        customList.addAtTail("Element 5");

        if(listIterator.fromFirst()) {
            while(listIterator.hasNext()) {
                System.out.println(listIterator.next());
            }
        }
        System.out.println();

        if(listIterator.fromLast()) {
            while(listIterator.hasPrevious()) {
                System.out.println(listIterator.previous());
            }
        }
    }
}