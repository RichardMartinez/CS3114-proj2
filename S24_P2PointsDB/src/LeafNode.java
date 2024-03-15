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
        // Set up the Points List of Lists
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
        if (canInsert(point1, it)) {
            point1.add(it);
            return;
        }
        else if (canInsert(point2, it)) {
            point2.add(it);
            return;
        }
        else if (canInsert(point3, it)) {
            point3.add(it);
            return;
        }
        
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
    
//    /**
//     * Return true if three unique points in the node
//     * @return true if full
//     */
//    public boolean isFull() {
//        boolean p1Empty = isEmptyList(point1);
//        boolean p2Empty = isEmptyList(point2);
//        boolean p3Empty = isEmptyList(point3);
//        
//        // If all are not empty, then we are full
//        // If statements for better mutation testing
//        if (!p1Empty) {
//            if (!p2Empty) {
//                if (!p3Empty) {
//                    return true;
//                }
//            }
//        }
//        return false;
//        
//    }
    
    /**
     * Return true if KVPair can be inserted in List
     * @param list
     *      List to check against
     * @param it
     *      KVPair to be inserted
     * @return true if can be inserted
     */
    public boolean canInsert(LinkedList<KVPair<String, Point>> list, KVPair<String, Point> it) {
        // We can insert if list is empty OR
        // if the given KVPair point coordinates match one of the lists
        boolean isEmpty = isEmptyList(list);
        boolean containsPoint = listContainsPoint(list, it);
        
        return (isEmpty || containsPoint);
    }
    
    /**
     * Return true if the given Point matches this list
     * @param list
     *      The list to check against
     * @param it
     *      The KVPair to check
     * @return true if match
     */
    public boolean listContainsPoint(LinkedList<KVPair<String, Point>> list, KVPair<String, Point> it) {
        if (isEmptyList(list)) {
            return false;
        }
        
        Point pt1 = it.getValue();
        Point pt2 = list.getFirst().getValue();
        
        return pt1.equals(pt2);
    }
    
    /**
     * Returns true if the overall node contains the point
     * @param it
     *      The KVPair to check
     * @return true if node contains Point
     */
    public boolean containsPoint(KVPair<String, Point> it) {
        boolean point1Contains = listContainsPoint(point1, it);
        boolean point2Contains = listContainsPoint(point2, it);
        boolean point3Contains = listContainsPoint(point3, it);
        
        return (point1Contains || point2Contains || point3Contains);
    }

}
