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
        
        String expected = "QuadTree dump:\n" +
            "Node at 0, 0, 1024: Internal\n" +
            "Node at 0, 0, 512:\n" +
            "(A, 256, 256)\n" +
            "Node at 512, 0, 512:\n" +
            "(C, 768, 256)\n" +
            "Node at 0, 512, 512:\n" +
            "(B, 256, 768)\n" +
            "Node at 512, 512, 512:\n" +
            "(D, 768, 768)\n" +
            "5 quadtree nodes printed\n";
        
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
        
        String expected = "QuadTree dump:\n" +
            "Node at 0, 0, 1024: Internal\n" +
            "Node at 0, 0, 512: Internal\n" +
            "Node at 0, 0, 256:\n" +
            "(A, 128, 128)\n" +
            "Node at 256, 0, 256:\n" +
            "(E, 384, 128)\n" +
            "Node at 0, 256, 256:\n" +
            "(F, 128, 384)\n" +
            "Node at 256, 256, 256:\n" +
            "(G, 384, 384)\n" +
            "Node at 512, 0, 512:\n" +
            "(C, 768, 256)\n" +
            "Node at 0, 512, 512:\n" +
            "(B, 256, 768)\n" +
            "Node at 512, 512, 512:\n" +
            "(D, 768, 768)\n" +
            "9 quadtree nodes printed\n";
        
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
        
        String expected = "QuadTree dump:\n" +
            "Node at 0, 0, 1024: Internal\n" +
            "Node at 0, 0, 512: Internal\n" +
            "Node at 0, 0, 256: Internal\n" +
            "Node at 0, 0, 128:\n" +
            "(A, 64, 64)\n" +
            "Node at 128, 0, 128:\n" +
            "(B, 192, 64)\n" +
            "Node at 0, 128, 128:\n" +
            "(C, 64, 192)\n" +
            "Node at 128, 128, 128:\n" +
            "(D, 192, 192)\n" +
            "Node at 256, 0, 256: Empty\n" +
            "Node at 0, 256, 256: Empty\n" +
            "Node at 256, 256, 256: Empty\n" +
            "Node at 512, 0, 512: Internal\n" +
            "Node at 512, 0, 256: Empty\n" +
            "Node at 768, 0, 256: Internal\n" +
            "Node at 768, 0, 128:\n" +
            "(I, 832, 64)\n" +
            "Node at 896, 0, 128:\n" +
            "(J, 960, 64)\n" +
            "Node at 768, 128, 128:\n" +
            "(K, 832, 192)\n" +
            "Node at 896, 128, 128:\n" +
            "(L, 960, 192)\n" +
            "Node at 512, 256, 256: Empty\n" +
            "Node at 768, 256, 256: Empty\n" +
            "Node at 0, 512, 512: Internal\n" +
            "Node at 0, 512, 256: Empty\n" +
            "Node at 256, 512, 256: Empty\n" +
            "Node at 0, 768, 256: Internal\n" +
            "Node at 0, 768, 128:\n" +
            "(E, 64, 832)\n" +
            "Node at 128, 768, 128:\n" +
            "(F, 192, 832)\n" +
            "Node at 0, 896, 128:\n" +
            "(G, 64, 960)\n" +
            "Node at 128, 896, 128:\n" +
            "(H, 192, 960)\n" +
            "Node at 256, 768, 256: Empty\n" +
            "Node at 512, 512, 512: Internal\n" +
            "Node at 512, 512, 256: Empty\n" +
            "Node at 768, 512, 256: Empty\n" +
            "Node at 512, 768, 256: Empty\n" +
            "Node at 768, 768, 256: Internal\n" +
            "Node at 768, 768, 128:\n" +
            "(M, 832, 832)\n" +
            "Node at 896, 768, 128:\n" +
            "(N, 960, 832)\n" +
            "Node at 768, 896, 128:\n" +
            "(O, 832, 960)\n" +
            "Node at 896, 896, 128:\n" +
            "(P, 960, 960)\n" +
            "37 quadtree nodes printed\n";
        
        assertFuzzyEquals(actual, expected);
    }
    
//    /**
//     * Test a different layout of the 16 points
//     */
//    public void testSixteenPoints2() {
//        
//    }
    
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
        
        String expected = "QuadTree dump:\n" +
            "Node at 0, 0, 1024: Internal\n" +
            "Node at 0, 0, 512:\n" +
            "(A, 256, 256)\n" +
            "Node at 512, 0, 512:\n" +
            "(D, 768, 256)\n" +
            "Node at 0, 512, 512:\n" +
            "(B, 256, 768)\n" +
            "(C, 256, 768)\n" +
            "(D, 256, 768)\n" +
            "Node at 512, 512, 512:\n" +
            "(A, 768, 768)\n" +
            "5 quadtree nodes printed\n";
        
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
        
//        name = "I";
//        pt = new Point(256, 768);
//        pair = new KVPair<String, Point>(name, pt);
//        tree.insert(pair);
        
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
        
        systemOut().clearHistory();
        tree.duplicates();
        String expected = "Duplicate points:\n" +
            "(128, 128)\n" +
            "(384, 128)\n" +
            "(768, 256)\n" +
            "(640, 128)\n" +
            "(768, 768)\n" +
            "(640, 640)\n" +
            "(896, 896)\n";
        
        String actual = systemOut().getHistory();
        assertFuzzyEquals(expected, actual);
    }
    
//    /**
//     * Test to make sure that we are splitting correctly
//     */
//    public void testSplitting() {
//        String name;
//        Point pt;
//        KVPair<String, Point> pair;
//        
//        name = "A";
//        pt = new Point(576, 576);
//        pair = new KVPair<String, Point>(name, pt);
//        tree.insert(pair);
//
//        name = "B";
//        pt = new Point(640, 896);
//        pair = new KVPair<String, Point>(name, pt);
//        tree.insert(pair);
//        
//        name = "C";
//        pt = new Point(896, 896);
//        pair = new KVPair<String, Point>(name, pt);
//        tree.insert(pair);
//        
//        name = "D";
//        pt = new Point(704, 704);
//        pair = new KVPair<String, Point>(name, pt);
//        tree.insert(pair);
//        
//        name = "E";
//        pt = new Point(704, 576);
//        pair = new KVPair<String, Point>(name, pt);
//        tree.insert(pair);
//        
//        name = "F";
//        pt = new Point(576, 704);
//        pair = new KVPair<String, Point>(name, pt);
//        tree.insert(pair);
//        
//        System.out.println("HERE");
//        tree.dump();
//        
//    }
    
//    /**
//     * Test the dump method on an empty tree
//     */
//    public void testEmptyDump() {
////        String name;
////        Point pt;
////        KVPair<String, Point> pair;
////        
////        name = "A";
////        pt = new Point(128, 128);
////        pair = new KVPair<String, Point>(name, pt);
////        tree.insert(pair);
//        
//        tree.dump();
//    }

}
