
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
    
    /**
     * Constructor for PRQuadTree
     */
    public PRQuadTree() {
        
    }
    
    /**
     * Insert a KVPair into the tree
     * 
     * @param it
     *      The KVPair to be inserted
     */
    public void insert(KVPair<String, Point> it) {
        
    }
    
    /**
     * Remove the given Point from the tree. If the point
     * is not found, return null.
     * 
     * @param pt
     *      The Point to be removed
     * @return
     *      The KVPair that was removed
     */
    public KVPair<String, Point> remove(Point pt) {
        
        return null;
    }
    
    /**
     * Traverses the tree and reports all points within the
     * described region. Outputs to standard out.
     * 
     * @param x
     *      X coordinate of the top-left corner of the region
     * @param y
     *      Y coordinate of the top-left corner of the region
     * @param w
     *      width of the region
     * @param h
     *      height of the region
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
}


