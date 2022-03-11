package Functions;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    public static void readFile(File file, char delimiter) {

        try {
            String sb = "";
            InputStream in = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String line;
            long count = 0;
            List<String> headers = new ArrayList<>();
            List<String> value = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                if (count == 0) {
                    headers = SplitWithDeliMiter.getStringList(line, delimiter);
                } else {
                    value.add(line);
                }
                count++;
            }

            CreateJsonFileWithMap.createJson(headers, value, delimiter);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
