package Archive.DataStructureStuff;

public class HashTable <E ,T> {
    int limit = 115000 ;
    int size = 0 ;
    Object [] entries ;

    public HashTable() {
        entries = new Object[limit];
    }

    public boolean put(E key , T value){
        Entry<E,T> entry = new Entry<>(key , value);
        int index = Math.abs(key.hashCode())%limit;
        for (int i = index; i < entries.length; i++) {
            if(entries[i]==null){
                entries[i]=entry;
                UpdateAfter();
                return true;
            }
        }
        return false;
    }
    public T getValue(E key){
        Entry<E,T> entry =null ;
        int index = Math.abs(key.hashCode())%limit;
        for (int i = index; i < entries.length; i++ ) {
            if(entries[i] != null){
                if (Math.abs(((Entry)entries[i]).getKey().hashCode())%limit == index ){
                    return entry.getVale();
                }
            }
        }
        return null;
    }

    public void UpdateAfter(){
        for (int i = 0; i < limit; i++) {
            if(entries[i] != null){
                Entry<E,T> temp = (Entry<E,T>)entries[i];

                for (int j = i+1; j <limit ; j++) {
                    if (entries[j] != null){
                        temp.setAfter((Entry<E,T>)entries[j]);
                    }
                }
            }
        }
    }

}