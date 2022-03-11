package Functions;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    public static void readFile(File file, char delimiter, File outputFile) {

        try {
            String sb = "";
            InputStream in = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String line;
            long count = 0;
            List<String> headers = new ArrayList<>();
            List<String> value = new ArrayList<>();
            long thresold = 10000;

            while ((line = br.readLine()) != null) {
                if (count == 0) {
                    headers = SplitWithDeliMiter.getStringList(line, delimiter);
                } else {
                    value.add(line);
                }

                /*Note
                 * Read and Write only threshold value at a time
                 * */
                if (count >= thresold && count % thresold == 0) {
                    CreateJsonFileWithMap.createJson(headers, value, delimiter, outputFile);
                    value.clear();
                    System.out.printf("%d json write into file.\n", count);
                }
                count++;
            }

            /*Note
             * Check count is less than threshold or not
             * */
            if (count < thresold) {
                CreateJsonFileWithMap.createJson(headers, value, delimiter, outputFile);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
