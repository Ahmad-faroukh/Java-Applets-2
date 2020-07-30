package Archive.DataStructureStuff;

public class Entry<E , T> {
    E key ;
    T vale;
    Entry<E,T> after ;

    public Entry<E, T> getAfter() {
        return after;
    }

    public void setAfter(Entry<E, T> after) {
        this.after = after;
    }

    public Entry(E key, T vale) {
        this.key = key;
        this.vale = vale;
    }

    public E getKey() {
        return key;
    }

    public void setKey(E key) {
        this.key = key;
    }

    public T getVale() {
        return vale;
    }

    public void setVale(T vale) {
        this.vale = vale;
    }
}