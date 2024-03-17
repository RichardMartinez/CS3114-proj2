import student.TestCase;

/**
 * This class tests the methods of the PRQuadTree class.
 * 
 * @author Richard Martinez
 * 
 * @version 2024-03-15
 */
public class PRQuadTreeTest extends TestCase {

    private PRQuadTree tree;

    /**
     * Set up the test object
     */
    public void setUp() {
        tree = new PRQuadTree();
    }


    /**
     * Test the first split of the tree
     */
    public void testFirstSplit() {
        String name;
        Point pt;
        KVPair<String, Point> pair;

        // Test first split
        name = "A";
        pt = new Point(256, 256);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "B";
        pt = new Point(256, 768);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "C";
        pt = new Point(768, 256);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "D";
        pt = new Point(768, 768);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        // Test structure using dump
        systemOut().clearHistory();
        tree.dump();
        String actual = systemOut().getHistory();

        String expected = "QuadTree dump:\n" + "Node at 0, 0, 1024: Internal\n"
            + "Node at 0, 0, 512:\n" + "(A, 256, 256)\n"
            + "Node at 512, 0, 512:\n" + "(C, 768, 256)\n"
            + "Node at 0, 512, 512:\n" + "(B, 256, 768)\n"
            + "Node at 512, 512, 512:\n" + "(D, 768, 768)\n"
            + "5 quadtree nodes printed\n";

        assertFuzzyEquals(actual, expected);
    }


    /**
     * Test the second split of the tree
     */
    public void testSecondSplit() {
        String name;
        Point pt;
        KVPair<String, Point> pair;

        name = "A";
        pt = new Point(128, 128);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "B";
        pt = new Point(256, 768);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "C";
        pt = new Point(768, 256);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "D";
        pt = new Point(768, 768);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "E";
        pt = new Point(384, 128);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "F";
        pt = new Point(128, 384);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "G";
        pt = new Point(384, 384);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        // Test structure using dump
        systemOut().clearHistory();
        tree.dump();
        String actual = systemOut().getHistory();

        String expected = "QuadTree dump:\n" + "Node at 0, 0, 1024: Internal\n"
            + "Node at 0, 0, 512: Internal\n" + "Node at 0, 0, 256:\n"
            + "(A, 128, 128)\n" + "Node at 256, 0, 256:\n" + "(E, 384, 128)\n"
            + "Node at 0, 256, 256:\n" + "(F, 128, 384)\n"
            + "Node at 256, 256, 256:\n" + "(G, 384, 384)\n"
            + "Node at 512, 0, 512:\n" + "(C, 768, 256)\n"
            + "Node at 0, 512, 512:\n" + "(B, 256, 768)\n"
            + "Node at 512, 512, 512:\n" + "(D, 768, 768)\n"
            + "9 quadtree nodes printed\n";

        assertFuzzyEquals(actual, expected);
    }


