import student.TestCase;

/**
 * This class tests the methods of Point class,
 * ensuring that they work as they should.
 * 
 * @author Richard Martinez
 * @version 1
 */
public class PointTest extends TestCase {

    private Point pt1;
    private Point pt2;

    /**
     * Initializes a point object to be used for the tests.
     */
    public void setUp() {
        pt1 = new Point(10, 5);
        pt2 = new Point(5, 10);
    }


    /**
     * Test the getX and getY methods
     */
    public void testGetXY() {
        assertTrue(pt1.getX() == 10);
        assertTrue(pt1.getY() == 5);
        
        assertTrue(pt2.getX() == 5);
        assertTrue(pt2.getY() == 10);
    }
    
    /**
     * Test the equals method
     */
    public void testEquals() {
        assertFalse(pt1.equals(pt2));
        assertFalse(pt2.equals(pt1));
        
        pt1 = new Point(30, 30);
        pt2 = new Point(30, 30);
        
        assertTrue(pt1.equals(pt2));
        assertTrue(pt2.equals(pt1));
        
        pt1 = new Point(30, 31);
        pt2 = new Point(30, 30);
        
        assertFalse(pt1.equals(pt2));
        assertFalse(pt2.equals(pt1));
        
        pt1 = new Point(31, 30);
        pt2 = new Point(30, 30);
        
        assertFalse(pt1.equals(pt2));
        assertFalse(pt2.equals(pt1));
    }
    
    /**
     * Test toString method
     */
    public void testToString() {
        assertFuzzyEquals(pt1.toString(), "10, 5");
        assertFuzzyEquals(pt2.toString(), "5, 10");
    }
    
    /**
     * Test isInvalid method
     */
    public void testIsInvalid() {
        assertFalse(pt1.isInvalid());
        assertFalse(pt2.isInvalid());
        
        pt1 = new Point(-1, 10);
        assertTrue(pt1.isInvalid());
        
        pt1 = new Point(10, -1);
        assertTrue(pt1.isInvalid());
        
        pt1 = new Point(-1, -1);
        assertTrue(pt1.isInvalid());
    }

}
