import org.junit.jupiter.api.*;
import services.GetValidDate;

import java.time.LocalDate;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GetValidDateTest {


    @BeforeAll
    public static void setupAll() {
        System.out.println(GetValidDateTest.class.getSimpleName() + " class test started.");
    }

    @BeforeEach
    public void setup() {
        System.out.println("----------------------------------");
    }

    @Test
    @DisplayName("Should Check Valid Date.")
    public void shouldCheckValidDate() {

        String date1 = "13-03-2022";
        String _date1 = "03-13-2022";
        String date2 = "2022-03-13";
        String _date2 = "2022-13-03";
        String date3 = "13/03/2022";
        String _date3 = "03/13/2022";
        String date4 = "2022/03/13";
        String _date4 = "2022/13/03";

        HashMap<String, Object> date = GetValidDate.isDate(date1);
        assertEquals(LocalDate.of(2022, 3, 13), date.get("date"));

        date = GetValidDate.isDate(_date1);
        assertEquals(LocalDate.of(2022, 3, 13), date.get("date"));

        date = GetValidDate.isDate(date2);
        assertEquals(LocalDate.of(2022, 3, 13), date.get("date"));

        date = GetValidDate.isDate(_date2);
        assertEquals(LocalDate.of(2022, 3, 13), date.get("date"));

        date = GetValidDate.isDate(date3);
        assertEquals(LocalDate.of(2022, 3, 13), date.get("date"));

        date = GetValidDate.isDate(_date3);
        assertEquals(LocalDate.of(2022, 3, 13), date.get("date"));

        date = GetValidDate.isDate(date4);
        assertEquals(LocalDate.of(2022, 3, 13), date.get("date"));

        date = GetValidDate.isDate(_date4);
        assertEquals(LocalDate.of(2022, 3, 13), date.get("date"));

        date = GetValidDate.isDate("err/03/11");
        assertFalse((Boolean) date.get("isDate"));

    }

    @AfterEach
    public void tearDown() {
        System.out.println("----------------------------------");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("Test Done");
    }
}
