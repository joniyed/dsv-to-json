//package Functions;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.List;
//
//public class CreateJsonFile {
//
//
//    private static JSONArray getJsonArray(List<String> headers, List<String> value, char delimiter) {
//        JSONArray jsonArray = new JSONArray();
//        value.stream().forEach(s -> {
//            //String[] jsonValue = s.split("\\S(,)\\S");
//            //String[] jsonValue = s.split(",");
//            List<String> jsonValue = SplitWithDeliMiter.getStringList(s, delimiter);
//
//            int size = Math.min(jsonValue.size(), headers.size());
//            JSONObject jsonObject = new JSONObject();
//            for (int i = 0; i < size; i++) {
//                jsonObject.put(headers.get(i), jsonValue.get(i));
//            }
//
//            jsonArray.add(jsonObject);
//
//        });
//        return jsonArray;
//    }
//
//    public static void createJson(List<String> headers, List<String> value, char delimiter) {
//
//        JSONArray jsonArray = getJsonArray(headers, value, delimiter);
//        try {
//            File file = new File("result.jsonl");
//
//            //ensure new result file
//            file.delete();
//            file.createNewFile();
//
//            jsonArray.forEach(o -> {
//                try {
//
//                    FileWriter fileW = new FileWriter(file.getAbsolutePath(), true);
//                    fileW.write(o.toString());
//                    fileW.write(System.lineSeparator());
//                    fileW.close();
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
