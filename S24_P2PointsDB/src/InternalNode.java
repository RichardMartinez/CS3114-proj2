
/**
 * This class represents and internal node in
 * the PRQuadTree. It contains no data other
 * than the pointers to its 4 children.
 * 
 * @author Richard Martinez
 * 
 * @version 2024-03-15
 */
public class InternalNode implements QuadNode {
    private QuadNode nw;
    private QuadNode ne;
    private QuadNode sw;
    private QuadNode se;

    /**
     * Construct the internal node
     * 
     * @param nw
     *            The northwest child
     * @param ne
     *            The northeast child
     * @param sw
     *            The southwest child
     * @param se
     *            The southeast child
     */
    public InternalNode(QuadNode nw, QuadNode ne, QuadNode sw, QuadNode se) {
        this.nw = nw;
        this.ne = ne;
        this.sw = sw;
        this.se = se;
    }


    /**
     * Return false because this is an internal node
     * 
     * @return true if leaf
     */
    public boolean isLeaf() {
        return false;
    }


    /**
     * Insert into the Node.
     * This is an internal node, so we must traverse to
     * one of its children recursively.
     * 
     * @param it
     *            The KVPair to be inserted
     */
    public void insert(KVPair<String, Point> it) {
        // Nothing to do because you can't insert
    }


    /**
     * Remove from the Node.
     * This is an internal node, so we must traverse to
     * one of its children recursively.
     * 
     * @param pt
     *            The Point to be removed.
     * @return KVPair that was removed
     */
    public KVPair<String, Point> remove(Point pt) {
        // Nothing to do because you can't remove
        return null;
    }


    /**
     * canInsert method for Internal node.
     * You cannot insert into an internal node.
     * 
     * @param it
     *            KVPair to check against
     * 
     * @return false
     */
    public boolean canInsert(KVPair<String, Point> it) {
        return false;
    }
    
    /**
     * Returns the number of points from this internal node
     * recursively
     */
    public int numPoints() {
        return nw.numPoints() + ne.numPoints() + sw.numPoints() + se.numPoints();
    }
    
    /**
     * Returns true if all children are leaf nodes
     * @return true if all leaf children
     */
    public boolean allLeafChildren() {
        // Nest for mutation testing
        if (nw.isLeaf()) {
            if (ne.isLeaf()) {
                if (sw.isLeaf()) {
                    if (se.isLeaf()) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }


    /**
     * Return the northwest leaf node
     * 
     * @return nw
     */
    public QuadNode northwest() {
        return nw;
    }


    /**
     * Return the northeast leaf node
     * 
     * @return ne
     */
    public QuadNode northeast() {
        return ne;
    }


    /**
     * Return the southwest leaf node
     * 
     * @return sw
     */
    public QuadNode southwest() {
        return sw;
    }


    /**
     * Return the southeast leaf node
     * 
     * @return se
     */
    public QuadNode southeast() {
        return se;
    }


    /**
     * Set the nw child
     * 
     * @param node
     *            The node to set
     */
    public void setNorthwest(QuadNode node) {
        nw = node;
    }


    /**
     * Set the ne child
     * 
     * @param node
     *            The node to set
     */
    public void setNortheast(QuadNode node) {
        ne = node;
    }


    /**
     * Set the sw child
     * 
     * @param node
     *            The node to set
     */
    public void setSouthwest(QuadNode node) {
        sw = node;
    }


    /**
     * Set the se child
     * 
     * @param node
     *            The node to set
     */
    public void setSoutheast(QuadNode node) {
        se = node;
    }

}
