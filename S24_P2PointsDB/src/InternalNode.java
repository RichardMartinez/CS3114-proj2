
/**
 * This class represents and internal node in
 * the PRQuadTree. It contains no data other
 * than the pointers to its 4 children.
 */
public class InternalNode implements QuadNode {
    private QuadNode nw;
    private QuadNode ne;
    private QuadNode sw;
    private QuadNode se;
    
    /**
     * Construct the internal node
     */
    public InternalNode(QuadNode nw, QuadNode ne, QuadNode sw, QuadNode se) {
        this.nw = nw;
        this.ne = ne;
        this.sw = sw;
        this.se = se;
    }
    
    /**
     * Return false because this is an internal node
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
    
    /**
     * canInsert method for Internal node.
     * You cannot insert into an internal node.
     */
    public boolean canInsert(KVPair<String, Point> it) {
        return false;
    }
    
    /**
     * Return the northwest leaf node
     * @return nw
     */
    public QuadNode northwest() {
        return nw;
    }
    
    /**
     * Return the northeast leaf node
     * @return ne
     */
    public QuadNode northeast() {
        return ne;
    }
    
    /**
     * Return the southwest leaf node
     * @return sw
     */
    public QuadNode southwest() {
        return sw;
    }
    
    /**
     * Return the southeast leaf node
     * @return se
     */
    public QuadNode southeast() {
        return se;
    }
    
    /**
     * Set the nw child
     */
    public void setNorthwest(QuadNode node) {
        nw = node;
    }
    
    /**
     * Set the ne child
     */
    public void setNortheast(QuadNode node) {
        ne = node;
    }
    
    /**
     * Set the sw child
     */
    public void setSouthwest(QuadNode node) {
        sw = node;
    }
    
    /**
     * Set the se child
     */
    public void setSoutheast(QuadNode node) {
        se = node;
    }

}
