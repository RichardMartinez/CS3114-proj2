import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class is responsible for interfacing between the command processor and
 * the SkipList. The responsibility of this class is to further interpret
 * variations of commands and do some error checking of those commands. This
 * class further interpreting the command means that the two types of remove
 * will be overloaded methods for if we are removing by name or by coordinates.
 * Many of these methods will simply call the appropriate version of the
 * SkipList method after some preparation.
 * 
 * Also note that the Database class will have a clearer role in Project2,
 * where we will have two data structures.
 * The Database class will then determine
 * which command should be directed to which data structure.
 * 
 * @author CS Staff
 * 
 * @version 2024-01-22
 */
public class Database {

    private SkipList<String, Point> list;
    private PRQuadTree tree;
    
    // TODO: Output all results to standard out.

    /**
     * The constructor for this class initializes a SkipList object with String
     * and Rectangle a its parameters.
     */
    public Database() {
        list = new SkipList<String, Point>();
        tree = new PRQuadTree();
    }


    /**
     * Inserts the KVPair in the SkipList if the rectangle has valid coordinates
     * and dimensions, that is that the coordinates are non-negative and that
     * the rectangle object has some area (not 0, 0, 0, 0). This insert will
     * add the KVPair specified into the sorted SkipList appropriately
     * 
     * @param pair
     *            the KVPair to be inserted
     */
    public void insert(KVPair<String, Point> pair) {
        // Delegates the decision mostly to SkipList, only
        // writing the correct message to the console from
        // that
        
        // TODO: Check if pair is an EXACT match of another pair
        // already stored
        // Same name is OK, same coords is OK, BUT NOT BOTH

        list.insert(pair);
        tree.insert(pair);
    }


    /**
     * Removes a rectangle with the name "name" if available. If not an error
     * message is printed to the console.
     * 
     * @param name
     *            the name of the rectangle to be removed
     */
    public void remove(String name) {
        // Remove by name, SkipList efficient
        // Then remove from PRQuadTree by value

        KVPair<String, Point> pair = list.remove(name);
        if (pair == null) {
            // Not found
            return;
        }

        Point pt = pair.getValue();
        tree.remove(pt);
    }


    /**
     * Removes a point with the specified coordinates if available. If not
     * an error message is printed to the console.
     * 
     * @param x
     *            x-coordinate of the point to be removed
     * @param y
     *            y-coordinate of the point to be removed
     */
    public void remove(int x, int y) {
        // Remove by value, PRQuadTree efficient
        // Then remove from SkipList by name

        Point pt = new Point(x, y);
        KVPair<String, Point> pair = tree.remove(pt);
        if (pair == null) {
            // Not Found
            return;
        }

        String name = pair.getKey();
        list.remove(name);
    }


    /**
     * Displays all the rectangles inside the specified region. The rectangle
     * must have some area inside the area that is created by the region,
     * meaning, Rectangles that only touch a side or corner of the region
     * specified will not be said to be in the region.
     * 
     * @param x
     *            x-Coordinate of the region
     * @param y
     *            y-Coordinate of the region
     * @param w
     *            width of the region
     * @param h
     *            height of the region
     */
    public void regionsearch(int x, int y, int w, int h) {
        // Traverse PRQuadTree and report any points in the
        // given region

        tree.regionsearch(x, y, w, h);
    }


    /**
     * Report all points that have duplicate coordinates
     */
    public void duplicates() {
        // Traverse PRQuadTree and report any duplicates

        tree.duplicates();
    }


    /**
     * Prints out all the rectangles with the specified name in the SkipList.
     * This method will delegate the searching to the SkipList class completely.
     * 
     * @param name
     *            name of the Rectangle to be searched for
     */
    public void search(String name) {
        // Search using SkipList and print all points with
        // the same keys

        ArrayList<KVPair<String, Point>> found = list.search(name);
        if (found.size() == 0) {
            // Not found
            // Point not found: name
            String out = String.format("Point not found: %s", name);
            System.out.println(out);
            return;
        }
        
        // Iterate and print all
        for (KVPair<String, Point> pair : found) {
            String name1 = pair.getKey();
            Point pt = pair.getValue();
            String out = String.format("Found (%s, %s)", name1, pt);
            System.out.println(out);
        }

    }


    /**
     * Prints out a dump of the SkipList which includes information about the
     * size of the SkipList and shows all of the contents of the SkipList. This
     * will all be delegated to the SkipList.
     */
    public void dump() {
        list.dump();
        tree.dump();
    }

}
