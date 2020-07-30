package Archive.doublelinkedlist;

import Archive.iterator.Iterator;

public class CDLIterator<E> implements Iterator {
    private CustomDoubleLinkedList<E> customDoubleLinkedList;
    private int start ;

    public CDLIterator(CustomDoubleLinkedList<E> customDoubleLinkedList) {
        this.customDoubleLinkedList = customDoubleLinkedList ;
    }

    @Override
    public boolean fromFirst() {
        if(customDoubleLinkedList.getSize() > 0) {
            start = 0;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean fromLast() {
        if(customDoubleLinkedList.getSize() > 0) {
            start = customDoubleLinkedList.getSize() - 1;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean hasNext() {
        if(start <= customDoubleLinkedList.getSize() - 1) {
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
        E element = customDoubleLinkedList.get(start);
        start = start + 1;
        return element;
    }

    @Override
    public E previous() {
        E element = customDoubleLinkedList.get(start);
        start = start - 1;
        return element;
    }
}