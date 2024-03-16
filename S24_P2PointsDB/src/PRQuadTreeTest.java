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
        
        
    }

}
