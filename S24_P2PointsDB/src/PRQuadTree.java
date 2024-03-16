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
        // TODO: Add parameters x, y, s (sidelength)
        root = inserthelp(it, root, 512, 512, 1024);
    }
    
    /**
     * Recursive helper function for insert
     * 
     * @param it
     *      KVPair to be inserted
     * @param node
     *      Node to insert to
     * @param x
     *      X coordinate of center of current region
     * @param y
     *      Y coordinate of center of current region
     * @param s
     *      Side length of the current region
     */
    public QuadNode inserthelp(KVPair<String, Point> it, QuadNode node, int x, int y, int s) {
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
        
        // Internal node -> traverse to correct child, call inserthelp(it, child)
        // Full leaf node -> create new internal node and split into four new leaf nodes
        //      Add all points from old leaf into correct children
        //      Delete old leaf node and rearrange pointers
        
        if (node.isLeaf()) {
            // It must be a full leaf node
            // We have to split!
            // Create new internal node to replace this one
            // Redistribute all current points to next flyweights
            // Change pointer to point to new internal node
            
            LeafNode leaf = (LeafNode) node;
            
            InternalNode internalNode = new InternalNode(flyweight, flyweight, flyweight, flyweight);
            
            // Iterate through points in this node and add them to the corresponding next one
            LinkedList<KVPair<String, Point>> points = leaf.getPoints();
            for (KVPair<String, Point> pair : points) {
                Point pt = pair.getValue();
                
                String direction = pt.getDirection(x, y);
                if (direction.equals("nw")) {
                    QuadNode nw = internalNode.northwest();
                    nw = inserthelp(pair, nw, x - s/4, y - s/4, s/2);
                    internalNode.setNorthwest(nw);
                }
                else if (direction.equals("ne")) {
                    QuadNode ne = internalNode.northeast();
                    ne = inserthelp(pair, ne, x + s/4, y - s/4, s/2);
                    internalNode.setNortheast(ne);
                }
                else if (direction.equals("sw")) {
                    QuadNode sw = internalNode.southwest();
                    sw = inserthelp(pair, sw, x - s/4, y + s/4, s/2);
                    internalNode.setSouthwest(sw);
                }
                else if (direction.equals("se")) {
                    QuadNode se = internalNode.southeast();
                    se = inserthelp(pair, se, x + s/4, y + s/4, s/2);
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
            InternalNode internalNode = (InternalNode) node;
            Point pt = it.getValue();
            
            String direction = pt.getDirection(x, y);
            if (direction.equals("nw")) {
                QuadNode nw = internalNode.northwest();
                nw = inserthelp(it, nw, x - s/4, y - s/4, s/2);
                internalNode.setNorthwest(nw);
            }
            else if (direction.equals("ne")) {
                QuadNode ne = internalNode.northeast();
                ne = inserthelp(it, ne, x + s/4, y - s/4, s/2);
                internalNode.setNortheast(ne);
            }
            else if (direction.equals("sw")) {
                QuadNode sw = internalNode.southwest();
                sw = inserthelp(it, sw, x - s/4, y + s/4, s/2);
                internalNode.setSouthwest(sw);
            }
            else if (direction.equals("se")) {
                QuadNode se = internalNode.southeast();
                se = inserthelp(it, se, x + s/4, y + s/4, s/2);
                internalNode.setSoutheast(se);
            }
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

        return null;
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
        this.numNodesPrinted = 0;
        
        System.out.println("QuadTree dump:");
        
        dumphelp(root, 512, 512, 1024, 0);

        String out = String.format("%d quadtree nodes printed", this.numNodesPrinted);
        System.out.println(out);
    }
    
    /**
     * Recursive helper method for dump
     * @param node
     */
    public void dumphelp(QuadNode node, int x, int y, int s, int level) {
        // Give indentation for each level
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        
        int printableX = x - s/2;
        int printableY = y - s/2;
        
        // Node at printableX, printableY, s: Internal
        // If internal, say internal
        // If leaf, print each point in the node
        // If empty/flyweight, say empty
        
        if (isFlyweight(node)) {
            // Print empty
            String out = String.format("Node at %d, %d, %d: Empty",
                printableX, printableY, s);
            System.out.println(out);
            this.numNodesPrinted++;
            return;
        }
        
        if (node.isLeaf()) {
            // Show leaf node
            String out = String.format("Node at %d, %d, %d:",
                printableX, printableY, s);
            System.out.println(out);
            this.numNodesPrinted++;
            
            // Print points
            LeafNode leaf = (LeafNode) node;
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
        String out = String.format("Node at %d, %d, %d: Internal",
            printableX, printableY, s);
        System.out.println(out);
        this.numNodesPrinted++;
        
        InternalNode internalNode = (InternalNode) node;
        
        QuadNode nw = internalNode.northwest();
        QuadNode ne = internalNode.northeast();
        QuadNode sw = internalNode.southwest();
        QuadNode se = internalNode.southeast();
        
        dumphelp(nw, x - s/4, y - s/4, s/2, level+1);
        dumphelp(ne, x + s/4, y - s/4, s/2, level+1);
        dumphelp(sw, x - s/4, y + s/4, s/2, level+1);
        dumphelp(se, x + s/4, y + s/4, s/2, level+1);
    }
    
    /**
     * Returns true if the node is flyweight
     * @return true if node is flyweight
     */
    public boolean isFlyweight(QuadNode node) {
        return (node == flyweight);
    }
    
    // TODO: Number of leaf nodes method? size()
}
