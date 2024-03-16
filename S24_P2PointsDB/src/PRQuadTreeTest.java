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
     * Test the insert method
     */
    public void testInsert() {
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
        
        int x = 1;
    }

}
