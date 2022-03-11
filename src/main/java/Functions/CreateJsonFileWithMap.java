package Functions;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateJsonFileWithMap {


    private static List<Map<String, Object>> getJsonArray(List<String> headers, List<String> value, char delimiter) {

        List<Map<String, Object>> jsonArray = new ArrayList<>();

        value.stream().forEach(s -> {

            List<String> jsonValue = SplitWithDeliMiter.getStringList(s, delimiter);
            int size = Math.min(jsonValue.size(), headers.size());
            Map<String, Object> jsonObject = new HashMap<>();
            for (int i = 0; i < size; i++) {
                jsonObject.put(headers.get(i), jsonValue.get(i));
            }

            jsonArray.add(jsonObject);

        });
        return jsonArray;
    }

    public static void createJson(List<String> headers, List<String> value, char delimiter) {

        List<Map<String, Object>> jsonArray = getJsonArray(headers, value, delimiter);

        try {

            File file = new File("result.jsonl");
            //ensure new result file
            file.delete();
            file.createNewFile();

            jsonArray.forEach(o -> {
                try {
//                    JSONObject json = new JSONObject();
//                    json.putAll(o);
                    Gson gson = new Gson();
                    String s = gson.toJson(o);
                    FileWriter fileW = new FileWriter(file.getAbsolutePath(), true);
                    fileW.write(s);
                    fileW.write(System.lineSeparator());
                    fileW.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
