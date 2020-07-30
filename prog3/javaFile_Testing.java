package Archive.prog3;

import java.io.*;
import java.util.Scanner;

public class javaFile_Testing {

    public static void main(String[] args) throws Exception {
        File file = new File("F:/Note.txt");
        try {
            Scanner scanner = new Scanner(file);
            System.out.println(""+file.canRead());//returns a boolean if you can read from the file
            System.out.println(""+file.canWrite());//returns a boolean if you can read from the file
            System.out.println(""+file.getName());
            System.out.println(""+file.getParent());
            System.out.println(""+file.getPath());
            System.out.println(""+file.isFile());
            System.out.println(""+file.exists());




            System.out.println("====================================");
            //reads a file
            FileInputStream fis = new FileInputStream("F:/Note.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer sb = new StringBuffer();
            while (br.ready()){
                sb.append(br.readLine()+"\n");
            }
            System.out.println(sb.toString());
            System.out.println("====================================");


              //creates a new file in the path above
//            File file2 = new File("F:/NewFile.txt");
//            if (!file2.exists()){
//                try {
//                    file2.createNewFile();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }

////            writes to a file
//            FileOutputStream fos = new FileOutputStream("F:/NewFile.txt");
//            OutputStreamWriter osw = new OutputStreamWriter(fos);
//            String temp = "welcome";
//            osw.write(temp,0,temp.length());
//
//            osw.write("Welcome" , 0 ,5);
//            PrintWriter pw = new PrintWriter(fos);
//            pw.println("hello 123");
//            pw.flush();//commits the print writer
//            osw.flush();//tells the write to commit the action(has to be last line after writing)
//            fos.close();//closes the sockets
//            osw.close();
//            pw.close();



            while (scanner.hasNext()){
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        File number = new File("E:\\Java\\num.txt");
        Scanner s = null;
        try {
            s = new Scanner(number);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        s.useDelimiter(",");//changes the default separator determiner from space to commas
        int sum = 0;
        while (s.hasNext()){
            sum+=s.nextInt();
        }
        System.out.println(sum);

        System.out.println("--------------------------");

        //Writes to Random Access File
         RandomAccessFile raf = new RandomAccessFile("F:/NewFile.dat","rw");
         raf.writeInt(1);// has a Length of 4
        raf.writeUTF("Abd");//3+2 ->5 (number of chars + 2 = length in UTF)
        raf.writeInt(19);//4
        raf.writeUTF("Ahmad");//5+2=7

        raf.seek(0);
        System.out.println(raf.readInt());
        raf.seek(4);
        System.out.println(raf.readUTF());
        raf.seek(9);
        System.out.println(raf.readInt());
        raf.seek(13);
        System.out.println(raf.readUTF());



    }
}