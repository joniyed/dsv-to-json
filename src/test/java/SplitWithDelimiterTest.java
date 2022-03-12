import services.SplitWithDeliMiter;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SplitWithDelimiterTest {

    @BeforeAll
    public static void setupAll() {
        System.out.println(SplitWithDelimiterTest.class.getSimpleName() + " class test started.");
    }

    @BeforeEach
    public void setup() {
        System.out.println("----------------------------------");
    }

    @Test
    @DisplayName("Test With DSV Input 2.txt")
    public void splitWithDMCheck() {

        String str = "firstName,middleName,lastName,gender,dateOfBirth,salary\n";
        List<String> stringList = SplitWithDeliMiter.getStringList(str, ',');

        /*Note
         * Json Object must be 6 for input 1
         * */
        assertEquals(6, stringList.size());
        assertEquals("firstName", stringList.get(0));
        assertEquals("middleName", stringList.get(1));
        assertEquals("lastName", stringList.get(2));
        assertEquals("gender", stringList.get(3));
        assertEquals("dateOfBirth", stringList.get(4));
        assertEquals("salary\n", stringList.get(5));

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
