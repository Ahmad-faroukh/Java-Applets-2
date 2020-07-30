
package Archive.arraylist;


public class Main {
    public static void main(String[] args) {
        CustomArrayList<String> arrayList = new CustomArrayList();
        
        CustomArrayListIterator<String> arrayListIterator = new CustomArrayListIterator(arrayList);
        
        System.out.println(arrayListIterator.fromFirst());
        System.out.println();
        
        arrayList.add("Element 1");
        System.out.println(arrayListIterator.fromFirst());
        System.out.println();
        
        arrayList.add("Element 2");
        arrayList.add("Element 3");
        arrayList.add("Element 4");
        arrayList.add("Element 5");
        
        if(arrayListIterator.fromFirst()) {
            while(arrayListIterator.hasNext()) {
                System.out.println(arrayListIterator.next());
            }
        }
        System.out.println();
        
        if(arrayListIterator.fromLast()) {
            while(arrayListIterator.hasPrevious()) {
                System.out.println(arrayListIterator.previous());
            }
        }
    }
}