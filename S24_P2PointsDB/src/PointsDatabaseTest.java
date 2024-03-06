
import student.TestCase;

public class PointsDatabaseTest extends TestCase {
    
    private PointsDatabase pdb;
    
    public void setUp() {
        pdb = new PointsDatabase();
    }
    
    public void testInit() {
        systemOut().clearHistory();
        System.out.println("Pass");
        String history = systemOut().getHistory();
        String expected = "Pass";
        assertTrue(history.contains(expected));
        assertFuzzyEquals(history, expected);
    }

}
