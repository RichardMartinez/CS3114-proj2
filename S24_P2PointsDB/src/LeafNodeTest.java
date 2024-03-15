import student.TestCase;

/**
 * This class tests the methods of the LeafNode class.
 * 
 * @author Richard Martinez
 * 
 * @version 2024-03-15
 */

public class LeafNodeTest extends TestCase{
    
    private LeafNode node;
    
    /**
     * Set up the test object
     */
    public void setUp() {
        node = new LeafNode();
    }
    
    /**
     * Test basic insert method
     */
    public void testBasicInsert() {
        String name = "a";
        Point pt = new Point(1, 2);
        KVPair<String, Point> pair = new KVPair<String, Point>(name, pt);
        node.insert(pair);
        assertTrue(node.containsPoint(pair));
    }
    
//    /**
//     * Test the basic isFull method
//     */
//    public void testIsFull() {
//       assertFalse(node.isFull());
//    }

}
