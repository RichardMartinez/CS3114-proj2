
/**
 * This is the interface for a node in the
 * PRQuadTree. All nodes in the tree must
 * conform to this interface.
 * 
 * @author Richard Martinez
 * 
 * @version 2024-03-15
 */
public interface QuadNode {

    /**
     * Insert into the node
     * 
     * @param it
     *            KVPair to be inserted
     */
    public void insert(KVPair<String, Point> it);


    /**
     * Remove from the node
     * 
     * @param pt
     *            The point to remove
     * @return
     *         The KVPair that was removed
     */
    public KVPair<String, Point> remove(Point pt);

    // TODO: Add regionsearch, duplicates, dump


    /**
     * Returns true if this node can insert it
     * 
     * @param it
     *            The KVPair to check
     * @return true if can insert
     */
    public boolean canInsert(KVPair<String, Point> it);


    /**
     * Returns true if leaf
     * 
     * @return true if leaf
     */
    public boolean isLeaf();

}
