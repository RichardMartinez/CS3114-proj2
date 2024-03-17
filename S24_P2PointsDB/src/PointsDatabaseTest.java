
import student.TestCase;
import student.TestableRandom;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class tests the PointsDatabase class.
 * 
 * @author Richard Martinez
 * 
 * @version 2024-03-15
 */
public class PointsDatabaseTest extends TestCase {

    private PointsDatabase pdb;

    /**
     * Set up the tests
     */
    public void setUp() {
        // pdb = new PointsDatabase();
    }


    /**
     * Read contents of a file into a string
     * 
     * @param path
     *            File name
     * @return the string
     * @throws IOException
     */
    static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded);
    }


    /**
     * Example 1: Tests the main method when the file name is invalid.
     */
    public void testMainNoArgs() {
        String[] testInput = {};
        PointsDatabase.main(testInput);
        assertTrue(fuzzyContains(systemOut().getHistory(), "Invalid file"));
    }


    /**
     * Example 2: Tests the main method when the file name is valid.
     */
    /**
     * This method tests the main functionality of the SkipListProject class.
     * It creates an instance of SkipListProject, calls the toString() method,
     * sets the expected output, sets the test input, and calls the main method
     * of SkipListProject with the test input. Finally, it asserts that the
     * expected output matches the system output.
     * 
     * @throws IOException
     */
    public void testMain() throws IOException {

        // Creates an instance of SkipListProject
// SkipListProject project = new SkipListProject();
// project.toString();

        // Sets the test input file.
        // This file contains a list of commands to be executed.

        // Set SkipList to all 1's for testing

        TestableRandom.setNextBooleans(false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false,
            false);

        // Type is array of Strings to match the `main` argument
        String[] testInput = { "PointsDBsampleInOut/testPointsDB.txt" };
        // Type is String to match type of `readFile` method
        String testOutput = "PointsDBsampleInOut/testPointsDBOut.txt";

        // Call main
        PointsDatabase.main(testInput);

        // Sets the expected output.
        // Change this to the file that contains expected output.
        // Then, you can read the output file and
        // set the expected output from that.
        String expected = readFile(testOutput);

        // asserts that the expected output matches the system output
        // generated by the main method of SkipListProject.
        assertFuzzyEquals(expected, systemOut().getHistory());
    }


    /**
     * Test the invalid filename
     * 
     * @throws IOException
     */
    public void testInvalidFilename() throws IOException {
        // PointsDatabase project = new PointsDatabase();

        String[] testInput = { "This file does not exist" };

        // Call main
        systemOut().clearHistory();
        PointsDatabase.main(testInput);

        String actualOutput = systemOut().getHistory();

        assertTrue(actualOutput.contains("Invalid file"));
    }


    /**
     * This is a placeholder
     */
    public void test() {

    }

}
