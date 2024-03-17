
/**
 * This is the interface for a node in the
 * PRQuadTree. All nodes in the tree must
 * conform to this interface.
 */
public interface QuadNode {

    public void insert(KVPair<String, Point> it);


    public KVPair<String, Point> remove(Point pt);

    // TODO: Add regionsearch, duplicates, dump


    public boolean canInsert(KVPair<String, Point> it);


    public boolean isLeaf();

}