    /**
     * Test sixteen points with multiple subdivisions
     */
    public void testSixteenPoints() {
        String name;
        Point pt;
        KVPair<String, Point> pair;

        name = "A";
        pt = new Point(64, 64);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "B";
        pt = new Point(192, 64);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "C";
        pt = new Point(64, 192);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "D";
        pt = new Point(192, 192);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "E";
        pt = new Point(64, 832);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "F";
        pt = new Point(192, 832);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "G";
        pt = new Point(64, 960);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "H";
        pt = new Point(192, 960);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "I";
        pt = new Point(832, 64);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "J";
        pt = new Point(960, 64);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "K";
        pt = new Point(832, 192);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "L";
        pt = new Point(960, 192);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "M";
        pt = new Point(832, 832);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "N";
        pt = new Point(960, 832);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "O";
        pt = new Point(832, 960);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "P";
        pt = new Point(960, 960);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        // Test structure using dump
        systemOut().clearHistory();
        tree.dump();
        String actual = systemOut().getHistory();

        String expected = "QuadTree dump:\n" + "Node at 0, 0, 1024: Internal\n"
            + "Node at 0, 0, 512: Internal\n" + "Node at 0, 0, 256: Internal\n"
            + "Node at 0, 0, 128:\n" + "(A, 64, 64)\n"
            + "Node at 128, 0, 128:\n" + "(B, 192, 64)\n"
            + "Node at 0, 128, 128:\n" + "(C, 64, 192)\n"
            + "Node at 128, 128, 128:\n" + "(D, 192, 192)\n"
            + "Node at 256, 0, 256: Empty\n" + "Node at 0, 256, 256: Empty\n"
            + "Node at 256, 256, 256: Empty\n"
            + "Node at 512, 0, 512: Internal\n" + "Node at 512, 0, 256: Empty\n"
            + "Node at 768, 0, 256: Internal\n" + "Node at 768, 0, 128:\n"
            + "(I, 832, 64)\n" + "Node at 896, 0, 128:\n" + "(J, 960, 64)\n"
            + "Node at 768, 128, 128:\n" + "(K, 832, 192)\n"
            + "Node at 896, 128, 128:\n" + "(L, 960, 192)\n"
            + "Node at 512, 256, 256: Empty\n"
            + "Node at 768, 256, 256: Empty\n"
            + "Node at 0, 512, 512: Internal\n" + "Node at 0, 512, 256: Empty\n"
            + "Node at 256, 512, 256: Empty\n"
            + "Node at 0, 768, 256: Internal\n" + "Node at 0, 768, 128:\n"
            + "(E, 64, 832)\n" + "Node at 128, 768, 128:\n" + "(F, 192, 832)\n"
            + "Node at 0, 896, 128:\n" + "(G, 64, 960)\n"
            + "Node at 128, 896, 128:\n" + "(H, 192, 960)\n"
            + "Node at 256, 768, 256: Empty\n"
            + "Node at 512, 512, 512: Internal\n"
            + "Node at 512, 512, 256: Empty\n"
            + "Node at 768, 512, 256: Empty\n"
            + "Node at 512, 768, 256: Empty\n"
            + "Node at 768, 768, 256: Internal\n" + "Node at 768, 768, 128:\n"
            + "(M, 832, 832)\n" + "Node at 896, 768, 128:\n" + "(N, 960, 832)\n"
            + "Node at 768, 896, 128:\n" + "(O, 832, 960)\n"
            + "Node at 896, 896, 128:\n" + "(P, 960, 960)\n"
            + "37 quadtree nodes printed\n";

        assertFuzzyEquals(actual, expected);
    }

// /**
// * Test a different layout of the 16 points
// */
// public void testSixteenPoints2() {
//
// }


    /**
     * Test inserting points with the same name
     * or same coordinates BUT NOT BOTH
     */
    public void testDuplicateNamesAndPoints() {
        String name;
        Point pt;
        KVPair<String, Point> pair;

        // Same name A
        name = "A";
        pt = new Point(256, 256);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "A";
        pt = new Point(768, 768);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        // Same Point 256, 768
        name = "B";
        pt = new Point(256, 768);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "C";
        pt = new Point(256, 768);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        // Same name D
        name = "D";
        pt = new Point(256, 768);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "D";
        pt = new Point(768, 256);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        // Test structure using dump
        systemOut().clearHistory();
        tree.dump();
        String actual = systemOut().getHistory();

        String expected = "QuadTree dump:\n" + "Node at 0, 0, 1024: Internal\n"
            + "Node at 0, 0, 512:\n" + "(A, 256, 256)\n"
            + "Node at 512, 0, 512:\n" + "(D, 768, 256)\n"
            + "Node at 0, 512, 512:\n" + "(B, 256, 768)\n" + "(C, 256, 768)\n"
            + "(D, 256, 768)\n" + "Node at 512, 512, 512:\n" + "(A, 768, 768)\n"
            + "5 quadtree nodes printed\n";

        assertFuzzyEquals(actual, expected);
    }


