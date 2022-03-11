package Functions;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CreateJsonFileWithMap {


    /*Note
     * Write jsonl file
     * */
    private static void writeToFile(File file, Map<String, Object> o) throws IOException {

        FileWriter fileW = new FileWriter(file.getAbsolutePath(), true);

        fileW.write(new Gson().toJson(o));
        fileW.write(System.lineSeparator());

        fileW.close();

    }

    /*Note
     * Get Writable json data
     * */
    private static List<Map<String, Object>> getJsonArray(List<String> headers, List<String> value, char delimiter) {

        List<Map<String, Object>> jsonArray = new ArrayList<>();

        value.stream().forEach(s -> {

            List<String> jsonValue = SplitWithDeliMiter.getStringList(s, delimiter);
            int size = Math.min(jsonValue.size(), headers.size());
            Map<String, Object> jsonObject = new HashMap<>();
            for (int i = 0; i < size; i++) {

                HashMap<String, Object> isDate = GetValidDate.isDate(jsonValue.get(i));
                boolean isValidDate = (boolean) isDate.get("isDate");

                if (isValidDate) {

                    /*Note
                     * Dynamically Check this text is date or not
                     * */
                    LocalDate date = (LocalDate) isDate.get("date");
                    DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    String text = date.format(formatters);
                    LocalDate parsedDate = LocalDate.parse(text, formatters);
                    jsonObject.put(headers.get(i), parsedDate.toString());

                } else {
                    jsonObject.put(headers.get(i), jsonValue.get(i));
                }

            }

            jsonArray.add(jsonObject);

        });
        return jsonArray;
    }


    /*Note
     * CreateJson File
     * */
    public static void createJson(List<String> headers, List<String> value, char delimiter, File file) {

        List<Map<String, Object>> jsonArray = getJsonArray(headers, value, delimiter);

        jsonArray.forEach(o -> {
            try {

                /*append true means save with previous data*/
                writeToFile(file, o);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
