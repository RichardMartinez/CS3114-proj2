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
    
    // TODO: Basic insert
    
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
        
        // TODO: Test somehow the structure using dump?
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

        // TODO: test with dump()?
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
        
        // TODO: test with dump
    }

}
