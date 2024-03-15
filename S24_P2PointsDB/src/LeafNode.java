import java.util.LinkedList;

/**
 * This class represent the leaf nodes for
 * the PRQuadTree.
 */
public class LeafNode implements QuadNode {
    
    // Linked Lists of Points
    private LinkedList<KVPair<String, Point>> point1;
    private LinkedList<KVPair<String, Point>> point2;
    private LinkedList<KVPair<String, Point>> point3;
    
    /**
     * Construct the LeafNode
     */
    public LeafNode() {
        // Set up the Points Lists
        point1 = new LinkedList<KVPair<String, Point>>();
        point2 = new LinkedList<KVPair<String, Point>>();
        point3 = new LinkedList<KVPair<String, Point>>();

    }
    
    /**
     * Insert into the Node.
     * This is an leaf node, so we can add it here.
     * But, first we must check capacity and split if
     * necessary.
     * 
     * @param it
     *      The KVPair to be inserted
     */
    public void insert(KVPair<String, Point> it) {
        // At this point assume there is capacity
        // Helper method should check if node is full
        // before calling this
        
        // Insert the point if we can
        if (canInsertList(point1, it)) {
            point1.add(it);
        }
        else if (canInsertList(point2, it)) {
            point2.add(it);
        }
        else if (canInsertList(point3, it)) {
            point3.add(it);
        }
        // Nothing happens here, node should have split
        // before it got here
        
    }
    
    /**
     * Remove from the Node.
     * This is an leaf node, so we can remove from here.
     * But, first we must check if the node contains pt
     * and after we remove, we might have to collapse
     * if necessary.
     * 
     * @param pt
     *      The Point to be removed.
     */
    public KVPair<String, Point> remove(Point pt) {
        
        return null;
    }
    
    /**
     * Checks if the given linked list is empty
     * @return true if empty
     */
    public boolean isEmptyList(LinkedList<KVPair<String, Point>> list) {
        return (list.size() == 0);
    }
        
    /**
     * Return true if KVPair can be inserted in List
     * Used for internal decisions
     * @param list
     *      List to check against
     * @param it
     *      KVPair to be inserted
     * @return true if can be inserted
     */
    public boolean canInsertList(LinkedList<KVPair<String, Point>> list, KVPair<String, Point> it) {
        // NOTE: Does this matter? Only takes effect if trying to insert
        // exact copy
//        if (listContainsExactCopy(list, it)) {
//            return false;
//        }
        
        // We can insert if list is empty OR
        // if the given KVPair point coordinates match one of the lists
        boolean isEmpty = isEmptyList(list);
        
        Point pt = it.getValue();
        boolean containsPoint = listContainsPoint(list, pt);
        
        return (isEmpty || containsPoint);
    }
    
    /**
     * Returns true if the overall node can insert it
     * Used for external splitting decisions
     * @param it
     *      KVPair to be inserted
     * @return true if can insert
     */
    public boolean canInsert(KVPair<String, Point> it) {
        boolean point1Can = canInsertList(point1, it);
        boolean point2Can = canInsertList(point2, it);
        boolean point3Can = canInsertList(point3, it);
        
        return (point1Can || point2Can || point3Can);
    }
    
    /**
     * Return true if the given Point matches this list
     * @param list
     *      The list to check against
     * @param it
     *      The point to check
     * @return true if match
     */
    public boolean listContainsPoint(LinkedList<KVPair<String, Point>> list, Point pt) {
        if (isEmptyList(list)) {
            return false;
        }
        
        Point pt2 = list.getFirst().getValue();
        
        return pt.equals(pt2);
    }
    
    /**
     * Returns true if the overall node contains the point
     * @param it
     *      The point to check
     * @return true if node contains Point
     */
    public boolean containsPoint(Point pt) {
        boolean point1Contains = listContainsPoint(point1, pt);
        boolean point2Contains = listContainsPoint(point2, pt);
        boolean point3Contains = listContainsPoint(point3, pt);
        
        return (point1Contains || point2Contains || point3Contains);
    }
    
    /**
     * Returns true if the given name is in the list
     * @param list
     *      The list to check against
     * @param name
     *      THe name to check
     * @return
     */
    public boolean listContainsName(LinkedList<KVPair<String, Point>> list, String name) {
        if (isEmptyList(list)) {
            return false;
        }
        
        for (KVPair<String, Point> pair : list) {
            String name2 = pair.getKey();
            if (name.equals(name2)) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Returns true if the overall node contains the name
     * @param name
     *      The name to check
     * @return true if contains
     */
    public boolean containsName(String name) {
        boolean point1Contains = listContainsName(point1, name);
        boolean point2Contains = listContainsName(point2, name);
        boolean point3Contains = listContainsName(point3, name);
        
        return (point1Contains || point2Contains || point3Contains);
    }
    
    /**
     * NOTE: Should this be removed??
     * If we can safely assume we will never insert exact
     * copies, we can remove this.
     * 
     * Returns true if list contains exact copy
     * @param list
     *      List to check against
     * @param pair
     *      Pair to check
     * @return true if contained
     */
//    public boolean listContainsExactCopy(LinkedList<KVPair<String, Point>> list, KVPair<String, Point> pair) {
//        if (isEmptyList(list)) {
//            return false;
//        }
//        
//        String name = pair.getKey();
//        Point pt = pair.getValue();
//
//        for (KVPair<String, Point> item : list) {
//            String name2 = item.getKey();
//            Point pt2 = item.getValue();
//            if (name.equals(name2) && pt.equals(pt2)) {
//                return true;
//            }
//        }
//        
//        return false;
//    }

}
