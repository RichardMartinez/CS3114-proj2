
import student.TestCase;
import student.TestableRandom;

/**
 * This class tests the CommandProcessor class.
 * Test each possible command on its bounds,
 * if applicable to ensure they work properly.
 * Also test passing improper command to ensure
 * all class functionalities work as intended.
 * 
 * @author Richard Martinez
 * @version 1
 */
public class CommandProcessorTest extends TestCase {

    private CommandProcessor cmdProc;

    /**
     * The setUp() method will be called automatically before
     * each test and reset whatever the test modified. For this
     * test class, only a new database object is needed, so
     * creat a database here for use in each test case.
     */
    public void setUp() {
        cmdProc = new CommandProcessor();
    }


    /**
     * Tests the insert command
     */
    public void testInsert() {
        // Valid insert
        systemOut().clearHistory();
        cmdProc.processor("insert A 64 64");
        String expected = "Point inserted: (A, 64, 64)";
        String actual = systemOut().getHistory();
        assertFuzzyEquals(expected, actual);

        // Invalid insert
        systemOut().clearHistory();
        cmdProc.processor("insert B -1 1");
        expected = "Point rejected: (B, -1, 1)";
        actual = systemOut().getHistory();
        assertFuzzyEquals(expected, actual);

        systemOut().clearHistory();
        cmdProc.processor("insert C 1 -1");
        expected = "Point rejected: (C, 1, -1)";
        actual = systemOut().getHistory();
        assertFuzzyEquals(expected, actual);

        systemOut().clearHistory();
        cmdProc.processor("insert D -1 -1");
        expected = "Point rejected: (D, -1, -1)";
        actual = systemOut().getHistory();
        assertFuzzyEquals(expected, actual);
    }


    /**
     * Tests the search command
     */
    public void testSearch() {
        // Insert
        cmdProc.processor("insert A 256 256");
        cmdProc.processor("insert B 768 256");
        cmdProc.processor("insert C 256 768");
        cmdProc.processor("insert D 768 768");

        // Valid search
        systemOut().clearHistory();
        cmdProc.processor("search A");
        String expected = "Found (A, 256, 256)";
        String actual = systemOut().getHistory();
        assertFuzzyEquals(expected, actual);

        // Invalid search
        systemOut().clearHistory();
        cmdProc.processor("search Z");
        expected = "Point not found: Z";
        actual = systemOut().getHistory();
        assertFuzzyEquals(expected, actual);
    }


    /**
     * Test the dump command
     */
    public void testDump() {
        // Set SkipList Levels to all 1's
        TestableRandom.setNextBooleans(false, false, false, false);

        // Insert
        cmdProc.processor("insert A 256 256");
        cmdProc.processor("insert B 768 256");
        cmdProc.processor("insert C 256 768");
        cmdProc.processor("insert D 768 768");

        systemOut().clearHistory();
        cmdProc.processor("dump");

        String expected = "SkipList dump:\n" + "Node with depth 1, Value null\n"
            + "Node with depth 1, Value (A, 256, 256)\n"
            + "Node with depth 1, Value (B, 768, 256)\n"
            + "Node with depth 1, Value (C, 256, 768)\n"
            + "Node with depth 1, Value (D, 768, 768)\n"
            + "SkipList size is: 4\n" +

            "QuadTree dump:\n" + "Node at 0, 0, 1024: Internal\n"
            + "Node at 0, 0, 512:\n" + "(A, 256, 256)\n"
            + "Node at 512, 0, 512:\n" + "(B, 768, 256)\n"
            + "Node at 0, 512, 512:\n" + "(C, 256, 768)\n"
            + "Node at 512, 512, 512:\n" + "(D, 768, 768)\n"
            + "5 quadtree nodes printed\n";

        String actual = systemOut().getHistory();
        assertFuzzyEquals(expected, actual);
    }


    /**
     * Test an invalid command
     */
    public void testUnrecognizedCommand() {
        systemOut().clearHistory();
        cmdProc.processor("invalid command");
        String expected = "Unrecognized command.";
        String actual = systemOut().getHistory();
        assertFuzzyEquals(expected, actual);
    }


    /**
     * Test the duplicates command
     */
    public void testDuplicates() {
        // Set SkipList Levels to all 1's
        TestableRandom.setNextBooleans(false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false,
            false);

        // Insert
        cmdProc.processor("insert A 128 128");
        cmdProc.processor("insert B 128 128");

        cmdProc.processor("insert C 384 128");
        cmdProc.processor("insert D 384 128");

        cmdProc.processor("insert E 128 384");

        cmdProc.processor("insert F 384 384");

        cmdProc.processor("insert G 768 256");
        cmdProc.processor("insert H 768 256");

        // cmdProc.processor("insert I 128 128");

        cmdProc.processor("insert J 768 768");
        cmdProc.processor("insert K 768 768");

        cmdProc.processor("insert L 640 128");
        cmdProc.processor("insert M 640 128");

        cmdProc.processor("insert N 640 640");
        cmdProc.processor("insert O 640 640");

        cmdProc.processor("insert P 896 896");
        cmdProc.processor("insert Q 896 896");

        systemOut().clearHistory();
        cmdProc.processor("duplicates");

        String expected = "Duplicate points:\n" + "(128, 128)\n"
            + "(384, 128)\n" + "(640, 128)\n" + "(768, 256)\n" + "(640, 640)\n"
            + "(768, 768)\n" + "(896, 896)\n";

        String actual = systemOut().getHistory();

        assertFuzzyEquals(expected, actual);
    }


