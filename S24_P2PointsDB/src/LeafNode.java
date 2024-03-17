import java.util.LinkedList;

/**
 * This class represent the leaf nodes for
 * the PRQuadTree.
 * 
 * @author Richard Martinez
 * 
 * @version 2024-03-15
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
     * Return true because this is a leaf node
     * 
     * @return true
     */
    public boolean isLeaf() {
        return true;
    }


    /**
     * Insert into the Node.
     * This is an leaf node, so we can add it here.
     * But, first we must check capacity and split if
     * necessary.
     * 
     * @param it
     *            The KVPair to be inserted
     */
    public void insert(KVPair<String, Point> it) {
        // At this point assume there is capacity
        // Helper method should check if node is full
        // before calling this

        if (!canInsert(it)) {
            return;
        }

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
     *            The Point to be removed.
     * @return KVPair that was removed or null if not found
     */
    public KVPair<String, Point> remove(Point pt) {
        if (!containsPoint(pt)) {
            return null;
        }

        KVPair<String, Point> pair;

        // Check which list it is in
        if (listContainsPoint(point1, pt)) {
            // Remove it
            pair = point1.removeFirst();
            if (isEmptyList(point1)) {
                // Need to shift everything
                // Move everything from point2 to point1
                while (!isEmptyList(point2)) {
                    KVPair<String, Point> item = point2.removeFirst();
                    point1.add(item);
                }

                // Move everything from point3 to point2
                while (!isEmptyList(point3)) {
                    KVPair<String, Point> item = point3.removeFirst();
                    point2.add(item);
                }
            }
        }
        else if (listContainsPoint(point2, pt)) {
            pair = point2.removeFirst();
            if (isEmptyList(point2)) {
                // Move everything from point3 to point2
                while (!isEmptyList(point3)) {
                    KVPair<String, Point> item = point3.removeFirst();
                    point2.add(item);
                }
            }
        }
        else if (listContainsPoint(point3, pt)) {
            pair = point3.removeFirst();
            // No need to shift
        }
        else {
            // This will never run
            pair = null;
        }

        return pair;
    }


    /**
     * Checks if the given linked list is empty
     * 
     * @param list
     *            The list to check
     * 
     * @return true if empty
     */
    public boolean isEmptyList(LinkedList<KVPair<String, Point>> list) {
        return (list.size() == 0);
    }


    /**
     * Return true if KVPair can be inserted in List
     * Used for internal decisions
     * 
     * @param list
     *            List to check against
     * @param it
     *            KVPair to be inserted
     * @return true if can be inserted
     */
    public boolean canInsertList(
        LinkedList<KVPair<String, Point>> list,
        KVPair<String, Point> it) {
        // NOTE: Does this matter? Only takes effect if trying to insert
        // exact copy
// if (listContainsExactCopy(list, it)) {
// return false;
// }

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
     * 
     * @param it
     *            KVPair to be inserted
     * @return true if can insert
     */
    public boolean canInsert(KVPair<String, Point> it) {
        // New canInsert method match the decomposition rule
        int numPointsStored = point1.size() + point2.size() + point3.size();
        if (numPointsStored < 3) {
            return true;
        }

        if (point1.size() == numPointsStored) { // All points in point1
            Point d = it.getValue(); // This is D
            Point a = point1.getFirst().getValue(); // This is A
            return d.equals(a);
        }

        return false;
    }


    /**
     * Return true if the given Point matches this list
     * 
     * @param list
     *            The list to check against
     * @param pt
     *            The point to check
     * @return true if match
     */
    public boolean listContainsPoint(
        LinkedList<KVPair<String, Point>> list,
        Point pt) {
        if (isEmptyList(list)) {
            return false;
        }

        Point pt2 = list.getFirst().getValue();

        return pt.equals(pt2);
    }


    /**
     * Returns true if the overall node contains the point
     * 
     * @param pt
     *            The point to check
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
     * 
     * @param list
     *            The list to check against
     * @param name
     *            THe name to check
     * @return true if contained
     */
    public boolean listContainsName(
        LinkedList<KVPair<String, Point>> list,
        String name) {
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
     * 
     * @param name
     *            The name to check
     * @return true if contains
     */
    public boolean containsName(String name) {
        boolean point1Contains = listContainsName(point1, name);
        boolean point2Contains = listContainsName(point2, name);
        boolean point3Contains = listContainsName(point3, name);

        return (point1Contains || point2Contains || point3Contains);
    }


    /**
     * Return all the points in this node as a single list.
     * This is used to split the leaf node.
     * 
     * @return a linked list of all the points in this node
     */
    public LinkedList<KVPair<String, Point>> getPoints() {
        LinkedList<KVPair<String, Point>> points =
            new LinkedList<KVPair<String, Point>>();

        for (KVPair<String, Point> pair : point1) {
            points.add(pair);
        }

        for (KVPair<String, Point> pair : point2) {
            points.add(pair);
        }

        for (KVPair<String, Point> pair : point3) {
            points.add(pair);
        }

        return points;
    }


    /**
     * Returns a list of all the points that are duplicates.
     * 
     * @return a linked list of all duplicate points
     */
    public LinkedList<KVPair<String, Point>> getDuplicates() {
        LinkedList<KVPair<String, Point>> points =
            new LinkedList<KVPair<String, Point>>();

        if (point1.size() > 1) {
            // There is a duplicate!
            KVPair<String, Point> pair = point1.getFirst();
            points.add(pair);
        }

        if (point2.size() > 1) {
            // There is a duplicate!
            KVPair<String, Point> pair = point2.getFirst();
            points.add(pair);
        }

        if (point3.size() > 1) {
            // There is a duplicate!
            KVPair<String, Point> pair = point3.getFirst();
            points.add(pair);
        }

        return points;
    }
    
    /**
     * Returns the number of points in this node
     */
    public int numPoints() {
        return this.getPoints().size();
    }

// /**
// * Returns the LeafNode in a readable String format
// */
// @Override
// public String toString() {
// return String.format("", );
// }

    /**
     * NOTE: Should this be removed??
     * If we can safely assume we will never insert exact
     * copies, we can remove this.
     * 
     * Returns true if list contains exact copy
     * 
     * @param list
     *            List to check against
     * @param pair
     *            Pair to check
     * @return true if contained
     */
// public boolean listContainsExactCopy(LinkedList<KVPair<String, Point>> list,
// KVPair<String, Point> pair) {
// if (isEmptyList(list)) {
// return false;
// }
//
// String name = pair.getKey();
// Point pt = pair.getValue();
//
// for (KVPair<String, Point> item : list) {
// String name2 = item.getKey();
// Point pt2 = item.getValue();
// if (name.equals(name2) && pt.equals(pt2)) {
// return true;
// }
// }
//
// return false;
// }

}
