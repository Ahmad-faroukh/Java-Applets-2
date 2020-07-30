package Archive.linkedlist;

import Archive.iterator.Iterator;

public class ListIterator<E> implements Iterator{
    private CustomLinkedList<E> customLinkedList ;
    private int start ;

    public ListIterator(CustomLinkedList<E> customLinkedList) {
        this.customLinkedList = customLinkedList ;
    }

    @Override
    public boolean fromFirst() {
        if(customLinkedList.getSize() > 0) {
            start = 0;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean fromLast() {
        if(customLinkedList.getSize() > 0) {
            start = customLinkedList.getSize() - 1;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean hasNext() {
        if(start <= customLinkedList.getSize() - 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean hasPrevious() {
        if(start >= 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public E next() {
        E element = customLinkedList.get(start);
        start = start + 1;
        return element;
    }

    @Override
    public E previous() {
        E element = customLinkedList.get(start);
        start = start - 1;
        return element;
    }
}