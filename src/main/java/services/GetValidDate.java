package services;

import org.apache.commons.validator.GenericValidator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class GetValidDate {

    public static HashMap<String, Object> isDate(String date) {

        DateTimeFormatter formatter = null;
        boolean isValidDate = false;
        LocalDate localDate = null;
        String dateFormat1 = "dd-MM-yyyy";
        String _dateFormat1 = "MM-dd-yyyy";
        String dateFormat2 = "yyyy-MM-dd";
        String _dateFormat2 = "yyyy-dd-MM";
        String dateFormat3 = "dd/MM/yyyy";
        String _dateFormat3 = "MM/dd/yyyy";
        String dateFormat4 = "yyyy/MM/dd";
        String _dateFormat4 = "yyyy/dd/MM";

        if (GenericValidator.isDate(date, dateFormat1, true)) {

            isValidDate = true;
            formatter = DateTimeFormatter.ofPattern(dateFormat1);

        } else if (GenericValidator.isDate(date, _dateFormat1, true)) {

            isValidDate = true;
            formatter = DateTimeFormatter.ofPattern(_dateFormat1);

        } else if (GenericValidator.isDate(date, dateFormat2, true)) {

            isValidDate = true;
            formatter = DateTimeFormatter.ofPattern(dateFormat2);

        } else if (GenericValidator.isDate(date, _dateFormat2, true)) {

            isValidDate = true;
            formatter = DateTimeFormatter.ofPattern(_dateFormat2);

        } else if (GenericValidator.isDate(date, dateFormat3, true)) {

            isValidDate = true;
            formatter = DateTimeFormatter.ofPattern(dateFormat3);

        }else if (GenericValidator.isDate(date, _dateFormat3, true)) {

            isValidDate = true;
            formatter = DateTimeFormatter.ofPattern(_dateFormat3);

        } else if (GenericValidator.isDate(date, dateFormat4, true)) {

            isValidDate = true;
            formatter = DateTimeFormatter.ofPattern(dateFormat4);

        }else if (GenericValidator.isDate(date, _dateFormat4, true)) {

            isValidDate = true;
            formatter = DateTimeFormatter.ofPattern(_dateFormat4);

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