    /**
     * Test the duplicates method
     */
    public void testDuplicates() {
        String name;
        Point pt;
        KVPair<String, Point> pair;

        name = "A";
        pt = new Point(128, 128);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "B";
        pt = new Point(128, 128);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "C";
        pt = new Point(384, 128);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "D";
        pt = new Point(384, 128);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "E";
        pt = new Point(128, 384);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "F";
        pt = new Point(384, 384);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "G";
        pt = new Point(768, 256);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "H";
        pt = new Point(768, 256);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

// name = "I";
// pt = new Point(256, 768);
// pair = new KVPair<String, Point>(name, pt);
// tree.insert(pair);

        name = "J";
        pt = new Point(768, 768);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "K";
        pt = new Point(768, 768);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "L";
        pt = new Point(640, 128);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "M";
        pt = new Point(640, 128);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "N";
        pt = new Point(640, 640);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "O";
        pt = new Point(640, 640);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "P";
        pt = new Point(896, 896);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "Q";
        pt = new Point(896, 896);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        System.out.println("DUPLICATES");
        systemOut().clearHistory();
        tree.duplicates();
        String expected = "Duplicate points:\n" + "(128, 128)\n"
            + "(384, 128)\n" + "(640, 128)\n" + "(768, 256)\n" + "(640, 640)\n"
            + "(768, 768)\n" + "(896, 896)\n";

        String actual = systemOut().getHistory();
        assertFuzzyEquals(expected, actual);
    }


    /**
     * Test to make sure that we are splitting correctly
     */
    public void testSplitting() {
        String name;
        Point pt;
        KVPair<String, Point> pair;

        name = "A";
        pt = new Point(576, 576);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "B";
        pt = new Point(640, 896);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "C";
        pt = new Point(896, 896);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "D";
        pt = new Point(704, 704);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "E";
        pt = new Point(704, 576);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "F";
        pt = new Point(576, 704);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        systemOut().clearHistory();
        tree.dump();
        String expected = "QuadTree dump:\n" + "Node at 0, 0, 1024: Internal\n"
            + "Node at 0, 0, 512: Empty\n" + "Node at 512, 0, 512: Empty\n"
            + "Node at 0, 512, 512: Empty\n"
            + "Node at 512, 512, 512: Internal\n"
            + "Node at 512, 512, 256: Internal\n" + "Node at 512, 512, 128:\n"
            + "(A, 576, 576)\n" + "Node at 640, 512, 128:\n" + "(E, 704, 576)\n"
            + "Node at 512, 640, 128:\n" + "(F, 576, 704)\n"
            + "Node at 640, 640, 128:\n" + "(D, 704, 704)\n"
            + "Node at 768, 512, 256: Empty\n" + "Node at 512, 768, 256:\n"
            + "(B, 640, 896)\n" + "Node at 768, 768, 256:\n" + "(C, 896, 896)\n"
            + "13 quadtree nodes printed\n";

        String actual = systemOut().getHistory();
        assertFuzzyEquals(expected, actual);

    }


    /**
     * Test the decomposition rule with duplicate points
     */
    public void testDecompositionRule() {
        String name;
        Point pt;
        KVPair<String, Point> pair;

        name = "A";
        pt = new Point(256, 256);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "B";
        pt = new Point(256, 256);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "C";
        pt = new Point(256, 256);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "D";
        pt = new Point(768, 768);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        System.out.println("DECOMP RULE");

        systemOut().clearHistory();
        tree.dump();
        String expected = "QuadTree dump:\n" + "Node at 0, 0, 1024: Internal\n"
            + "Node at 0, 0, 512:\n" + "(A, 256, 256)\n" + "(B, 256, 256)\n"
            + "(C, 256, 256)\n" + "Node at 512, 0, 512: Empty\n"
            + "Node at 0, 512, 512: Empty\n" + "Node at 512, 512, 512:\n"
            + "(D, 768, 768)\n" + "5 quadtree nodes printed\n";

        String actual = systemOut().getHistory();

        assertFuzzyEquals(expected, actual);
    }


