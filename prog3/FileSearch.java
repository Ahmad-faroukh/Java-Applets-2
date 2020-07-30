package Archive.prog3;

import java.io.File;
import java.util.Scanner;

public class FileSearch {
    public static void main(String[] args)throws Exception {
        File fileToSearch = new File("C:\\Users\\ACER E15\\Desktop\\Notes.txt");
        String search="10";
        Scanner scanner = new Scanner(fileToSearch);
        while (scanner.hasNext()){
            String temp = scanner.nextLine();
            if (temp.contains(search)){
                System.out.println(temp);
            }
        }
    }
}