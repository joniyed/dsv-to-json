import Functions.ReadFile;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static File getOutputFile(String outputFileName) {
        File file = new File(String.format("%s_%d.jsonl", outputFileName, System.nanoTime()));
        //ensure new result file
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------------------");
        System.out.println("Please Enter the file path: ");
        System.out.println("----------------------------------");

        File file = new File(scanner.nextLine());

        if (file.exists()) {

            //src/test/java/
            char delimiter = ',';
            System.out.println("----------------------------------");
            System.out.println("Do you want to change delimiter (default: ,(comma)) ??\nyes or no");
            System.out.println("----------------------------------");

            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                System.out.println("----------------------------------");
                System.out.println("Type delimiter please: ");
                System.out.println("----------------------------------");
                delimiter = scanner.next().charAt(0);
            }

            System.out.println("----------------------------------");
            System.out.println("Enter output file name: ");
            System.out.println("----------------------------------");
            String s = scanner.next();
            System.out.println("----------------------------------");

            ReadFile.readFile(file, delimiter, getOutputFile(s));

        } else {
            System.out.println("File Not found");
        }

    }
}