    /**
     * Test adding five duplicate points
     * 
     * Then add an sixth and observe the split
     */
    public void testFiveDuplicatePoints() {
        String name;
        Point pt;
        KVPair<String, Point> pair;

        name = "A";
        pt = new Point(256, 256);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "B";
        pt = new Point(256, 256);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "C";
        pt = new Point(256, 256);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "D";
        pt = new Point(256, 256);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "E";
        pt = new Point(256, 256);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        systemOut().clearHistory();
        tree.dump();
        String expected = "QuadTree dump:\n" + "Node at 0, 0, 1024:\n"
            + "(A, 256, 256)\n" + "(B, 256, 256)\n" + "(C, 256, 256)\n"
            + "(D, 256, 256)\n" + "(E, 256, 256)\n"
            + "1 quadtree nodes printed\n";

        String actual = systemOut().getHistory();

        assertFuzzyEquals(expected, actual);

        // Now add a sixth and observe the split
        name = "F";
        pt = new Point(768, 768);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        systemOut().clearHistory();
        tree.dump();
        expected = "QuadTree dump:\n" + "Node at 0, 0, 1024: Internal\n"
            + "Node at 0, 0, 512:\n" + "(A, 256, 256)\n" + "(B, 256, 256)\n"
            + "(C, 256, 256)\n" + "(D, 256, 256)\n" + "(E, 256, 256)\n"
            + "Node at 512, 0, 512: Empty\n" + "Node at 0, 512, 512: Empty\n"
            + "Node at 512, 512, 512:\n" + "(F, 768, 768)\n"
            + "5 quadtree nodes printed\n";

        actual = systemOut().getHistory();

        assertFuzzyEquals(expected, actual);

    }


    /**
     * Test the region intersection method
     */
    public void testRegionIntersectsCurr() {
        int regionX;
        int regionY;
        int regionW;
        int regionH;
        int currX;
        int currY;
        int currS;

        // Set curr
        currX = 768;
        currY = 256;
        currS = 512;

        // Set region shape
        regionW = 100;
        regionH = 100;

        // Region intersects on the left
        regionX = 500;
        regionY = 200;
        assertTrue(tree.regionIntersectsCurr(regionX, regionY, regionW, regionH,
            currX, currY, currS));

        // Region intersects on the top
        regionX = 700;
        regionY = -50;
        assertTrue(tree.regionIntersectsCurr(regionX, regionY, regionW, regionH,
            currX, currY, currS));

        // Region intersects on the right
        regionX = 1000;
        regionY = 200;
        assertTrue(tree.regionIntersectsCurr(regionX, regionY, regionW, regionH,
            currX, currY, currS));

        // Region intersects on the bottom
        regionX = 700;
        regionY = 500;
        assertTrue(tree.regionIntersectsCurr(regionX, regionY, regionW, regionH,
            currX, currY, currS));

        // Region does not intersect
        regionX = 100;
        regionY = 600;
        assertFalse(tree.regionIntersectsCurr(regionX, regionY, regionW,
            regionH, currX, currY, currS));

        regionX = 100;
        regionY = 100;
        assertFalse(tree.regionIntersectsCurr(regionX, regionY, regionW,
            regionH, currX, currY, currS));

        regionX = 100;
        regionY = -200;
        assertFalse(tree.regionIntersectsCurr(regionX, regionY, regionW,
            regionH, currX, currY, currS));

        regionX = 600;
        regionY = 600;
        assertFalse(tree.regionIntersectsCurr(regionX, regionY, regionW,
            regionH, currX, currY, currS));
        regionX = 1100;
        regionY = 600;
        assertFalse(tree.regionIntersectsCurr(regionX, regionY, regionW,
            regionH, currX, currY, currS));

        regionX = 1100;
        regionY = 100;
        assertFalse(tree.regionIntersectsCurr(regionX, regionY, regionW,
            regionH, currX, currY, currS));

        regionX = 1100;
        regionY = -200;
        assertFalse(tree.regionIntersectsCurr(regionX, regionY, regionW,
            regionH, currX, currY, currS));

        regionX = 600;
        regionY = -200;
        assertFalse(tree.regionIntersectsCurr(regionX, regionY, regionW,
            regionH, currX, currY, currS));
    }


