
/**
 * This class implements the PRQuadTree data structure.
 * The Point Region QuadTree is a spatial data structure
 * that organizes points into quadrants. These quadrants
 * can then be recursively traversed the efficiently
 * respond to spatial queries.
 * 
 * @author Richard Martinez
 * 
 * @version 2024-03-13
 */
public class PRQuadTree {
    
    // The flyweight node
    private QuadNode flyweight;
    
    // Root node
    private QuadNode root;
    
    // TODO: Create recursive helper methods
    // Then call them on root for overall method

    /**
     * Constructor for PRQuadTree
     */
    public PRQuadTree() {
        // Initialize the flyweight and root
        flyweight = new LeafNode();
        root = flyweight;
    }


    /**
     * Insert a KVPair into the tree
     * 
     * @param it
     *            The KVPair to be inserted
     */
    public void insert(KVPair<String, Point> it) {
        // Call the recursive helper function
        inserthelp(it, root);
    }
    
    /**
     * Recursive helper function for insert
     */
    public void inserthelp(KVPair<String, Point> it, QuadNode node) {
        // Base case for flyweight node
        if (isFlyweight(node)) {
            node = new LeafNode();
            return;
        }
        // TODO: How to use recursion here?
        // Does this insert auto use recursion?
        node.insert(it);
        
        
    }


    /**
     * Remove the given Point from the tree. If the point
     * is not found, return null.
     * 
     * @param pt
     *            The Point to be removed
     * @return
     *         The KVPair that was removed
     */
    public KVPair<String, Point> remove(Point pt) {

        return null;
    }


    /**
     * Traverses the tree and reports all points within the
     * described region. Outputs to standard out.
     * 
     * @param x
     *            X coordinate of the top-left corner of the region
     * @param y
     *            Y coordinate of the top-left corner of the region
     * @param w
     *            width of the region
     * @param h
     *            height of the region
     */
    public void regionsearch(int x, int y, int w, int h) {

    }


    /**
     * Traverses the tree and reports all points that have
     * duplicate coordinates. Outputs to standard out.
     */
    public void duplicates() {

    }


    /**
     * Traverses the tree and outputs the structure to
     * standard out. Used to observe internal structure
     * of the tree at runtime.
     */
    public void dump() {

    }
    
    /**
     * Returns true if the node is flyweight
     * @return true if node is flyweight
     */
    public boolean isFlyweight(QuadNode node) {
        return (node == flyweight);
    }
}
