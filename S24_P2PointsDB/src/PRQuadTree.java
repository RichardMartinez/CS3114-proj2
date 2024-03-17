import java.util.LinkedList;

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

    // Keep track for dump method
    private int numNodesPrinted = 0;

    // Keep track for regionsearch method
    private int numNodesVisited = 0;

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
        root = inserthelp(it, root, 512, 512, 1024);
    }


    /**
     * Recursive helper function for insert
     * 
     * @param it
     *            KVPair to be inserted
     * @param node
     *            Node to insert to
     * @param x
     *            X coordinate of center of current region
     * @param y
     *            Y coordinate of center of current region
     * @param s
     *            Side length of the current region
     * @return the quadnode of relevance
     */
    public QuadNode inserthelp(
        KVPair<String, Point> it,
        QuadNode node,
        int x,
        int y,
        int s) {
        // Base case for flyweight node
        if (isFlyweight(node)) {
            LeafNode leaf = new LeafNode();
            leaf.insert(it);
            node = leaf;
            return node;
        }

        if (node.canInsert(it)) {
            // Must be a leaf node with space available
            node.insert(it);
            return node;
        }

        // Is either an internal node or a leaf node that is full

        // Internal node -> traverse to correct child, call inserthelp(it,
        // child)
        // Full leaf node -> create new internal node and split into four new
        // leaf nodes
        // Add all points from old leaf into correct children
        // Delete old leaf node and rearrange pointers

        if (node.isLeaf()) {
            // It must be a full leaf node
            // We have to split!
            // Create new internal node to replace this one
            // Redistribute all current points to next flyweights
            // Change pointer to point to new internal node

            LeafNode leaf = (LeafNode)node;

            InternalNode internalNode = new InternalNode(flyweight, flyweight,
                flyweight, flyweight);

            // Iterate through points in this node and add them to the
            // corresponding next one
            LinkedList<KVPair<String, Point>> points = leaf.getPoints();
            for (KVPair<String, Point> pair : points) {
                Point pt = pair.getValue();

                String direction = pt.getDirection(x, y);
                // These are all flyweights at this point,
                // so x, y, s are ignored.
                // Remove calculations for better mutation testing
                if (direction.equals("nw")) {
                    QuadNode nw = internalNode.northwest();
                    // x - s/4
                    // y - s/4
                    // s/2
                    nw = inserthelp(pair, nw, x, y, s);
                    internalNode.setNorthwest(nw);
                }
                else if (direction.equals("ne")) {
                    QuadNode ne = internalNode.northeast();
                    ne = inserthelp(pair, ne, x, y, s);
                    internalNode.setNortheast(ne);
                }
                else if (direction.equals("sw")) {
                    QuadNode sw = internalNode.southwest();
                    sw = inserthelp(pair, sw, x, y, s);
                    internalNode.setSouthwest(sw);
                }
                else if (direction.equals("se")) {
                    QuadNode se = internalNode.southeast();
                    se = inserthelp(pair, se, x, y, s);
                    internalNode.setSoutheast(se);
                }
            }

            // Change the pointers
            node = internalNode;

            // Now all the points have been spread out, insert it
            node = inserthelp(it, node, x, y, s);
            // return node;
        }
        else {
            // It must be an internal node
            InternalNode internalNode = (InternalNode)node;
            Point pt = it.getValue();

            String direction = pt.getDirection(x, y);
            if (direction.equals("nw")) {
                QuadNode nw = internalNode.northwest();
                nw = inserthelp(it, nw, x - s / 4, y - s / 4, s / 2);
                internalNode.setNorthwest(nw);
            }
            else if (direction.equals("ne")) {
                QuadNode ne = internalNode.northeast();
                ne = inserthelp(it, ne, x + s / 4, y - s / 4, s / 2);
                internalNode.setNortheast(ne);
            }
            else if (direction.equals("sw")) {
                QuadNode sw = internalNode.southwest();
                sw = inserthelp(it, sw, x - s / 4, y + s / 4, s / 2);
                internalNode.setSouthwest(sw);
            }
            else if (direction.equals("se")) {
                QuadNode se = internalNode.southeast();
                se = inserthelp(it, se, x + s / 4, y + s / 4, s / 2);
                internalNode.setSoutheast(se);
            }

            // TODO: Does this stay here?
            node = internalNode;
        }

        return node;
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

        return removehelp(root, pt, 512, 512, 1024);
    }


    /**
     * Recursive helper for remove
     * 
     * @param node
     *            The node for recursion
     * @param pt
     *            Point to be removed
     * @param x
     *            x coordinate
     * @param y
     *            y coordinate
     * @param s
     *            side length
     * @return KVPair that was removed
     */
    public KVPair<String, Point> removehelp(
        QuadNode node,
        Point pt,
        int x,
        int y,
        int s) {

        if (isFlyweight(node)) {
            return null;
        }

        if (node.isLeaf()) {
            // Remove from the leaf node if it contains pt
            LeafNode leaf = (LeafNode)node;

            KVPair<String, Point> pair;

            if (leaf.containsPoint(pt)) {
                // Remove it
                pair = leaf.remove(pt);
            }
            else {
                pair = null;
            }

            // TODO: How to handle collapsing back down??
            // TODO: This should become flyweight if empty after remove
//            if (leaf.numPoints() == 0) {
//                // Needs to become flyweight
//                node = flyweight;
//                return pair;
//            }

            node = leaf;
            return pair;
        }

        // Internal Node
        // Traverse recursively
        // If any of the paths return non-null, return that value instead

        InternalNode internalNode = (InternalNode)node;

        KVPair<String, Point> pair;
        
        QuadNode nw = internalNode.northwest();
        QuadNode ne = internalNode.northeast();
        QuadNode sw = internalNode.southwest();
        QuadNode se = internalNode.southeast();

        String direction = pt.getDirection(x, y);
        if (direction.equals("nw")) {
            nw = internalNode.northwest();
            pair = removehelp(nw, pt, x - s / 4, y - s / 4, s / 2);
        }
        else if (direction.equals("ne")) {
            ne = internalNode.northeast();
            pair = removehelp(ne, pt, x + s / 4, y - s / 4, s / 2);
        }
        else if (direction.equals("sw")) {
            sw = internalNode.southwest();
            pair = removehelp(sw, pt, x - s / 4, y + s / 4, s / 2);
        }
        else if (direction.equals("se")) {
            se = internalNode.southeast();
            pair = removehelp(se, pt, x + s / 4, y + s / 4, s / 2);
        }
        else {
            // This will never run
            pair = null;
        }
        
        // TODO: Here check if we need to merge by checking each of the children
        // We need to merge if all children combined have 3 or less points
        // It is impossible for multiple children to share the same coordinates, so
        // we can safely ignore that requirement
        
        // Need num children method
        // Leaf nodes -> size of getPoints()
        // Internal Nodes -> recursively sum children
        
        //TODO: This won't work if there are too many duplicate points
        // The num points might be more than 3 but we still need to merge
//        int numPoints = internalNode.numPoints();
//        if (numPoints > 3) {
//            // No need to merge
//            node = internalNode;
//            return pair;
//        }
        
        // We need to merge here!!

        return pair;
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
        // Check if invalid rectangle
        if (w <= 0 || h <= 0) {
            String out = String.format("Rectangle rejected: (%d, %d, %d, %d)",
                x, y, w, h);
            System.out.println(out);
            return;
        }

        // Know valid rectangle
        String out = String.format(
            "Points intersecting region (%d, %d, %d, %d)", x, y, w, h);
        System.out.println(out);

        this.numNodesVisited = 0;
        regionsearchhelp(root, x, y, w, h, 512, 512, 1024);

        // Print num nodes visited
        out = String.format("%d quadtree nodes visited", this.numNodesVisited);
        System.out.println(out);
    }


    /**
     * Recursive helper for regionsearch
     * 
     * @param node
     *            The node for recursion
     * @param regionX
     *            x coordinate of the region
     * @param regionY
     *            y coordinate of the region
     * @param regionW
     *            width of the region
     * @param regionH
     *            height of the region
     * @param currX
     *            x coordinate for recursion
     * @param currY
     *            y coordinate for recursion
     * @param currS
     *            side length for recursion
     */
    public void regionsearchhelp(
        QuadNode node,
        int regionX,
        int regionY,
        int regionW,
        int regionH,
        int currX,
        int currY,
        int currS) {
        this.numNodesVisited++;

        if (isFlyweight(node)) {
            // Nothing
            return;
        }

        if (node.isLeaf()) {
            LeafNode leaf = (LeafNode)node;
            LinkedList<KVPair<String, Point>> points = leaf.getPoints();

            for (KVPair<String, Point> pair : points) {
                String name = pair.getKey();
                Point pt = pair.getValue();

                // Check point.intersects(region)
                if (pt.intersectsRegion(regionX, regionY, regionW, regionH)) {
                    // Print it
                    String out = String.format("Point found: (%s, %s)", name,
                        pt);
                    System.out.println(out);
                }
            }
            return;
        }

        // Internal Node
        InternalNode internalNode = (InternalNode)node;

        QuadNode nw = internalNode.northwest();
        QuadNode ne = internalNode.northeast();
        QuadNode sw = internalNode.southwest();
        QuadNode se = internalNode.southeast();

        // Recursively iterate
        // Check for region intersect before exploring that node

        int newX = 0;
        int newY = 0;
        int newS = currS / 2;

        // Northwest
        newX = currX - currS / 4;
        newY = currY - currS / 4;
        if (this.regionIntersectsCurr(regionX, regionY, regionW, regionH, newX,
            newY, newS)) {
            regionsearchhelp(nw, regionX, regionY, regionW, regionH, newX, newY,
                newS);
        }

        // Northeast
        newX = currX + currS / 4;
        newY = currY - currS / 4;
        if (this.regionIntersectsCurr(regionX, regionY, regionW, regionH, newX,
            newY, newS)) {
            regionsearchhelp(ne, regionX, regionY, regionW, regionH, newX, newY,
                newS);
        }

        // Southwest
        newX = currX - currS / 4;
        newY = currY + currS / 4;
        if (this.regionIntersectsCurr(regionX, regionY, regionW, regionH, newX,
            newY, newS)) {
            regionsearchhelp(sw, regionX, regionY, regionW, regionH, newX, newY,
                newS);
        }

        // Southeast
        newX = currX + currS / 4;
        newY = currY + currS / 4;
        if (this.regionIntersectsCurr(regionX, regionY, regionW, regionH, newX,
            newY, newS)) {
            regionsearchhelp(se, regionX, regionY, regionW, regionH, newX, newY,
                newS);
        }
    }


    /**
     * Traverses the tree and reports all points that have
     * duplicate coordinates. Outputs to standard out.
     */
    public void duplicates() {
        System.out.println("Duplicate points:");

        duplicateshelp(root);
    }


    /**
     * Recursive helper method for duplicates
     * 
     * @param node
     *            The node for recursion
     */
    public void duplicateshelp(QuadNode node) {
        if (isFlyweight(node)) {
            // Nothing
            return;
        }

        if (node.isLeaf()) {
            LeafNode leaf = (LeafNode)node;
            LinkedList<KVPair<String, Point>> points = leaf.getDuplicates();
            if (points.size() > 0) {
                // There is a duplicate!
                for (KVPair<String, Point> pair : points) {
                    // Print the point only
                    Point pt = pair.getValue();

                    String out = String.format("(%s)", pt);
                    System.out.println(out);
                }
            }

            return;
        }

        // Internal Node
        InternalNode internalNode = (InternalNode)node;

        QuadNode nw = internalNode.northwest();
        QuadNode ne = internalNode.northeast();
        QuadNode sw = internalNode.southwest();
        QuadNode se = internalNode.southeast();

        duplicateshelp(nw);
        duplicateshelp(ne);
        duplicateshelp(sw);
        duplicateshelp(se);

    }


    /**
     * Traverses the tree and outputs the structure to
     * standard out. Used to observe internal structure
     * of the tree at runtime.
     */
    public void dump() {
        this.numNodesPrinted = 0;

        System.out.println("QuadTree dump:");

        dumphelp(root, 512, 512, 1024, 0);

        String out = String.format("%d quadtree nodes printed",
            this.numNodesPrinted);
        System.out.println(out);
    }


    /**
     * Recursive helper method for dump
     * 
     * @param node
     *            The node for recursion
     * @param x
     *            x coordinate
     * @param y
     *            y coordinate
     * @param s
     *            side length
     * @param level
     *            current level of the tree
     */
    public void dumphelp(QuadNode node, int x, int y, int s, int level) {
        // Give indentation for each level
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }

        int printableX = x - s / 2;
        int printableY = y - s / 2;

        // Node at printableX, printableY, s: Internal
        // If internal, say internal
        // If leaf, print each point in the node
        // If empty/flyweight, say empty

        if (isFlyweight(node)) {
            // Print empty
            String out = String.format("Node at %d, %d, %d: Empty", printableX,
                printableY, s);
            System.out.println(out);
            this.numNodesPrinted++;
            return;
        }

        if (node.isLeaf()) {
            // Show leaf node
            String out = String.format("Node at %d, %d, %d:", printableX,
                printableY, s);
            System.out.println(out);
            this.numNodesPrinted++;

            // Print points
            LeafNode leaf = (LeafNode)node;
            LinkedList<KVPair<String, Point>> points = leaf.getPoints();
            for (KVPair<String, Point> pair : points) {
                String name = pair.getKey();
                Point pt = pair.getValue();

                // Reprint indentation
                for (int i = 0; i < level; i++) {
                    System.out.print("  ");
                }

                out = String.format("(%s, %s)", name, pt);
                System.out.println(out);
            }
            return;
        }

        // Here is an internal node
        // Call dumphelp recursively
        String out = String.format("Node at %d, %d, %d: Internal", printableX,
            printableY, s);
        System.out.println(out);
        this.numNodesPrinted++;

        InternalNode internalNode = (InternalNode)node;

        QuadNode nw = internalNode.northwest();
        QuadNode ne = internalNode.northeast();
        QuadNode sw = internalNode.southwest();
        QuadNode se = internalNode.southeast();

        dumphelp(nw, x - s / 4, y - s / 4, s / 2, level + 1);
        dumphelp(ne, x + s / 4, y - s / 4, s / 2, level + 1);
        dumphelp(sw, x - s / 4, y + s / 4, s / 2, level + 1);
        dumphelp(se, x + s / 4, y + s / 4, s / 2, level + 1);
    }


    /**
     * Returns true if the node is flyweight
     * 
     * @param node
     *            The node to check
     * 
     * @return true if node is flyweight
     */
    public boolean isFlyweight(QuadNode node) {
        return (node == flyweight);
    }


    /**
     * Returns true if the region intersections the current boundary
     * 
     * @param regionX
     *            x coordinate of the region
     * @param regionY
     *            y coordinate of the region
     * @param regionW
     *            width of the region
     * @param regionH
     *            height of the region
     * @param currX
     *            x coordinate for recursion
     * @param currY
     *            y coordinate for recursion
     * @param currS
     *            side length for recursion
     * @return true if intersects
     */
    public boolean regionIntersectsCurr(
        int regionX,
        int regionY,
        int regionW,
        int regionH,
        int currX,
        int currY,
        int currS) {
        int currLeft = currX - currS / 2;
        int currRight = currX + currS / 2;
        int currTop = currY - currS / 2;
        int currBottom = currY + currS / 2;

        int regionLeft = regionX;
        int regionRight = regionX + regionW;
        int regionTop = regionY;
        int regionBottom = regionY + regionH;

        // Psuedocode taken from Project 1

        // One is too far left
        if (currRight <= regionLeft) {
            return false;
        }

        if (regionRight <= currLeft) {
            return false;
        }

        // One if too far down
        if (regionBottom <= currTop) {
            return false;
        }

        return !(currBottom <= regionTop);
    }

}
