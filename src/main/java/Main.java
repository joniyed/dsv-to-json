import Functions.ReadFile;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter the file path: ");

//         File file = new File("/home/joniyed/Documents/demo projects/pst.ag/dsv-to-json/src/main/resources/Java task/DSV input 1.txt");
        File file = new File(scanner.nextLine());
        char delimiter = ',';
        System.out.println("Do you want to change delimiter (default: ,(comma)) ??\nYes or No");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            System.out.println("Type delimiter please: ");
            delimiter = scanner.next().charAt(0);
        }
        if (file.exists()) {
            ReadFile.readFile(file, delimiter);
        } else {
            System.out.println("File Not found");
        }
    }
}
