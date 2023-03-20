package W1.lab;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class read {

    public static void main(String[] args) {
        try {
            // Part 1
            Scanner sc = new Scanner(new FileInputStream("./W1/lab/wenghong_22004797.txt"));
            while (sc.hasNextLine())
                System.out.println(sc.nextLine());
            sc.close();

            // Part 2
            sc = new Scanner(System.in);
            PrintWriter writer = new PrintWriter(new FileOutputStream("./W1/lab/wenghong_22004797.txt", true));
            System.out.println("Add something...");
            writer.println();
            String line;
            while (!(line = sc.nextLine()).equals("end"))
                writer.println(line);
            writer.close();

            sc = new Scanner(new FileInputStream("./W1/lab/wenghong_22004797.txt"));
            while (sc.hasNextLine())
                System.out.println(sc.nextLine());
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
