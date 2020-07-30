package Archive.prog3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class PR3_Quiz {
    public static void writeToFile(String pathName)throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter File Name");
        String fileName = scanner.nextLine();
        fileName = fileName.concat(".txt");
        String filePath = pathName.concat("\\"+fileName);
        File file = new File(filePath);
        if (file.exists()){
            System.out.println("File Does Exist");
            System.out.println("Enter Text To Write To File");
            String temp ="";
            String text = "";
            while(!temp.toLowerCase().equals("end")){
                temp = scanner.nextLine();
                text = text.concat(temp);
            }
            FileOutputStream fos = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(fos);
            pw.println(text);
            pw.flush();
            fos.close();
            pw.close();
        }else{
            file.createNewFile();
            System.out.println("File Does Not Exist . new file created");
            System.out.println("Enter Text To Write To File");
            String temp ="";
            String text = "";
            while(!temp.toLowerCase().equals("end")){
                 temp = scanner.nextLine();
                 text = text.concat(temp);
            }
            FileOutputStream fos = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(fos);
            pw.println(text);
            pw.flush();
            fos.close();
            pw.close();
        }
    }

    public static void readFromFile(String pathName)throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter File Name");
        String fileName = scanner.nextLine();
        fileName = fileName.concat(".txt");
        String filePath = pathName.concat("\\"+fileName);
        File file = new File(filePath);
        if (file.exists()){
            System.out.println("File Does Exist and Contains :-");
            String text = "";
            Scanner s = new Scanner(file);
            while(s.hasNext()){
                text = s.nextLine();
                System.out.println(text);
            }
        }else{
            System.out.println("File Does not Exist");
        }
    }

    public static void reverseFileContent(String pathName)throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter File Name");
        String fileName = scanner.nextLine();
        fileName = fileName.concat(".txt");
        String filePath = pathName.concat("\\"+fileName);
        File file = new File(filePath);
        if (file.exists()){
            String text = "";
            Scanner s = new Scanner(file);
            while(s.hasNext()){
                text = s.nextLine();
                text = text.concat(text);
            }
            String reversedString = "";
            for (int i = text.length()-1; i >=0; i--) {
                char x = text.charAt(i);
                reversedString = reversedString.concat(Character.toString(x));
            }
            System.out.println(reversedString);
        }else{
            System.out.println("File Does not Exist");
        }
    }

    public static void fileCount (String pathName)throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter File Name");
        String fileName = scanner.nextLine();
        fileName = fileName.concat(".txt");
        String filePath = pathName.concat("\\"+fileName);
        File file = new File(filePath);
        if (file.exists()){
            Scanner s = new Scanner(file);
            int line = 0 ;
            int charCount = 0 ;
            String temp1 = "";
            while (s.hasNext()){
                temp1 = s.nextLine();
                temp1.concat(temp1);
                line++;
            }
            charCount = temp1.length();
            int wordCount = 0;
            Scanner s2 = new Scanner(file);
            String temp2;
            while (s2.hasNext()){
                temp2 = s2.next();
                wordCount++;
            }

            System.out.println("File has " + line + " Lines");
            System.out.println("File has " + wordCount + " Words");
            System.out.println("File has " + charCount + " Characters");

        }else{
            System.out.println("File Does not Exist");
        }
    }

    public static void search(String pathName)throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter File Name");
        String fileName = scanner.nextLine();
        fileName = fileName.concat(".txt");
        String filePath = pathName.concat("\\"+fileName);
        File file = new File(filePath);
        System.out.println("Enter Text To Search For");
        String textToSearch = scanner.nextLine();
        if (file.exists()){
            Scanner s = new Scanner(file);
            int line = 1 ;
            while (s.hasNext()){
                String temp = s.nextLine();
                if (temp.contains(textToSearch)){
                    System.out.println("Text Can be Found in Line : "+line);
                }
                line++;
            }
        }else{
            System.out.println("File Does not Exist");
        }
    }

    public static void main(String[] args)throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Folder Path");
        String folderPath = scanner.nextLine();

        while (true){
            System.out.println("Enter 1 To Write To File");
            System.out.println("Enter 2 To Read From File");
            System.out.println("Enter 3 To Reverse The content of the file");
            System.out.println("Enter 4 To Print the number of words , lines , chars in the file");
            System.out.println("Enter 5 To Search");
            System.out.println("Enter 0 To Exit");
            int count = scanner.nextInt();
            switch (count){
                case 1 :
                    writeToFile(folderPath);
                    break;
                case 2 :
                    readFromFile(folderPath);
                    break;
                case 3 :
                    reverseFileContent(folderPath);
                    break;
                case 4 :
                    fileCount(folderPath);
                    break;
                case 5 :
                    search(folderPath);
                    break;
                case 0 :
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }
}