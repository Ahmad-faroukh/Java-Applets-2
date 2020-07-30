package Archive.prog3;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class PR3_CH5_Q3 {

    public static void main(String[] args) throws  IOException {

        HashMap<String, Integer> hashMap = new HashMap();

        File file = new File("C:\\Users\\ACER E15\\Desktop\\TextFile.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String wordToSearch = scanner.next();

            Integer x = hashMap.get(wordToSearch);
            if (x == null) {
                hashMap.put(wordToSearch, 1);
            } else {
                hashMap.put(wordToSearch, x + 1);
            }


            for (int j = 0; j < wordToSearch.length(); j++) {

                Character character = wordToSearch.charAt(j);

                Integer y = hashMap.get(character.toString());
                if (y == null) {
                    hashMap.put(character.toString(), 1);
                } else {
                    hashMap.put(character.toString(), y + 1);
                }
            }

        }
        System.out.println(hashMap);
    }
}