    /**
     * Test the region search method
     */
    public void testRegionSearch() {
        // Set SkipList Levels to all 1's
        TestableRandom.setNextBooleans(false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false,
            false);

        // Insert
        cmdProc.processor("insert A 128 128");
        cmdProc.processor("insert B 128 128");

        cmdProc.processor("insert C 384 128");
        cmdProc.processor("insert D 384 128");

        cmdProc.processor("insert E 128 384");

        cmdProc.processor("insert F 384 384");

        cmdProc.processor("insert G 768 256");
        cmdProc.processor("insert H 768 256");

        // cmdProc.processor("insert I 128 128");

        cmdProc.processor("insert J 768 768");
        cmdProc.processor("insert K 768 768");

        cmdProc.processor("insert L 640 128");
        cmdProc.processor("insert M 640 128");

        cmdProc.processor("insert N 640 640");
        cmdProc.processor("insert O 640 640");

        cmdProc.processor("insert P 896 896");
        cmdProc.processor("insert Q 896 896");

        systemOut().clearHistory();
        cmdProc.processor("regionsearch 0 0 512 512");

        String expected = "Points intersecting region (0, 0, 512, 512)\n"
            + "Point found: (A, 128, 128)\n" + "Point found: (B, 128, 128)\n"
            + "Point found: (C, 384, 128)\n" + "Point found: (D, 384, 128)\n"
            + "Point found: (E, 128, 384)\n" + "Point found: (F, 384, 384)\n"
            + "6 quadtree nodes visited\n";

        String actual = systemOut().getHistory();

        assertFuzzyEquals(expected, actual);

    }


    /**
     * Test the remove command
     */
    public void testRemove() {
        // Set SkipList Levels to all 1's
        TestableRandom.setNextBooleans(false, false, false, false, false,
            false);

        cmdProc.processor("insert A 128 128");
        cmdProc.processor("insert B 384 128");
        cmdProc.processor("insert C 768 256");
        cmdProc.processor("insert D 256 768");
        cmdProc.processor("insert E 640 640");
        cmdProc.processor("insert F 896 640");

        System.out.println("BEFORE");
        cmdProc.processor("dump");

        // Remove B and F
        cmdProc.processor("remove 384 128");
        cmdProc.processor("remove 896 640");

        // Print and test
        System.out.println("AFTER");

        systemOut().clearHistory();
        cmdProc.processor("dump");
        String expected = "SkipList dump:\n" + "Node with depth 1, Value null\n"
            + "Node with depth 1, Value (A, 128, 128)\n"
            + "Node with depth 1, Value (C, 768, 256)\n"
            + "Node with depth 1, Value (D, 256, 768)\n"
            + "Node with depth 1, Value (E, 640, 640)\n"
            + "SkipList size is: 4\n" + "QuadTree dump:\n"
            + "Node at 0, 0, 1024: Internal\n" + "Node at 0, 0, 512:\n"
            + "(A, 128, 128)\n" + "Node at 512, 0, 512:\n" + "(C, 768, 256)\n"
            + "Node at 0, 512, 512:\n" + "(D, 256, 768)\n"
            + "Node at 512, 512, 512:\n" + "(E, 640, 640)\n"
            + "5 quadtree nodes printed\n";

        String actual = systemOut().getHistory();

        assertFuzzyEquals(expected, actual);

        // Try to remove invalid point
        systemOut().clearHistory();
        cmdProc.processor("remove 0 0");
        expected = "Point not found: (0, 0)\n";

        actual = systemOut().getHistory();

        assertFuzzyEquals(expected, actual);
    }


    /**
     * Test an invalid remove
     */
    public void testInvalidRemove() {
        systemOut().clearHistory();
        cmdProc.processor("remove 0 0 0");
        String expected = "Invalid command.\n";

        String actual = systemOut().getHistory();

        assertFuzzyEquals(expected, actual);
    }
    
    /**
     * Test removing by name
     */
    public void testRemoveByName() {
     // Set SkipList Levels to all 1's
        TestableRandom.setNextBooleans(false, false, false, false, false,
            false);

        cmdProc.processor("insert A 128 128");
        cmdProc.processor("insert B 384 128");
        cmdProc.processor("insert C 768 256");
        cmdProc.processor("insert D 256 768");
        cmdProc.processor("insert E 640 640");
        cmdProc.processor("insert F 896 640");

        System.out.println("BEFORE");
        cmdProc.processor("dump");

        // Remove B and F
        cmdProc.processor("remove B");
        cmdProc.processor("remove F");

        // Print and test
        System.out.println("AFTER");

        systemOut().clearHistory();
        cmdProc.processor("dump");
        String expected = "SkipList dump:\n" + "Node with depth 1, Value null\n"
            + "Node with depth 1, Value (A, 128, 128)\n"
            + "Node with depth 1, Value (C, 768, 256)\n"
            + "Node with depth 1, Value (D, 256, 768)\n"
            + "Node with depth 1, Value (E, 640, 640)\n"
            + "SkipList size is: 4\n" + "QuadTree dump:\n"
            + "Node at 0, 0, 1024: Internal\n" + "Node at 0, 0, 512:\n"
            + "(A, 128, 128)\n" + "Node at 512, 0, 512:\n" + "(C, 768, 256)\n"
            + "Node at 0, 512, 512:\n" + "(D, 256, 768)\n"
            + "Node at 512, 512, 512:\n" + "(E, 640, 640)\n"
            + "5 quadtree nodes printed\n";

        String actual = systemOut().getHistory();

        assertFuzzyEquals(expected, actual);

        // Try to remove invalid point
        systemOut().clearHistory();
        cmdProc.processor("remove M");
        expected = "Point not removed: M\n";

        actual = systemOut().getHistory();

        assertFuzzyEquals(expected, actual);
    }
}