    /**
     * Test the regionsearch method
     */
    public void testRegionSearch() {
        // Insert all the points
        String name;
        Point pt;
        KVPair<String, Point> pair;

        name = "A";
        pt = new Point(640, 128);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "B";
        pt = new Point(896, 128);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "C";
        pt = new Point(896, 384);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "D";
        pt = new Point(256, 768);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "E";
        pt = new Point(640, 640);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "F";
        pt = new Point(896, 640);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "G";
        pt = new Point(640, 896);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "H";
        pt = new Point(896, 896);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "I";
        pt = new Point(128, 128);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "J";
        pt = new Point(384, 128);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "K";
        pt = new Point(128, 384);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "L";
        pt = new Point(384, 384);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

// System.out.println("REGIONSEARCH");
// tree.dump();

        int regionX;
        int regionY;
        int regionW;
        int regionH;

        // Region 1
        regionX = 512;
        regionY = 0;
        regionW = 512;
        regionH = 768;

        systemOut().clearHistory();
        tree.regionsearch(regionX, regionY, regionW, regionH);
        String expected = "Points intersecting region (512, 0, 512, 768)\n"
            + "Point found: (A, 640, 128)\n" + "Point found: (B, 896, 128)\n"
            + "Point found: (C, 896, 384)\n" + "Point found: (E, 640, 640)\n"
            + "Point found: (F, 896, 640)\n" + "5 quadtree nodes visited\n";

        String actual = systemOut().getHistory();

        assertFuzzyEquals(expected, actual);

        // Region 2
        regionX = 0;
        regionY = 512;
        regionW = 1024;
        regionH = 512;

        systemOut().clearHistory();
        tree.regionsearch(regionX, regionY, regionW, regionH);
        expected = "Points intersecting region (0, 512, 1024, 512)\n"
            + "Point found: (D, 256, 768)\n" + "Point found: (E, 640, 640)\n"
            + "Point found: (F, 896, 640)\n" + "Point found: (G, 640, 896)\n"
            + "Point found: (H, 896, 896)\n" + "7 quadtree nodes visited\n";

        actual = systemOut().getHistory();

        assertFuzzyEquals(expected, actual);

        // Region 3
        regionX = 768;
        regionY = 0;
        regionW = 256;
        regionH = 256;

        systemOut().clearHistory();
        tree.regionsearch(regionX, regionY, regionW, regionH);
        expected = "Points intersecting region (768, 0, 256, 256)\n"
            + "Point found: (B, 896, 128)\n" + "2 quadtree nodes visited\n";

        actual = systemOut().getHistory();

        assertFuzzyEquals(expected, actual);
    }


    /**
     * Test invalid region search
     */
    public void testInvalidRegionSearch() {
        systemOut().clearHistory();
        tree.regionsearch(0, 0, -1, 1);
        String expected = "Rectangle rejected: (0, 0, -1, 1)\n";

        String actual = systemOut().getHistory();

        assertFuzzyEquals(expected, actual);

        systemOut().clearHistory();
        tree.regionsearch(0, 0, 1, -1);
        expected = "Rectangle rejected: (0, 0, 1, -1)\n";

        actual = systemOut().getHistory();

        assertFuzzyEquals(expected, actual);

        systemOut().clearHistory();
        tree.regionsearch(0, 0, -1, -1);
        expected = "Rectangle rejected: (0, 0, -1, -1)\n";

        actual = systemOut().getHistory();

        assertFuzzyEquals(expected, actual);

    }


