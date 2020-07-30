package Archive.CustomLinkedListPackage;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList<Student> list = new CustomLinkedList<>();
        Student std1 = new Student();
        std1.setId(5);
        Student std2 = new Student();
        std2.setId(4);
        Student std3 = new Student();
        std1.setId(5);
        list.addAtHead(std1);
        list.addAtHead(std2);
        CustomLinkedList<String> sList = new CustomLinkedList<>();
        String ahmad = "Ahmad";
        String mohammed = "mohammed";
        sList.addAtHead(ahmad);

        System.out.println(list.contains(std1));
        System.out.println(list.contains(std3));
        System.out.println(sList.contains(ahmad));
        System.out.println(sList.contains(mohammed));
        list.remove(std1);
        System.out.println(list.contains(std1));
        sList.remove(ahmad);
        System.out.println(sList.contains(ahmad));

    }
}