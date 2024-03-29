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
        assertEquals(pt1.getX(), 10);
        assertEquals(pt1.getY(), 5);

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

        pt1 = new Point(1024, 1);
        assertTrue(pt1.isInvalid());

        pt1 = new Point(1, 1024);
        assertTrue(pt1.isInvalid());
    }


    /**
     * Test direction methods
     */
    public void testDirections() {
        Point a = new Point(256, 256);
        Point b = new Point(256, 768);
        Point c = new Point(768, 256);
        Point d = new Point(768, 768);

        int x = 512;
        int y = 512;

        assertTrue(a.isNorthOf(x, y));
        assertTrue(a.isWestOf(x, y));

        assertFalse(b.isNorthOf(x, y));
        assertTrue(b.isWestOf(x, y));

        assertTrue(c.isNorthOf(x, y));
        assertFalse(c.isWestOf(x, y));

        assertFalse(d.isNorthOf(x, y));
        assertFalse(d.isWestOf(x, y));

        assertEquals(a.getDirection(x, y), "nw");
        assertEquals(b.getDirection(x, y), "sw");
        assertEquals(c.getDirection(x, y), "ne");
        assertEquals(d.getDirection(x, y), "se");
    }


    /**
     * Test the region intersect method
     */
    public void testIntersectRegion() {
        // Setup region
        int regionX = 10;
        int regionY = 10;
        int regionW = 10;
        int regionH = 10;

        Point pt = new Point(15, 15);
        assertTrue(pt.intersectsRegion(regionX, regionY, regionW, regionH));

        // Point does not intersect
        pt = new Point(5, 5);
        assertFalse(pt.intersectsRegion(regionX, regionY, regionW, regionH));

        pt = new Point(5, 15);
        assertFalse(pt.intersectsRegion(regionX, regionY, regionW, regionH));

        pt = new Point(5, 25);
        assertFalse(pt.intersectsRegion(regionX, regionY, regionW, regionH));

        pt = new Point(15, 5);
        assertFalse(pt.intersectsRegion(regionX, regionY, regionW, regionH));

        pt = new Point(15, 25);
        assertFalse(pt.intersectsRegion(regionX, regionY, regionW, regionH));

        pt = new Point(25, 5);
        assertFalse(pt.intersectsRegion(regionX, regionY, regionW, regionH));

        pt = new Point(25, 15);
        assertFalse(pt.intersectsRegion(regionX, regionY, regionW, regionH));

        pt = new Point(25, 25);
        assertFalse(pt.intersectsRegion(regionX, regionY, regionW, regionH));
    }

}
