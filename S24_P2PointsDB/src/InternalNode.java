
/**
 * This class represents and internal node in
 * the PRQuadTree. It contains no data other
 * than the pointers to its 4 children.
 */
public class InternalNode implements QuadNode {
    private LeafNode nw;
    private LeafNode ne;
    private LeafNode sw;
    private LeafNode se;
    
    /**
     * Insert into the Node.
     * This is an internal node, so we must traverse to
     * one of its children recursively.
     * 
     * @param it
     *      The KVPair to be inserted
     */
    public void insert(KVPair<String, Point> it) {
        
    }
    
    /**
     * Remove from the Node.
     * This is an internal node, so we must traverse to
     * one of its children recursively.
     * 
     * @param pt
     *      The Point to be removed.
     */
    public KVPair<String, Point> remove(Point pt) {
        
        return null;
    }

}
