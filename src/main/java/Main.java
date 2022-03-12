import services.ReadFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static File getOutputFile(String outputFileName) {
        File file = new File(String.format("%s_%d.jsonl", outputFileName, System.nanoTime()));
        //ensure new result file
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int i = Integer.parseInt(br.readLine());

        int exitMessage = 0;

        while (exitMessage != 2) {

            System.out.println();
            System.out.println("----------------------------------");
            System.out.println("Please Enter the file path: ");
            System.out.println("----------------------------------");
            System.out.println();

            File file = new File(br.readLine());
            if (file.exists()) {

                //src/test/java/
                char delimiter = ',';
                System.out.println();
                System.out.println("----------------------------------");
                System.out.println("Do you want to change delimiter (default: ,(comma)) ??\n1.yes\n2.no\nPlease Enter 1 or 2");
                System.out.println("----------------------------------");
                System.out.println();

                if (scanner.nextInt() == 1) {
                    System.out.println();
                    System.out.println("----------------------------------");
                    System.out.println("Please Enter Your Delimiter: ");
                    System.out.println("----------------------------------");
                    System.out.println();
                    delimiter = scanner.next().charAt(0);
                }

                System.out.println();
                System.out.println("----------------------------------");
                System.out.println("Please Enter Output File Name: ");
                System.out.println("----------------------------------");
                System.out.println();

                String s = br.readLine();

                ReadFile.readFile(file, delimiter, getOutputFile(String.format("output/%s", s)));


                System.out.println();
                System.out.println("----------------------------------");
                System.out.println("Successfully Done..");
                System.out.println("----------------------------------");
                System.out.println();
                System.out.println();

            } else {
                System.out.println("File Not found");
            }


            /*Note
             * Run until User not exit
             * */
            System.out.println();
            System.out.println("----------------------------------");
            System.out.println("Do you want to do more work??\n 1.yes\n 2.no\nPlease Enter 1 or 2");
            System.out.println("----------------------------------");
            System.out.println();
            exitMessage = scanner.nextInt();
        }

    }
}