    /**
     * Test simple region search
     */
    public void testSimpleRegionSearch() {
        // TODO: write a simple test with at least one flyweight in the tree
        // Try to get code coverage in recursive method for isFlyweight(node)
        // return;

        // Insert all the points
        String name;
        Point pt;
        KVPair<String, Point> pair;

        name = "A";
        pt = new Point(128, 128);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "B";
        pt = new Point(128, 384);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "C";
        pt = new Point(768, 256);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "D";
        pt = new Point(256, 768);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        int regionX = 0;
        int regionY = 0;
        int regionW = 1024;
        int regionH = 1024;

        systemOut().clearHistory();
        tree.regionsearch(regionX, regionY, regionW, regionH);
        String expected = "Points intersecting region (0, 0, 1024, 1024)\n"
            + "Point found: (A, 128, 128)\n" + "Point found: (B, 128, 384)\n"
            + "Point found: (C, 768, 256)\n" + "Point found: (D, 256, 768)\n"
            + "5 quadtree nodes visited\n";

        String actual = systemOut().getHistory();

        assertFuzzyEquals(expected, actual);
    }


    /**
     * Test a basic call to remove
     */
    public void testBasicRemove() {
        String name;
        Point pt;
        KVPair<String, Point> pair;

        name = "A";
        pt = new Point(256, 256);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "B";
        pt = new Point(768, 256);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "C";
        pt = new Point(768, 768);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        System.out.println("BEFORE");
        tree.dump();

        // Remove C
        pt = new Point(768, 768);
        pair = tree.remove(pt);
        assertNotNull(pair);
        Point pt2 = pair.getValue();
        assertTrue(pt.equals(pt2));

        // Print
        System.out.println("AFTER");

        systemOut().clearHistory();
        tree.dump();

        String expected = "QuadTree dump:\n" + "Node at 0, 0, 1024:\n"
            + "(A, 256, 256)\n" + "(B, 768, 256)\n"
            + "1 quadtree nodes printed\n";

        String actual = systemOut().getHistory();

        assertFuzzyEquals(expected, actual);

    }

    /**
     * Test a remove with one split in the tree
     */
    public void testOneSplitRemove() {
        String name;
        Point pt;
        KVPair<String, Point> pair;

        name = "A";
        pt = new Point(128, 128);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "B";
        pt = new Point(384, 128);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "C";
        pt = new Point(768, 256);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "D";
        pt = new Point(256, 768);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "E";
        pt = new Point(640, 640);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "F";
        pt = new Point(896, 640);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        System.out.println("BEFORE");
        tree.dump();

        // Remove B
        pt = new Point(384, 128);
        pair = tree.remove(pt);
        assertNotNull(pair);
        Point pt2 = pair.getValue();
        assertTrue(pt.equals(pt2));

        // Remove F
        pt = new Point(896, 640);
        pair = tree.remove(pt);
        assertNotNull(pair);
        pt2 = pair.getValue();
        assertTrue(pt.equals(pt2));

        // Print
        System.out.println("AFTER");

        systemOut().clearHistory();
        tree.dump();

        String expected = "QuadTree dump:\n" + "Node at 0, 0, 1024: Internal\n"
            + "Node at 0, 0, 512:\n" + "(A, 128, 128)\n"
            + "Node at 512, 0, 512:\n" + "(C, 768, 256)\n"
            + "Node at 0, 512, 512:\n" + "(D, 256, 768)\n"
            + "Node at 512, 512, 512:\n" + "(E, 640, 640)\n"
            + "5 quadtree nodes printed\n";

        String actual = systemOut().getHistory();

        assertFuzzyEquals(expected, actual);

    }
    
    /**
     * Test the merge logic with a single merge
     */
    public void testSingleMerge() {
        String name;
        Point pt;
        KVPair<String, Point> pair;

        name = "A";
        pt = new Point(256, 256);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "B";
        pt = new Point(768, 256);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "C";
        pt = new Point(256, 768);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "D";
        pt = new Point(768, 768);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);
        
        System.out.println("BEFORE MERGE");
        tree.dump();
        
        // Remove D
        pt = new Point(768, 768);
        pair = tree.remove(pt);
        assertNotNull(pair);
        Point pt2 = pair.getValue();
        assertTrue(pt.equals(pt2));
        
        System.out.println("AFTER MERGE");
        
        systemOut().clearHistory();
        tree.dump();

