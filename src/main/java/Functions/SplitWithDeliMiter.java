package Functions;

import java.util.ArrayList;
import java.util.List;

public class SplitWithDeliMiter {

    public static List<String> getStringList(String s, char del) {

        List<String> jsonValue = new ArrayList<>();
        int temp = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == del && s.charAt(i - 1) != ' ' && s.charAt(i + 1) != ' ') {
                jsonValue.add(s.substring(temp, i));
                temp = i + 1;
            } else if (i == s.length() - 1) {
                jsonValue.add(s.substring(temp));
            }

        }
        return jsonValue;
    }

}
