import Functions.GetValidDate;
import Functions.ReadFile;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class MainTest {

    @BeforeAll
    public static void setupAll() {
        System.out.println("Started Main Test");
    }

    @BeforeEach
    public void setup() {
        System.out.println("---------------------------");
    }

    @Test
    @DisplayName("Test With DSV Input 1.txt")
    public void testForInputTxt1() {

        File input = new File("src/test/resource/input/DSV input 1.txt");
        File outputFile = Main.getOutputFile("src/test/resource/output/dsv_input_1");
        testInputOutputFile(input, ',', outputFile);

    }

    @Test
    @DisplayName("Test With DSV Input 2.txt")
    public void testForInputTxt2() {

        File input = new File("src/test/resource/input/DSV input 2.txt");
        File outputFile = Main.getOutputFile("src/test/resource/output/dsv_input_2");
        testInputOutputFile(input, '|', outputFile);

    }

    /*Note
     * Internal Service Used
     * */
    private void testInputOutputFile(File input, char delimeter, File outputFile) {

        System.out.println("File " + input.getPath() + " test started.....");
        ReadFile.readFile(input, delimeter, outputFile);
        try {

            /*Note
             * After complete, must need to exist the file
             * */
            assertTrue(outputFile.exists());

            /*Note
             * Input file has header. So count of output file line must less than one
             * */
            assertEquals(
                    Files.readAllLines(Path.of(input.getPath())).size(),
                    Files.readAllLines(Path.of(outputFile.getPath())).size() + 1
            );

            List<String> strings = Files.readAllLines(Path.of(outputFile.getPath()));
            strings.forEach(s -> {

                Gson gson = new Gson();
                Map map = gson.fromJson(s, Map.class);

                /*Note
                 * Json Object must be 6 for input 1
                 * */
                assertEquals(6, map.size());


                Object dateOfBirth = map.get("dateOfBirth");
                HashMap<String, Object> date = GetValidDate.isDate((String) dateOfBirth);

                /*Note
                 * Check the date valid or not
                 * */
                assertTrue((Boolean) date.get("isDate"));

            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("File test done.....");

    }

}
