package W1.lab;

import java.util.Scanner;
import java.io.*;

public class Q2 {
    public static void main(String[] args) {
        String filename = "";
        for (int i = 1; i <= 4; i++){
            System.out.println();
            filename = String.format("/Users/wenghong/Library/CloudStorage/OneDrive-UniversitiMalaya/UM/WIA 1002/W1/lab/text%d.txt", i);
            String pattern = "";
            switch(i) {
                case 1 -> pattern = ",";
                case 2 -> pattern = ", ";
                case 3 -> pattern = "; ";
                case 4 -> pattern = "\\d";
            }

            try {
                Scanner sc = new Scanner(new FileInputStream(filename));
                int charCount = 0;
                String finalLine = "";
                while (sc.hasNextLine()){
                    String line = sc.nextLine();
                    if (i <= 3){
                        String[] words = line.split(pattern);
                        finalLine = String.join("", words);
                    } else {
                        String words = line.replaceAll(pattern, "");
                        finalLine = words;
                    }
                    charCount += finalLine.length();
                    System.out.println(finalLine);
                }
                System.out.println("Number of characters: " + charCount);
                sc.close();
            } catch (FileNotFoundException e) {
                System.out.println(e);
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}