        String expected = "QuadTree dump:\n" +
            "Node at 0, 0, 1024:\n" +
            "(A, 256, 256)\n" +
            "(B, 768, 256)\n" +
            "(C, 256, 768)\n" +
            "1 quadtree nodes printed\n";

        String actual = systemOut().getHistory();

        assertFuzzyEquals(expected, actual);
    }
    
    /**
     * Test removing an invalid point
     */
    public void testInvalidRemove() {
        String name;
        Point pt;
        KVPair<String, Point> pair;

        name = "A";
        pt = new Point(256, 256);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "B";
        pt = new Point(768, 256);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "C";
        pt = new Point(256, 768);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "D";
        pt = new Point(768, 768);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);
        
        System.out.println("BEFORE INVALID");
        
        systemOut().clearHistory();
        tree.dump();
        String before = systemOut().getHistory();
        
        pt = new Point(10, 10);
        pair = tree.remove(pt);
        assertNull(pair);
        
        System.out.println("AFTER INVALID");
        
        systemOut().clearHistory();
        tree.dump();
        String after = systemOut().getHistory();
        
        assertFuzzyEquals(before, after);
    }
    
    /**
     * Test double merge
     */
    public void testDoubleMerge() {
        String name;
        Point pt;
        KVPair<String, Point> pair;

        name = "A";
        pt = new Point(640, 128);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "B";
        pt = new Point(896, 128);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "C";
        pt = new Point(640, 384);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "D";
        pt = new Point(896, 384);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);
        
        System.out.println("BEFORE DOUBLE MERGE");
        tree.dump();
         
        // Remove D
        pt = new Point(896, 384);
        pair = tree.remove(pt);
        assertNotNull(pair);
        Point pt2 = pair.getValue();
        assertTrue(pt.equals(pt2));
        
        System.out.println("AFTER DOUBLE MERGE");
        
        systemOut().clearHistory();
        tree.dump();

        String expected = "QuadTree dump:\n" +
            "Node at 0, 0, 1024:\n" +
            "(A, 640, 128)\n" +
            "(B, 896, 128)\n" +
            "(C, 640, 384)\n" +
            "1 quadtree nodes printed\n";

        String actual = systemOut().getHistory();

        assertFuzzyEquals(expected, actual);
    }
    
    /**
     * Test double merge again
     */
    public void testDoubleMerge2() {
        String name;
        Point pt;
        KVPair<String, Point> pair;

        name = "A";
        pt = new Point(128, 640);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "B";
        pt = new Point(384, 640);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "C";
        pt = new Point(128, 896);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);

        name = "D";
        pt = new Point(384, 896);
        pair = new KVPair<String, Point>(name, pt);
        tree.insert(pair);
        
        System.out.println("BEFORE DOUBLE MERGE 2");
        tree.dump();
        
        // Test Remove Flyweight
        pt = new Point(768, 256);
        pair = tree.remove(pt);
        assertNull(pair);
        
        // Remove D
        pt = new Point(384, 896);
        pair = tree.remove(pt);
        assertNotNull(pair);
        Point pt2 = pair.getValue();
        assertTrue(pt.equals(pt2));
        
        System.out.println("AFTER DOUBLE MERGE 2");
        
        systemOut().clearHistory();
        tree.dump();

        String expected = "QuadTree dump:\n" +
            "Node at 0, 0, 1024:\n" +
            "(A, 128, 640)\n" +
            "(B, 384, 640)\n" +
            "(C, 128, 896)\n" +
            "1 quadtree nodes printed\n";

        String actual = systemOut().getHistory();

        assertFuzzyEquals(expected, actual);
    }
    
    // TODO: Test internal node collapsing to leaf node
    // Remember to check duplicate points!
    // Are duplicate points covered by canInsert check in merge?
    
    
    

// /**
// * Test the dump method on an empty tree
// */
// public void testEmptyDump() {
//// String name;
//// Point pt;
//// KVPair<String, Point> pair;
////
//// name = "A";
//// pt = new Point(128, 128);
//// pair = new KVPair<String, Point>(name, pt);
//// tree.insert(pair);
//
// tree.dump();
// }

}
