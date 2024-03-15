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
        
        assertTrue(node.canInsert(pair));
        node.insert(pair);
        
        assertTrue(node.containsPoint(pt));
        assertTrue(node.containsName(name));
    }
    
    /**
     * Test inserting a duplicate point
     */
    public void testDuplicatePoint() {
        String name;
        Point pt;
        KVPair<String, Point> pair;
        
        name = "a";
        pt = new Point(1, 2);
        pair = new KVPair<String, Point>(name, pt);
        
        assertTrue(node.canInsert(pair));
        node.insert(pair);
        
        name = "b";
        pt = new Point(1, 2);
        pair = new KVPair<String, Point>(name, pt);
        
        assertTrue(node.canInsert(pair));
        node.insert(pair);
        
        assertTrue(node.containsPoint(pt));
        assertTrue(node.containsName("a"));
        assertTrue(node.containsName("b"));   
    }
    
    /**
     * Test inserting a duplicate name
     */
    public void testDuplicateName() {
        String name;
        Point pt;
        KVPair<String, Point> pair;
        
        name = "a";
        pt = new Point(1, 2);
        pair = new KVPair<String, Point>(name, pt);
        
        assertTrue(node.canInsert(pair));
        node.insert(pair);
        
        name = "a";
        pt = new Point(3, 4);
        pair = new KVPair<String, Point>(name, pt);
        
        assertTrue(node.canInsert(pair));
        node.insert(pair);
        
        name = "a";
        pt = new Point(5, 6);
        pair = new KVPair<String, Point>(name, pt);
        
        assertTrue(node.canInsert(pair));
        node.insert(pair);
        
        name = "b";
        pt = new Point(7, 8);
        pair = new KVPair<String, Point>(name, pt);
        
        assertFalse(node.canInsert(pair));
        node.insert(pair);  // Nothing should happen
        
        assertTrue(node.containsName("a"));
        assertFalse(node.containsName("b"));
        
    }
    
//    /**
//     * Test inserting an exact copy.
//     * This should not be allowed.
//     */
//    public void testDuplicateCopy() {
//        String name;
//        Point pt;
//        KVPair<String, Point> pair;
//        
//        name = "a";
//        pt = new Point(1, 2);
//        pair = new KVPair<String, Point>(name, pt);
//        node.insert(pair);
//        
//        name = "a";
//        pt = new Point(1, 2);
//        pair = new KVPair<String, Point>(name, pt);
//        node.insert(pair);
//        
//    }
//    
//    /**
//     * Test insert method with multiple inserts
//     */
//    public void testInsert() {
//        String name;
//        Point pt;
//        KVPair<String, Point> pair;
//        
//        name = "a";
//        pt = new Point(1, 2);
//        pair = new KVPair<String, Point>(name, pt);
//        node.insert(pair);
//        
//        name = "b";
//        pt = new Point(3, 4);
//        pair = new KVPair<String, Point>(name, pt);
//        node.insert(pair);
//        
//        name = "c";
//        pt = new Point(5, 6);
//        pair = new KVPair<String, Point>(name, pt);
//        node.insert(pair);
//    }
    
//    /**
//     * Test the basic isFull method
//     */
//    public void testIsFull() {
//       assertFalse(node.isFull());
//    }

}
