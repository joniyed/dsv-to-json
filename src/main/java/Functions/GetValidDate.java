package Functions;

import org.apache.commons.validator.GenericValidator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class GetValidDate {

    public static HashMap<String, Object> isDate(String date) {

        DateTimeFormatter formatter = null;
        boolean isValidDate = false;
        LocalDate localDate = null;

        if (GenericValidator.isDate(date, "dd-MM-yyyy", true)) {

            isValidDate = true;
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        }else if (GenericValidator.isDate(date, "yyyy-MM-dd", true)) {

            isValidDate = true;
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        }else if (GenericValidator.isDate(date, "dd/MM/yyyy", true)) {

            isValidDate = true;
            formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        }else if (GenericValidator.isDate(date, "yyyy/MM/dd", true)) {

            isValidDate = true;
            formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        }


        if (isValidDate) {
            localDate = LocalDate.parse(date, formatter);
        }


        boolean finalIsValidDate = isValidDate;
        LocalDate finalLocalDate = localDate;
        return new HashMap<>() {{
            put("isDate", finalIsValidDate);
            put("date", finalLocalDate);
        }};

    }
}
