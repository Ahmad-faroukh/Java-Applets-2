package Archive.Assignment8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Q2 {
    
    public static void main(String[] args) throws  IOException {
        File file = new File("C:\\Users\\ACER E15\\Desktop\\file.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String out = "";
        int sum = 0;
        String temp = br.readLine();
        while(temp != null){
            out+=temp;
            temp = br.readLine();
        }
        String[] words = out.split(" ");
        out o = w -> w.length() ;
        for(String s : words){
              sum += o.output(s);
        }
        System.out.println(sum);
    }
    interface out{
        int output(String w);
    }
}