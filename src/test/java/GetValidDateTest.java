import Functions.GetValidDate;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GetValidDateTest {

    @BeforeAll
    public static void setupAll() {
        System.out.println("Should Print Before All Tests");
    }

    @BeforeEach
    public void setup() {
        System.out.println("Instantiating Contact Manager");
    }

    @Test
    @DisplayName("Should Check Valid Date.")
    public void shouldCheckValidDate() {

        HashMap<String, Object> date = GetValidDate.isDate("2022/03/11");
        assertEquals(LocalDate.of(2022, 3, 11), date.get("date"));

        date = GetValidDate.isDate("11/03/2022");
        assertEquals(LocalDate.of(2022, 3, 11), date.get("date"));

        date = GetValidDate.isDate("2022-03-11");
        assertEquals(LocalDate.of(2022, 3, 11), date.get("date"));

        date = GetValidDate.isDate("11-03-2022");
        assertEquals(LocalDate.of(2022, 3, 11), date.get("date"));

        date = GetValidDate.isDate("err/03/11");
        assertFalse((Boolean) date.get("isDate"));

    }
//
//    @Test
//    @DisplayName("Should Not Create Contact When First Name is Null")
//    public void shouldThrowRuntimeExceptionWhenFirstNameIsNull() {
//        Assertions.assertThrows(RuntimeException.class, () -> {
//            contactManager.addContact(null, "Doe", "0123456789");
//        });
//    }
//
//    @Test
//    @DisplayName("Should Not Create Contact When Last Name is Null")
//    public void shouldThrowRuntimeExceptionWhenLastNameIsNull() {
//        Assertions.assertThrows(RuntimeException.class, () -> {
//            contactManager.addContact("John", null, "0123456789");
//        });
//    }
//
//    @Test
//    @DisplayName("Should Not Create Contact When Phone Number is Null")
//    public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNull() {
//        Assertions.assertThrows(RuntimeException.class, () -> {
//            contactManager.addContact("John", "Doe", null);
//        });
//    }
//
//    @Test
//    @DisplayName("Should Create Contact")
//    @EnabledOnOs(value = OS.MAC, disabledReason = "Should Run only on MAC")
//    public void shouldCreateContactOnMAC() {
//        contactManager.addContact("John", "Doe", "0123456789");
//        assertFalse(contactManager.getAllContacts().isEmpty());
//        assertEquals(1, contactManager.getAllContacts().size());
//    }
//
//    @Test
//    @DisplayName("Test Contact Creation on Developer Machine")
//    public void shouldTestContactCreationOnDEV() {
//        Assumptions.assumeTrue("DEV".equals(System.getProperty("ENV")));
//        contactManager.addContact("John", "Doe", "0123456789");
//        assertFalse(contactManager.getAllContacts().isEmpty());
//        assertEquals(1, contactManager.getAllContacts().size());
//    }
//
//    @Test
//    @DisplayName("Phone Number should start with 0")
//    public void shouldTestPhoneNumberFormat() {
//        contactManager.addContact("John", "Doe", "0123456789");
//        assertFalse(contactManager.getAllContacts().isEmpty());
//        assertEquals(1, contactManager.getAllContacts().size());
//    }
//
//
//    @Nested
//    class RepeatedTests {
//        @DisplayName("Repeat Contact Creation Test 5 Times")
//        @RepeatedTest(value = 5,
//                name = "Repeating Contact Creation Test {currentRepetition} of {totalRepetitions}")
//        public void shouldTestContactCreationRepeatedly() {
//            contactManager.addContact("John", "Doe", "0123456789");
//            assertFalse(contactManager.getAllContacts().isEmpty());
//            assertEquals(1, contactManager.getAllContacts().size());
//        }
//    }
//
//    @Nested
//    class ParameterizedTests {
//        @DisplayName("Phone Number should match the required Format")
//        @ParameterizedTest
//        @ValueSource(strings = {"0123456789", "0123456798", "0123456897"})
//        public void shouldTestPhoneNumberFormatUsingValueSource(String phoneNumber) {
//            contactManager.addContact("John", "Doe", phoneNumber);
//            assertFalse(contactManager.getAllContacts().isEmpty());
//            assertEquals(1, contactManager.getAllContacts().size());
//        }
//
//        @DisplayName("CSV Source Case - Phone Number should match the required Format")
//        @ParameterizedTest
//        @CsvSource({"0123456789", "0123456798", "0123456897"})
//        public void shouldTestPhoneNumberFormatUsingCSVSource(String phoneNumber) {
//            contactManager.addContact("John", "Doe", phoneNumber);
//            assertFalse(contactManager.getAllContacts().isEmpty());
//            assertEquals(1, contactManager.getAllContacts().size());
//        }
//
//        @DisplayName("CSV File Source Case - Phone Number should match the required Format")
//        @ParameterizedTest
//        @CsvFileSource(resources = "/data.csv")
//        public void shouldTestPhoneNumberFormatUsingCSVFileSource(String phoneNumber) {
//            contactManager.addContact("John", "Doe", phoneNumber);
//            assertFalse(contactManager.getAllContacts().isEmpty());
//            assertEquals(1, contactManager.getAllContacts().size());
//        }
//    }
//
//    @DisplayName("Method Source Case - Phone Number should match the required Format")
//    @ParameterizedTest
//    @MethodSource("phoneNumberList")
//    public void shouldTestPhoneNumberFormatUsingMethodSource(String phoneNumber) {
//        contactManager.addContact("John", "Doe", phoneNumber);
//        assertFalse(contactManager.getAllContacts().isEmpty());
//        assertEquals(1, contactManager.getAllContacts().size());
//    }
//
//    private static List<String> phoneNumberList() {
//        return Arrays.asList("0123456789", "0123456798", "0123456897");
//    }
//
//    @Test
//    @DisplayName("Test Should Be Disabled")
//    @Disabled
//    public void shouldBeDisabled() {
//        throw new RuntimeException("Test Should Not be executed");
//    }


    @AfterEach
    public void tearDown() {
        System.out.println("Should Execute After Each Test");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("Should be executed at the end of the Test");
    }
}
