import Functions.ReadFile;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter the file path: ");

        File file = new File(scanner.nextLine());

        if (file.exists()) {

            // /home/joniyed/Documents/demo projects/pst.ag/dsv-to-json/src/main/resources/Java task/DSV input 2.txt
            char delimiter = ',';
            System.out.println("Do you want to change delimiter (default: ,(comma)) ??\nyes or no");

            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                System.out.println("Type delimiter please: ");
                delimiter = scanner.next().charAt(0);
            }

            ReadFile.readFile(file, delimiter);

        } else {
            System.out.println("File Not found");
        }

    }
}
